package parser.cartas;

/**
 * Factoria que permite acceder a los diferentes constructores de cartas 
 * 
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 *
 *
 */
public class LetterFactory {
	/**
	 * Metodo que da acceso a la factoria
	 * @param format Formato de la carta que queremos crear. Podrá ser "pdf", "word" o "txt". El formato por defecto es word
	 * @return Un creador de cartas en el formato escogido
	 */
	public static Letter createLetter(String format) {
		if ("txt".equals(format)) {
			return (Letter) new TxtLetter();
		} else if ("pdf".equals(format)) {
			return (Letter) new PdfLetter();
		} else if ("word".equals(format)) {
			return (Letter) new WordLetter();
		} else {
			return (Letter) new WordLetter();
		}
	}
}
