package scripts.bug_history_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.BugHistoryPage;

public class AS_7394_OpenBugHistoryPageUsingUrl extends OpenClose {

	@Test
	public void testOpenBugHistoryPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("BugHistoryPage", 1, 0);

		driver.get(URL_BUG_HISTORY_BASE + "000000000000000000000000");

		BugHistoryPage page = new BugHistoryPage(driver);
		page.verifyBugHistoryPageTitle(expectedTitle);
	}
}
