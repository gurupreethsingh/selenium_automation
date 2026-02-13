package scripts.homepage_scenarios.funtional_scenarios;

import generic.AutomationConstants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_1383_OpenHompageUsingUrl2 implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
		// open the chrome browser
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		// enter the url and open the web page / homepage. 
//		driver.get(urlOfApplication);
		
		driver.navigate().to(urlOfApplication);
		
		driver.manage().window().maximize();
		
		System.out.println("The window handle number of the tab is, :");
		System.out.println(driver.getWindowHandle());
		
		System.out.println(driver.getWindowHandles());
		
//		driver.switchTo("");
		
		System.out.println("The title of the current page is : " + driver.getTitle());
		System.out.println("The url of the page is : "+ driver.getCurrentUrl());

	}
}