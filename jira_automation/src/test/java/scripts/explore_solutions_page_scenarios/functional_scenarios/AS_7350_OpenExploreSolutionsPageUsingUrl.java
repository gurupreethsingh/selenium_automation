package scripts.explore_solutions_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ExploreSolutionsPage;

public class AS_7350_OpenExploreSolutionsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenExploreSolutionsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ExploreSolutionsPage", 1, 0);

		driver.get(URL_EXPLORE_SOLUTIONS);

		ExploreSolutionsPage page = new ExploreSolutionsPage(driver);
		page.verifyExploreSolutionsPageTitle(expectedTitle);
	}
}
