package reportwriter;

public class ReportWriter {
	private static ReportWriter instance;
	private WriteReport wR = new WriteReportImpl();
	
	private ReportWriter() {
	}
	
	public static ReportWriter getInstance() {
		if(instance == null) instance = new ReportWriter();
		return instance;
	}
	
	public WriteReport getWriteReport() {
		return wR;
	}
	
	
}
