package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Agent;

public class UserTest {

	@Test
	public void testEquals() {
		Agent user1 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7777777R");
		Agent user2 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7777777R");
		Agent user3 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7787777R");
		Agent user4 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, null);
		//TODO: lo anterior no tiene sentido hay que controlar que no pueda ser null
		assertTrue(user1.equals(user2));
		assertTrue(user3.equals(user3));
		assertFalse(user2.equals(user3));
		assertNotNull(user1);
		assertFalse(user4.equals(user3));
	}

	@Test
	public void testHashCode() {
		Agent user1 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7777777R");
		Agent user2 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7777777R");
		Agent user3 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7778777R");
		Agent user4 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, null);
		Agent user5 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, null);

		assertEquals(user1.hashCode(), user2.hashCode());
		assertEquals(user4.hashCode(), user5.hashCode());
		assertNotEquals(user2.hashCode(), user3.hashCode());

		System.out.println(user1.toString());
	}

	@Test
	public void testAll() {
		Agent user1 = new Agent("Dani Duque", "email@gmail.com", "43.542467N -5.6690830", 1, "7777777R");

		String password = user1.getPassword();
		String userName = user1.getUsername();
		String toString = "Agent [nombre=Dani Duque, email=email@gmail.com, localizacion=43.542467N -5.6690830, nif=7777777R, type=1]";
		

		assertEquals("Dani Duque", user1.getNombre());
		assertEquals("email@gmail.com", user1.getEmail());
		assertEquals("43.542467N -5.6690830", user1.getLocalizacion());
		assertEquals(1, user1.getType());
		assertEquals("7777777R", user1.getNIF());
		assertEquals(password, user1.getPassword());
		assertEquals(userName, user1.getUsername());
		assertEquals(toString, user1.toString());
	}

}
