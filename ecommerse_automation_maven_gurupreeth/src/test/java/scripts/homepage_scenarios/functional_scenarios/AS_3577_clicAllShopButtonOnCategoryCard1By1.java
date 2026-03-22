package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_3577_clicAllShopButtonOnCategoryCard1By1 extends OpenClose {

	@Test
	public void testClickingOnAllCategoryShopButtonsOneByOne() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page"),
				"Home page did not load properly at test start");

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		for (int row = 6; row <= 15; row++) {

			String categoryName = null;

			try {
				categoryName = (String) Excel.getData("HomePage", row, 2);

				System.out.println("\n====================================================");
				System.out.println("Processing Excel Row : " + row);
				System.out.println("Category fetched from Excel : " + categoryName);
				System.out.println("====================================================");

				softAssert.assertNotNull(categoryName, "Category name is null at row: " + row);

				if (categoryName == null || categoryName.trim().isEmpty()) {
					System.out.println("[SKIPPING] Category name is null/empty at row: " + row);
					continue;
				}

				categoryName = categoryName.trim();

				// dynamically build expected search products page URL
				String expectedSearchProductsPageUrl = "/search-products?query=" + categoryName;

				hp = new HomePage(driver);

				softAssert.assertTrue(
						hp.waitForPageToLoad(expectedHomePageTitle, null,
								"Home Page Before Clicking Category Shop Button"),
						"Homepage was not fully loaded before clicking category shop button: " + categoryName);

				softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
						"Homepage title verification failed before clicking category shop button: " + categoryName);

				// CLICK SHOP BUTTON OF MATCHED CATEGORY
				boolean clickStatus = hp.clickShopButtonByCategoryName(categoryName);
				softAssert.assertTrue(clickStatus,
						"Failed to click shop button for category: " + categoryName + " at Excel row: " + row);

				if (!clickStatus) {
					continue;
				}

				SearchProductsPage spp = new SearchProductsPage(driver);

				softAssert.assertTrue(
						spp.waitForPageToLoad(expectedSearchProductsPageTitle, expectedSearchProductsPageUrl,
								"Search Products Page"),
						"Search Products page did not load properly for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
						"Search Products page title verification failed for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedSearchProductsPageUrl),
						"Search Products page URL verification failed for category: " + categoryName);

				List<WebElement> fetchedProducts = spp.fetchAllProductsOfACategory(categoryName);

				softAssert.assertNotNull(fetchedProducts,
						"Fetched products list is null for category: " + categoryName);

				if (fetchedProducts != null) {
					softAssert.assertFalse(fetchedProducts.isEmpty(),
							"No products found for category: " + categoryName);

					System.out.println("Total products fetched for [" + categoryName + "] : " + fetchedProducts.size());
				}

				System.out.println("===================================================================");

			} catch (Exception ex) {
				System.out.println(
						"[TEST FLOW FAILED] Category: " + categoryName + " | Row: " + row + " | " + ex.getMessage());
				softAssert.fail(
						"Test flow failed for category: " + categoryName + " at row: " + row + " | " + ex.getMessage());
			} finally {
				try {
					driver.navigate().back();

					hp = new HomePage(driver);

					softAssert.assertTrue(
							hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page After Navigate Back"),
							"Failed to return to homepage after category flow. Category: " + categoryName);

					softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
							"Homepage title verification failed after navigating back. Category: " + categoryName);

				} catch (Exception backEx) {
					System.out.println(
							"[NAVIGATION BACK FAILED] Category: " + categoryName + " | " + backEx.getMessage());
					softAssert.fail("Navigation back to homepage failed after category: " + categoryName + " | "
							+ backEx.getMessage());
				}
			}
		}

		softAssert.assertAll();
	}
}