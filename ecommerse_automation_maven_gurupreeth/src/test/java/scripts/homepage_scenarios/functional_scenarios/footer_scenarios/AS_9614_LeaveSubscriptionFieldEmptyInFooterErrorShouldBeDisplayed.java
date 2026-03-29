package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_9614_LeaveSubscriptionFieldEmptyInFooterErrorShouldBeDisplayed extends OpenClose {

	@Test
	public void testLeaveSubscriptionFieldEmptyInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Footer footer = new Footer(driver);
		footer.enterValueIntoSubscritionFormInputField("");
		Thread.sleep(500);
		footer.clickOnSubscriptionButton();
		Thread.sleep(500);
		footer.verifySubscriptionErrorMessageText("Please enter your email");
		boolean errorMessage = footer.verifySubscriptionErrorMessageIsDisplayed();

		Assert.assertTrue(errorMessage,
				"Validation error is not displayed when only spaces are entered in footer subscription field.");

		Assert.assertTrue(footer.verifySubscriptionErrorMessageText("Please Enter your email."),
				"Error message is wrong");
	}
}