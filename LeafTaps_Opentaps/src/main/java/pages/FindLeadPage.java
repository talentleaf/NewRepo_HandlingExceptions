package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrappers.LeafTapWrappers;

public class FindLeadPage extends LeafTapWrappers {
	
	public FindLeadPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if(!verifyTitle("Find Leads | opentaps CRM"))
		logSteps("fail", "User doesnt land on correct find leads page");
	}
	
	public FindLeadPage typeFirstName(String data)
	{
		enterByXpath("(//input[@name='firstName'])[3]", data);
		return this;
	}
	
	public FindLeadPage clickFindLeadButton()
	{
		clickByXpath("//button[text()='Find Leads']");
		return this;
	}
	
	public ViewLeadPage clickonSearchedLead()
	{
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		return new ViewLeadPage(driver,et);
	}
	
}
