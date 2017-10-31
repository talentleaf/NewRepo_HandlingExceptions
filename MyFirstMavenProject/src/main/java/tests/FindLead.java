package tests;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class FindLead extends GenericWrappers{

	@Test(groups="Sanity", dependsOnGroups="Smoke")
	public void findLead()
	{
		
		invokeApp("chrome", "http://leaftaps.com/opentaps");

		enterById("username", "DemoSalesManager");

		enterById("password", "crmsfa");

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");

		clickByLink("Leads");
		
		clickByLink("Find Leads");
		
		enterByXpath("(//input[@name='firstName'])[3]", "Karpagam");
		
		clickByXpath("//button[text()='Find Leads']");
		
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]
		
		closeBrowser();
		
		
		
		
		



	}

}
