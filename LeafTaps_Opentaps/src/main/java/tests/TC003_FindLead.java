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

public class TC003_FindLead extends LeafTapWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="TC003_FindLead";
		testDesc="Verify Find Lead function";
		author="karpa";
		category="smoke";
		excelName="FindLeadTestData";
	}

	@Test(dataProvider="getDataFromExcel")
	public void findLeadfun(String userName, String password, String firstName)
	{
		new LoginPage(driver,et)
		.typeUserName(userName)
		.typePassword(password)
		.clickLogin()
		.clickCRMSFAlink()
		
		//MyHomePage mhp=new MyHomePage();
		.clickLeadsTab()
		.clickFindLeadTab()
		.typeFirstName(firstName)
		.clickFindLeadButton()
		.clickonSearchedLead();
		
	}

}
