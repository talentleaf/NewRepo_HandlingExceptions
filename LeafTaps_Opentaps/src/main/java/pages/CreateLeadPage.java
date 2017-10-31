package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class CreateLeadPage extends LeafTapWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("Create Lead | opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at Create Lead page");
		}	
	}	
	public CreateLeadPage typeCompanyName(String companyName)
	{
		enterById("createLeadForm_companyName", companyName);
		return this;
	}
	
	public CreateLeadPage typeFirstName(String firstName)
	{
		enterById("createLeadForm_firstName", firstName);
		return this;
	}
	
	public CreateLeadPage typeLastName(String lastName)
	{
		enterById("createLeadForm_lastName", lastName);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton()
	{		
		clickByXpath("//input[@value='Create Lead']");
		return new ViewLeadPage(driver,et);
	}
}
