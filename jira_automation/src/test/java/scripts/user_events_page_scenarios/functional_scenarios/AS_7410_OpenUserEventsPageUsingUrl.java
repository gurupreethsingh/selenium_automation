package scripts.user_events_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UserEventsPage;

public class AS_7410_OpenUserEventsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUserEventsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UserEventsPage", 1, 0);

		driver.get(URL_USER_EVENTS);

		UserEventsPage page = new UserEventsPage(driver);
		page.verifyUserEventsPageTitle(expectedTitle);
	}
}
