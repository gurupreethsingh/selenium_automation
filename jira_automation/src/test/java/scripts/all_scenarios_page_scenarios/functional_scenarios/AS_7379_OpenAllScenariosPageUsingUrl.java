package scripts.all_scenarios_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllScenariosPage;

public class AS_7379_OpenAllScenariosPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllScenariosPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllScenariosPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/view-all-scenarios");

		AllScenariosPage page = new AllScenariosPage(driver);
		page.verifyAllScenariosPageTitle(expectedTitle);
	}
}
