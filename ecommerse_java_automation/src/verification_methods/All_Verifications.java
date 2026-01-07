//package verification_methods;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.SoftAssert;
//
//import screenshots.TakeScreenshot;
//
//public class All_Verifications
//{
//  public void verifyTitleMatch(String expectedTitle , WebDriver driver, SoftAssert sa)
//  {
//	  // make the object of the WebDriverWait class.
//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	  try
//	  {
//		  wait.until(ExpectedConditions.titleIs(expectedTitle));
//		  System.out.println("Title is matchin,: "+ expectedTitle + "Matched with  : " + driver.getTitle());
//	  }
//	  catch(Exception ex)
//	  {
//		  ex.printStackTrace();
//		  System.out.println("Test case failed, Title did not match.");
//		  System.out.println("Expected title : "+ expectedTitle + " , But Found : " + driver.getTitle() );
//		  // take the screenshot.
//		  TakeScreenshot.getScreenshot(driver);;
//	  }
//  }
//}

// till here without the softassert.
// now with soft assert code.


package verification_methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import screenshots.TakeScreenshot;

public class All_Verifications {

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
            System.out.println("Title did not match.");
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
            System.out.println("Verifying URL match:");
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + actualUrl);
            sa.assertEquals(actualUrl, expected, "URL does not match!");
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

    public static void verifyIfElementVisibleAndEnabled(WebElement element, WebDriver driver, SoftAssert sa, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait until element is visible
            wait.until(ExpectedConditions.visibilityOf(element));
            // Wait until element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (element.isDisplayed() && element.isEnabled())
            {
                sa.assertTrue(true, "Element is displayed and Enabled: " + elementName);

            } else {
                System.out.println("Element not enabled and displayed: " + elementName);
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Element is either not visible or not enabled: " + elementName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception while checking on element: " + elementName);
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception occurred while checking for visibility and enabled.: " + elementName);
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

    public static void verifyTextPresentCaseSensitive(WebElement element, String expectedText, WebDriver driver, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText)); // Partial check, not strict

            String actualText = element.getText();

            if (actualText.equals(expectedText)) { // Full strict case-sensitive check
                System.out.println("Text found (case-sensitive): '" + expectedText + "'");
                sa.assertTrue(true, "Text is present (case-sensitive): " + expectedText);
            } else {
                System.out.println("Text mismatch. Expected: '" + expectedText + "', Found: '" + actualText + "'");
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Expected text not found (case-sensitive). Found: '" + actualText + "'");
            }

        } catch (Exception ex) {
            System.out.println("Exception while verifying text: '" + expectedText + "'");
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception during text presence check (case-sensitive): " + expectedText);
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

    public static void verifyCartItemCount(WebDriver driver, By locator, int expectedCount, SoftAssert sa) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	try {

            wait.until(ExpectedConditions.numberOfElementsToBe(locator, expectedCount));

            int actual = driver.findElements(locator).size();
            System.out.println("Cart has expected item count: " + actual);
            sa.assertEquals(actual, expectedCount, "Cart item count mismatch.");
        } catch (Exception ex) {
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Cart did not reach expected count: " + expectedCount);
        }
    }


    public static void verifyElementCount(WebDriver driver, By locator, int expectedCount, SoftAssert sa) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.numberOfElementsToBe(locator, expectedCount));

            int actual = driver.findElements(locator).size();
            System.out.println("Found " + actual + " elements for locator: " + locator);
            sa.assertEquals(actual, expectedCount, "Element count mismatch for locator: " + locator);
        } catch (Exception ex) {
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Expected " + expectedCount + " elements, but check failed for locator: " + locator);
        }
    }


    // Compares actual and expected count and logs result
    public static void verifyCountMatch(int expectedCount, int actualCount, WebDriver driver, SoftAssert sa) {
        try {
            if (actualCount == expectedCount) {
                System.out.println("Count matched: Expected = " + expectedCount + ", Actual = " + actualCount);
                sa.assertTrue(true, "Count matched successfully.");
            } else {
                System.out.println("❌ Count mismatch: Expected = " + expectedCount + ", Actual = " + actualCount);
                TakeScreenshot.getScreenshot(driver);
                sa.fail("Count mismatch! Expected: " + expectedCount + ", but got: " + actualCount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception during count verification.");
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Exception during count check. Expected: " + expectedCount + ", Actual: " + actualCount);
        }
    }

    public static void verifyAndTypeInputField(WebDriver driver, WebElement inputField, String textToType, String fieldName, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Step 1: Visibility
            wait.until(ExpectedConditions.visibilityOf(inputField));
            sa.assertTrue(inputField.isDisplayed(), fieldName + " is visible");

            // Step 2: Enabled (interactable)
            sa.assertTrue(inputField.isEnabled(), fieldName + " is enabled");

            // Step 3: Clear existing value (optional)
            inputField.clear();

            // Step 4: Type text
            inputField.sendKeys(textToType);

            // Step 5: Verification (value typed successfully)
            String typedValue = inputField.getAttribute("value");
            sa.assertEquals(typedValue, textToType, fieldName + " value verification after typing");

            // Step 6: Log success
            System.out.println("✅ Typed '" + textToType + "' into " + fieldName + " successfully.");

        } catch (Exception ex) {
            System.out.println("❌ Failed to type into " + fieldName + ": " + ex.getMessage());
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("Failed to type into " + fieldName + ": " + ex.getMessage());
        }
    }

    public static void verifyElementInvisibility(WebDriver driver, By locator, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            System.out.println("✅ Element is now invisible or removed: " + locator);
            sa.assertTrue(true, "Element is invisible as expected: " + locator);
        } catch (Exception ex) {
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("❌ Element is still visible or not removed: " + locator);
        }
    }

    public static void verifyAllElementsInvisibility(WebDriver driver, List<WebElement> elements, SoftAssert sa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
            System.out.println("✅ All elements are now invisible or removed.");
            sa.assertTrue(true, "All elements are invisible as expected.");
        } catch (Exception ex) {
            ex.printStackTrace();
            TakeScreenshot.getScreenshot(driver);
            sa.fail("❌ Some elements are still visible or not removed.");
        }
    }
}