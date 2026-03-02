package scripts.module_requirements_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ModuleRequirementsPage;

public class AS_7403_OpenModuleRequirementsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenModuleRequirementsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ModuleRequirementsPage", 1, 0);

		driver.get(URL_MODULE_REQUIREMENTS_BASE + "69a58f3a326ce82d2a693069" + "/" + "Header");

		ModuleRequirementsPage page = new ModuleRequirementsPage(driver);
		page.verifyModuleRequirementsPageTitle(expectedTitle);
	}
}
