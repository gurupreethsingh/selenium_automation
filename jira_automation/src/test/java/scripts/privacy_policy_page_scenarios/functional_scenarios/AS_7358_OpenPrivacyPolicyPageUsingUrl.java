package scripts.privacy_policy_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.PrivacyPolicyPage;

public class AS_7358_OpenPrivacyPolicyPageUsingUrl extends OpenClose {

	@Test
	public void testOpenPrivacyPolicyPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("PrivacyPolicyPage", 1, 0);

		driver.get(URL_PRIVACY_POLICY);

		PrivacyPolicyPage page = new PrivacyPolicyPage(driver);
		page.verifyPrivacyPolicyPageTitle(expectedTitle);
	}
}
