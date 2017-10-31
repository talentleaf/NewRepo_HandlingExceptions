package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class Facebook extends GenericWrappers {

	@Test
	public void facebookLogin() throws InterruptedException {
		
		invokeApp("chrome", "https://www.facebook.com/");
		
		//Enter the UserName
		enterById("email", "babu");
		
		//Enter the Password
		enterById("pass", "crmsfa");

		//Click on Login Button
		clickByXpath("//input[@value='Log In']");
		
		// Close browser
		closeBrowser();
		
		
	
		
	}
}