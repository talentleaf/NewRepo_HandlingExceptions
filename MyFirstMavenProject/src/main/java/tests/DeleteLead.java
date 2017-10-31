package tests;

import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class DeleteLead extends GenericWrappers{

	@Test
	public void findLead()
	{
		invokeApp("chrome", "http://leaftaps.com/opentaps");

		enterById("username", "DemoSalesManager");

		enterById("password", "crmsfa");

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");

		clickByLink("Leads");
		
		clickByLink("Find Leads");
		
		clickByXpath("//span[text()='Phone']");
		
		enterByXpath("//input[@name='phoneAreaCode']", "044");
		
		enterByXpath("//input[@name='phoneNumber']", "49596512");
		
		clickByXpath("//button[text()='Find Leads']");
		
		String leadID=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		clickByLink("Delete");
		
		clickByLink("Find Leads");
		
		enterByXpath("//input[@name='id']",leadID );
		
		clickByXpath("//button[text()='Find Leads']");

		String info=getTextByXpath("//div[@class='x-paging-info']");
		
		if(info.equals("No records to display"))
		{
			System.out.println("Record deleted successfully");
			closeBrowser();
		}
		else
			System.err.println("Deletion failed");
		
			}

}
