package scripts.all_test_cases_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllTestCasesPage;

public class AS_7382_OpenAllTestCasesPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllTestCasesPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllTestCasesPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/all-test-cases");

		AllTestCasesPage page = new AllTestCasesPage(driver);
		page.verifyAllTestCasesPageTitle(expectedTitle);
	}
}
