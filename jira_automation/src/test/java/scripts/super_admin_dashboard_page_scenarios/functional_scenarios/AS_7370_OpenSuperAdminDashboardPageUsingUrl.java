package scripts.super_admin_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SuperAdminDashboardPage;

public class AS_7370_OpenSuperAdminDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSuperAdminDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SuperAdminDashboardPage", 1, 0);

		driver.get(URL_SUPER_ADMIN_DASHBOARD);

		SuperAdminDashboardPage page = new SuperAdminDashboardPage(driver);
		page.verifySuperAdminDashboardPageTitle(expectedTitle);
	}
}
