package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AllVerifications 
{
	protected WebDriver driver;
	
	protected AllVerifications(WebDriver driver)
	{
		this.driver = driver;
	}

	public static boolean verifyTitle(String expectedTitle, WebDriver driver, SoftAssert sa)
	{
		boolean isTitleVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			isTitleVerified = true;
			System.out.println("Title Vefication successfull, expected title : "+ expectedTitle + " Actual title : "+ driver.getTitle());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Title Vefication failed, expected title : "+ expectedTitle + " Actual title : "+ driver.getTitle());
			TakingScreenshot.captureScreenshot(driver);
		}
		return isTitleVerified; 
	}
	
	
	
	
	public static boolean verifyUrl(String expectedUrl, WebDriver driver , SoftAssert sa)
	{
		boolean urlVerified = false;
		
		WebDriverWait wait = new WebDriverWait( driver,Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.urlMatches(expectedUrl));
			if(driver.getCurrentUrl().equals(expectedUrl))
			{
				urlVerified =true;
				System.out.println("Url verification passed , expected url was : "+expectedUrl +" , Url found : "+ driver.getCurrentUrl());
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Url verification failed , expected url was : "+expectedUrl +" , Url found : "+ driver.getCurrentUrl());
			TakingScreenshot.captureScreenshot(driver);
		}
		return urlVerified;
	}
	
	
	
	public static boolean textIsPresentOrNot(String expectedText, WebDriver driver, WebElement element , SoftAssert sa)
	{
		boolean textVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			 wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			System.out.println("Text verification passed , expected text was : "+expectedText +" , Actal text found : "+ element.getText());
			textVerified = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Text verification failed , expected text was : "+expectedText +" , Actal text found : "+ element.getText());
			TakingScreenshot.captureScreenshot(driver);
			
		}
		return textVerified; 
	}
	
	
	
	 public static boolean textIsPresentOrNotIgnoreCase(String expectedText, WebDriver driver, By locator , SoftAssert sa) 
	    {
	        boolean textVerified = false; 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        try 
	        {
	            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, expectedText)));
	            String actualText = driver.findElement(locator).getText().trim();

	            if (actualText.equalsIgnoreCase(expectedText.trim())) 
	            {
	                System.out.println("Text verification passed. Expected: " + expectedText + " , Actual: " + actualText);
	                textVerified = true;
	            } 
	            else 
	            {
	                System.out.println("Text verification failed. Expected: " + expectedText + " , Actual: " + actualText);
	                TakingScreenshot.captureScreenshot(driver);
	            }
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	            System.out.println("Text verification failed (exception). Expected: " + expectedText + " , Actual: " + driver.findElement(locator).getText());
	            TakingScreenshot.captureScreenshot(driver);
	        }

	        return textVerified;
	    }


	
	
	
	
//	public static boolean clickIfVisibleAndEnabled(WebElement element, WebDriver driver)
//	{
//		boolean clicked = false;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		
//		
//		try
//		{
//			wait.until(ExpectedConditions.visibilityOf(element));
//			// check if its present and enabled. 
//			wait.until(ExpectedConditions.presenceOfElementLocated(null));  // elemt is present and enabled
//			
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			
//			clicked= true; 
//			System.out.println("Element clicked : "+ element);
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			System.out.println("Unable to click on the element : "+ element);
//			TakingScrenshot.captureScreenshot(driver);
//			
//		}
//		
//		return clicked; 
//	}
	
	
	
	public static boolean clickIfVisibleAndEnabled(WebElement element, WebDriver driver , SoftAssert sa) 
	{
        boolean clicked = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Check if element is present in DOM by catching StaleElementReferenceException
            if (element != null) {

                // Wait until visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Check if element is displayed and enabled
                if (element.isDisplayed() && element.isEnabled()) {

                    // Wait until element is clickable
                    wait.until(ExpectedConditions.elementToBeClickable(element));

                    // Perform click
                    element.click();
                    clicked = true;
                    System.out.println("Element clicked: " + element);
                } else {
                    System.out.println("Element is not displayed or not enabled: " + element);
                }

            } else {
                System.out.println("Element is null. Possibly not found in DOM.");
            }

        } catch (Exception ex) {
            System.out.println("Unable to click on the element: " + element);
            ex.printStackTrace();
            TakingScreenshot.captureScreenshot(driver);
        }

        return clicked;
    }
	
	
	
	public static boolean verifyTotalNumberOfElements(int expectedCount, WebDriver driver, By allButtons , SoftAssert sa)
	{
		boolean countVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			 wait.until(ExpectedConditions.numberOfElementsToBe(allButtons,  expectedCount));
			 int actualCount = driver.findElements(allButtons).size();
			System.out.println("Count matching TC passed , expected count was : "+expectedCount +" , Actal Count found : "+ actualCount);
			countVerified = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			int actualCount = driver.findElements(allButtons).size();
			System.out.println("Count Not matching TC failed, expected count was : "+expectedCount +" , Actal Count found : "+ actualCount);
			TakingScreenshot.captureScreenshot(driver);
			
		}
		return countVerified; 
	}
}


