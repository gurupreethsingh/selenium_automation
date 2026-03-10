package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_8418_VerifyEmailSubscriptionFieldInFooterGetsClearedAfterSuccessfulSubscription
		extends OpenClose {

	@Test
	public void testVerifyEmailSubscriptionFieldInFooterOfHomepageGetsClearedAfterSuccessfulSubscription()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		hp.subscribeFromFooter(validEmail);
		Thread.sleep(2000);

		String actualValue = driver
				.findElement(By.cssSelector("footer form.flex.flex-col.space-y-3 input[type='email']"))
				.getAttribute("value");

		Assert.assertTrue(actualValue == null || actualValue.trim().isEmpty(),
				"Email subscription field is not cleared after successful subscription.");
	}
}