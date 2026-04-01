package scripts.footer_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class FooterFullRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testVerifyFooterElementsAreVisibleAfterPageReload() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		driver.navigate().refresh();

		Footer footer = new Footer(driver);
		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible after page reload");
		sa.assertTrue(footer.getFooterLogoDisplayed(), "Footer logo is not visible after page reload");
		sa.assertTrue(footer.getAllFooterLinks(), "Footer links are not visible after page reload");

		sa.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testVerifyFooterLogoImageDisplayedCorrectlyInFooterSection() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterLogoDisplayed(), "Footer logo image is not displayed");

		sa.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testVerifyFooterLogoImageSourceUrlIsCorrect() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterLogoSource("ecoders_logo"), "Footer logo image source verification failed");

		sa.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifyFooterDescriptionTextDisplayedAndContainsExpectedContent()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterDescriptionText("Building modern software with engineering excellence"),
				"Footer description text verification failed");

		sa.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testClickAboutUSLinkFromFooterOfHomepageAndNavigateToABoutusPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterAboutUsLink(), "Click on about us link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/about-us"), "About Us page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testClickProjectsLinkFromFooterAndNavigateToProjectsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterProjectsLink(), "Click on Projects link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/projects"), "Projects page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testClickBlogsLinkFromFooterAndNavigateToAllBlogsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterBlogsLink(), "Click on Blogs link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/all-blogs"), "All Blogs page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClickCareersLinkFromFooterAndNavigateToCareersPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterCareersLink(), "Click on Careers link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/careers"), "Careers page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testClickExploreSolutionsLinkFromFooterAndNavigateToExploreSolutionsPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterExploreSolutionsLink(), "Click on Explore Solutions link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/explore-solutions"),
				"Explore Solutions page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testClickWebAppsLinkFromFooterAndNavigateToWebAppsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterWebAppsLink(), "Click on Web & Mobile Apps link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/web-apps"), "Web & Mobile Apps page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testClickQaAutomationLinkFromFooterAndNavigateToQaAutomationPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterQaAutomationLink(), "Click on QA Automation link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/qa-automation"), "QA Automation page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testClickAiSystemsLinkFromFooterAndNavigateToAiSystemsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterAiSystemsLink(), "Click on AI Systems link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/ai-systems"), "AI Systems page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void testClickBlockchainLinkFromFooterAndNavigateToBlockchainPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterBlockchainLink(), "Click on Blockchain link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/blockchain"), "Blockchain page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 14, enabled = true, invocationCount = 1)
	public void testClickContactLinkFromFooterAndNavigateToContactUsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterContactLink(), "Click on Contact Us link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/contact"), "Contact Us page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 15, enabled = true, invocationCount = 1)
	public void testClickPrivacyPolicyLinkFromFooterAndNavigateToPrivacyPolicyPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterPrivacyPolicyLink(), "Click on Privacy Policy link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/privacy-policy"), "Privacy Policy page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 16, enabled = true, invocationCount = 1)
	public void testClickLoginLinkFromFooterAndNavigateToLoginPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterLoginLink(), "Click on Login link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/login"), "Login page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void testClickRegisterLinkFromFooterAndNavigateToRegisterPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterRegisterLink(), "Click on Register link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/register"), "Register page URL verification failed");

		sa.assertAll();
	}

	@Test(priority = 18, enabled = true, invocationCount = 1)
	public void testVerifyAllAddressDetailsDisplayedCorrectlyInFooter() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getAllAddressSectionsDetails(), "Footer address details are not displayed");

		sa.assertAll();
	}

	@Test(priority = 19, enabled = true, invocationCount = 1)
	public void testVerifyFooterCopyrightTextDisplayedCorrectly() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);
		String expectedCopyrightText = "© 2019 Ecoders. All rights reserved.";

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterCopyrightText(expectedCopyrightText),
				"Footer copyright text verification failed");

		sa.assertAll();
	}

}
