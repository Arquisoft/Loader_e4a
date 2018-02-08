package parser.cartas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import model.Agent;

/**
 *  Clase que implementa la interfaz {@link executer.ActionFacade} 
 *  Proporcionando cartas en formato PDF
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 *
 */
public class PdfLetter implements Letter{
	private Document document;
	
	/* (non-Javadoc)
	 * @see parser.cartas.Letter#createLetter
	 */
	public  void createLetter(Agent user) throws DocumentException, FileNotFoundException{
		document = null;
		FileOutputStream letter = null;
		letter = new FileOutputStream(
				"cartas/pdf/" + user.getID() + ".pdf");
		document = new Document();
		PdfWriter.getInstance(document, letter);
		document.open();
		document.add(new Paragraph("Usuario: " + user.getUsername()
				+ "\n Password: " + user.getPassword()));
		document.close();
	}
}
