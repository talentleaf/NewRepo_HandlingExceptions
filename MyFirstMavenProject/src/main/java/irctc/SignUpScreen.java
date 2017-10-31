package irctc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpScreen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String message=null;
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("userRegistrationForm:userName").sendKeys("renugambal");
		driver.findElementById("userRegistrationForm:checkavail").click();
		WebElement useridexistmsg=driver.findElementByXPath("//label[@id='userRegistrationForm:useravailn']");
		message=useridexistmsg.getText();
		if(message!=null)
		{
		driver.findElementById("userRegistrationForm:userName").clear();
		driver.findElementById("userRegistrationForm:userName").sendKeys("renuka_kar");
		driver.findElementById("userRegistrationForm:checkavail").click();
		//message=driver.findElementByXPath("//*[text()[contains(.,'User Id already exists')]]").getText();
		}
		driver.findElementById("userRegistrationForm:password").sendKeys("Abikarpa25");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Abikarpa25");
		Select secretquestiondropdown=new Select(driver.findElementById("userRegistrationForm:securityQ"));
		secretquestiondropdown.selectByVisibleText("What was the name of your first school?");
		/*List <WebElement> dropdownvalues=secretquestiondropdown.getOptions();
		for(WebElement values:dropdownvalues)
		{
			String s=values.getText();
			if(s=="What was the name of your first school?")
				secretquestiondropdown.selectByVisibleText("What was the name of your first school?");
		}*/
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Government School");
		Select prefflanguage=new Select(driver.findElementById("userRegistrationForm:prelan"));
		prefflanguage.selectByIndex(0);
		driver.findElementById("userRegistrationForm:firstName").sendKeys("renuka");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("karunanithi");
		driver.findElementByXPath("//label[@for='userRegistrationForm:gender:1']").click();
		//driver.findElementByXPath("//label[contains(text(),'Married']").click();
		//driver.findElementByXPath("//label[@for='userRegistrationForm:maritalStatus:0']").click();
		driver.findElementByXPath("//input[@id='userRegistrationForm:maritalStatus:0']").sendKeys(Keys.ENTER);
		Select date=new Select(driver.findElementById("userRegistrationForm:dobDay"));
		date.selectByVisibleText("06");
		Select month=new Select(driver.findElementById("userRegistrationForm:dobMonth"));
		month.selectByVisibleText("JUN");
		Select year=new Select(driver.findElementById("userRegistrationForm:dateOfBirth"));
		year.selectByVisibleText("1968");
		  
		Select occupation=new Select(driver.findElementById("userRegistrationForm:occupation"));
		occupation.selectByValue("0");
		Select country=new Select(driver.findElementById("userRegistrationForm:countries"));
		country.selectByIndex(1);
		driver.findElementById("userRegistrationForm:email").sendKeys("karpagam.karuna@gmail.com");
		//driver.findElementById("userRegistrationForm:isdCode").sendKeys("91");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9487865216");
		Select nationality=new Select(driver.findElementById("userRegistrationForm:nationalityId"));
		nationality.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:address").sendKeys("plot no:5");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600091",Keys.TAB);
		//Thread.sleep(1000);
		//driver.findElementById("userRegistrationForm:statesName").sendKeys("TamilNadu");
		driver.findElementById("userRegistrationForm:cityName").click();
		Select city=new Select(driver.findElementById("userRegistrationForm:cityName"));
		city.selectByIndex(1);;
		Select postoffice=new Select(driver.findElementById("userRegistrationForm:postofficeName"));
		postoffice.selectByIndex(1);
		driver.findElementById("userRegistrationForm:landline").sendKeys("04449596512");
		
		
		
		
		
	}

}
