package scripts.all_projects_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllProjectsPage;

public class AS_7376_OpenAllProjectsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllProjectsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllProjectsPage", 1, 0);

		driver.get(URL_ALL_PROJECTS);

		AllProjectsPage page = new AllProjectsPage(driver);
		page.verifyAllProjectsPageTitle(expectedTitle);
	}
}
