package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_7347_OpenHomePageUsingUrl extends OpenClose {

	@Test
	public void testOpenHomePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_1);

		HomePage page = new HomePage(driver);
		page.verifyHomePageTitle(expectedTitle);
	}
}
