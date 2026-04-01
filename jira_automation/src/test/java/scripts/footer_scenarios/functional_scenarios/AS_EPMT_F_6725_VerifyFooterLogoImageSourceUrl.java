package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Footer;

public class AS_EPMT_F_6725_VerifyFooterLogoImageSourceUrl extends OpenClose {

	@Test
	public void testVerifyFooterLogoImageSourceUrlIsCorrect() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterLogoSource("ecoders_logo"), "Footer logo image source verification failed");

		sa.assertAll();
	}
}