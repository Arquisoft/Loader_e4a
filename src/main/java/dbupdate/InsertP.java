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
import persistence.UserFinder;
import persistence.util.Jpa;
import reportwriter.ReportWriter;

public class InsertP implements Insert {

	@Override
	public Agent save(Agent user) throws FileNotFoundException, DocumentException, IOException {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		try {
			if (!UserFinder.findByID(user.getID()).isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"El usuario con el dni " + user.getID() + " ya existe en la base de datos");
				trx.rollback();
			} else if (!UserFinder.findByID(user.getEmail()).isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"Ya existe un usuario con el email " + user.getEmail() + " en la base de datos");
				trx.rollback();
			} else {
				Jpa.getManager().persist(user);
				trx.commit();
				Letter letter = new PdfLetter();
				letter.createLetter(user);
				letter = new TxtLetter();
				letter.createLetter(user);
				letter = new WordLetter();
				letter.createLetter(user);
			}
		} catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return user;
	}

	@Override
	public List<Agent> findByDNI(String dni) {
		return UserFinder.findByID(dni);
	}

	@Override
	public List<Agent> findByEmail(String email) {
		return UserFinder.findByID(email);
	}
}
