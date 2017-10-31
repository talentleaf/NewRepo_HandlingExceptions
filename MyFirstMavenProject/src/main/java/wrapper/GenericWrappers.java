package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers{
	
	RemoteWebDriver driver;
	int i = 1;
	
	public void invokeApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			//takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterById(String idValue, String data) {
		try {
			WebElement eleId = driver.findElementById(idValue);
			eleId.clear();
			eleId.sendKeys(data);
			System.out.println("The text field with id "+idValue+" entered with data "+data+" successfully.");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element with "+idValue+ " is not present");
		}finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		WebElement ele=driver.findElementByName(nameValue);
		ele.clear();
		ele.sendKeys(data);
		System.out.println("The text field with name "+data+ " has been entered");
		takeSnap();	    
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			WebElement ele=driver.findElementByXPath(xpathValue);
			ele.clear();
			ele.sendKeys(data);
			System.out.println("Entered data "+data+" in  the field with xpath "+xpathValue);
		} catch (Exception e) {
			System.err.println("Some new exception occured");
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
		

	}

	public boolean verifyTitle(String title) {
		try {
			String actualTitle=driver.getTitle();
			if(actualTitle.equals(title))
			{
				System.out.println("Page Title: " +actualTitle+" is validated successfully");
				takeSnap();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Page title is wrong");
			takeSnap();
		}	
		return false;
	}

	public boolean verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub

	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		System.out.println("The button with class "+classVal+" is clicked");
		takeSnap();
	}

	public void clickByName(String name) {
		driver.findElementByName(name).click();
		System.out.println("The button with name "+name+" is clicked");
		takeSnap();
		

	}

	public void clickByLink(String name) {
	
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The link with"+name+ "is clicked");
			
		} catch (Exception e) {
			System.err.println("SOme Error message");
			e.printStackTrace();
		}finally
		{
			takeSnap();
		}

	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The link with"+name+ "is clicked");
			
		} catch (Exception e) {
			System.err.println("SOme Error message");
			e.printStackTrace();
		}

	}

	public void clickByXpath(String xpathVal) {
		try{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The button with xpath "+xpathVal+" is clicked");
			takeSnap();
		}catch(NoSuchElementException e)
		{
			System.err.println("The button with xpath "+xpathVal+" is not found");
		}catch(Exception e) {
			System.err.println("some new exception occurred");
			System.err.println(e.getMessage());
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("Field with xpath value "+xpathVal+" is clicked");
		} catch (Exception e) {
			System.err.println("Exception occured");
			e.printStackTrace();
		}

	}

	public String getTextById(String idVal) {
		try {
			WebElement ele=driver.findElementById(idVal);
			String elementText=ele.getText();
			System.out.println("Text of the element has been stored successfully: "+elementText);
			return elementText;
		} catch (Exception e) {
			System.out.println("some New Exception Occured");
			e.printStackTrace();
		}
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		try {
			String Text=driver.findElementByXPath(xpathVal).getText();
			System.out.println("Text has been returned to the function "+Text);
			return Text;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		WebElement dropdown = driver.findElementById(id);
		Select src = new Select(dropdown);
		src.selectByVisibleText(value);
		System.out.println("dropdown value" +value+ " is selected");
		takeSnap();
		

	}

	public void selectIndexById(String id, int value) {
		WebElement e=driver.findElementById(id);
		Select drop=new Select(e);
		drop.selectByIndex(value);
		List <WebElement> optionValues=drop.getOptions();
		
		for(WebElement eachoption:optionValues)
		{
			System.out.println(eachoption);
		}

	}

	public void switchToParentWindow() {
		try {
			Set<String> allWindows=driver.getWindowHandles();
			System.out.println(allWindows.size());;
			for(String singleWindow:allWindows)
			{
				driver.switchTo().window(singleWindow);
				break;
			}
			System.out.println("Driver switched to parent window: "+driver.getTitle());
		} catch (Exception e) {
			System.err.println("Exception occured");
			e.printStackTrace();
		}finally
		{
			takeSnap();
		}

	}

	public void switchToLastWindow() {
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println(allWindows.size())	;
		for(String eachWindow:allWindows)
		{
			driver.switchTo().window(eachWindow);
		
		}
		System.out.println(driver.getTitle());
		
	}

	public void switchToFrames(String frameName)
	{
		driver.switchTo().frame(frameName);
		System.out.println("Switched to frame successfully");
		
	}
	public void acceptAlert(String data) {

		Alert al=driver.switchTo().alert();
		al.sendKeys(data);
		System.out.println("Alert has been accepted after entering value in the text field");
		al.accept();
		takeSnap();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		System.out.println("Alert has been dismissed");
		takeSnap();

	}

	public String getAlertText() {
		Alert al=driver.switchTo().alert();
		String alertText=al.getText();
		return alertText;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".jpg");
		i++;
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.close();
		System.out.println("The browser is closed");
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
driver.switchTo().alert().accept();
System.out.println("Alert has been accepted successfully");
takeSnap();
		
	}
	
	public void verifyCurrentURL(String currenturl)
	{
		String s=driver.getCurrentUrl();
		if(s.equalsIgnoreCase(currenturl))
		{
			System.out.println("Current url is verified and it is success");
		}
		else
		{
			System.out.println("Current url is not matched");
		}
		
	}

}
