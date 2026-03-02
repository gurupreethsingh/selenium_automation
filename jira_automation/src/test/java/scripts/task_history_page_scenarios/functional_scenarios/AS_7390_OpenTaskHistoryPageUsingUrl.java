package scripts.task_history_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.TaskHistoryPage;

public class AS_7390_OpenTaskHistoryPageUsingUrl extends OpenClose {

	@Test
	public void testOpenTaskHistoryPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("TaskHistoryPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/single-task/" + "000000000000000000000000");

		TaskHistoryPage page = new TaskHistoryPage(driver);
		page.verifyTaskHistoryPageTitle(expectedTitle);
	}
}
