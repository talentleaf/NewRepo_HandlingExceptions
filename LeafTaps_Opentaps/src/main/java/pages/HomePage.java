package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class HomePage extends LeafTapWrappers {

	public HomePage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("Opentaps Open Source ERP + CRM")==false) {
			logSteps("fail", "Driver is not landed in the Home page");
		}	
	}	
	public MyHomePage clickCRMSFAlink()
	{
		clickByLink("CRM/SFA");
		return new MyHomePage(driver,et);
	}
	public LoginPage clickLogOut()
	{
		clickByClassName("decorativeSubmit");
		return new LoginPage(driver,et);
	}
}
