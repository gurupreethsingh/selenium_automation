package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;

public class AS_7887_VerifyEmailSubscriptionInputFieldInFooterDoesntAcceptAllInvalidEmailFormat extends OpenClose {

	@Test
	public void testVerifyEmailSubscriptionInputFieldInFooterOfHomepageDoesNotAcceptAllInvalidEmailFormat()
			throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		for (int i = 3; i <= 166; i++) {

			String invalidEmail = (String) Excel.getData("FooterElements", i, 0);

			System.out.println("===============================================");
			System.out.println("[TESTING INVALID EMAIL] Row: " + i + " | Value: " + invalidEmail);
			System.out.println("===============================================");

			boolean enterStatus = footer.enterValueIntoSubscritionFormInputField(invalidEmail);
			softAssert.assertTrue(enterStatus,
					"Failed to enter invalid email at row: " + i + " | Value: " + invalidEmail);

			Thread.sleep(100);

			boolean clickStatus = footer.clickOnSubscriptionButton();
			softAssert.assertTrue(clickStatus, "Failed to click subscription button for row: " + i);

			Thread.sleep(100);

			boolean errorDisplayed = footer.verifySubscriptionErrorMessageIsDisplayed();

			softAssert.assertTrue(errorDisplayed, "[FAILED] Error message NOT displayed for invalid email at row: " + i
					+ " | Value: " + invalidEmail);

			// Optional but IMPORTANT → clear field before next iteration
			footer.enterValueIntoSubscritionFormInputField(""); // since your method now clears internally
		}

		// VERY IMPORTANT → triggers all collected assertions
		softAssert.assertAll();
	}
}