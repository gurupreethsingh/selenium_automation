package scripts.aboutuspage_scripts.functiona_scenarios;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.AboutUsPage;

public class AS_EPMT_AUP_0003_VerifyBadgeTextBlockchain extends OpenClose {
	@Test
	public void verifyBlockChainBadgeTextInHeroSectionOfAboutUsPage() throws InterruptedException {
		// you will be in homepage.

		// you navigate to about us page.

		driver.navigate().to(URL_ABOUT_US);
		driver.getTitle();

		Thread.sleep(2000);

		// verify about badge text.

		AboutUsPage aup = new AboutUsPage(driver);

		String expectedBadgeText = "BLOCKCHAIN";
		aup.verifyTextOfBlockchainBadgeInHeroSection(expectedBadgeText);

		Thread.sleep(2000);
	}

}
