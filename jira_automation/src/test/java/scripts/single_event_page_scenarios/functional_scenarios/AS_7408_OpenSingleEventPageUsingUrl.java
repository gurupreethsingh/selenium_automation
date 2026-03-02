package scripts.single_event_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleEventPage;

public class AS_7408_OpenSingleEventPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleEventPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleEventPage", 1, 0);

		driver.get(URL_SINGLE_EVENT_BASE + "000000000000000000000000");

		SingleEventPage page = new SingleEventPage(driver);
		page.verifySingleEventPageTitle(expectedTitle);
	}
}
