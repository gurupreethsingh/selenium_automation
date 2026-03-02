package scripts.create_notification_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateNotificationPage;

public class AS_7416_OpenCreateNotificationPageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateNotificationPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateNotificationPage", 1, 0);

		driver.get(URL_CREATE_NOTIFICATION);

		CreateNotificationPage page = new CreateNotificationPage(driver);
		page.verifyCreateNotificationPageTitle(expectedTitle);
	}
}
