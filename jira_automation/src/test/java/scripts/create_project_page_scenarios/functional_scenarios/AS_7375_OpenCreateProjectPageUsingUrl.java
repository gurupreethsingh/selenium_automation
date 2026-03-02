package scripts.create_project_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateProjectPage;

public class AS_7375_OpenCreateProjectPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateProjectPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateProjectPage", 1, 0);

		driver.get(URL_CREATE_PROJECT);

		CreateProjectPage page = new CreateProjectPage(driver);
		page.verifyCreateProjectPageTitle(expectedTitle);
	}
}
