package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_3417_ClickContactLinkFromHeaderNavigateToContactUsPage extends OpenClose {

	@Test
	public void testClickContactLinkFromHeaderOfHomepageUserShouldNavigateToContactUsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getContactLinkText("Contact"),
				"Contact link text verification failed before click.");

		softAssert.assertTrue(header.getContactLinkHref("/contact"),
				"Contact link href verification failed before click.");

		softAssert.assertTrue(header.clickOnContactLink(), "Failed to click Contact link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/contact", "Contact Us Page"),
				"Contact Us page did not load properly after clicking Contact link.");

		softAssert.assertAll();
	}
}