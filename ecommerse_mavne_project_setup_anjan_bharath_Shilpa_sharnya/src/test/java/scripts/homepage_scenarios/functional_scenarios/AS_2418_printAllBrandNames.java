package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2418_printAllBrandNames extends OpenClose {
	@Test
	public void testPrintAllBrandNames() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.printAllBrandNames();

	}

}
