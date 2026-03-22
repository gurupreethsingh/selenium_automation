package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_2319_fetchAllProductsIn1CategoryInSearchProductsPg extends OpenClose {

	@Test
	public void testFetchAllProductsInOfCategoryInSearchProductsPg() throws IOException, InterruptedException {

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		String categoryName = (String) Excel.getData("HomePage", 10, 2);

		System.out.println("Category fetched from Excel: " + categoryName);

		Assert.assertNotNull(categoryName, "Category name from Excel is null");
		Assert.assertFalse(categoryName.trim().isEmpty(), "Category name from Excel is empty");

		Assert.assertTrue(hp.clickCategoryByName(categoryName), "Failed to click category: " + categoryName);

		// now the user will be in the search products page. now fetch all products and
		// print them on the screen. even get the count of products.
		// belonging to that particular category.
		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);
		Thread.sleep(3000);
		// now fetch all the products from the page.
		spp.fetchAllProductsOfACategory(categoryName);
		Thread.sleep(3000);
	}
}