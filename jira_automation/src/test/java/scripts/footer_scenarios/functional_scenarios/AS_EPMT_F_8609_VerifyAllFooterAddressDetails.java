package scripts.footer_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Footer;

public class AS_EPMT_F_8609_VerifyAllFooterAddressDetails extends OpenClose {

	@Test
	public void testVerifyAllAddressDetailsDisplayedCorrectlyInFooter() throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		Footer footer = new Footer(driver);

		sa.assertTrue(footer.verifyFooterIsVisible(), "Footer is not visible");
		sa.assertTrue(footer.getAllAddressSectionsDetails(), "Footer address details are not displayed");

		sa.assertAll();
	}
}