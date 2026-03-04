package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageAllRegressionScenarios extends OpenClose {
	@Test
	public void testOpenHomePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME);

		HomePage page = new HomePage(driver);
		page.verifyHomePageTitle(expectedTitle);
	}
}
