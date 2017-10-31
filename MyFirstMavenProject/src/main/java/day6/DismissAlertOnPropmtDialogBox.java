package day6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DismissAlertOnPropmtDialogBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		//to dismiss the alert
		driver.switchTo().alert().dismiss();
		WebElement cancelTextAdd=driver.findElementByXPath("//p[text()[contains(.,'cancelled the prompt')]]");
		//WebElement cancelTextAdd=driver.findElementByXPath("// p[@id='demo']");
		String text=cancelTextAdd.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("google_ads_iframe_/16833175/TryitLeaderboard_0");
		WebElement addImageAddress=driver.findElementByClassName("img_ad");
		String value=addImageAddress.getAttribute("src");
		if(value.isEmpty())
		{
			System.out.println("Ad is not present");
		}
		else
			System.out.println("Ad is displayed correctly");
	}

}
