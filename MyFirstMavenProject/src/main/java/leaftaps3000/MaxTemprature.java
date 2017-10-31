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

public class MaxTemprature {

	@Test
	public void maxandmintempcheck()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='Sat']").click();
		Set <String>ts=new TreeSet<String>();
		List<WebElement> alltemploc=driver.findElementsByXPath("//span[contains(@data-test,'maximum-5-')]");
		int i=1;
		for(WebElement temploc: alltemploc)
		{
			String tempinString=driver.findElementByXPath("(//span[contains(@data-test,'maximum-5-')])["+i+"]").getText();
			i++;
			ts.add(tempinString);
		}
		List<String> lal=new ArrayList<String>();
		lal.addAll(ts);
		String minTemp=lal.get(0);
		String maxTemp=lal.get(lal.size()-1);
		
		System.out.println("Minimum Temp: "+minTemp);
		System.out.println("Maximum Temp: "+maxTemp);
		
		String displayedMaxtemp=driver.findElementByXPath("//span[contains(@data-test,'maximum-5')]").getText();		
		if(maxTemp.equals(displayedMaxtemp))
			System.out.println("test case is passed for maximimum");
		else
			System.out.println("test case is failed");
		
		String displayedMintemp=driver.findElementByXPath("//span[contains(@data-test,'minimum-5')]").getText();		
		if(minTemp.equals(displayedMintemp))
			System.out.println("test case is passed for minimum");
		else
			System.out.println("test case is failed");
		
		
		
		
		
		
		
	}
}
