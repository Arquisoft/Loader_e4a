package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.Agent;
import persistence.UserFinder;

public class InsertReader implements Insert {

	@Override
	public Agent save(Agent user) throws FileNotFoundException, DocumentException, IOException {
		return new InsertP().save(user);
	}

	@Override
	public List<Agent> findByDNI(String dni) {
		return UserFinder.findByID(dni);
	}

	@Override
	public List<Agent> findByEmail(String email) {
		return UserFinder.findByID(email);
	}
}
