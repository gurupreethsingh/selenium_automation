package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_4798_VerifyEventsAndNotificationIconsAppearOnRightSideAfterLogin extends OpenClose {

	@Test
	public void testVerifyEventsAndNotificationIconsAppearOnRightSideOfHeaderAfterLogin() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By eventsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Events']");
		By notificationsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Notifications']");

		softAssert.assertTrue(header.verifyElementPresentAndVisible(eventsIconLocator, "Header Events Icon Link"),
				"Events icon is not visible on the right side of header after login.");

		softAssert.assertTrue(
				header.verifyElementPresentAndVisible(notificationsIconLocator, "Header Notifications Icon Link"),
				"Notifications icon is not visible on the right side of header after login.");

		softAssert.assertAll();
	}
}