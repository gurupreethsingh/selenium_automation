package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2519_ClickAboutUsLinkFromFooterOfHomepageUserGetsNavigatedToAboutUsPage extends OpenClose {

	@Test
	public void testClickAboutUsLinkFromFooterOfHomepageUserGetsNavigatedToAboutUsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle((String) Excel.getData("HomePage", 1, 0));

		hp.clickFooterAboutUs();
		Thread.sleep(1500);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("about"),
				"User is not navigated to About Us page.");
	}
}