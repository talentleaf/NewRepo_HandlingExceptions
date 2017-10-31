package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapWrappers;

public class TC001_LeafTapLogin extends LeafTapWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="TC001_LeafTapLogin";
		testDesc="Verify login function";
		author="karpa";
		category="smoke";
		excelName="LoginData";
	}

	@Test(dataProvider="getDataFromExcel")
	public void loginfun(String userName,String password)
	{
		LoginPage lp=new LoginPage(driver,et);
		lp.typeUserName(userName);
		lp.typePassword(password);
		lp.clickLogin();
	}

}
