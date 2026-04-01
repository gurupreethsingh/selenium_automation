package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_6648_ClickUserAvatarLoginIconFromHeaderNavigateToLoginSignInPage extends OpenClose {

	@Test
	public void testClickUserAvatarLoginIconFromHeaderOfHomepageUserShouldNavigateToLoginSignInPage()
			throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnUserAvatarLoginIcon(),
				"Failed to click User Avatar Login icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*(login|sign-in).*", "Login / Sign In Page"),
				"Login / Sign In page did not load properly after clicking User Avatar Login icon.");

		softAssert.assertAll();
	}
}