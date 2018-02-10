package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.Agent;

/**
 * 
 * 	Interfaz que estiona la conexión con la base de datos
 * 
 *  Autor original:
 *  @author Ignacio Escribano Burgos
 * 
 *  Modificado por:
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 *
 */
public interface Insert {
	/**
	 * Guarda un agente en la Base de datos
	 * 
	 * @param agent, El agente a guardar en la base de datos
	 * @return Agent
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
	 */
	Agent save(Agent agent) throws FileNotFoundException, DocumentException, IOException;

	/**
	 * Devuelve una lista de Agentes con dni igual al introducido por parametro
	 * @param ID, ID del/los agentes a buscar
	 * @return List<Agent>, lista de agentes
	 */
	List<Agent> findByID(String id);

	/**
	 * Devuelve una lista de Agentes con email igual al introducido por parametro
	 * @param email, Email del/los agentes a buscar
	 * @return List<Agent>, lista de agentes
	 */
	List<Agent> findByEmail(String email);
}
