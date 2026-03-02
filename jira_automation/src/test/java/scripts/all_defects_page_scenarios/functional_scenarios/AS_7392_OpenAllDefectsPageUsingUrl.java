package scripts.all_defects_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllDefectsPage;

public class AS_7392_OpenAllDefectsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllDefectsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllDefectsPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/all-defects");

		AllDefectsPage page = new AllDefectsPage(driver);
		page.verifyAllDefectsPageTitle(expectedTitle);
	}
}
