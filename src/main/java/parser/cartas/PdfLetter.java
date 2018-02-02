package parser.cartas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import model.User;

public class PdfLetter extends Letter{
	private Document document;
	public  void createLetter(User user) throws DocumentException, FileNotFoundException{
		document = null;
		FileOutputStream letter = null;
		letter = new FileOutputStream(
				"cartas/pdf/" + user.getDNI() + ".pdf");
		document = new Document();
		PdfWriter.getInstance(document, letter);
		document.open();
		document.add(new Paragraph("Usuario: " + user.getUsername()
				+ "\n Password: " + user.getPassword()));
		document.close();
	}
}
