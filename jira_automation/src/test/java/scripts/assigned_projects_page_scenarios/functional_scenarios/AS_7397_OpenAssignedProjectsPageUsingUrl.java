package scripts.assigned_projects_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AssignedProjectsPage;

public class AS_7397_OpenAssignedProjectsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAssignedProjectsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AssignedProjectsPage", 1, 0);

		driver.get(URL_USER_ASSIGNED_PROJECTS_BASE + "66d849960093c94b4cee0381");

		AssignedProjectsPage page = new AssignedProjectsPage(driver);
		page.verifyAssignedProjectsPageTitle(expectedTitle);
	}
}
