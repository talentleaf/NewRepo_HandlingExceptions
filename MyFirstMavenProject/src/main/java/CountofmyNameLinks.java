import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountofmyNameLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://google.com");
	
		driver.findElementByXPath("//*[@id='lst-ib']").sendKeys("karpagam",Keys.ENTER);
		//driver.findElementByName("btnK").click();
		System.out.println(driver.getCurrentUrl());
		List <WebElement> allLinks=driver.findElementsByTagName("a");
		System.out.println(allLinks.size());
		
		int count=0;
		for(WebElement linkcontainskarpagam:allLinks)
		{
			String text=linkcontainskarpagam.getText();
			System.out.println(text);
			if(text.contains("karpagam")||text.contains("Karpagam"))
			{
				//int count=0;
				count=count+1;
				//System.out.println(text);
			}
			
		}
		
		System.out.println("count of links that contains karpagam"+count);
		
	}

}
