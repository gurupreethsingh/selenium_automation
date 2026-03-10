package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1238_ClickFirstSocialMediaIconFromFooterCorrespondingPageShouldOpenInDifferentTab
		extends OpenClose {

	@Test
	public void testClickFirstSocialMediaIconFromFooterOfHomepageCorrespondingPageShouldOpenInDifferentTab()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Set<String> oldWindows = driver.getWindowHandles();
		hp.clickFooterSocialLinkByIndex(0);
		Thread.sleep(1500);

		Set<String> newWindows = driver.getWindowHandles();
		Assert.assertTrue(newWindows.size() > oldWindows.size(),
				"First social media icon did not open in a different tab.");
	}
}