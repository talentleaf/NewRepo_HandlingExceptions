package tests;

import java.sql.Driver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wrapper.GenericWrappers;
import wrapper.LeafTapWrappers;

public class ParameterSample extends GenericWrappers{
	@Parameters("PhoneNumber")
	@Test
	public void createLead(@Optional("044") int index) {

		invokeApp("chrome", "http://leaftaps.com/opentaps");

		enterById("username", "DemoSalesManager");

		enterById("password", "crmsfa");

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");
		//Click Create Lead
		clickByLink("Create Lead");

		//To fill mandatory fields in create lead page

		enterById("createLeadForm_companyName","Cognizant Technology Solutions");

		enterById("createLeadForm_firstName","Karpagam");
		enterById("createLeadForm_lastName","Karunanithi");
		
	}




}


