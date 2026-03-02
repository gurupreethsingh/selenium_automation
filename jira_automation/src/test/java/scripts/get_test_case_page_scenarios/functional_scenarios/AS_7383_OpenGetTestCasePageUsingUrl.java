package scripts.get_test_case_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.GetTestCasePage;

public class AS_7383_OpenGetTestCasePageUsingUrl extends OpenClose {

	@Test
	public void testOpenGetTestCasePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("GetTestCasePage", 1, 0);

		driver.get(URL_GET_TEST_CASE_BASE + "000000000000000000000000");

		GetTestCasePage page = new GetTestCasePage(driver);
		page.verifyGetTestCasePageTitle(expectedTitle);
	}
}
