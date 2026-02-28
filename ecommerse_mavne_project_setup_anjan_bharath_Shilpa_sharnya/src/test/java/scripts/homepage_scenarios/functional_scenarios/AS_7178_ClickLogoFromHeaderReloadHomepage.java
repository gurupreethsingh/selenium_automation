package scripts.homepage_scenarios.functional_scenarios;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_7178_ClickLogoFromHeaderReloadHomepage extends OpenClose {
	// create a function to test , click on logo from header and reload the
	// homepage.

	@Test
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() {

		Homepage hp = new Homepage(driver);
		String expectedTitle = Excel.getData1("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickOnLogo();
		hp.verifyHomepageTitle(expectedTitle);

	}
}
