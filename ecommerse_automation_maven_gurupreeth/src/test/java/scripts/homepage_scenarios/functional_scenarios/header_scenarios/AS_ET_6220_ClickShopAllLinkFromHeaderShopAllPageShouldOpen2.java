
package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import generic.ScreenshotUtility;
import pom.Header;
import pom.HomePage;
import pom.ShopPage;

public class AS_ET_6220_ClickShopAllLinkFromHeaderShopAllPageShouldOpen2 extends OpenClose {

	@Test
	public void testClickShopAllLinkFromHeaderShopAllPageShouldOpen() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// take screen shot
		ScreenshotUtility sc = new ScreenshotUtility(driver);
		sc.captureScreenshot();

		Header header = new Header(driver);
		header.clickHeaderShopAllDesktop();
		Thread.sleep(1000);

		// take screen shot

		sc.captureScreenshot();
		ShopPage sp = new ShopPage(driver);
		String expectedShopPageTitle = (String) Excel.getData("ShopPage", 1, 0);
		sp.verifyShopPageTitle(expectedShopPageTitle);
	}
}