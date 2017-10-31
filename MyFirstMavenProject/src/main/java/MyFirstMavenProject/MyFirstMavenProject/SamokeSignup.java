package MyFirstMavenProject.MyFirstMavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SamokeSignup {
	@Test
	public void signup() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		WebElement ele=driver.findElementByTagName("Select");
		if(ele.isDisplayed())
			System.out.println("Dropdown is present");
		
		Select s=new Select(ele);
		List <WebElement> options=s.getOptions();
		for(WebElement eachoption:options)
		{
			String OptionValue=eachoption.getText();
			if(OptionValue.equals("IBM"))
			{
			s.selectByVisibleText(OptionValue);
			break;}
					}
		
	}
	

}
