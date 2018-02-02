package parser;

import java.io.FileNotFoundException;

import com.lowagie.text.DocumentException;

public interface ReadList {
	public void load(String path) throws FileNotFoundException, DocumentException;
}
