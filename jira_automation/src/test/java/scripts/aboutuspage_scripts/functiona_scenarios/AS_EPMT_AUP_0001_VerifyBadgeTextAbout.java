package scripts.aboutuspage_scripts.functiona_scenarios;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.AboutUsPage;
import pom.HomePage;

public class AS_EPMT_AUP_0001_VerifyBadgeTextAbout extends OpenClose {
	@Test
	public void verifyAboutBadgeTextInHeroSectionOfAboutUsPage() throws InterruptedException {
		// you will be in homepage.
		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = "Home | ECODERS";
		hp.verifyHomePageTitle(expectedHomePageTitle);

		// you navigate to about us page.
		driver.navigate().to(URL_ABOUT_US);

		AboutUsPage aup = new AboutUsPage(driver);
		String expectedAboutUsPageTitle = "About Us | ECODERS";
		aup.verifyAboutUsPageTitle(expectedAboutUsPageTitle);
		Thread.sleep(2000);

		String expectedBadgeText = "ABOUT";
		aup.verifyTextOfAboutBadgeInHeroSection(expectedBadgeText);

		Thread.sleep(2000);
	}
}
