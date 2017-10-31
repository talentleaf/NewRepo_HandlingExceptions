package withExceldata;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import simple_java_programs.ReadFromExcel;
import wrapper.GenericWrappers;
import wrapper.LeafTapWrappers;

public class EditLead extends LeafTapWrappers{

	@Test(dataProvider="editcaseGetData")
	public void editLeadGetDataFromExcel(String firstname,String newCompanyName)
	{
		clickByLink("Leads");
		
		clickByLink("Find Leads");
		
		enterByXpath("(//input[@name='firstName'])[3]", firstname);
		
		clickByXpath("//button[text()='Find Leads']");
		
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		boolean titleValidation=verifyTitle("View Lead | opentaps CRM");
		
		clickByLink("Edit");
		
		enterById("updateLeadForm_companyName",newCompanyName);
		
		clickByXpath("//input[@name='submitButton']");
		
		String companyNameText=getTextById("viewLead_companyName_sp");
		
		/*String subText=companyNameText.substring(2);
		System.out.println(subText);*/
		
		if(companyNameText.contains(newCompanyName))
		{
			System.out.println("Company NAme filed is updated successfully with "+companyNameText);
			
			
		}
		else
		{
			System.err.println("Company NAme filed is not updated successfully");
		}
			
			}
	
	@DataProvider(name="editcaseGetData")
	
	public Object[][] editGetDataFromExcel() throws InvalidFormatException, IOException
	{
		ReadFromExcel rfe=new ReadFromExcel();
		Object[][] obj =rfe.readExcelData("EditLead");
		return obj;
		
	}

}
