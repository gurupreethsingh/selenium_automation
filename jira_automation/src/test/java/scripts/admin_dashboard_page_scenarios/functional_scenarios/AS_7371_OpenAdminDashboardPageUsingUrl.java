package scripts.admin_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AdminDashboardPage;

public class AS_7371_OpenAdminDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAdminDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AdminDashboardPage", 1, 0);

		driver.get(URL_ADMIN_DASHBOARD);

		AdminDashboardPage page = new AdminDashboardPage(driver);
		page.verifyAdminDashboardPageTitle(expectedTitle);
	}
}
