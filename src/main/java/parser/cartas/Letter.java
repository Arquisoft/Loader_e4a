package parser.cartas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.User;

public abstract class Letter {
		public abstract void createLetter(User user) throws DocumentException, FileNotFoundException, IOException;
}
