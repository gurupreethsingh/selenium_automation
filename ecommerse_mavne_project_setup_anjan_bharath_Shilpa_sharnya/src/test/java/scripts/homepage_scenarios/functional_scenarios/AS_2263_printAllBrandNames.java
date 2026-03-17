package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_2263_printAllBrandNames extends OpenClose {
	@Test
	public void testPrintAllCategoryNames() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.printAllBrandNames();

	}

}
