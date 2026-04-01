package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_9827_VerifyTotalOptionsAndNamesInUserNameDropdown extends OpenClose {

	@Test
	public void testVerifyTotalOptionsInUserNameDropdownIsFiveAndNamesAreCorrect() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By totalVisibleDropdownOptionsLocator = By.cssSelector("header div.absolute.right-0 > div:nth-of-type(-n+5)");

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.verifyTotalElementsCount(5, totalVisibleDropdownOptionsLocator),
				"Total dropdown options count is not 5.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"),
				"Profile dropdown option text verification failed.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks dropdown option text verification failed.");

		softAssert.assertTrue(header.getCreateToDoTaskListLinkTextFromDropdown("Create To Do Task List"),
				"Create To Do Task List dropdown option text verification failed.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard dropdown option text verification failed.");

		softAssert.assertTrue(header.getLogoutButtonTextFromDropdown("Logout"),
				"Logout dropdown option text verification failed.");

		softAssert.assertAll();
	}
}