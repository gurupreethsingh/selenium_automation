package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_1410_ClickAboutUsLinkFromHeaderNavigateToAboutUsPage extends OpenClose {

	@Test
	public void testClickAboutUsLinkFromHeaderOfHomepageUserShouldNavigateToAboutUsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getAboutUsLinkText("About Us"),
				"About Us link text verification failed before click.");

		softAssert.assertTrue(header.getAboutUsLinkHref("/about-us"),
				"About Us link href verification failed before click.");

		softAssert.assertTrue(header.clickOnAboutUsLink(), "Failed to click About Us link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/about-us", "About Us Page"),
				"About Us page did not load properly after clicking About Us link.");

		softAssert.assertAll();
	}
}