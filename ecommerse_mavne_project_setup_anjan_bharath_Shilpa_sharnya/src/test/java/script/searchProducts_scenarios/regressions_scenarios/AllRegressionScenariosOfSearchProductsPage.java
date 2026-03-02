package script.searchProducts_scenarios.regressions_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SearchProductsPage;

public class AllRegressionScenariosOfSearchProductsPage extends OpenClose {
	@Test(priority = 1)
	public void testOpenSearchProductsPageUsingUrl() throws IOException {
		SearchProductsPage hp = new SearchProductsPage(driver);

		String expectedTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		System.out.println("Title from excel sheet : " + expectedTitle);

		hp.verifySearchProductsPageTitle(expectedTitle);
	}
}
