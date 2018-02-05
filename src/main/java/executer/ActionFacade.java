package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.Agent;

public interface ActionFacade {
	public void saveData(User user) throws FileNotFoundException, DocumentException, IOException;
}