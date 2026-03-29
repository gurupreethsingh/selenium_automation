package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_2369_EnterValidEmailInFooterPressEnterSubscriptionShouldWorkCorrectly extends OpenClose {

	@Test
	public void testEnterValidEmailInFooterOfHomepageAndPressEnterSubscriptionShouldWorkCorrectly()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

//		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		String validEmail = "mark@gmail.com";

		Footer footer = new Footer(driver);

		footer.enterValueIntoSubscritionFormInputField(validEmail);

		footer.clickOnSubscriptionButton();

		footer.verifySubscriptionSuccessMessageText("Subscription Successfull");

	}
}