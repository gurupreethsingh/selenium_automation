package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_3210_VerifyUserNameAppearsNextToUserAvatarAfterLogin extends OpenClose {

	@Test
	public void testVerifyUserNameAppearsRightNextToUserAvatarOnceUserIsLoggedIn() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By userNameLocator = By.cssSelector("header button[aria-haspopup='menu'] span");

		softAssert.assertTrue(header.verifyElementPresentAndVisible(userNameLocator, "Header Dropdown User Name Text"),
				"User name is not visible next to the user avatar after login.");

		softAssert.assertAll();
	}
}