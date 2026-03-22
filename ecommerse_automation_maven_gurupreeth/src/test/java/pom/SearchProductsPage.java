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

	// one single main drop down heading
	@FindBy(css = "aside.hidden div.w-full div.space-y-1>div>div.flex>span.cursor-pointer.text-orange-600")
	private WebElement singleHighlightedMainDropDownName;

	// All top-level category drop down names in the left category filter (all
	// dropdowns)
	// Example: ELECTRONICS, TOYS
	@FindBy(css = "aside.hidden div.w-full div.space-y-1 > div > div.flex.items-center.justify-between > span:first-child")
	private List<WebElement> allCategoryMainDropdownItemNames;

	// All expanded sub-category options of the currently expanded category
	// Example inside ELECTRONICS: HEADPHONES, LAPTOPS, MOBILE PHONES, SMART WATCH
	@FindBy(css = "aside.hidden div.w-full div.space-y-1>div>div.pl-4.mt-1.space-y-1>div")
	private List<WebElement> allExpandedCategoryOptions;

	@FindBy(css = "div.grid-cols-2 div.mt-3>p:first-child")
	private List<WebElement> allProductsInSingleCategory;

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
	// ✅ PRODUCTS VERIFICATION
	// ============================================================

	public List<WebElement> fetchAllProductsOfACategory(String categoryName) {
		return printTextOfAllElements(allProductsInSingleCategory, "[All Products In Category] " + categoryName);
	}

	// ============================================================
	// ✅ CATEGORY DROPDOWN MAIN HEADER METHODS
	// ============================================================

	public boolean verifyCategoryDropdownIsDisplayed() {
		return verifyElementPresentAndVisible(categoryDropdownContainer, "Search Products Category Dropdown");
	}

	// Prints top-level category drop down headings names only.
	// Example: ELECTRONICS, TOYS
	public List<WebElement> fetchAndPrintAllCategoryDropdownOptions() {
		return fetchAndPrintAllDropdownOptions(categoryDropdownContainer, allCategoryMainDropdownItemNames,
				"Search Products Main Category Dropdown");
	}

	public boolean verifyCategoryExistsInDropdown(String expectedCategoryName) {
		return verifyOptionExistsInDropdown(categoryDropdownContainer, allCategoryMainDropdownItemNames,
				expectedCategoryName, "Search Products Main Category Dropdown");
	}

	// singleHighlightedMainDropDownName
	public boolean verifySelectedCategoryHighlightedInDropdown(String expectedCategoryName) {
		try {
			expectedCategoryName = expectedCategoryName == null ? "" : expectedCategoryName.trim();

			if (expectedCategoryName.isEmpty()) {
				throw new IllegalArgumentException("Expected category name is null or empty");
			}

			if (!verifyDropdownPresentAndVisible(categoryDropdownContainer, "Search Products Main Category Dropdown")) {
				return false;
			}

			if (!verifyDropdownHasOptions(allCategoryMainDropdownItemNames, "Search Products Main Category Dropdown")) {
				return false;
			}

			System.out.println("[CATEGORY DROPDOWN VERIFY]");
			System.out.println("Expected Selected Category : " + expectedCategoryName);
			System.out.println("Total Dropdown Categories  : " + allCategoryMainDropdownItemNames.size());

			// ============================================================
			// 1. Verify highlighted main dropdown category element is present
			// ============================================================
			if (singleHighlightedMainDropDownName == null) {
				System.out.println("[CATEGORY FAIL] Highlighted category element is null");
				captureFailure("HIGHLIGHTED CATEGORY ELEMENT IS NULL");
				return false;
			}

			String highlightedCategoryText = "";
			String highlightedCategoryClass = "";

			try {
				highlightedCategoryText = singleHighlightedMainDropDownName.getText() == null ? ""
						: singleHighlightedMainDropDownName.getText().trim();

				highlightedCategoryClass = singleHighlightedMainDropDownName.getAttribute("class") == null ? ""
						: singleHighlightedMainDropDownName.getAttribute("class").trim();

				System.out.println("[HIGHLIGHTED CATEGORY] Text: " + highlightedCategoryText + " | Class: "
						+ highlightedCategoryClass);

			} catch (Exception ex) {
				System.out.println("[CATEGORY FAIL] Unable to read highlighted category element");
				captureFailure("UNABLE TO READ HIGHLIGHTED CATEGORY ELEMENT", ex);
				return false;
			}

			// ============================================================
			// 2. Verify the highlighted category text matches expected
			// ============================================================
			if (!highlightedCategoryText.equalsIgnoreCase(expectedCategoryName)) {
				System.out.println("[CATEGORY FAIL] Highlighted category mismatch");
				System.out.println("Expected : " + expectedCategoryName);
				System.out.println("Actual   : " + highlightedCategoryText);
				captureFailure("HIGHLIGHTED CATEGORY TEXT MISMATCH -> expected=" + expectedCategoryName + " actual="
						+ highlightedCategoryText);
				return false;
			}

			// ============================================================
			// 3. Verify highlighted category really contains orange class
			// ============================================================
			if (!highlightedCategoryClass.contains("text-orange-600")) {
				System.out.println(
						"[CATEGORY FAIL] Highlighted category does not contain orange class: " + expectedCategoryName);
				captureFailure("HIGHLIGHTED CATEGORY DOES NOT HAVE ORANGE CLASS -> " + expectedCategoryName);
				return false;
			}

			// ============================================================
			// 4. Verify expected category exists in all main dropdown names
			// ============================================================
			int matchedCountInAllDropdowns = 0;

			for (int i = 0; i < allCategoryMainDropdownItemNames.size(); i++) {
				WebElement categoryElement = allCategoryMainDropdownItemNames.get(i);

				try {
					String actualText = categoryElement.getText() == null ? "" : categoryElement.getText().trim();
					String classValue = categoryElement.getAttribute("class") == null ? ""
							: categoryElement.getAttribute("class").trim();

					System.out.println(
							"[CATEGORY ITEM] Index: " + (i + 1) + " | Text: " + actualText + " | Class: " + classValue);

					if (actualText.equalsIgnoreCase(expectedCategoryName)) {
						matchedCountInAllDropdowns++;
					}

				} catch (Exception innerEx) {
					System.out.println("[CATEGORY ITEM READ FAILED] Index: " + (i + 1));
				}
			}

			if (matchedCountInAllDropdowns == 0) {
				System.out.println(
						"[CATEGORY FAIL] Expected category not found in main dropdown list: " + expectedCategoryName);
				captureFailure("CATEGORY NOT FOUND IN MAIN DROPDOWN LIST -> " + expectedCategoryName);
				return false;
			}

			if (matchedCountInAllDropdowns > 1) {
				System.out.println("[CATEGORY FAIL] Duplicate category names found in main dropdown list. Count: "
						+ matchedCountInAllDropdowns + " | Category: " + expectedCategoryName);
				captureFailure("DUPLICATE CATEGORY NAMES FOUND -> " + expectedCategoryName + " | Count="
						+ matchedCountInAllDropdowns);
				return false;
			}

			// ============================================================
			// 5. Verify expanded options are present for selected category
			// ============================================================
			if (!verifyDropdownHasOptions(allExpandedCategoryOptions,
					"Expanded Sub Category Options Under Selected Category")) {
				return false;
			}

			System.out.println("[EXPANDED OPTIONS COUNT] " + allExpandedCategoryOptions.size());

			for (int i = 0; i < allExpandedCategoryOptions.size(); i++) {
				try {
					String optionText = allExpandedCategoryOptions.get(i).getText() == null ? ""
							: allExpandedCategoryOptions.get(i).getText().trim();

					System.out.println("[EXPANDED OPTION] Index: " + (i + 1) + " | Text: " + optionText);
				} catch (Exception innerEx) {
					System.out.println("[EXPANDED OPTION READ FAILED] Index: " + (i + 1));
				}
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
	// ✅ EXPANDED CATEGORY INNER OPTIONS METHODS
	// ============================================================

	// Prints inner options inside currently expanded category
	// Example inside ELECTRONICS: HEADPHONES, LAPTOPS, MOBILE PHONES, SMART WATCH
	public List<WebElement> fetchAndPrintAllExpandedCategoryOptions() {
		return fetchAndPrintAllDropdownOptions(categoryDropdownContainer, allExpandedCategoryOptions,
				"Expanded Category Inner Options");
	}

	public boolean verifyExpandedCategoryOptionExists(String expectedOptionName) {
		return verifyOptionExistsInDropdown(categoryDropdownContainer, allExpandedCategoryOptions, expectedOptionName,
				"Expanded Category Inner Options");
	}
}