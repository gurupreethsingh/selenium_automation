package scripts.assign_task_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AssignTaskPage;

public class AS_7387_OpenAssignTaskPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAssignTaskPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AssignTaskPage", 1, 0);

		driver.get(URL_ASSIGN_TASK_BASE + "69a58f3a326ce82d2a693069" + "/assign-task");

		AssignTaskPage page = new AssignTaskPage(driver);
		page.verifyAssignTaskPageTitle(expectedTitle);
	}
}
