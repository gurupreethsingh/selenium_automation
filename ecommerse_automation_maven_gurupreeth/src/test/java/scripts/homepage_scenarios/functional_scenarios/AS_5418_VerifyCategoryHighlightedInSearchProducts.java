package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_5418_VerifyCategoryHighlightedInSearchProducts extends OpenClose {

	@Test
	public void testVerifyCategoryHighlightedInSearchProducts() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		// ============================================================
		// ✅ STEP 1: VERIFY HOMEPAGE TITLE
		// ============================================================
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		// ============================================================
		// ✅ STEP 2: CLICK CATEGORY (CURRENT POM SUPPORTS ONLY THIS)
		// ============================================================
		String categoryName = "Electronics";

		softAssert.assertTrue(hp.clickOnCategory(), "Failed to click category: " + categoryName);

		// ============================================================
		// ✅ STEP 3: VERIFY SEARCH PRODUCTS PAGE TITLE
		// ============================================================
		SearchProductsPage spp = new SearchProductsPage(driver);

		String expectedTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedTitle),
				"Search products page title verification failed");

		// ============================================================
		// ✅ STEP 4: VERIFY URL
		// ============================================================
		String expectedUrl = "http://localhost:5173/search-products?query=" + categoryName;

		softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedUrl),
				"Search products page URL verification failed");

		// ============================================================
		// ✅ STEP 5: VERIFY MAIN HEADING
		// ============================================================
		softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
				"Search products main heading verification failed");

		// ============================================================
		// ✅ STEP 6: VERIFY CATEGORY DROPDOWN IS DISPLAYED
		// ============================================================
		softAssert.assertTrue(spp.verifyCategoryDropdownIsDisplayed(), "Category dropdown is not displayed");

		// ============================================================
		// ✅ STEP 7: VERIFY CATEGORY IS HIGHLIGHTED IN ORANGE
		// ============================================================
		softAssert.assertTrue(spp.verifySelectedCategoryHighlightedInDropdown(categoryName),
				"Selected category is NOT highlighted in orange in dropdown");

		// ============================================================
		// ✅ FINAL ASSERT
		// ============================================================
		softAssert.assertAll();
	}
}