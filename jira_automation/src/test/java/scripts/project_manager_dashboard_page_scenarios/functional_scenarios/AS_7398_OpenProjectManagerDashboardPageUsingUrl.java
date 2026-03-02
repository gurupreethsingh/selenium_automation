package scripts.project_manager_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ProjectManagerDashboardPage;

public class AS_7398_OpenProjectManagerDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenProjectManagerDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ProjectManagerDashboardPage", 1, 0);

		driver.get(URL_PROJECT_MANAGER_DASHBOARD);

		ProjectManagerDashboardPage page = new ProjectManagerDashboardPage(driver);
		page.verifyProjectManagerDashboardPageTitle(expectedTitle);
	}
}
