package parser;

import java.io.FileNotFoundException;

import com.lowagie.text.DocumentException;

/**
 * Interfaz para especificar lo que ha realizar un parser para importar información al sistema
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 *
 */
public interface ReadList {
	
	/**
	 * Lee los datos del fichero
	 * @param pathFichero Path hasta el fichero que se quiera leer
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void load(String pathFichero) throws FileNotFoundException, DocumentException;
}
