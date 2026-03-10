package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1554_VerifyTotalNumberOfSocialMediaLinksDisplayedInFooterOfHomepageIsCorrect extends OpenClose {

	@Test
	public void testVerifyTotalNumberOfSocialMediaLinksDisplayedInFooterOfHomepageIsCorrect()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		int actualCount = hp.getFooterSocialLinkCount();
		Assert.assertEquals(actualCount, 6, "Total number of social media links displayed in footer is incorrect.");
	}
}