package scripts.developer_assigned_defects_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DeveloperAssignedDefectsPage;

public class AS_7396_OpenDeveloperAssignedDefectsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenDeveloperAssignedDefectsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("DeveloperAssignedDefectsPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/developer/" + "000000000000000000000000" + "/view-assigned-defects");

		DeveloperAssignedDefectsPage page = new DeveloperAssignedDefectsPage(driver);
		page.verifyDeveloperAssignedDefectsPageTitle(expectedTitle);
	}
}
