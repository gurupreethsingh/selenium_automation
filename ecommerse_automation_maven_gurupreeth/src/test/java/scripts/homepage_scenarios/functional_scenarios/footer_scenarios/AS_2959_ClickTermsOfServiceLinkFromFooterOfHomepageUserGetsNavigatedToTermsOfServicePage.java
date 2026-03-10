package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2959_ClickTermsOfServiceLinkFromFooterOfHomepageUserGetsNavigatedToTermsOfServicePage
		extends OpenClose {

	@Test
	public void testClickTermsOfServiceLinkFromFooterOfHomepageUserGetsNavigatedToTermsOfServicePage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle((String) Excel.getData("HomePage", 1, 0));

		hp.clickFooterTermsOfService();
		Thread.sleep(1500);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("terms"),
				"User is not navigated to Terms of Service page.");
	}
}