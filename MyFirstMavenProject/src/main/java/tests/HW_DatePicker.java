package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.AllocationInstruction;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW_DatePicker {

	public static void main(String[] args) {
		String lastDate=null;
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));
	driver.findElementById("datepicker").click();
	WebElement tableloc=driver.findElementByClassName("ui-datepicker-calendar");
	List<WebElement> rowsInCalendar=tableloc.findElements(By.tagName("tr"));
	System.out.println("total number of rows: "+rowsInCalendar.size());
	WebElement lastRow=rowsInCalendar.get(5);
	//through tag name "a"
	
	List <WebElement> allDatainLastRow=lastRow.findElements(By.tagName("a"));
	System.out.println("no of columns in last row: "+allDatainLastRow.size());
	for(WebElement eachdata:allDatainLastRow)
	{
		lastDate=eachdata.getText();
	}
	
	System.out.println(lastDate);
	
	//through xpath
	/*List<WebElement> allDatainLastRow=driver.findElements(By.xpath("//td[@data-event='click']/a"));
	System.out.println("no of columns in last row: "+allDatainLastRow.size());
	for(WebElement eachdata:allDatainLastRow)
	{
		lastDate=eachdata.getText();
	}
	System.out.println("Last Date value:"+lastDate);
	*/
	
	}
}
