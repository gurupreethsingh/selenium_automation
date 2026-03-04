package scripts.homepage_scenarios.functional_scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.HomePage;

public class AS_6617_VerifyHomePageRootIsDisplayed extends OpenClose {
	@Test
	public void testVerifyHomePageRootIsDisplayed() {
		driver.get(URL_HOME_ALT_1);

		HomePage page = new HomePage(driver);

		boolean isRootDisplayed = page.isHomePageRootDisplayed();

		Assert.assertTrue(isRootDisplayed, "HomePage root is NOT displayed. Page did not load correctly.");
	}

}
