package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.lowagie.text.DocumentException;

import model.Agent;
import parser.cartas.Letter;
import parser.cartas.PdfLetter;
import parser.cartas.TxtLetter;
import parser.cartas.WordLetter;
import persistence.AgentFinder;
import persistence.util.Jpa;
import reportwriter.ReportWriter;

/**
 * 
 *  Clase que implementa la interfaz {@link dbupdate.Insert}
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 */
public class InsertAgent implements Insert {

	/* (non-Javadoc)
	 * @see dbupdate.Insert#save
	 */
	@Override
	public Agent save(Agent agent) throws FileNotFoundException, DocumentException, IOException {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		try {
			if (!AgentFinder.findByID(agent.getID()).isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"El agente con el dni " + agent.getID() + " ya existe en la base de datos");
				trx.rollback();
			} else if (!AgentFinder.findByID(agent.getEmail()).isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"Ya existe un agente con el email " + agent.getEmail() + " en la base de datos");
				trx.rollback();
			} else {
				Jpa.getManager().persist(agent);
				trx.commit();
				Letter letter = new PdfLetter();
				letter.createLetter(agent);
				letter = new TxtLetter();
				letter.createLetter(agent);
				letter = new WordLetter();
				letter.createLetter(agent);
			}
		} catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return agent;
	}

	/* (non-Javadoc)
	 * @see dbupdate.Insert#findByDNI
	 */
	@Override
	public List<Agent> findByID(String dni) {
		return AgentFinder.findByID(dni);
	}

	/* (non-Javadoc)
	 * @see dbupdate.Insert#findByEmail
	 */
	@Override
	public List<Agent> findByEmail(String email) {
		return AgentFinder.findByID(email);
	}
	
	
}
