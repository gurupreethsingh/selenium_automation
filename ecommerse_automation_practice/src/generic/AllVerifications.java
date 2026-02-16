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
	
	public static boolean verifyUrlOfWebpage(WebDriver driver, String expectedUrl)
	{
		boolean urlVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.urlMatches(expectedUrl));
			urlVerified = true;
		}
		catch(Exception ex)
		{
			System.out.println("Url not matching " + expectedUrl + " Found : "+ driver.getCurrentUrl());
		}
		return urlVerified;
	}
	
	
	public static boolean verifyTextPresent(WebDriver driver, String expectedText, WebElement element)
	{
		boolean textVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			textVerified = true;
		}
		catch(Exception ex)
		{
			System.out.println("Text not matching " + expectedText + " Found : "+ element.getText());
		}
		return textVerified;
	}
}
