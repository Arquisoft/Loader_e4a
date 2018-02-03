package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.Agent;

public interface ActionFacade {
	public void saveData(Agent user) throws FileNotFoundException, DocumentException, IOException;
	// public void verifySecurity();  Esto es una ampliacion opcional y no se en que consiste
}