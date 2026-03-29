package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_1947_EnterEmailWithoutDomainInFooterClickSubscribeErrorMessageShouldBeDisplayed extends OpenClose {

	@Test
	public void testEnterEmailWithoutDomainInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

//		String invalidEmail = (String) Excel.getData("HomePageFooter", 4, 0);
		String invalidEmail = "ecoders@.com";
		Footer footer = new Footer(driver);
		footer.enterValueIntoSubscritionFormInputField(invalidEmail);
		Thread.sleep(500);

		footer.clickOnSubscriptionButton();

		Assert.assertTrue(footer.verifySubscriptionErrorMessageText("Enter a valid email id"),
				"Error message is not showing");

	}
}