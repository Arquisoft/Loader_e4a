package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.Agent;
import persistence.AgentFinder;

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
public class InsertReader implements Insert {

	/* (non-Javadoc)
	 * @see dbupdate.Insert#save
	 */
	@Override
	public Agent save(Agent user) throws FileNotFoundException, DocumentException, IOException {
		return new InsertAgent().save(user);
	}

	/* (non-Javadoc)
	 * @see dbupdate.Insert#findByDNI
	 */
	@Override
	public List<Agent> findByDNI(String dni) {
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
