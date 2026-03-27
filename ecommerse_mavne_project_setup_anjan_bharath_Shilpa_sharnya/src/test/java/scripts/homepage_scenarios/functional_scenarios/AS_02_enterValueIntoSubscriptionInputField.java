package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.HomePage;

public class AS_02_enterValueIntoSubscriptionInputField extends OpenClose {
	@Test
	public void testEnterValueIntoSubscriptionInputFieldFooterOfHomepage() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String valueToEnter = "shilpa1@ecoders.co.in";
		Thread.sleep(2000);
		hp.enterValueIntoFooterEmailInputField(valueToEnter, "Enter your email", "Footer Email Field");

		Thread.sleep(2000);
		hp.clickOnSubscribeButtonOfFooter();

		Thread.sleep(2000);

	}
}
