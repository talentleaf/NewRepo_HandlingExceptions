package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MergeLeadsPage extends LeafTapWrappers{
	public String fromLeadId;

	public MergeLeadsPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("Merge Leads | opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at My Lead page");
		}	
	}	
	public FindLeadLookUpPage clickFromLeadLookUpicon()
	{
		clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		return new FindLeadLookUpPage(driver,et);	
	}
	
	public FindLeadLookUpPage clickToLeadLookUpicon()
	{
		clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		return new FindLeadLookUpPage(driver,et);
	}
	
	public MergeLeadsPage getTextFromLead()
	{
		fromLeadId=driver.findElementByXPath("//input[@name='ComboBox_partyIdFrom']").getAttribute("valuenow");
		return new MergeLeadsPage(driver,et);
	}
	
	public void clickMergeButton()
	{
		clickByLinkNoSnap("Merge");
		acceptAlert();
	}
	
	
}
