package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.Agent;
/**
 * 
 *  Interfaz que proporciona una fachada para poder acceder a los servicios de la base de datos
 *  desde la capa de lógica. 	
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 */
public interface ActionFacade {
	
	/**
	 * Permite acceder al método save de {@link dbupdate.Insert}
	 * @param agent, el agente a guardar
	 * @throws FileNotFoundException 
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void saveData(Agent agent) throws FileNotFoundException, DocumentException, IOException;
}