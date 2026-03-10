package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_ET_3955_ClickLogoFromHomepageHomepageShouldOpenReload extends OpenClose {

	@Test
	public void testClickLogoFromHomepageHomepageShouldOpenReload() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String urlBeforeClick = driver.getCurrentUrl();

		hp.clickHeaderLogoHome();
		Thread.sleep(1000);

		String urlAfterClick = driver.getCurrentUrl();

		hp.verifyHomepageTitle(expectedHomePageTitle);
		Assert.assertTrue(urlAfterClick.contains("/"), "Homepage did not open after clicking logo.");
		Assert.assertNotNull(urlBeforeClick);
	}
}