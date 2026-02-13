package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications 
{
	// function to verify the title of the page. 
	public static boolean verifyTitleOfWebpage(WebDriver driver, String expectedTitle)
	{
		boolean titleVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			titleVerified = true;
		}
		catch(Exception ex)
		{
			System.out.println("Title not matching " + expectedTitle + " Found : "+ driver.getTitle());
		}
		return titleVerified;
	}
}
