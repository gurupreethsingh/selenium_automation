package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_2807_VerifyAllUsersLinkDisappearsWhenSuperAdminLogsOut extends OpenClose {

	@Test
	public void testVerifyAllUsersLinkDisappearsInHeaderNavigationWhenSuperAdminLogsOut() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By allUsersLinkLocator = By.cssSelector("div.flex.items-center.gap-5 a[href='/all-users']");

		softAssert.assertTrue(header.getAllUsersLinkText("All Users"), "All Users link is not visible before logout.");

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.clickOnLogoutButtonFromDropdown(), "Failed to click Logout button from dropdown.");

		softAssert.assertFalse(header.isElementPresentInDOM(allUsersLinkLocator),
				"All Users link is still visible after superadmin logout.");

		softAssert.assertAll();
	}
}