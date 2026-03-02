package scripts.single_blog_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleBlogPage;

public class AS_7362_OpenSingleBlogPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleBlogPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleBlogPage", 1, 0);

		driver.get(URL_SINGLE_BLOG_BASE + "test-slug" + "/" + "000000000000000000000000");

		SingleBlogPage page = new SingleBlogPage(driver);
		page.verifySingleBlogPageTitle(expectedTitle);
	}
}
