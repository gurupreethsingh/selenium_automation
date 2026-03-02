package scripts.single_requirement_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleRequirementPage;

public class AS_7404_OpenSingleRequirementPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleRequirementPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleRequirementPage", 1, 0);

		driver.get(URL_SINGLE_REQUIREMENT_BASE + "000000000000000000000000");

		SingleRequirementPage page = new SingleRequirementPage(driver);
		page.verifySingleRequirementPageTitle(expectedTitle);
	}
}
