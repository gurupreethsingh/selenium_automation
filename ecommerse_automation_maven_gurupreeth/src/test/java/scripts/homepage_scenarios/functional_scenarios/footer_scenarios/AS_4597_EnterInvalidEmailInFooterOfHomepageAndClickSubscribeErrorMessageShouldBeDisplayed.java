package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_4597_EnterInvalidEmailInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed
		extends OpenClose {

	@Test
	public void testEnterInvalidEmailInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 2, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Error message is not displayed for invalid email entered in footer subscription field.");
	}
}