package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_EPMT_F_1818_VerifyFooterElementsVisibleAfterPageReload extends OpenClose {

	@Test
	public void testVerifyFooterElementsAreVisibleAfterPageReload() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		sa.assertTrue(hp.verifyHomePageTitle(expectedHomePageTitle), "Homepage title verification failed");

		driver.navigate().refresh();

		Footer footer = new Footer(driver);
		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible after page reload");
		sa.assertTrue(footer.getFooterLogoDisplayed(), "Footer logo is not visible after page reload");
		sa.assertTrue(footer.getAllFooterLinks(), "Footer links are not visible after page reload");

		sa.assertAll();
	}
}