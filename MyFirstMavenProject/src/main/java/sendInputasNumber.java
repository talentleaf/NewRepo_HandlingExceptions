import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class sendInputasNumber {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://resident.uidai.gov.in/check-aadhaar-status");
		WebElement ele=driver.findElementById("eid");
		ele.sendKeys("1");	

	}

}
