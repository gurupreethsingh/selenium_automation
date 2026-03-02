package scripts.single_user_event_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleUserEventPage;

public class AS_7411_OpenSingleUserEventPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleUserEventPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleUserEventPage", 1, 0);

		driver.get(URL_SINGLE_USER_EVENT_BASE + "000000000000000000000000");

		SingleUserEventPage page = new SingleUserEventPage(driver);
		page.verifySingleUserEventPageTitle(expectedTitle);
	}
}
