package homepage_scenarios;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class O6_OpenTwitterClickTwitterLinkFooter implements AutomationConstants {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			// open browser.
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open homepage
			driver.get(urlOfHomepage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Save parent window handle (homepage handle)
			String parentWindow = driver.getWindowHandle();

			// find the  link. in the homepage to click
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Wait until the login link is visible and then click
			WebElement tLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.twitter.com']")));
			tLink.click();

			// get all the window handles. after clicking on the fb link.
			Set<String> allHandles = driver.getWindowHandles();

			// now leaving the parent window
			for(String eachChildWindow : allHandles)
			{
				if(!eachChildWindow.equals(parentWindow))
				{
					driver.switchTo().window(eachChildWindow);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					break;
				}
			}
			wait.until(driver1 -> !driver1.getTitle().isEmpty());

			// actual title and url of the opened page.
			System.out.println("Actual title of page : " + driver.getTitle());
			System.out.println("Actual url of  page :" + driver.getCurrentUrl());

			try {
				wait.until(ExpectedConditions.titleIs("Instagram"));
				System.out.println("Test case passed, Title of page is matching.");
			} catch (Exception ex) {
				// Clean handling — no stack trace
				System.out.println("Test failed: Expected title did not match. Screenshot captured.");
				TakeScreenshot.getScreenshot(driver);
				System.out.println("Testcase failed screenshot stored.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
