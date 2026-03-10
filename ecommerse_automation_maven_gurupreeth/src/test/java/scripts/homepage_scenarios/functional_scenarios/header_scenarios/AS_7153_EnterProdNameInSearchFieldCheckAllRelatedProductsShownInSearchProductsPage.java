package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_7153_EnterProdNameInSearchFieldCheckAllRelatedProductsShownInSearchProductsPage
		extends OpenClose {

	@Test
	public void testEnterProductNameInSearchFieldCheckAllRelatedProductsAreShownInSearchProductsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String productName = (String) Excel.getData("SearchProductsPage", 5, 0);
		hp.enterValueIntoSearchField(productName);
		Thread.sleep(1000);
		hp.clickSearchButtonDesktop();

		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);

	}
}