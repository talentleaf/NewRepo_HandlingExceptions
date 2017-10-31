package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class ViewLeadPage extends LeafTapWrappers{

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("View Lead | opentaps CRM")==false) {
			logSteps("fail", "Driver is not landed at View Lead page");
		}	
	}		
	public ViewLeadPage verifyCompanyName(String companyName)
	{		
		boolean check=verifyTextById("viewLead_companyName_sp", companyName);
		return this;
	}
	
	public EditPage clickEditButton()
	{
		clickByLink("Edit");
		return new EditPage(driver,et);
		
	}
}
