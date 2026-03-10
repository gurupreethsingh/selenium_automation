package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2369_EnterValidEmailInFooterPressEnterSubscriptionShouldWorkCorrectly extends OpenClose {

	@Test
	public void testEnterValidEmailInFooterOfHomepageAndPressEnterSubscriptionShouldWorkCorrectly()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);

		WebElement emailField = driver
				.findElement(By.cssSelector("footer form.flex.flex-col.space-y-3 input[type='email']"));
		emailField.clear();
		emailField.sendKeys(validEmail);
		emailField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		String successMessage = hp.getFooterSubscriptionSuccessMessage();
		Assert.assertFalse(successMessage.isEmpty(),
				"Subscription did not work correctly when Enter key was pressed from footer email field.");
	}
}