package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_2554_ClickEventsIconNavigateToAllEventsPage extends OpenClose {

	@Test
	public void testClickEventsIconFromHeaderAfterLoginNavigateToAllEventsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnEventsIconLink(), "Failed to click Events icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*event.*", "All Events Page"),
				"All Events page did not load properly.");

		softAssert.assertAll();
	}
}