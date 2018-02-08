package parser.cartas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import model.Agent;
/**
 *  Clase que implementa la interfaz {@link executer.ActionFacade} 
 *  Proporcionando cartas en formato de texto plano
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 *
 */
public class TxtLetter implements Letter{
	private Writer writer;
	/* (non-Javadoc)
	 * @see parser.cartas.Letter#createLetter
	 */
	public void createLetter(Agent user) throws IOException{
		File letter = new File("cartas/txt/" + user.getID() + ".txt");
		writer = new FileWriter(letter);
		writer.write("Usuario: " + user.getUsername() + "\n" + "Password: "
				+ user.getPassword());
	}
}
