package persistence;

import java.util.List;
import model.Agent;
import persistence.util.Jpa;

/**
 * Clase que permite obtener información de la base de datos relacionada con los agentes
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 *
 */
public class AgentFinder {
	
	/**
	 * Obtiene información de un agente a partir de su id
	 * @param id id del agente
	 * @return Lista con los agentes que tienen ese id
	 */
	public static List<Agent> findByID(String id) {
		return Jpa.getManager()
				.createNamedQuery("Agent.findByID", Agent.class)
				.setParameter(1, id)
				.getResultList();
	}

	/**
	 * Obtiene información del agente a partir de nombre de usuario
	 * @param username
	 * @return Lista con los agentes que tienen ese nombre de usuario
	 */
	public static List<Agent> findByUsername(String username) {
		return Jpa.getManager()
				.createNamedQuery("Agent.findByUsername", Agent.class)
				.setParameter(1, username)
				.getResultList();
	}
}
