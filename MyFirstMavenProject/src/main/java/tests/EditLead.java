package tests;

import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class EditLead extends GenericWrappers{

	@Test(groups="Regression",dependsOnGroups="Sanity")
	public void findLead()
	{
		invokeApp("chrome", "http://leaftaps.com/opentaps");

		enterById("username", "DemoSalesManager");

		enterById("password", "crmsfa");

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");

		clickByLink("Leads");
		
		clickByLink("Find Leads");
		
		enterByXpath("(//input[@name='firstName'])[3]", "karpagam");
		
		clickByXpath("//button[text()='Find Leads']");
		
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		boolean titleValidation=verifyTitle("View Lead | opentaps CRM");
		
		clickByLink("Edit");
		
		String newCompanyName="CTS";
		
		enterById("updateLeadForm_companyName",newCompanyName);
		
		clickByXpath("//input[@name='submitButton']");
		
		String companyNameText=getTextById("viewLead_companyName_sp");
		
		String subText=companyNameText.substring(2);
		System.out.println(subText);
		
		if(companyNameText.contains(newCompanyName))
		{
			System.out.println("Company NAme filed is updated successfully with "+companyNameText);
			
			
		}
		else
		{
			System.err.println("Company NAme filed is not updated successfully");
		}
		
		closeBrowser();
			
			}

}
