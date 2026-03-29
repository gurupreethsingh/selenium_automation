package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_5820_EnterSubscribedEmailInFooterClickSubscribeShouldDisplayAlreadySubscribedMessage extends OpenClose {

	@Test
	public void testEnterAlreadySubscribedEmailInFooterOfHomepageAndClickSubscribeShouldDisplayAlreadySubscribedMessage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		String alreadySubscribedEmail = "saranya@gmail.com";

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.enterValueIntoSubscritionFormInputField(alreadySubscribedEmail),
				"Unable to enter already subscribed email into subscription input field.");

		Thread.sleep(500);

		Assert.assertTrue(footer.clickOnSubscriptionButton(), "Unable to click on subscription button.");

		Thread.sleep(500);

		Assert.assertTrue(footer.verifySubscriptionErrorMessageIsDisplayed(), "Error message not displayed.");

		Assert.assertTrue(footer.verifySubscriptionErrorMessageText("Email is already subscribed."),
				"Email error display message failed");
	}
}