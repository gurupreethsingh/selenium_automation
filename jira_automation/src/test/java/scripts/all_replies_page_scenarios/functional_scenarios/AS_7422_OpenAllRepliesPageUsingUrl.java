package scripts.all_replies_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllRepliesPage;

public class AS_7422_OpenAllRepliesPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllRepliesPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllRepliesPage", 1, 0);

		driver.get(URL_ALL_REPLIES);

		AllRepliesPage page = new AllRepliesPage(driver);
		page.verifyAllRepliesPageTitle(expectedTitle);
	}
}
