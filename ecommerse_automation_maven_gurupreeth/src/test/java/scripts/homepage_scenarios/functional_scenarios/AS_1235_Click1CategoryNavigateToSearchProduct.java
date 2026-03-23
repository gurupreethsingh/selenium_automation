package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_1235_Click1CategoryNavigateToSearchProduct extends OpenClose {

	@Test
	public void testClick1CategoryNavigateToSearchProduct() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		// fetch category name before click
		String categoryName = hp.fetchSingleCategoryNameText();
		Assert.assertFalse(categoryName.isEmpty(), "Fetched category name is empty");
		System.out.println("[CLICKING CATEGORY] " + categoryName);

		// click on that category from homepage
		Assert.assertTrue(hp.clickOnAnyCategory(), "Category click failed for: " + categoryName);

		// now after click user navigates to search products page
		SearchProductsPage spp = new SearchProductsPage(driver);
		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl),
				"URL verification failed for category: " + categoryName);
	}
}