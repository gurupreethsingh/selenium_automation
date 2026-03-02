package scripts.projects_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ProjectsPage;

public class AS_7349_OpenProjectsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenProjectsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ProjectsPage", 1, 0);

		driver.get(URL_PROJECTS);

		ProjectsPage page = new ProjectsPage(driver);
		page.verifyProjectsPageTitle(expectedTitle);
	}
}
