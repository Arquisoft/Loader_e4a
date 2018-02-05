package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Test;

import com.lowagie.text.DocumentException;

import executer.ActionSingleton;
import model.User;
import persistence.UserFinder;
import persistence.util.Jpa;

public class DbTest {

	@Test
	public void usuarioYaExistenteDni() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		Date date = new Date(System.currentTimeMillis());
		User user1 = new User("Paco", "Francisco", "francisco@gmail.com", date, "C\\Uría", "Español", "87654321P");
		User user2 = new User("Paco", "Francisco", "franci@gmail.com", date, "C\\Uría", "Español", "87654321P");

		aS.getActionFacade().saveData(user1);
		aS.getActionFacade().saveData(user2);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByDNI("87654321P");
		assertEquals(test.get(0).getEmail(), "francisco@gmail.com");

		trx.commit();
		mapper.close();
	}

	@Test
	public void usuarioYaExistenteEmail() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		Date date = new Date(System.currentTimeMillis());
		User user1 = new User("Paco", "Francisco", "francisco@gmail.com", date, "C\\Uría", "Español", "87654321P");
		User user3 = new User("Paco", "Francisco", "francisco@gmail.com", date, "C\\Uría", "Español", "87654353Y");

		aS.getActionFacade().saveData(user1);
		aS.getActionFacade().saveData(user3);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByEmail("francisco@gmail.com");
		assertEquals(test.get(0).getDNI(), "87654321P");

		trx.commit();
		mapper.close();

	}

	@After
	public void deleting() {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> aBorrar = UserFinder.findByDNI("87654321P");
		Jpa.getManager().remove(aBorrar.get(0));
		trx.commit();
		mapper.close();
	}

}
