package homepage_scenarios_saritha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class InvalidEmail implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = null;
		try {
			// open browser.
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open homepage
			driver.get(urlOfHomepage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// expectedTitle
			String expectedTitle = "Login | ECODERS";

			// find the  link. in the homepage.
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Wait until the login link is visible and then click
			WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
			emailField.sendKeys("saritha@gmail.com");


			WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
			passwordField.sendKeys("sfgdsfgdfsgdsfgsdfgdfsgdfsg");

			WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
			signInButton.click();

			// actual title and url of the opened page.
			System.out.println("Actual title of login page :" + driver.getTitle());
			System.out.println("Actual url of login page :" + driver.getCurrentUrl());

			try {
				wait.until(ExpectedConditions.titleIs(expectedTitle));
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
			Thread.sleep(2000);
			driver.quit();
		}
	}
}