//    newly advance code. 


// package generic;

// import java.time.Duration;
// import java.util.List;
// import java.util.regex.Pattern;

// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;

// import org.openqa.selenium.support.ui.ExpectedCondition;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import org.testng.asserts.SoftAssert;

// public class AllVerifications {

//     private static final int DEFAULT_TIMEOUT_SEC = 10;

//     /* ==================== CONTEXT (no OpenClose dependency) ==================== */
//     // Store driver and SoftAssert here; set in @BeforeMethod
//     private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();
//     private static final ThreadLocal<SoftAssert> TL_SA    = new ThreadLocal<>();

//     /** Call this ONCE per test in @BeforeMethod */
//     public static void setContext(WebDriver driver, SoftAssert sa) {
//         TL_DRIVER.set(driver);
//         TL_SA.set(sa);
//     }

//     /** Call this in @AfterMethod */
//     public static void clearContext() {
//         TL_DRIVER.remove();
//         TL_SA.remove();
//     }

//     // Constructor remains for your POMs that call super(driver); it's optional now.
//     // If a driver is passed here and TL is empty, we set it so clicks can work even
//     // when the test forgot to call setContext (SoftAssert will be created locally).
//     static WebDriver lastCtorDriver = null;
//     protected AllVerifications(WebDriver driver) {
//         lastCtorDriver = driver;
//         if (TL_DRIVER.get() == null && driver != null) {
//             TL_DRIVER.set(driver);
//         }
//     }

//     private static WebDriver ctxDriver() {
//         WebDriver d = TL_DRIVER.get();
//         if (d == null) d = lastCtorDriver; // best-effort fallback
//         return d;
//     }

//     private static SoftAssert ctxSA() {
//         SoftAssert s = TL_SA.get();
//         if (s == null) s = new SoftAssert(); // local fallback (won’t be auto-assertAll)
//         return s;
//     }

//     /* ==================== TITLE ==================== */

//     public static boolean verifyTitleEquals(String expectedTitle, WebDriver driver, SoftAssert sa) {
//         return verifyTitleEquals(expectedTitle, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean verifyTitleEquals(String expectedTitle, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         String actual = driver.getTitle();
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.titleIs(expectedTitle));
//             actual = driver.getTitle();
//             ok = true;
//             System.out.println("[PASS] Title equals. Expected: [" + expectedTitle + "] | Actual: [" + actual + "]");
//         } catch (Exception e) {
//             actual = driver.getTitle();
//             System.out.println("[FAIL] Title equals. Expected: [" + expectedTitle + "] | Actual: [" + actual + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Title equals check failed. Expected: [" + expectedTitle + "] | Actual: [" + actual + "]");
//         return ok;
//     }

//     public static boolean verifyTitleContains(String expectedSubstring, WebDriver driver, SoftAssert sa) {
//         return verifyTitleContains(expectedSubstring, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean verifyTitleContains(String expectedSubstring, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         String actual = driver.getTitle();
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.titleContains(expectedSubstring));
//             actual = driver.getTitle();
//             ok = true;
//             System.out.println("[PASS] Title contains. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//         } catch (Exception e) {
//             actual = driver.getTitle();
//             System.out.println("[FAIL] Title contains. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Title contains check failed. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//         return ok;
//     }

