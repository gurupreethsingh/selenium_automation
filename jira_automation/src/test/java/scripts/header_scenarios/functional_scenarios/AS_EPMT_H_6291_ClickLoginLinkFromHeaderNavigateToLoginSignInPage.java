package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_6291_ClickLoginLinkFromHeaderNavigateToLoginSignInPage extends OpenClose {

	@Test
	public void testClickLoginLinkFromHeaderOfHomepageUserShouldNavigateToLoginSignInPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getLoginText("Login"), "Login text verification failed before click.");

		softAssert.assertTrue(header.clickOnLoginTextLink(), "Failed to click Login text link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*(login|sign-in).*", "Login / Sign In Page"),
				"Login / Sign In page did not load properly after clicking Login link.");

		softAssert.assertAll();
	}
}