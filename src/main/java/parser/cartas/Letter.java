package parser.cartas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.Agent;

/**
 * Interfaz que especifica como han de ser las factorias para crear cartas para informar a los agentes
 * 
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 *
 */
public interface  Letter {
	
	/**
	 * Crea la carta a partir de la informacion de un agente.
	 * @param agent, el agente a informar
	 * 
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public  void createLetter(Agent agent) throws DocumentException, FileNotFoundException, IOException;
}
