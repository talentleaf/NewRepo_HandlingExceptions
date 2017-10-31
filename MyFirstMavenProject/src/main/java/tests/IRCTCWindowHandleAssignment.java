package tests;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import wrapper.GenericWrappers;

public class IRCTCWindowHandleAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String message=null;
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().window().maximize();
		driver.findElementByLinkText("Contact Us").click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String eachWindow:allWindows)
		{
			driver.switchTo().window(eachWindow);

		}
		//to print the child window url
		System.out.println(driver.getCurrentUrl());
		//to print child window title
		System.out.println(driver.getTitle());

		WebElement ele=driver.findElementByXPath("//*[text()[contains(.,'Fax no. :')]]");

		String text=ele.getText();


		if(text.equalsIgnoreCase("Fax no. :"))
		{
			System.out.println(text);
			driver.quit();
		}
		else
		{
			System.out.println("fax no text is not displayed");
		}


	}

}
