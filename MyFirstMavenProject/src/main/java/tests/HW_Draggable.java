package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW_Draggable {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://jqueryui.com/draggable/");
	driver.manage().window().maximize();
	driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));
	WebElement dragmeAround=driver.findElementById("draggable");
	Point p=dragmeAround.getLocation();
	System.out.println(p);
	Actions builder=new Actions(driver);
	builder.dragAndDropBy(dragmeAround, 100, 100).build().perform();
	p=dragmeAround.getLocation();
	System.out.println(p);

	}

}
