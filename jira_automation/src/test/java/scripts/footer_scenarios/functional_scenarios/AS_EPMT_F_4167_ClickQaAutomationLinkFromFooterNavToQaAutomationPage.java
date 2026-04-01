
package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_EPMT_F_4167_ClickQaAutomationLinkFromFooterNavToQaAutomationPage extends OpenClose {

	@Test
	public void testClickQaAutomationLinkFromFooterAndNavigateToQaAutomationPage()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		Footer footer = new Footer(driver);
		Assert.assertTrue(footer.clickOnFooterQaAutomationLink(), "Click on QA Automation link failed");

		sa.assertTrue(footer.verifyUrlOfWebpage("/qa-automation"), "QA Automation page URL verification failed");

		sa.assertAll();
	}
}