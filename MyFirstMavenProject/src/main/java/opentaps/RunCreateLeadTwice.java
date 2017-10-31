package opentaps;

import org.openqa.selenium.chrome.ChromeDriver;

public class RunCreateLeadTwice {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps");
			driver.findElementById("username").sendKeys("DemoSalesManager");
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByLinkText("Create Lead").click();
			driver.findElementById("createLeadForm_companyName").sendKeys("Cognizant Technology Solutions");
			driver.findElementById("createLeadForm_firstName").sendKeys("Karpagam");
			driver.findElementById("createLeadForm_lastName").sendKeys("Karunanithi");
			System.out.println("number of time: "+i+1);

		}

	}

}
