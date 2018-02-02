package parser.cartas;

public class LetterFactory {
	
	public static Letter createLetter(String format){
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
