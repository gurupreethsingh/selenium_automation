package scripts.careers_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CareersPage;

public class AS_7360_OpenCareersPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCareersPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CareersPage", 1, 0);

		driver.get(URL_CAREERS);

		CareersPage page = new CareersPage(driver);
		page.verifyCareersPageTitle(expectedTitle);
	}
}
