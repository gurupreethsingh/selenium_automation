package scripts.add_defect_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AddDefectPage;

public class AS_7391_OpenAddDefectPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAddDefectPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AddDefectPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/add-defect");

		AddDefectPage page = new AddDefectPage(driver);
		page.verifyAddDefectPageTitle(expectedTitle);
	}
}
