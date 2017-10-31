package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class EditPage extends LeafTapWrappers{

	public EditPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at Edit Lead page");
		}	
	}		
	public EditPage changeCompanyName(String newCompanyName)
	{
	enterById("updateLeadForm_companyName", newCompanyName);
	return this;
	}
	public ViewLeadPage clickUpdateButton()
	{
		clickByXpath("//input[@value='Update']");
		return new ViewLeadPage(driver,et);
	}
	
}
