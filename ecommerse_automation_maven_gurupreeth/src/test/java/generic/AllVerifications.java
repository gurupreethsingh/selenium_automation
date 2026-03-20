//package generic;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.ElementClickInterceptedException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
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
//		this.su = new ScreenshotUtility(driver);
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
//	protected void captureFailure(String tag) {
//		try {
//			System.out.println("[SCREENSHOT] " + tag);
//			su.captureScreenshot();
//		} catch (Exception ignore) {
//			System.out.println("[SCREENSHOT FAILED] " + tag);
//		}
//	}
//
//	protected void captureFailure(String tag, Exception ex) {
//		try {
//			System.out.println("[SCREENSHOT] " + tag + " | ex=" + ex.getClass().getSimpleName());
//			su.captureScreenshot();
//		} catch (Exception ignore) {
//			System.out.println("[SCREENSHOT FAILED] " + tag);
//		}
//	}
//
//	// universal click function with all the waits to click on element
//	public boolean clickOnElement(WebElement element, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (element == null) {
//					throw new IllegalArgumentException("Element is null");
//				}
//
//				String displayName = (elementName == null || elementName.trim().isEmpty())
//						? getElementDisplayName(element)
//						: elementName.trim();
//
//				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName);
//
//				// 1. Check if element reference is alive / present
//				try {
//					element.isDisplayed();
//				} catch (StaleElementReferenceException sere) {
//					throw sere;
//				} catch (Exception ex) {
//					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
//				}
//
//				// 2. Scroll to element
//				scrollElementToCenter(element);
//
//				// 3. Wait until visible
//				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOf(element));
//
//				// 4. Wait until clickable
//				WebElement clickableElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.elementToBeClickable(visibleElement));
//
//				// 5. Check enabled
//				if (!clickableElement.isEnabled()) {
//					throw new IllegalStateException("Element is disabled: " + displayName);
//				}
//
//				// 6. Capture clicked text/name
//				String clickedText = getCleanText(clickableElement);
//				if (clickedText == null || clickedText.trim().isEmpty()) {
//					clickedText = displayName;
//				}
//
//				System.out.println("[CLICKING ELEMENT] " + clickedText);
//
//				// 7. Click with fallback chain
//				try {
//					clickableElement.click();
//				} catch (ElementClickInterceptedException e1) {
//					try {
//						new Actions(driver).moveToElement(clickableElement).pause(Duration.ofMillis(200)).click()
//								.perform();
//					} catch (Exception e2) {
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableElement);
//					}
//				}
//
//				System.out.println("[CLICK SUCCESS] " + clickedText);
//				return true;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
//				captureFailure("CLICK STALE -> " + elementName, sere);
//
//			} catch (Exception ex) {
//				System.out.println("[CLICK FAILED] " + elementName + " | " + ex.getMessage());
//				captureFailure("CLICK FAILED -> " + elementName, ex);
//				return false;
//			}
//		}
//
//		System.out.println("[CLICK FAILED AFTER RETRIES] " + elementName);
//		captureFailure("CLICK FAILED AFTER RETRIES -> " + elementName);
//		return false;
//	}
//
//	public boolean clickOnElement(By locator, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (locator == null) {
//					throw new IllegalArgumentException("Locator is null");
//				}
//
//				String displayName = (elementName == null || elementName.trim().isEmpty()) ? locator.toString()
//						: elementName.trim();
//
//				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName + " | " + locator);
//
//				// 1. Check presence
//				List<WebElement> found = driver.findElements(locator);
//				if (found.isEmpty()) {
//					throw new NoSuchElementException("Element is not present in DOM: " + locator);
//				}
//
//				// 2. Wait for presence
//				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//				// 3. Scroll to element
//				scrollElementToCenter(element);
//
//				// 4. Wait until visible
//				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//				// 5. Wait until clickable
//				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.elementToBeClickable(locator));
//
//				// 6. Check enabled
//				if (!element.isEnabled()) {
//					throw new IllegalStateException("Element is disabled: " + displayName);
//				}
//
//				// 7. Capture clicked text/name
//				String clickedText = getCleanText(element);
//				if (clickedText == null || clickedText.trim().isEmpty()) {
//					clickedText = displayName;
//				}
//
//				System.out.println("[CLICKING ELEMENT] " + clickedText);
//
//				// 8. Click with fallback chain
//				try {
//					element.click();
//				} catch (ElementClickInterceptedException e1) {
//					try {
//						new Actions(driver).moveToElement(element).pause(Duration.ofMillis(200)).click().perform();
//					} catch (Exception e2) {
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//					}
//				}
//
//				System.out.println("[CLICK SUCCESS] " + clickedText);
//				return true;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
//				captureFailure("CLICK STALE -> " + elementName, sere);
//
//			} catch (Exception ex) {
//				System.out.println("[CLICK FAILED] " + elementName + " | " + ex.getMessage());
//				captureFailure("CLICK FAILED -> " + elementName, ex);
//				return false;
//			}
//		}
//
//		System.out.println("[CLICK FAILED AFTER RETRIES] " + elementName);
//		captureFailure("CLICK FAILED AFTER RETRIES -> " + elementName);
//		return false;
//	}
//
//	public boolean verifyText(WebElement element, String expectedText, String name, String matchType,
//			boolean ignoreCase) {
//		try {
//			if (element == null) {
//				throw new IllegalArgumentException("Element is null");
//			}
//
//			expectedText = (expectedText == null) ? "" : expectedText.trim();
//			matchType = (matchType == null) ? "" : matchType.trim().toLowerCase();
//
//			if (expectedText.isEmpty()) {
//				throw new IllegalArgumentException("Expected text is null or empty");
//			}
//
//			if (!matchType.equals("equals") && !matchType.equals("contains") && !matchType.equals("regex")) {
//				throw new IllegalArgumentException("Invalid matchType: " + matchType);
//			}
//
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, name);
//
//			String actualText = element.getText();
//			actualText = (actualText == null) ? "" : actualText.trim();
//
//			System.out.println("[TEXT VERIFY]");
//			System.out.println("Element Name   : " + name);
//			System.out.println("Match Type     : " + matchType);
//			System.out.println("Ignore Case    : " + ignoreCase);
//			System.out.println("Expected Text  : " + expectedText);
//			System.out.println("Actual Text    : " + actualText);
//
//			boolean result = false;
//
//			switch (matchType) {
//			case "equals":
//				result = ignoreCase ? actualText.equalsIgnoreCase(expectedText) : actualText.equals(expectedText);
//				break;
//
//			case "contains":
//				result = ignoreCase ? actualText.toLowerCase().contains(expectedText.toLowerCase())
//						: actualText.contains(expectedText);
//				break;
//
//			case "regex":
//				try {
//					Pattern pattern = ignoreCase ? Pattern.compile(expectedText, Pattern.CASE_INSENSITIVE)
//							: Pattern.compile(expectedText);
//
//					result = pattern.matcher(actualText).matches();
//				} catch (PatternSyntaxException ex) {
//					throw new IllegalArgumentException("Invalid regex pattern: " + expectedText, ex);
//				}
//				break;
//			}
//
//			if (result) {
//				System.out.println("[TEXT PASS] " + name + " | Match Type: " + matchType);
//			} else {
//				System.out.println("[TEXT FAIL] " + name + " | Match Type: " + matchType);
//				captureFailure("TEXT VERIFICATION FAILED -> Name: " + name + " | MatchType: " + matchType
//						+ " | IgnoreCase: " + ignoreCase + " | Expected: " + expectedText + " | Actual: " + actualText);
//			}
//
//			return result;
//
//		} catch (Exception e) {
//			System.out.println("[TEXT VERIFY FAILED] " + name);
//			captureFailure("TEXT VERIFY FAILED -> " + name, e);
//			return false;
//		}
//	}
//
//	public String getAttributeValueFromElement(WebElement element, String attributeName, String elementName) {
//		try {
//			waitUntilElementVisible(element, DEFAULT_WAITING_TIME_IN_SEC, elementName);
//
//			if (attributeName == null || attributeName.trim().isEmpty()) {
//				System.out.println("[GET ATTRIBUTE FAILED] Attribute name is NULL/EMPTY for " + elementName);
//				captureFailure("GET ATTRIBUTE NAME EMPTY -> " + elementName);
//				return "";
//			}
//
//			String value = element.getAttribute(attributeName);
//			value = (value == null) ? "" : value.trim();
//
//			System.out.println("[GET ATTRIBUTE] " + elementName + " | " + attributeName + " -> " + value);
//			return value;
//
//		} catch (StaleElementReferenceException sere) {
//			System.out.println("[GET ATTRIBUTE STALE] " + elementName + " | " + attributeName + " | retrying once...");
//			captureFailure("GET ATTRIBUTE STALE -> " + elementName + " | " + attributeName, sere);
//
//			try {
//				String value = element.getAttribute(attributeName);
//				value = (value == null) ? "" : value.trim();
//
//				System.out.println(
//						"[GET ATTRIBUTE SUCCESS AFTER RETRY] " + elementName + " | " + attributeName + " -> " + value);
//				return value;
//
//			} catch (Exception ex) {
//				System.out.println("[GET ATTRIBUTE FAILED AFTER RETRY] " + elementName + " | " + attributeName);
//				ex.printStackTrace();
//				captureFailure("GET ATTRIBUTE FAILED AFTER RETRY -> " + elementName + " | " + attributeName, ex);
//				return "";
//			}
//
//		} catch (Exception e) {
//			System.out.println("[GET ATTRIBUTE FAILED] " + elementName + " | " + attributeName);
//			e.printStackTrace();
//			captureFailure("GET ATTRIBUTE FAILED -> " + elementName + " | " + attributeName, e);
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
//
//		try {
//			expectedTitle = (expectedTitle == null) ? "" : expectedTitle.trim();
//
//			if (expectedTitle.isEmpty()) {
//				throw new IllegalArgumentException("Expected title is null or empty");
//			}
//
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
//				String title = driver.getTitle();
//				return title != null && !title.trim().isEmpty();
//			});
//
//			String actualTitle = driver.getTitle();
//			actualTitle = (actualTitle == null) ? "" : actualTitle.trim();
//
//			String normalizedExpected = normalizeTitleVerificationText(expectedTitle);
//			String normalizedActual = normalizeTitleVerificationText(actualTitle);
//
//			System.out.println("[VERIFY TITLE]");
//			System.out.println("Expected Input      : " + expectedTitle);
//			System.out.println("Actual Title        : " + actualTitle);
//			System.out.println("Normalized Expected : " + normalizedExpected);
//			System.out.println("Normalized Actual   : " + normalizedActual);
//
//			if (actualTitle.equalsIgnoreCase(expectedTitle)) {
//				titleVerified = true;
//				System.out.println("[TITLE PASS] Match Type: EXACT");
//			} else if (actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
//				titleVerified = true;
//				System.out.println("[TITLE PASS] Match Type: PARTIAL");
//			} else if (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected)) {
//				titleVerified = true;
//				System.out.println("[TITLE PASS] Match Type: NORMALIZED PARTIAL");
//			} else if (isValidTitleRegex(expectedTitle) && actualTitle.matches(expectedTitle)) {
//				titleVerified = true;
//				System.out.println("[TITLE PASS] Match Type: REGEX");
//			}
//
//			if (titleVerified) {
//				System.out.println("[TITLE PASS] Expected: " + expectedTitle + " | Found: " + actualTitle);
//			} else {
//				System.out.println("[TITLE FAIL] Expected: " + expectedTitle + " | Found: " + actualTitle);
//				captureFailure("VERIFY TITLE FAIL -> expected=" + expectedTitle + " | actual=" + actualTitle);
//			}
//
//		} catch (Exception ex) {
//			System.out.println("[TITLE VERIFY EXCEPTION] Expected: " + expectedTitle + " | Found: " + safeTitle());
//			captureFailure("VERIFY TITLE EXCEPTION -> expected=" + expectedTitle, ex);
//		}
//
//		return titleVerified;
//	}
//
//	private String normalizeTitleVerificationText(String value) {
//		if (value == null) {
//			return "";
//		}
//		return value.replaceAll("[^A-Za-z0-9]", "").toLowerCase().trim();
//	}
//
//	private boolean isValidTitleRegex(String value) {
//		try {
//			Pattern.compile(value);
//			return true;
//		} catch (PatternSyntaxException ex) {
//			return false;
//		}
//	}
//
//	public boolean verifyUrlOfWebpage(String expectedUrl) {
//		boolean urlVerified = false;
//
//		try {
//			expectedUrl = (expectedUrl == null) ? "" : expectedUrl.trim();
//
//			if (expectedUrl.isEmpty()) {
//				throw new IllegalArgumentException("Expected URL is null or empty");
//			}
//
//			String actualUrl = driver.getCurrentUrl();
//			actualUrl = (actualUrl == null) ? "" : actualUrl.trim();
//
//			String decodedActualUrl = URLDecoder.decode(actualUrl, StandardCharsets.UTF_8);
//
//			String normalizedExpected = normalizeUrlVerificationText(expectedUrl);
//			String normalizedActual = normalizeUrlVerificationText(decodedActualUrl);
//
//			System.out.println("[VERIFY URL]");
//			System.out.println("Expected Input      : " + expectedUrl);
//			System.out.println("Actual URL          : " + actualUrl);
//			System.out.println("Decoded Actual URL  : " + decodedActualUrl);
//			System.out.println("Normalized Expected : " + normalizedExpected);
//			System.out.println("Normalized Actual   : " + normalizedActual);
//
//			if (decodedActualUrl.equalsIgnoreCase(expectedUrl)) {
//				urlVerified = true;
//				System.out.println("[URL PASS] Match Type: EXACT");
//			} else if (decodedActualUrl.toLowerCase().contains(expectedUrl.toLowerCase())) {
//				urlVerified = true;
//				System.out.println("[URL PASS] Match Type: PARTIAL");
//			} else if (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected)) {
//				urlVerified = true;
//				System.out.println("[URL PASS] Match Type: NORMALIZED PARTIAL");
//			} else if (isValidRegex(expectedUrl) && decodedActualUrl.matches(expectedUrl)) {
//				urlVerified = true;
//				System.out.println("[URL PASS] Match Type: REGEX");
//			}
//
//			if (urlVerified) {
//				System.out.println("[URL PASS] Expected: " + expectedUrl + " | Found: " + actualUrl);
//			} else {
//				System.out.println("[URL FAIL] Expected: " + expectedUrl + " | Found: " + actualUrl);
//				captureFailure("VERIFY URL FAIL -> expected=" + expectedUrl + " | actual=" + actualUrl
//						+ " | decodedActual=" + decodedActualUrl);
//			}
//
//		} catch (Exception ex) {
//			System.out.println("[URL VERIFY EXCEPTION] Expected: " + expectedUrl + " | Found: " + safeUrl());
//			captureFailure("VERIFY URL EXCEPTION -> expected=" + expectedUrl, ex);
//		}
//
//		return urlVerified;
//	}
//
//	private String normalizeUrlVerificationText(String value) {
//		if (value == null) {
//			return "";
//		}
//		return value.replaceAll("[^A-Za-z0-9]", "").toLowerCase().trim();
//	}
//
//	private boolean isValidRegex(String value) {
//		try {
//			Pattern.compile(value);
//			return true;
//		} catch (PatternSyntaxException ex) {
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
//		} catch (NoAlertPresentException ex) {
//			System.out.println("[ALERT ACCEPT FAILED] No alert present.");
//			captureFailure("ALERT ACCEPT FAILED - NO ALERT", ex);
//			return false;
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
//		} catch (NoAlertPresentException ex) {
//			System.out.println("[ALERT DISMISS FAILED] No alert present.");
//			captureFailure("ALERT DISMISS FAILED - NO ALERT", ex);
//			return false;
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
//			if (locator == null) {
//				throw new IllegalArgumentException("Locator is null");
//			}
//
//			System.out.println("[COUNT VERIFY] Expected: " + expectedCount + " | Locator: " + locator);
//
//			for (int i = 1; i <= 50; i++) {
//				actualCount = driver.findElements(locator).size();
//
//				if (actualCount == expectedCount) {
//					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
//					break;
//				}
//
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
//
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
//	public boolean verifyTotalElementsCount(int expectedCount, List<?> elements) {
//		int actualCount = 0;
//
//		try {
//
//			if (elements == null) {
//				throw new IllegalArgumentException("Element list is null");
//			}
//
//			System.out.println("[COUNT VERIFY] Expected: " + expectedCount);
//
//			for (int i = 1; i <= 50; i++) {
//
//				actualCount = elements.size();
//
//				if (actualCount == expectedCount) {
//					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
//					break;
//				}
//
//				Thread.sleep(200);
//			}
//
//			System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);
//
//			boolean ok = (actualCount == expectedCount);
//
//			if (!ok) {
//				captureFailure("COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount);
//			}
//
//			return ok;
//
//		} catch (Exception ex) {
//
//			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);
//
//			captureFailure("COUNT FAILED -> expected=" + expectedCount + " actual=" + actualCount, ex);
//
//			return false;
//		}
//	}
//
//	// generic function print names of all the elements
//	public void printTextOfAllElements(List<WebElement> elements, String elementName) {
//		try {
//			if (elements == null) {
//				throw new IllegalArgumentException(elementName + " list is null");
//			}
//
//			System.out.println("[PRINT ALL TEXT] " + elementName + " | Total elements: " + elements.size());
//
//			for (int i = 0; i < elements.size(); i++) {
//				String text = elements.get(i).getText().trim();
//				System.out.println((i + 1) + ". " + text);
//			}
//
//		} catch (Exception ex) {
//			System.out.println("[PRINT ALL TEXT FAILED] " + elementName);
//			captureFailure("[PRINT ALL TEXT FAILED] " + elementName, ex);
//		}
//	}
//
//	// print the text of all the elements direclty from the dom using javascript not
//	// from element directly
//	public List<String> printTextOfAllElementsUsingJavascript(String cssSelector, String elementName) {
//		try {
//			if (cssSelector == null || cssSelector.trim().isEmpty()) {
//				throw new IllegalArgumentException("CSS selector is null or empty");
//			}
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//
//			@SuppressWarnings("unchecked")
//			List<String> texts = (List<String>) js
//					.executeScript("var elements = document.querySelectorAll(arguments[0]);" + "var result = [];"
//							+ "for (var i = 0; i < elements.length; i++) {"
//							+ "    var text = elements[i].textContent.trim();" + "    if (text !== '') {"
//							+ "        result.push(text);" + "    }" + "}" + "return result;", cssSelector);
//
//			System.out
//					.println("[PRINT ALL TEXT USING JAVASCRIPT] " + elementName + " | Total elements: " + texts.size());
//
//			for (int i = 0; i < texts.size(); i++) {
//				System.out.println((i + 1) + ". " + texts.get(i));
//			}
//
//			return texts;
//
//		} catch (Exception ex) {
//			System.out.println("[PRINT ALL TEXT USING JAVASCRIPT FAILED] " + elementName);
//			captureFailure("[PRINT ALL TEXT USING JAVASCRIPT FAILED] " + elementName, ex);
//			return new ArrayList<>();
//		}
//	}
//
//	// function to print text of all the eleements
//	public List<String> fetchAllElementTexts(List<WebElement> elements, String elementName) {
//		List<String> allTexts = new ArrayList<>();
//
//		try {
//			if (elements == null) {
//				throw new IllegalArgumentException(elementName + " list is null");
//			}
//
//			System.out.println("[FETCH TEXT START] " + elementName + " | Total elements: " + elements.size());
//
//			for (int i = 0; i < elements.size(); i++) {
//				String text = elements.get(i).getText().trim();
//				allTexts.add(text);
//				System.out.println((i + 1) + ". " + text);
//			}
//
//			System.out.println("[FETCH TEXT COMPLETED] " + elementName);
//			return allTexts;
//
//		} catch (Exception ex) {
//			System.out.println("[FETCH TEXT FAILED] " + elementName);
//			captureFailure("[FETCH TEXT FAILED] " + elementName, ex);
//			return allTexts;
//		}
//	}
//
//	// generic function to click on each element and back to previous page.
//	public boolean clickEachElementOneByOneAndNavigateBack(By locator, String elementName,
//			By pageLoadLocatorAfterBack) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_IN_SEC));
//
//		try {
//			if (locator == null) {
//				throw new IllegalArgumentException(elementName + " locator is null");
//			}
//
//			int totalElements = driver.findElements(locator).size();
//
//			if (totalElements == 0) {
//				System.out.println("[CLICK LOOP FAILED] " + elementName + " | No elements found");
//				captureFailure("[CLICK LOOP FAILED] " + elementName + " | No elements found");
//				return false;
//			}
//
//			System.out.println("[CLICK LOOP START] " + elementName + " | Total elements: " + totalElements);
//
//			for (int i = 0; i < totalElements; i++) {
//				String oldUrl = driver.getCurrentUrl();
//
//				List<WebElement> freshElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//
//				if (i >= freshElements.size()) {
//					System.out.println("[CLICK LOOP STOPPED] Index out of bounds at index: " + i);
//					captureFailure("[CLICK LOOP STOPPED] " + elementName + " | Index out of bounds at index: " + i);
//					return false;
//				}
//
//				WebElement currentElement = freshElements.get(i);
//				String currentText = currentElement.getText().trim();
//
//				System.out.println("[CLICKING] " + elementName + " Index: " + (i + 1) + " | Text: " + currentText);
//
//				boolean clicked = clickOnElement(currentElement,
//						currentText.isEmpty() ? elementName + " #" + (i + 1) : currentText);
//
//				if (!clicked) {
//					System.out.println(
//							"[CLICK FAILED] " + elementName + " | Index: " + (i + 1) + " | Text: " + currentText);
//					captureFailure("[CLICK FAILED] " + elementName + " | Index=" + (i + 1) + " | Text=" + currentText);
//					return false;
//				}
//
//				wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
//
//				System.out.println("[AFTER CLICK] URL: " + driver.getCurrentUrl());
//				System.out.println("[AFTER CLICK] TITLE: " + driver.getTitle());
//
//				driver.navigate().back();
//
//				if (pageLoadLocatorAfterBack != null) {
//					wait.until(ExpectedConditions.visibilityOfElementLocated(pageLoadLocatorAfterBack));
//				}
//
//				wait.until(ExpectedConditions.urlToBe(oldUrl));
//
//				System.out.println("[BACK DONE] Returned after clicking: " + currentText);
//			}
//
//			System.out.println("[CLICK LOOP COMPLETED] " + elementName);
//			return true;
//
//		} catch (Exception ex) {
//			System.out.println("[CLICK LOOP FAILED] " + elementName);
//			captureFailure("[CLICK LOOP FAILED] " + elementName, ex);
//			return false;
//		}
//	}
//
//	// fetching names from any slider. with click options.
//	public List<String> fetchAllTextsFromSlider(By itemLocator, By nextButtonLocator, String elementName) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_IN_SEC));
//		LinkedHashSet<String> uniqueTexts = new LinkedHashSet<>();
//
//		try {
//			if (itemLocator == null) {
//				throw new IllegalArgumentException(elementName + " item locator is null");
//			}
//
//			if (nextButtonLocator == null) {
//				throw new IllegalArgumentException(elementName + " next button locator is null");
//			}
//
//			System.out.println("[SLIDER FETCH START] " + elementName);
//
//			int sameStateCount = 0;
//			String previousSnapshot = "";
//
//			for (int attempt = 1; attempt <= 50; attempt++) {
//
//				List<WebElement> visibleItems = wait
//						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemLocator));
//
//				StringBuilder currentSnapshotBuilder = new StringBuilder();
//
//				for (WebElement item : visibleItems) {
//					String text = item.getText().trim();
//
//					if (!text.isEmpty()) {
//						uniqueTexts.add(text);
//						currentSnapshotBuilder.append(text).append("|");
//					}
//				}
//
//				String currentSnapshot = currentSnapshotBuilder.toString();
//
//				System.out.println("[SLIDER STEP] Attempt: " + attempt + " | Unique " + elementName + " count: "
//						+ uniqueTexts.size());
//
//				WebElement nextButton;
//				try {
//					nextButton = wait.until(ExpectedConditions.presenceOfElementLocated(nextButtonLocator));
//				} catch (Exception e) {
//					System.out.println("[SLIDER END] Next button not found");
//					break;
//				}
//
//				boolean isDisabled = !nextButton.isEnabled()
//						|| "true".equalsIgnoreCase(nextButton.getAttribute("disabled"))
//						|| nextButton.getAttribute("class") != null
//								&& nextButton.getAttribute("class").toLowerCase().contains("disabled");
//
//				if (isDisabled) {
//					System.out.println("[SLIDER END] Next button is disabled");
//					break;
//				}
//
//				try {
//					boolean nextClicked = clickOnElement(nextButton, elementName + " Next Button");
//					if (!nextClicked) {
//						System.out.println("[SLIDER END] Could not click next button");
//						break;
//					}
//
//					Thread.sleep(1000);
//
//				} catch (Exception clickEx) {
//					System.out.println("[SLIDER END] Could not click next button");
//					break;
//				}
//
//				if (currentSnapshot.equals(previousSnapshot)) {
//					sameStateCount++;
//				} else {
//					sameStateCount = 0;
//				}
//
//				previousSnapshot = currentSnapshot;
//
//				if (sameStateCount >= 2) {
//					System.out.println("[SLIDER END] No new items appearing after multiple attempts");
//					break;
//				}
//			}
//
//			List<String> result = new ArrayList<>(uniqueTexts);
//
//			System.out.println("[SLIDER FETCH COMPLETED] " + elementName + " | Total unique items: " + result.size());
//
//			for (int i = 0; i < result.size(); i++) {
//				System.out.println((i + 1) + ". " + result.get(i));
//			}
//
//			return result;
//
//		} catch (Exception ex) {
//			System.out.println("[SLIDER FETCH FAILED] " + elementName);
//			captureFailure("[SLIDER FETCH FAILED] " + elementName, ex);
//			return new ArrayList<>();
//		}
//	}
//
//	// fetching text from auto sliding slider without any click operation.
//	public List<String> fetchAllUniqueTextsFromAutoSlider(By locator, int expectedUniqueCount, String elementName) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_IN_SEC));
//		LinkedHashSet<String> uniqueTexts = new LinkedHashSet<>();
//
//		try {
//			if (locator == null) {
//				throw new IllegalArgumentException(elementName + " locator is null");
//			}
//
//			System.out.println(
//					"[AUTO SLIDER FETCH START] " + elementName + " | Expected unique count: " + expectedUniqueCount);
//
//			int idleRounds = 0;
//			int lastSize = 0;
//
//			for (int attempt = 1; attempt <= 300; attempt++) {
//				List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//
//				for (WebElement element : elements) {
//					try {
//						String text = element.getText().trim();
//						if (!text.isEmpty()) {
//							uniqueTexts.add(text);
//						}
//					} catch (Exception ignored) {
//					}
//				}
//
//				System.out.println("[AUTO SLIDER FETCH] Attempt: " + attempt + " | Unique " + elementName + ": "
//						+ uniqueTexts.size());
//
//				if (uniqueTexts.size() == expectedUniqueCount) {
//					break;
//				}
//
//				if (uniqueTexts.size() == lastSize) {
//					idleRounds++;
//				} else {
//					idleRounds = 0;
//				}
//
//				lastSize = uniqueTexts.size();
//
//				if (idleRounds >= 20) {
//					System.out.println("[AUTO SLIDER FETCH STOP] No new " + elementName + " found for many rounds");
//					break;
//				}
//
//				Thread.sleep(300);
//			}
//
//			List<String> result = new ArrayList<>(uniqueTexts);
//
//			System.out.println(
//					"[AUTO SLIDER FETCH COMPLETED] " + elementName + " | Total unique found: " + result.size());
//
//			for (int i = 0; i < result.size(); i++) {
//				System.out.println((i + 1) + ". " + result.get(i));
//			}
//
//			return result;
//
//		} catch (Exception ex) {
//			System.out.println("[AUTO SLIDER FETCH FAILED] " + elementName);
//			captureFailure("[AUTO SLIDER FETCH FAILED] " + elementName, ex);
//			return new ArrayList<>();
//		}
//	}
//
//	// click one visible element by text from auto slider
//	public boolean clickVisibleAutoSliderElementByText(By locator, String targetText, String elementName) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_IN_SEC));
//
//		try {
//			if (locator == null) {
//				throw new IllegalArgumentException(elementName + " locator is null");
//			}
//
//			if (targetText == null || targetText.trim().isEmpty()) {
//				throw new IllegalArgumentException(elementName + " target text is null/empty");
//			}
//
//			System.out.println("[AUTO SLIDER CLICK SEARCH] " + elementName + " -> " + targetText);
//
//			for (int attempt = 1; attempt <= 100; attempt++) {
//				List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//
//				for (WebElement element : elements) {
//					try {
//						String currentText = element.getText().trim();
//
//						if (targetText.equals(currentText) && element.isDisplayed()) {
//							boolean clicked = clickOnElement(element, targetText);
//							if (clicked) {
//								System.out.println("[AUTO SLIDER CLICK SUCCESS] " + elementName + " -> " + targetText);
//								return true;
//							}
//						}
//					} catch (Exception ignored) {
//					}
//				}
//
//				Thread.sleep(300);
//			}
//
//			System.out.println("[AUTO SLIDER CLICK FAILED] Could not find visible text: " + targetText);
//			captureFailure("[AUTO SLIDER CLICK FAILED] " + elementName + " -> " + targetText);
//			return false;
//
//		} catch (Exception ex) {
//			System.out.println("[AUTO SLIDER CLICK FAILED] " + elementName + " -> " + targetText);
//			captureFailure("[AUTO SLIDER CLICK FAILED] " + elementName + " -> " + targetText, ex);
//			return false;
//		}
//	}
//
//	// click each unique element one by one from auto slider
//	public boolean clickEachUniqueTextElementFromAutoSlider(By locator, int expectedUniqueCount, String elementName,
//			By pageLoadLocatorAfterBack) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_IN_SEC));
//
//		try {
//			List<String> allUniqueTexts = fetchAllUniqueTextsFromAutoSlider(locator, expectedUniqueCount, elementName);
//
//			if (allUniqueTexts.isEmpty()) {
//				System.out.println("[AUTO SLIDER CLICK LOOP FAILED] No " + elementName + " found");
//				captureFailure("[AUTO SLIDER CLICK LOOP FAILED] No " + elementName + " found");
//				return false;
//			}
//
//			System.out.println("[AUTO SLIDER CLICK LOOP START] " + elementName + " | Total unique items: "
//					+ allUniqueTexts.size());
//
//			for (int i = 0; i < allUniqueTexts.size(); i++) {
//				String textToClick = allUniqueTexts.get(i);
//				String oldUrl = driver.getCurrentUrl();
//
//				System.out.println(
//						"[AUTO SLIDER CLICKING] " + elementName + " Index: " + (i + 1) + " | Text: " + textToClick);
//
//				boolean clicked = clickVisibleAutoSliderElementByText(locator, textToClick, elementName);
//
//				if (!clicked) {
//					captureFailure("[AUTO SLIDER CLICK LOOP FAILED] Could not click: " + textToClick);
//					return false;
//				}
//
//				try {
//					wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
//				} catch (Exception ignored) {
//				}
//
//				System.out.println("[AFTER CLICK] URL: " + driver.getCurrentUrl());
//				System.out.println("[AFTER CLICK] TITLE: " + driver.getTitle());
//
//				driver.navigate().back();
//
//				if (pageLoadLocatorAfterBack != null) {
//					wait.until(ExpectedConditions.visibilityOfElementLocated(pageLoadLocatorAfterBack));
//				}
//
//				try {
//					wait.until(ExpectedConditions.urlToBe(oldUrl));
//				} catch (Exception ignored) {
//				}
//
//				System.out.println("[BACK DONE] Returned after clicking: " + textToClick);
//			}
//
//			System.out.println("[AUTO SLIDER CLICK LOOP COMPLETED] " + elementName);
//			return true;
//
//		} catch (Exception ex) {
//			System.out.println("[AUTO SLIDER CLICK LOOP FAILED] " + elementName);
//			captureFailure("[AUTO SLIDER CLICK LOOP FAILED] " + elementName, ex);
//			return false;
//		}
//	}
//
//	// ============================================================
//	// ✅ GENERIC STANDARD PAGE HELPERS
//	// ============================================================
//
//	protected List<WebElement> safeFindFromRoot(WebElement rootElement, By by) {
//		if (rootElement == null) {
//			return driver.findElements(by);
//		}
//		return rootElement.findElements(by);
//	}
//
//	protected String getCleanText(WebElement element) {
//		if (element == null)
//			return "";
//
//		String text = "";
//		try {
//			text = element.getText();
//		} catch (Exception e) {
//			text = "";
//		}
//
//		if (text != null && !text.trim().isEmpty()) {
//			return text.trim();
//		}
//
//		String[] attrs = { "aria-label", "title", "alt", "name", "value", "placeholder", "id", "href", "src" };
//		for (String attr : attrs) {
//			try {
//				String value = element.getAttribute(attr);
//				if (value != null && !value.trim().isEmpty()) {
//					return value.trim();
//				}
//			} catch (Exception e) {
//			}
//		}
//
//		return "";
//	}
//
//	protected String getElementDisplayName(WebElement element) {
//		if (element == null)
//			return "UNKNOWN ELEMENT";
//
//		String text = getCleanText(element);
//		if (text != null && !text.isEmpty()) {
//			return text;
//		}
//
//		try {
//			String tag = element.getTagName();
//			return tag == null ? "UNKNOWN ELEMENT" : tag.trim().toUpperCase();
//		} catch (Exception e) {
//			return "UNKNOWN ELEMENT";
//		}
//	}
//
//	protected void scrollElementToCenter(WebElement element) {
//		try {
//			((JavascriptExecutor) driver).executeScript(
//					"arguments[0].scrollIntoView({block:'center', inline:'center', behavior:'instant'});", element);
//		} catch (Exception e) {
//			System.out.println("[GENERIC] Unable to scroll element to center.");
//		}
//	}
//
//	protected boolean isLikelyBrokenResponseCode(int code) {
//		return code >= 400;
//	}
//
//	protected String normalizeToAbsoluteUrl(String hrefOrSrc) {
//		try {
//			if (hrefOrSrc == null || hrefOrSrc.trim().isEmpty())
//				return "";
//
//			String raw = hrefOrSrc.trim();
//
//			if (raw.startsWith("javascript:") || raw.startsWith("mailto:") || raw.startsWith("tel:")
//					|| raw.startsWith("#")) {
//				return "";
//			}
//
//			URL base = new URL(driver.getCurrentUrl());
//			URL abs = new URL(base, raw);
//			return abs.toString();
//		} catch (Exception e) {
//			return "";
//		}
//	}
//
//	// ============================================================
//	// ✅ GENERIC - HEADINGS
//	// ============================================================
//
//	public List<WebElement> getAllHeadingElements(By headingLocator) {
//		return driver.findElements(headingLocator);
//	}
//
//	public List<WebElement> getAllHeadingElements(WebElement rootElement, By headingLocator) {
//		return safeFindFromRoot(rootElement, headingLocator);
//	}
//
//	public List<String> getAllHeadingTexts(By headingLocator) {
//		List<String> texts = new ArrayList<>();
//		List<WebElement> elements = getAllHeadingElements(headingLocator);
//
//		for (WebElement element : elements) {
//			String text = getCleanText(element);
//			if (!text.isEmpty()) {
//				texts.add(text);
//			}
//		}
//		return texts;
//	}
//
//	public List<String> getAllHeadingTexts(WebElement rootElement, By headingLocator) {
//		List<String> texts = new ArrayList<>();
//		List<WebElement> elements = getAllHeadingElements(rootElement, headingLocator);
//
//		for (WebElement element : elements) {
//			String text = getCleanText(element);
//			if (!text.isEmpty()) {
//				texts.add(text);
//			}
//		}
//		return texts;
//	}
//
//	public void printAllHeadingTexts(By headingLocator, String elementName) {
//		List<String> headings = getAllHeadingTexts(headingLocator);
//		System.out.println("========== ALL HEADINGS : " + elementName + " ==========");
//		System.out.println("Total headings found: " + headings.size());
//
//		for (int i = 0; i < headings.size(); i++) {
//			System.out.println((i + 1) + ". " + headings.get(i));
//		}
//	}
//
//	public void printAllHeadingTexts(WebElement rootElement, By headingLocator, String elementName) {
//		List<String> headings = getAllHeadingTexts(rootElement, headingLocator);
//		System.out.println("========== ALL HEADINGS : " + elementName + " ==========");
//		System.out.println("Total headings found: " + headings.size());
//
//		for (int i = 0; i < headings.size(); i++) {
//			System.out.println((i + 1) + ". " + headings.get(i));
//		}
//	}
//
//	// ============================================================
//	// ✅ GENERIC - PARAGRAPHS
//	// ============================================================
//
//	public List<WebElement> getAllParagraphElements(By paragraphLocator) {
//		return driver.findElements(paragraphLocator);
//	}
//
//	public List<WebElement> getAllParagraphElements(WebElement rootElement, By paragraphLocator) {
//		return safeFindFromRoot(rootElement, paragraphLocator);
//	}
//
//	public List<String> getAllParagraphTexts(By paragraphLocator) {
//		List<String> texts = new ArrayList<>();
//		List<WebElement> elements = getAllParagraphElements(paragraphLocator);
//
//		for (WebElement element : elements) {
//			String text = getCleanText(element);
//			if (!text.isEmpty()) {
//				texts.add(text);
//			}
//		}
//		return texts;
//	}
//
//	public List<String> getAllParagraphTexts(WebElement rootElement, By paragraphLocator) {
//		List<String> texts = new ArrayList<>();
//		List<WebElement> elements = getAllParagraphElements(rootElement, paragraphLocator);
//
//		for (WebElement element : elements) {
//			String text = getCleanText(element);
//			if (!text.isEmpty()) {
//				texts.add(text);
//			}
//		}
//		return texts;
//	}
//
//	public void printAllParagraphTexts(By paragraphLocator, String elementName) {
//		List<String> paragraphs = getAllParagraphTexts(paragraphLocator);
//		System.out.println("========== ALL PARAGRAPHS : " + elementName + " ==========");
//		System.out.println("Total paragraphs found: " + paragraphs.size());
//
//		for (int i = 0; i < paragraphs.size(); i++) {
//			System.out.println((i + 1) + ". " + paragraphs.get(i));
//		}
//	}
//
//	public void printAllParagraphTexts(WebElement rootElement, By paragraphLocator, String elementName) {
//		List<String> paragraphs = getAllParagraphTexts(rootElement, paragraphLocator);
//		System.out.println("========== ALL PARAGRAPHS : " + elementName + " ==========");
//		System.out.println("Total paragraphs found: " + paragraphs.size());
//
//		for (int i = 0; i < paragraphs.size(); i++) {
//			System.out.println((i + 1) + ". " + paragraphs.get(i));
//		}
//	}
//
//	// ============================================================
//	// ✅ GENERIC - IMAGES
//	// ============================================================
//
//	public List<WebElement> getAllImageElements(By imageLocator) {
//		return driver.findElements(imageLocator);
//	}
//
//	public List<WebElement> getAllImageElements(WebElement rootElement, By imageLocator) {
//		return safeFindFromRoot(rootElement, imageLocator);
//	}
//
//	public List<String> getAllImageSources(By imageLocator) {
//		List<String> sources = new ArrayList<>();
//		List<WebElement> elements = getAllImageElements(imageLocator);
//
//		for (WebElement element : elements) {
//			try {
//				String src = element.getAttribute("src");
//				if (src != null && !src.trim().isEmpty()) {
//					sources.add(src.trim());
//				}
//			} catch (Exception e) {
//			}
//		}
//		return sources;
//	}
//
//	public List<String> getAllImageSources(WebElement rootElement, By imageLocator) {
//		List<String> sources = new ArrayList<>();
//		List<WebElement> elements = getAllImageElements(rootElement, imageLocator);
//
//		for (WebElement element : elements) {
//			try {
//				String src = element.getAttribute("src");
//				if (src != null && !src.trim().isEmpty()) {
//					sources.add(src.trim());
//				}
//			} catch (Exception e) {
//			}
//		}
//		return sources;
//	}
//
//	public void printAllImages(By imageLocator, String elementName) {
//		List<WebElement> images = getAllImageElements(imageLocator);
//		System.out.println("========== ALL IMAGES : " + elementName + " ==========");
//		System.out.println("Total images found: " + images.size());
//
//		for (int i = 0; i < images.size(); i++) {
//			WebElement image = images.get(i);
//			String alt = "";
//			String src = "";
//			try {
//				alt = image.getAttribute("alt");
//				src = image.getAttribute("src");
//			} catch (Exception e) {
//			}
//			System.out.println((i + 1) + ". ALT: " + (alt == null ? "" : alt) + " | SRC: " + (src == null ? "" : src));
//		}
//	}
//
//	public void printAllImages(WebElement rootElement, By imageLocator, String elementName) {
//		List<WebElement> images = getAllImageElements(rootElement, imageLocator);
//		System.out.println("========== ALL IMAGES : " + elementName + " ==========");
//		System.out.println("Total images found: " + images.size());
//
//		for (int i = 0; i < images.size(); i++) {
//			WebElement image = images.get(i);
//			String alt = "";
//			String src = "";
//			try {
//				alt = image.getAttribute("alt");
//				src = image.getAttribute("src");
//			} catch (Exception e) {
//			}
//			System.out.println((i + 1) + ". ALT: " + (alt == null ? "" : alt) + " | SRC: " + (src == null ? "" : src));
//		}
//	}
//
//	// ============================================================
//	// ✅ GENERIC - LINKS + BROKEN LINKS
//	// ============================================================
//
//	public List<WebElement> getAllLinkElements(By linkLocator) {
//		return driver.findElements(linkLocator);
//	}
//
//	public List<WebElement> getAllLinkElements(WebElement rootElement, By linkLocator) {
//		return safeFindFromRoot(rootElement, linkLocator);
//	}
//
//	public List<String> getAllLinkUrls(By linkLocator) {
//		List<String> urls = new ArrayList<>();
//		List<WebElement> elements = getAllLinkElements(linkLocator);
//
//		for (WebElement element : elements) {
//			try {
//				String href = element.getAttribute("href");
//				if (href != null && !href.trim().isEmpty()) {
//					urls.add(href.trim());
//				}
//			} catch (Exception e) {
//			}
//		}
//		return urls;
//	}
//
//	public List<String> getAllLinkUrls(WebElement rootElement, By linkLocator) {
//		List<String> urls = new ArrayList<>();
//		List<WebElement> elements = getAllLinkElements(rootElement, linkLocator);
//
//		for (WebElement element : elements) {
//			try {
//				String href = element.getAttribute("href");
//				if (href != null && !href.trim().isEmpty()) {
//					urls.add(href.trim());
//				}
//			} catch (Exception e) {
//			}
//		}
//		return urls;
//	}
//
//	public void printAllLinks(By linkLocator, String elementName) {
//		List<WebElement> links = getAllLinkElements(linkLocator);
//		System.out.println("========== ALL LINKS : " + elementName + " ==========");
//		System.out.println("Total links found: " + links.size());
//
//		for (int i = 0; i < links.size(); i++) {
//			WebElement link = links.get(i);
//			String name = getElementDisplayName(link);
//			String href = "";
//			try {
//				href = link.getAttribute("href");
//			} catch (Exception e) {
//			}
//			System.out.println((i + 1) + ". NAME: " + name + " | HREF: " + href);
//		}
//	}
//
//	public void printAllLinks(WebElement rootElement, By linkLocator, String elementName) {
//		List<WebElement> links = getAllLinkElements(rootElement, linkLocator);
//		System.out.println("========== ALL LINKS : " + elementName + " ==========");
//		System.out.println("Total links found: " + links.size());
//
//		for (int i = 0; i < links.size(); i++) {
//			WebElement link = links.get(i);
//			String name = getElementDisplayName(link);
//			String href = "";
//			try {
//				href = link.getAttribute("href");
//			} catch (Exception e) {
//			}
//			System.out.println((i + 1) + ". NAME: " + name + " | HREF: " + href);
//		}
//	}
//
//	public List<String> getAllBrokenLinks(By linkLocator) {
//		return getAllBrokenLinks(null, linkLocator);
//	}
//
//	public List<String> getAllBrokenLinks(WebElement rootElement, By linkLocator) {
//		List<String> brokenLinks = new ArrayList<>();
//		List<WebElement> links = rootElement == null ? getAllLinkElements(linkLocator)
//				: getAllLinkElements(rootElement, linkLocator);
//
//		System.out.println("========== CHECKING BROKEN LINKS ==========");
//
//		for (WebElement link : links) {
//			String rawHref = "";
//			try {
//				rawHref = link.getAttribute("href");
//			} catch (Exception e) {
//			}
//
//			String absoluteUrl = normalizeToAbsoluteUrl(rawHref);
//			String name = getElementDisplayName(link);
//
//			if (absoluteUrl.isEmpty()) {
//				System.out.println("[GENERIC] Skipping non-http/non-testable link: " + rawHref);
//				continue;
//			}
//
//			HttpURLConnection connection = null;
//			try {
//				URL url = new URL(absoluteUrl);
//				connection = (HttpURLConnection) url.openConnection();
//				connection.setRequestMethod("GET");
//				connection.setConnectTimeout(8000);
//				connection.setReadTimeout(8000);
//				connection.connect();
//
//				int responseCode = connection.getResponseCode();
//
//				if (isLikelyBrokenResponseCode(responseCode)) {
//					String broken = "NAME: " + name + " | URL: " + absoluteUrl + " | RESPONSE CODE: " + responseCode;
//					brokenLinks.add(broken);
//					System.out.println("[BROKEN] " + broken);
//				} else {
//					System.out.println(
//							"[OK] NAME: " + name + " | URL: " + absoluteUrl + " | RESPONSE CODE: " + responseCode);
//				}
//			} catch (Exception e) {
//				String broken = "NAME: " + name + " | URL: " + absoluteUrl + " | ERROR: " + e.getMessage();
//				brokenLinks.add(broken);
//				System.out.println("[BROKEN] " + broken);
//			} finally {
//				if (connection != null) {
//					try {
//						connection.disconnect();
//					} catch (Exception e) {
//					}
//				}
//			}
//		}
//
//		return brokenLinks;
//	}
//
//	public void printAllBrokenLinks(By linkLocator, String elementName) {
//		List<String> brokenLinks = getAllBrokenLinks(linkLocator);
//		System.out.println("========== BROKEN LINKS SUMMARY : " + elementName + " ==========");
//		System.out.println("Total broken links found: " + brokenLinks.size());
//
//		for (int i = 0; i < brokenLinks.size(); i++) {
//			System.out.println((i + 1) + ". " + brokenLinks.get(i));
//		}
//	}
//
//	public void printAllBrokenLinks(WebElement rootElement, By linkLocator, String elementName) {
//		List<String> brokenLinks = getAllBrokenLinks(rootElement, linkLocator);
//		System.out.println("========== BROKEN LINKS SUMMARY : " + elementName + " ==========");
//		System.out.println("Total broken links found: " + brokenLinks.size());
//
//		for (int i = 0; i < brokenLinks.size(); i++) {
//			System.out.println((i + 1) + ". " + brokenLinks.get(i));
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
//}

