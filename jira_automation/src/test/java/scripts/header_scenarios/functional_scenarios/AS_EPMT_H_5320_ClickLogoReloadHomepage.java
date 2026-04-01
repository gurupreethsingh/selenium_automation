package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Header;
import pom.HomePage;

public class AS_EPMT_H_5320_ClickLogoReloadHomepage extends OpenClose {

	@Test
	public void testClickAppNameLogoFromHeaderOfHomepageVerifyReloadingOfHomepage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage homepage = new HomePage(driver);
		Header header = new Header(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = "/home";

		// Step 1: verify homepage title before click
		boolean homeTitleVerifiedBeforeClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedBeforeClick,
				"Homepage title verification failed before clicking application name.");

		// Step 2: verify application name is clickable
		boolean appNameClickedAndReloadVerified = header.verifyPageReloadAfterAction(
				() -> header.clickOnApplicationName(), expectedHomePageTitle, expectedHomePageUrl,
				"Homepage Reload After Clicking Header Application Name");

		softAssert.assertTrue(appNameClickedAndReloadVerified,
				"Homepage reload verification failed after clicking application name.");

		// Step 3: verify homepage title again after reload
		boolean homeTitleVerifiedAfterClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedAfterClick,
				"Homepage title verification failed after clicking application name.");
		softAssert.assertTrue(homepage.verifyHomePageUrl(expectedHomePageUrl),
				"Homepage url verification failed after clicking application name.");

		softAssert.assertAll();
	}
}