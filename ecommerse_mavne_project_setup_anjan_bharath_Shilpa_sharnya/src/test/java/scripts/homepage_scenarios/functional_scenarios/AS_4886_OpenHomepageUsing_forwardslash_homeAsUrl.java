package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_4886_OpenHomepageUsing_forwardslash_homeAsUrl extends OpenClose {
	@Test
	public void testOpenHomepageUsing_forwardslash_homeAsUrl() throws IOException {
		// @BeforeMethod

		driver.get(urlOfApplication1);

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		// @BeforeMethod
	}
}
