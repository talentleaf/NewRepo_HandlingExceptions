package leaftaps3000;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ThreeHoursInterval {

	@Test
	public void threehoursIntervalcheck()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='Sat']").click();
		List <Integer>al=new ArrayList<Integer>();
		List<WebElement> timeIntervalloc=driver.findElementsByXPath("//span[contains(@data-test,'hour-5-')]");
		for(int i =1;i<timeIntervalloc.size();i++)
		{
			WebElement timeintervalxpath=driver.findElementByXPath("(//span[contains(@data-test,'hour-5-')])["+i+"]");
			String timeintervalinString=timeintervalxpath.getText();
			int timeinterval=Integer.parseInt(timeintervalinString);
			al.add(timeinterval);
		}
		int i=0;
		while(i<al.size())
		{	
			int value1=al.get(i);
			i++;
			int value2=al.get(i);
			i++;
			int difference=value2-value1;
			if(difference==300)
				System.out.println("Difference is 3 hours between timeinterval.Hence the test case is passed");	
			else
				System.err.println("the test case is failed");
		}
		
		
	}
}
