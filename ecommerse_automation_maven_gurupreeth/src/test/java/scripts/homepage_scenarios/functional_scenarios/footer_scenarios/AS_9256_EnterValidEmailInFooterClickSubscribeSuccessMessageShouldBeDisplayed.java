package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_9256_EnterValidEmailInFooterClickSubscribeSuccessMessageShouldBeDisplayed
		extends OpenClose {

	@Test
	public void testEnterValidEmailInFooterOfHomepageAndClickSubscribeSuccessMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		hp.subscribeFromFooter(validEmail);
		Thread.sleep(2000);

		String successMessage = hp.getFooterSubscriptionSuccessMessage();
		Assert.assertFalse(successMessage.isEmpty(),
				"Success message is not displayed after entering valid email in footer subscription field.");
	}
}