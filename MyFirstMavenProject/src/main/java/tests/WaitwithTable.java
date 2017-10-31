package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitwithTable {
		public static void main(String[] args) throws InterruptedException {	
				
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://leaftaps.com/opentaps");
			driver.manage().window().maximize();
			driver.findElementById("username").sendKeys("DemoSalesManager");
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByLinkText("Leads").click();
			driver.findElementByLinkText("Find Leads").click();
			driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("n");
			driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
			
			//driver.findElementsByXPath("//table[@class='x-grid3-row-table]");
			
			List<WebElement> listOfTable=driver.findElementsByClassName("x-grid3-row-table");
			
			System.out.println("Total Table "+listOfTable.size());	
			
			WebElement firstTable=listOfTable.get(0);
			
			List<WebElement> rows=firstTable.findElements(By.tagName("tr"));
			
			System.out.println("Rows in a table "+rows.size());
			
			WebElement firstrow=rows.get(0);
			
			List <WebElement> totalColumns=firstrow.findElements(By.tagName("td"));
			
			System.out.println(totalColumns.size());
			
			//WebElement column=totalColumns.get(0);
			
			System.out.println(totalColumns.get(0).getText());
			
			

			//driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();		
		}
	

}
