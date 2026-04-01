package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_6865_ClickCareersLinkFromHeaderNavigateToCareersPage extends OpenClose {

	@Test
	public void testClickCareersLinkFromHeaderOfHomepageUserShouldNavigateToCareersPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getCareersLinkText("Careers"),
				"Careers link text verification failed before click.");

		softAssert.assertTrue(header.getCareersLinkHref("/careers"),
				"Careers link href verification failed before click.");

		softAssert.assertTrue(header.clickOnCareersLink(), "Failed to click Careers link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/careers", "Careers Page"),
				"Careers page did not load properly after clicking Careers link.");

		softAssert.assertAll();
	}
}