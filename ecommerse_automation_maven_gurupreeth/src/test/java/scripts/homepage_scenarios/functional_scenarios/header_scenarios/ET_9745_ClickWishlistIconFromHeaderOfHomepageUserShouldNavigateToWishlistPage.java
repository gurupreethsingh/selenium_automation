package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.WishlistPage;

public class ET_9745_ClickWishlistIconFromHeaderOfHomepageUserShouldNavigateToWishlistPage extends OpenClose {

	@Test
	public void testClickWishlistIconFromHeaderOfHomepageUserShouldNavigateToWishlistPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickWishlistDesktop();
		Thread.sleep(1000);

		WishlistPage wp = new WishlistPage(driver);
		String expectedWishlistPageTitle = (String) Excel.getData("WishlistPage", 1, 0);
		wp.verifyWishlistPageTitle(expectedWishlistPageTitle);
	}
}