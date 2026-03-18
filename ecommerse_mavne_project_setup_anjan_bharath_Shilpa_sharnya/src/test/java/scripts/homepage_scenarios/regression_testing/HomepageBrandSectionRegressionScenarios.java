package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class HomepageBrandSectionRegressionScenarios extends OpenClose {

	@Test(priority = 1, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionMainHeading() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionMainHeading();

		String exptectedBrandMainHeading = (String) Excel.getData("HomePage", 1, 8);
		Assert.assertEquals(hp.verifyBrandSectionMainHeading(), exptectedBrandMainHeading);

	}

	@Test(priority = 2, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionSubHeading() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionSubHeading();

		String exptectedBrandSubHeading = (String) Excel.getData("HomePage", 1, 9);
		Assert.assertEquals(hp.verifyBrandSectionSubHeading(), exptectedBrandSubHeading);

	}

	@Test(priority = 3, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionCountText() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionCountText();

		String exptectedBrandCountText = (String) Excel.getData("HomePage", 1, 10);
		Assert.assertEquals(hp.verifyBrandSectionCountText(), exptectedBrandCountText);

	}
}
