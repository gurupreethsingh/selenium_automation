package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5820_EnterSubscribedEmailInFooterClickSubscribeShouldDisplayAlreadySubscribedMessage
		extends OpenClose {

	@Test
	public void testEnterAlreadySubscribedEmailInFooterOfHomepageAndClickSubscribeShouldDisplayAlreadySubscribedMessage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String alreadySubscribedEmail = (String) Excel.getData("HomePageFooter", 3, 0);
		hp.subscribeFromFooter(alreadySubscribedEmail);
		Thread.sleep(2000);

		String actualMessage = hp.getFooterSubscriptionError();
		Assert.assertEquals(actualMessage, "Email is already subscribed.");
	}
}