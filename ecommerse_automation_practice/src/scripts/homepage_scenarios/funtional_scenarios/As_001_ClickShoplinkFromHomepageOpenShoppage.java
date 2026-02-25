package scripts.homepage_scenarios.funtional_scenarios;

import generic.OpenClose;
import pom.Homepage;
import pom.ShopAllPage;

public class As_001_ClickShoplinkFromHomepageOpenShoppage extends OpenClose {

	public static void main(String[] args) throws InterruptedException {

		OpenClose.openApplication();

		String expectedHomepageTitle = "Home | ECODERS";

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomepageTitle);

		// find the shopall link from homepage and click on it.
		hp.clickOnShopAllLink();

		String expectedShoppageTitle = "Shop | ECODERS";
		ShopAllPage sap = new ShopAllPage(driver);
		sap.verityShopPageTitle(expectedShoppageTitle);

		OpenClose.closeApplication();

	}

}
