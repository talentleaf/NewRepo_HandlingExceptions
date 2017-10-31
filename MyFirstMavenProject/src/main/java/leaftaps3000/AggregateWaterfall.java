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

public class AggregateWaterfall {

	@Test
	public void aggregateWaterfall()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='Sat']").click();
		List<WebElement> alltemploc=driver.findElementsByXPath("//span[contains(@data-test,'rainfall-5-')]");
		int i=1;
		int sum=0;
		for(WebElement temploc: alltemploc)
		{
			String waterfallString=driver.findElementByXPath("(//span[contains(@data-test,'rainfall-5-')])["+i+"]").getText();
			i++;
			String newvaluewithoutmm=waterfallString.replace("mm", "");
				int rainfallquann=Integer.valueOf(newvaluewithoutmm);
			System.out.println(newvaluewithoutmm);
			sum=sum+rainfallquann;
		}
		String displayedrainfallvalue=driver.findElementByXPath("//span[contains(@data-test,'rainfall-5')]").getText();
		String Substring=displayedrainfallvalue.replace("mm", "");
		int displayquan=Integer.parseInt(Substring);
		if(displayquan==sum)
			System.out.println("test case is passed"+displayedrainfallvalue);
		else
			System.out.println("test case is failed");
	}
}
