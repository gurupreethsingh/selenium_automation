package scripts.all_messages_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllMessagesPage;

public class AS_7420_OpenAllMessagesPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllMessagesPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllMessagesPage", 1, 0);

		driver.get(URL_ALL_MESSAGES);

		AllMessagesPage page = new AllMessagesPage(driver);
		page.verifyAllMessagesPageTitle(expectedTitle);
	}
}
