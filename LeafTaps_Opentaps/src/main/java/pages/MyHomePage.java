package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MyHomePage extends LeafTapWrappers {

	public MyHomePage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("My Home | opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at My Home page");
		}	
	}	
	public MyLeadsPage clickLeadsTab()
	{
		clickByLink("Leads");
		return new MyLeadsPage(driver,et);
	}

}
