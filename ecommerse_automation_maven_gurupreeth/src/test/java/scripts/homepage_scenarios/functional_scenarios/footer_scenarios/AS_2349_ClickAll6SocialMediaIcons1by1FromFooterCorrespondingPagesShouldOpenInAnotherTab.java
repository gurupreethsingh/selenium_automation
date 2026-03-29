package scripts.homepage_scenarios.functional_scenarios.footer_scenarios;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Footer;
import pom.HomePage;

public class AS_2349_ClickAll6SocialMediaIcons1by1FromFooterCorrespondingPagesShouldOpenInAnotherTab extends OpenClose {

	@Test
	public void testClickAll6SocialMediaIconsOneByOneFromFooterOfHomepageCorrespondingPagesShouldOpenInAnotherTab()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		Footer footer = new Footer(driver);

		Assert.assertTrue(footer.verifyFollowAndSubscribeSectionIsDisplayed(),
				"Follow and Subscribe section is not displayed.");

		Assert.assertTrue(footer.verifySocialIconsContainerIsDisplayed(), "Social icons container is not displayed.");

		Assert.assertTrue(footer.verifyTotalSocialLinksCount(6),
				"Footer does not contain exactly 6 social media icons.");

		int socialLinkCount = footer.getTotalSocialMediaLinksCount();
		Assert.assertEquals(socialLinkCount, 6, "Footer social media links count mismatch.");

		String parentWindow = driver.getWindowHandle();

		for (int i = 0; i < socialLinkCount; i++) {

			System.out.println("============================================================");
			System.out.println("[SOCIAL LINK TEST START] Index: " + i);
			System.out.println("============================================================");

			driver.switchTo().window(parentWindow);

			Assert.assertTrue(footer.verifySocialIconsContainerIsDisplayed(),
					"Social icons container is not displayed before clicking index: " + i);

			Set<String> oldWindows = driver.getWindowHandles();

			String expectedHref = footer.getFooterSocialLinkHrefByIndex(i);
			System.out.println("[EXPECTED HREF] " + expectedHref);

			Assert.assertTrue(footer.clickFooterSocialLinkByIndex(i),
					"Unable to click footer social media link at index: " + i);

			Thread.sleep(2000);

			Set<String> newWindows = driver.getWindowHandles();

			Assert.assertTrue(newWindows.size() > oldWindows.size(),
					"New tab did not open for social media link index: " + i);

			String childWindow = null;

			for (String win : newWindows) {
				if (!oldWindows.contains(win)) {
					childWindow = win;
					break;
				}
			}

			Assert.assertNotNull(childWindow, "Unable to find newly opened tab for social media link index: " + i);

			driver.switchTo().window(childWindow);
			Thread.sleep(2000);

			String actualUrl = driver.getCurrentUrl();
			System.out.println("[NEW TAB URL] " + actualUrl);

			Assert.assertTrue(actualUrl != null && !actualUrl.trim().isEmpty(),
					"Opened tab URL is blank for social media link index: " + i);

			driver.close();
			driver.switchTo().window(parentWindow);
			Thread.sleep(1000);

			System.out.println("[SOCIAL LINK TEST PASS] Index: " + i);
		}
	}
}