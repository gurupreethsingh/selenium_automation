package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_4717_VerifyBrandSectionCountText extends OpenClose {
	@Test
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
