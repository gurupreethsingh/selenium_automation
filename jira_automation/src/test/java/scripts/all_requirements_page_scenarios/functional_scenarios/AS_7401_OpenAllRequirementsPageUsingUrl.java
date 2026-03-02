package scripts.all_requirements_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllRequirementsPage;

public class AS_7401_OpenAllRequirementsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllRequirementsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllRequirementsPage", 1, 0);

		driver.get(URL_ALL_REQUIREMENTS_BASE + "69a58f3a326ce82d2a693069");

		AllRequirementsPage page = new AllRequirementsPage(driver);
		page.verifyAllRequirementsPageTitle(expectedTitle);
	}
}
