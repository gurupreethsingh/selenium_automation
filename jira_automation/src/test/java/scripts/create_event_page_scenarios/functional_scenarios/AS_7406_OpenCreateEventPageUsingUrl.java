package scripts.create_event_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateEventPage;

public class AS_7406_OpenCreateEventPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateEventPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateEventPage", 1, 0);

		driver.get(URL_CREATE_EVENT);

		CreateEventPage page = new CreateEventPage(driver);
		page.verifyCreateEventPageTitle(expectedTitle);
	}
}
