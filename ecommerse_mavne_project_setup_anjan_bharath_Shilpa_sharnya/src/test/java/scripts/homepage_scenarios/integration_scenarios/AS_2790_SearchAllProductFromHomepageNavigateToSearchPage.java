package scripts.homepage_scenarios.integration_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.SearchProductsPage;

public class AS_2790_SearchAllProductFromHomepageNavigateToSearchPage extends OpenClose {
	@Test
	public void testSearchProductFromHomepageNavigateToSearchPage() throws IOException, InterruptedException {
		// find the input field
		Homepage hp = new Homepage(driver);
		for (int i = 5; i <= 9; i++) {
			String eachProductNameTyped = (String) Excel.getData("SearchProductsPage", i, 0);
			// enter some query or product name into the input field.
			hp.enterValueIntoSearchField(eachProductNameTyped);
			// find the seach button.
			// click on the search button.
			hp.clickSearchButtonDesktop();
			// user will navigate to search products page.
			SearchProductsPage spp = new SearchProductsPage(driver);
			String expectedTitleOfSearchProductsPage = (String) Excel.getData("SearchProductPage", 1, 0);
			spp.verifySearchProductsPageTitle(expectedTitleOfSearchProductsPage);
			spp.verifySearchProductsPageUrl(
					"http://localhost:5173/search-products?query=" + eachProductNameTyped + ")");
			// find the text in the page. and match with the query word typed.
			driver.navigate().to("http://localhost:5173");
		}
	}
}
