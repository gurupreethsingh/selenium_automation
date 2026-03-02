package scripts.create_todo_list_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateTodoListPage;

public class AS_7423_OpenCreateTodoListPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateTodoListPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateTodoListPage", 1, 0);

		driver.get(URL_CREATE_TODO_LIST);

		CreateTodoListPage page = new CreateTodoListPage(driver);
		page.verifyCreateTodoListPageTitle(expectedTitle);
	}
}
