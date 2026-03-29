package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_1736_EnterEmailWithoutAtSymbolInFooterClickSubscribeErrorMessageShouldBeDisplayed extends OpenClose {

	@Test
	public void testEnterEmailWithoutAtSymbolInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

//		String invalidEmail = (String) Excel.getData("HomePageFooter", 5, 0);

		String invalidEmail = "igururpeethgmail.com";

		Footer footer = new Footer(driver);
		footer.enterValueIntoSubscritionFormInputField(invalidEmail);
		Thread.sleep(1000);
		footer.clickOnSubscriptionButton();

		Thread.sleep(1000);

		footer.verifySubscriptionErrorMessageIsDisplayed();
		Thread.sleep(1000);

		Assert.assertTrue(footer.verifySubscriptionErrorMessageIsDisplayed(),
				"Error message is not displayed for email without @ in footer subscription.");
	}
}