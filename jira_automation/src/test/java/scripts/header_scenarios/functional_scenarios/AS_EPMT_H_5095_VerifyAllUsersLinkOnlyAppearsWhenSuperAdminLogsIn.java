package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_5095_VerifyAllUsersLinkOnlyAppearsWhenSuperAdminLogsIn extends OpenClose {

	@Test
	public void testVerifyAllUsersLinkOnlyAppearsWhenSuperAdminOfTheApplicationLogsIn() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getAllUsersLinkText("All Users"),
				"All Users link text verification failed for superadmin login.");

		softAssert.assertTrue(header.getAllUsersLinkHref("/all-users"),
				"All Users link href verification failed for superadmin login.");

		softAssert.assertAll();
	}
}