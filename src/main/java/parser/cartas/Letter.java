package parser.cartas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.Agent;

public abstract class Letter {
		public abstract void createLetter(Agent user) throws DocumentException, FileNotFoundException, IOException;
}
