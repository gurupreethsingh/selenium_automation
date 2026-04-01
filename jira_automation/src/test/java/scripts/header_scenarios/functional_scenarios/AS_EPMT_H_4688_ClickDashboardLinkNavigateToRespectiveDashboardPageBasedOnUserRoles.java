package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_4688_ClickDashboardLinkNavigateToRespectiveDashboardPageBasedOnUserRoles extends OpenClose {

	@Test
	public void testClickDashboardLinkFromHeaderNavigateToRespectiveDashboardPagesBasedOnUserRoles()
			throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard dropdown option text verification failed.");

		softAssert.assertTrue(header.clickOnDashboardLinkFromDropdown(),
				"Failed to click Dashboard link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*dashboard.*", "Dashboard Page"),
				"Respective dashboard page did not load properly.");

		softAssert.assertAll();
	}
}