package generic;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {

	protected final WebDriver driver;
	protected final ScreenshotUtility su;

	// ✅ constructor injection
	public AllVerifications(WebDriver driver) {
		this.driver = driver;
		this.su = new ScreenshotUtility(driver);
	}

	// ============================================================
	// ✅ CENTRAL CONFIG
	// ============================================================
	protected static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
	private static final int DEFAULT_RETRY_COUNT = 2;

	protected WebDriverWait createWait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

	// ============================================================
	// ✅ SCREENSHOT HELPERS
	// ============================================================
	private String safeTag(String tag) {
		if (tag == null || tag.trim().isEmpty())
			return "UNKNOWN";
		return tag.replaceAll("[^a-zA-Z0-9-_]", "_");
	}

	protected void captureFailure(String tag) {
		try {
			su.captureScreenshot(); // your utility already makes unique name
			System.out.println("[SCREENSHOT CAPTURED] " + safeTag(tag));
		} catch (Exception e) {
			System.out.println("[SCREENSHOT FAILED] " + safeTag(tag));
		}
	}

	protected void captureFailure(String tag, Exception ex) {
		try {
			su.captureScreenshot();
			System.out.println("[SCREENSHOT CAPTURED] " + safeTag(tag) + " | "
					+ (ex == null ? "" : ex.getClass().getSimpleName()));
		} catch (Exception e) {
			System.out.println("[SCREENSHOT FAILED] " + safeTag(tag));
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
			captureFailure("WAIT_PRESENCE_TIMEOUT_" + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT PRESENCE FAILED] " + name + " | " + locator);
			e.printStackTrace();
			captureFailure("WAIT_PRESENCE_FAILED_" + name, e);
			return null;
		}
	}

	public WebElement waitUntilElementVisible(By locator, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT VISIBLE] " + name + " | " + locator);
			return createWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException te) {
			System.out.println("[WAIT VISIBLE TIMEOUT] " + name + " | " + locator);
			captureFailure("WAIT_VISIBLE_TIMEOUT_" + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT VISIBLE FAILED] " + name + " | " + locator);
			e.printStackTrace();
			captureFailure("WAIT_VISIBLE_FAILED_" + name, e);
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
			e.printStackTrace();
			captureFailure("WAIT_INVISIBLE_FAILED_" + name, e);
			return false;
		}
	}

	public boolean isElementPresentInDOM(By locator) {
		try {
			return driver.findElements(locator).size() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			captureFailure("IS_ELEMENT_PRESENT_IN_DOM_FAILED", e);
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
			captureFailure("WAIT_VISIBLE_ELEMENT_TIMEOUT_" + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT VISIBLE FAILED] " + name);
			e.printStackTrace();
			captureFailure("WAIT_VISIBLE_ELEMENT_FAILED_" + name, e);
			return null;
		}
	}

	public WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds, String name) {
		try {
			System.out.println("[WAIT CLICKABLE] " + name);
			return createWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException te) {
			System.out.println("[WAIT CLICKABLE TIMEOUT] " + name);
			captureFailure("WAIT_CLICKABLE_TIMEOUT_" + name, te);
			return null;
		} catch (Exception e) {
			System.out.println("[WAIT CLICKABLE FAILED] " + name);
			e.printStackTrace();
			captureFailure("WAIT_CLICKABLE_FAILED_" + name, e);
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
				captureFailure("CLICK_STALE_" + elementName, sere);
			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName);
				ex.printStackTrace();
				captureFailure("CLICK_FAILED_" + elementName, ex);
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
				captureFailure("CLICK_BY_STALE_" + elementName, sere);
			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName + " | " + locator);
				ex.printStackTrace();
				captureFailure("CLICK_BY_FAILED_" + elementName, ex);
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
				captureFailure("TYPE_NULL_" + fieldName);
				return false;
			}

			String trimmed = value.trim();
			if (trimmed.isEmpty()) {
				System.out.println("[TYPE ERROR] " + fieldName + " value is EMPTY/WHITESPACE");
				captureFailure("TYPE_EMPTY_" + fieldName);
				return false;
			}

			element.clear();
			element.sendKeys(trimmed);

			typed = true;
			System.out.println("[TYPE SUCCESS] " + fieldName + " : " + trimmed);

		} catch (StaleElementReferenceException sere) {
			System.out.println("[STALE TYPE] " + fieldName + " | retrying once...");
			captureFailure("TYPE_STALE_" + fieldName, sere);

			try {
				element.clear();
				element.sendKeys(value.trim());
				typed = true;
			} catch (Exception ex) {
				System.out.println("[TYPE FAILED AFTER RETRY] " + fieldName);
				ex.printStackTrace();
				captureFailure("TYPE_FAILED_AFTER_RETRY_" + fieldName, ex);
			}

		} catch (Exception ex) {
			System.out.println("[TYPE FAILED] " + fieldName);
			ex.printStackTrace();
			captureFailure("TYPE_FAILED_" + fieldName, ex);
		}

		return typed;
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
			captureFailure("PRESS_KEY_FAILED_" + name + "_" + key, e);
			return false;
		}
	}

	// ============================================================
	// ✅ TEXT / DISPLAY HELPERS
	// ============================================================

	public String getTextFromElement(WebElement element, String name) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
			String t = element.getText();
			t = (t == null) ? "" : t.trim();
			System.out.println("[GOT TEXT] " + name + " -> " + t);
			return t;
		} catch (Exception e) {
			System.out.println("[GETTING TEXT FAILED] " + name);
			e.printStackTrace();
			captureFailure("GET_TEXT_FAILED_" + name, e);
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
			e.printStackTrace();
			captureFailure("GET_INT_FAILED_" + name, e);
			return 0;
		}
	}

	public boolean isElementDisplayed(WebElement element, String name) {
		try {
			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
			boolean ok = element.isDisplayed();
			System.out.println("[IS DISPLAYED] " + name + " -> " + ok);

			if (!ok) {
				captureFailure("IS_DISPLAYED_FALSE_" + name);
			}
			return ok;

		} catch (Exception e) {
			System.out.println("[IS DISPLAYED FAILED] " + name);
			e.printStackTrace();
			captureFailure("IS_DISPLAYED_FAILED_" + name, e);
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
			ex.printStackTrace();
			captureFailure("VERIFY_TITLE_FAIL_" + expectedTitle, ex);
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
			ex.printStackTrace();
			captureFailure("VERIFY_URL_FAIL_" + expectedUrl, ex);
		}
		return urlVerified;
	}

	public boolean verifyTextPresent(String expectedText, WebElement element) {
		boolean textVerified = false;
		try {
			System.out.println("[VERIFY TEXT] Expected: " + expectedText);
			createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			textVerified = true;
			System.out.println("[TEXT PASS] Expected: " + expectedText + " | Found: " + safeGet(element));
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL] Expected: " + expectedText + " | Found: " + safeGet(element));
			ex.printStackTrace();
			captureFailure("VERIFY_TEXT_FAIL_" + expectedText, ex);
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
				captureFailure("VERIFY_TEXT_IGNORECASE_FAIL_expected_" + exp + "_found_" + actualText);
			}

			return ok;
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL - IGNORECASE] Element not found or exception.");
			ex.printStackTrace();
			captureFailure("VERIFY_TEXT_IGNORECASE_EXCEPTION_" + expectedText, ex);
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
				captureFailure("VERIFY_TEXT_PATTERN_FAIL_pattern_" + expectedPattern + "_found_" + actualText);
			}

			return ok;
		} catch (Exception ex) {
			System.out.println("[TEXT FAIL - PATTERN] Element not found or pattern not matched.");
			ex.printStackTrace();
			captureFailure("VERIFY_TEXT_PATTERN_EXCEPTION_" + expectedPattern, ex);
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
			ex.printStackTrace();
			captureFailure("VERIFY_TEXT_NOT_PRESENT_FAIL_" + expectedText, ex);
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
				captureFailure("VERIFY_NESTED_TEXT_NOT_PRESENT_FAIL_" + exp);
			}
			return ok;

		} catch (Exception e) {
			System.out.println("[NESTED TEXT NOT PRESENT FAIL] Still present: " + expectedText + " | "
					+ containerOrElementLocator);
			e.printStackTrace();
			captureFailure("VERIFY_NESTED_TEXT_NOT_PRESENT_EXCEPTION_" + expectedText, e);
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
			captureFailure("CLICK_BLOCKED_NOT_ENABLED");
			return false;

		} catch (Exception ex) {
			System.out.println("[CLICK FAILED] Element not visible within wait time.");
			ex.printStackTrace();
			captureFailure("CLICK_VISIBLE_ENABLED_FAILED", ex);
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

		} catch (Exception ex) {
			System.out.println("[ALERT ACCEPT FAILED]");
			ex.printStackTrace();
			captureFailure("ALERT_ACCEPT_FAILED", ex);
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

		} catch (Exception ex) {
			System.out.println("[ALERT DISMISS FAILED]");
			ex.printStackTrace();
			captureFailure("ALERT_DISMISS_FAILED", ex);
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
				captureFailure("COUNT_MISMATCH_expected_" + expectedCount + "_actual_" + actualCount);
			}
			return ok;

		} catch (Exception ex) {
			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
			ex.printStackTrace();
			captureFailure("COUNT_FAILED_expected_" + expectedCount + "_actual_" + actualCount, ex);
			return false;
		}
	}
}