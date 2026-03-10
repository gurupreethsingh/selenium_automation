package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1947_EnterEmailWithoutDomainInFooterClickSubscribeErrorMessageShouldBeDisplayed
		extends OpenClose {

	@Test
	public void testEnterEmailWithoutDomainInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 4, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Error message is not displayed for email without domain in footer subscription.");
	}
}