package generic;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {

	protected final WebDriver driver;
	protected final ScreenshotUtility su;

	// ============================================================
	// ✅ CENTRAL CONFIG
	// ============================================================
	private static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
	private static final int DEFAULT_RETRY_COUNT = 2;

	// ============================================================
	// ✅ CONSTRUCTOR
	// ============================================================
	public AllVerifications(WebDriver driver) {
		this.driver = driver;
		this.su = new ScreenshotUtility(driver);
	}

	protected WebDriverWait createWait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

	// ============================================================
	// ✅ SCREENSHOT HELPERS
	// ============================================================
	protected void captureFailure(String tag) {
		try {
			System.out.println("[SCREENSHOT] " + tag);
			su.captureScreenshot();
		} catch (Exception ignore) {
			System.out.println("[SCREENSHOT FAILED] " + tag);
		}
	}

	protected void captureFailure(String tag, Exception ex) {
		try {
			System.out
					.println("[SCREENSHOT] " + tag + " | ex=" + (ex == null ? "null" : ex.getClass().getSimpleName()));
			su.captureScreenshot();
		} catch (Exception ignore) {
			System.out.println("[SCREENSHOT FAILED] " + tag);
		}
	}

	// function to check if they are present and visible to perform actions on them.

	public boolean verifyElementPresentAndVisible(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName);

				// 1. Validate reference is still alive
				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				// 2. Wait until visible
				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				// 3. Final displayed check
				if (!visibleElement.isDisplayed()) {
					throw new IllegalStateException("Element is not displayed: " + displayName);
				}

				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
				captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);

			} catch (TimeoutException te) {
				System.out.println("[ELEMENT VERIFY TIMEOUT] " + elementName + " | " + te.getMessage());
				captureFailure("ELEMENT VERIFY TIMEOUT -> " + elementName, te);
				return false;

			} catch (Exception ex) {
				System.out.println("[ELEMENT VERIFY FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("ELEMENT VERIFY FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[ELEMENT VERIFY FAILED AFTER RETRIES] " + elementName);
		captureFailure("ELEMENT VERIFY FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	public boolean verifyElementPresentAndVisible(By locator, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());

				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName + " | " + locator);

				// 1. Check DOM presence
				List<WebElement> found = driver.findElements(locator);
				if (found.isEmpty()) {
					throw new NoSuchElementException("Element is not present in DOM: " + locator);
				}

				// 2. Wait for presence
				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				// 3. Wait for visibility
				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

				// 4. Final displayed check
				if (!element.isDisplayed()) {
					throw new IllegalStateException("Element is not displayed: " + displayName);
				}

				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
				captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);

			} catch (TimeoutException te) {
				System.out.println("[ELEMENT VERIFY TIMEOUT] " + elementName + " | " + te.getMessage());
				captureFailure("ELEMENT VERIFY TIMEOUT -> " + elementName, te);
				return false;

			} catch (Exception ex) {
				System.out.println("[ELEMENT VERIFY FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("ELEMENT VERIFY FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[ELEMENT VERIFY FAILED AFTER RETRIES] " + elementName);
		captureFailure("ELEMENT VERIFY FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	// ============================================================
	// ✅ ENTERPRISE CLICK - WEBELEMENT
	// ============================================================
	public boolean clickOnElement(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName);

				// 1. Validate element reference still exists
				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				// 2. Scroll to center
				scrollElementToCenter(element);

				// 3. Wait until visible
				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				// 4. Wait until clickable
				WebElement clickableElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.elementToBeClickable(visibleElement));

				// 5. Check enabled
				if (!clickableElement.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				// 6. Resolve best possible text for reporting
				String clickedText = getCleanText(clickableElement);
				if (clickedText == null || clickedText.trim().isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

				// 7. Normal click -> Actions click -> JS click
				try {
					clickableElement.click();
				} catch (ElementClickInterceptedException e1) {
					try {
						new Actions(driver).moveToElement(clickableElement).pause(Duration.ofMillis(200)).click()
								.perform();
					} catch (Exception e2) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableElement);
					}
				}

				System.out.println("[CLICK SUCCESS] " + clickedText);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
				captureFailure("CLICK STALE -> " + elementName, sere);

			} catch (TimeoutException te) {
				System.out.println("[CLICK TIMEOUT] " + elementName + " | " + te.getMessage());
				captureFailure("CLICK TIMEOUT -> " + elementName, te);
				return false;

			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("CLICK FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[CLICK FAILED AFTER RETRIES] " + elementName);
		captureFailure("CLICK FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	// ============================================================
	// ✅ ENTERPRISE CLICK - LOCATOR
	// ============================================================
	public boolean clickOnElement(By locator, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName + " | " + locator);

				// 1. Presence check
				List<WebElement> found = driver.findElements(locator);
				if (found.isEmpty()) {
					throw new NoSuchElementException("Element is not present in DOM: " + locator);
				}

				// 2. Wait for presence
				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				// 3. Scroll
				scrollElementToCenter(element);

				// 4. Wait for visibility
				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

				// 5. Wait for clickability
				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.elementToBeClickable(locator));

				// 6. Enabled check
				if (!element.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				// 7. Get reporting text
				String clickedText = getCleanText(element);
				if (clickedText == null || clickedText.trim().isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

				// 8. Normal click -> Actions click -> JS click
				try {
					element.click();
				} catch (ElementClickInterceptedException e1) {
					try {
						new Actions(driver).moveToElement(element).pause(Duration.ofMillis(200)).click().perform();
					} catch (Exception e2) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					}
				}

				System.out.println("[CLICK SUCCESS] " + clickedText);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
				captureFailure("CLICK STALE -> " + elementName, sere);

			} catch (TimeoutException te) {
				System.out.println("[CLICK TIMEOUT] " + elementName + " | " + te.getMessage());
				captureFailure("CLICK TIMEOUT -> " + elementName, te);
				return false;

			} catch (Exception ex) {
				System.out.println("[CLICK FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("CLICK FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[CLICK FAILED AFTER RETRIES] " + elementName);
		captureFailure("CLICK FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	// ============================================================
	// ✅ ENTERPRISE TEXT VERIFICATION // matchType = equals / contains / regex
	// ============================================================
	public boolean verifyText(WebElement element, String expectedText, String name, String matchType,
			boolean ignoreCase) {
		try {
			if (element == null) {
				throw new IllegalArgumentException("Element is null");
			}

			expectedText = safeTrim(expectedText);
			matchType = safeTrim(matchType).toLowerCase();
			name = normalizeName(name, "TEXT ELEMENT");

			if (expectedText.isEmpty()) {
				throw new IllegalArgumentException("Expected text is null or empty");
			}

			if (!matchType.equals("equals") && !matchType.equals("contains") && !matchType.equals("regex")) {
				throw new IllegalArgumentException("Invalid matchType: " + matchType);
			}

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.visibilityOf(element));

			String actualText = safeTrim(element.getText());

			System.out.println("[TEXT VERIFY]");
			System.out.println("Element Name   : " + name);
			System.out.println("Match Type     : " + matchType);
			System.out.println("Ignore Case    : " + ignoreCase);
			System.out.println("Expected Text  : " + expectedText);
			System.out.println("Actual Text    : " + actualText);

			boolean result = false;

			switch (matchType) {
			case "equals":
				result = ignoreCase ? actualText.equalsIgnoreCase(expectedText) : actualText.equals(expectedText);
				break;

			case "contains":
				result = ignoreCase ? actualText.toLowerCase().contains(expectedText.toLowerCase())
						: actualText.contains(expectedText);
				break;

			case "regex":
				try {
					Pattern pattern = ignoreCase ? Pattern.compile(expectedText, Pattern.CASE_INSENSITIVE)
							: Pattern.compile(expectedText);

					result = pattern.matcher(actualText).matches();
				} catch (PatternSyntaxException ex) {
					throw new IllegalArgumentException("Invalid regex pattern: " + expectedText, ex);
				}
				break;
			}

			if (result) {
				System.out.println("[TEXT PASS] " + name + " | Match Type: " + matchType);
			} else {
				System.out.println("[TEXT FAIL] " + name + " | Match Type: " + matchType);
				captureFailure("TEXT VERIFICATION FAILED -> Name: " + name + " | MatchType: " + matchType
						+ " | IgnoreCase: " + ignoreCase + " | Expected: " + expectedText + " | Actual: " + actualText);
			}

			return result;

		} catch (Exception e) {
			System.out.println("[TEXT VERIFY FAILED] " + name);
			captureFailure("TEXT VERIFY FAILED -> " + name, e);
			return false;
		}
	}

	// ============================================================
	// ✅ ENTERPRISE TITLE VERIFICATION // EXACT / PARTIAL / NORMALIZED PARTIAL /
	// REGEX
	// ============================================================
	public boolean verifyTitleOfWebpage(String expectedTitle) {
		boolean titleVerified = false;

		try {
			expectedTitle = safeTrim(expectedTitle);

			if (expectedTitle.isEmpty()) {
				throw new IllegalArgumentException("Expected title is null or empty");
			}

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				String title = driver.getTitle();
				return title != null && !title.trim().isEmpty();
			});

			String actualTitle = safeTrim(driver.getTitle());

			String normalizedExpected = normalizeVerificationText(expectedTitle);
			String normalizedActual = normalizeVerificationText(actualTitle);

			System.out.println("[VERIFY TITLE]");
			System.out.println("Expected Input      : " + expectedTitle);
			System.out.println("Actual Title        : " + actualTitle);
			System.out.println("Normalized Expected : " + normalizedExpected);
			System.out.println("Normalized Actual   : " + normalizedActual);

			if (actualTitle.equalsIgnoreCase(expectedTitle)) {
				titleVerified = true;
				System.out.println("[TITLE PASS] Match Type: EXACT");
			} else if (actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
				titleVerified = true;
				System.out.println("[TITLE PASS] Match Type: PARTIAL");
			} else if (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected)) {
				titleVerified = true;
				System.out.println("[TITLE PASS] Match Type: NORMALIZED PARTIAL");
			} else if (isValidRegex(expectedTitle) && actualTitle.matches(expectedTitle)) {
				titleVerified = true;
				System.out.println("[TITLE PASS] Match Type: REGEX");
			}

			if (titleVerified) {
				System.out.println("[TITLE PASS] Expected: " + expectedTitle + " | Found: " + actualTitle);
			} else {
				System.out.println("[TITLE FAIL] Expected: " + expectedTitle + " | Found: " + actualTitle);
				captureFailure("VERIFY TITLE FAIL -> expected=" + expectedTitle + " | actual=" + actualTitle);
			}

		} catch (Exception ex) {
			System.out.println("[TITLE VERIFY EXCEPTION] Expected: " + expectedTitle + " | Found: " + safeTitle());
			captureFailure("VERIFY TITLE EXCEPTION -> expected=" + expectedTitle, ex);
		}

		return titleVerified;
	}

	// ============================================================
	// ✅ ENTERPRISE URL VERIFICATION // EXACT / PARTIAL / NORMALIZED PARTIAL / REGEX
	// // with URL decoding
	// ============================================================
	public boolean verifyUrlOfWebpage(String expectedUrl) {
		boolean urlVerified = false;

		try {
			expectedUrl = safeTrim(expectedUrl);

			if (expectedUrl.isEmpty()) {
				throw new IllegalArgumentException("Expected URL is null or empty");
			}

			String actualUrl = safeTrim(driver.getCurrentUrl());
			String decodedActualUrl = URLDecoder.decode(actualUrl, StandardCharsets.UTF_8);

			String normalizedExpected = normalizeVerificationText(expectedUrl);
			String normalizedActual = normalizeVerificationText(decodedActualUrl);

			System.out.println("[VERIFY URL]");
			System.out.println("Expected Input      : " + expectedUrl);
			System.out.println("Actual URL          : " + actualUrl);
			System.out.println("Decoded Actual URL  : " + decodedActualUrl);
			System.out.println("Normalized Expected : " + normalizedExpected);
			System.out.println("Normalized Actual   : " + normalizedActual);

			if (decodedActualUrl.equalsIgnoreCase(expectedUrl)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: EXACT");
			} else if (decodedActualUrl.toLowerCase().contains(expectedUrl.toLowerCase())) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: PARTIAL");
			} else if (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: NORMALIZED PARTIAL");
			} else if (isValidRegex(expectedUrl) && decodedActualUrl.matches(expectedUrl)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: REGEX");
			}

			if (urlVerified) {
				System.out.println("[URL PASS] Expected: " + expectedUrl + " | Found: " + actualUrl);
			} else {
				System.out.println("[URL FAIL] Expected: " + expectedUrl + " | Found: " + actualUrl);
				captureFailure("VERIFY URL FAIL -> expected=" + expectedUrl + " | actual=" + actualUrl
						+ " | decodedActual=" + decodedActualUrl);
			}

		} catch (Exception ex) {
			System.out.println("[URL VERIFY EXCEPTION] Expected: " + expectedUrl + " | Found: " + safeUrl());
			captureFailure("VERIFY URL EXCEPTION -> expected=" + expectedUrl, ex);
		}

		return urlVerified;
	}

	// ============================================================
	// ✅ INTERNAL HELPERS
	// ============================================================
	// internal helper to scroll to the center of the element
	protected void scrollElementToCenter(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block:'center', inline:'center', behavior:'instant'});", element);
		} catch (Exception e) {
			System.out.println("[SCROLL FAILED] Unable to scroll element to center.");
		}
	}

	protected String getCleanText(WebElement element) {
		if (element == null)
			return "";

		String text = "";
		try {
			text = element.getText();
		} catch (Exception e) {
			text = "";
		}

		if (text != null && !text.trim().isEmpty()) {
			return text.trim();
		}

		String[] attrs = { "aria-label", "title", "alt", "name", "value", "placeholder", "id", "href", "src" };

		for (String attr : attrs) {
			try {
				String value = element.getAttribute(attr);
				if (value != null && !value.trim().isEmpty()) {
					return value.trim();
				}
			} catch (Exception e) {
			}
		}

		return "";
	}

	protected String getElementDisplayName(WebElement element) {
		if (element == null)
			return "UNKNOWN ELEMENT";

		String text = getCleanText(element);
		if (text != null && !text.isEmpty()) {
			return text;
		}

		try {
			String tag = element.getTagName();
			return tag == null ? "UNKNOWN ELEMENT" : tag.trim().toUpperCase();
		} catch (Exception e) {
			return "UNKNOWN ELEMENT";
		}
	}

	private String normalizeVerificationText(String value) {
		if (value == null) {
			return "";
		}
		return value.replaceAll("[^A-Za-z0-9]", "").toLowerCase().trim();
	}

	private boolean isValidRegex(String value) {
		try {
			Pattern.compile(value);
			return true;
		} catch (PatternSyntaxException ex) {
			return false;
		}
	}

	private String normalizeName(String preferredName, String fallbackName) {
		String name = safeTrim(preferredName);
		if (!name.isEmpty()) {
			return name;
		}
		return safeTrim(fallbackName).isEmpty() ? "UNNAMED ELEMENT" : safeTrim(fallbackName);
	}

	private String safeTrim(String value) {
		return value == null ? "" : value.trim();
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

	// generic function print names of all the elements
	public List<WebElement> printTextOfAllElements(List<WebElement> elements, String elementName) {
		try {
			if (elements == null) {
				throw new IllegalArgumentException(elementName + " list is null");
			}

			System.out.println("[PRINT ALL TEXT] " + elementName + " | Total elements: " + elements.size());

			for (int i = 0; i < elements.size(); i++) {
				String text = elements.get(i).getText().trim();
				System.out.println((i + 1) + ". " + text);
			}

		} catch (Exception ex) {
			System.out.println("[PRINT ALL TEXT FAILED] " + elementName);
			captureFailure("[PRINT ALL TEXT FAILED] " + elementName, ex);
			return new java.util.ArrayList<>();
		}

		return elements;
	}

	// print the text of all the elements direclty from the dom using javascript not
	// from element directly
	public List<String> printTextOfAllElementsUsingJavascript(String cssSelector, String elementName) {
		try {
			if (cssSelector == null || cssSelector.trim().isEmpty()) {
				throw new IllegalArgumentException("CSS selector is null or empty");
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;

			@SuppressWarnings("unchecked")
			List<String> texts = (List<String>) js
					.executeScript("var elements = document.querySelectorAll(arguments[0]);" + "var result = [];"
							+ "for (var i = 0; i < elements.length; i++) {"
							+ "    var text = elements[i].textContent.trim();" + "    if (text !== '') {"
							+ "        result.push(text);" + "    }" + "}" + "return result;", cssSelector);

			System.out
					.println("[PRINT ALL TEXT USING JAVASCRIPT] " + elementName + " | Total elements: " + texts.size());

			for (int i = 0; i < texts.size(); i++) {
				System.out.println((i + 1) + ". " + texts.get(i));
			}

			return texts;

		} catch (Exception ex) {
			System.out.println("[PRINT ALL TEXT USING JAVASCRIPT FAILED] " + elementName);
			captureFailure("[PRINT ALL TEXT USING JAVASCRIPT FAILED] " + elementName, ex);
			return new ArrayList<>();
		}
	}

	// count functions.
	public boolean verifyTotalElementsCount(int expectedCount, By locator) {
		int actualCount = 0;

		try {
			if (locator == null) {
				throw new IllegalArgumentException("Locator is null");
			}

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

	// function to count the number of elements.
	public boolean verifyTotalElementsCount(int expectedCount, List<?> elements) {
		int actualCount = 0;

		try {

			if (elements == null) {
				throw new IllegalArgumentException("Element list is null");
			}

			System.out.println("[COUNT VERIFY] Expected: " + expectedCount);

			for (int i = 1; i <= 50; i++) {

				actualCount = elements.size();

				if (actualCount == expectedCount) {
					System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
					break;
				}

				Thread.sleep(200);
			}

			System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);

			boolean ok = (actualCount == expectedCount);

			if (!ok) {
				captureFailure("COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount);
			}

			return ok;

		} catch (Exception ex) {

			System.out.println("[COUNT FAILED] Expected: " + expectedCount + " | Actual: " + actualCount);

			captureFailure("COUNT FAILED -> expected=" + expectedCount + " actual=" + actualCount, ex);

			return false;
		}
	}

}