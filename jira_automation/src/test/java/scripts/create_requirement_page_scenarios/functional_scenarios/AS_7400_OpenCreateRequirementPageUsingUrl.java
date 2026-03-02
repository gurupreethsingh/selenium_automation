package scripts.create_requirement_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateRequirementPage;

public class AS_7400_OpenCreateRequirementPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateRequirementPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateRequirementPage", 1, 0);

		driver.get(URL_CREATE_REQUIREMENT_BASE + "69a58f3a326ce82d2a693069");

		CreateRequirementPage page = new CreateRequirementPage(driver);
		page.verifyCreateRequirementPageTitle(expectedTitle);
	}
}
