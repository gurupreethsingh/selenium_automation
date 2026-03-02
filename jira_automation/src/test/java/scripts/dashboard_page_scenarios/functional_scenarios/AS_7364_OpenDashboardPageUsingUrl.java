package scripts.dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DashboardPage;

public class AS_7364_OpenDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("DashboardPage", 1, 0);

		driver.get(URL_DASHBOARD);

		DashboardPage page = new DashboardPage(driver);
		page.verifyDashboardPageTitle(expectedTitle);
	}
}
