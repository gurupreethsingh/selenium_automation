
package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.ShopPage;

public class AS_ET_6220_ClickShopAllLinkFromHeaderShopAllPageShouldOpen extends OpenClose {

	@Test
	public void testClickShopAllLinkFromHeaderShopAllPageShouldOpen() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickHeaderShopAllDesktop();
		Thread.sleep(1000);

		ShopPage sp = new ShopPage(driver);
		String expectedShopPageTitle = (String) Excel.getData("ShopPage", 1, 0);
		sp.verifyShopPageTitle(expectedShopPageTitle);
	}
}