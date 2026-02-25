package generic;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {
	// function to verify the title of the page.
	public static boolean verifyTitleOfWebpage(WebDriver driver, String expectedTitle) {
		boolean titleVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			titleVerified = true;
			System.out.println("Title verification passed , expected title was : " + expectedTitle + " Found : "
					+ driver.getTitle());
		} catch (Exception ex) {
			System.out.println("Title not matching " + expectedTitle + " Found : " + driver.getTitle());
		}
		return titleVerified;
	}

	public static boolean verifyUrlOfWebpage(WebDriver driver, String expectedUrl) {
		boolean urlVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.urlMatches(expectedUrl));
			urlVerified = true;
			System.out.println("Url matching " + expectedUrl + " Found : " + driver.getCurrentUrl());
		} catch (Exception ex) {
			System.out.println("Url not matching " + expectedUrl + " Found : " + driver.getCurrentUrl());
		}
		return urlVerified;
	}

	// function to verify if the text is persent, but case sensitive, will show
	// error if case dont match
//	public static boolean verifyTextPresent(WebDriver driver, String expectedText, WebElement element) {
//		boolean textVerified = false;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		try {
//			wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
//			textVerified = true;
//			if (textVerified == true) {
//				System.out.println("Text is matching " + expectedText + " Found : " + element.getText());
//			}
//		} catch (Exception ex) {
//			System.out.println("Text not matching " + expectedText + " Found : " + element.getText());
//		}
//		return textVerified;
//	}

	// function to verify text is present or not.
	public static boolean verifyTextPresent(WebDriver driver, String expectedText, WebElement element) {
		boolean textVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			textVerified = true;
			System.out.println(
					"Text verification passed : expected text was " + expectedText + " found " + element.getText());
		} catch (Exception ex) {
			System.out.println(
					"Text verification failed : expected text was " + expectedText + " found " + element.getText());
			ex.printStackTrace();
		}

		return textVerified;
	}

	// function to check if text exists, irrespective of uppercase or lowercase
	public static boolean verifyTextPresentIgnoreCase(WebDriver driver, String expectedText, WebElement element) {
		boolean textVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(element));

			String actualText = element.getText().trim();

			// ✅ Ignore case comparison
			if (actualText.equalsIgnoreCase(expectedText.trim())) {
				textVerified = true;
				System.out.println("Text is matching (Ignore Case): " + expectedText + " Found: " + actualText);
			} else {
				System.out.println("Text not matching (Ignore Case): " + expectedText + " Found: " + actualText);
			}
		} catch (Exception ex) {
			System.out.println("Element not found or text not matching: " + expectedText);
		}

		return textVerified;
	}

	// function to verify any type of text with numbers anywhere in the text.
	public static boolean verifyTextPresentWithNumbers(WebDriver driver, String expectedPattern, WebElement element) {
		boolean textVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			String actualText = element.getText().trim();
			// ✅ Match pattern (numbers can appear anywhere)
			if (actualText.matches(expectedPattern)) {
				textVerified = true;
				System.out.println("Text is matching (With Numbers): " + actualText);
			} else {
				System.out.println("Text not matching (With Numbers). Expected Pattern: " + expectedPattern + " Found: "
						+ actualText);
			}
		} catch (Exception ex) {
			System.out.println("Element not found or pattern not matched.");
		}

		return textVerified;
	}

	/*
	 * ✅ How to Use This Function Example 1: "117 products"
	 * verifyTextPresentWithNumbers(driver, "\\d+ products", element);
	 * 
	 * Example 2: "Showing 10 of 30 products" verifyTextPresentWithNumbers(driver,
	 * "Showing \\d+ of \\d+ products", element);
	 * 
	 * Example 3: "Total Product 75" verifyTextPresentWithNumbers(driver,
	 * "Total Product \\d+", element);
	 */

	// text not present function.
	public static boolean verifyTextNotPresent(WebDriver driver, String expectedText, By locator) {
		boolean textNotPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// ✅ Wait until element disappears from DOM
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			textNotPresent = true;
			System.out.println("Text removed successfully. Not Found: " + expectedText);
		} catch (Exception ex) {
			System.out.println("Text is still present. Found : " + expectedText);
		}

		return textNotPresent;
	}

	// text not to be present in the nested element / elements
	public static boolean verifyTextNotPresentInNestedElements(WebDriver driver, By containerOrElementLocator,
			String expectedText) throws Exception {
		boolean textNotPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			String exp = expectedText == null ? "" : expectedText.trim();

			// ✅ Wait until:
			// 1) element not found OR
			// 2) element found but not displayed OR
			// 3) element found but text does NOT contain expectedText
			boolean ok = wait.until((ExpectedCondition<Boolean>) d -> {
				try {
					List<WebElement> els = d.findElements(containerOrElementLocator);

					// ✅ If element is not in DOM at all => PASS
					if (els == null || els.isEmpty())
						return true;

					WebElement el = els.get(0);

					// ✅ If element exists but not visible => PASS
					if (!el.isDisplayed())
						return true;

					// ✅ If visible, check text from the container (includes nested text)
					String actual = (el.getText() == null) ? "" : el.getText().trim();

					// ✅ Text NOT present => PASS
					return !actual.contains(exp);
				} catch (StaleElementReferenceException sere) {
					// DOM updated; re-try in next poll
					return false;
				} catch (NoSuchElementException nse) {
					// not found => PASS
					return true;
				} catch (Exception e) {
					// Any other transient render issue -> retry
					return false;
				}
			});

			if (ok) {
				textNotPresent = true;
				System.out
						.println("Text NOT present now: " + expectedText + " | Locator: " + containerOrElementLocator);
			}
		} catch (Exception te) {
			System.out.println(
					"Text still present after wait: " + expectedText + " | Locator: " + containerOrElementLocator);
		}
		return textNotPresent;
	}

	// function to click on the element if its clickable
	public static boolean clickOnElementIfClickable(WebDriver driver, WebElement element) {
		boolean elementClicked = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			elementClicked = true;
			System.out.println("Element clicked successfully : " + element);

		} catch (Exception ex) {
			System.out.println("Element is not clickable or Visible : " + element);
			ex.printStackTrace();
		}
		return elementClicked;
	}

	// function to click on the element if the element is first visible, and then if
	// its enabled.
	public static boolean clickOnElementIfVisibleAndEnabled(WebDriver driver, WebElement element) {
		boolean elementClicked = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// ✅ Step 1: Wait until element is visible
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element is visible.");

			// ✅ Step 2: Check if element is enabled
			if (element.isEnabled()) {
				System.out.println("Element is enabled.");
				// ✅ Step 3: Click the element
				element.click();
				elementClicked = true;
				System.out.println("Element clicked successfully.");
			} else {
				System.out.println("Element is visible but NOT enabled, cannot click.");
			}
		} catch (Exception ex) {
			System.out.println("Element is NOT visible within wait time, cannot click.");
			ex.printStackTrace();
		}

		return elementClicked;
	}

	// function to handle alert and accept the alert
	public static boolean handleAlertIfAlertIsPresentAndAccept(WebDriver driver) {
		boolean alertHandledAndAccepted = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is : " + alert.getText());
			alert.accept();
			alertHandledAndAccepted = true;
			System.out.println("Alert is handeled successfully, navigating to next page.");
		} catch (Exception ex) {
			System.out.println("Unable to handle the alert.");
			ex.printStackTrace();
		}
		return alertHandledAndAccepted;
	}

	// function to handle alert dismiss/ cancel the alert
	public static boolean handleAlertIfAlertIsPresentAndDismiss(WebDriver driver) {
		boolean alertHandledAndRejected = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is : " + alert.getText());
			alert.dismiss();
			alertHandledAndRejected = true;
			System.out.println("Alert is handeled successfully, navigating to next page.");
		} catch (Exception ex) {
			System.out.println("Unable to handle the alert.");
			ex.printStackTrace();
		}
		return alertHandledAndRejected;
	}

	// function to verify total element count in any element (using lambda function)
