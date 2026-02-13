package scripts.shoppge.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutomationConstants;

public class AS_01_OpenShoppageUsingUrl implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
		// open chrome 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the shop page url
		driver.get(urlOfShopAllPage);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verify shop page is open or not.
		System.out.println(driver.getTitle());
		// find the logo in header of shoppage.
		// click on the logo 
		// verify homepage is opened or not. 
		
		
		Thread.sleep(3000);
		// close the browser
		driver.quit();
	}
}
