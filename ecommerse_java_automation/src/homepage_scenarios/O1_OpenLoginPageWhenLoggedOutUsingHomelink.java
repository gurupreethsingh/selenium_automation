package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class O1_OpenLoginPageWhenLoggedOutUsingHomelink implements AutomationConstants
{
	public static void main(String[] args)
	{
		WebDriver driver = null;
		try
		{
			// open browser.
			driver = new ChromeDriver() ;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open homepage
			driver.get(urlOfHomepage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// expectedTitle
			System.out.println("Expected title :" + "Login | ECODERS");
			System.out.println("Actual title of login page :" + driver.getTitle());
			System.out.println("Actual url of login page :" + driver.getCurrentUrl());
			String expectedTitle = "Login | ECODER";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
			    wait.until(ExpectedConditions.titleIs(expectedTitle));
			} catch (Exception ex) {
			    // Clean handling — no stack trace
			    System.out.println("Test failed: Expected title did not match. Screenshot captured.");
			    TakeScreenshot.getScreenshot(driver);
			    System.out.println("Testcase failed screenshot stored.");
			}
		}
		catch(Exception ex)		{
			ex.printStackTrace();
		}
		finally		{
			driver.quit();
		}
	}
}
