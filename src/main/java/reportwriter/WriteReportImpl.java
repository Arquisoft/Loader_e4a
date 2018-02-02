package reportwriter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteReportImpl implements WriteReport {

	private Logger logger = Logger.getLogger("Logger");
	
	@Override
	public void log(Level lv, String msg) {
		logger.log(lv, msg);
	}

	public Logger getLogger(){
		return logger;
	}
}
