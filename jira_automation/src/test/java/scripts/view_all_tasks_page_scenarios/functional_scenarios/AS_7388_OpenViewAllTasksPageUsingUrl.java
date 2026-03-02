package scripts.view_all_tasks_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ViewAllTasksPage;

public class AS_7388_OpenViewAllTasksPageUsingUrl extends OpenClose {

	@Test
	public void testOpenViewAllTasksPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ViewAllTasksPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/view-all-tasks");

		ViewAllTasksPage page = new ViewAllTasksPage(driver);
		page.verifyViewAllTasksPageTitle(expectedTitle);
	}
}
