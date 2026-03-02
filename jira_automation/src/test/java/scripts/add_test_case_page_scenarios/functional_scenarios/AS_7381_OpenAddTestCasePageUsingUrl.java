package scripts.add_test_case_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AddTestCasePage;

public class AS_7381_OpenAddTestCasePageUsingUrl extends OpenClose {

	@Test
	public void testOpenAddTestCasePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AddTestCasePage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/scenario/" + "000000000000000000000000" + "/add-test-case");

		AddTestCasePage page = new AddTestCasePage(driver);
		page.verifyAddTestCasePageTitle(expectedTitle);
	}
}
