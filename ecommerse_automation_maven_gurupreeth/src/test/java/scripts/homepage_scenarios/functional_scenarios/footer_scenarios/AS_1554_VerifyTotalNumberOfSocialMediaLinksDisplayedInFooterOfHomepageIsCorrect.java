package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_1554_VerifyTotalNumberOfSocialMediaLinksDisplayedInFooterOfHomepageIsCorrect extends OpenClose {

	@Test
	public void testVerifyTotalNumberOfSocialMediaLinksDisplayedInFooterOfHomepageIsCorrect()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Footer footer = new Footer(driver);

		footer.verifyTotalSocialLinksCount(6);
		footer.printAllSocialMediaLinks();

	}
}