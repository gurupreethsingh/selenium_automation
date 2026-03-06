package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_5870_OpenHomepageUsing_forwardslashUrl extends OpenClose {
	@Test
	public void testOpenHomepageUsing_forwardslashUrl() throws IOException {
		// @BeforeMethod

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		// @BeforeMethod
	}
}
