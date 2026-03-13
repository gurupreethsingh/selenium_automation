////package generic;
////
////import java.time.Duration;
////import java.util.List;
////import java.util.NoSuchElementException;
////
////import org.openqa.selenium.Alert;
////import org.openqa.selenium.By;
////import org.openqa.selenium.Keys;
////import org.openqa.selenium.StaleElementReferenceException;
////import org.openqa.selenium.TimeoutException;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.support.ui.ExpectedCondition;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.WebDriverWait;
////
////public class AllVerifications {
////
////	protected final WebDriver driver;
////
////	// ✅ constructor injection
////	public AllVerifications(WebDriver driver) {
////		this.driver = driver;
////	}
////
////	// ============================================================
////	// ✅ CENTRAL CONFIG
////	// ============================================================
////	private static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
////	private static final int DEFAULT_RETRY_COUNT = 2;
////
////	protected WebDriverWait createWait(int seconds) {
////		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
////	}
////
////	// ============================================================
////	// ✅ UNIVERSAL WAITS (By)
////	// ============================================================
////
////	public WebElement waitUntilElementPresent(By locator, int timeoutSeconds, String name) {
////		try {
////			System.out.println("[WAIT PRESENCE] " + name + " | " + locator);
////			return createWait(timeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
////		} catch (TimeoutException te) {
////			System.out.println("[WAIT PRESENCE TIMEOUT] " + name + " | " + locator);
////			return null;
////		} catch (Exception e) {
////			System.out.println("[WAIT PRESENCE FAILED] " + name + " | " + locator);
////			e.printStackTrace();
////			return null;
////		}
////	}
////
////	public WebElement waitUntilElementVisible(By locator, int timeoutSeconds, String name) {
////		try {
////			System.out.println("[WAIT VISIBLE] " + name + " | " + locator);
////			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
////		} catch (TimeoutException te) {
////			System.out.println("[WAIT VISIBLE TIMEOUT] " + name + " | " + locator);
////			return null;
////		} catch (Exception e) {
////			System.out.println("[WAIT VISIBLE FAILED] " + name + " | " + locator);
////			e.printStackTrace();
////			return null;
////		}
////	}
////
////	public boolean waitUntilElementInvisible(By locator, int timeoutSeconds, String name) {
////		try {
////			System.out.println("[WAIT INVISIBLE] " + name + " | " + locator);
////			boolean ok = createWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
////			System.out.println("[WAIT INVISIBLE DONE] " + name + " -> " + ok);
////			return ok;
////		} catch (Exception e) {
////			System.out.println("[WAIT INVISIBLE FAILED] " + name + " | " + locator);
////			return false;
////		}
////	}
////
////	public boolean isElementPresentInDOM(By locator) {
////		try {
////			return driver.findElements(locator).size() > 0;
////		} catch (Exception e) {
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ UNIVERSAL WAITS (WebElement)
////	// ============================================================
////
////	public WebElement waitUntilElementVisible(WebElement element, int timeoutSeconds, String name) {
////		try {
////			System.out.println("[WAIT VISIBLE] " + name);
////			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));
////		} catch (TimeoutException te) {
////			System.out.println("[WAIT VISIBLE TIMEOUT] " + name);
////			return null;
////		} catch (Exception e) {
////			System.out.println("[WAIT VISIBLE FAILED] " + name);
////			e.printStackTrace();
////			return null;
////		}
////	}
////
////	public WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds, String name) {
////		try {
////			System.out.println("[WAIT CLICKABLE] " + name);
////			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
////		} catch (TimeoutException te) {
////			System.out.println("[WAIT CLICKABLE TIMEOUT] " + name);
////			return null;
////		} catch (Exception e) {
////			System.out.println("[WAIT CLICKABLE FAILED] " + name);
////			e.printStackTrace();
////			return null;
////		}
////	}
////
////	// ============================================================
////	// ✅ UNIVERSAL CLICK (WebElement / By)
////	// ============================================================
////
////	public boolean clickOnElement(WebElement element, String elementName) {
////		boolean clicked = false;
////		ScreenshotUtility su = new ScreenshotUtility();
////
////		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
////			try {
////				System.out.println("[CLICK TRY " + attempt + "] " + elementName);
////
////				waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
////				waitUntilElementClickable(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
////
////				element.click();
////				clicked = true;
////
////				System.out.println("[CLICK SUCCESS] " + elementName);
////				break;
////
////			} catch (StaleElementReferenceException sere) {
////				System.out.println("[STALE ELEMENT] " + elementName + " | retrying...");
////
////				su.captureScreenshot();
////			} catch (Exception ex) {
////				System.out.println("[CLICK FAILED] " + elementName);
////				ex.printStackTrace();
////				su.captureScreenshot();
////				break;
////			}
////		}
////
////		return clicked;
////	}
////
////	public boolean clickOnElement(By locator, String elementName) {
////		boolean clicked = false;
////		ScreenshotUtility su = new ScreenshotUtility();
////
////		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
////			try {
////				System.out.println("[CLICK TRY " + attempt + "] " + elementName + " | " + locator);
////
////				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
////						.until(ExpectedConditions.elementToBeClickable(locator));
////				element.click();
////
////				clicked = true;
////				System.out.println("[CLICK SUCCESS] " + elementName);
////				break;
////
////			} catch (StaleElementReferenceException sere) {
////				System.out.println("[STALE ELEMENT] " + elementName + " | " + locator + " | retrying...");
////				su.captureScreenshot();
////			} catch (Exception ex) {
////				System.out.println("[CLICK FAILED] " + elementName + " | " + locator);
////				ex.printStackTrace();
////				su.captureScreenshot();
////				break;
////			}
////		}
////
////		return clicked;
////	}
////
////	// ============================================================
////	// ✅ TYPE + KEYS
////	// ============================================================
////
////	public boolean typeInInputField(WebElement element, String value, String fieldName) {
////		boolean typed = false;
////
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, fieldName);
////
////			if (value == null) {
////				System.out.println("[TYPE ERROR] " + fieldName + " value is NULL");
////				return false;
////			}
////
////			String trimmed = value.trim();
////			if (trimmed.isEmpty()) {
////				System.out.println("[TYPE ERROR] " + fieldName + " value is EMPTY/WHITESPACE");
////				return false;
////			}
////
////			element.clear();
////			element.sendKeys(trimmed);
////
////			typed = true;
////			System.out.println("[TYPE SUCCESS] " + fieldName + " : " + trimmed);
////
////		} catch (StaleElementReferenceException sere) {
////			System.out.println("[STALE TYPE] " + fieldName + " | retrying once...");
////			try {
////				element.clear();
////				element.sendKeys(value.trim());
////				typed = true;
////			} catch (Exception ex) {
////				System.out.println("[TYPE FAILED AFTER RETRY] " + fieldName);
////			}
////		} catch (Exception ex) {
////			System.out.println("[TYPE FAILED] " + fieldName);
////			ex.printStackTrace();
////		}
////
////		return typed;
////	}
////
////	public boolean pressKeyInElement(WebElement element, Keys key, String name) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
////			element.sendKeys(key);
////			System.out.println("[PRESS KEY SUCCESS] " + name + " -> " + key);
////			return true;
////		} catch (Exception e) {
////			System.out.println("[PRESS KEY FAILED] " + name + " -> " + key);
////			e.printStackTrace();
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ TEXT / DISPLAY HELPERS
////	// ============================================================
////
////	public String getTextFromElement(WebElement element, String name) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
////			String t = element.getText();
////			t = (t == null) ? "" : t.trim();
////			System.out.println("[GET TEXT] " + name + " -> " + t);
////			return t;
////		} catch (Exception e) {
////			System.out.println("[GET TEXT FAILED] " + name);
////			return "";
////		}
////	}
////
////	public int getIntegerFromElementText(WebElement element, String name) {
////		try {
////			String txt = getTextFromElement(element, name);
////			if (txt == null || txt.trim().isEmpty())
////				return 0;
////			return Integer.parseInt(txt.trim());
////		} catch (Exception e) {
////			System.out.println("[GET INT FAILED] " + name);
////			return 0;
////		}
////	}
////
////	public boolean isElementDisplayed(WebElement element, String name) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
////			boolean ok = element.isDisplayed();
////			System.out.println("[IS DISPLAYED] " + name + " -> " + ok);
////			return ok;
////		} catch (Exception e) {
////			System.out.println("[IS DISPLAYED FAILED] " + name);
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ VERIFICATION METHODS
////	// ============================================================
////
////	public boolean verifyTitleOfWebpage(String expectedTitle) {
////		boolean titleVerified = false;
////		try {
////			System.out.println("[VERIFY TITLE] Expected: " + expectedTitle);
////			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.titleIs(expectedTitle));
////			titleVerified = true;
////			System.out.println("[TITLE PASS] Expected: " + expectedTitle + " | Found: " + driver.getTitle());
////		} catch (Exception ex) {
////			System.out.println("[TITLE FAIL] Expected: " + expectedTitle + " | Found: " + safeTitle());
////		}
////		return titleVerified;
////	}
////
////	public boolean verifyUrlOfWebpage(String expectedUrl) {
////		boolean urlVerified = false;
////		try {
////			System.out.println("[VERIFY URL] Expected: " + expectedUrl);
////			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.urlMatches(expectedUrl));
////			urlVerified = true;
////			System.out.println("[URL PASS] Expected: " + expectedUrl + " | Found: " + driver.getCurrentUrl());
////		} catch (Exception ex) {
////			System.out.println("[URL FAIL] Expected: " + expectedUrl + " | Found: " + safeUrl());
////		}
////		return urlVerified;
////	}
////
////	public boolean verifyTextPresent(String expectedText, WebElement element) {
////		boolean textVerified = false;
////		try {
////			System.out.println("[VERIFY TEXT] Expected: " + expectedText);
////			createWait(DEFAULT_WAITING_TIME_IN_SEC)
////					.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
////			textVerified = true;
////			System.out.println("[TEXT PASS] Expected: " + expectedText + " | Found: " + safeGet(element));
////		} catch (Exception ex) {
////			System.out.println("[TEXT FAIL] Expected: " + expectedText + " | Found: " + safeGet(element));
////		}
////		return textVerified;
////	}
////
////	private String safeGet(WebElement element) {
////		try {
////			String t = element.getText();
////			return t == null ? "" : t;
////		} catch (Exception e) {
////			return "";
////		}
////	}
////
////	private String safeTitle() {
////		try {
////			return driver.getTitle();
////		} catch (Exception e) {
////			return "";
////		}
////	}
////
////	private String safeUrl() {
////		try {
////			return driver.getCurrentUrl();
////		} catch (Exception e) {
////			return "";
////		}
////	}
////
////	public boolean verifyTextPresentIgnoreCase(String expectedText, WebElement element) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentIgnoreCase element");
////
////			String actualText = element.getText() == null ? "" : element.getText().trim();
////			String exp = expectedText == null ? "" : expectedText.trim();
////
////			boolean ok = actualText.equalsIgnoreCase(exp);
////			System.out.println(ok ? "[TEXT PASS - IGNORECASE]"
////					: "[TEXT FAIL - IGNORECASE]" + " Expected: " + exp + " | Found: " + actualText);
////
////			return ok;
////		} catch (Exception ex) {
////			System.out.println("[TEXT FAIL - IGNORECASE] Element not found or exception.");
////			return false;
////		}
////	}
////
////	public boolean verifyTextPresentWithNumbers(String expectedPattern, WebElement element) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentWithNumbers element");
////			String actualText = element.getText() == null ? "" : element.getText().trim();
////
////			boolean ok = actualText.matches(expectedPattern);
////			System.out.println(ok ? "[TEXT PASS - PATTERN] " + actualText
////					: "[TEXT FAIL - PATTERN] Expected Pattern: " + expectedPattern + " | Found: " + actualText);
////
////			return ok;
////		} catch (Exception ex) {
////			System.out.println("[TEXT FAIL - PATTERN] Element not found or pattern not matched.");
////			return false;
////		}
////	}
////
////	public boolean verifyTextNotPresent(String expectedText, By locator) {
////		try {
////			System.out.println("[VERIFY TEXT NOT PRESENT] " + expectedText + " | " + locator);
////			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.invisibilityOfElementLocated(locator));
////			System.out.println("[TEXT REMOVED PASS] Not Found: " + expectedText);
////			return true;
////		} catch (Exception ex) {
////			System.out.println("[TEXT REMOVED FAIL] Still Found: " + expectedText);
////			return false;
////		}
////	}
////
////	public boolean verifyTextNotPresentInNestedElements(By containerOrElementLocator, String expectedText) {
////		try {
////			String exp = expectedText == null ? "" : expectedText.trim();
////
////			System.out.println("[VERIFY NESTED TEXT NOT PRESENT] " + exp + " | " + containerOrElementLocator);
////
////			boolean ok = createWait(DEFAULT_WAITING_TIME_IN_SEC).until((ExpectedCondition<Boolean>) d -> {
////				try {
////					List<WebElement> els = d.findElements(containerOrElementLocator);
////
////					if (els == null || els.isEmpty())
////						return true;
////
////					WebElement el = els.get(0);
////
////					if (!el.isDisplayed())
////						return true;
////
////					String actual = (el.getText() == null) ? "" : el.getText().trim();
////					return !actual.contains(exp);
////
////				} catch (StaleElementReferenceException sere) {
////					return false;
////				} catch (NoSuchElementException nse) {
////					return true;
////				} catch (Exception e) {
////					return false;
////				}
////			});
////
////			System.out.println(ok ? "[NESTED TEXT NOT PRESENT PASS]" : "[NESTED TEXT NOT PRESENT FAIL]");
////			return ok;
////
////		} catch (Exception e) {
////			System.out.println("[NESTED TEXT NOT PRESENT FAIL] Still present: " + expectedText + " | "
////					+ containerOrElementLocator);
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ CLICK IF… WRAPPERS
////	// ============================================================
////
////	public boolean clickOnElementIfClickable(WebElement element) {
////		return clickOnElement(element, "clickOnElementIfClickable -> " + element);
////	}
////
////	public boolean clickOnElementIfVisibleAndEnabled(WebElement element) {
////		try {
////			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC,
////					"clickOnElementIfVisibleAndEnabled -> element");
////
////			if (element.isEnabled()) {
////				return clickOnElement(element, "clickOnElementIfVisibleAndEnabled -> element");
////			}
////
////			System.out.println("[CLICK BLOCKED] Element is visible but NOT enabled.");
////			return false;
////
////		} catch (Exception ex) {
////			System.out.println("[CLICK FAILED] Element not visible within wait time.");
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ ALERT HANDLERS
////	// ============================================================
////
////	public boolean acceptAlertIfPresent() {
////		try {
////			System.out.println("[ALERT WAIT] Accept");
////			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());
////
////			Alert alert = driver.switchTo().alert();
////			System.out.println("[ALERT TEXT] " + alert.getText());
////
////			alert.accept();
////			System.out.println("[ALERT ACCEPTED] Successfully.");
////			return true;
////
////		} catch (Exception ex) {
////			System.out.println("[ALERT ACCEPT FAILED]");
////			return false;
////		}
////	}
////
////	public boolean dismissAlertIfPresent() {
////		try {
////			System.out.println("[ALERT WAIT] Dismiss");
////			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());
////
////			Alert alert = driver.switchTo().alert();
////			System.out.println("[ALERT TEXT] " + alert.getText());
////
////			alert.dismiss();
////			System.out.println("[ALERT DISMISSED] Successfully.");
////			return true;
////
////		} catch (Exception ex) {
////			System.out.println("[ALERT DISMISS FAILED]");
////			return false;
////		}
////	}
////
////	// ============================================================
////	// ✅ COUNT / PRINT HELPERS
////	// ============================================================
////
////	public boolean verifyTotalElementsCount(int expectedCount, By locator) {
////		int actualCount = 0;
////
////		try {
////			System.out.println("[COUNT VERIFY] Expected: " + expectedCount + " | Locator: " + locator);
////
////			for (int i = 1; i <= 50; i++) {
////				actualCount = driver.findElements(locator).size();
////				if (actualCount == expectedCount) {
////					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
////					break;
////				}
////				Thread.sleep(200);
////			}
////
////			System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);
////			return (actualCount == expectedCount);
////
////		} catch (Exception ex) {
////			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
////			return false;
////		}
////	}
////
//////	public boolean printAllBrandNamesInHomepage(int expectedCount, By locator) {
//////		int actualCount = 0;
//////
//////		try {
//////			System.out.println("[PRINT BRANDS] ExpectedCount: " + expectedCount + " | Locator: " + locator);
//////
//////			for (int i = 1; i <= 50; i++) {
//////				actualCount = driver.findElements(locator).size();
//////				if (actualCount == expectedCount) {
//////					System.out.println("[BRANDS COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
//////					break;
//////				}
//////				Thread.sleep(200);
//////			}
//////
//////			List<WebElement> brandButtons = driver.findElements(locator);
//////			actualCount = brandButtons.size();
//////
//////			Set<String> uniqueBrands = new LinkedHashSet<>();
//////			for (WebElement btn : brandButtons) {
//////				String brand = btn.getAttribute("title");
//////				if (brand != null && !brand.trim().isEmpty())
//////					uniqueBrands.add(brand.trim());
//////			}
//////
//////			int count = 0;
//////			for (String b : uniqueBrands) {
//////				System.out.println((count + 1) + " Brand Name : " + b);
//////				count++;
//////				Thread.sleep(50);
//////			}
//////
//////			System.out.println("[BRANDS SUMMARY] Expected: " + expectedCount + " | Actual: " + actualCount
//////					+ " | Unique: " + uniqueBrands.size());
//////
//////			return (actualCount == expectedCount);
//////
//////		} catch (Exception ex) {
//////			System.out.println("[PRINT BRANDS FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
//////			return false;
//////		}
//////	}
//////
//////	public boolean verifyTotalElementsCount1(int expectedCount, By locator) {
//////		int actualCount = 0;
//////
//////		try {
//////			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//////			wait.until(d -> d.findElements(locator).size() == expectedCount);
//////
//////			List<WebElement> brandButtons = driver.findElements(locator);
//////			actualCount = brandButtons.size();
//////
//////			java.util.Set<String> uniqueBrands = new java.util.LinkedHashSet<>();
//////			for (WebElement btn : brandButtons) {
//////				String brand = btn.getAttribute("title");
//////				if (brand != null) {
//////					brand = brand.trim();
//////					if (!brand.isEmpty())
//////						uniqueBrands.add(brand);
//////				}
//////			}
//////
//////			if (uniqueBrands.isEmpty()) {
//////				List<WebElement> nameSpans = driver.findElements(By.cssSelector(
//////						"div.flex.items-center.w-max:first-child>button[title]>div>div:last-child>span:first-child"));
//////				for (WebElement s : nameSpans) {
//////					String t = s.getAttribute("textContent");
//////					if (t != null) {
//////						t = t.trim();
//////						if (!t.isEmpty())
//////							uniqueBrands.add(t);
//////					}
//////				}
//////			}
//////
//////			int count = 0;
//////			for (String b : uniqueBrands) {
//////				System.out.println(count + 1 + " Brand Name : " + b);
//////				count++;
//////				Thread.sleep(50);
//////			}
//////
//////			System.out.println("Count matching - expected count : " + expectedCount + " Found actual count is : "
//////					+ actualCount + " | Unique names printed: " + uniqueBrands.size());
//////
//////			return (actualCount == expectedCount);
//////
//////		} catch (Exception ex) {
//////			System.out.println(
//////					"Count Not matching expected count : " + expectedCount + " Found actual count as : " + actualCount);
//////			return false;
//////		}
//////	}
////}
//
//// till here my code. 
//
//package generic;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class AllVerifications {
//
//	protected final WebDriver driver;
//
//	// ✅ GLOBAL screenshot utility (single instance for entire class)
//	protected final ScreenshotUtility su;
//
//	// ✅ constructor injection
//	public AllVerifications(WebDriver driver) {
//		this.driver = driver;
//		this.su = new ScreenshotUtility(driver); // assuming default constructor works in your framework
//	}
//
//	// ============================================================
//	// ✅ CENTRAL CONFIG
//	// ============================================================
//	private static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
//	private static final int DEFAULT_RETRY_COUNT = 2;
//
//	protected WebDriverWait createWait(int seconds) {
//		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
//	}
//
//	// ============================================================
//	// ✅ INTERNAL: Screenshot capture wrapper (no extra failures)
//	// ============================================================
//	private void captureFailure(String tag) {
//		try {
//			System.out.println("[SCREENSHOT] " + tag);
//			su.captureScreenshot();
//		} catch (Exception ignore) {
//			System.out.println("[SCREENSHOT FAILED] " + tag);
//		}
//	}
//
//	private void captureFailure(String tag, Exception ex) {
//		try {
//			System.out.println("[SCREENSHOT] " + tag + " | ex=" + ex.getClass().getSimpleName());
//			su.captureScreenshot();
//		} catch (Exception ignore) {
//			System.out.println("[SCREENSHOT FAILED] " + tag);
//		}
//	}
//
//	// ============================================================
//	// ✅ UNIVERSAL WAITS (By)
//	// ============================================================
//
//	public WebElement waitUntilElementPresent(By locator, int timeoutSeconds, String name) {
//		try {
//			System.out.println("[WAIT PRESENCE] " + name + " | " + locator);
//			return createWait(timeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
//		} catch (TimeoutException te) {
//			System.out.println("[WAIT PRESENCE TIMEOUT] " + name + " | " + locator);
//			captureFailure("WAIT PRESENCE TIMEOUT -> " + name + " | " + locator, te);
//			return null;
//		} catch (Exception e) {
//			System.out.println("[WAIT PRESENCE FAILED] " + name + " | " + locator);
//			e.printStackTrace();
//			captureFailure("WAIT PRESENCE FAILED -> " + name + " | " + locator, e);
//			return null;
//		}
//	}
//
//	public WebElement waitUntilElementVisible(By locator, int timeoutSeconds, String name) {
//		try {
//			System.out.println("[WAIT VISIBLE] " + name + " | " + locator);
//			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
//		} catch (TimeoutException te) {
//			System.out.println("[WAIT VISIBLE TIMEOUT] " + name + " | " + locator);
//			captureFailure("WAIT VISIBLE TIMEOUT -> " + name + " | " + locator, te);
//			return null;
//		} catch (Exception e) {
//			System.out.println("[WAIT VISIBLE FAILED] " + name + " | " + locator);
//			e.printStackTrace();
//			captureFailure("WAIT VISIBLE FAILED -> " + name + " | " + locator, e);
//			return null;
//		}
//	}
//
//	public boolean waitUntilElementInvisible(By locator, int timeoutSeconds, String name) {
//		try {
//			System.out.println("[WAIT INVISIBLE] " + name + " | " + locator);
//			boolean ok = createWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
//			System.out.println("[WAIT INVISIBLE DONE] " + name + " -> " + ok);
//			return ok;
//		} catch (Exception e) {
//			System.out.println("[WAIT INVISIBLE FAILED] " + name + " | " + locator);
//			captureFailure("WAIT INVISIBLE FAILED -> " + name + " | " + locator, e);
//			return false;
//		}
//	}
//
//	public boolean isElementPresentInDOM(By locator) {
//		try {
//			return driver.findElements(locator).size() > 0;
//		} catch (Exception e) {
//			captureFailure("isElementPresentInDOM FAILED -> " + locator, e);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ UNIVERSAL WAITS (WebElement)
//	// ============================================================
//
//	public WebElement waitUntilElementVisible(WebElement element, int timeoutSeconds, String name) {
//		try {
//			System.out.println("[WAIT VISIBLE] " + name);
//			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));
//		} catch (TimeoutException te) {
//			System.out.println("[WAIT VISIBLE TIMEOUT] " + name);
//			captureFailure("WAIT VISIBLE (element) TIMEOUT -> " + name, te);
//			return null;
//		} catch (Exception e) {
//			System.out.println("[WAIT VISIBLE FAILED] " + name);
//			e.printStackTrace();
//			captureFailure("WAIT VISIBLE (element) FAILED -> " + name, e);
//			return null;
//		}
//	}
//
//	public WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds, String name) {
//		try {
//			System.out.println("[WAIT CLICKABLE] " + name);
//			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
//		} catch (TimeoutException te) {
//			System.out.println("[WAIT CLICKABLE TIMEOUT] " + name);
//			captureFailure("WAIT CLICKABLE TIMEOUT -> " + name, te);
//			return null;
//		} catch (Exception e) {
//			System.out.println("[WAIT CLICKABLE FAILED] " + name);
//			e.printStackTrace();
//			captureFailure("WAIT CLICKABLE FAILED -> " + name, e);
//			return null;
//		}
//	}
//
//	public WebElement waitUntilElementIsClickable(WebElement element, int timeoutSeconds, String elementName) {
//		new WebDriverWait(driver, Duration.ofSeconds(10));
//		try {
//			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
//
//		} catch (Exception ex) {
//			System.out.println("Unable to click on the element.");
//			ex.printStackTrace();
//			// screenshot code.
//			return null;
//		}
//	}
//
//	// ============================================================
//	// ✅ UNIVERSAL CLICK (WebElement / By)
//	// ============================================================
//
//	public boolean clickOnElement(WebElement element, String elementName) {
//		boolean clicked = false;
//
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
//			try {
//				System.out.println("[CLICK TRY " + attempt + "] " + elementName);
//
//				waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
//				waitUntilElementClickable(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
//
//				element.click();
//				clicked = true;
//
//				System.out.println("[CLICK SUCCESS] " + elementName);
//				break;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[STALE ELEMENT] " + elementName + " | retrying...");
//				captureFailure("CLICK STALE -> " + elementName, sere);
//
//			} catch (Exception ex) {
//				System.out.println("[CLICK FAILED] " + elementName);
//				ex.printStackTrace();
//				captureFailure("CLICK FAILED -> " + elementName, ex);
//				break;
//			}
//		}
//
//		return clicked;
//	}
//
//	public boolean clickOnElement(By locator, String elementName) {
//		boolean clicked = false;
//
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
//			try {
//				System.out.println("[CLICK TRY " + attempt + "] " + elementName + " | " + locator);
//
//				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.elementToBeClickable(locator));
//				element.click();
//
//				clicked = true;
//				System.out.println("[CLICK SUCCESS] " + elementName);
//				break;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[STALE ELEMENT] " + elementName + " | " + locator + " | retrying...");
//				captureFailure("CLICK(By) STALE -> " + elementName + " | " + locator, sere);
//
//			} catch (Exception ex) {
//				System.out.println("[CLICK FAILED] " + elementName + " | " + locator);
//				ex.printStackTrace();
//				captureFailure("CLICK(By) FAILED -> " + elementName + " | " + locator, ex);
//				break;
//			}
//		}
//
//		return clicked;
//	}
//
//	// ============================================================
//	// ✅ TYPE + KEYS
//	// ============================================================
//
//	public boolean typeInInputField(WebElement element, String value, String fieldName) {
//		boolean typed = false;
//
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, fieldName);
//
//			if (value == null) {
//				System.out.println("[TYPE ERROR] " + fieldName + " value is NULL");
//				captureFailure("TYPE NULL -> " + fieldName);
//				return false;
//			}
//
//			String trimmed = value.trim();
//			if (trimmed.isEmpty()) {
//				System.out.println("[TYPE ERROR] " + fieldName + " value is EMPTY/WHITESPACE");
//				captureFailure("TYPE EMPTY -> " + fieldName);
//				return false;
//			}
//
//			element.clear();
//			element.sendKeys(trimmed);
//
//			typed = true;
//			System.out.println("[TYPE SUCCESS] " + fieldName + " : " + trimmed);
//
//		} catch (StaleElementReferenceException sere) {
//			System.out.println("[STALE TYPE] " + fieldName + " | retrying once...");
//			captureFailure("TYPE STALE -> " + fieldName, sere);
//
//			try {
//				element.clear();
//				element.sendKeys(value.trim());
//				typed = true;
//				System.out.println("[TYPE SUCCESS AFTER RETRY] " + fieldName);
//			} catch (Exception ex) {
//				System.out.println("[TYPE FAILED AFTER RETRY] " + fieldName);
//				ex.printStackTrace();
//				captureFailure("TYPE FAILED AFTER RETRY -> " + fieldName, ex);
//			}
//
//		} catch (Exception ex) {
//			System.out.println("[TYPE FAILED] " + fieldName);
//			ex.printStackTrace();
//			captureFailure("TYPE FAILED -> " + fieldName, ex);
//		}
//
//		return typed;
//	}
//
//	public boolean pressKeyInElement(WebElement element, Keys key, String name) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
//			element.sendKeys(key);
//			System.out.println("[PRESS KEY SUCCESS] " + name + " -> " + key);
//			return true;
//		} catch (Exception e) {
//			System.out.println("[PRESS KEY FAILED] " + name + " -> " + key);
//			e.printStackTrace();
//			captureFailure("PRESS KEY FAILED -> " + name + " -> " + key, e);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ TEXT / DISPLAY HELPERS
//	// ============================================================
//
//	public String getTextFromElement(WebElement element, String name) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
//			String t = element.getText();
//			t = (t == null) ? "" : t.trim();
//			System.out.println("[GET TEXT] " + name + " -> " + t);
//			return t;
//		} catch (Exception e) {
//			System.out.println("[GET TEXT FAILED] " + name);
//			captureFailure("GET TEXT FAILED -> " + name, e);
//			return "";
//		}
//	}
//
//	public int getIntegerFromElementText(WebElement element, String name) {
//		try {
//			String txt = getTextFromElement(element, name);
//			if (txt == null || txt.trim().isEmpty())
//				return 0;
//			return Integer.parseInt(txt.trim());
//		} catch (Exception e) {
//			System.out.println("[GET INT FAILED] " + name);
//			captureFailure("GET INT FAILED -> " + name, e);
//			return 0;
//		}
//	}
//
//	public boolean isElementDisplayed(WebElement element, String name) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
//			boolean ok = element.isDisplayed();
//			System.out.println("[IS DISPLAYED] " + name + " -> " + ok);
//			return ok;
//		} catch (Exception e) {
//			System.out.println("[IS DISPLAYED FAILED] " + name);
//			captureFailure("IS DISPLAYED FAILED -> " + name, e);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ VERIFICATION METHODS
//	// ============================================================
//
//	public boolean verifyTitleOfWebpage(String expectedTitle) {
//		boolean titleVerified = false;
//		try {
//			System.out.println("[VERIFY TITLE] Expected: " + expectedTitle);
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.titleIs(expectedTitle));
//			titleVerified = true;
//			System.out.println("[TITLE PASS] Expected: " + expectedTitle + " | Found: " + driver.getTitle());
//		} catch (Exception ex) {
//			System.out.println("[TITLE FAIL] Expected: " + expectedTitle + " | Found: " + safeTitle());
//			captureFailure("VERIFY TITLE FAIL -> expected=" + expectedTitle, ex);
//		}
//		return titleVerified;
//	}
//
//	public boolean verifyUrlOfWebpage(String expectedUrl) {
//		boolean urlVerified = false;
//		try {
//			System.out.println("[VERIFY URL] Expected: " + expectedUrl);
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.urlMatches(expectedUrl));
//			urlVerified = true;
//			System.out.println("[URL PASS] Expected: " + expectedUrl + " | Found: " + driver.getCurrentUrl());
//		} catch (Exception ex) {
//			System.out.println("[URL FAIL] Expected: " + expectedUrl + " | Found: " + safeUrl());
//			captureFailure("VERIFY URL FAIL -> expected=" + expectedUrl, ex);
//		}
//		return urlVerified;
//	}
//
//	public boolean verifyTextPresent(String expectedText, WebElement element) {
//		boolean textVerified = false;
//		try {
//			System.out.println("[VERIFY TEXT] Expected: " + expectedText);
//			createWait(DEFAULT_WAITING_TIME_IN_SEC)
//					.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
//			textVerified = true;
//			System.out.println("[TEXT PASS] Expected: " + expectedText + " | Found: " + safeGet(element));
//		} catch (Exception ex) {
//			System.out.println("[TEXT FAIL] Expected: " + expectedText + " | Found: " + safeGet(element));
//			captureFailure("VERIFY TEXT FAIL -> expected=" + expectedText, ex);
//		}
//		return textVerified;
//	}
//
//	private String safeGet(WebElement element) {
//		try {
//			String t = element.getText();
//			return t == null ? "" : t;
//		} catch (Exception e) {
//			return "";
//		}
//	}
//
//	private String safeTitle() {
//		try {
//			return driver.getTitle();
//		} catch (Exception e) {
//			return "";
//		}
//	}
//
//	private String safeUrl() {
//		try {
//			return driver.getCurrentUrl();
//		} catch (Exception e) {
//			return "";
//		}
//	}
//
//	public boolean verifyTextPresentIgnoreCase(String expectedText, WebElement element) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentIgnoreCase element");
//
//			String actualText = element.getText() == null ? "" : element.getText().trim();
//			String exp = expectedText == null ? "" : expectedText.trim();
//
//			boolean ok = actualText.equalsIgnoreCase(exp);
//			System.out.println(ok ? "[TEXT PASS - IGNORECASE]"
//					: "[TEXT FAIL - IGNORECASE]" + " Expected: " + exp + " | Found: " + actualText);
//
//			if (!ok) {
//				captureFailure("VERIFY TEXT IGNORECASE FAIL -> expected=" + exp + " found=" + actualText);
//			}
//
//			return ok;
//		} catch (Exception ex) {
//			System.out.println("[TEXT FAIL - IGNORECASE] Element not found or exception.");
//			captureFailure("VERIFY TEXT IGNORECASE EXCEPTION", ex);
//			return false;
//		}
//	}
//
//	public boolean verifyTextPresentWithNumbers(String expectedPattern, WebElement element) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentWithNumbers element");
//			String actualText = element.getText() == null ? "" : element.getText().trim();
//
//			boolean ok = actualText.matches(expectedPattern);
//			System.out.println(ok ? "[TEXT PASS - PATTERN] " + actualText
//					: "[TEXT FAIL - PATTERN] Expected Pattern: " + expectedPattern + " | Found: " + actualText);
//
//			if (!ok) {
//				captureFailure("VERIFY TEXT PATTERN FAIL -> pattern=" + expectedPattern + " found=" + actualText);
//			}
//
//			return ok;
//		} catch (Exception ex) {
//			System.out.println("[TEXT FAIL - PATTERN] Element not found or pattern not matched.");
//			captureFailure("VERIFY TEXT PATTERN EXCEPTION -> pattern=" + expectedPattern, ex);
//			return false;
//		}
//	}
//
//	public boolean verifyTextNotPresent(String expectedText, By locator) {
//		try {
//			System.out.println("[VERIFY TEXT NOT PRESENT] " + expectedText + " | " + locator);
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.invisibilityOfElementLocated(locator));
//			System.out.println("[TEXT REMOVED PASS] Not Found: " + expectedText);
//			return true;
//		} catch (Exception ex) {
//			System.out.println("[TEXT REMOVED FAIL] Still Found: " + expectedText);
//			captureFailure("VERIFY TEXT NOT PRESENT FAIL -> " + expectedText + " | " + locator, ex);
//			return false;
//		}
//	}
//
//	public boolean verifyTextNotPresentInNestedElements(By containerOrElementLocator, String expectedText) {
//		try {
//			String exp = expectedText == null ? "" : expectedText.trim();
//
//			System.out.println("[VERIFY NESTED TEXT NOT PRESENT] " + exp + " | " + containerOrElementLocator);
//
//			boolean ok = createWait(DEFAULT_WAITING_TIME_IN_SEC).until((ExpectedCondition<Boolean>) d -> {
//				try {
//					List<WebElement> els = d.findElements(containerOrElementLocator);
//
//					if (els == null || els.isEmpty())
//						return true;
//
//					WebElement el = els.get(0);
//
//					if (!el.isDisplayed())
//						return true;
//
//					String actual = (el.getText() == null) ? "" : el.getText().trim();
//					return !actual.contains(exp);
//
//				} catch (StaleElementReferenceException sere) {
//					return false;
//				} catch (NoSuchElementException nse) {
//					return true;
//				} catch (Exception e) {
//					return false;
//				}
//			});
//
//			System.out.println(ok ? "[NESTED TEXT NOT PRESENT PASS]" : "[NESTED TEXT NOT PRESENT FAIL]");
//			if (!ok) {
//				captureFailure("NESTED TEXT STILL PRESENT -> " + exp + " | " + containerOrElementLocator);
//			}
//			return ok;
//
//		} catch (Exception e) {
//			System.out.println("[NESTED TEXT NOT PRESENT FAIL] Still present: " + expectedText + " | "
//					+ containerOrElementLocator);
//			captureFailure("NESTED TEXT NOT PRESENT EXCEPTION -> " + expectedText + " | " + containerOrElementLocator,
//					e);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ CLICK IF… WRAPPERS
//	// ============================================================
//
//	public boolean clickOnElementIfClickable(WebElement element) {
//		return clickOnElement(element, "clickOnElementIfClickable -> " + element);
//	}
//
//	public boolean clickOnElementIfVisibleAndEnabled(WebElement element) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC,
//					"clickOnElementIfVisibleAndEnabled -> element");
//
//			if (element.isEnabled()) {
//				return clickOnElement(element, "clickOnElementIfVisibleAndEnabled -> element");
//			}
//
//			System.out.println("[CLICK BLOCKED] Element is visible but NOT enabled.");
//			captureFailure("CLICK BLOCKED (not enabled) -> clickOnElementIfVisibleAndEnabled");
//			return false;
//
//		} catch (Exception ex) {
//			System.out.println("[CLICK FAILED] Element not visible within wait time.");
//			captureFailure("CLICK FAILED -> clickOnElementIfVisibleAndEnabled", ex);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ ALERT HANDLERS
//	// ============================================================
//
//	public boolean acceptAlertIfPresent() {
//		try {
//			System.out.println("[ALERT WAIT] Accept");
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());
//
//			Alert alert = driver.switchTo().alert();
//			System.out.println("[ALERT TEXT] " + alert.getText());
//
//			alert.accept();
//			System.out.println("[ALERT ACCEPTED] Successfully.");
//			return true;
//
//		} catch (Exception ex) {
//			System.out.println("[ALERT ACCEPT FAILED]");
//			captureFailure("ALERT ACCEPT FAILED", ex);
//			return false;
//		}
//	}
//
//	public boolean dismissAlertIfPresent() {
//		try {
//			System.out.println("[ALERT WAIT] Dismiss");
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());
//
//			Alert alert = driver.switchTo().alert();
//			System.out.println("[ALERT TEXT] " + alert.getText());
//
//			alert.dismiss();
//			System.out.println("[ALERT DISMISSED] Successfully.");
//			return true;
//
//		} catch (Exception ex) {
//			System.out.println("[ALERT DISMISS FAILED]");
//			captureFailure("ALERT DISMISS FAILED", ex);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ COUNT / PRINT HELPERS
//	// ============================================================
//
//	public boolean verifyTotalElementsCount(int expectedCount, By locator) {
//		int actualCount = 0;
//
//		try {
//			System.out.println("[COUNT VERIFY] Expected: " + expectedCount + " | Locator: " + locator);
//
//			for (int i = 1; i <= 50; i++) {
//				actualCount = driver.findElements(locator).size();
//				if (actualCount == expectedCount) {
//					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
//					break;
//				}
//				Thread.sleep(200);
//			}
//
//			System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);
//
//			boolean ok = (actualCount == expectedCount);
//			if (!ok) {
//				captureFailure(
//						"COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount + " | " + locator);
//			}
//			return ok;
//
//		} catch (Exception ex) {
//			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
//			captureFailure("COUNT FAILED -> expected=" + expectedCount + " actual=" + actualCount + " | " + locator,
//					ex);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// (kept commented methods as-is)
//	// ============================================================
//
////	public boolean printAllBrandNamesInHomepage(int expectedCount, By locator) {
////		int actualCount = 0;
////
////		try {
////			System.out.println("[PRINT BRANDS] ExpectedCount: " + expectedCount + " | Locator: " + locator);
////
////			for (int i = 1; i <= 50; i++) {
////				actualCount = driver.findElements(locator).size();
////				if (actualCount == expectedCount) {
////					System.out.println("[BRANDS COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
////					break;
////				}
////				Thread.sleep(200);
////			}
////
////			List<WebElement> brandButtons = driver.findElements(locator);
////			actualCount = brandButtons.size();
////
////			Set<String> uniqueBrands = new LinkedHashSet<>();
////			for (WebElement btn : brandButtons) {
////				String brand = btn.getAttribute("title");
////				if (brand != null && !brand.trim().isEmpty())
////					uniqueBrands.add(brand.trim());
////			}
////
////			int count = 0;
////			for (String b : uniqueBrands) {
////				System.out.println((count + 1) + " Brand Name : " + b);
////				count++;
////				Thread.sleep(50);
////			}
////
////			System.out.println("[BRANDS SUMMARY] Expected: " + expectedCount + " | Actual: " + actualCount
////					+ " | Unique: " + uniqueBrands.size());
////
////			return (actualCount == expectedCount);
////
////		} catch (Exception ex) {
////			System.out.println("[PRINT BRANDS FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
////			return false;
////		}
////	}
////
////	public boolean verifyTotalElementsCount1(int expectedCount, By locator) {
////		int actualCount = 0;
////
////		try {
////			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////			wait.until(d -> d.findElements(locator).size() == expectedCount);
////
////			List<WebElement> brandButtons = driver.findElements(locator);
////			actualCount = brandButtons.size();
////
////			java.util.Set<String> uniqueBrands = new java.util.LinkedHashSet<>();
////			for (WebElement btn : brandButtons) {
////				String brand = btn.getAttribute("title");
////				if (brand != null) {
////					brand = brand.trim();
////					if (!brand.isEmpty())
////						uniqueBrands.add(brand);
////				}
////			}
////
////			if (uniqueBrands.isEmpty()) {
////				List<WebElement> nameSpans = driver.findElements(By.cssSelector(
////						"div.flex.items-center.w-max:first-child>button[title]>div>div:last-child>span:first-child"));
////				for (WebElement s : nameSpans) {
////					String t = s.getAttribute("textContent");
////					if (t != null) {
////						t = t.trim();
////						if (!t.isEmpty())
////							uniqueBrands.add(t);
////					}
////				}
////			}
////
////			int count = 0;
////			for (String b : uniqueBrands) {
////				System.out.println(count + 1 + " Brand Name : " + b);
////				count++;
////				Thread.sleep(50);
////			}
////
////			System.out.println("Count matching - expected count : " + expectedCount + " Found actual count is : "
////					+ actualCount + " | Unique names printed: " + uniqueBrands.size());
////
////			return (actualCount == expectedCount);
////
////		} catch (Exception ex) {
////			System.out.println(
////					"Count Not matching expected count : " + expectedCount + " Found actual count as : " + actualCount);
////			return false;
////		}
////	}
//}

