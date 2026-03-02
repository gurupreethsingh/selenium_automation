package scripts.developer_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DeveloperDashboardPage;

public class AS_7374_OpenDeveloperDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenDeveloperDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("DeveloperDashboardPage", 1, 0);

		driver.get(URL_DEVELOPER_DASHBOARD);

		DeveloperDashboardPage page = new DeveloperDashboardPage(driver);
		page.verifyDeveloperDashboardPageTitle(expectedTitle);
	}
}
