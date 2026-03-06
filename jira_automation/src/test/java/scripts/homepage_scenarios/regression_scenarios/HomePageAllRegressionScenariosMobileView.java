package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageAllRegressionScenariosMobileView extends OpenClose {

	@Test
	public void testOpenHomePageUsingUrl_MobileView() throws IOException {

		// ✅ Pick any ONE mobile size// Example: iPhone 12/13/14 (390 x 844)
		setViewport(390, 844);

		// ✅ Open in mobile viewport
		driver.get(URL_HOME);

		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage page = new HomePage(driver);
		page.verifyHomePageTitle(expectedTitle);

	}
}