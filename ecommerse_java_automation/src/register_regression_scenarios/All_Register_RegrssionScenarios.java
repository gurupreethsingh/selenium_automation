package register_regression_scenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation_scripts.AutomationConstants;
import excel_automation.O3_ReadFromExcel;

public class All_Register_RegrssionScenarios implements AutomationConstants
{
	WebDriver driver = null;

	@BeforeMethod
	public void openApplication()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(urlOfRegister);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());
	}

	@Test(priority = 1, invocationCount = 1)
	public void runClickOnLogo()
	{
			WebElement logo = driver.findElement(By.xpath("//a[text()='LOGO']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logo.click();

			System.out.println("Actual title :" + driver.getTitle());
			System.out.println("Actual url :" + driver.getCurrentUrl());
	}

	@Test(priority = 2)
	public void runClickOnLogin()
	{
			WebElement logo = driver.findElement(By.xpath("//a[text()='Login']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logo.click();

			System.out.println("Actual title :" + driver.getTitle());
			System.out.println("Actual url :" + driver.getCurrentUrl());
	}

	@Test(enabled = false)
	public void runAllInvalidEmail() throws  IOException, InterruptedException
	{
		for ( int i = 0; i<= 20; i++)
		{
		WebElement nameField = driver.findElement(By.id("name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		nameField.sendKeys("Person1");

			WebElement emailField = driver.findElement(By.id("email"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			 String wrongEmails = O3_ReadFromExcel.getData("Sheet1", i, 0);
			emailField.sendKeys(wrongEmails);

		WebElement passwordField = driver.findElement(By.id("password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		passwordField.sendKeys("Person1");

		WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		registerButton.click();


		try {
		    WebElement errorMessage = driver.findElement(By.xpath("//p[@class='errorText mb-4']"));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    System.out.println("Error Message: " + errorMessage.getText());
		} catch (Exception e) {
		    System.out.println("No error message displayed, moving to next scenario...");
		}

		Thread.sleep(500);
		// Clear using key simulation instead of clear()
		WebElement nameFieldClear = driver.findElement(By.id("name"));
		nameFieldClear.sendKeys(Keys.CONTROL + "a");
		nameFieldClear.sendKeys(Keys.DELETE);

		WebElement emailFieldClear = driver.findElement(By.id("email"));
		emailFieldClear.sendKeys(Keys.CONTROL + "a");
		emailFieldClear.sendKeys(Keys.DELETE);

		WebElement passwordFieldClear = driver.findElement(By.id("password"));
		passwordFieldClear.sendKeys(Keys.CONTROL + "a");
		passwordFieldClear.sendKeys(Keys.DELETE);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String expectedTitle = "Register | ECODERS";

		System.out.println("Actual title :" + driver.getTitle());
		System.out.println("Actual url :" + driver.getCurrentUrl());

		if(expectedTitle.equals(driver.getTitle())){
			System.out.println("Tc Pass");
		}
		else
		{
			System.out.println("Falied");
		}

		}
	}

	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
	}

}
