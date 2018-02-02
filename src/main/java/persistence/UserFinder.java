package persistence;

import java.util.List;
import model.User;
import persistence.util.Jpa;

public class UserFinder {

	public static List<User> findByDNI(String dni) {
		return Jpa.getManager().createNamedQuery("User.findByDni", User.class).
				setParameter(1, dni).getResultList();
	}

	public static List<User> findByEmail(String email) {
		return Jpa.getManager().createNamedQuery("User.findByEmail", User.class).
				setParameter(1, email).getResultList();
	}
}
