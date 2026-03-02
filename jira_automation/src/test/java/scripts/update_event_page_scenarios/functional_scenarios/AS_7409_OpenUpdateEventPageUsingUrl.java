package scripts.update_event_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UpdateEventPage;

public class AS_7409_OpenUpdateEventPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUpdateEventPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UpdateEventPage", 1, 0);

		driver.get(URL_UPDATE_EVENT_BASE + "000000000000000000000000");

		UpdateEventPage page = new UpdateEventPage(driver);
		page.verifyUpdateEventPageTitle(expectedTitle);
	}
}
