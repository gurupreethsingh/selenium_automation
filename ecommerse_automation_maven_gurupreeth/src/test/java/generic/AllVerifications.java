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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {

	protected final WebDriver driver;
	protected final ScreenshotUtility su;

	protected static final int DEFAULT_WAITING_TIME_IN_SEC = 15;
	protected static final int DEFAULT_RETRY_COUNT = 2;
	private static final int SPA_SETTLE_POLLS = 3;
	private static final long SPA_SETTLE_SLEEP_MS = 250;
	private static final int DEFAULT_COUNT_POLL_ATTEMPTS = 50;
	private static final long DEFAULT_COUNT_POLL_SLEEP_MS = 200;

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
				sleepSilently(SPA_SETTLE_SLEEP_MS);
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

			createWait(DEFAULT_WAITING_TIME_IN_SEC).until(driver -> {
				try {
					String state = String
							.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
					return "complete".equalsIgnoreCase(state);
				} catch (Exception e) {
					return false;
				}
			});

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

			waitForSpaDomToSettle(displayName);

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

	// page loading verification after some action has been performed.
	public boolean verifyPageReloadAfterAction(Runnable action, String expectedTitle, String expectedUrl,
			String pageName) {
		try {
			String displayName = normalizeName(pageName, "PAGE RELOAD VERIFICATION");

			if (action == null) {
				throw new IllegalArgumentException("Action is null");
			}

			final String finalExpectedTitle = safeTrim(expectedTitle);
			final String finalExpectedUrl = safeTrim(expectedUrl);

			System.out.println("============================================================");
			System.out.println("[VERIFY PAGE RELOAD AFTER ACTION START]");
			System.out.println("Page Name       : " + displayName);
			System.out.println("Expected Title  : " + finalExpectedTitle);
			System.out.println("Expected URL    : " + finalExpectedUrl);
			System.out.println("============================================================");

			waitForDocumentReady(displayName + " BEFORE ACTION");

			String urlBefore = safeTrim(driver.getCurrentUrl());
			String titleBefore = safeTrim(driver.getTitle());
			String domSnapshotBefore = getDomStabilitySnapshot();

			Object beforeNavigationEntry = ((JavascriptExecutor) driver)
					.executeScript("var nav = performance.getEntriesByType('navigation');"
							+ "return nav && nav.length ? (nav[nav.length - 1].startTime + '||' + nav[nav.length - 1].type + '||' + nav[nav.length - 1].duration) : '';");

			String navigationBefore = beforeNavigationEntry == null ? "" : beforeNavigationEntry.toString();

			System.out.println("[BEFORE ACTION]");
			System.out.println("Title Before        : " + titleBefore);
			System.out.println("URL Before          : " + urlBefore);
			System.out.println("DOM Snapshot Before : " + domSnapshotBefore);
			System.out.println("Navigation Before   : " + navigationBefore);

			action.run();

			boolean pageLoadStatus = waitForPageToLoad(finalExpectedTitle, finalExpectedUrl,
					displayName + " AFTER ACTION");
			if (!pageLoadStatus) {
				System.out.println("[VERIFY PAGE RELOAD FAIL] Page did not load correctly after action.");
				captureFailure("VERIFY PAGE RELOAD FAIL -> Page load failed after action for: " + displayName);
				return false;
			}

			String urlAfter = safeTrim(driver.getCurrentUrl());
			String titleAfter = safeTrim(driver.getTitle());
			String domSnapshotAfter = getDomStabilitySnapshot();

			Object afterNavigationEntry = ((JavascriptExecutor) driver)
					.executeScript("var nav = performance.getEntriesByType('navigation');"
							+ "return nav && nav.length ? (nav[nav.length - 1].startTime + '||' + nav[nav.length - 1].type + '||' + nav[nav.length - 1].duration) : '';");

			String navigationAfter = afterNavigationEntry == null ? "" : afterNavigationEntry.toString();

			System.out.println("[AFTER ACTION]");
			System.out.println("Title After         : " + titleAfter);
			System.out.println("URL After           : " + urlAfter);
			System.out.println("DOM Snapshot After  : " + domSnapshotAfter);
			System.out.println("Navigation After    : " + navigationAfter);

			boolean expectedTitleOk = finalExpectedTitle.isEmpty()
					|| matchesExpectedText(titleAfter, finalExpectedTitle);
			boolean expectedUrlOk = finalExpectedUrl.isEmpty() || matchesExpectedUrl(urlAfter, finalExpectedUrl);

			boolean navigationChanged = !navigationBefore.equals(navigationAfter);
			boolean domChanged = !domSnapshotBefore.equals(domSnapshotAfter);

			boolean reloadVerified = expectedTitleOk && expectedUrlOk && (navigationChanged || domChanged);

			System.out.println("[RELOAD CHECK]");
			System.out.println("Expected Title OK : " + expectedTitleOk);
			System.out.println("Expected URL OK   : " + expectedUrlOk);
			System.out.println("Navigation Changed: " + navigationChanged);
			System.out.println("DOM Changed       : " + domChanged);
			System.out.println("Reload Verified   : " + reloadVerified);

			if (reloadVerified) {
				System.out.println("[VERIFY PAGE RELOAD AFTER ACTION PASS] " + displayName);
				return true;
			}

			System.out.println("[VERIFY PAGE RELOAD AFTER ACTION FAIL] " + displayName);
			captureFailure("VERIFY PAGE RELOAD AFTER ACTION FAIL -> " + displayName + " | TitleBefore=" + titleBefore
					+ " | TitleAfter=" + titleAfter + " | UrlBefore=" + urlBefore + " | UrlAfter=" + urlAfter
					+ " | NavBefore=" + navigationBefore + " | NavAfter=" + navigationAfter);
			return false;

		} catch (Exception ex) {
			System.out.println("[VERIFY PAGE RELOAD AFTER ACTION EXCEPTION] " + pageName + " | " + ex.getMessage());
			captureFailure("VERIFY PAGE RELOAD AFTER ACTION EXCEPTION -> " + pageName, ex);
			return false;
		}
	}

	// function to reload the page. any time.
	public boolean verifyPageReload(String expectedTitle, String expectedUrl, String pageName) {
		try {
			String displayName = normalizeName(pageName, "PAGE RELOAD VERIFICATION");
			String finalExpectedTitle = safeTrim(expectedTitle);
			String finalExpectedUrl = safeTrim(expectedUrl);

			System.out.println("============================================================");
			System.out.println("[VERIFY PAGE RELOAD START]");
			System.out.println("Page Name      : " + displayName);
			System.out.println("Expected Title : " + finalExpectedTitle);
			System.out.println("Expected URL   : " + finalExpectedUrl);
			System.out.println("============================================================");

			boolean pageLoadStatus = waitForPageToLoad(finalExpectedTitle, finalExpectedUrl, displayName);

			if (!pageLoadStatus) {
				System.out.println("[VERIFY PAGE RELOAD FAIL] Page did not load correctly.");
				captureFailure("VERIFY PAGE RELOAD FAIL -> " + displayName);
				return false;
			}

			String actualTitle = safeTrim(driver.getTitle());
			String actualUrl = safeTrim(driver.getCurrentUrl());

			boolean titleMatch = finalExpectedTitle.isEmpty() || matchesExpectedText(actualTitle, finalExpectedTitle);
			boolean urlMatch = finalExpectedUrl.isEmpty() || matchesExpectedUrl(actualUrl, finalExpectedUrl);

			System.out.println("Actual Title : " + actualTitle);
			System.out.println("Actual URL   : " + actualUrl);
			System.out.println("Title Match  : " + titleMatch);
			System.out.println("URL Match    : " + urlMatch);

			if (titleMatch && urlMatch) {
				System.out.println("[VERIFY PAGE RELOAD PASS] " + displayName);
				return true;
			}

			System.out.println("[VERIFY PAGE RELOAD FAIL] " + displayName);
			captureFailure("VERIFY PAGE RELOAD FAIL -> " + displayName + " | ActualTitle=" + actualTitle
					+ " | ActualUrl=" + actualUrl);
			return false;

		} catch (Exception ex) {
			System.out.println("[VERIFY PAGE RELOAD EXCEPTION] " + pageName + " | " + ex.getMessage());
			captureFailure("VERIFY PAGE RELOAD EXCEPTION -> " + pageName, ex);
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

				scrollElementToCenter(element);

				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				scrollElementToCenter(visibleElement);

				if (!visibleElement.isDisplayed()) {
					throw new IllegalStateException("Element is not displayed: " + displayName);
				}

				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);
				}
				sleepSilently(150);

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

				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				scrollElementToCenter(element);

				element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

				scrollElementToCenter(element);

				if (!element.isDisplayed()) {
					throw new IllegalStateException("Element is not displayed: " + displayName);
				}

				System.out.println("[ELEMENT PRESENT AND VISIBLE PASS] " + displayName);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[ELEMENT VERIFY STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("ELEMENT VERIFY STALE -> " + elementName, sere);
				}
				sleepSilently(150);

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
	// ✅ GENERIC WAIT HELPERS
	// ============================================================

	public WebElement waitUntilElementVisible(WebElement element, int timeoutSeconds, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));
				waitForDocumentReady(displayName);

				scrollElementToCenter(element);

				WebElement visibleElement = createWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));

				scrollElementToCenter(visibleElement);

				System.out.println("[WAIT VISIBLE PASS] " + displayName);
				return visibleElement;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[WAIT VISIBLE STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("WAIT VISIBLE STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[WAIT VISIBLE FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("WAIT VISIBLE FAILED -> " + elementName, ex);
				return null;
			}
		}

		System.out.println("[WAIT VISIBLE FAILED AFTER RETRIES] " + elementName);
		captureFailure("WAIT VISIBLE FAILED AFTER RETRIES -> " + elementName);
		return null;
	}

	public WebElement waitUntilElementVisible(By locator, int timeoutSeconds, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());
				waitForDocumentReady(displayName);

				WebElement visibleElement = createWait(timeoutSeconds)
						.until(ExpectedConditions.visibilityOfElementLocated(locator));

				scrollElementToCenter(visibleElement);

				System.out.println("[WAIT VISIBLE PASS] " + displayName);
				return visibleElement;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[WAIT VISIBLE STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("WAIT VISIBLE STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[WAIT VISIBLE FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("WAIT VISIBLE FAILED -> " + elementName, ex);
				return null;
			}
		}

		System.out.println("[WAIT VISIBLE FAILED AFTER RETRIES] " + elementName);
		captureFailure("WAIT VISIBLE FAILED AFTER RETRIES -> " + elementName);
		return null;
	}

	public WebElement waitUntilElementPresent(By locator, int timeoutSeconds, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());
				waitForDocumentReady(displayName);

				WebElement element = createWait(timeoutSeconds)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				System.out.println("[WAIT PRESENT PASS] " + displayName);
				return element;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[WAIT PRESENT STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("WAIT PRESENT STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[WAIT PRESENT FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("WAIT PRESENT FAILED -> " + elementName, ex);
				return null;
			}
		}

		System.out.println("[WAIT PRESENT FAILED AFTER RETRIES] " + elementName);
		captureFailure("WAIT PRESENT FAILED AFTER RETRIES -> " + elementName);
		return null;
	}

	public boolean waitUntilElementInvisible(By locator, int timeoutSeconds, String elementName) {
		try {
			if (locator == null) {
				throw new IllegalArgumentException("Locator is null");
			}

			String displayName = normalizeName(elementName, locator.toString());
			waitForDocumentReady(displayName);

			boolean status = createWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));

			if (status) {
				System.out.println("[WAIT INVISIBLE PASS] " + displayName);
			} else {
				System.out.println("[WAIT INVISIBLE FAIL] " + displayName);
				captureFailure("WAIT INVISIBLE FAILED -> " + displayName);
			}

			return status;

		} catch (Exception ex) {
			System.out.println("[WAIT INVISIBLE FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("WAIT INVISIBLE FAILED -> " + elementName, ex);
			return false;
		}
	}

	public boolean isElementPresentInDOM(By locator) {
		try {
			if (locator == null) {
				throw new IllegalArgumentException("Locator is null");
			}

			boolean status = !driver.findElements(locator).isEmpty();
			System.out.println("[ELEMENT PRESENT IN DOM] " + locator + " -> " + status);
			return status;

		} catch (Exception ex) {
			System.out.println("[ELEMENT PRESENT IN DOM FAILED] " + locator + " | " + ex.getMessage());
			return false;
		}
	}

	// ============================================================
	// ✅ CLICK - WEBELEMENT
	// ============================================================

	public WebElement waitUntilElementClickable(WebElement element, int timeoutSeconds, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				waitForDocumentReady(displayName);

				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				scrollElementToCenter(element);

				WebElement visibleElement = createWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));

				scrollElementToCenter(visibleElement);

				WebElement clickableElement = createWait(timeoutSeconds)
						.until(ExpectedConditions.elementToBeClickable(visibleElement));

				scrollElementToCenter(clickableElement);

				if (!clickableElement.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				System.out.println("[WAIT CLICKABLE PASS] " + displayName);
				return clickableElement;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[WAIT CLICKABLE STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("WAIT CLICKABLE STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (TimeoutException te) {
				System.out.println("[WAIT CLICKABLE TIMEOUT] " + elementName + " | " + te.getMessage());
				captureFailure("WAIT CLICKABLE TIMEOUT -> " + elementName, te);
				return null;

			} catch (Exception ex) {
				System.out.println("[WAIT CLICKABLE FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("WAIT CLICKABLE FAILED -> " + elementName, ex);
				return null;
			}
		}

		System.out.println("[WAIT CLICKABLE FAILED AFTER RETRIES] " + elementName);
		captureFailure("WAIT CLICKABLE FAILED AFTER RETRIES -> " + elementName);
		return null;
	}

	public boolean clickOnElement(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName);

				try {
					element.isDisplayed();
				} catch (StaleElementReferenceException sere) {
					throw sere;
				} catch (Exception ex) {
					throw new NoSuchElementException("Element is not present in DOM: " + displayName);
				}

				WebElement clickableElement = waitUntilElementClickable(element, DEFAULT_WAITING_TIME_IN_SEC,
						displayName);
				if (clickableElement == null) {
					return false;
				}

				String clickedText = getCleanText(clickableElement);
				if (clickedText.isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

				performRobustClick(clickableElement);

				System.out.println("[CLICK SUCCESS] " + clickedText);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("CLICK STALE -> " + elementName, sere);
				}
				sleepSilently(150);

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

	public boolean clickOnElement(By locator, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (locator == null) {
					throw new IllegalArgumentException("Locator is null");
				}

				String displayName = normalizeName(elementName, locator.toString());

				waitForDocumentReady(displayName);

				System.out.println("[CLICK ATTEMPT " + attempt + "] " + displayName + " | " + locator);

				WebElement element = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.presenceOfElementLocated(locator));

				WebElement clickableElement = waitUntilElementClickable(element, DEFAULT_WAITING_TIME_IN_SEC,
						displayName);
				if (clickableElement == null) {
					return false;
				}

				String clickedText = getCleanText(clickableElement);
				if (clickedText.isEmpty()) {
					clickedText = displayName;
				}

				System.out.println("[CLICKING ELEMENT] " + clickedText);

				performRobustClick(clickableElement);

				System.out.println("[CLICK SUCCESS] " + clickedText);
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[CLICK STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("CLICK STALE -> " + elementName, sere);
				}
				sleepSilently(150);

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
	// ✅ TEXT FUNCTIONS
	// ============================================================

	public String getTextFromElement(WebElement element, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				waitForDocumentReady(displayName);
				scrollElementToCenter(element);

				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				scrollElementToCenter(visibleElement);

				String actualText = safeTrim(readTextSafely(visibleElement));

				System.out.println("[GET TEXT PASS] " + displayName + " -> " + actualText);
				return actualText;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[GET TEXT STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("GET TEXT STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[GET TEXT FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("GET TEXT FAILED -> " + elementName, ex);
				return "";
			}
		}

		System.out.println("[GET TEXT FAILED AFTER RETRIES] " + elementName);
		captureFailure("GET TEXT FAILED AFTER RETRIES -> " + elementName);
		return "";
	}

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

			scrollElementToCenter(element);

			WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.visibilityOf(element));

			scrollElementToCenter(visibleElement);

			String actualText = safeTrim(readTextSafely(visibleElement));

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
			if (element == null) {
				return;
			}
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block:'center', inline:'center', behavior:'instant'});", element);
		} catch (Exception e) {
			System.out.println("[SCROLL FAILED] Unable to scroll element to center.");
		}
	}

	protected void scrollToTopOfPage() {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo({top:0, behavior:'instant'});");
			System.out.println("[SCROLL TOP PASS]");
		} catch (Exception e) {
			System.out.println("[SCROLL TOP FAIL]");
		}
	}

	protected void scrollToBottomOfPage() {
		try {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo({top:document.body.scrollHeight, behavior:'instant'});");
			System.out.println("[SCROLL BOTTOM PASS]");
		} catch (Exception e) {
			System.out.println("[SCROLL BOTTOM FAIL]");
		}
	}

	protected void scrollByPixels(int x, int y) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
			System.out.println("[SCROLL BY PIXELS PASS] x=" + x + " y=" + y);
		} catch (Exception e) {
			System.out.println("[SCROLL BY PIXELS FAIL] x=" + x + " y=" + y);
		}
	}

	protected void scrollIntoViewStart(WebElement element) {
		try {
			if (element == null) {
				return;
			}
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block:'start', inline:'nearest', behavior:'instant'});", element);
			System.out.println("[SCROLL START PASS]");
		} catch (Exception e) {
			System.out.println("[SCROLL START FAIL]");
		}
	}

	protected void scrollIntoViewEnd(WebElement element) {
		try {
			if (element == null) {
				return;
			}
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block:'end', inline:'nearest', behavior:'instant'});", element);
			System.out.println("[SCROLL END PASS]");
		} catch (Exception e) {
			System.out.println("[SCROLL END FAIL]");
		}
	}

	protected String getCleanText(WebElement element) {
		if (element == null) {
			return "";
		}

		String text = readTextSafely(element);
		if (!text.isEmpty()) {
			return text;
		}

		String[] attrs = { "aria-label", "title", "alt", "name", "value", "placeholder", "id", "href", "src" };

		for (String attr : attrs) {
			try {
				String value = element.getAttribute(attr);
				if (value != null && !value.trim().isEmpty()) {
					return value.trim();
				}
			} catch (Exception e) {
				// ignore
			}
		}

		return "";
	}

	protected String getElementDisplayName(WebElement element) {
		if (element == null) {
			return "UNKNOWN ELEMENT";
		}

		String text = getCleanText(element);
		if (!text.isEmpty()) {
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
		String fallback = safeTrim(fallbackName);
		return fallback.isEmpty() ? "UNNAMED ELEMENT" : fallback;
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

		String decodedActualUrl = safeTrim(URLDecoder.decode(actualUrl, StandardCharsets.UTF_8));
		String decodedExpectedUrl = safeTrim(URLDecoder.decode(expectedUrl, StandardCharsets.UTF_8));

		String normalizedExpected = normalizeVerificationText(decodedExpectedUrl);
		String normalizedActual = normalizeVerificationText(decodedActualUrl);

		return decodedActualUrl.equalsIgnoreCase(decodedExpectedUrl)
				|| decodedActualUrl.toLowerCase().contains(decodedExpectedUrl.toLowerCase())
				|| (!normalizedExpected.isEmpty() && normalizedActual.contains(normalizedExpected))
				|| (isValidRegex(decodedExpectedUrl) && decodedActualUrl.matches(decodedExpectedUrl));
	}

	private void sleepSilently(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}

	private String readTextSafely(WebElement element) {
		if (element == null) {
			return "";
		}

		try {
			String text = element.getText();
			if (text != null && !text.trim().isEmpty()) {
				return text.trim();
			}
		} catch (Exception e) {
			// ignore
		}

		try {
			String textContent = element.getAttribute("textContent");
			if (textContent != null && !textContent.trim().isEmpty()) {
				return textContent.trim().replaceAll("\\s+", " ");
			}
		} catch (Exception e) {
			// ignore
		}

		try {
			String innerText = element.getAttribute("innerText");
			if (innerText != null && !innerText.trim().isEmpty()) {
				return innerText.trim().replaceAll("\\s+", " ");
			}
		} catch (Exception e) {
			// ignore
		}

		return "";
	}

	private void performRobustClick(WebElement element) {
		try {
			element.click();
			return;
		} catch (ElementClickInterceptedException e) {
			// fallback below
		}

		try {
			new Actions(driver).moveToElement(element).pause(Duration.ofMillis(200)).click().perform();
			return;
		} catch (Exception e) {
			// fallback below
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	private boolean isMacPlatform() {
		try {
			if (driver instanceof RemoteWebDriver) {
				Platform platform = ((RemoteWebDriver) driver).getCapabilities().getPlatformName();
				return platform != null && platform.is(Platform.MAC);
			}
		} catch (Exception e) {
			// ignore
		}

		String os = System.getProperty("os.name", "");
		return os.toLowerCase().contains("mac");
	}

	private Keys getSelectAllModifierKey() {
		return isMacPlatform() ? Keys.COMMAND : Keys.CONTROL;
	}

	private boolean waitForCountMatch(By locator, int expectedCount) {
		int actualCount = -1;

		for (int i = 1; i <= DEFAULT_COUNT_POLL_ATTEMPTS; i++) {
			try {
				actualCount = driver.findElements(locator).size();
			} catch (Exception e) {
				actualCount = -1;
			}

			if (actualCount == expectedCount) {
				System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
				return true;
			}

			sleepSilently(DEFAULT_COUNT_POLL_SLEEP_MS);
		}

		System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);
		return false;
	}

	private boolean waitForCountMatch(List<?> elements, int expectedCount) {
		int actualCount = -1;

		for (int i = 1; i <= DEFAULT_COUNT_POLL_ATTEMPTS; i++) {
			try {
				actualCount = elements.size();
			} catch (Exception e) {
				actualCount = -1;
			}

			if (actualCount == expectedCount) {
				System.out.println("[COUNT MATCH] attempt=" + i + " | Found: " + actualCount);
				return true;
			}

			sleepSilently(DEFAULT_COUNT_POLL_SLEEP_MS);
		}

		System.out.println("[COUNT RESULT] Expected: " + expectedCount + " | Actual: " + actualCount);
		return false;
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
				try {
					WebElement element = elements.get(i);
					scrollElementToCenter(element);
					String text = readTextSafely(element);
					System.out.println((i + 1) + ". " + text);
				} catch (StaleElementReferenceException sere) {
					System.out.println((i + 1) + ". [STALE ELEMENT]");
				} catch (Exception innerEx) {
					System.out.println((i + 1) + ". [UNABLE TO READ TEXT]");
				}
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
			List<String> texts = (List<String>) js
					.executeScript("var elements = document.querySelectorAll(arguments[0]);" + "var result = [];"
							+ "for (var i = 0; i < elements.length; i++) {"
							+ "  elements[i].scrollIntoView({block:'center', inline:'center', behavior:'instant'});"
							+ "  var text = (elements[i].textContent || elements[i].innerText || '').trim();"
							+ "  if (text !== '') { result.push(text.replace(/\\s+/g, ' ')); }" + "}"
							+ "return result;", cssSelector);

			if (texts == null) {
				texts = new ArrayList<>();
			}

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
		try {
			if (locator == null) {
				throw new IllegalArgumentException("Locator is null");
			}

			System.out.println("[COUNT VERIFY] Expected: " + expectedCount + " | Locator: " + locator);

			boolean ok = waitForCountMatch(locator, expectedCount);

			if (!ok) {
				int actualCount = driver.findElements(locator).size();
				captureFailure(
						"COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount + " | " + locator);
			}

			return ok;

		} catch (Exception ex) {
			System.out.println("[COUNT FAILED] Expected: " + expectedCount);
			captureFailure("COUNT FAILED -> expected=" + expectedCount + " | " + locator, ex);
			return false;
		}
	}

	public boolean verifyTotalElementsCount(int expectedCount, List<?> elements) {
		try {
			if (elements == null) {
				throw new IllegalArgumentException("Element list is null");
			}

			System.out.println("[COUNT VERIFY] Expected: " + expectedCount);

			boolean ok = waitForCountMatch(elements, expectedCount);

			if (!ok) {
				int actualCount = elements.size();
				captureFailure("COUNT MISMATCH -> expected=" + expectedCount + " actual=" + actualCount);
			}

			return ok;

		} catch (Exception ex) {
			System.out.println("[COUNT FAILED] Expected: " + expectedCount);
			captureFailure("COUNT FAILED -> expected=" + expectedCount, ex);
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

			scrollElementToCenter(dropdownContainer);

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

			int count = 0;

			for (int i = 1; i <= DEFAULT_COUNT_POLL_ATTEMPTS; i++) {
				try {
					count = dropdownOptions.size();
				} catch (Exception e) {
					count = 0;
				}

				if (count > 0) {
					break;
				}

				sleepSilently(DEFAULT_COUNT_POLL_SLEEP_MS);
			}

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
			expectedOptionText = safeTrim(expectedOptionText);

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
				scrollElementToCenter(optionElement);
				String actualText = safeTrim(readTextSafely(optionElement));

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
			expectedOptionText = safeTrim(expectedOptionText);

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
				scrollElementToCenter(optionElement);
				String actualText = safeTrim(readTextSafely(optionElement));

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
					scrollElementToCenter(optionElement);
					actualText = safeTrim(readTextSafely(optionElement));
					classValue = safeTrim(optionElement.getAttribute("class"));

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

	public boolean handleAndPrintDropdownOptions(WebElement dropdownContainer, List<WebElement> dropdownOptions,
			String dropdownName, String expectedOptionText) {
		try {
			expectedOptionText = safeTrim(expectedOptionText);

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

	// ============================================================
	// ✅ GENERIC LIST SEARCH HELPERS
	// ============================================================

	public WebElement fetchMatchingElementByExactText(List<WebElement> elements, String expectedText,
			String elementName) {
		try {
			if (elements == null) {
				throw new IllegalArgumentException("Element list is null");
			}

			String finalExpectedText = safeTrim(expectedText);

			if (finalExpectedText.isEmpty()) {
				throw new IllegalArgumentException("Expected text is null or empty");
			}

			System.out.println("[FETCH MATCHING ELEMENT BY EXACT TEXT]");
			System.out.println("Element Group  : " + normalizeName(elementName, "ELEMENT LIST"));
			System.out.println("Expected Text  : " + finalExpectedText);
			System.out.println("Total Elements : " + elements.size());

			for (int i = 0; i < elements.size(); i++) {
				WebElement element = elements.get(i);
				String actualText = getTextFromElement(element,
						normalizeName(elementName, "ELEMENT") + " Index: " + (i + 1));

				System.out.println("[ELEMENT TEXT] Index: " + (i + 1) + " | Text: " + actualText);

				if (actualText.equals(finalExpectedText)) {
					System.out.println("[MATCH FOUND] Index: " + (i + 1) + " | Text: " + actualText);
					return element;
				}
			}

			System.out.println("[MATCH NOT FOUND] " + finalExpectedText);
			captureFailure("MATCHING ELEMENT NOT FOUND -> " + finalExpectedText + " | Element Group: "
					+ normalizeName(elementName, "ELEMENT LIST"));
			return null;

		} catch (Exception ex) {
			System.out.println("[FETCH MATCHING ELEMENT FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("FETCH MATCHING ELEMENT FAILED -> " + elementName, ex);
			return null;
		}
	}

	// ============================================================
	// ✅ VERIFY ELEMENT IS ENABLED
	// ============================================================

	public boolean verifyElementIsEnabled(WebElement element, String elementName) {
		try {
			if (element == null) {
				throw new IllegalArgumentException("Element is null");
			}

			String displayName = normalizeName(elementName, getElementDisplayName(element));

			waitForDocumentReady(displayName);
			scrollElementToCenter(element);

			WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.visibilityOf(element));

			scrollElementToCenter(visibleElement);

			boolean status = visibleElement.isEnabled();

			System.out.println("[ELEMENT ENABLED VERIFY]");
			System.out.println("Element Name : " + displayName);
			System.out.println("Is Enabled   : " + status);

			if (status) {
				System.out.println("[ELEMENT ENABLED PASS] " + displayName);
			} else {
				System.out.println("[ELEMENT ENABLED FAIL] " + displayName);
				captureFailure("ELEMENT ENABLED VERIFY FAILED -> " + displayName);
			}

			return status;

		} catch (Exception ex) {
			System.out.println("[ELEMENT ENABLED VERIFY FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("ELEMENT ENABLED VERIFY FAILED -> " + elementName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ VERIFY INPUT FIELD PLACEHOLDER
	// ============================================================

	public boolean verifyInputFieldPlaceholder(WebElement inputField, String expectedPlaceholder, String elementName) {
		try {
			if (inputField == null) {
				throw new IllegalArgumentException("Input field is null");
			}

			String displayName = normalizeName(elementName, getElementDisplayName(inputField));
			String finalExpectedPlaceholder = safeTrim(expectedPlaceholder);

			waitForDocumentReady(displayName);
			scrollElementToCenter(inputField);

			WebElement visibleInputField = createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.visibilityOf(inputField));

			scrollElementToCenter(visibleInputField);

			String actualPlaceholder = safeTrim(visibleInputField.getAttribute("placeholder"));

			System.out.println("[INPUT PLACEHOLDER VERIFY]");
			System.out.println("Element Name          : " + displayName);
			System.out.println("Expected Placeholder  : " + finalExpectedPlaceholder);
			System.out.println("Actual Placeholder    : " + actualPlaceholder);

			boolean status = actualPlaceholder.equals(finalExpectedPlaceholder);

			if (status) {
				System.out.println("[INPUT PLACEHOLDER PASS] " + displayName);
			} else {
				System.out.println("[INPUT PLACEHOLDER FAIL] " + displayName);
				captureFailure("INPUT PLACEHOLDER VERIFY FAILED -> " + displayName + " | Expected: "
						+ finalExpectedPlaceholder + " | Actual: " + actualPlaceholder);
			}

			return status;

		} catch (Exception ex) {
			System.out.println("[INPUT PLACEHOLDER VERIFY FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("INPUT PLACEHOLDER VERIFY FAILED -> " + elementName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ CLEAR INPUT FIELD
	// ============================================================

	public boolean clearInputField(WebElement inputField, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (inputField == null) {
					throw new IllegalArgumentException("Input field is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(inputField));

				waitForDocumentReady(displayName);

				System.out.println("[CLEAR INPUT ATTEMPT " + attempt + "] " + displayName);

				scrollElementToCenter(inputField);

				WebElement visibleInputField = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(inputField));

				scrollElementToCenter(visibleInputField);

				if (!visibleInputField.isEnabled()) {
					throw new IllegalStateException("Input field is disabled: " + displayName);
				}

				visibleInputField.click();
				visibleInputField.clear();

				String currentValue = safeTrim(visibleInputField.getAttribute("value"));

				if (!currentValue.isEmpty()) {
					visibleInputField.sendKeys(Keys.chord(getSelectAllModifierKey(), "a"));
					visibleInputField.sendKeys(Keys.DELETE);
					currentValue = safeTrim(visibleInputField.getAttribute("value"));
				}

				if (!currentValue.isEmpty()) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].value='';" + "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));"
									+ "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
							visibleInputField);
					currentValue = safeTrim(visibleInputField.getAttribute("value"));
				}

				System.out.println("[CLEAR INPUT RESULT]");
				System.out.println("Element Name       : " + displayName);
				System.out.println("Value After Clear  : " + currentValue);

				boolean status = currentValue.isEmpty();

				if (status) {
					System.out.println("[CLEAR INPUT PASS] " + displayName);
				} else {
					System.out.println("[CLEAR INPUT FAIL] " + displayName);
					captureFailure("CLEAR INPUT FAILED -> " + displayName + " | Remaining Value: " + currentValue);
				}

				return status;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[CLEAR INPUT STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("CLEAR INPUT STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[CLEAR INPUT FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("CLEAR INPUT FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[CLEAR INPUT FAILED AFTER RETRIES] " + elementName);
		captureFailure("CLEAR INPUT FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	// ============================================================
	// ✅ ENTER VALUE INTO INPUT FIELD
	// ============================================================

	public boolean enterValueIntoInputField(WebElement inputField, String valueToEnter, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (inputField == null) {
					throw new IllegalArgumentException("Input field is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(inputField));
				String finalValueToEnter = valueToEnter == null ? "" : valueToEnter;

				waitForDocumentReady(displayName);

				System.out.println("[ENTER INPUT ATTEMPT " + attempt + "] " + displayName);
				System.out.println("Input Value : " + finalValueToEnter);

				scrollElementToCenter(inputField);

				WebElement visibleInputField = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(inputField));

				scrollElementToCenter(visibleInputField);

				if (!visibleInputField.isEnabled()) {
					throw new IllegalStateException("Input field is disabled: " + displayName);
				}

				visibleInputField.click();
				visibleInputField.sendKeys(finalValueToEnter);

				String actualValue = visibleInputField.getAttribute("value");
				actualValue = actualValue == null ? "" : actualValue;

				System.out.println("[INPUT VALUE ENTERED]");
				System.out.println("Element Name    : " + displayName);
				System.out.println("Expected Value  : " + finalValueToEnter);
				System.out.println("Actual Value    : " + actualValue);

				boolean status = actualValue.equals(finalValueToEnter);

				if (status) {
					System.out.println("[ENTER INPUT PASS] " + displayName);
				} else {
					System.out.println("[ENTER INPUT FAIL] " + displayName);
					captureFailure("ENTER INPUT VERIFY FAILED -> " + displayName + " | Expected: " + finalValueToEnter
							+ " | Actual: " + actualValue);
				}

				return status;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[ENTER INPUT STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("ENTER INPUT STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[ENTER INPUT FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("ENTER INPUT FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[ENTER INPUT FAILED AFTER RETRIES] " + elementName);
		captureFailure("ENTER INPUT FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	public boolean typeInInputField(WebElement inputField, String valueToEnter, String elementName) {
		return clearAndEnterValueIntoInputField(inputField, valueToEnter, elementName);
	}

	// ============================================================
	// ✅ CLEAR AND ENTER VALUE INTO INPUT FIELD
	// ============================================================

	public boolean clearAndEnterValueIntoInputField(WebElement inputField, String valueToEnter, String elementName) {
		try {
			boolean clearStatus = clearInputField(inputField, elementName);
			if (!clearStatus) {
				return false;
			}

			return enterValueIntoInputField(inputField, valueToEnter, elementName);

		} catch (Exception ex) {
			System.out.println("[CLEAR AND ENTER INPUT FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("CLEAR AND ENTER INPUT FAILED -> " + elementName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ VERIFY INPUT FIELD VALUE
	// ============================================================

	public boolean verifyInputFieldValue(WebElement inputField, String expectedValue, String elementName) {
		try {
			if (inputField == null) {
				throw new IllegalArgumentException("Input field is null");
			}

			String displayName = normalizeName(elementName, getElementDisplayName(inputField));
			String finalExpectedValue = expectedValue == null ? "" : expectedValue;

			waitForDocumentReady(displayName);
			scrollElementToCenter(inputField);

			WebElement visibleInputField = createWait(DEFAULT_WAITING_TIME_IN_SEC)
					.until(ExpectedConditions.visibilityOf(inputField));

			scrollElementToCenter(visibleInputField);

			String actualValue = visibleInputField.getAttribute("value");
			actualValue = actualValue == null ? "" : actualValue;

			System.out.println("[INPUT FIELD VALUE VERIFY]");
			System.out.println("Element Name    : " + displayName);
			System.out.println("Expected Value  : " + finalExpectedValue);
			System.out.println("Actual Value    : " + actualValue);

			boolean status = actualValue.equals(finalExpectedValue);

			if (status) {
				System.out.println("[INPUT FIELD VALUE PASS] " + displayName);
			} else {
				System.out.println("[INPUT FIELD VALUE FAIL] " + displayName);
				captureFailure("INPUT FIELD VALUE VERIFY FAILED -> " + displayName + " | Expected: "
						+ finalExpectedValue + " | Actual: " + actualValue);
			}

			return status;

		} catch (Exception ex) {
			System.out.println("[INPUT FIELD VALUE VERIFY FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("INPUT FIELD VALUE VERIFY FAILED -> " + elementName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ KEYBOARD HELPERS
	// ============================================================

	public boolean pressKeyInElement(WebElement element, Keys key, String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (element == null) {
					throw new IllegalArgumentException("Element is null");
				}
				if (key == null) {
					throw new IllegalArgumentException("Key is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(element));

				waitForDocumentReady(displayName);
				scrollElementToCenter(element);

				WebElement visibleElement = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(element));

				scrollElementToCenter(visibleElement);

				if (!visibleElement.isEnabled()) {
					throw new IllegalStateException("Element is disabled: " + displayName);
				}

				visibleElement.click();
				visibleElement.sendKeys(key);

				System.out.println("[PRESS KEY PASS] " + displayName + " | Key: " + key.name());
				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[PRESS KEY STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("PRESS KEY STALE -> " + elementName, sere);
				}
				sleepSilently(150);

			} catch (Exception ex) {
				System.out.println("[PRESS KEY FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("PRESS KEY FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[PRESS KEY FAILED AFTER RETRIES] " + elementName);
		captureFailure("PRESS KEY FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	// ============================================================
	// ✅ INTEGER TEXT HELPERS
	// ============================================================

	public int getIntegerFromElementText(WebElement element, String elementName) {
		try {
			String actualText = getTextFromElement(element, elementName);
			String numericValue = actualText.replaceAll("[^0-9-]", "").trim();

			System.out.println("[GET INTEGER FROM TEXT]");
			System.out.println("Element Name  : " + normalizeName(elementName, "ELEMENT"));
			System.out.println("Actual Text   : " + actualText);
			System.out.println("Numeric Text  : " + numericValue);

			if (numericValue.isEmpty()) {
				return 0;
			}

			return Integer.parseInt(numericValue);

		} catch (Exception ex) {
			System.out.println("[GET INTEGER FROM TEXT FAILED] " + elementName + " | " + ex.getMessage());
			captureFailure("GET INTEGER FROM TEXT FAILED -> " + elementName, ex);
			return 0;
		}
	}

	// ============================================================
	// ✅ UNIVERSAL INPUT FIELD HANDLER WITH RETRY
	// ============================================================

	public boolean handleInputField(WebElement inputField, String valueToEnter, String expectedPlaceholder,
			String elementName) {
		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				if (inputField == null) {
					throw new IllegalArgumentException("Input field is null");
				}

				String displayName = normalizeName(elementName, getElementDisplayName(inputField));
				String finalValueToEnter = valueToEnter == null ? "" : valueToEnter;
				String finalExpectedPlaceholder = expectedPlaceholder == null ? "" : safeTrim(expectedPlaceholder);

				System.out.println("============================================================");
				System.out.println("[UNIVERSAL INPUT FIELD HANDLER ATTEMPT " + attempt + "]");
				System.out.println("Element Name          : " + displayName);
				System.out.println("Expected Placeholder  : " + finalExpectedPlaceholder);
				System.out.println("Value To Enter        : " + finalValueToEnter);
				System.out.println("============================================================");

				waitForDocumentReady(displayName);
				scrollElementToCenter(inputField);

				WebElement visibleInputField = createWait(DEFAULT_WAITING_TIME_IN_SEC)
						.until(ExpectedConditions.visibilityOf(inputField));

				if (visibleInputField == null) {
					throw new NoSuchElementException("Input field is not visible: " + displayName);
				}

				scrollElementToCenter(visibleInputField);

				if (!visibleInputField.isEnabled()) {
					throw new IllegalStateException("Input field is disabled: " + displayName);
				}

				System.out.println("[INPUT FIELD STATE PASS] " + displayName + " is visible and enabled");

				if (!finalExpectedPlaceholder.isEmpty()) {
					String actualPlaceholder = safeTrim(visibleInputField.getAttribute("placeholder"));

					System.out.println("[PLACEHOLDER VERIFY]");
					System.out.println("Element Name          : " + displayName);
					System.out.println("Expected Placeholder  : " + finalExpectedPlaceholder);
					System.out.println("Actual Placeholder    : " + actualPlaceholder);

					if (!actualPlaceholder.equals(finalExpectedPlaceholder)) {
						System.out.println("[PLACEHOLDER VERIFY FAIL] " + displayName);
						captureFailure("PLACEHOLDER VERIFY FAILED -> " + displayName + " | Expected: "
								+ finalExpectedPlaceholder + " | Actual: " + actualPlaceholder);
						return false;
					}

					System.out.println("[PLACEHOLDER VERIFY PASS] " + displayName);
				} else {
					System.out.println("[PLACEHOLDER VERIFY SKIPPED] " + displayName);
				}

				visibleInputField.click();
				System.out.println("[INPUT CLICK PASS] " + displayName);

				boolean clearStatus = clearInputField(visibleInputField, displayName);
				if (!clearStatus) {
					System.out.println("[INPUT CLEAR FAIL] " + displayName);
					return false;
				}

				boolean enterStatus = enterValueIntoInputField(visibleInputField, finalValueToEnter, displayName);
				if (!enterStatus) {
					System.out.println("[INPUT ENTER FAIL] " + displayName);
					return false;
				}

				boolean verifyStatus = verifyInputFieldValue(visibleInputField, finalValueToEnter, displayName);
				if (!verifyStatus) {
					System.out.println("[INPUT FINAL VERIFY FAIL] " + displayName);
					return false;
				}

				System.out.println("============================================================");
				System.out.println("[UNIVERSAL INPUT FIELD HANDLER PASS] " + displayName);
				System.out.println("============================================================");

				return true;

			} catch (StaleElementReferenceException sere) {
				System.out.println("[UNIVERSAL INPUT FIELD HANDLER STALE] " + elementName + " | Retrying...");
				if (attempt > DEFAULT_RETRY_COUNT) {
					captureFailure("UNIVERSAL INPUT FIELD HANDLER STALE -> " + elementName, sere);
				}
				sleepSilently(150);
			} catch (Exception ex) {
				System.out.println("[UNIVERSAL INPUT FIELD HANDLER FAILED] " + elementName + " | " + ex.getMessage());
				captureFailure("UNIVERSAL INPUT FIELD HANDLER FAILED -> " + elementName, ex);
				return false;
			}
		}

		System.out.println("[UNIVERSAL INPUT FIELD HANDLER FAILED AFTER RETRIES] " + elementName);
		captureFailure("UNIVERSAL INPUT FIELD HANDLER FAILED AFTER RETRIES -> " + elementName);
		return false;
	}

	public boolean performActionsUsingActionsClass(String actionSequenceName, Object... steps) {

		String displaySequenceName = normalizeName(actionSequenceName, "ACTIONS SEQUENCE");

		System.out.println("======================================================================");
		System.out.println("[ACTIONS CLASS SEQUENCE START]");
		System.out.println("Action Sequence Name : " + displaySequenceName);
		System.out.println("======================================================================");

		if (steps == null || steps.length == 0) {
			System.out.println("[ACTIONS CLASS ERROR] No action steps were provided.");
			captureFailure("ACTIONS CLASS ERROR -> No action steps provided for: " + displaySequenceName);
			return false;
		}

		if (steps.length % 2 != 0) {
			System.out.println("[ACTIONS CLASS ERROR] Steps must be in action-value pairs.");
			captureFailure("ACTIONS CLASS ERROR -> Invalid action-value pair structure for: " + displaySequenceName);
			return false;
		}

		Exception lastException = null;

		for (int attempt = 1; attempt <= DEFAULT_RETRY_COUNT + 1; attempt++) {
			try {
				waitForDocumentReady(displaySequenceName);

				System.out.println("------------------------------------------------------------");
				System.out.println("[ACTIONS CLASS ATTEMPT] " + attempt + " / " + (DEFAULT_RETRY_COUNT + 1));
				System.out.println("------------------------------------------------------------");

				Actions actions = new Actions(driver);
				int stepNumber = 1;

				for (int i = 0; i < steps.length; i += 2) {
					if (!(steps[i] instanceof String)) {
						throw new IllegalArgumentException(
								"Invalid action type at position " + i + ". Action type must be String.");
					}

					String actionType = ((String) steps[i]).trim().toUpperCase();
					Object value = steps[i + 1];

					System.out.println("------------------------------------------------------------");
					System.out.println("[ACTIONS CLASS STEP START]");
					System.out.println("Step Number   : " + stepNumber);
					System.out.println("Action Type   : " + actionType);
					System.out.println("------------------------------------------------------------");

					switch (actionType) {

					case "MOVE":
					case "MOVETOELEMENT":
					case "HOVER": {
						if (!(value instanceof WebElement)) {
							throw new IllegalArgumentException("MOVE/HOVER requires a WebElement.");
						}

						WebElement visibleElement = waitUntilElementVisible((WebElement) value,
								DEFAULT_WAITING_TIME_IN_SEC, "ACTION MOVE STEP " + stepNumber);

						if (visibleElement == null) {
							return false;
						}

						actions.moveToElement(visibleElement);
						break;
					}

					case "CLICK": {
						if (!(value instanceof WebElement)) {
							throw new IllegalArgumentException("CLICK requires a WebElement.");
						}

						WebElement clickableElement = waitUntilElementClickable((WebElement) value,
								DEFAULT_WAITING_TIME_IN_SEC, "ACTION CLICK STEP " + stepNumber);

						if (clickableElement == null) {
							return false;
						}

						actions.moveToElement(clickableElement).click();
						break;
					}

					case "DOUBLECLICK": {
						if (!(value instanceof WebElement)) {
							throw new IllegalArgumentException("DOUBLECLICK requires a WebElement.");
						}

						WebElement clickableElement = waitUntilElementClickable((WebElement) value,
								DEFAULT_WAITING_TIME_IN_SEC, "ACTION DOUBLECLICK STEP " + stepNumber);

						if (clickableElement == null) {
							return false;
						}

						actions.moveToElement(clickableElement).doubleClick();
						break;
					}

					case "RIGHTCLICK":
					case "CONTEXTCLICK": {
						if (!(value instanceof WebElement)) {
							throw new IllegalArgumentException("RIGHTCLICK requires a WebElement.");
						}

						WebElement visibleElement = waitUntilElementVisible((WebElement) value,
								DEFAULT_WAITING_TIME_IN_SEC, "ACTION RIGHTCLICK STEP " + stepNumber);

						if (visibleElement == null) {
							return false;
						}

						actions.moveToElement(visibleElement).contextClick();
						break;
					}

					case "CLICKANDHOLD": {
						if (!(value instanceof WebElement)) {
							throw new IllegalArgumentException("CLICKANDHOLD requires a WebElement.");
						}

						WebElement visibleElement = waitUntilElementVisible((WebElement) value,
								DEFAULT_WAITING_TIME_IN_SEC, "ACTION CLICKANDHOLD STEP " + stepNumber);

						if (visibleElement == null) {
							return false;
						}

						actions.moveToElement(visibleElement).clickAndHold();
						break;
					}

					case "RELEASE": {
						if (value == null) {
							actions.release();
						} else if (value instanceof WebElement) {
							WebElement visibleElement = waitUntilElementVisible((WebElement) value,
									DEFAULT_WAITING_TIME_IN_SEC, "ACTION RELEASE STEP " + stepNumber);

							if (visibleElement == null) {
								return false;
							}

							actions.moveToElement(visibleElement).release();
						} else {
							throw new IllegalArgumentException("RELEASE requires null or WebElement.");
						}
						break;
					}

					case "SENDKEYS": {
						if (!(value instanceof CharSequence)) {
							throw new IllegalArgumentException("SENDKEYS requires text.");
						}
						actions.sendKeys((CharSequence) value);
						break;
					}

					case "KEYDOWN": {
						if (!(value instanceof Keys)) {
							throw new IllegalArgumentException("KEYDOWN requires a Keys value.");
						}
						actions.keyDown((Keys) value);
						break;
					}

					case "KEYUP": {
						if (!(value instanceof Keys)) {
							throw new IllegalArgumentException("KEYUP requires a Keys value.");
						}
						actions.keyUp((Keys) value);
						break;
					}

					case "PAUSE": {
						if (!(value instanceof Number)) {
							throw new IllegalArgumentException("PAUSE requires milliseconds as number.");
						}

						long pauseMillis = ((Number) value).longValue();

						if (pauseMillis < 0) {
							throw new IllegalArgumentException("Pause duration cannot be negative.");
						}

						actions.pause(Duration.ofMillis(pauseMillis));
						break;
					}

					case "MOVEBYOFFSET": {
						if (!(value instanceof int[]) || ((int[]) value).length < 2) {
							throw new IllegalArgumentException("MOVEBYOFFSET requires int[] {xOffset, yOffset}.");
						}

						int[] offsets = (int[]) value;
						actions.moveByOffset(offsets[0], offsets[1]);
						break;
					}

					case "DRAGANDDROP": {
						if (!(value instanceof WebElement[]) || ((WebElement[]) value).length < 2) {
							throw new IllegalArgumentException("DRAGANDDROP requires WebElement[] {source, target}.");
						}

						WebElement[] dragElements = (WebElement[]) value;

						WebElement sourceElement = waitUntilElementVisible(dragElements[0], DEFAULT_WAITING_TIME_IN_SEC,
								"ACTION DRAG SOURCE STEP " + stepNumber);
						WebElement targetElement = waitUntilElementVisible(dragElements[1], DEFAULT_WAITING_TIME_IN_SEC,
								"ACTION DRAG TARGET STEP " + stepNumber);

						if (sourceElement == null || targetElement == null) {
							return false;
						}

						actions.dragAndDrop(sourceElement, targetElement);
						break;
					}

					default:
						throw new UnsupportedOperationException("Unsupported action type: " + actionType);
					}

					System.out.println("[ACTIONS CLASS STEP SUCCESS] Step " + stepNumber + " -> " + actionType);
					stepNumber++;
				}

				actions.build().perform();

				System.out.println("======================================================================");
				System.out.println("[ACTIONS CLASS SEQUENCE PASS]");
				System.out.println("Action Sequence Name : " + displaySequenceName);
				System.out.println("======================================================================");

				return true;

			} catch (StaleElementReferenceException sere) {
				lastException = sere;
				System.out.println("[ACTIONS CLASS STALE] " + displaySequenceName + " | Retrying...");
				sleepSilently(150);

			} catch (TimeoutException te) {
				lastException = te;
				System.out.println("[ACTIONS CLASS TIMEOUT] " + displaySequenceName + " | " + te.getMessage());
				sleepSilently(150);

			} catch (Exception ex) {
				lastException = ex;
				System.out.println("[ACTIONS CLASS FAILED] " + displaySequenceName + " | " + ex.getMessage());
				sleepSilently(150);
			}
		}

		System.out.println("[ACTIONS CLASS FAILED AFTER RETRIES] " + displaySequenceName);
		captureFailure("ACTIONS CLASS FAILED AFTER RETRIES -> " + displaySequenceName,
				lastException instanceof Exception ? (Exception) lastException : new Exception("Unknown exception"));
		return false;
	}
}