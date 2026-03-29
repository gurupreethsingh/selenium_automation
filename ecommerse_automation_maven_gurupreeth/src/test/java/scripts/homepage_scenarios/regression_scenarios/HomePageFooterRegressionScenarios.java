package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class HomePageFooterRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testVerifyFooterRootAndMainWrapperDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage hp = new HomePage(driver);
		Footer footer = new Footer(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");
		softAssert.assertTrue(footer.verifyFooterRootIsDisplayed(), "Footer root is not displayed");
		softAssert.assertTrue(footer.verifyFooterMainWrapperIsDisplayed(), "Footer main wrapper is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testVerifyTrustBadgesSectionAndCount() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyTrustBadgesSectionIsDisplayed(), "Trust badges section is not displayed");
		softAssert.assertTrue(footer.verifyTotalTrustBadgeCardsCount(4), "Trust badge cards count mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testVerifyIndividualTrustBadgeCardsDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFastDeliveryCardIsDisplayed(), "Fast Delivery card is not displayed");
		softAssert.assertTrue(footer.verifyEasyReturnsCardIsDisplayed(), "Easy Returns card is not displayed");
		softAssert.assertTrue(footer.verifyBuyerProtectionCardIsDisplayed(), "Buyer Protection card is not displayed");
		softAssert.assertTrue(footer.verifySupportCardIsDisplayed(), "Support card is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifyTrustBadgeTitlesText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFastDeliveryTitleText("Fast Delivery"),
				"Fast Delivery title verification failed");
		softAssert.assertTrue(footer.verifyEasyReturnsTitleText("Easy Returns"),
				"Easy Returns title verification failed");
		softAssert.assertTrue(footer.verifyBuyerProtectionTitleText("Buyer Protection"),
				"Buyer Protection title verification failed");
		softAssert.assertTrue(footer.verifySupportTitleText("Support"), "Support title verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testVerifyFooterGridSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFooterGridSectionIsDisplayed(), "Footer grid section is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testVerifyCompanyInfoSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyCompanyInfoSectionIsDisplayed(), "Company info section is not displayed");
		softAssert.assertTrue(footer.verifyContactInfoBlockIsDisplayed(), "Contact info block is not displayed");
		softAssert.assertTrue(footer.verifySupportEmailBlockIsDisplayed(), "Support email block is not displayed");
		softAssert.assertTrue(footer.verifySupportPhoneBlockIsDisplayed(), "Support phone block is not displayed");
		softAssert.assertTrue(footer.verifyWorkingHoursBlockIsDisplayed(), "Working hours block is not displayed");
		softAssert.assertTrue(footer.verifyLocationBlockIsDisplayed(), "Location block is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testVerifyCompanyInfoTexts() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyEcodersBadgeText("Ecoders"), "Ecoders badge text verification failed");
		softAssert.assertTrue(footer.verifyCompanyDescriptionText("Empowering online shopping"),
				"Company description text verification failed");
		softAssert.assertTrue(footer.verifySupportEmailText("support@ecoders.com"),
				"Support email verification failed");
		softAssert.assertTrue(footer.verifySupportPhoneText("+91 90000 00000"), "Support phone verification failed");
		softAssert.assertTrue(footer.verifyWorkingHoursText("Mon–Sat • 9:00 AM – 7:00 PM"),
				"Working hours verification failed");
		softAssert.assertTrue(footer.verifyLocationText("Bengaluru, Karnataka, India"), "Location verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testVerifyCompanyLinksSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyCompanyLinksSectionIsDisplayed(), "Company links section is not displayed");
		softAssert.assertTrue(footer.verifyCompanySectionHeadingText("Company"),
				"Company section heading verification failed");
		softAssert.assertTrue(footer.verifyFooterAboutUsLinkIsDisplayed(), "About Us link is not displayed");
		softAssert.assertTrue(footer.verifyFooterContactUsLinkIsDisplayed(), "Contact Us link is not displayed");
		softAssert.assertTrue(footer.verifyFooterCareersLinkIsDisplayed(), "Careers link is not displayed");
		softAssert.assertTrue(footer.verifyFooterBlogsLinkIsDisplayed(), "Blogs link is not displayed");
		softAssert.assertTrue(footer.verifyTotalCompanyLinksCount(4), "Company links count mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testVerifySecurePaymentsCardSection() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySecurePaymentsCardIsDisplayed(), "Secure Payments card is not displayed");
		softAssert.assertTrue(footer.verifySecurePaymentsHeadingText("Secure Payments"),
				"Secure Payments heading verification failed");
		softAssert.assertTrue(footer.verifyPaymentIconsBlockIsDisplayed(), "Payment icons block is not displayed");
		softAssert.assertTrue(footer.verifyPaymentInfoText("Multiple payment options supported"),
				"Payment info text verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testVerifySupportLinksSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySupportLinksSectionIsDisplayed(), "Support links section is not displayed");
		softAssert.assertTrue(footer.verifySupportSectionHeadingText("Support"),
				"Support section heading verification failed");
		softAssert.assertTrue(footer.verifyFooterHelpCenterLinkIsDisplayed(), "Help Center link is not displayed");
		softAssert.assertTrue(footer.verifyFooterPrivacyPolicyLinkIsDisplayed(),
				"Privacy Policy link is not displayed");
		softAssert.assertTrue(footer.verifyFooterTermsOfServiceLinkIsDisplayed(),
				"Terms of Service link is not displayed");
		softAssert.assertTrue(footer.verifyTotalSupportLinksCount(3), "Support links count mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testVerifySubscribeTipCardTexts() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscribeTipCardIsDisplayed(), "Subscribe tip card is not displayed");
		softAssert.assertTrue(footer.verifySubscribeTipHeadingText("Tip: Subscribe to get deal alerts"),
				"Subscribe tip heading verification failed");
		softAssert.assertTrue(footer.verifySubscribeTipSubText("New arrivals"),
				"Subscribe tip subtext verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testVerifyFollowAndSubscribeSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFollowAndSubscribeSectionIsDisplayed(),
				"Follow and Subscribe section is not displayed");
		softAssert.assertTrue(footer.verifyFollowAndSubscribeHeadingText("Follow & Subscribe"),
				"Follow and Subscribe heading verification failed");
		softAssert.assertTrue(footer.verifySocialIconsContainerIsDisplayed(),
				"Social icons container is not displayed");
		softAssert.assertTrue(footer.verifyTotalSocialLinksCount(6), "Social links count mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void testVerifyAllSocialLinksDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFooterFacebookLinkIsDisplayed(), "Facebook link is not displayed");
		softAssert.assertTrue(footer.verifyFooterTwitterLinkIsDisplayed(), "Twitter link is not displayed");
		softAssert.assertTrue(footer.verifyFooterGithubLinkIsDisplayed(), "Github link is not displayed");
		softAssert.assertTrue(footer.verifyFooterLinkedinLinkIsDisplayed(), "Linkedin link is not displayed");
		softAssert.assertTrue(footer.verifyFooterInstagramLinkIsDisplayed(), "Instagram link is not displayed");
		softAssert.assertTrue(footer.verifyFooterYoutubeLinkIsDisplayed(), "Youtube link is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 14, enabled = true, invocationCount = 1)
	public void testVerifySubscriptionFormSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifySubscribeContainerIsDisplayed(), "Subscribe container is not displayed");
		softAssert.assertTrue(footer.verifySubscribeFormHeading("Subscribe for Updates"),
				"Subscribe form heading verification failed");
		softAssert.assertTrue(footer.verifySubscribeFormCardIsDisplayed(), "Subscribe form card is not displayed");
		softAssert.assertTrue(footer.verifySubscriptionFormIsDisplayed(), "Subscription form is not displayed");
		softAssert.assertTrue(footer.verifySubscriptionEmailTextFieldIsDisplayed(),
				"Subscription email field is not displayed");
		softAssert.assertTrue(footer.verifySubscriptionButtonIsDisplayed(), "Subscription button is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 15, enabled = true, invocationCount = 1)
	public void testVerifyFooterBottomSectionDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyFooterBottomSectionIsDisplayed(), "Footer bottom section is not displayed");
		softAssert.assertTrue(footer.verifySecureFastReliableBlockIsDisplayed(),
				"Secure fast reliable block is not displayed");

		softAssert.assertAll();
	}

	@Test(priority = 16, enabled = true, invocationCount = 1)
	public void testVerifyFooterBottomTexts() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.verifyCopyrightText("©"), "Copyright text verification failed");
		softAssert.assertTrue(footer.verifySecureFastReliableText("Secure.Fast.Reliable"),
				"Secure fast reliable text verification failed");
		softAssert.assertTrue(footer.verifyFooterTaglineText("Empowering online shopping — one click at a time."),
				"Footer tagline verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void testClickFooterAboutUsLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterAboutUsLink(), "Failed to click About Us link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/about-us"),
				"About Us page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 18, enabled = true, invocationCount = 1)
	public void testClickFooterContactUsLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterContactUsLink(), "Failed to click Contact Us link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/contact-us"),
				"Contact Us page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 19, enabled = true, invocationCount = 1)
	public void testClickFooterCareersLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterCareersLink(), "Failed to click Careers link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/careers"),
				"Careers page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 20, enabled = true, invocationCount = 1)
	public void testClickFooterBlogsLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterBlogsLink(), "Failed to click Blogs link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/all-blogs"),
				"Blogs page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 21, enabled = true, invocationCount = 1)
	public void testClickFooterHelpCenterLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterHelpCenterLink(), "Failed to click Help Center link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/help-center"),
				"Help Center page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 22, enabled = true, invocationCount = 1)
	public void testClickFooterPrivacyPolicyLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterPrivacyPolicyLink(), "Failed to click Privacy Policy link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/privacy-policy"),
				"Privacy Policy page URL verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 23, enabled = true, invocationCount = 1)
	public void testClickFooterTermsOfServiceLinkAndVerifyNavigation() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		driver.navigate().to(URL_HOME);

		Footer footer = new Footer(driver);

		softAssert.assertTrue(footer.clickOnFooterTermsOfServiceLink(), "Failed to click Terms of Service link");
		softAssert.assertTrue(footer.verifyUrlOfWebpage("http://localhost:5173/terms-of-service"),
				"Terms of Service page URL verification failed");

		softAssert.assertAll();
	}
}