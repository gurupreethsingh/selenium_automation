package homepage_sindhu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class O1_InvalidLoginUsingWroungPwd {

	public static void main(String[] args) {
		WebDriver driver=null;
		try
		{
			driver=new ChromeDriver();
			driver.get("http://localhost:5173/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			WebElement emailfeiled =driver.findElement(By.xpath("//input[@type='email']"));
			emailfeiled.sendKeys("sindhugowda31@gmail.com");
			WebElement pwsfeild=driver.findElement(By.xpath("//input[@type='password']"));
			pwsfeild.sendKeys("sindhu");
			WebElement loginlink=driver.findElement(By.xpath("//button[@type='submit']"));
			loginlink.click();
			String expectedtext="Login failed. Try again.";
			WebElement actualText=driver.findElement(By.xpath("//div/p[@class='errorText mb-4']"));
			System.out.println(actualText.getText());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
			    wait.until(ExpectedConditions.titleIs(expectedtext));
			} catch (Exception ex) {
			    // Clean handling — no stack trace
			    System.out.println("Test failed: Expected text did not match. Screenshot captured.");
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
