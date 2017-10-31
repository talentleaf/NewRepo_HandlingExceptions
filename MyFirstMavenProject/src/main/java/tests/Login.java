package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class Login {

@Test
	public void loginLogout() throws InterruptedException {
		
		GenericWrappers wr = new GenericWrappers();
		wr.invokeApp("chrome", "http://leaftaps.com/opentaps");
		
		//Enter the UserName
		wr.enterById("username", "DemoSalesManager");
		
		//Enter the Password
		wr.enterById("password", "crmsfa");

		//Click on Login Button
		wr.clickByClassName("decorativeSubmit");
		
		//Click on LogOut Button
		wr.clickByClassName("decorativeSubmit");
		
		// Close browser
		wr.closeBrowser();	
		
	}
}