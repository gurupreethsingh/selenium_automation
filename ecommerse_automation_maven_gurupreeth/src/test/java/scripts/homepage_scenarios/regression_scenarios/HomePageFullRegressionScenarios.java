package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class HomePageFullRegressionScenarios extends OpenClose {
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testEnterForwardSlashUrlInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main parent container / root container of homepage is displayed
		hp.isHomePageRootDisplayed();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testEnterHomepageUrlWithHomeInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		String homepageUrlWithHome = (String) Excel.getData("HomePage", 1, 2);
		driver.get(homepageUrlWithHome);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main parent container / root container of homepage is displayed
		hp.isHomePageRootDisplayed();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testEnterHomepageUrlWithHomepageInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		String homepageUrlWithHomepage = (String) Excel.getData("HomePage", 1, 3);
		driver.get(homepageUrlWithHomepage);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main parent container / root container of homepage is displayed
		hp.isHomePageRootDisplayed();
	}

	@Test(invocationCount = 4, enabled = false, priority = 1)
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
