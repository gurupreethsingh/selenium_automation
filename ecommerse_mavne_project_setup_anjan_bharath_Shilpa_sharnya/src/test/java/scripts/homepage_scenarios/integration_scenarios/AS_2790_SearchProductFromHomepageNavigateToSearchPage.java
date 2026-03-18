package scripts.homepage_scenarios.integration_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_2790_SearchProductFromHomepageNavigateToSearchPage extends OpenClose {
	@Test
	public void testSearchProductFromHomepageNavigateToSearchPage() throws IOException {
		// find the input field
		HomePage hp = new HomePage(driver);
//		String productNameTyped = (String)Excel.getData("HomePage", 2, 2);
		// enter some query or product name into the input field.
		hp.enterValueIntoSearchField("samsung");
		// find the seach button.
		// click on the search button.
		hp.clickSearchButtonDesktop();
		// user will navigate to search products page.
		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedTitleOfSearchProductsPage = (String) Excel.getData("HomePage", 1, 0);
		spp.verifySearchProductsPageTitle(expectedTitleOfSearchProductsPage);
		spp.verifySearchProductsPageUrl("http://localhost:5173/search-products?query=samsung");
		// find the text in the page. and match with the query word typed.
		driver.navigate().back();
		// come back to homepage and close the browser.
	}
}
