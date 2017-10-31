package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MyLeadsPage extends LeafTapWrappers{

	public MyLeadsPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("My Leads | opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at My Lead page");
		}	
	}	
	public CreateLeadPage clickCreateLeadTab()
	{
		clickByLink("Create Lead");
		return new CreateLeadPage(driver,et);
	}
	public FindLeadPage clickFindLeadTab()
	{
		clickByLink("Find Leads");
		return new FindLeadPage(driver,et);
	}
	
	public MergeLeadsPage clickMergeLeadsTab()
	{
		clickByLink("Merge Leads");
		return new MergeLeadsPage(driver,et);
	}
}
