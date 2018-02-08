package reportwriter;

import java.util.logging.Level;


/**
 * Interfaz que proporciona las funcionalidades de loggin de la aplicación
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443) 
 *
 */
public interface WriteReport {
	/**
	 * Escribe un mensaje de log del nivel designado
	 * @param lv Nivel del mensaje {@link java.util.loggin.Level}
	 * @param msg Mensaje a escribir
	 */
	void log(Level lv, String msg);
	
}
