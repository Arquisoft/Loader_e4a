package parser.cartas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import model.Agent;

public class TxtLetter extends Letter{
	private Writer writer;

	public void createLetter(Agent user) throws IOException{
		File letter = new File("cartas/txt/" + user.getNIF() + ".txt");
		writer = new FileWriter(letter);
		writer.write("Usuario: " + user.getUsername() + "\n" + "Password: "
				+ user.getPassword());
	}
}
