package withExceldata;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import simple_java_programs.ReadFromExcel;
import wrapper.GenericWrappers;
import wrapper.LeafTapWrappers;

public class FindLead extends LeafTapWrappers{

	@Test(dataProvider="findcaseGetData")
	public void findLeadgetDatafromExcel(String firstName)
	{
		clickByLink("Leads");
		
		clickByLink("Find Leads");
		
		enterByXpath("(//input[@name='firstName'])[3]", firstName);
		
		clickByXpath("//button[text()='Find Leads']");
		
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]
	}
	
@DataProvider(name="findcaseGetData")
	
	public Object[][] editGetDataFromExcel() throws InvalidFormatException, IOException
	{
		ReadFromExcel rfe=new ReadFromExcel();
		Object[][] obj =rfe.readExcelData("FindLead");
		return obj;
		
	}
}
