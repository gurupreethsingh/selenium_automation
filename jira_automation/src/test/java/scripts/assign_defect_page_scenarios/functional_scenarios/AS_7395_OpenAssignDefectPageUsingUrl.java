package scripts.assign_defect_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AssignDefectPage;

public class AS_7395_OpenAssignDefectPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAssignDefectPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AssignDefectPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/assign-defect/" + "000000000000000000000000");

		AssignDefectPage page = new AssignDefectPage(driver);
		page.verifyAssignDefectPageTitle(expectedTitle);
	}
}
