package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class LoginPage extends LeafTapWrappers {

	public LoginPage(RemoteWebDriver driver, ExtentTest et)
	{
		this.driver=driver;
		this.et=et;
		if (verifyTitle("Opentaps Open Source ERP + CRM")==false) {
			logSteps("fail", "Driver is not landed in the login page");
		}	
	}
	
	public LoginPage typeUserName(String userName)
	{
		enterById("username", userName);
		return this;
	}
	
	public LoginPage typePassword(String password)
	{
		enterById("password", password);
		return this;
	}
	
	public HomePage clickLogin()
	{
		clickByClassName("decorativeSubmit");
		return new HomePage(driver, et);
	}
}