package generic;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {

	protected final WebDriver driver;

	// ✅ GLOBAL screenshot utility (single instance for entire class)
	protected final ScreenshotUtility su;

	// ✅ constructor injection
	public AllVerifications(WebDriver driver) {
		this.driver = driver;
		this.su = new ScreenshotUtility(driver);
	}

	// ============================================================
	// ✅ CENTRAL CONFIG
	// ============================================================
	private static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
	private static final int DEFAULT_RETRY_COUNT = 2;

	protected WebDriverWait createWait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

	// ============================================================
	// ✅ INTERNAL: Screenshot capture wrapper (no extra failures)
	// ============================================================
	private void captureFailure(String tag) {
		try {
			System.out.println("[SCREENSHOT] " + tag);
			su.captureScreenshot();
		} catch (Exception ignore) {
			System.out.println("[SCREENSHOT FAILED] " + tag);
		}
	}

	private void captureFailure(String tag, Exception ex) {
		try {
			System.out.println("[SCREENSHOT] " + tag + " | ex=" + ex.getClass().getSimpleName());
			su.captureScreenshot();
		} catch (Exception ignore) {
			System.out.println("[SCREENSHOT FAILED] " + tag);
		}
	}

	// ============================================================
	// ✅ UNIVERSAL WAITS (By)
	// ============================================================

	public WebElement waitUntilElementPresent(By locator, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT PRESENCE] " + name + " | " + locator);
			return createWait(timeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException te) {
			System.out.println("[WAIT PRESENCE TIMEOUT] " + name + " | " + locator);
			captureFailure("WAIT PRESENCE TIMEOUT -> " + name + " | " + locator, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT PRESENCE FAILED] " + name + " | " + locator);
			e.printStackTrace();
			captureFailure("WAIT PRESENCE FAILED -> " + name + " | " + locator, e);
			return null;
		}
	}

	public WebElement waitUntilElementVisible(By locator, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT VISIBLE] " + name + " | " + locator);
			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException te) {
			System.out.println("[WAIT VISIBLE TIMEOUT] " + name + " | " + locator);
			captureFailure("WAIT VISIBLE TIMEOUT -> " + name + " | " + locator, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT VISIBLE FAILED] " + name + " | " + locator);
			e.printStackTrace();
			captureFailure("WAIT VISIBLE FAILED -> " + name + " | " + locator, e);
			return null;
		}
	}

	public boolean waitUntilElementInvisible(By locator, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT INVISIBLE] " + name + " | " + locator);
			boolean ok = createWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
			System.out.println("[WAIT INVISIBLE DONE] " + name + " -> " + ok);
			return ok;
		} catch (Exception e) {
			System.out.println("[WAIT INVISIBLE FAILED] " + name + " | " + locator);
			captureFailure("WAIT INVISIBLE FAILED -> " + name + " | " + locator, e);
			return false;
		}
	}

	public boolean isElementPresentInDOM(By locator) {
		try {
			return driver.findElements(locator).size() > 0;
		} catch (Exception e) {
			captureFailure("isElementPresentInDOM FAILED -> " + locator, e);
			return false;
		}
	}

	// ============================================================
	// ✅ UNIVERSAL WAITS (WebElement)
	// ============================================================

	public WebElement waitUntilElementVisible(WebElement element, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT VISIBLE] " + name);
			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException te) {
			System.out.println("[WAIT VISIBLE TIMEOUT] " + name);
			captureFailure("WAIT VISIBLE (element) TIMEOUT -> " + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT VISIBLE FAILED] " + name);
			e.printStackTrace();
			captureFailure("WAIT VISIBLE (element) FAILED -> " + name, e);
			return null;
		}
	}

	public WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT CLICKABLE] " + name);
			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException te) {
			System.out.println("[WAIT CLICKABLE TIMEOUT] " + name);
			captureFailure("WAIT CLICKABLE TIMEOUT -> " + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT CLICKABLE FAILED] " + name);
			e.printStackTrace();
			captureFailure("WAIT CLICKABLE FAILED -> " + name, e);
			return null;
		}
	}

	public WebElement waitUntilElementIsClickable(WebElement element, int timeoutSeconds, String elementName) {
		try {
			System.out.println("[WAIT ELEMENT IS CLICKABLE] " + elementName);
			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			System.out.println("[WAIT ELEMENT IS CLICKABLE FAILED] " + elementName);
			ex.printStackTrace();
			captureFailure("WAIT ELEMENT IS CLICKABLE FAILED -> " + elementName, ex);
			return null;
		}
	}

	// ============================================================
	// ✅ UNIVERSAL CLICK (WebElement / By)
	// ============================================================

	public boolean clickOnElement(WebElement element, String elementName) {
		boolean clicked = false;

		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
			try {
				System.out.println("[CLICK TRY " + attempt + "] " + elementName);

				waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
				waitUntilElementClickable(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);

				element.click();
				clicked = true;

				System.out.println("[CLICK SUCCESS] " + elementName);
				break;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[STALE ELEMENT] " + elementName + " | retrying...");
				captureFailure("CLICK STALE -> " + elementName, sere);

			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName);
				ex.printStackTrace();
				captureFailure("CLICK FAILED -> " + elementName, ex);
				break;
			}
		}

		return clicked;
	}

	public boolean clickOnElement(By locator, String elementName) {
		boolean clicked = false;

		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT; attempt++) {
			try {
				System.out.println("[CLICK TRY " + attempt + "] " + elementName + " | " + locator);

				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();

				clicked = true;
				System.out.println("[CLICK SUCCESS] " + elementName);
				break;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[STALE ELEMENT] " + elementName + " | " + locator + " | retrying...");
				captureFailure("CLICK(By) STALE -> " + elementName + " | " + locator, sere);

			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName + " | " + locator);
				ex.printStackTrace();
				captureFailure("CLICK(By) FAILED -> " + elementName + " | " + locator, ex);
				break;
			}
		}

		return clicked;
	}

	// ============================================================
	// ✅ SCROLL HELPERS
	// ============================================================

	public void scrollToElement(WebElement element, String name) {
		try {
			if (element == null) {
				System.out.println("[SCROLL FAILED] " + name + " -> element is NULL");
				captureFailure("SCROLL_FAILED_NULL_" + name);
				return;
			}

			System.out.println("[SCROLL] " + name);

			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'center'});", element);

			System.out.println("[SCROLL SUCCESS] " + name);

		} catch (Exception e) {
			System.out.println("[SCROLL FAILED] " + name);
			e.printStackTrace();
			captureFailure("SCROLL_FAILED_" + name, e);
		}
	}

	// ============================================================
	// ✅ TYPE + KEYS
	// ============================================================

	public boolean typeInInputField(WebElement element, String value, String fieldName) {
		boolean typed = false;

		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, fieldName);

			if (value == null) {
				System.out.println("[TYPE ERROR] " + fieldName + " value is NULL");
				captureFailure("TYPE NULL -> " + fieldName);
				return false;
			}

			String trimmed = value.trim();
			if (trimmed.isEmpty()) {
				System.out.println("[TYPE ERROR] " + fieldName + " value is EMPTY/WHITESPACE");
				captureFailure("TYPE EMPTY -> " + fieldName);
				return false;
			}

			element.clear();
			element.sendKeys(trimmed);

			typed = true;
			System.out.println("[TYPE SUCCESS] " + fieldName + " : " + trimmed);

		} catch (StaleElementReferenceException sere) {
			System.out.println("[STALE TYPE] " + fieldName + " | retrying once...");
			captureFailure("TYPE STALE -> " + fieldName, sere);

			try {
				element.clear();
				element.sendKeys(value.trim());
				typed = true;
				System.out.println("[TYPE SUCCESS AFTER RETRY] " + fieldName);
			} catch (Exception ex) {
				System.out.println("[TYPE FAILED AFTER RETRY] " + fieldName);
				ex.printStackTrace();
				captureFailure("TYPE FAILED AFTER RETRY -> " + fieldName, ex);
			}

		} catch (Exception ex) {
			System.out.println("[TYPE FAILED] " + fieldName);
			ex.printStackTrace();
			captureFailure("TYPE FAILED -> " + fieldName, ex);
		}

		return typed;
	}

	public boolean clearInputField(WebElement element, String fieldName) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, fieldName);
			element.clear();
			System.out.println("[CLEAR INPUT SUCCESS] " + fieldName);
			return true;
		} catch (StaleElementReferenceException sere) {
			System.out.println("[CLEAR INPUT STALE] " + fieldName + " | retrying once...");
			captureFailure("CLEAR INPUT STALE -> " + fieldName, sere);
			try {
				element.clear();
				System.out.println("[CLEAR INPUT SUCCESS AFTER RETRY] " + fieldName);
				return true;
			} catch (Exception ex) {
				System.out.println("[CLEAR INPUT FAILED AFTER RETRY] " + fieldName);
				ex.printStackTrace();
				captureFailure("CLEAR INPUT FAILED AFTER RETRY -> " + fieldName, ex);
				return false;
			}
		} catch (Exception ex) {
			System.out.println("[CLEAR INPUT FAILED] " + fieldName);
			ex.printStackTrace();
			captureFailure("CLEAR INPUT FAILED -> " + fieldName, ex);
			return false;
		}
	}

	public boolean pressKeyInElement(WebElement element, Keys key, String name) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
			element.sendKeys(key);
			System.out.println("[PRESS KEY SUCCESS] " + name + " -> " + key);
			return true;
		} catch (Exception e) {
			System.out.println("[PRESS KEY FAILED] " + name + " -> " + key);
			e.printStackTrace();
			captureFailure("PRESS KEY FAILED -> " + name + " -> " + key, e);
			return false;
		}
	}

	// ============================================================
	// ✅ TEXT / ATTRIBUTE / DISPLAY HELPERS
	// ============================================================

	public String getTextFromElement(WebElement element, String name) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
			String t = element.getText();
			t = (t == null) ? "" : t.trim();
			System.out.println("[GET TEXT] " + name + " -> " + t);
			return t;
		} catch (Exception e) {
			System.out.println("[GET TEXT FAILED] " + name);
			captureFailure("GET TEXT FAILED -> " + name, e);
			return "";
		}
	}

	public String getAttributeValueFromElement(WebElement element, String attributeName, String elementName) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);

			if (attributeName == null || attributeName.trim().isEmpty()) {
				System.out.println("[GET ATTRIBUTE FAILED] Attribute name is NULL/EMPTY for " + elementName);
				captureFailure("GET ATTRIBUTE NAME EMPTY -> " + elementName);
				return "";
			}

			String value = element.getAttribute(attributeName);
			value = (value == null) ? "" : value.trim();

			System.out.println("[GET ATTRIBUTE] " + elementName + " | " + attributeName + " -> " + value);
			return value;

		} catch (StaleElementReferenceException sere) {
			System.out.println("[GET ATTRIBUTE STALE] " + elementName + " | " + attributeName + " | retrying once...");
			captureFailure("GET ATTRIBUTE STALE -> " + elementName + " | " + attributeName, sere);

			try {
				String value = element.getAttribute(attributeName);
				value = (value == null) ? "" : value.trim();

				System.out.println(
						"[GET ATTRIBUTE SUCCESS AFTER RETRY] " + elementName + " | " + attributeName + " -> " + value);
				return value;

			} catch (Exception ex) {
				System.out.println("[GET ATTRIBUTE FAILED AFTER RETRY] " + elementName + " | " + attributeName);
				ex.printStackTrace();
				captureFailure("GET ATTRIBUTE FAILED AFTER RETRY -> " + elementName + " | " + attributeName, ex);
				return "";
			}

		} catch (Exception e) {
			System.out.println("[GET ATTRIBUTE FAILED] " + elementName + " | " + attributeName);
			e.printStackTrace();
			captureFailure("GET ATTRIBUTE FAILED -> " + elementName + " | " + attributeName, e);
			return "";
		}
	}

	public int getIntegerFromElementText(WebElement element, String name) {
		try {
			String txt = getTextFromElement(element, name);
			if (txt == null || txt.trim().isEmpty())
				return 0;
			return Integer.parseInt(txt.trim());
		} catch (Exception e) {
			System.out.println("[GET INT FAILED] " + name);
			captureFailure("GET INT FAILED -> " + name, e);
			return 0;
		}
	}

	public boolean isElementDisplayed(WebElement element, String name) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
			boolean ok = element.isDisplayed();
			System.out.println("[IS DISPLAYED] " + name + " -> " + ok);
			return ok;
		} catch (Exception e) {
			System.out.println("[IS DISPLAYED FAILED] " + name);
			captureFailure("IS DISPLAYED FAILED -> " + name, e);
			return false;
		}
	}

	// ============================================================
	// ✅ VERIFICATION METHODS
	// ============================================================

	public boolean verifyTitleOfWebpage(String expectedTitle) {
		boolean titleVerified = false;
		try {
			System.out.println("[VERIFY TITLE] Expected: " + expectedTitle);
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.titleIs(expectedTitle));
			titleVerified = true;
			System.out.println("[TITLE PASS] Expected: " + expectedTitle + " | Found: " + driver.getTitle());
		} catch (Exception ex) {
			System.out.println("[TITLE FAIL] Expected: " + expectedTitle + " | Found: " + safeTitle());
			captureFailure("VERIFY TITLE FAIL -> expected=" + expectedTitle, ex);
		}
		return titleVerified;
	}

	public boolean verifyUrlOfWebpage(String expectedUrl) {
		boolean urlVerified = false;
		try {
			System.out.println("[VERIFY URL] Expected: " + expectedUrl);
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.urlMatches(expectedUrl));
			urlVerified = true;
			System.out.println("[URL PASS] Expected: " + expectedUrl + " | Found: " + driver.getCurrentUrl());
		} catch (Exception ex) {
			System.out.println("[URL FAIL] Expected: " + expectedUrl + " | Found: " + safeUrl());
			captureFailure("VERIFY URL FAIL -> expected=" + expectedUrl, ex);
		}
		return urlVerified;
	}

	public boolean verifyTextPresent(WebElement element, String expectedText) {
		boolean textVerified = false;
		try {
			System.out.println("[VERIFY TEXT] Expected: " + expectedText);
			createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			textVerified = true;
			System.out.println("[TEXT PASS] Expected: " + expectedText + " | Found: " + safeGet(element));
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL] Expected: " + expectedText + " | Found: " + safeGet(element));
			captureFailure("VERIFY TEXT FAIL -> expected=" + expectedText, ex);
		}
		return textVerified;
	}

	private String safeGet(WebElement element) {
		try {
			String t = element.getText();
			return t == null ? "" : t;
		} catch (Exception e) {
			return "";
		}
	}

	private String safeTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			return "";
		}
	}

	private String safeUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			return "";
		}
	}

	public boolean verifyTextPresentIgnoreCase(String expectedText, WebElement element) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentIgnoreCase element");

			String actualText = element.getText() == null ? "" : element.getText().trim();
			String exp = expectedText == null ? "" : expectedText.trim();

			boolean ok = actualText.equalsIgnoreCase(exp);
			System.out.println(ok ? "[TEXT PASS - IGNORECASE]"
					: "[TEXT FAIL - IGNORECASE]" + " Expected: " + exp + " | Found: " + actualText);

			if (!ok) {
				captureFailure("VERIFY TEXT IGNORECASE FAIL -> expected=" + exp + " found=" + actualText);
			}

			return ok;
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL - IGNORECASE] Element not found or exception.");
			captureFailure("VERIFY TEXT IGNORECASE EXCEPTION", ex);
			return false;
		}
	}

	public boolean verifyTextPresentWithNumbers(String expectedPattern, WebElement element) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, "verifyTextPresentWithNumbers element");
			String actualText = element.getText() == null ? "" : element.getText().trim();

			boolean ok = actualText.matches(expectedPattern);
			System.out.println(ok ? "[TEXT PASS - PATTERN] " + actualText
					: "[TEXT FAIL - PATTERN] Expected Pattern: " + expectedPattern + " | Found: " + actualText);

			if (!ok) {
				captureFailure("VERIFY TEXT PATTERN FAIL -> pattern=" + expectedPattern + " found=" + actualText);
			}

			return ok;
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL - PATTERN] Element not found or pattern not matched.");
			captureFailure("VERIFY TEXT PATTERN EXCEPTION -> pattern=" + expectedPattern, ex);
			return false;
		}
	}

	public boolean verifyTextNotPresent(String expectedText, By locator) {
		try {
			System.out.println("[VERIFY TEXT NOT PRESENT] " + expectedText + " | " + locator);
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.invisibilityOfElementLocated(locator));
			System.out.println("[TEXT REMOVED PASS] Not Found: " + expectedText);
			return true;
		} catch (Exception ex) {
			System.out.println("[TEXT REMOVED FAIL] Still Found: " + expectedText);
			captureFailure("VERIFY TEXT NOT PRESENT FAIL -> " + expectedText + " | " + locator, ex);
			return false;
		}
	}

	public boolean verifyTextNotPresentInNestedElements(By containerOrElementLocator, String expectedText) {
		try {
			String exp = expectedText == null ? "" : expectedText.trim();

			System.out.println("[VERIFY NESTED TEXT NOT PRESENT] " + exp + " | " + containerOrElementLocator);

			boolean ok = createWait(DEFAULT_WAITING_TIME_IN_SEC).until((ExpectedCondition<Boolean>) d -> {
				try {
					List<WebElement> els = d.findElements(containerOrElementLocator);

					if (els == null || els.isEmpty())
						return true;

					WebElement el = els.get(0);

					if (!el.isDisplayed())
						return true;

					String actual = (el.getText() == null) ? "" : el.getText().trim();
					return !actual.contains(exp);

				} catch (StaleElementReferenceException sere) {
					return false;
				} catch (NoSuchElementException nse) {
					return true;
				} catch (Exception e) {
					return false;
				}
			});

			System.out.println(ok ? "[NESTED TEXT NOT PRESENT PASS]" : "[NESTED TEXT NOT PRESENT FAIL]");
			if (!ok) {
				captureFailure("NESTED TEXT STILL PRESENT -> " + exp + " | " + containerOrElementLocator);
			}
			return ok;

		} catch (Exception e) {
			System.out.println("[NESTED TEXT NOT PRESENT FAIL] Still present: " + expectedText + " | "
					+ containerOrElementLocator);
			captureFailure("NESTED TEXT NOT PRESENT EXCEPTION -> " + expectedText + " | " + containerOrElementLocator,
					e);
			return false;
		}
	}

	// ============================================================
	// ✅ CLICK IF… WRAPPERS
	// ============================================================

	public boolean clickOnElementIfClickable(WebElement element) {
		return clickOnElement(element, "clickOnElementIfClickable -> " + element);
	}

	public boolean clickOnElementIfVisibleAndEnabled(WebElement element) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC,
					"clickOnElementIfVisibleAndEnabled -> element");

			if (element.isEnabled()) {
				return clickOnElement(element, "clickOnElementIfVisibleAndEnabled -> element");
			}

			System.out.println("[CLICK BLOCKED] Element is visible but NOT enabled.");
			captureFailure("CLICK BLOCKED (not enabled) -> clickOnElementIfVisibleAndEnabled");
			return false;

		} catch (Exception ex) {
			System.out.println("[CLICK FAILED] Element not visible within wait time.");
			captureFailure("CLICK FAILED -> clickOnElementIfVisibleAndEnabled", ex);
			return false;
		}
	}

	// ============================================================
	// ✅ ALERT HANDLERS
	// ============================================================

	public boolean acceptAlertIfPresent() {
		try {
			System.out.println("[ALERT WAIT] Accept");
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			System.out.println("[ALERT TEXT] " + alert.getText());

			alert.accept();
			System.out.println("[ALERT ACCEPTED] Successfully.");
			return true;

		} catch (NoAlertPresentException ex) {
			System.out.println("[ALERT ACCEPT FAILED] No alert present.");
			captureFailure("ALERT ACCEPT FAILED - NO ALERT", ex);
			return false;
		} catch (Exception ex) {
			System.out.println("[ALERT ACCEPT FAILED]");
			captureFailure("ALERT ACCEPT FAILED", ex);
			return false;
		}
	}

	public boolean dismissAlertIfPresent() {
		try {
			System.out.println("[ALERT WAIT] Dismiss");
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			System.out.println("[ALERT TEXT] " + alert.getText());

			alert.dismiss();
			System.out.println("[ALERT DISMISSED] Successfully.");
			return true;

		} catch (NoAlertPresentException ex) {
			System.out.println("[ALERT DISMISS FAILED] No alert present.");
			captureFailure("ALERT DISMISS FAILED - NO ALERT", ex);
			return false;
		} catch (Exception ex) {
			System.out.println("[ALERT DISMISS FAILED]");
			captureFailure("ALERT DISMISS FAILED", ex);
			return false;
		}
	}

	// ============================================================
	// ✅ COUNT / PRINT HELPERS
	// ============================================================

	public boolean verifyTotalElementsCount(int expectedCount, By locator) {
		int actualCount = 0;

		try {
			System.out.println("[COUNT VERIFY] Expected: " + expectedCount + " | Locator: " + locator);

			for (int i = 1; i <= 50; i++) {
				actualCount = driver.findElements(locator).size();
				if (actualCount == expectedCount) {
					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
					break;
				}
				Thread.sleep(200);
			}

			System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);

			boolean ok = (actualCount == expectedCount);
			if (!ok) {
				captureFailure(
						"COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount + " | " + locator);
			}
			return ok;

		} catch (Exception ex) {
			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
			captureFailure("COUNT FAILED -> expected=" + expectedCount + " actual=" + actualCount + " | " + locator,
					ex);
			return false;
		}
	}

	// ============================================================
	// (kept commented methods as-is)
	// ============================================================

