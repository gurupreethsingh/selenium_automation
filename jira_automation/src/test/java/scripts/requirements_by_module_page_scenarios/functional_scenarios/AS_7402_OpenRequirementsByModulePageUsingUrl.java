package scripts.requirements_by_module_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.RequirementsByModulePage;

public class AS_7402_OpenRequirementsByModulePageUsingUrl extends OpenClose {

	@Test
	public void testOpenRequirementsByModulePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("RequirementsByModulePage", 1, 0);

		driver.get(URL_ALL_REQUIREMENTS_BASE + "69a58f3a326ce82d2a693069" + "/module/" + "Header");

		RequirementsByModulePage page = new RequirementsByModulePage(driver);
		page.verifyRequirementsByModulePageTitle(expectedTitle);
	}
}
