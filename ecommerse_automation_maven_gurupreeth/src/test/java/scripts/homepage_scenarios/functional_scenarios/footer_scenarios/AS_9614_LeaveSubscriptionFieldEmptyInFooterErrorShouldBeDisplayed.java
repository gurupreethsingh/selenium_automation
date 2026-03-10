package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_9614_LeaveSubscriptionFieldEmptyInFooterErrorShouldBeDisplayed
		extends OpenClose {

	@Test
	public void testLeaveSubscriptionFieldEmptyInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterSubscribeButton();
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Validation error is not displayed when footer subscription field is left empty.");
	}
}