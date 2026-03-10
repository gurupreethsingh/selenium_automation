package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2282_VerifyEmailSubscriptionInputFieldInFooterOfHomepageAcceptsAllValidEmailFormats extends OpenClose {

	@Test
	public void testVerifyEmailSubscriptionInputFieldInFooterOfHomepageAcceptsAllValidEmailFormats()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		hp.subscribeFromFooter(validEmail);
		Thread.sleep(2000);

		String successMessage = hp.getFooterSubscriptionSuccessMessage();
		String errorMessage = hp.getFooterSubscriptionError();

		Assert.assertTrue(!successMessage.isEmpty() && errorMessage.isEmpty(),
				"Valid email format was not accepted in footer subscription field.");
	}
}