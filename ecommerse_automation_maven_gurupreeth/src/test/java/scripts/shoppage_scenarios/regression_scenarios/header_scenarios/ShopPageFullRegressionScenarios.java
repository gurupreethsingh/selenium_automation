package scripts.shoppage_scenarios.regression_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SearchProductsPage;
import pom.ShopPage;

public class ShopPageFullRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testEnterProductFromSearchFieldOFHeaderNavigateToSEearchProductsPage()
			throws IOException, InterruptedException {
		driver.get(URL_SHOP);
		ShopPage hp = new ShopPage(driver);
		String expectedShopPageTitle = (String) Excel.getData("ShopPage", 1, 0);
		hp.verifyShopPageTitle(expectedShopPageTitle);
		// now we have to enter something in the search field from the header of the
		// ShopPage.

		String key = (String) Excel.getData("SearchProductsPage", 5, 0);
		hp.enterValueIntoSearchField(key);
		Thread.sleep(1000);
		hp.clickSearchButtonDesktop();

		// user gets navigated to Search products page.
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testEnterProductNameInSearchFieldCheckAllRelatedProductsAreShownInSearchProductsPage()
			throws IOException, InterruptedException {

		driver.get(URL_SHOP);
		ShopPage hp = new ShopPage(driver);

		String expectedShopPageTitle = (String) Excel.getData("ShopPage", 1, 0);
		hp.verifyShopPageTitle(expectedShopPageTitle);

		String productName = (String) Excel.getData("SearchProductsPage", 5, 0);
		hp.enterValueIntoSearchField(productName);
		Thread.sleep(1000);
		hp.clickSearchButtonDesktop();

		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);

	}

}
