package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AboutUsPage;
import pom.Footer;
import pom.HomePage;

public class AS_2519_ClickAboutUsLinkFromFooterOfHomepageUserGetsNavigatedToAboutUsPage extends OpenClose {

	@Test
	public void testClickAboutUsLinkFromFooterOfHomepageUserGetsNavigatedToAboutUsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle((String) Excel.getData("HomePage", 1, 0));

		Footer footer = new Footer(driver);
		footer.clickOnFooterAboutUsLink();

		AboutUsPage aus = new AboutUsPage(driver);
		Assert.assertTrue(aus.verifyAboutUsPageTitle("About Us | ECODERS"), "About us title didnt match");

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("about"),
				"User is not navigated to About Us page.");
	}
}