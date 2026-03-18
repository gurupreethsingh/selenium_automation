package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_4287_VerifyBrandSectionMainHeading extends OpenClose {
	@Test
	public void testVerifyBrandSectionMainHeading() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionMainHeading();

		String exptectedBrandMainHeading = (String) Excel.getData("HomePage", 1, 8);
		Assert.assertEquals(hp.verifyBrandSectionMainHeading(), exptectedBrandMainHeading);

	}
}
