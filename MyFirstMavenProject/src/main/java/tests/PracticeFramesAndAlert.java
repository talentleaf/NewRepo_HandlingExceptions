package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import wrapper.GenericWrappers;

public class PracticeFramesAndAlert {
	public static void main(String[] args) {

		GenericWrappers wrapperObject=new GenericWrappers();
		wrapperObject.invokeApp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		wrapperObject.switchToFrames("iframeResult");
		wrapperObject.clickByXpath("//button[text()='Try it']");
		String alertText1=wrapperObject.getAlertText();
		System.out.println("Text in the alert: "+alertText1);
		wrapperObject.acceptAlert("Karpagam");
		
		

	}

}
