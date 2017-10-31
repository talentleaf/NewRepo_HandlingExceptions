package withExceldata;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import simple_java_programs.ReadFromExcel;
import wrapper.LeafTapWrappers;

public class CreateLeadGetDatafromExcel extends LeafTapWrappers{
	@Test(dataProvider="getDataFromExcel")
	public void createLead(String com_name,String FirstName,String lastName) {
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName",com_name);
		enterById("createLeadForm_firstName",FirstName);
		enterById("createLeadForm_lastName",lastName);
		clickByName("submitButton");
	}
	
	@DataProvider(name="getDataFromExcel")
	public Object[][] datafromExcel() throws InvalidFormatException, IOException
	{
		ReadFromExcel rfe=new ReadFromExcel();
		
		Object[][] dp= rfe.readExcelData("CreateLeadData");
		
		return dp;
		
	}
}


		/*

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

		}
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

	







