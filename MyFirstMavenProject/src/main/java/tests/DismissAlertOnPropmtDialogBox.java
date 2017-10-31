package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import wrapper.GenericWrappers;

public class DismissAlertOnPropmtDialogBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		GenericWrappers wrapperObject=new GenericWrappers();
		wrapperObject.clickByXpath("//button[text()='Try it']");*/
		
		GenericWrappers wrapperObject=new GenericWrappers();
		wrapperObject.invokeApp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		wrapperObject.switchToFrames("iframeResult");
		wrapperObject.clickByXpath("//button[text()='Try it']");
		wrapperObject.dismissAlert();

	}

}
