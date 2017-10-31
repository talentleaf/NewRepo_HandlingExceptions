package day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFramesAndAlert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		WebElement tryitButton=driver.findElementByXPath("//button[text()='Try it']");
		tryitButton.click();
		Alert alt=driver.switchTo().alert();
		alt.getText();
		alt.sendKeys("Karpagam and Keerthika");
		alt.accept();
		//WebElement welcomeAdd=driver.findElementByXPath("//p[@id='demo']");
		
		WebElement welcomeAdd=driver.findElementByXPath("//p[text()[contains(.,'Hello karpagam! How are you today?')]]");
		String welcomeText=welcomeAdd.getText();
		System.out.println(welcomeText);
		
		if(welcomeText.contains("Karpagam"))
		{
			System.out.println("our code is successful");
		}
		else
		{
			System.out.println("code doesn't contain my name");
		}

	}

}
