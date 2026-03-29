package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_8418_VerifyEmailSubscriptionFieldInFooterGetsClearedAfterSuccessfulSubscription extends OpenClose {

	@Test
	public void testVerifyEmailSubscriptionFieldInFooterOfHomepageGetsClearedAfterSuccessfulSubscription()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		Footer footer = new Footer(driver);

		String validEmail = "ecoders" + System.currentTimeMillis() + "@gmail.com";

		Assert.assertTrue(footer.enterValueIntoSubscritionFormInputField(validEmail),
				"Unable to enter valid email into subscription input field.");

		Thread.sleep(500);

		Assert.assertTrue(footer.clickOnSubscriptionButton(), "Unable to click on subscription button.");

		Thread.sleep(500);

		Assert.assertTrue(footer.verifySubscriptionSuccessMessageIsDisplayed(),
				"Subscription success message is not displayed.");

		Assert.assertTrue(footer.verifySubscriptionEmailInputFieldIsCleared(),
				"Email subscription input field is not cleared after successful subscription.");
	}
}