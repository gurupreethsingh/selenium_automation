package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_5647_VerifyAllDropdownOptionsAreDisplayedWhenUserNameDropdownIsClicked extends OpenClose {

	@Test
	public void testVerifyAllDropdownOptionsAreDisplayedWhenUserNameDropdownIsClicked() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getAllDropdownOptions(), "All dropdown options are not displayed.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"), "Profile option is not displayed.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks option is not displayed.");

		softAssert.assertTrue(header.getCreateToDoTaskListLinkTextFromDropdown("Create To Do Task List"),
				"Create To Do Task List option is not displayed.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard option is not displayed.");

		softAssert.assertTrue(header.getLogoutButtonTextFromDropdown("Logout"), "Logout option is not displayed.");

		softAssert.assertAll();
	}
}