package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_8071_VerifyEventsAndNotificationIconsAreNotDisplayedBeforeLogin extends OpenClose {

	@Test
	public void testVerifyEventsAndNotificationIconsAreNotDisplayedBeforeLogin() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By eventsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Events']");
		By notificationsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Notifications']");

		softAssert.assertFalse(header.isElementPresentInDOM(eventsIconLocator),
				"Events icon should not be displayed before login.");

		softAssert.assertFalse(header.isElementPresentInDOM(notificationsIconLocator),
				"Notifications icon should not be displayed before login.");

		softAssert.assertAll();
	}
}