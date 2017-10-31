package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyHomePage;
import pages.MyLeadsPage;
import pages.ViewLeadPage;
import wrappers.LeafTapWrappers;

public class TC002_CreateLead extends LeafTapWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="TC002_CreateLead";
		testDesc="Verify create Lead function";
		author="karpa";
		category="smoke";
		excelName="CreateLeadData";
	}

	@Test(dataProvider="getDataFromExcel")
	public void createLeadfun(String companyName, String firstName, String lastName)
	{
		new LoginPage(driver, et)
		.typeUserName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.clickCRMSFAlink()
		
		//MyHomePage mhp=new MyHomePage();
		.clickLeadsTab()
		
		//MyLeads ml=new MyLeads();
		.clickCreateLeadTab()
	
		//CreateLead cl=new CreateLead();
		.typeCompanyName(companyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLeadButton()	
		
		//ViewLead vl=new ViewLead();
		.verifyCompanyName(companyName);
		
	}

}
