package scripts.user_notification_detail_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UserNotificationDetailPage;

public class AS_7419_OpenUserNotificationDetailPageUsingUrl extends OpenClose {

	@Test
	public void testOpenUserNotificationDetailPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UserNotificationDetailPage", 1, 0);

		driver.get(URL_USER_NOTIFICATION_DETAIL_BASE + "000000000000000000000000");

		UserNotificationDetailPage page = new UserNotificationDetailPage(driver);
		page.verifyUserNotificationDetailPageTitle(expectedTitle);
	}
}
