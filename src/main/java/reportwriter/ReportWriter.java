package reportwriter;

/**
 * Singleton que permite acceder al logger de la aplicación
 * 
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 *
 */
public class ReportWriter {
	private static ReportWriter instance;
	private WriteReport wR = new WriteReportImpl();
	
	private ReportWriter() {
	}
	
	/**
	 * Obtiene una instancia del ReportWriter
	 * @return Instancia única de ReportWriter
	 */
	public static ReportWriter getInstance() {
		if(instance == null) instance = new ReportWriter();
		return instance;
	}
	
	/**
	 * Obtiene el logger
	 * @return Logger
	 */
	public WriteReport getWriteReport() {
		return wR;
	}
	
	
}
