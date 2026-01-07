package generic;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class All_Verications 
{
	WebDriver driver = null; 
	
	public All_Verications(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public static void verifyTitleMatch(String expectedTitle, WebDriver driver, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.titleIs(expectedTitle));

            String actualTitle = driver.getTitle();
            System.out.println("Title matched. Expected: " + expectedTitle + " | Found: " + actualTitle);

            // Soft assertion to verify titles match
            sa.assertEquals(actualTitle, expectedTitle, "Title does not match!");
        } catch (Exception ex) {
            ex.printStackTrace();

            String actualTitle = driver.getTitle();
            System.out.println("❌ Title did not match.");
            System.out.println("Expected: " + expectedTitle + " | Found: " + actualTitle);

            TakeScreenshot.getScreenshot(driver);
            // Report failure to soft assert so it doesn’t halt execution
            sa.fail("Title mismatch or wait timeout. Expected: " + expectedTitle + ", but found: " + actualTitle);
        }
    }
    
    
    public static void verifyUrleMatch(String expectedUrl, WebDriver driver, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.urlContains(expectedUrl.trim()));

            String actualUrl = driver.getCurrentUrl().trim();
            String expected = expectedUrl.trim();

            System.out.println("🔍 Verifying URL match:");
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + actualUrl);

            sa.assertEquals(actualUrl, expected, "❌ URL does not match!");
            System.out.println("URL matched successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();

            String actualUrl = driver.getCurrentUrl().trim();
            System.out.println("URL did not match.");
            System.out.println("Expected: " + expectedUrl);
            System.out.println("Found   : " + actualUrl);

            TakeScreenshot.getScreenshot(driver);
            sa.fail("URL mismatch or wait timeout. Expected: " + expectedUrl + ", but found: " + actualUrl);
        }
    }

    
    
    
    public static void clickIfVisibleAndEnabled(WebElement element, WebDriver driver, SoftAssert sa, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait until element is visible
            wait.until(ExpectedConditions.visibilityOf(element));
            // Wait until element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
                System.out.println("Clicked on element: " + elementName);
                sa.assertTrue(true, "Element clicked successfully: " + elementName);
            } else {
                System.out.println("Element not clickable: " + elementName);
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Element is either not visible or not enabled: " + elementName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception while clicking on element: " + elementName);
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception occurred while clicking: " + elementName);
        }
    }

    
//    public static void verifyTextPresent(String expectedText, WebDriver driver, SoftAssert sa) {
//        try {
//            if (driver.getPageSource().contains(expectedText)) {
//                System.out.println("✅ Text found: '" + expectedText + "'");
//                sa.assertTrue(true, "Text is present: " + expectedText);
//            } else {
//                System.out.println("❌ Text NOT found: '" + expectedText + "'");
//                TakeScreenshot.getScreenshot(driver);
//                sa.fail("Expected text not found: " + expectedText);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("❌ Exception while verifying text presence: " + expectedText);
//            TakeScreenshot.getScreenshot(driver);
//            sa.fail("Exception during text presence check: " + expectedText);
//        }
//    }
    
    
    // if we dont want case sentitive verification for the text is present or not. 
    public static void verifyTextPresent(String expectedText, WebDriver driver, SoftAssert sa) {
        try {
            String pageSourceLower = driver.getPageSource().toLowerCase();
            String expectedLower = expectedText.toLowerCase();

            if (pageSourceLower.contains(expectedLower)) {
                System.out.println(" Text found (case-insensitive): '" + expectedText + "'");
                sa.assertTrue(true, "Text is present (case-insensitive): " + expectedText);
            } else {
                System.out.println(" Text NOT found: '" + expectedText + "'");
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Expected text not found (case-insensitive): " + expectedText);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(" Exception during text verification: " + expectedText);
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception during text presence check: " + expectedText);
        }
    }


    public static void verifyTextNotPresent(String unexpectedText, WebDriver driver, SoftAssert sa) {
        try {
            if (!driver.getPageSource().contains(unexpectedText)) {
                System.out.println(" Text correctly NOT present: '" + unexpectedText + "'");
                sa.assertTrue(true, "Text is not present: " + unexpectedText);
            } else {
                System.out.println(" Unexpected text IS present: '" + unexpectedText + "'");
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Unexpected text found: " + unexpectedText);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(" Exception while verifying absence of text: " + unexpectedText);
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception during text absence check: " + unexpectedText);
        }
    }

    
    
    public static boolean verifyAlertIsPresentMoveToAlert(WebDriver driver, SoftAssert sa) 
    {
        boolean alertResult = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try 
        {
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("[INFO] Alert is present. Switching to alert...");
            // ✅ Switch to the alert and get the Alert object
            Alert alert = driver.switchTo().alert();
            // ✅ (Optional) You can print alert text if needed
            System.out.println("[INFO] Alert text: " + alert.getText());
            alertResult = true;
        } 
        catch (Exception ex) 
        {
            System.out.println("[WARN] Alert is not present after waiting.");
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Expected alert is not present on the page.");
        }
        return alertResult;
    }
}
























