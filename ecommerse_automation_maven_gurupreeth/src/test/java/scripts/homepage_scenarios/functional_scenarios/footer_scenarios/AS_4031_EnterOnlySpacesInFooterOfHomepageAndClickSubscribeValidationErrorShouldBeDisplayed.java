package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_4031_EnterOnlySpacesInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed
		extends OpenClose {

	@Test
	public void testEnterOnlySpacesInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.subscribeFromFooter("   ");
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Validation error is not displayed when only spaces are entered in footer subscription field.");
	}
}