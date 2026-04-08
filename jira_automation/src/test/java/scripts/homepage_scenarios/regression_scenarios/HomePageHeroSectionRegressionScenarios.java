package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageHeroSectionRegressionScenarios extends OpenClose {
	// full regression scenarios for the entire homepage.

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrl() throws IOException {
		SoftAssert sa = new SoftAssert();
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
		driver.get(URL_HOME);
		HomePage homePage = new HomePage(driver);
		sa.assertTrue(homePage.verifyHomePageTitle(expectedTitle), "HomePage title verfication failed");
		sa.assertAll();
	}

	// to run the code in all the screen sizes, one by one.
	// public class AS_7346_OpenHomePageUsingUrl extends OpenClose {
	//
//		@Test(dataProvider = "allViewports", dataProviderClass = ViewportDataProvider.class)
//		public void testOpenHomePageUsingUrl(int width, int height, String deviceName) throws IOException {
	//
//			setViewport(width, height);
//			driver.get(URL_HOME);
//			String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
//			HomePage page = new HomePage(driver);
//			page.verifyHomePageTitle(expectedTitle);
//			System.out.println("Test executed on: " + deviceName + " -> " + width + "x" + height);
//			System.out.println("*******************************************************************");
//		}
// }

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrlForwardSlashHome() throws IOException {
		SoftAssert sa = new SoftAssert();
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
		driver.get(URL_HOME_ALT_1);
		HomePage homePage = new HomePage(driver);
		sa.assertTrue(homePage.verifyHomePageTitle(expectedTitle), "HomePage title verfication failed");
		sa.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrlForwardSlashHomepage() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
		SoftAssert sa = new SoftAssert();
		driver.get(URL_HOME_ALT_2);
		HomePage homePage = new HomePage(driver);
		sa.assertTrue(homePage.verifyHomePageTitle(expectedTitle), "HomePage title verfication failed");
		sa.assertAll();
	}

}
