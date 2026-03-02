package scripts.defect_details_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DefectDetailsPage;

public class AS_7393_OpenDefectDetailsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenDefectDetailsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("DefectDetailsPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/defect/" + "000000000000000000000000");

		DefectDetailsPage page = new DefectDetailsPage(driver);
		page.verifyDefectDetailsPageTitle(expectedTitle);
	}
}
