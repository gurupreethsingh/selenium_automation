package scripts.homepage_scenarios.funtional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.ShopAllPage;

public class As_001_ClickShoplinkFromHomepageOpenShoppage_usingTestNG extends OpenClose {

	@Test(invocationCount = 1, priority = 1, enabled = true)
	public static void testOpenShoppageFromHomepageClickonShoplink() throws InterruptedException, IOException {

		String expectedHomepageTitle = (String) Excel.getData("Homepage", 1, 0);
		Homepage hp = new Homepage(driver); // pom
		hp.verifyHomepageTitle(expectedHomepageTitle);
		hp.clickOnShopAllLink();
		String expectedShoppageTitle = (String) Excel.getData1("ShopAllPage", 1, 0);
		ShopAllPage sap = new ShopAllPage(driver); // pom
		sap.verityShopPageTitle(expectedShoppageTitle);

	}

}
