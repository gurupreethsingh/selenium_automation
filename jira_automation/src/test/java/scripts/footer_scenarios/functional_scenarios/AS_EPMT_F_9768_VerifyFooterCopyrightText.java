package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Footer;

public class AS_EPMT_F_9768_VerifyFooterCopyrightText extends OpenClose {

	@Test
	public void testVerifyFooterCopyrightTextDisplayedCorrectly() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);
		String expectedCopyrightText = "© 2019 Ecoders. All rights reserved.";

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getFooterCopyrightText(expectedCopyrightText),
				"Footer copyright text verification failed");

		sa.assertAll();
	}
}