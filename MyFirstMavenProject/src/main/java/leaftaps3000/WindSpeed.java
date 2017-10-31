package leaftaps3000;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WindSpeed {

	@Test
	public void windSpeedCheck()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='Sat']").click();
		List<String> al=new ArrayList<String>();
		List<WebElement> alltemploc=driver.findElementsByXPath("//span[contains(@data-test,'speed-5-')]");
		int i=1;
		for(WebElement temploc: alltemploc)
		{
			String tempinString=driver.findElementByXPath("(//span[contains(@data-test,'speed-5-')])["+i+"]").getText();
			i++;
			al.add(tempinString);
		}
		String firstWindSpeed=al.get(0);
		String displayedWindSpeed=driver.findElementByXPath("//span[contains(@data-test,'speed-5')]").getText();		
		if(displayedWindSpeed.equals(firstWindSpeed))
			System.out.println("test case is passed"+displayedWindSpeed);
		else
			System.out.println("test case is failed");
		
		
	}
}
