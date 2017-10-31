package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HW_Selectable {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://jqueryui.com/selectable/");
	driver.manage().window().maximize();
	driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));
	WebElement firstitem=driver.findElementByXPath("//ol[@id='selectable']/li[1]");
	WebElement middleItem=driver.findElementByXPath("//ol[@id='selectable']/li[3]");
	WebElement lastItem=driver.findElementByXPath("//ol[@id='selectable']/li[5]");
	
	Actions builder=new Actions(driver);
	
	/*Action seriesofAction=builder
							.moveToElement(firstitem)
							.sendKeys(Keys.ENTER)
							.keyDown(Keys.CONTROL)
							.moveToElement(lastItem)
							.sendKeys(Keys.ENTER)
							.build();
							seriesofAction.perform();*/
	
	builder.click(firstitem).keyDown(Keys.CONTROL).click(middleItem).build().perform();
	Action series=builder.keyDown(Keys.CONTROL)
			.click(firstitem)
			.click(middleItem)
			.click(lastItem)
			.keyUp(Keys.CONTROL)
			.build();
	series.perform();
	
	System.out.println("Success");

	}

}