//     /* ==================== URL ==================== */

//     public static boolean verifyUrlEquals(String expectedUrl, WebDriver driver, SoftAssert sa) {
//         return verifyUrlEquals(expectedUrl, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean verifyUrlEquals(String expectedUrl, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         String actual = driver.getCurrentUrl();
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.urlToBe(expectedUrl));
//             actual = driver.getCurrentUrl();
//             ok = true;
//             System.out.println("[PASS] URL equals. Expected: [" + expectedUrl + "] | Actual: [" + actual + "]");
//         } catch (Exception e) {
//             actual = driver.getCurrentUrl();
//             System.out.println("[FAIL] URL equals. Expected: [" + expectedUrl + "] | Actual: [" + actual + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "URL equals check failed. Expected: [" + expectedUrl + "] | Actual: [" + actual + "]");
//         return ok;
//     }

//     public static boolean verifyUrlContains(String expectedSubstring, WebDriver driver, SoftAssert sa) {
//         return verifyUrlContains(expectedSubstring, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean verifyUrlContains(final String expectedSubstring, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         String actual = driver.getCurrentUrl();
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(new ExpectedCondition<Boolean>() {
//                         public Boolean apply(WebDriver d) {
//                             try {
//                                 String url = d.getCurrentUrl();
//                                 return url != null && url.contains(expectedSubstring);
//                             } catch (Exception ignored) {
//                                 return false;
//                             }
//                         }
//                         public String toString() { return "URL to contain: [" + expectedSubstring + "]"; }
//                     });
//             actual = driver.getCurrentUrl();
//             System.out.println("[PASS] URL contains. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//             ok = true;
//         } catch (Exception e) {
//             actual = driver.getCurrentUrl();
//             System.out.println("[FAIL] URL contains. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "URL contains check failed. Substring: [" + expectedSubstring + "] | Actual: [" + actual + "]");
//         return ok;
//     }

//     /* ==================== TEXT (BODY) ==================== */

//     public static boolean textIsPresentOrNot(String expectedText, WebDriver driver, SoftAssert sa) {
//         return textIsPresentOrNot(expectedText, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean textIsPresentOrNot(String expectedText, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));
//             ok = true;
//             System.out.println("[PASS] Text present (case-sensitive): [" + expectedText + "]");
//         } catch (Exception e) {
//             System.out.println("[FAIL] Text present (case-sensitive): [" + expectedText + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Expected text not found (case-sensitive): [" + expectedText + "]");
//         return ok;
//     }

//     public static boolean textIsPresentOrNotIgnoreCase(String expectedText, WebDriver driver, SoftAssert sa) {
//         return textIsPresentOrNotIgnoreCase(expectedText, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean textIsPresentOrNotIgnoreCase(final String expectedText, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         boolean ok = false;
//         final String needle = expectedText == null ? "" : expectedText.toLowerCase();
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(new ExpectedCondition<Boolean>() {
//                         public Boolean apply(WebDriver d) {
//                             try {
//                                 String body = d.findElement(By.tagName("body")).getText();
//                                 return body != null && body.toLowerCase().contains(needle);
//                             } catch (Exception ignored) {
//                                 return false;
//                             }
//                         }
//                         public String toString() { return "text (ignore case) to contain: [" + needle + "]"; }
//                     });
//             System.out.println("[PASS] Text present (ignore case): [" + expectedText + "]");
//             ok = true;
//         } catch (Exception e) {
//             System.out.println("[FAIL] Text present (ignore case): [" + expectedText + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Expected text not found (ignore case): [" + expectedText + "]");
//         return ok;
//     }

//     /* ==================== UNIVERSAL DYNAMIC TEXT (TEMPLATE + TOKENS) ==================== */
//     // Tokens:
//     // {n} -> \d+      number
//     // {w} -> \w+      single word
//     // {s} -> [\s\S]+? any text (non-greedy)
//     // {q} -> "[^"]+"  double-quoted text
//     public static boolean textDynamic_Template(final String templateWithTokens, WebDriver driver, SoftAssert sa) {
//         return textDynamic_Template(templateWithTokens, true, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static boolean textDynamic_Template(
//             final String templateWithTokens,
//             final boolean ignoreCase,
//             WebDriver driver,
//             SoftAssert sa,
//             int timeoutSec
//     ) {
//         boolean ok = false;

//         StringBuilder sb = new StringBuilder();
//         int i = 0;
//         while (i < templateWithTokens.length()) {
//             char c = templateWithTokens.charAt(i);
//             if (c == '{') {
//                 int close = templateWithTokens.indexOf('}', i + 1);
//                 if (close > i) {
//                     String token = templateWithTokens.substring(i, close + 1);
//                     String pat;
//                     if ("{n}".equals(token)) pat = "\\\\d+";
//                     else if ("{w}".equals(token)) pat = "\\\\w+";
//                     else if ("{s}".equals(token)) pat = "[\\\\s\\\\S]+?";
//                     else if ("{q}".equals(token)) pat = "\\\\\"[^\\\\\"]+\\\\\"";
//                     else pat = Pattern.quote(token);
//                     sb.append(pat);
//                     i = close + 1;
//                     continue;
//                 }
//             }
//             int nextBrace = templateWithTokens.indexOf('{', i);
//             String literal = (nextBrace == -1)
//                     ? templateWithTokens.substring(i)
//                     : templateWithTokens.substring(i, nextBrace);
//             sb.append(Pattern.quote(literal));
//             if (nextBrace == -1) break;
//             i = nextBrace;
//         }

//         final String regex = "(?s)" + sb.toString();
//         final Pattern pattern = ignoreCase
//                 ? Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)
//                 : Pattern.compile(regex);

//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(new ExpectedCondition<Boolean>() {
//                         public Boolean apply(WebDriver d) {
//                             try {
//                                 String body = d.findElement(By.tagName("body")).getText();
//                                 return body != null && pattern.matcher(body).find();
//                             } catch (Exception ignored) {
//                                 return false;
//                             }
//                         }
//                         public String toString() {
//                             return "body text to match template regex: /" + regex + "/ ignoreCase=" + ignoreCase;
//                         }
//                     });
//             System.out.println("[PASS] Dynamic text present (template). Template: [" + templateWithTokens + "]");
//             ok = true;
//         } catch (Exception e) {
//             System.out.println("[FAIL] Dynamic text NOT present (template). Template: [" + templateWithTokens + "]");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }

//         sa.assertTrue(ok, "Dynamic text not found for template: [" + templateWithTokens + "] (ignoreCase=" + ignoreCase + ")");
//         return ok;
//     }

//     /* ==================== ALERT HELPERS ==================== */

//     public static String acceptAlertIfPresentAndGetText(WebDriver driver, SoftAssert sa) {
//         return acceptAlertIfPresentAndGetText(driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static String acceptAlertIfPresentAndGetText(WebDriver driver, SoftAssert sa, int timeoutSec) {
//         String text = "";
//         boolean ok = false;
//         try {
//             Alert alert = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.alertIsPresent());
//             text = alert.getText();
//             alert.accept();
//             ok = true;
//             System.out.println("[PASS] Alert accepted. Text: [" + text + "]");
//         } catch (Exception e) {
//             System.out.println("[FAIL] No alert to accept (or accept failed).");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Alert accept failed or alert not present. Last seen text: [" + text + "]");
//         return text;
//     }

//     public static String dismissAlertIfPresentAndGetText(WebDriver driver, SoftAssert sa) {
//         return dismissAlertIfPresentAndGetText(driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static String dismissAlertIfPresentAndGetText(WebDriver driver, SoftAssert sa, int timeoutSec) {
//         String text = "";
//         boolean ok = false;
//         try {
//             Alert alert = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.alertIsPresent());
//             text = alert.getText();
//             alert.dismiss();
//             ok = true;
//             System.out.println("[PASS] Alert dismissed. Text: [" + text + "]");
//         } catch (Exception e) {
//             System.out.println("[FAIL] No alert to dismiss (or dismiss failed).");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Alert dismiss failed or alert not present. Last seen text: [" + text + "]");
//         return text;
//     }

//     public static String handlePromptAlertSendKeysAndAccept(String keysToSend, WebDriver driver, SoftAssert sa) {
//         return handlePromptAlertSendKeysAndAccept(keysToSend, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static String handlePromptAlertSendKeysAndAccept(String keysToSend, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         String previousText = "";
//         boolean ok = false;
//         try {
//             Alert alert = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.alertIsPresent());
//             previousText = alert.getText();
//             alert.sendKeys(keysToSend);
//             alert.accept();
//             ok = true;
//             System.out.println("[PASS] Prompt accepted. Previous: [" + previousText + "], Entered: [" + keysToSend + "]");
//         } catch (Exception e) {
//             System.out.println("[FAIL] Prompt handling failed (no alert or sendKeys/accept failed).");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Prompt alert handling failed. Previous: [" + previousText + "], Entered: [" + keysToSend + "]");
//         return previousText;
//     }

//     /* ==================== COUNT ELEMENTS ==================== */

//     public static int countElements(By locator, WebDriver driver, SoftAssert sa) {
//         return countElements(locator, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static int countElements(final By locator, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         int count = 0;
//         boolean ok = false;
//         try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//             List<WebElement> els = driver.findElements(locator);
//             count = (els == null) ? 0 : els.size();
//             ok = count >= 0;
//             System.out.println("[PASS] Counted elements for " + locator + " = " + count);
//         } catch (Exception e) {
//             System.out.println("[FAIL] Could not count elements for " + locator);
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Failed to count elements for locator: " + locator);
//         return count;
//     }

//     public static int countElementsWithin(By parentLocator, By childLocator, WebDriver driver, SoftAssert sa) {
//         return countElementsWithin(parentLocator, childLocator, driver, sa, DEFAULT_TIMEOUT_SEC);
//     }

//     public static int countElementsWithin(final By parentLocator, final By childLocator, WebDriver driver, SoftAssert sa, int timeoutSec) {
//         int count = 0;
//         boolean ok = false;
//         try {
//             WebElement parent = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
//                     .until(ExpectedConditions.presenceOfElementLocated(parentLocator));
//             List<WebElement> children = parent.findElements(childLocator);
//             count = (children == null) ? 0 : children.size();
//             ok = count >= 0;
//             System.out.println("[PASS] Counted children " + childLocator + " within " + parentLocator + " = " + count);
//         } catch (Exception e) {
//             System.out.println("[FAIL] Could not count children " + childLocator + " within " + parentLocator);
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }
//         sa.assertTrue(ok, "Failed to count child elements for parent: " + parentLocator + " and child: " + childLocator);
//         return count;
//     }

//     /* ==================== CLICK (NO PARAMS) ==================== */

//     /** Use after calling AllVerifications.setContext(driver, sa) in @BeforeMethod */
//     public static boolean clickIfVisibleAndEnabled(WebElement el) {
//         WebDriver driver = ctxDriver();
//         SoftAssert sa = ctxSA();

//         if (driver == null) {
//             System.out.println("[FAIL] No WebDriver in AllVerifications context. Call setContext() in @BeforeMethod.");
//             sa.fail("No WebDriver in AllVerifications context.");
//             return false;
//         }

//         boolean ok = false;
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SEC));

//         try {
//             wait.until(ExpectedConditions.visibilityOf(el));
//             wait.until(ExpectedConditions.elementToBeClickable(el));

//             String tag = "";
//             String text = "";
//             try { tag = el.getTagName(); } catch (Exception ignore) {}
//             try { text = el.getText(); }    catch (Exception ignore) {}

//             el.click();
//             ok = true;
//             if (text != null && !text.trim().isEmpty()) {
//                 System.out.println("[PASS] Clicked <" + tag + "> | text: [" + text.trim() + "]");
//             } else {
//                 System.out.println("[PASS] Clicked <" + tag + "> | (no text)");
//             }

//         } catch (Exception e) {
//             System.out.println("[FAIL] Click failed.");
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }

//         sa.assertTrue(ok, "Click failed or element not visible/enabled.");
//         return ok;
//     }
// }




