package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_EPMT_F_8788_ClickWebAppsLinkFromFooterNavToWebAppsPage extends OpenClose {

	@Test
	public void testClickWebAppsLinkFromFooterAndNavigateToWebAppsPage() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterWebAppsLink(), "Click on Web & Mobile Apps link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/web-apps"), "Web & Mobile Apps page URL verification failed");

		sa.assertAll();
	}
}