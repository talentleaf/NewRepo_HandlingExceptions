package tests;

import org.testng.annotations.Test;

import wrapper.GenericWrappers;

public class IRCTC_NestedWindows extends GenericWrappers {
	
	@Test
	public void nestingWindows()
	{
		invokeApp("chrome", "https://www.irctc.co.in/eticketing/loginHome.jsf");
		clickByLinkNoSnap("Alerts & Updates");
		switchToLastWindow();
		clickByLinkNoSnap("/html/body/div/div/div[3]/font/font/span[3]/h5/a");
		switchToLastWindow();
		verifyCurrentURL("http://contents.irctc.co.in/en/GstCircular.pdf");
		switchToParentWindow();
		clickByLinkNoSnap("Contact Us");
		switchToLastWindow();
		verifyTextContainsByXpath("//*[text()='Fax no. : ']", "Fax no. :");
	}

}
