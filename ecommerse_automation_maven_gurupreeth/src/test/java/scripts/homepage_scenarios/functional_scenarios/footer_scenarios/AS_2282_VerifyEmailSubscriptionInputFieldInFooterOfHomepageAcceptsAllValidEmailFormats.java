package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_2282_VerifyEmailSubscriptionInputFieldInFooterOfHomepageAcceptsAllValidEmailFormats extends OpenClose {

	@Test
	public void testVerifyEmailSubscriptionInputFieldInFooterOfHomepageAcceptsAllValidEmailFormats()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		for (int i = 4; i <= 46; i++) {
			String validEmail = (String) Excel.getData("FooterElements", i, 1);
			Footer footer = new Footer(driver);
			footer.enterValueIntoSubscritionFormInputField(validEmail);
			Thread.sleep(500);
			footer.clickOnSubscriptionButton();
			Thread.sleep(500);
			Assert.assertTrue(footer.verifySubscriptionSuccessMessageIsDisplayed(), "Error in subscription");
		}
	}
}