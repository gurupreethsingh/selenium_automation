package scripts.homepage_scenarios.integration_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.SearchProductsPage;

public class AS_2790_SearchProductFromHomepageNavigateToSearchPage extends OpenClose {
	@Test
	public void testSearchProductFromHomepageNavigateToSearchPage() throws IOException {
		// find the input field
		Homepage hp = new Homepage(driver);
//		String productNameTyped = (String)Excel.getData("Homepage", 2, 2);
		// enter some query or product name into the input field.
		hp.enterValueIntoSearchField("samsung");
		// find the seach button.
		// click on the search button.
		hp.clickSearchButtonDesktop();
		// user will navigate to search products page.
		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedTitleOfSearchProductsPage = (String) Excel.getData(excelSheetPath, 1, 0);
		spp.verifySearchProductsPageTitle(expectedTitleOfSearchProductsPage);
		spp.verifySearchProductsPageUrl("http://localhost:5173/search-products?query=samsung");
		// find the text in the page. and match with the query word typed.
		driver.navigate().back();
		// come back to homepage and close the browser.
	}
}
