package scripts.single_project_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleProjectPage;

public class AS_7377_OpenSingleProjectPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleProjectPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleProjectPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069");

		SingleProjectPage page = new SingleProjectPage(driver);
		page.verifySingleProjectPageTitle(expectedTitle);
	}
}
