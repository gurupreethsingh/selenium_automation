package scripts.user_notifications_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UserNotificationsPage;

public class AS_7418_OpenUserNotificationsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUserNotificationsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UserNotificationsPage", 1, 0);

		driver.get(URL_USER_NOTIFICATIONS);

		UserNotificationsPage page = new UserNotificationsPage(driver);
		page.verifyUserNotificationsPageTitle(expectedTitle);
	}
}
