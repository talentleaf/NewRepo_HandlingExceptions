package opentaps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class GeckoDriver_Run extends GenericWrappers {

	@Test
	public void firefoxRun(){
		invokeApp("firefox", "http://leaftaps.com/opentaps");
		
		enterById("username", "DemoSalesManager");
		
		enterById("password", "crmsfa");
		
		clickByClassName("decorativeSubmit");

	}

}
