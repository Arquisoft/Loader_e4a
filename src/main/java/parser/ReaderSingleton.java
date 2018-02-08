package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import reportwriter.ReportWriter;

/**
 * Patron singleton que permite acceder a las clases de lectura de datos
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443) 
 *
 */
public class ReaderSingleton {
	private static ReaderSingleton instance;
	private ReadList loader;
	private static HashMap<String, Integer> mapa = new HashMap<String, Integer>();

	private ReaderSingleton() {
		this.loader = new ReadListExcel();
	}
	
	/**
	 * Obtiene una instancia del lector. 
	 * @param path del fichero maestro CSV con los datos de los tipos de agente
	 * @return Instancia de ReaderSingleton
	 */
	public static ReaderSingleton getInstance(String path) {
		if (mapa.isEmpty()) {
			leerCSV(path);
			return getInstance();
		}
		return getInstance();
	}
	/**
	 * Obtiene una instancia del lector. No inicializa los datos del fichero maestro 
	 * @return Instancia de ReaderSingleton
	 */
	public static ReaderSingleton getInstance() {
		if (instance == null)
			instance = new ReaderSingleton();
		return instance;
	}
	
	/**
	 * Lee los datos del fichero con los datos de los agentes
	 * @param path Path del fichero a leer
	 * @throws DocumentException
	 */
	public void loadFile(String path) throws DocumentException {
		try {
			loader.load(path);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo excel");
		}
	}

	/**
	 * Lee los datos del fichero maestro
	 * @param path Path al fichero maestro en formato CSV
	 */
	public static void leerCSV(String path) {
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (null != line) {
				String[] fields = line.split(",");
				mapa.put(fields[1], Integer.parseInt(fields[0]));
				line = br.readLine();
			}
		} catch (IOException ioe) {
			System.err.println("Problema con la lectura del CSV");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Problema con la lectura del CSV");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Obtiene una copia del mapa con los datos obtenidos del fichero maestro
	 * @return Copia del mapa 
	 */
	public HashMap<String, Integer> getMapa() {
		return new HashMap<String, Integer>(mapa);
	}
}
