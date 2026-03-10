package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1907_ClickContactUsLinkFromFooterOfHomepageUserGetsNavigatedToContactUsPage extends OpenClose {

	@Test
	public void testClickContactUsLinkFromFooterOfHomepageUserGetsNavigatedToContactUsPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle((String) Excel.getData("HomePage", 1, 0));

		hp.clickFooterContactUs();
		Thread.sleep(1500);

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("contact"),
				"User is not navigated to Contact Us page.");
	}
}