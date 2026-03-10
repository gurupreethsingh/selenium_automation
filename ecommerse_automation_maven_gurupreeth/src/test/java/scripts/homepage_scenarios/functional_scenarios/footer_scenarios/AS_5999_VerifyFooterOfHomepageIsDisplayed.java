package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5999_VerifyFooterOfHomepageIsDisplayed extends OpenClose {

	@Test
	public void testVerifyFooterOfHomepageIsDisplayed() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Assert.assertTrue(hp.isFooterVisible(), "Footer of homepage is not displayed.");
	}
}