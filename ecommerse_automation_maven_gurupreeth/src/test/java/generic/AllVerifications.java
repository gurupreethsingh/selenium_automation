//
//package generic;
//
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.ElementClickInterceptedException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class AllVerifications {
//
//	protected final WebDriver driver;
//	protected final ScreenshotUtility su;
//
//	// ============================================================
//	// ✅ CENTRAL CONFIG
//	// ============================================================
//	private static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
//	private static final int DEFAULT_RETRY_COUNT = 2;
//
//	// ============================================================
//	// ✅ CONSTRUCTOR
//	// ============================================================
//	public AllVerifications(WebDriver driver) {
//		this.driver = driver;
//		this.su = new ScreenshotUtility(driver);
//	}
//
//	protected WebDriverWait createWait(int seconds) {
//		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
//	}
//
//	// ============================================================
//	// ✅ SCREENSHOT HELPERS
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
//			System.out
//					.println("[SCREENSHOT] " + tag + " | ex=" + (ex == null ? "null" : ex.getClass().getSimpleName()));
//			su.captureScreenshot();
//		} catch (Exception ignore) {
//			System.out.println("[SCREENSHOT FAILED] " + tag);
//		}
//	}
//
//	// function to check if they are present and visible to perform actions on them.
//
//	public boolean verifyElementPresentAndVisible(WebElement element, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (element == null) {
//					throw new IllegalArgumentException("Element is null");
//				}
//
//				String displayName = normalizeName(elementName, getElementDisplayName(element));
//
//				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName);
//
//				// 1. Validate reference is still alive
//				try {
//					element.isDisplayed();
//				} catch (StaleElementReferenceException sere) {
//					throw sere;
//				} catch (Exception ex) {
//					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
//				}
//
//				// 2. Wait until visible
//				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOf(element));
//
//				// 3. Final displayed check
//				if (!visibleElement.isDisplayed()) {
//					throw new IllegalStateException("Element is not displayed: " + displayName);
//				}
//
//				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
//				return true;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
//				captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);
//
//			} catch (TimeoutException te) {
//				System.out.println("[ELEMENT VERIFY TIMEOUT] " + elementName + " | " + te.getMessage());
//				captureFailure("ELEMENT VERIFY TIMEOUT -> " + elementName, te);
//				return false;
//
//			} catch (Exception ex) {
//				System.out.println("[ELEMENT VERIFY FAILED] " + elementName + " | " + ex.getMessage());
//				captureFailure("ELEMENT VERIFY FAILED -> " + elementName, ex);
//				return false;
//			}
//		}
//
//		System.out.println("[ELEMENT VERIFY FAILED AFTER RETRIES] " + elementName);
//		captureFailure("ELEMENT VERIFY FAILED AFTER RETRIES -> " + elementName);
//		return false;
//	}
//
//	public boolean verifyElementPresentAndVisible(By locator, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (locator == null) {
//					throw new IllegalArgumentException("Locator is null");
//				}
//
//				String displayName = normalizeName(elementName, locator.toString());
//
//				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName + " | " + locator);
//
//				// 1. Check DOM presence
//				List<WebElement> found = driver.findElements(locator);
//				if (found.isEmpty()) {
//					throw new NoSuchElementException("Element is not present in DOM: " + locator);
//				}
//
//				// 2. Wait for presence
//				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//				// 3. Wait for visibility
//				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//				// 4. Final displayed check
//				if (!element.isDisplayed()) {
//					throw new IllegalStateException("Element is not displayed: " + displayName);
//				}
//
//				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
//				return true;
//
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
//				captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);
//
//			} catch (TimeoutException te) {
//				System.out.println("[ELEMENT VERIFY TIMEOUT] " + elementName + " | " + te.getMessage());
//				captureFailure("ELEMENT VERIFY TIMEOUT -> " + elementName, te);
//				return false;
//
//			} catch (Exception ex) {
//				System.out.println("[ELEMENT VERIFY FAILED] " + elementName + " | " + ex.getMessage());
//				captureFailure("ELEMENT VERIFY FAILED -> " + elementName, ex);
//				return false;
//			}
//		}
//
//		System.out.println("[ELEMENT VERIFY FAILED AFTER RETRIES] " + elementName);
//		captureFailure("ELEMENT VERIFY FAILED AFTER RETRIES -> " + elementName);
//		return false;
//	}
//
//	// ENTERPRISE CLICK - WEBELEMENT
//	public boolean clickOnElement(WebElement element, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (element == null) {
//					throw new IllegalArgumentException("Element is null");
//				}
//				String displayName = normalizeName(elementName, getElementDisplayName(element));
//				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName);
//				// 1. Validate element reference still exists
//				try {
//					element.isDisplayed();
//				} catch (StaleElementReferenceException sere) {
//					throw sere;
//				} catch (Exception ex) {
//					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
//				}
//				// 2. Scroll to center
//				scrollElementToCenter(element);
//				// 3. Wait until visible
//				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOf(element));
//				// 4. Wait until clickable
//				WebElement clickableElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.elementToBeClickable(visibleElement));
//				// 5. Check enabled
//				if (!clickableElement.isEnabled()) {
//					throw new IllegalStateException("Element is disabled: " + displayName);
//				}
//				// 6. Resolve best possible text for reporting
//				String clickedText = getCleanText(clickableElement);
//				if (clickedText == null || clickedText.trim().isEmpty()) {
//					clickedText = displayName;
//				}
//				System.out.println("[CLICKING ELEMENT] " + clickedText);
//				// 7. Normal click -> Actions click -> JS click
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
//				System.out.println("[CLICK SUCCESS] " + clickedText);
//				return true;
//			} catch (StaleElementReferenceException sere) {
//				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
//				captureFailure("CLICK STALE -> " + elementName, sere);
//			} catch (TimeoutException te) {
//				System.out.println("[CLICK TIMEOUT] " + elementName + " | " + te.getMessage());
//				captureFailure("CLICK TIMEOUT -> " + elementName, te);
//				return false;
//			} catch (Exception ex) {
//				System.out.println("[CLICK FAILED] " + elementName + " | " + ex.getMessage());
//				captureFailure("CLICK FAILED -> " + elementName, ex);
//				return false;
//			}
//		}
//		System.out.println("[CLICK FAILED AFTER RETRIES] " + elementName);
//		captureFailure("CLICK FAILED AFTER RETRIES -> " + elementName);
//		return false;
//	}
//
//	// ============================================================
//	// ✅ ENTERPRISE CLICK - LOCATOR
//	// ============================================================
//	public boolean clickOnElement(By locator, String elementName) {
//		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
//			try {
//				if (locator == null) {
//					throw new IllegalArgumentException("Locator is null");
//				}
//
//				String displayName = normalizeName(elementName, locator.toString());
//
//				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName + " | " + locator);
//
//				// 1. Presence check
//				List<WebElement> found = driver.findElements(locator);
//				if (found.isEmpty()) {
//					throw new NoSuchElementException("Element is not present in DOM: " + locator);
//				}
//
//				// 2. Wait for presence
//				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//				// 3. Scroll
//				scrollElementToCenter(element);
//
//				// 4. Wait for visibility
//				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//				// 5. Wait for clickability
//				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
//						.until(ExpectedConditions.elementToBeClickable(locator));
//
//				// 6. Enabled check
//				if (!element.isEnabled()) {
//					throw new IllegalStateException("Element is disabled: " + displayName);
//				}
//
//				// 7. Get reporting text
//				String clickedText = getCleanText(element);
//				if (clickedText == null || clickedText.trim().isEmpty()) {
//					clickedText = displayName;
//				}
//
//				System.out.println("[CLICKING ELEMENT] " + clickedText);
//
//				// 8. Normal click -> Actions click -> JS click
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
//			} catch (TimeoutException te) {
//				System.out.println("[CLICK TIMEOUT] " + elementName + " | " + te.getMessage());
//				captureFailure("CLICK TIMEOUT -> " + elementName, te);
//				return false;
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
//	// ============================================================
//	// ✅ ENTERPRISE TEXT VERIFICATION // matchType = equals / contains / regex
//	// ============================================================
//	public boolean verifyText(WebElement element, String expectedText, String name, String matchType,
//			boolean ignoreCase) {
//		try {
//			if (element == null) {
//				throw new IllegalArgumentException("Element is null");
//			}
//
//			expectedText = safeTrim(expectedText);
//			matchType = safeTrim(matchType).toLowerCase();
//			name = normalizeName(name, "TEXT ELEMENT");
//
//			if (expectedText.isEmpty()) {
//				throw new IllegalArgumentException("Expected text is null or empty");
//			}
//
//			if (!matchType.equals("equals") && !matchType.equals("contains") && !matchType.equals("regex")) {
//				throw new IllegalArgumentException("Invalid matchType: " + matchType);
//			}
//
//			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(ExpectedConditions.visibilityOf(element));
//
//			String actualText = safeTrim(element.getText());
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
//	// ============================================================
//	// ✅ ENTERPRISE TITLE VERIFICATION // EXACT / PARTIAL / NORMALIZED PARTIAL /
//	// REGEX
//	// ============================================================
//	public boolean verifyTitleOfWebpage(String expectedTitle) {
//		boolean titleVerified = false;
//
//		try {
//			expectedTitle = safeTrim(expectedTitle);
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
//			String actualTitle = safeTrim(driver.getTitle());
//
//			String normalizedExpected = normalizeVerificationText(expectedTitle);
//			String normalizedActual = normalizeVerificationText(actualTitle);
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
//			} else if (isValidRegex(expectedTitle) && actualTitle.matches(expectedTitle)) {
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
//	// ============================================================
//	// ✅ ENTERPRISE URL VERIFICATION // EXACT / PARTIAL / NORMALIZED PARTIAL / REGEX
//	// // with URL decoding
//	// ============================================================
//	public boolean verifyUrlOfWebpage(String expectedUrl) {
//		boolean urlVerified = false;
//
//		try {
//			expectedUrl = safeTrim(expectedUrl);
//
//			if (expectedUrl.isEmpty()) {
//				throw new IllegalArgumentException("Expected URL is null or empty");
//			}
//
//			String actualUrl = safeTrim(driver.getCurrentUrl());
//			String decodedActualUrl = URLDecoder.decode(actualUrl, StandardCharsets.UTF_8);
//
//			String normalizedExpected = normalizeVerificationText(expectedUrl);
//			String normalizedActual = normalizeVerificationText(decodedActualUrl);
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
//	// ============================================================
//	// ✅ INTERNAL HELPERS
//	// ============================================================
//	// internal helper to scroll to the center of the element
//	protected void scrollElementToCenter(WebElement element) {
//		try {
//			((JavascriptExecutor) driver).executeScript(
//					"arguments[0].scrollIntoView({block:'center', inline:'center', behavior:'instant'});", element);
//		} catch (Exception e) {
//			System.out.println("[SCROLL FAILED] Unable to scroll element to center.");
//		}
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
//
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
//	private String normalizeVerificationText(String value) {
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
//	private String normalizeName(String preferredName, String fallbackName) {
//		String name = safeTrim(preferredName);
//		if (!name.isEmpty()) {
//			return name;
//		}
//		return safeTrim(fallbackName).isEmpty() ? "UNNAMED ELEMENT" : safeTrim(fallbackName);
//	}
//
//	private String safeTrim(String value) {
//		return value == null ? "" : value.trim();
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
//	// generic function print names of all the elements
//	public List<WebElement> printTextOfAllElements(List<WebElement> elements, String elementName) {
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
//			return new java.util.ArrayList<>();
//		}
//
//		return elements;
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
//			List<String> texts = (List<String>) js.executeScript(""
//					+ "var elements = document.querySelectorAll(arguments[0]);" + "var result = [];"
//					+ "for (var i = 0; i < elements.length; i++) " + "{" + "var text = elements[i].textContent.trim();"
//					+ "if (text !== '') " + "{" + "result.push(text);" + "    " + "}" + "}" + "return result;",
//					cssSelector);
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
//	// count functions.
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
//	// function to count the number of elements.
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

	protected static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
	protected static final int DEFAULT_RETRY_COUNT = 2;
	private static final int SPA_SETTLE_POLLS = 3;
	private static final long SPA_SETTLE_SLEEP_MS = 250;

	public AllVerifications(WebDriver driver) {
		this.driver = driver;
		this.su = new ScreenshotUtility(driver);
	}

	protected WebDriverWait createWait(int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

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

	// ============================================================
	// ✅ REACT / SPA AWARE PAGE WAITS
	// ============================================================

	public boolean waitForDocumentReady(String pageName) {
		try {
			String displayName = normalizeName(pageName, "PAGE");
			System.out.println("[WAIT DOCUMENT READY] " + displayName);

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				try {
					String state = String
							.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
					return "complete".equalsIgnoreCase(state);
				} catch (Exception e) {
					return false;
				}
			});

			System.out.println("[DOCUMENT READY PASS] " + displayName);
			return true;

		} catch (Exception ex) {
			System.out.println("[DOCUMENT READY FAIL] " + pageName + " | " + ex.getMessage());
			captureFailure("DOCUMENT READY FAIL -> " + pageName, ex);
			return false;
		}
	}

	private String getDomStabilitySnapshot() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			Object result = js.executeScript("var root = document.querySelector('#root') || document.body;"
					+ "if (!root) return '';" + "var title = document.title || '';"
					+ "var href = window.location.href || '';" + "var childCount = root.querySelectorAll('*').length;"
					+ "var textLen = (root.innerText || '').trim().length;"
					+ "var htmlLen = (root.innerHTML || '').trim().length;"
					+ "return title + '||' + href + '||' + childCount + '||' + textLen + '||' + htmlLen;");

			return result == null ? "" : result.toString();

		} catch (Exception e) {
			return "";
		}
	}

	private boolean waitForSpaDomToSettle(String pageName) {
		try {
			String displayName = normalizeName(pageName, "PAGE");
			System.out.println("[WAIT SPA DOM STABLE] " + displayName);

			String previousSnapshot = "";
			int stableCount = 0;

			long endTime = System.currentTimeMillis() + (DEFAULT_WAITING_TIME_IN_SEC * 1000L);

			while (System.currentTimeMillis() < endTime) {
				String currentSnapshot = getDomStabilitySnapshot();

				if (!currentSnapshot.isEmpty() && currentSnapshot.equals(previousSnapshot)) {
					stableCount++;
				} else {
					stableCount = 0;
				}

				if (stableCount >= SPA_SETTLE_POLLS) {
					System.out.println("[SPA DOM STABLE PASS] " + displayName);
					return true;
				}

				previousSnapshot = currentSnapshot;
				Thread.sleep(SPA_SETTLE_SLEEP_MS);
			}

			System.out.println("[SPA DOM STABLE TIMEOUT] " + displayName);
			return false;

		} catch (Exception ex) {
			System.out.println("[SPA DOM STABLE FAIL] " + pageName + " | " + ex.getMessage());
			return false;
		}
	}

	public boolean waitForPageToLoad(String expectedTitle, String expectedUrl, String pageName) {
		try {
			String displayName = normalizeName(pageName, "PAGE");

			final String finalExpectedTitle = safeTrim(expectedTitle);
			final String finalExpectedUrl = safeTrim(expectedUrl);

			System.out.println("[WAIT PAGE LOAD] " + displayName);
			System.out.println("Expected Title : " + finalExpectedTitle);
			System.out.println("Expected URL   : " + finalExpectedUrl);

			// 1. Browser document ready
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				try {
					String state = String
							.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
					return "complete".equalsIgnoreCase(state);
				} catch (Exception e) {
					return false;
				}
			});

			// 2. Wait until URL matches if provided
			if (!finalExpectedUrl.isEmpty()) {
				createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
					try {
						String actualUrl = safeTrim(driver.getCurrentUrl());
						return matchesExpectedUrl(actualUrl, finalExpectedUrl);
					} catch (Exception e) {
						return false;
					}
				});
			}

			// 3. Wait until title matches if provided
			if (!finalExpectedTitle.isEmpty()) {
				createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
					try {
						String actualTitle = safeTrim(driver.getTitle());
						return matchesExpectedText(actualTitle, finalExpectedTitle);
					} catch (Exception e) {
						return false;
					}
				});
			}

			// 4. SPA settle wait - helps React title/DOM stabilization
			waitForSpaDomToSettle(displayName);

			// 5. Final confirmation after settle
			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				try {
					String actualTitle = safeTrim(driver.getTitle());
					String actualUrl = safeTrim(driver.getCurrentUrl());

					boolean titleOk = finalExpectedTitle.isEmpty()
							|| matchesExpectedText(actualTitle, finalExpectedTitle);

					boolean urlOk = finalExpectedUrl.isEmpty() || matchesExpectedUrl(actualUrl, finalExpectedUrl);

					return titleOk && urlOk;
				} catch (Exception e) {
					return false;
				}
			});

			System.out.println("[PAGE LOAD PASS] " + displayName + " | Title: " + safeTitle() + " | URL: " + safeUrl());
			return true;

		} catch (Exception ex) {
			System.out.println("[PAGE LOAD FAIL] " + pageName + " | " + ex.getMessage());
			System.out.println("Actual Title : " + safeTitle());
			System.out.println("Actual URL   : " + safeUrl());
			captureFailure("PAGE LOAD FAIL -> " + pageName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ ELEMENT VISIBILITY
	// ============================================================

	public boolean verifyElementPresentAndVisible(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				waitForDocumentReady(displayName);

				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName);

				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

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

				waitForDocumentReady(displayName);

				System.out.println("[VERIFY ELEMENT ATTEMPT " + attempt + "] " + displayName + " | " + locator);

				List<WebElement> found = driver.findElements(locator);
				if (found.isEmpty()) {
					throw new NoSuchElementException("Element is not present in DOM: " + locator);
				}

				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

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
	// ✅ CLICK - WEBELEMENT
	// ============================================================

	public boolean clickOnElement(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				waitForDocumentReady(displayName);

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName);

				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				scrollElementToCenter(element);

				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				WebElement clickableElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.elementToBeClickable(visibleElement));

				if (!clickableElement.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				String clickedText = getCleanText(clickableElement);
				if (clickedText == null || clickedText.trim().isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

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
	// ✅ CLICK - LOCATOR
	// ============================================================

	public boolean clickOnElement(By locator, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());

				waitForDocumentReady(displayName);

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName + " | " + locator);

				List<WebElement> found = driver.findElements(locator);
				if (found.isEmpty()) {
					throw new NoSuchElementException("Element is not present in DOM: " + locator);
				}

				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				scrollElementToCenter(element);

				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.elementToBeClickable(locator));

				if (!element.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				String clickedText = getCleanText(element);
				if (clickedText == null || clickedText.trim().isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

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
	// ✅ TEXT VERIFY
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

			waitForDocumentReady(name);

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
	// ✅ TITLE VERIFY
	// ============================================================
	public boolean verifyTitleOfWebpage(String expectedTitle) {
		boolean titleVerified = false;

		try {
			expectedTitle = safeTrim(expectedTitle);

			if (expectedTitle.isEmpty()) {
				throw new IllegalArgumentException("Expected title is null or empty");
			}

			waitForDocumentReady("TITLE VERIFY");

			final String finalExpectedTitle = expectedTitle;

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				String actualTitle = safeTrim(driver.getTitle());
				return matchesExpectedText(actualTitle, finalExpectedTitle);
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
	// ✅ URL VERIFY
	// ============================================================
	public boolean verifyUrlOfWebpage(String expectedUrl) {
		boolean urlVerified = false;

		try {
			expectedUrl = safeTrim(expectedUrl);

			if (expectedUrl.isEmpty()) {
				throw new IllegalArgumentException("Expected URL is null or empty");
			}

			waitForDocumentReady("URL VERIFY");

			final String finalExpectedUrl = safeTrim(URLDecoder.decode(expectedUrl, StandardCharsets.UTF_8));

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				String actualUrl = safeTrim(driver.getCurrentUrl());
				return matchesExpectedUrl(actualUrl, finalExpectedUrl);
			});

			String actualUrl = safeTrim(driver.getCurrentUrl());
			String decodedActualUrl = safeTrim(URLDecoder.decode(actualUrl, StandardCharsets.UTF_8));

			String normalizedExpected = normalizeVerificationText(finalExpectedUrl);
			String normalizedActual = normalizeVerificationText(decodedActualUrl);

			System.out.println("[VERIFY URL]");
			System.out.println("Expected Input      : " + expectedUrl);
			System.out.println("Decoded Expected    : " + finalExpectedUrl);
			System.out.println("Actual URL          : " + actualUrl);
			System.out.println("Decoded Actual URL  : " + decodedActualUrl);
			System.out.println("Normalized Expected : " + normalizedExpected);
			System.out.println("Normalized Actual   : " + normalizedActual);

			if (decodedActualUrl.equalsIgnoreCase(finalExpectedUrl)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: EXACT");
			} else if (decodedActualUrl.toLowerCase().contains(finalExpectedUrl.toLowerCase())) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: PARTIAL");
			} else if (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: NORMALIZED PARTIAL");
			} else if (isValidRegex(finalExpectedUrl) && decodedActualUrl.matches(finalExpectedUrl)) {
				urlVerified = true;
				System.out.println("[URL PASS] Match Type: REGEX");
			}

			if (urlVerified) {
				System.out.println("[URL PASS] Expected: " + finalExpectedUrl + " | Found: " + actualUrl);
			} else {
				System.out.println("[URL FAIL] Expected: " + finalExpectedUrl + " | Found: " + actualUrl);
				captureFailure("VERIFY URL FAIL -> expected=" + finalExpectedUrl + " | actual=" + actualUrl
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

	private boolean matchesExpectedText(String actualText, String expectedText) {
		actualText = safeTrim(actualText);
		expectedText = safeTrim(expectedText);

		if (expectedText.isEmpty()) {
			return true;
		}

		String normalizedExpected = normalizeVerificationText(expectedText);
		String normalizedActual = normalizeVerificationText(actualText);

		return actualText.equalsIgnoreCase(expectedText)
				|| actualText.toLowerCase().contains(expectedText.toLowerCase())
				|| (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected))
				|| (isValidRegex(expectedText) && actualText.matches(expectedText));
	}

	private boolean matchesExpectedUrl(String actualUrl, String expectedUrl) {
		actualUrl = safeTrim(actualUrl);
		expectedUrl = safeTrim(expectedUrl);

		if (expectedUrl.isEmpty()) {
			return true;
		}

		String decodedActualUrl = URLDecoder.decode(actualUrl, StandardCharsets.UTF_8);

		String normalizedExpected = normalizeVerificationText(expectedUrl);
		String normalizedActual = normalizeVerificationText(decodedActualUrl);

		return decodedActualUrl.equalsIgnoreCase(expectedUrl)
				|| decodedActualUrl.toLowerCase().contains(expectedUrl.toLowerCase())
				|| (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected))
				|| (isValidRegex(expectedUrl) && decodedActualUrl.matches(expectedUrl));
	}

	// ============================================================
	// ✅ PRINT ALL TEXT
	// ============================================================

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
			return new ArrayList<>();
		}

		return elements;
	}

	public List<String> printTextOfAllElementsUsingJavascript(String cssSelector, String elementName) {
		try {
			if (cssSelector == null || cssSelector.trim().isEmpty()) {
				throw new IllegalArgumentException("CSS selector is null or empty");
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;

			@SuppressWarnings("unchecked")
			List<String> texts = (List<String>) js.executeScript(""
					+ "var elements = document.querySelectorAll(arguments[0]);" + "var result = [];"
					+ "for (var i = 0; i < elements.length; i++) {" + "  var text = elements[i].textContent.trim();"
					+ "  if (text !== '') { result.push(text); }" + "}" + "return result;", cssSelector);

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

	// ============================================================
	// ✅ COUNT FUNCTIONS
	// ============================================================

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

// ============================================================
// ✅ GENERIC DROPDOWN HELPERS
// ============================================================

	public boolean verifyDropdownPresentAndVisible(WebElement dropdownContainer, String dropdownName) {
		try {
			if (dropdownContainer == null) {
				throw new IllegalArgumentException("Dropdown container is null for: " + dropdownName);
			}

			boolean status = verifyElementPresentAndVisible(dropdownContainer, dropdownName);

			if (status) {
				System.out.println("[DROPDOWN PASS] " + dropdownName + " is present and visible");
			} else {
				System.out.println("[DROPDOWN FAIL] " + dropdownName + " is NOT present and visible");
				captureFailure("DROPDOWN NOT VISIBLE -> " + dropdownName);
			}

			return status;

		} catch (Exception ex) {
			System.out.println("[DROPDOWN VERIFY FAILED] " + dropdownName);
			captureFailure("DROPDOWN VERIFY FAILED -> " + dropdownName, ex);
			return false;
		}
	}

	public boolean verifyDropdownHasOptions(List<WebElement> dropdownOptions, String dropdownName) {
		try {
			if (dropdownOptions == null) {
				throw new IllegalArgumentException("Dropdown options list is null for: " + dropdownName);
			}

			int count = dropdownOptions.size();

			System.out.println("[DROPDOWN OPTIONS COUNT] " + dropdownName + " -> " + count);

			if (count <= 0) {
				System.out.println("[DROPDOWN FAIL] No options found in dropdown: " + dropdownName);
				captureFailure("NO DROPDOWN OPTIONS FOUND -> " + dropdownName);
				return false;
			}

			System.out.println("[DROPDOWN PASS] Options found in dropdown: " + dropdownName);
			return true;

		} catch (Exception ex) {
			System.out.println("[DROPDOWN OPTIONS VERIFY FAILED] " + dropdownName);
			captureFailure("DROPDOWN OPTIONS VERIFY FAILED -> " + dropdownName, ex);
			return false;
		}
	}

	public List<WebElement> fetchAndPrintAllDropdownOptions(WebElement dropdownContainer,
			List<WebElement> dropdownOptions, String dropdownName) {
		try {
			if (!verifyDropdownPresentAndVisible(dropdownContainer, dropdownName)) {
				return dropdownOptions;
			}

			if (!verifyDropdownHasOptions(dropdownOptions, dropdownName)) {
				return dropdownOptions;
			}

			System.out.println("============================================================");
			System.out.println("[DROPDOWN OPTIONS PRINT]");
			System.out.println("Dropdown Name : " + dropdownName);
			System.out.println("Total Options : " + dropdownOptions.size());
			System.out.println("============================================================");

			return printTextOfAllElements(dropdownOptions, "[DROPDOWN OPTION] " + dropdownName);

		} catch (Exception ex) {
			System.out.println("[FETCH DROPDOWN OPTIONS FAILED] " + dropdownName);
			captureFailure("FETCH DROPDOWN OPTIONS FAILED -> " + dropdownName, ex);
			return dropdownOptions;
		}
	}

	public boolean verifyOptionExistsInDropdown(WebElement dropdownContainer, List<WebElement> dropdownOptions,
			String expectedOptionText, String dropdownName) {
		try {
			expectedOptionText = expectedOptionText == null ? "" : expectedOptionText.trim();

			if (expectedOptionText.isEmpty()) {
				throw new IllegalArgumentException(
						"Expected option text is null or empty for dropdown: " + dropdownName);
			}

			if (!verifyDropdownPresentAndVisible(dropdownContainer, dropdownName)) {
				return false;
			}

			if (!verifyDropdownHasOptions(dropdownOptions, dropdownName)) {
				return false;
			}

			System.out.println("[DROPDOWN OPTION SEARCH]");
			System.out.println("Dropdown Name   : " + dropdownName);
			System.out.println("Expected Option : " + expectedOptionText);

			for (int i = 0; i < dropdownOptions.size(); i++) {
				WebElement optionElement = dropdownOptions.get(i);
				String actualText = optionElement.getText() == null ? "" : optionElement.getText().trim();

				System.out.println("[DROPDOWN OPTION] Index: " + (i + 1) + " | Text: " + actualText);

				if (actualText.equalsIgnoreCase(expectedOptionText)) {
					System.out.println("[DROPDOWN OPTION PASS] Found option: " + expectedOptionText);
					return true;
				}
			}

			System.out.println("[DROPDOWN OPTION FAIL] Option not found: " + expectedOptionText);
			captureFailure("DROPDOWN OPTION NOT FOUND -> " + expectedOptionText + " | Dropdown: " + dropdownName);
			return false;

		} catch (Exception ex) {
			System.out
					.println("[DROPDOWN OPTION VERIFY FAILED] " + expectedOptionText + " | Dropdown: " + dropdownName);
			captureFailure("DROPDOWN OPTION VERIFY FAILED -> " + expectedOptionText + " | Dropdown: " + dropdownName,
					ex);
			return false;
		}
	}

	public WebElement fetchMatchingDropdownOption(WebElement dropdownContainer, List<WebElement> dropdownOptions,
			String expectedOptionText, String dropdownName) {
		try {
			expectedOptionText = expectedOptionText == null ? "" : expectedOptionText.trim();

			if (expectedOptionText.isEmpty()) {
				throw new IllegalArgumentException(
						"Expected option text is null or empty for dropdown: " + dropdownName);
			}

			if (!verifyDropdownPresentAndVisible(dropdownContainer, dropdownName)) {
				return null;
			}

			if (!verifyDropdownHasOptions(dropdownOptions, dropdownName)) {
				return null;
			}

			for (int i = 0; i < dropdownOptions.size(); i++) {
				WebElement optionElement = dropdownOptions.get(i);
				String actualText = optionElement.getText() == null ? "" : optionElement.getText().trim();

				if (actualText.equalsIgnoreCase(expectedOptionText)) {
					System.out.println("[MATCHING DROPDOWN OPTION FOUND] Index: " + (i + 1) + " | Text: " + actualText);
					return optionElement;
				}
			}

			System.out.println("[MATCHING DROPDOWN OPTION FAIL] Option not found: " + expectedOptionText);
			captureFailure(
					"MATCHING DROPDOWN OPTION NOT FOUND -> " + expectedOptionText + " | Dropdown: " + dropdownName);
			return null;

		} catch (Exception ex) {
			System.out.println(
					"[FETCH MATCHING DROPDOWN OPTION FAILED] " + expectedOptionText + " | Dropdown: " + dropdownName);
			captureFailure(
					"FETCH MATCHING DROPDOWN OPTION FAILED -> " + expectedOptionText + " | Dropdown: " + dropdownName,
					ex);
			return null;
		}
	}

	public int fetchAndPrintDropdownOptionsWithClasses(WebElement dropdownContainer, List<WebElement> dropdownOptions,
			String dropdownName) {
		int totalOptions = 0;

		try {
			if (!verifyDropdownPresentAndVisible(dropdownContainer, dropdownName)) {
				return totalOptions;
			}

			if (!verifyDropdownHasOptions(dropdownOptions, dropdownName)) {
				return totalOptions;
			}

			totalOptions = dropdownOptions.size();

			System.out.println("============================================================");
			System.out.println("[DROPDOWN OPTIONS WITH CLASS PRINT]");
			System.out.println("Dropdown Name : " + dropdownName);
			System.out.println("Total Options : " + totalOptions);
			System.out.println("============================================================");

			for (int i = 0; i < dropdownOptions.size(); i++) {
				WebElement optionElement = dropdownOptions.get(i);

				String actualText = "";
				String classValue = "";

				try {
					actualText = optionElement.getText() == null ? "" : optionElement.getText().trim();
					classValue = optionElement.getAttribute("class") == null ? ""
							: optionElement.getAttribute("class").trim();

					System.out.println("[DROPDOWN OPTION] Index: " + (i + 1) + " | Text: " + actualText + " | Class: "
							+ classValue);

				} catch (Exception innerEx) {
					System.out.println("[DROPDOWN OPTION READ FAILED] Index: " + (i + 1));
				}
			}

			return totalOptions;

		} catch (Exception ex) {
			System.out.println("[FETCH DROPDOWN OPTIONS WITH CLASS FAILED] " + dropdownName);
			captureFailure("FETCH DROPDOWN OPTIONS WITH CLASS FAILED -> " + dropdownName, ex);
			return totalOptions;
		}
	}

// ✅ MASTER UNIVERSAL DROPDOWN FUNCTION
	public boolean handleAndPrintDropdownOptions(WebElement dropdownContainer, List<WebElement> dropdownOptions,
			String dropdownName, String expectedOptionText) {
		try {
			expectedOptionText = expectedOptionText == null ? "" : expectedOptionText.trim();

			if (!verifyDropdownPresentAndVisible(dropdownContainer, dropdownName)) {
				return false;
			}

			if (!verifyDropdownHasOptions(dropdownOptions, dropdownName)) {
				return false;
			}

			fetchAndPrintAllDropdownOptions(dropdownContainer, dropdownOptions, dropdownName);

			if (!expectedOptionText.isEmpty()) {
				return verifyOptionExistsInDropdown(dropdownContainer, dropdownOptions, expectedOptionText,
						dropdownName);
			}

			return true;

		} catch (Exception ex) {
			System.out.println("[HANDLE AND PRINT DROPDOWN FAILED] " + dropdownName);
			captureFailure("HANDLE AND PRINT DROPDOWN FAILED -> " + dropdownName, ex);
			return false;
		}
	}

}
