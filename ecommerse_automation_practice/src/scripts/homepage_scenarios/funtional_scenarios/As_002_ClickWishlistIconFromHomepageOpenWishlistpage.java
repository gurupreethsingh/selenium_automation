package scripts.homepage_scenarios.funtional_scenarios;

import generic.OpenClose;
import pom.Homepage;
import pom.WishlistPage;

public class As_002_ClickWishlistIconFromHomepageOpenWishlistpage extends OpenClose {

	public static void main(String[] args) throws InterruptedException {
		OpenClose.openApplication();
		String expectedHomepageTitle = "Home | ECODERS";
		Homepage hp = new Homepage(driver);
		hp.verityHomepageTitle(expectedHomepageTitle);
		hp.clickOnWishlistIcon();
		String expectedWistlistPageTitle = "Wishlist | ECODERS";
		WishlistPage wlp = new WishlistPage(driver);
		wlp.verityWistlistPageTitle(expectedWistlistPageTitle);
		OpenClose.closeApplication();
	}
}
