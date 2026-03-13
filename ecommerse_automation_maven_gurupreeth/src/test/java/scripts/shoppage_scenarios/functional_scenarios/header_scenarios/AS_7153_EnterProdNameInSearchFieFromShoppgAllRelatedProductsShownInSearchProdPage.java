package scripts.shoppage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SearchProductsPage;
import pom.ShopPage;

public class AS_7153_EnterProdNameInSearchFieFromShoppgAllRelatedProductsShownInSearchProdPage extends OpenClose {

	@Test
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