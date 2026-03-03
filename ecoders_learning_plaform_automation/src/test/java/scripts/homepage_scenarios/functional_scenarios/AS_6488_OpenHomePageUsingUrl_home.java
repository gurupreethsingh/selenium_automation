package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_6488_OpenHomePageUsingUrl_home extends OpenClose {
	@Test
	public void testOpenHomePageUsingUrl_home() throws IOException {

		// get the expected homepage tittle from the excel sheet.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME_ALT_1);

		System.out.println(driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.verifyHomePageTitle(expectedHomePageTitle);

	}
}
