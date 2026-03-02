package scripts.update_blog_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UpdateBlogPage;

public class AS_7363_OpenUpdateBlogPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUpdateBlogPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UpdateBlogPage", 1, 0);

		driver.get(URL_UPDATE_BLOG_BASE + "test-slug" + "/" + "000000000000000000000000");

		UpdateBlogPage page = new UpdateBlogPage(driver);
		page.verifyUpdateBlogPageTitle(expectedTitle);
	}
}
