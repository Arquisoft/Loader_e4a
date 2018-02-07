package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import reportwriter.ReportWriter;

public class ReaderSingleton {
	private static ReaderSingleton instance;
	private ReadList loader;
	private static HashMap<String, Integer> mapa = new HashMap<String,Integer>();

	private ReaderSingleton() {
		this.loader = new ReadListExcel();
	}
	
	public static ReaderSingleton getInstance(String path) {
		if(mapa.isEmpty()) {
			leerCSV(path);
			return getInstance();
		}
		return getInstance();
	}

	public static ReaderSingleton getInstance() {
		if (instance == null)
			instance = new ReaderSingleton();
		return instance;
	}

	public void loadFile(String path) throws DocumentException {
		try{
			loader.load(path);
		}catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo excel");
		}
	}
	
	public static void leerCSV(String path) {
		BufferedReader br = null;
	      
	      try {
	         
	         br =new BufferedReader(new FileReader(path));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(",");
	            mapa.put(fields[1], Integer.parseInt(fields[0]));
	            line = br.readLine();
	         }
	      } catch (IOException ioe) {
				System.err.println("Problema con la lectura del CSV");
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"Problema con la lectura del CSV");
	      }finally {
	    	  if(br!=null) {
	    			  try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    	  }
	      }
	}
	
	public HashMap<String,Integer> getMapa(){
		return new HashMap<String, Integer>(mapa);
	}
}
