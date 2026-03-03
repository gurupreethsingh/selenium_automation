package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_3500_OpenHomePageUsingUrlForwardSlash extends OpenClose {
	@Test
	public void testOpenHomePageUsingUrlForwardSlash() throws IOException {

		// get the expected homepage tittle from the excel sheet.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		hp.verifyHomePageTitle(expectedHomePageTitle);

	}
}