//	public boolean printAllBrandNamesInHomepage(int expectedCount, By locator) {
//		int actualCount = 0;
//
//		try {
//			System.out.println("[PRINT BRANDS] ExpectedCount: " + expectedCount + " | Locator: " + locator);
//
//			for (int i = 1; i <= 50; i++) {
//				actualCount = driver.findElements(locator).size();
//				if (actualCount == expectedCount) {
//					System.out.println("[BRANDS COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
//					break;
//				}
//				Thread.sleep(200);
//			}
//
//			List<WebElement> brandButtons = driver.findElements(locator);
//			actualCount = brandButtons.size();
//
//			Set<String> uniqueBrands = new LinkedHashSet<>();
//			for (WebElement btn : brandButtons) {
//				String brand = btn.getAttribute("title");
//				if (brand != null && !brand.trim().isEmpty())
//					uniqueBrands.add(brand.trim());
//			}
//
//			int count = 0;
//			for (String b : uniqueBrands) {
//				System.out.println((count + 1) + " Brand Name : " + b);
//				count++;
//				Thread.sleep(50);
//			}
//
//			System.out.println("[BRANDS SUMMARY] Expected: " + expectedCount + " | Actual: " + actualCount
//					+ " | Unique: " + uniqueBrands.size());
//
//			return (actualCount == expectedCount);
//
//		} catch (Exception ex) {
//			System.out.println("[PRINT BRANDS FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
//			return false;
//		}
//	}
//
//	public boolean verifyTotalElementsCount1(int expectedCount, By locator) {
//		int actualCount = 0;
//
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(d -> d.findElements(locator).size() == expectedCount);
//
//			List<WebElement> brandButtons = driver.findElements(locator);
//			actualCount = brandButtons.size();
//
//			java.util.Set<String> uniqueBrands = new java.util.LinkedHashSet<>();
//			for (WebElement btn : brandButtons) {
//				String brand = btn.getAttribute("title");
//				if (brand != null) {
//					brand = brand.trim();
//					if (!brand.isEmpty())
//						uniqueBrands.add(brand);
//				}
//			}
//
//			if (uniqueBrands.isEmpty()) {
//				List<WebElement> nameSpans = driver.findElements(By.cssSelector(
//						"div.flex.items-center.w-max:first-child>button[title]>div>div:last-child>span:first-child"));
//				for (WebElement s : nameSpans) {
//					String t = s.getAttribute("textContent");
//					if (t != null) {
//						t = t.trim();
//						if (!t.isEmpty())
//							uniqueBrands.add(t);
//					}
//				}
//			}
//
//			int count = 0;
//			for (String b : uniqueBrands) {
//				System.out.println(count + 1 + " Brand Name : " + b);
//				count++;
//				Thread.sleep(50);
//			}
//
//			System.out.println("Count matching - expected count : " + expectedCount + " Found actual count is : "
//					+ actualCount + " | Unique names printed: " + uniqueBrands.size());
//
//			return (actualCount == expectedCount);
//
//		} catch (Exception ex) {
//			System.out.println(
//					"Count Not matching expected count : " + expectedCount + " Found actual count as : " + actualCount);
//			return false;
//		}
//	}
}