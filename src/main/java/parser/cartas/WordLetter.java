package parser.cartas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import model.Agent;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.lowagie.text.DocumentException;
/**
 *  Clase que implementa la interfaz {@link executer.ActionFacade} 
 *  Proporcionando cartas en formato Word
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 *
 */
public class WordLetter implements Letter{
	private FileOutputStream carta;
	/* (non-Javadoc)
	 * @see parser.cartas.Letter#createLetter
	 */
	public void createLetter(Agent user) throws FileNotFoundException, DocumentException, IOException {
		XWPFDocument documento = new XWPFDocument();
		File folder = new File("carta/word");
		folder.mkdir();
		carta = new FileOutputStream(
				"cartas/word/" + user.getID() + ".docx");
		XWPFParagraph paragraph = documento.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText("Usuario: " + user.getUsername());
		run.addBreak();
		run.setText("Password: " + user.getPassword());
		documento.write(carta);
		documento.close();
		carta.close();
	}
}
