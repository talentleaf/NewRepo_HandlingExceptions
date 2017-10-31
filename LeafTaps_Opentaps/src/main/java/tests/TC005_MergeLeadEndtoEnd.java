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

public class TC005_MergeLeadEndtoEnd extends LeafTapWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="TC005_MergeLeadEndtoEnd";
		testDesc="Verify user is able to merge the lead";
		author="karpa";
		category="smoke";
		excelName="MergeLeadTestData";
	}

	@Test(dataProvider="getDataFromExcel")
	public void mergeLeadfun(String userName, String password, String firstName)
	{
		new LoginPage(driver,et)
		.typeUserName(userName)
		.typePassword(password)
		.clickLogin()
		.clickCRMSFAlink()
		.clickLeadsTab()
		.clickMergeLeadsTab()
		.clickFromLeadLookUpicon()
		.typeFirstName(firstName)
		.clickFindLeadButton()
		.clickonSearchedLead(1)
		//.getTextFromLead()
		.clickToLeadLookUpicon()
		.typeFirstName(firstName)
		.clickFindLeadButton()
		.clickonSearchedLead(3)
		.clickMergeButton();	
	}

}
