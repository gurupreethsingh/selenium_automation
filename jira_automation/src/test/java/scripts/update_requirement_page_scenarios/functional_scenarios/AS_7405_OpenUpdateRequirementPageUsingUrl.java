package scripts.update_requirement_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UpdateRequirementPage;

public class AS_7405_OpenUpdateRequirementPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUpdateRequirementPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UpdateRequirementPage", 1, 0);

		driver.get(URL_UPDATE_REQUIREMENT_BASE + "000000000000000000000000");

		UpdateRequirementPage page = new UpdateRequirementPage(driver);
		page.verifyUpdateRequirementPageTitle(expectedTitle);
	}
}
