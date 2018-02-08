package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import dbupdate.Insert;
import dbupdate.InsertAgent;
import model.Agent;



/**
 * 
 *  Clase que implementa la interfaz {@link executer.ActionFacade}
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 */
public class ActionFacadeClass implements ActionFacade {
	
	/* (non-Javadoc)
	 * @see executer.ActionFacadeClass#saveData
	 */
	@Override
	public void saveData(Agent agent) throws FileNotFoundException, DocumentException, IOException {
		Insert insert = new InsertAgent();
		insert.save(agent);
	}
}