package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_8157_ClickProfileFromDropdownNavigateToProfilePage extends OpenClose {

	@Test
	public void testClickProfileFromDropdownNavigateToProfilePage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"),
				"Profile dropdown text verification failed.");

		softAssert.assertTrue(header.clickOnProfileLinkFromDropdown(), "Failed to click Profile link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*profile.*", "Profile Page"),
				"Profile page did not load properly.");

		softAssert.assertAll();
	}
}