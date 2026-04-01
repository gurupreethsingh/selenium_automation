package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Header;
import pom.HomePage;

public class AS_EPMT_H_2567_ClickAppNameReloadHomepage extends OpenClose {

	@Test
	public void testClickLogoFromHeaderOfHomepageVerifyReloadingOfHomepage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage homepage = new HomePage(driver);
		Header header = new Header(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = "/home";

		// Step 1: verify homePage title before click
		boolean homeTitleVerifiedBeforeClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedBeforeClick,
				"Homepage title verification failed before clicking application name.");

		// Step 2: verify logo is clickable
		boolean appNameClickedAndReloadVerified = header.verifyPageReloadAfterAction(() -> header.clickOnLogo(),
				expectedHomePageTitle, expectedHomePageUrl, "Homepage Reload After Clicking Logo");

		softAssert.assertTrue(appNameClickedAndReloadVerified,
				"Homepage reload verification failed after clicking logo.");

		// Step 3: verify homePage title and url again after reload
		softAssert.assertTrue(homepage.verifyHomePageTitle(expectedHomePageTitle),
				"Homepage title verification failed after clicking logo.");
		softAssert.assertTrue(homepage.verifyHomePageUrl(expectedHomePageUrl),
				"Homepage url verification failed after clicking logo.");

		softAssert.assertAll();
	}
}