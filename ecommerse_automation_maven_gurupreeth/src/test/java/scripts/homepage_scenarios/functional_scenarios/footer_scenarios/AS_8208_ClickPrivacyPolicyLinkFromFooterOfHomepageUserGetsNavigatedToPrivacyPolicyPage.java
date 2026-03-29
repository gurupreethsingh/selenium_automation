package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_8208_ClickPrivacyPolicyLinkFromFooterOfHomepageUserGetsNavigatedToPrivacyPolicyPage extends OpenClose {

	@Test
	public void testClickPrivacyPolicyLinkFromFooterOfHomepageUserGetsNavigatedToPrivacyPolicyPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle((String) Excel.getData("HomePage", 1, 0));

		Footer footer = new Footer(driver);

		footer.clickOnFooterPrivacyPolicyLink();
		Thread.sleep(500);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("privacy"),
				"User is not navigated to Privacy Policy page.");
	}
}