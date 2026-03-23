package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class HomePageSubscriptionRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testVerifyHomepageLoadedSuccessfullyBeforeSubscriptionChecks() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionSectionContainerDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();
		Footer footer = new Footer(driver);
		softAssert.assertTrue(footer.verifySubscribeContainerIsDisplayed(), "Subscribe container verification failed");
		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionFormHeading() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		// Keep this value aligned with current UI text
		String expectedSubscribeHeading = "Subscribe for Updates";

		softAssert.assertTrue(footer.verifySubscribeFormHeading(expectedSubscribeHeading),
				"Subscribe form heading verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionFormCardDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscribeFormCardIsDisplayed(), "Subscribe form card verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionFormDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscriptionFormIsDisplayed(), "Subscription form verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionEmailTextFieldDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscriptionEmailTextFieldIsDisplayed(),
				"Subscription email text field verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionButtonDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscriptionButtonIsDisplayed(), "Subscription button verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testVerifyCompleteSubscriptionFormSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		String expectedSubscribeHeading = "Subscribe for Updates";

		softAssert.assertTrue(footer.verifySubscribeContainerIsDisplayed(), "Subscribe container verification failed");

		softAssert.assertTrue(footer.verifySubscribeFormHeading(expectedSubscribeHeading),
				"Subscribe form heading verification failed");

		softAssert.assertTrue(footer.verifySubscribeFormCardIsDisplayed(), "Subscribe form card verification failed");

		softAssert.assertTrue(footer.verifySubscriptionFormIsDisplayed(), "Subscription form verification failed");

		softAssert.assertTrue(footer.verifySubscriptionEmailTextFieldIsDisplayed(),
				"Subscription email text field verification failed");

		softAssert.assertTrue(footer.verifySubscriptionButtonIsDisplayed(), "Subscription button verification failed");

		softAssert.assertAll();
	}

	// fucntion to check if the error message is displayed or not , (not the text
	// verification of eerror message)
	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testClickSubscriptionButtonWithoutEnteringEmailAndVerifyErrorMessage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscriptionFormIsDisplayed(),
				"Subscription form verification failed before clicking submit");

		softAssert.assertTrue(footer.verifySubscriptionButtonIsDisplayed(),
				"Subscription button verification failed before clicking submit");

		softAssert.assertTrue(footer.clickOnSubscriptionButton(), "Click on subscription button failed");

		softAssert.assertTrue(footer.verifySubscriptionErrorMessageIsDisplayed(),
				"Subscription error message display verification failed");

		softAssert.assertAll();
	}

	// this function is to check the error text is the correct text displayed
	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testClickSubscriptionButtonWithoutEnteringEmailAndVerifyErrorMessageText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		// Update this expected text exactly as per your frontend validation message
		String expectedErrorMessage = "Please enter your email.";

		softAssert.assertTrue(footer.verifySubscriptionButtonIsDisplayed(), "Subscription button verification failed");

		softAssert.assertTrue(footer.clickOnSubscriptionButton(), "Click on subscription button failed");

		softAssert.assertTrue(footer.verifySubscriptionErrorMessageIsDisplayed(),
				"Subscription error message display verification failed");

		softAssert.assertTrue(footer.verifySubscriptionErrorMessageText(expectedErrorMessage),
				"Subscription error message text verification failed");

		softAssert.assertAll();
	}
}