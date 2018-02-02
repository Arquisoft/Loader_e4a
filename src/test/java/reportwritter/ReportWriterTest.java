package reportwritter;

import static org.junit.Assert.*;

import org.junit.Test;

import reportwriter.ReportWriter;

public class ReportWriterTest {

	@Test
	public void test() {
		ReportWriter rp1 = ReportWriter.getInstance();
		ReportWriter rp2 = ReportWriter.getInstance();
		
		assertEquals(true, rp1.equals(rp2));
		assertEquals(true, rp1.getWriteReport().equals(rp2.getWriteReport()));
	}

}