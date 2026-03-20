package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_9516_ClickAllCategoryVerifyMainHeadingInSearchProduct extends OpenClose {

	@Test
	public void testClickAllCategoryVerifyMainHeadingInSearchProduct() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		// ============================================================
		// ✅ STEP 1: VERIFY HOMEPAGE TITLE
		// ============================================================
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		// ============================================================
		// ✅ STEP 2: GET ALL CATEGORY NAMES FROM EXCEL
		// Row = 6 to 15, Column = 2
		// ============================================================
		List<String> expectedCategories = new ArrayList<>();

		for (int row = 6; row <= 15; row++) {
			String categoryName = (String) Excel.getData("HomePage", row, 2);

			if (categoryName != null && !categoryName.trim().isEmpty()) {
				expectedCategories.add(categoryName.trim());
			}
		}

		softAssert.assertFalse(expectedCategories.isEmpty(), "Expected category list from Excel is empty");

		System.out.println("==================================================");
		System.out.println("[CATEGORY LOOP START]");
		System.out.println("Total Categories To Test: " + expectedCategories.size());
		System.out.println("==================================================");

		// ============================================================
		// ✅ STEP 3: SEARCH PRODUCTS PAGE EXPECTED TITLE
		// ============================================================
		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		// ============================================================
		// ✅ STEP 4: LOOP THROUGH ALL CATEGORIES
		// ============================================================
		for (int i = 0; i < expectedCategories.size(); i++) {

			String categoryName = expectedCategories.get(i);

			System.out.println("--------------------------------------------------");
			System.out.println("[TESTING CATEGORY] " + (i + 1) + ". " + categoryName);
			System.out.println("--------------------------------------------------");

			// Recreate homepage object for fresh references
			hp = new HomePage(driver);

			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed before clicking category: " + categoryName);

			boolean clicked = hp.clickAllCategoriesByName(categoryName);

			softAssert.assertTrue(clicked, "Failed to click category: " + categoryName);

			// If click failed, skip remaining validations for this category
			if (!clicked) {
				continue;
			}

			// User navigates to Search Products page
			SearchProductsPage spp = new SearchProductsPage(driver);

			softAssert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
					"Search products page title verification failed for category: " + categoryName);

			String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

			softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedSearchProductsPageUrl),
					"Search products page URL verification failed for category: " + categoryName);

			softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
					"Search products main heading verification failed for category: " + categoryName);

			// Go back to homepage
			driver.navigate().back();

			// Recreate homepage object after back navigation
			hp = new HomePage(driver);

			// Explicit verification instead of Thread.sleep
			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed after navigating back from category: " + categoryName);

			softAssert.assertTrue(hp.verifyCategoryParentContainerIsDisplayed(),
					"Homepage category section not visible after navigating back from category: " + categoryName);
		}

		System.out.println("==================================================");
		System.out.println("[CATEGORY LOOP COMPLETED]");
		System.out.println("==================================================");

		// ============================================================
		// ✅ FINAL ASSERT
		// ============================================================
		softAssert.assertAll();
	}
}