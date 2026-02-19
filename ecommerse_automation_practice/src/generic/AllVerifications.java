package generic;

import java.time.Duration;

import org.openqa.selenium.Alert;
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
			if(textVerified == true)
			{
				System.out.println("Text is matching " + expectedText + " Found : "+ element.getText());
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Text not matching " + expectedText + " Found : "+ element.getText());
		}
		return textVerified;
	}
	
	
	public static boolean clickOnElementIfVisibleAndEnabled(WebDriver driver, WebElement element)
	{
		boolean elementClicked = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			elementClicked = true; 
			System.out.println("Element clicked successfully : " + element);
			
		}
		catch(Exception ex)
		{
			System.out.println("Element is not clickable or Visible : "+ element);
			ex.printStackTrace();
		}
		return elementClicked;
	}
	
	public static boolean handleAlertIfAlertIsPresentAndAccept(WebDriver driver)
	{
		boolean alertHandled = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try
		{
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert is handeled successfully, navigating to next page.");
		}
		catch(Exception ex)
		{
			System.out.println("Unable to handle the alert.");
			ex.printStackTrace();
		}
		return alertHandled;
	}

}
