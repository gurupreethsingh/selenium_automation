package scripts.scenario_history_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ScenarioHistoryPage;

public class AS_7380_OpenScenarioHistoryPageUsingUrl extends OpenClose {

	@Test
	public void testOpenScenarioHistoryPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ScenarioHistoryPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/scenario-history/" + "000000000000000000000000");

		ScenarioHistoryPage page = new ScenarioHistoryPage(driver);
		page.verifyScenarioHistoryPageTitle(expectedTitle);
	}
}
