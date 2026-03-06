package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageAllRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME);

		HomePage page = new HomePage(driver);
		boolean homePageTitleVerified = page.verifyHomePageTitle(expectedTitle);

		softAssert.assertTrue(homePageTitleVerified, "Home page title mismatch for URL_HOME.");
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrlForwardSlashHome() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_1);

		HomePage page = new HomePage(driver);
		boolean homePageTitleVerified = page.verifyHomePageTitle(expectedTitle);

		softAssert.assertTrue(homePageTitleVerified, "Home page title mismatch for URL_HOME_ALT_1.");
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrlForwardSlashHomepage() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_2);

		HomePage page = new HomePage(driver);
		boolean homePageTitleVerified = page.verifyHomePageTitle(expectedTitle);

		softAssert.assertTrue(homePageTitleVerified, "Home page title mismatch for URL_HOME_ALT_2.");
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifyHomePageRootIsDisplayed() {
		HomePage page = new HomePage(driver);

		boolean isRootDisplayed = page.isHomePageRootDisplayed();

		softAssert.assertTrue(isRootDisplayed, "HomePage root is NOT displayed. Page did not load correctly.");
	}
}