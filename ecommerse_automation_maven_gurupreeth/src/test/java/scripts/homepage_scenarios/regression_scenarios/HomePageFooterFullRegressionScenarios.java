package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageFooterFullRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testVerifyFooterOfHomepageIsDisplayed() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Assert.assertTrue(hp.isFooterVisible(), "Footer of homepage is not displayed.");
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testClickAboutUsLinkFromFooterOfHomepageUserGetsNavigatedToAboutUsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterAboutUs();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("about"),
				"User is not navigated to About Us page.");
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testClickContactUsLinkFromFooterOfHomepageUserGetsNavigatedToContactUsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterContactUs();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("contact"),
				"User is not navigated to Contact Us page.");
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testClickCareersLinkFromFooterOfHomepageUserGetsNavigatedToCareersPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterCareers();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("careers"),
				"User is not navigated to Careers page.");
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testClickBlogsLinkFromFooterOfHomepageUserGetsNavigatedToAllBlogsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterBlogs();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("blog"),
				"User is not navigated to All Blogs page.");
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testClickHelpCenterLinkFromFooterOfHomepageUserGetsNavigatedToHelpCenterPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterHelpCenter();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("help"),
				"User is not navigated to Help Center page.");
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testClickPrivacyPolicyLinkFromFooterOfHomepageUserGetsNavigatedToPrivacyPolicyPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterPrivacyPolicy();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("privacy"),
				"User is not navigated to Privacy Policy page.");
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClickTermsOfServiceLinkFromFooterOfHomepageUserGetsNavigatedToTermsOfServicePage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterTermsOfService();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("terms"),
				"User is not navigated to Terms of Service page.");
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testVerifyTotalNumberOfSocialMediaLinksDisplayedInFooterOfHomepageIsCorrect()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		int actualCount = hp.getFooterSocialLinkCount();
		Assert.assertEquals(actualCount, 6, "Total number of social media links displayed in footer is incorrect.");
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testClickFirstSocialMediaIconFromFooterOfHomepageCorrespondingPageShouldOpenInDifferentTab()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Set<String> oldWindows = driver.getWindowHandles();
		hp.clickFooterSocialLinkByIndex(0);
		Thread.sleep(1500);

		Set<String> newWindows = driver.getWindowHandles();
		Assert.assertTrue(newWindows.size() > oldWindows.size(),
				"First social media icon did not open in a different tab.");
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testClickAll6SocialMediaIconsOneByOneFromFooterOfHomepageCorrespondingPagesShouldOpenInAnotherTab()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		int socialLinkCount = hp.getFooterSocialLinkCount();
		Assert.assertEquals(socialLinkCount, 6, "Footer does not contain exactly 6 social media icons.");

		for (int i = 0; i < socialLinkCount; i++) {
			Set<String> oldWindows = driver.getWindowHandles();
			hp.clickFooterSocialLinkByIndex(i);
			Thread.sleep(1500);

			Set<String> newWindows = driver.getWindowHandles();
			Assert.assertTrue(newWindows.size() > oldWindows.size(),
					"Corresponding social media page did not open in another tab for icon index: " + i);

			for (String win : newWindows) {
				if (!oldWindows.contains(win)) {
					driver.switchTo().window(win);
					driver.close();
				}
			}

			for (String win : oldWindows) {
				driver.switchTo().window(win);
				break;
			}
		}
	}

	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testEnterValidEmailInFooterOfHomepageAndClickSubscribeSuccessMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		hp.subscribeFromFooter(validEmail);
		Thread.sleep(2000);

		String successMessage = hp.getFooterSubscriptionSuccessMessage();
		Assert.assertFalse(successMessage.isEmpty(),
				"Success message is not displayed after entering valid email in footer subscription field.");
	}

	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void testEnterInvalidEmailInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 2, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Error message is not displayed for invalid email entered in footer subscription field.");
	}

	@Test(priority = 14, enabled = true, invocationCount = 1)
	public void testLeaveSubscriptionFieldEmptyInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickFooterSubscribeButton();
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Validation error is not displayed when footer subscription field is left empty.");
	}

	@Test(priority = 15, enabled = true, invocationCount = 1)
	public void testEnterOnlySpacesInFooterOfHomepageAndClickSubscribeValidationErrorShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.subscribeFromFooter("   ");
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Validation error is not displayed when only spaces are entered in footer subscription field.");
	}

	@Test(priority = 16, enabled = true, invocationCount = 1)
	public void testEnterEmailWithoutAtSymbolInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 5, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Error message is not displayed for email without @ in footer subscription.");
	}

	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void testEnterEmailWithoutDomainInFooterOfHomepageAndClickSubscribeErrorMessageShouldBeDisplayed()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 4, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(),
				"Error message is not displayed for email without domain in footer subscription.");
	}

	@Test(priority = 18, enabled = true, invocationCount = 1)
	public void testEnterAlreadySubscribedEmailInFooterOfHomepageAndClickSubscribeShouldDisplayAlreadySubscribedMessage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String alreadySubscribedEmail = (String) Excel.getData("HomePageFooter", 3, 0);
		hp.subscribeFromFooter(alreadySubscribedEmail);
		Thread.sleep(2000);

		String actualMessage = hp.getFooterSubscriptionError();
		Assert.assertEquals(actualMessage, "Email is already subscribed.");
	}

	@Test(priority = 19, enabled = true, invocationCount = 1)
	public void testEnterValidEmailInFooterOfHomepageAndPressEnterSubscriptionShouldWorkCorrectly()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

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

	@Test(priority = 20, enabled = true, invocationCount = 1)
	public void testVerifyEmailSubscriptionInputFieldInFooterOfHomepageAcceptsAllValidEmailFormats()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String validEmail = (String) Excel.getData("HomePageFooter", 1, 0);
		hp.subscribeFromFooter(validEmail);
		Thread.sleep(2000);

		String successMessage = hp.getFooterSubscriptionSuccessMessage();
		String errorMessage = hp.getFooterSubscriptionError();

		Assert.assertTrue(!successMessage.isEmpty() && errorMessage.isEmpty(),
				"Valid email format was not accepted in footer subscription field.");
	}

	@Test(priority = 21, enabled = true, invocationCount = 1)
	public void testVerifyEmailSubscriptionInputFieldInFooterOfHomepageDoesNotAcceptAllInvalidEmailFormat()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String invalidEmail = (String) Excel.getData("HomePageFooter", 2, 0);
		hp.subscribeFromFooter(invalidEmail);
		Thread.sleep(1500);

		String errorMessage = hp.getFooterSubscriptionError();
		Assert.assertFalse(errorMessage.isEmpty(), "Invalid email format was accepted in footer subscription field.");
	}

	@Test(priority = 22, enabled = true, invocationCount = 1)
	public void testVerifyEmailSubscriptionFieldInFooterOfHomepageGetsClearedAfterSuccessfulSubscription()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

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