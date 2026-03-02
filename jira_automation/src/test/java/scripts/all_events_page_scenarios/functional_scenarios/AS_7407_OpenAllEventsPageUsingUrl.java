package scripts.all_events_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllEventsPage;

public class AS_7407_OpenAllEventsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllEventsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllEventsPage", 1, 0);

		driver.get(URL_ALL_EVENTS);

		AllEventsPage page = new AllEventsPage(driver);
		page.verifyAllEventsPageTitle(expectedTitle);
	}
}
