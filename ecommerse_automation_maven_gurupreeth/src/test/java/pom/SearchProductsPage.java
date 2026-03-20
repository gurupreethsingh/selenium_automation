package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SearchProductsPage extends AllVerifications {

	@FindBy(css = "div.min-w-0>div.flex.items-center.gap-2>h1")
	private WebElement mainBrandHeading;

	// ============================================================
	// ✅ CATEGORY DROPDOWN / FILTER SECTION
	// ============================================================

	// Entire category filter block
	@FindBy(css = "aside.hidden div.w-full div.space-y-1")
	private WebElement categoryDropdownContainer;

	// All top-level category names in the left category filter
	@FindBy(css = "aside.hidden div.w-full div.space-y-1 > div > div.flex.items-center.justify-between > span")
	private List<WebElement> allCategoryDropdownItems;

	public SearchProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ MAIN HEADING VERIFICATION
	// ============================================================

	public boolean verifyMainHeadingTextContainsBrandName(String brandName) {
		String expectedText = "Results for \"" + brandName + "\"";
		return verifyText(mainBrandHeading, expectedText, "Main Brand Heading", "contains", false);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifySearchProductsPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySearchProductsPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ VERIFY CATEGORY DROPDOWN IS DISPLAYED
	// ============================================================

	public boolean verifyCategoryDropdownIsDisplayed() {
		return verifyElementPresentAndVisible(categoryDropdownContainer, "Search Products Category Dropdown");
	}

	// ============================================================
	// ✅ COMPLETE DROPDOWN VALIDATION
	// Verifies:
	// 1. dropdown visible
	// 2. expected category exists
	// 3. expected category is orange (selected)
	// 4. all other categories are NOT orange
	// 5. only one category is selected
	// ============================================================

	public boolean verifySelectedCategoryHighlightedInDropdown(String expectedCategoryName) {
		try {
			expectedCategoryName = expectedCategoryName == null ? "" : expectedCategoryName.trim();

			if (expectedCategoryName.isEmpty()) {
				throw new IllegalArgumentException("Expected category name is null or empty");
			}

			if (!verifyElementPresentAndVisible(categoryDropdownContainer, "Search Products Category Dropdown")) {
				return false;
			}

			if (allCategoryDropdownItems == null || allCategoryDropdownItems.isEmpty()) {
				System.out.println("[CATEGORY DROPDOWN FAIL] No category items found in dropdown");
				captureFailure("CATEGORY DROPDOWN FAIL -> No category items found");
				return false;
			}

			System.out.println("[CATEGORY DROPDOWN VERIFY]");
			System.out.println("Expected Selected Category : " + expectedCategoryName);
			System.out.println("Total Dropdown Categories  : " + allCategoryDropdownItems.size());

			WebElement matchedCategoryElement = null;
			int orangeSelectedCount = 0;

			for (int i = 0; i < allCategoryDropdownItems.size(); i++) {
				WebElement categoryElement = allCategoryDropdownItems.get(i);

				String actualText = "";
				String classValue = "";

				try {
					actualText = categoryElement.getText() == null ? "" : categoryElement.getText().trim();
					classValue = categoryElement.getAttribute("class") == null ? ""
							: categoryElement.getAttribute("class").trim();

					System.out.println(
							"[CATEGORY ITEM] Index: " + (i + 1) + " | Text: " + actualText + " | Class: " + classValue);

					boolean isOrange = classValue.contains("text-orange-600");

					if (isOrange) {
						orangeSelectedCount++;
					}

					if (actualText.equalsIgnoreCase(expectedCategoryName)) {
						matchedCategoryElement = categoryElement;

						if (!isOrange) {
							System.out.println("[CATEGORY FAIL] Expected category found but NOT highlighted in orange: "
									+ expectedCategoryName);
							captureFailure("CATEGORY NOT HIGHLIGHTED ORANGE -> " + expectedCategoryName);
							return false;
						}
					}

				} catch (Exception innerEx) {
					System.out.println("[CATEGORY ITEM READ FAILED] Index: " + (i + 1));
				}
			}

			if (matchedCategoryElement == null) {
				System.out.println("[CATEGORY FAIL] Expected category not found in dropdown: " + expectedCategoryName);
				captureFailure("CATEGORY NOT FOUND IN DROPDOWN -> " + expectedCategoryName);
				return false;
			}

			if (orangeSelectedCount != 1) {
				System.out.println("[CATEGORY FAIL] More than one / no orange selected category found. Count: "
						+ orangeSelectedCount);
				captureFailure("INVALID ORANGE SELECTION COUNT -> expected=1 actual=" + orangeSelectedCount);
				return false;
			}

			System.out.println(
					"[CATEGORY PASS] Selected category correctly highlighted in orange: " + expectedCategoryName);
			return true;

		} catch (Exception ex) {
			System.out.println("[CATEGORY DROPDOWN VERIFY FAILED] " + expectedCategoryName);
			captureFailure("CATEGORY DROPDOWN VERIFY FAILED -> " + expectedCategoryName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ OPTIONAL: ONLY CHECK WHETHER CATEGORY EXISTS IN DROPDOWN
	// ============================================================

	public boolean verifyCategoryExistsInDropdown(String expectedCategoryName) {
		try {
			expectedCategoryName = expectedCategoryName == null ? "" : expectedCategoryName.trim();

			if (expectedCategoryName.isEmpty()) {
				throw new IllegalArgumentException("Expected category name is null or empty");
			}

			if (!verifyElementPresentAndVisible(categoryDropdownContainer, "Search Products Category Dropdown")) {
				return false;
			}

			for (WebElement categoryElement : allCategoryDropdownItems) {
				String actualText = categoryElement.getText() == null ? "" : categoryElement.getText().trim();

				if (actualText.equalsIgnoreCase(expectedCategoryName)) {
					System.out.println("[CATEGORY EXISTS PASS] " + expectedCategoryName);
					return true;
				}
			}

			System.out.println("[CATEGORY EXISTS FAIL] " + expectedCategoryName);
			captureFailure("CATEGORY DOES NOT EXIST IN DROPDOWN -> " + expectedCategoryName);
			return false;

		} catch (Exception ex) {
			System.out.println("[CATEGORY EXISTS VERIFY FAILED] " + expectedCategoryName);
			captureFailure("CATEGORY EXISTS VERIFY FAILED -> " + expectedCategoryName, ex);
			return false;
		}
	}
}