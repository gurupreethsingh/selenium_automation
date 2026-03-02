package scripts.developer_lead_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DeveloperLeadDashboardPage;

public class AS_7399_OpenDeveloperLeadDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenDeveloperLeadDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("DeveloperLeadDashboardPage", 1, 0);

		driver.get(URL_DEVELOPER_LEAD_DASHBOARD);

		DeveloperLeadDashboardPage page = new DeveloperLeadDashboardPage(driver);
		page.verifyDeveloperLeadDashboardPageTitle(expectedTitle);
	}
}
