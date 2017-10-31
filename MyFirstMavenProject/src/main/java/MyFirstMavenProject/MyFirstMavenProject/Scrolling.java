package MyFirstMavenProject.MyFirstMavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Scrolling {
	@Test
	public void scolltoBottomPage()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/selenium-tutorials/scrolling-web-page-with-selenium-webdriver-using-java");
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	@Test
	public void dynamicSearch()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.findElementById("lst-ib").sendKeys("karpagam");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//ul[@role='listbox']")));
		
		List<WebElement> ele=driver.findElementsByXPath("//li[@role='presentation']");
		
		for(int i=0;i<ele.size();i++)
		{
			WebElement each=ele(i);
			String searchresult=e.getText();
			
			System.out.println(searchresult);
			


			
		}
		
		
	}
}
