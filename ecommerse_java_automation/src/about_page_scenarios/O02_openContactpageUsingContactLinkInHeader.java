package about_page_scenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class O02_openContactpageUsingContactLinkInHeader {

	public static void main(String[] args)
	{
			WebDriver driver=null;
			try
			{
				driver=new ChromeDriver();
				driver.get("http://localhost:5173/login");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				WebElement emailfeiled =driver.findElement(By.xpath("//input[@type='email']"));
				emailfeiled.sendKeys("igurupreeth@gmail.com");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement pwsfeild=driver.findElement(By.xpath("//input[@type='password']"));
				pwsfeild.sendKeys("abc123ABC!@#");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement loginlink=driver.findElement(By.xpath("//button[@type='submit']"));
				loginlink.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				String expectedTitle = "SuperAdmin Dashboard | ECODERS";
			    String actualTitle=driver.getTitle();
			    System.out.println("Actual Dashboard title is " + actualTitle);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				try {
				    wait.until(ExpectedConditions.titleIs(expectedTitle));
				    System.out.println("Test case passed, Title matched");

				    driver.navigate().to("http://localhost:5173/about-us");

				    // find the about us link, from header.
				    WebElement contactUsLink = driver.findElement(By.xpath("//a[@href='/contact-us']"));
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				    contactUsLink.click();
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				    String expectedAboutTitle = "Contact Us | ECODERS";
				    String actualPageTitle = driver.getTitle();
				    System.out.println("Actual title of page is " + actualPageTitle);

				    try
				    {
				    	wait.until(ExpectedConditions.titleIs(expectedAboutTitle));
					    System.out.println("Test case passed, Title matched");
				    }
				    catch(Exception ex)
				    {
				    	System.out.println("Test failed: Expected Title did not match. Screenshot captured.");
					    TakeScreenshot.getScreenshot(driver);
					    System.out.println("Testcase failed screenshot stored.");
				    }


				} catch (Exception ex) {
				    // Clean handling — no stack trace
				    System.out.println("Test failed: Expected Title did not match. Screenshot captured.");
				    TakeScreenshot.getScreenshot(driver);
				    System.out.println("Testcase failed screenshot stored.");

				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				driver.quit();
			}

		}
}
