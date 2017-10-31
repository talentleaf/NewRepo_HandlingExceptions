package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LeafTapWrappers extends GenericWrappers {
	
@Parameters({"URL","UserName","Password","Browser"})
@BeforeMethod
	public void login(String urlName,String userNameData,String passwordData,String browserData)
	{
		invokeApp(browserData, urlName);

		enterById("username", userNameData);

		enterById("password", passwordData);

		clickByClassName("decorativeSubmit");

		clickByLink("CRM/SFA");
	}

@AfterMethod
public void close()
{
	closeBrowser();
}

}
