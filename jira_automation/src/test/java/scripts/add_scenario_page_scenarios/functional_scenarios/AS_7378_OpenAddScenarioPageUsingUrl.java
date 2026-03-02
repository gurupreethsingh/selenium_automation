package scripts.add_scenario_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AddScenarioPage;

public class AS_7378_OpenAddScenarioPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAddScenarioPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AddScenarioPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/add-scenario");

		AddScenarioPage page = new AddScenarioPage(driver);
		page.verifyAddScenarioPageTitle(expectedTitle);
	}
}
