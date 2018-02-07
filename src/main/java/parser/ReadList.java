package parser;

import java.io.FileNotFoundException;

import com.lowagie.text.DocumentException;

public interface ReadList {
	public void load(String pathExcel) throws FileNotFoundException, DocumentException;
}
