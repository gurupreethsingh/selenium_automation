package scripts.homepage_scenarios.funtional_scenarios;

import generic.AutomationConstants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_1383_OpenHompageUsingUrl implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
		// open the chrome browser
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		// enter the url and open the web page / homepage. 
		driver.get(urlOfApplication);
		Thread.sleep(1000);
		// confirm whether homepage is opened or not , by verifying the title or url 
		String actualTitle = driver.getTitle();
		String actualUrl  = driver.getCurrentUrl();
		
		String expectedTitle = "Home | ECODERS";
		String expectedUrl = "http://localhost:5173";
		
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