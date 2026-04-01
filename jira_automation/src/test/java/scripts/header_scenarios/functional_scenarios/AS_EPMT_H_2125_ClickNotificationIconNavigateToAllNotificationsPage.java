package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_2125_ClickNotificationIconNavigateToAllNotificationsPage extends OpenClose {

	@Test
	public void testClickNotificationIconFromHeaderAfterLoginNavigateToAllNotificationsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnNotificationsIconLink(), "Failed to click Notifications icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*notification.*", "All Notifications Page"),
				"All Notifications page did not load properly.");

		softAssert.assertAll();
	}
}