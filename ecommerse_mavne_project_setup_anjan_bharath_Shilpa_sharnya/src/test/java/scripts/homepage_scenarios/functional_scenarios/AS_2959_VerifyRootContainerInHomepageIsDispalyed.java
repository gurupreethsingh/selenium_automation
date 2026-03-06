package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_2959_VerifyRootContainerInHomepageIsDispalyed extends OpenClose {
	@Test
	public void testVerifyRootContainerInHomepageIsDispalyed() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.isHomePageRootDisplayed();

	}
}
