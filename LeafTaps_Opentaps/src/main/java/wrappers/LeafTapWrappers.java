package wrappers;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;

public class LeafTapWrappers extends GenericWrappers {
	
	public String testCaseName, testDesc, author, category,excelName;
	
@BeforeSuite
public void beforeSuite()
{
	createReport();
}
@BeforeTest
public void beforeTest()
{
	
}

@Parameters({"URL","Browser"})
@BeforeMethod
	public void login(String url,String browser)
	{
		
	createTestcaseReport(testCaseName, testDesc, author, category);
		invokeApp(browser,url);
	}

@AfterMethod
public void close()
{
	closeBrowser();
	closeTestcaseReport();
}

@AfterClass
public void afterClass()
{
	
}
@AfterTest
public void afterTest(){
	
}
@AfterSuite
public void afterSuite(){
	saveReport();
}
@DataProvider(name="getDataFromExcel")
public Object[][] datafromExcel() throws InvalidFormatException, IOException
{
	DataInputProvider rfe=new DataInputProvider();
	
	Object[][] dp= rfe.readExcelData(excelName);
	
	return dp;
	
}
}
