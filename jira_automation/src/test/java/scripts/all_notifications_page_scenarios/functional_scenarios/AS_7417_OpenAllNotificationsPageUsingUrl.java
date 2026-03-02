package scripts.all_notifications_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllNotificationsPage;

public class AS_7417_OpenAllNotificationsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllNotificationsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllNotificationsPage", 1, 0);

		driver.get(URL_ALL_NOTIFICATIONS);

		AllNotificationsPage page = new AllNotificationsPage(driver);
		page.verifyAllNotificationsPageTitle(expectedTitle);
	}
}
