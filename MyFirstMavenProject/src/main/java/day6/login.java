package day6;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		//Options option=driver.manage();
		//Timeouts time=option.timeouts();
		//time.implicitlyWait(30, TimeUnit.SECONDS);
		
		//Enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click Create Lead
		driver.findElementByLinkText("Create Lead").click();
		
		//To fill mandatory fields in create lead page
		
	driver.findElementById("createLeadForm_companyName").sendKeys("Cognizant Technology Solutions");
	driver.findElementById("createLeadForm_firstName").sendKeys("Karpagam");
	driver.findElementById("createLeadForm_lastName").sendKeys("Karunanithi");
	Select sourcedropdown=new Select(driver.findElementById("createLeadForm_dataSourceId"));
	sourcedropdown.selectByIndex(4);
	Select marketcampaigndropdown=new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
	marketcampaigndropdown.selectByVisibleText("Automobile");
	driver.findElementById("createLeadForm_firstNameLocal").sendKeys("karpa");
	driver.findElementById("createLeadForm_lastNameLocal").sendKeys("karuna");
	driver.findElementById("createLeadForm_personalTitle").sendKeys("Mrs");
	driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Mrs.Veera");
	driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");
	driver.findElementById("createLeadForm_annualRevenue").sendKeys("1000000");
	
	
	//To find total number of options available in currency dropdown 
	Select currencyDropdown=new Select(driver.findElementById("createLeadForm_currencyUomId"));
	List <WebElement> currencyOptions=currencyDropdown.getOptions();
	System.out.println("Total Currency values in a dropdown="+currencyOptions.size());
	currencyDropdown.selectByValue("INR");
	
	WebElement industryDropdown=driver.findElementById("createLeadForm_industryEnumId");
	Select idd=new Select(industryDropdown);
	//List <WebElement> industryDropDownOptions=idd.getOptions();
	idd.selectByVisibleText("Insurance");
	
	//to find webelement by creating xpath without using firebug
	driver.findElementByXPath("//input[@id='createLeadForm_numberEmployees']").sendKeys("100");
	WebElement ownershipdropdownAddress=driver.findElementByXPath("//*[@name='ownershipEnumId']");
	Select ownershipdropdown=new Select(ownershipdropdownAddress);
	ownershipdropdown.selectByVisibleText("Partnership");
	/*List <WebElement> allvalues= ownershipdropdown.getOptions();
	for(int i=0;i<allvalues.size();i++)
{
	WebElement values=allvalues.get(i);
	String text=values.getText();
	System.out.println("ownership dropdown values="+text);
	if(values.getText()=="Partnership")
	{
		ownershipdropdown.selectByVisibleText("Partnership");
	}
	
}*/
	driver.findElementByXPath("//input[@name='sicCode']").sendKeys("15");
	driver.findElementByXPath("//textarea[@name='description']").sendKeys("Trying to submit the create lead form_karpagam");
	driver.findElementByName("importantNote").sendKeys("Notes section data");
	driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("044");
	driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("49596512");
	
	String createLead_Tile=driver.getTitle();
	
	if(createLead_Tile.equals("Create Lead | opentaps CRM")) {
		System.out.println("Create lead page is opened successfully");
		
	}else
	{
		System.out.println("Create Lead page is not opened: failure");
	}
	//driver.findElementByName("submitButton").click();
	
	//to find my lead that has been created
	/*driver.findElementByLinkText("Find Leads").click();
	driver.findElementByName("id").sendKeys("12314");
	driver.findElementByXPath("//*[@id='ext-gen334']").click();
	//driver.findElementByClassName("x-btn-center").click(); this has too many values of same class name so it is not clciking the correct data.
	
*/	
	//till duplicate lead code works
	//driver.findElementByXPath("//a[contains(text(),'Duplicate Lead')]").click();
			
	}

}