//	public static boolean verifyTotalElementsCount(WebDriver driver, By locator, int expectedCount) {
//		boolean countVerified = false;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		try {
//			// ✅ Wait until element count becomes expected count
//			wait.until(driver1 -> driver1.findElements(locator).size() == expectedCount);
//
//			int actualCount = driver.findElements(locator).size();
//
//			if (actualCount == expectedCount) {
//				countVerified = true;
//				System.out.println("Count is matching. Expected: " + expectedCount + " Found: " + actualCount);
//			}
//		} catch (Exception ex) {
//			int actualCount = driver.findElements(locator).size();
//			System.out.println("Count not matching. Expected: " + expectedCount + " Found: " + actualCount);
//		}
//
//		return countVerified;
//	}

//	public static boolean verifyTotalElementsCount(WebDriver driver, int expectedCount, By locator) {
//		boolean totalCountVerified = false;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		int actualCount = 0;
//		try {
//			wait.until(driver1 -> driver1.findElements(locator).size() == expectedCount); // lambda function
//			actualCount = driver.findElements(locator).size();
//
//			List<WebElement> allBrandNames = driver.findElements(By
//					.cssSelector("div.flex.items-center.w-max:first-child>button>div>div:last-child>span:first-child"));
//			int actualNameCount = allBrandNames.size();
//
//			for (int i = 0; i < actualNameCount; i++) {
//				String eachBrandNameText = allBrandNames.get(i).getText();
//				System.out.println(eachBrandNameText);
//				Thread.sleep(100);
//			}
//
//			System.out.println(
//					"Count matching - expected count : " + expectedCount + " Found actual count is : " + actualCount);
//		} catch (Exception ex) {
//			System.out.println(
//					"Count Not matching expected count : " + expectedCount + " Found actual count as : " + actualCount);
//			ex.printStackTrace();
//		}
//		return totalCountVerified;
//	}

	// usage : verifyTotalElementsCount(driver, By.cssSelector(".wishlist-card"),
	// 0));
	// int before = getTotalElementsCount(driver, By.cssSelector(".wishlist-card"));
	// removeButton.click();
	// verifyTotalElementsCount(driver, By.cssSelector(".wishlist-card"), before
	// -1));

	public static boolean verifyTotalElementsCount1(WebDriver driver, int expectedCount, By locator) {
		boolean totalCountVerified = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int actualCount = 0;

		try {
			// ✅ wait until the expected count is present in DOM
			wait.until(d -> d.findElements(locator).size() == expectedCount);

			List<WebElement> brandButtons = driver.findElements(locator);
			actualCount = brandButtons.size();

			// ✅ Print ALL brand names (visibility independent)
			// We read from the button's title attribute (title={brand} in React)
			java.util.Set<String> uniqueBrands = new java.util.LinkedHashSet<>();

			for (WebElement btn : brandButtons) {
				String brand = btn.getAttribute("title"); // ✅ works even if off-screen
				if (brand != null) {
					brand = brand.trim();
					if (!brand.isEmpty())
						uniqueBrands.add(brand);
				}
			}

			// ✅ If your locator accidentally doesn't include [title], fall back to spans
			// using textContent
			// (textContent is more reliable than getText for animated/overflow content)
			if (uniqueBrands.isEmpty()) {
				List<WebElement> nameSpans = driver.findElements(By.cssSelector(
						"div.flex.items-center.w-max:first-child>button[title]>div>div:last-child>span:first-child"));
				for (WebElement s : nameSpans) {
					String t = s.getAttribute("textContent");
					if (t != null) {
						t = t.trim();
						if (!t.isEmpty())
							uniqueBrands.add(t);
					}
				}
			}

			// ✅ Print
			int count = 0;
			for (String b : uniqueBrands) {
				System.out.println(count + 1 + " Brand Name : " + b);
				count++;
				Thread.sleep(50);
			}

			System.out.println("Count matching - expected count : " + expectedCount + " Found actual count is : "
					+ actualCount + " | Unique names printed: " + uniqueBrands.size());

			// ✅ mark verified
			totalCountVerified = (actualCount == expectedCount);

		} catch (Exception ex) {
			System.out.println(
					"Count Not matching expected count : " + expectedCount + " Found actual count as : " + actualCount);
			ex.printStackTrace();
		}

		return totalCountVerified;
	}

	// simpler version.
	public static boolean verifyTotalElementsCount(WebDriver driver, int expectedCount, By locator) {
		boolean totalCountVerified = false;
		int actualCount = 0;

		try {
			// 1) Wait until expected number of elements are present (simple loop)
			for (int i = 0; i < 50; i++) {

				actualCount = driver.findElements(locator).size();

				if (actualCount == expectedCount) {
					break;
				}
				Thread.sleep(200);
			}

			// 4) Print summary + return result
			System.out.println(
					"Count Verification passed, Expected count: " + expectedCount + " | Actual count: " + actualCount);

			totalCountVerified = (actualCount == expectedCount);

		} catch (Exception ex) {
			System.out.println("Count verification failed. Expected: " + expectedCount + " | Actual: " + actualCount);
			ex.printStackTrace();
		}

		return totalCountVerified;
	}

	public static boolean printAllBrandNamesInHomepage(WebDriver driver, int expectedCount, By locator) {
		boolean totalCountVerified = false;
		int actualCount = 0;

		try {
			// 1) Wait until expected number of elements are present (simple loop)
			for (int i = 0; i < 50; i++) {

				actualCount = driver.findElements(locator).size();

				if (actualCount == expectedCount) {
					break;
				}
				Thread.sleep(200);
			}

			// 2) Get all brand buttons
			List<WebElement> brandButtons = driver.findElements(locator);
			actualCount = brandButtons.size();

			// 3) Print all brand names (from title attribute)
			Set<String> uniqueBrands = new LinkedHashSet<>();

			for (WebElement btn : brandButtons) {
				String brand = btn.getAttribute("title"); // ✅ does not depend on visibility
				if (brand != null && !brand.trim().isEmpty()) {
					uniqueBrands.add(brand.trim());
				}
			}

			int count = 0;
			for (String b : uniqueBrands) {
				System.out.println(count + 1 + " Brand Name : " + b);
				count++;
				Thread.sleep(50);
			}

			// 4) Print summary + return result
			System.out.println("Expected count: " + expectedCount + " | Actual count: " + actualCount
					+ " | Unique names printed: " + uniqueBrands.size());

			totalCountVerified = (actualCount == expectedCount);

		} catch (Exception ex) {
			System.out.println("Count verification failed. Expected: " + expectedCount + " | Actual: " + actualCount);
			ex.printStackTrace();
		}

		return totalCountVerified;
	}

}
