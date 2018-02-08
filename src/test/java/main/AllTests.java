package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dbupdate.DbTest;
import executer.ExecuterTest;
import modeltest.UserTest;
import parsertest.LetterTest;
import parsertest.ParserTest;
import reportwritter.ReportWriterTest;
import reportwritter.WriteReportImplTest;

@RunWith(Suite.class)
@SuiteClasses({DbTest.class, ExecuterTest.class, UserTest.class, LetterTest.class, ParserTest.class, ReportWriterTest.class, WriteReportImplTest.class })
public class AllTests {

}
