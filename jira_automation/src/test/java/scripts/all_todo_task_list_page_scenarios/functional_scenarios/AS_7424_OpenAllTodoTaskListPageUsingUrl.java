package scripts.all_todo_task_list_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllTodoTaskListPage;

public class AS_7424_OpenAllTodoTaskListPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllTodoTaskListPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllTodoTaskListPage", 1, 0);

		driver.get(URL_VIEW_ALL_TODO_LIST);

		AllTodoTaskListPage page = new AllTodoTaskListPage(driver);
		page.verifyAllTodoTaskListPageTitle(expectedTitle);
	}
}
