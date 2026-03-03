package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomepageFullRegressionScenarios extends OpenClose {
	@Test(priority = 1, enabled = true, invocationCount = 2)
	public void testOpenHomePageUsingUrlForwardSlash() throws IOException {

		// get the expected homepage tittle from the excel sheet.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		hp.verifyHomePageTitle(expectedHomePageTitle);

	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrl_home() throws IOException {

		// get the expected homepage tittle from the excel sheet.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_1);

		System.out.println(driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.verifyHomePageTitle(expectedHomePageTitle);

	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomePageUsingUrl_homepage() throws IOException {

		// get the expected homepage tittle from the excel sheet.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_2);

		System.out.println(driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.verifyHomePageTitle(expectedHomePageTitle);

	}

}
