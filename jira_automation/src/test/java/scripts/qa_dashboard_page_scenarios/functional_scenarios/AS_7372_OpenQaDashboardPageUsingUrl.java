package scripts.qa_dashboard_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.QaDashboardPage;

public class AS_7372_OpenQaDashboardPageUsingUrl extends OpenClose {

	@Test
	public void testOpenQaDashboardPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("QaDashboardPage", 1, 0);

		driver.get(URL_QA_DASHBOARD);

		QaDashboardPage page = new QaDashboardPage(driver);
		page.verifyQaDashboardPageTitle(expectedTitle);
	}
}
