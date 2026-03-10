package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2349_ClickAll6SocialMediaIcons1by1FromFooterCorrespondingPagesShouldOpenInAnotherTab
		extends OpenClose {

	@Test
	public void testClickAll6SocialMediaIconsOneByOneFromFooterOfHomepageCorrespondingPagesShouldOpenInAnotherTab()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		int socialLinkCount = hp.getFooterSocialLinkCount();
		Assert.assertEquals(socialLinkCount, 6, "Footer does not contain exactly 6 social media icons.");

		for (int i = 0; i < socialLinkCount; i++) {
			Set<String> oldWindows = driver.getWindowHandles();
			hp.clickFooterSocialLinkByIndex(i);
			Thread.sleep(1500);

			Set<String> newWindows = driver.getWindowHandles();
			Assert.assertTrue(newWindows.size() > oldWindows.size(),
					"Corresponding social media page did not open in another tab for icon index: " + i);

			for (String win : newWindows) {
				if (!oldWindows.contains(win)) {
					driver.switchTo().window(win);
					driver.close();
				}
			}

			for (String win : oldWindows) {
				driver.switchTo().window(win);
				break;
			}
		}
	}
}