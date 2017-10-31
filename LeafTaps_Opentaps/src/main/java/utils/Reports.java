package utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {

	static ExtentReports reports;
	public ExtentTest et;

	public void createReport()
	{
		reports=new ExtentReports("./Reports/FirstReport.html",false);
		File f=new File("./Configuration.xml");
		reports.loadConfig(f);
	}

	public void createTestcaseReport(String testcaseName, String desc, String authorName, String category)
	{
		et=reports.startTest(testcaseName, desc);
		et.assignAuthor(authorName);
		et.assignCategory(category);
	}
	public void logSteps(String status, String desc)
	{
		if(status.equalsIgnoreCase("pass"))
		{
			et.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("fail"))
		{
			et.log(LogStatus.FAIL, desc);
			throw new RuntimeException();
		}
		else if(status.equalsIgnoreCase("warning"))
		{
			et.log(LogStatus.WARNING, desc);	
		}
		else if(status.equalsIgnoreCase("skip"))
		{
			et.log(LogStatus.SKIP,desc);	
		}
		else if(status.equalsIgnoreCase("fatal"))
		{
			et.log(LogStatus.FATAL,desc);	
		}
		else if(status.equalsIgnoreCase("unknown"))
		{
			et.log(LogStatus.UNKNOWN,desc);	
		}
	}
	public void closeTestcaseReport()
	{
		reports.endTest(et);
	}
	public void saveReport()
	{
		reports.flush();
	}
}
