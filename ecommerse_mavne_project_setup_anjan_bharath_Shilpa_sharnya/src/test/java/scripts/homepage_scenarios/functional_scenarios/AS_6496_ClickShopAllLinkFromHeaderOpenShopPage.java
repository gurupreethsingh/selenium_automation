package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.ShopPage;

public class AS_6496_ClickShopAllLinkFromHeaderOpenShopPage extends OpenClose {

	@Test
	public void testClickShopAllLinkFromHeaderOpenShopPage() throws IOException {

		HomePage hp = new HomePage(driver);
		String expectedHomeTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomeTitle);

		hp.clickHeaderShopAllDesktop();

		ShopPage sp = new ShopPage(driver);
		String expectedShopTitle = (String) Excel.getData("Shoppage", 1, 0);
		sp.verifyShopPageTitle(expectedShopTitle);

	}
}
