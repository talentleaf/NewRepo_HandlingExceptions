package sampleReports;

import java.io.File;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProjectReports {

	@Test
	public void projectReports()
	{
	ExtentReports reports=new ExtentReports("./Reports/FirstReport.html",false);
	
	File f=new File("./Configuration.xml");
	
	reports.loadConfig(f);
	
	ExtentTest et=reports.startTest("CreateLead", "Lead successfully created");
	
	et.assignAuthor("authorNamekarkeernimi");
	et.assignCategory("Sanity");
	et.log(LogStatus.PASS, "Filled Manadatory fields successfully");
	et.log(LogStatus.PASS, "Filled non Manadatory fields successfully");
	et.log(LogStatus.FAIL, "Dropdown has been selected successfully");
	et.log(LogStatus.SKIP, "Create lead button is clicked");
		
	reports.endTest(et);
	reports.flush();
	//ExtentTest
	}
	
}
