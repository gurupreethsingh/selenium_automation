package scripts.all_blogs_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllBlogsPage;

public class AS_7361_OpenAllBlogsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllBlogsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllBlogsPage", 1, 0);

		driver.get(URL_ALL_BLOGS);

		AllBlogsPage page = new AllBlogsPage(driver);
		page.verifyAllBlogsPageTitle(expectedTitle);
	}
}
