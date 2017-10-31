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

public class TC004_EditFunction extends LeafTapWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="TC004_EditFunction";
		testDesc="Verify user is able to edit the lead";
		author="karpa";
		category="smoke";
		excelName="EditLeadTestData";
	}

	@Test(dataProvider="getDataFromExcel")
	public void editfun(String userName, String password, String firstName,String newCompanyName)
	{
		new LoginPage(driver,et)
		.typeUserName(userName)
		.typePassword(password)
		.clickLogin()
		.clickCRMSFAlink()
		.clickLeadsTab()
		.clickFindLeadTab()
		.typeFirstName(firstName)
		.clickFindLeadButton()
		.clickonSearchedLead()
		.clickEditButton()
		.changeCompanyName(newCompanyName)
		.clickUpdateButton()
		.verifyCompanyName(newCompanyName);	
		
	}

}
