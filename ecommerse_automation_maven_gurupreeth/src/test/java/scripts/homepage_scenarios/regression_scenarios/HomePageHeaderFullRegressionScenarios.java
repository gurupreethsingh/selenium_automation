package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class HomePageHeaderFullRegressionScenarios extends OpenClose {
	@Test(invocationCount = 1, enabled = true, priority = 1)
	public void testEnterProductFromSearchFieldOFHeaderNavigateToSEearchProductsPage()
			throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);
		// now we have to enter something in the search field from the header of the
		// homepage.

		String key = (String) Excel.getData("SearchProductsPage", 5, 0);
		hp.enterValueIntoSearchField(key);
		hp.clickSearchButtonDesktop();

		// user gets navigated to Search products page.
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);
	}
}
