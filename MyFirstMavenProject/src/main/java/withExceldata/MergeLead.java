package withExceldata;

import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class MergeLead extends GenericWrappers{

	@Test(groups="Regression",dependsOnGroups="Sanity")
	public void findLead()
	{
		invokeApp("chrome", "http://leaftaps.com/opentaps");

		enterById("username", "DemoSalesManager");

		enterById("password", "crmsfa");

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");

		clickByLink("Leads");
		
		clickByLink("Merge Leads");
		
		clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		
		switchToLastWindow();
		
		enterByXpath("//input[@name='firstName']", "Karpagam");
		
		clickByXpath("//button[text()='Find Leads']");
		
		String fromLeadText=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		switchToParentWindow();
		
		clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		
		switchToLastWindow();
		
		enterByXpath("//input[@name='firstName']", "Karpagam");
		
		clickByXpath("//button[text()='Find Leads']");
		
		String toLeadText=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[3]");
		
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[3]");
		
		switchToParentWindow();
		
		clickByLinkNoSnap("Merge");
		
		acceptAlert();
		
		clickByLink("Find Leads");
		
		enterByXpath("//input[@name='id']",fromLeadText );
		
		clickByXpath("//button[text()='Find Leads']");

		String info=getTextByXpath("//div[@class='x-paging-info']");
		
		if(info.equals("No records to display"))
		{
			System.out.println("merging success");
		}
		else
			System.err.println("Merging failed");
		
		closeBrowser();
		
	}

}
