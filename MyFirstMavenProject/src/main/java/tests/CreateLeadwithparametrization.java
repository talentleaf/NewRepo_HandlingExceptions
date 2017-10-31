package tests;

import java.sql.Driver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;
import wrapper.LeafTapWrappers;

public class CreateLeadwithparametrization extends LeafTapWrappers{
	@Test(dataProvider="createleadvalues")
	public void createLead(String companyName,String firstName, String lastName) {

		clickByLink("Create Lead");
		enterById("createLeadForm_companyName",companyName);
		enterById("createLeadForm_firstName",firstName);
		enterById("createLeadForm_lastName",lastName);
		clickByName("submitButton");
		
	}

@DataProvider(name="createleadvalues")

public Object[][] getCreateLeadTestData()
{
	Object[][] getData=new Object[][]{
		{"CTS","karpagam","k"},
		{"wipro","keerthi","e"},
		{"infy","nirmala","a"},
		{"TCS","vignesh","s"}		
	};
	return getData;
	
}


}


