package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.SearchProductsPage;
import pom.ShopPage;

public class HomepageRegressionTestingScenarios extends OpenClose {

	@Test(priority = 1)
	public void testOpenHomepageUsingUrl() throws IOException {
		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		System.out.println("Title from excel sheet : " + expectedTitle);
		String expectedUrl = (String) Excel.getData("Homepage", 1, 1);
		System.out.println("Url from excel sheet : " + expectedUrl);

		int password = ((Double) Excel.getData("Homepage", 1, 4)).intValue();// 12345.0
		System.out.println(password);

		hp.verifyHomepageTitle(expectedTitle);
		hp.verifyHomepageUrl(expectedUrl);

	}

	@Test(priority = 2, enabled = true)
	public void testOpenHomepageUsing_forwardslash_homeAsUrl() throws IOException {
		// @BeforeMethod

		driver.get(URL_HOME_ALT_1);

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		// @BeforeMethod
	}

	@Test(priority = 3, enabled = true)
	public void testVerifyRootContainerInHomepageIsDispalyed() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.isHomePageRootDisplayed();

	}

	@Test(priority = 4, enabled = true)
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoHome();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 5, enabled = true)
	public void testClickOnLogoApplicationNameHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoAppNameAndPrintText();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 6, invocationCount = 1)
	public void testClickShopAllLinkFromHeaderOpenShopPage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedHomeTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedHomeTitle);

		// update row/col as per your excel
		hp.clickHeaderShopAllDesktop();

		ShopPage sp = new ShopPage(driver);
		String expectedShopTitle = (String) Excel.getData("Shoppage", 1, 0);
		sp.verifyShopPageTitle(expectedShopTitle);

	}

	@Test(priority = 7, invocationCount = 1)
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
		String expectedTitleOfSearchProductsPage = (String) Excel.getData(EXCEL_SHEET_PATH, 1, 0);
		spp.verifySearchProductsPageTitle(expectedTitleOfSearchProductsPage);
		spp.verifySearchProductsPageUrl("http://localhost:5173/search-products?query=samsung");
		// find the text in the page. and match with the query word typed.
		driver.navigate().back();
		// come back to homepage and close the browser.
	}

}
