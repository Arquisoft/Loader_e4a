package reportwriter;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase que implementa la interfaz {@link reportwriter.WriteReport}
 * @author Antonio Payá González(UO251065)
 * @author Pablo Amorin Triana (UO237060)
 * @author Hugo Perez Fernandez (UO250708)
 * @author Ivan Casielles Alvarez (UO251063)
 * @author Mirza Ojeda Vieira (UO251443)
 * 
 *
 */
public class WriteReportImpl implements WriteReport {

	private Logger logger = Logger.getLogger("Logger");
	/*
	 * (non-Javadoc)
	 * @see reportwriter.WriteReport#log(java.util.logging.Level, java.lang.String)
	 */
	@Override
	public void log(Level lv, String msg) {
		logger.log(lv, msg);
	}
	
	/**
	 * Obtiene una instancia del logger única.
	 * @return Instancia del Logger
	 */
	public Logger getLogger(){
		return logger;
	}
}
