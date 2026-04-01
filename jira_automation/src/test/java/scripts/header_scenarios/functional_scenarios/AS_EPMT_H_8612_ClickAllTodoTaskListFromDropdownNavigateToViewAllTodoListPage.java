package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_8612_ClickAllTodoTaskListFromDropdownNavigateToViewAllTodoListPage extends OpenClose {

	@Test
	public void testClickAllTodoTaskListFromDropdownNavigateToViewAllTodoListPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks dropdown text verification failed.");

		softAssert.assertTrue(header.clickOnViewAllToDoTasksLinkFromDropdown(),
				"Failed to click View All ToDo Tasks link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*todo.*", "View All Todo List Page"),
				"View All Todo List page did not load properly.");

		softAssert.assertAll();
	}
}