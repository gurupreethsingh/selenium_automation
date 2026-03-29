package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_9256_EnterValidEmailInFooterClickSubscribeSuccessMessageShouldBeDisplayed extends OpenClose {

	@Test
	public void testEnterValidEmailInFooterOfHomepageAndClickSubscribeSuccessMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = "ecoders" + System.currentTimeMillis() + "@gmail.com";

		Footer footer = new Footer(driver);
		footer.enterValueIntoSubscritionFormInputField(validEmail);
		Thread.sleep(500);
		footer.clickOnSubscriptionButton();
		Thread.sleep(500);

		boolean successMessageDisplayed = footer.verifySubscriptionSuccessMessageIsDisplayed();

		Assert.assertTrue(successMessageDisplayed, "Success message not displayed");

		Assert.assertFalse(footer.verifySubscriptionSuccessMessageText("Subscription Successfull"),
				"Success message is not displayed after entering valid email in footer subscription field.");
	}
}