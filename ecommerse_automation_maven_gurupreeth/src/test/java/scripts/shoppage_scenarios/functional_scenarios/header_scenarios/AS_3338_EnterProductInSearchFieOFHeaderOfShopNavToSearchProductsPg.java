package scripts.shoppage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SearchProductsPage;
import pom.ShopPage;

public class AS_3338_EnterProductInSearchFieOFHeaderOfShopNavToSearchProductsPg extends OpenClose {
	@Test
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
}
