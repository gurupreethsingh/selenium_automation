package scripts.view_assigned_tasks_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ViewAssignedTasksPage;

public class AS_7389_OpenViewAssignedTasksPageUsingUrl extends OpenClose {

	@Test
	public void testOpenViewAssignedTasksPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ViewAssignedTasksPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/user-assigned-tasks/" + "66d849960093c94b4cee0381");

		ViewAssignedTasksPage page = new ViewAssignedTasksPage(driver);
		page.verifyViewAssignedTasksPageTitle(expectedTitle);
	}
}
