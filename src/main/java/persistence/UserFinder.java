package persistence;

import java.util.List;
import model.Agent;
import persistence.util.Jpa;

public class UserFinder {

	public static List<Agent> findByID(String id) {
		return Jpa.getManager()
				.createNamedQuery("Agent.findByID", Agent.class)
				.setParameter(1, id)
				.getResultList();
	}

	public static List<Agent> findByUsername(String username) {
		return Jpa.getManager()
				.createNamedQuery("Agent.findByUsername", Agent.class)
				.setParameter(1, username)
				.getResultList();
	}
}
