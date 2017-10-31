package wrappers;

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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reports;

public class GenericWrappers extends Reports implements Wrappers{
	
	public RemoteWebDriver driver;
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
			logSteps("pass", "The browser "+browser+" launched successfully");
			//takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
			logSteps("fail", "The browser "+browser+" could not be launched");
		}

	}

	public void enterById(String idValue, String data) {
		try {
			WebElement eleId = driver.findElementById(idValue);
			eleId.clear();
			eleId.sendKeys(data);
			System.out.println("The text field with id "+idValue+" entered with data "+data+" successfully.");
			logSteps("pass", "The text field with id "+idValue+" entered with data "+data+" successfully.");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element with "+idValue+ " is not present");
			logSteps("Fail","Element with "+idValue+ " is not present" );
		}finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			WebElement ele=driver.findElementByName(nameValue);
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The"+nameValue+ " text field with name "+data+ " has been entered");
			logSteps("pass", "The"+nameValue+ " text field with name "+data+ " has been entered");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			String message=e.getMessage();
			logSteps("fail", "Exception occured");
		}catch(WebDriverException e)
		{
			String message=e.getMessage();
			logSteps("fail", message);
		}finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			WebElement ele=driver.findElementByXPath(xpathValue);
			ele.clear();
			ele.sendKeys(data);
			System.out.println("Entered data "+data+" in  the field with xpath "+xpathValue);
			logSteps("pass", "Entered data "+data+" in  the field with xpath "+xpathValue);
		} catch (Exception e) {
			System.err.println("Some new exception occured");
			logSteps("fail", "Exception occured");
			e.printStackTrace();
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
				logSteps("pass", "Page Title: " +actualTitle+" is validated successfully");
				takeSnap();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception occurs and the page title is not returned correctly");
			takeSnap();
			logSteps("fail", "Exception occurs and the page title is not returned correctly");
		}	
		return false;
	}

	public boolean verifyTextById(String id, String text) {
		try {
			String s=driver.findElementById(id).getText();
			if(s.contains(text))
			{
				System.out.println("Field "+id+" contains "+text+ "and verification is passed");
				logSteps("pass", "Field "+id+" contains "+text+ " and verification is passed");
				return true;
			}else
			{
				System.err.println("Field "+id+" doesnt contains "+text+ "and verification failed");
				logSteps("fail", "Field "+id+" doesnt contains "+text+ "and verification failed");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println("Some exception occured");
		}
		return false;
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The button with class "+classVal+" is clicked");
			logSteps("pass", "The button with class "+classVal+" is clicked");
		} catch (Exception e) {
			e.printStackTrace();
			logSteps("fail", "The button with class "+classVal+" could  not be clicked");
		}finally {
			takeSnap();
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println("The button with name "+name+" is clicked");
			logSteps("pass", "The button with name "+name+" is clicked");
		} catch (Exception e) {
			logSteps("fail", "The button with name "+name+" could  not be clicked");
			e.printStackTrace();
		}finally {
			takeSnap();
		}
		

	}

	public void clickByLink(String name) {
	
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The link with"+name+ "is clicked");
			logSteps("pass", "The link with"+name+ "is clicked");
			
		} catch (Exception e) {
			System.err.println("SOme Error message");
			logSteps("fail", "Some exception occured so link is not clickable");
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
			logSteps("pass", "The link with"+name+ "is clicked");
			
		} catch (Exception e) {
			System.err.println("SOme Error message");
			logSteps("fail", "Some exception occured so link is not clickable");
			e.printStackTrace();
		}

	}

	public void clickByXpath(String xpathVal) {
		try{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The button with xpath "+xpathVal+" is clicked");
			logSteps("pass","The button with xpath "+xpathVal+" is clicked");
			
		}catch(NoSuchElementException e)
		{
			System.err.println("The button with xpath "+xpathVal+" is not found");
			logSteps("fail", "The button with xpath "+xpathVal+" is not found");
		}catch(Exception e) {
			System.err.println("some new exception occurred");
			System.err.println(e.getMessage());
			logSteps("fail", "some new exception occurred");
			
		}finally {
			takeSnap();
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("Field with xpath value "+xpathVal+" is clicked");
			logSteps("pass","Field with xpath value "+xpathVal+" is clicked");
		} catch (Exception e) {
			System.err.println("Exception occured");
			e.printStackTrace();
			logSteps("fail", "some new exception occurred");
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
		try {
			WebElement dropdown = driver.findElementById(id);
			Select src = new Select(dropdown);
			src.selectByVisibleText(value);
			System.out.println("dropdown value" +value+ " is selected");
			logSteps("pass", "dropdown value" +value+ " is selected");
		} catch (Exception e) {
			e.printStackTrace();
			logSteps("fail", "DropDown value is not selected");
		}finally {
			takeSnap();
		}	

	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement e=driver.findElementById(id);
			Select drop=new Select(e);
			drop.selectByIndex(value);
			logSteps("pass", "dropdown value" +value+ " is selected");
			List <WebElement> optionValues=drop.getOptions();
			for(WebElement eachoption:optionValues)
			{
				System.out.println(eachoption);
			}
		} catch (Exception e) {
			logSteps("fail", "DropDown value is not selected");
		}finally {
			takeSnap();
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
			logSteps("pass", "Driver switched to parent window: "+driver.getTitle());
		} catch (Exception e) {
			System.err.println("Exception occured");
			e.printStackTrace();
			logSteps("fail", "Exception occured");
		}finally
		{
			takeSnap();
		}

	}

	public void switchToLastWindow() {
		try {
			Set<String> allWindows=driver.getWindowHandles();
			System.out.println(allWindows.size())	;
			for(String eachWindow:allWindows)
			{
				driver.switchTo().window(eachWindow);
			
			}
			System.out.println(driver.getTitle());
			logSteps("pass", "Driver switched to last child window "+driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
			logSteps("fail", "Exception occurs when driver switches to last window");
		}finally {
			takeSnap();
		}
		
	}

	public void switchToFrames(String frameName)
	{
		try {
			driver.switchTo().frame(frameName);
			System.out.println("Switched to frame successfully");
			logSteps("pass","Switched to frame successfully"+frameName );
		} catch (Exception e) {
			logSteps("fail", "There is no such frame to switch over");
		}finally {
			takeSnap();
		}
		
	}
	public void acceptAlert(String data) {

		try {
			Alert al=driver.switchTo().alert();
			al.sendKeys(data);
			System.out.println("Alert has been accepted after entering value in the text field");
			al.accept();
			logSteps("pass", "Alert has been accted by entering the "+data+" in the text field");
		} catch (Exception e) {
			logSteps("fail","No such alert exception");
			e.printStackTrace();
		}finally {
			takeSnap();	
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert has been dismissed");
			logSteps("pass", "Alert has been dismissed");
			
		} catch (Exception e) {
			logSteps("fail","No such alert exception");
		}finally {
			takeSnap();
		}

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

}
