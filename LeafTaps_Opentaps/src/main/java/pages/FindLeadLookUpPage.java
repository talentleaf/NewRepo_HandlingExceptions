package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrappers.LeafTapWrappers;

public class FindLeadLookUpPage extends LeafTapWrappers {
	
	public FindLeadLookUpPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if(!verifyTitle("Find Leads"))
		logSteps("fail", "User doesnt land on correct find leads page");
	}
	
	public FindLeadLookUpPage typeFirstName(String data)
	{
		enterByXpath("//input[@name='firstName']", data);
		return this;
	}
	
	public FindLeadLookUpPage clickFindLeadButton()
	{
		clickByXpath("//button[text()='Find Leads']");
		return this;
	}
	
	public MergeLeadsPage clickonSearchedLead(int n)
	{
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)["+n+"]");
		switchToParentWindow();
		return new MergeLeadsPage(driver,et);
	}
	
}
