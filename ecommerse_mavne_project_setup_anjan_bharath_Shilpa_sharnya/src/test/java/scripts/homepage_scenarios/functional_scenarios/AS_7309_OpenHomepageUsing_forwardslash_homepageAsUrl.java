package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_7309_OpenHomepageUsing_forwardslash_homepageAsUrl extends OpenClose {
	@Test
	public void testOpenHomepageUsing_forwardslash_homepageAsUrl() throws IOException {
		// @BeforeMethod

		driver.get(urlOfApplication2);

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		// @BeforeMethod
	}
}
