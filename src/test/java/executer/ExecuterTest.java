package executer;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.lowagie.text.DocumentException;

import model.Agent;
import persistence.UserFinder;
import persistence.util.Jpa;

public class ExecuterTest {

	@Test
	public void testActionSingleton() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		ActionSingleton aS2 = ActionSingleton.getInstance();
		
		assertEquals(aS, aS2);
		
		Agent user = new Agent("Paco Francisco", "francisco@gmail.com", "40°38′31″N 4°09′19″O", 1, "87654321P");
		
		aS.getActionFacade().saveData(user);
		
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		Agent user2 = UserFinder.findByID("francisco@gmail.com").get(0);
		
		assertEquals(user, user2);
		
		trx.commit();
		
	}

}
