package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_5418_VerifyCategoryHighlightedInSPPAllCatClicked1By1InHp extends OpenClose {

	@Test
	public void testVerifyCategoryHighlightedInSearchProductsForAllCategories() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		for (int row = 6; row <= 15; row++) {

			System.out.println("============================================================");
			System.out.println("[TEST STARTED FOR CATEGORY ROW] " + row);
			System.out.println("============================================================");

			// Re-open homepage fresh for every category
			driver.get("http://localhost:5173/");

			HomePage hp = new HomePage(driver);

			// STEP 1: VERIFY HOMEPAGE TITLE
			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed at row: " + row);

			// STEP 2: READ CATEGORY NAME FROM EXCEL
			String categoryName = (String) Excel.getData("HomePage", row, 2);

			System.out.println("[CATEGORY FROM EXCEL] Row: " + row + " | Category: " + categoryName);

			// STEP 3: CLICK CATEGORY FROM HOMEPAGE
			softAssert.assertTrue(hp.clickAllCategoriesByName(categoryName),
					"Failed to click category from homepage: " + categoryName + " at row: " + row);

			// STEP 4: CREATE SEARCH PRODUCTS PAGE OBJECT
			SearchProductsPage spp = new SearchProductsPage(driver);

			// STEP 5: VERIFY SEARCH PRODUCTS PAGE TITLE
			softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
					"Search products page title verification failed for category: " + categoryName + " at row: " + row);

			// STEP 6: VERIFY SEARCH PRODUCTS PAGE URL
			String expectedUrl = "http://localhost:5173/search-products?query=" + categoryName;
			softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedUrl),
					"Search products page URL verification failed for category: " + categoryName + " at row: " + row);

			// STEP 7: VERIFY SEARCH PRODUCTS MAIN HEADING
			softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
					"Search products main heading verification failed for category: " + categoryName + " at row: "
							+ row);

			// STEP 8: VERIFY CATEGORY DROPDOWN IS DISPLAYED
			softAssert.assertTrue(spp.verifyCategoryDropdownIsDisplayed(),
					"Category dropdown is not displayed for category: " + categoryName + " at row: " + row);

			// STEP 9: PRINT ALL MAIN CATEGORY DROPDOWN OPTIONS
			spp.fetchAndPrintAllCategoryDropdownOptions();

			// STEP 10: VERIFY CATEGORY EXISTS IN MAIN CATEGORY DROPDOWN
			softAssert.assertTrue(spp.verifyCategoryExistsInDropdown(categoryName),
					"Expected category does not exist in dropdown: " + categoryName + " at row: " + row);

			// STEP 11: VERIFY SELECTED CATEGORY IS HIGHLIGHTED IN ORANGE
			softAssert.assertTrue(spp.verifySelectedCategoryHighlightedInDropdown(categoryName),
					"Selected category is NOT highlighted in orange in dropdown: " + categoryName + " at row: " + row);

			// STEP 12: PRINT ALL EXPANDED SUBCATEGORY OPTIONS
			spp.fetchAndPrintAllExpandedCategoryOptions();

			System.out.println("============================================================");
			System.out.println("[TEST COMPLETED FOR CATEGORY] " + categoryName + " | Row: " + row);
			System.out.println("============================================================");
		}

		softAssert.assertAll();
	}
}