package scripts.homepage_scenarios.funtional_scenarios;

import generic.AutomationConstants;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_1383_OpenHompageUsingUrl implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
		// open the chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the url and open the web page / homepage. 
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// confirm whether homepage is opened or not , by verifying the title or url 
		String actualTitle = driver.getTitle();
		String actualUrl  = driver.getCurrentUrl();
		
		String expectedTitle = "Home | ECODERS";    // this will be given in the requirement
		String expectedUrl = "http://localhost:5173"; // this will be given in the requirement
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test case passed, Title is matcing.");
		}
		else
		{
			System.out.println("Test case failed, Title is not matcing.");
		}
		
		Thread.sleep(4000);
		// close the browser
		driver.quit();
	}
}