package scripts.wishlist_scenarios.functional_scenarios;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.DashboardPage;
import pom.LoginPage;
import pom.WishlistPage;

public class AS_W_3414_logged_in_user_access_wishlistPg_via_URL extends OpenClose {

	@Test
	public void testlogged_in_user_access_wishlistPg_via_URL() throws InterruptedException, IOException {

		Thread.sleep(1000);
		// login,
		driver.navigate().to(URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LoginPage lp = new LoginPage(driver);
		String loginPageExpectedText = (String) Excel.getData("LoginPage", 1, 0);
		lp.verifyLoginPageTitle(loginPageExpectedText);

		lp.login("shilpa@gmail.com", "abc123ABC!@#");
		Thread.sleep(1000);
		lp.clickOnloginButton();

		lp.acceptAlert();

		DashboardPage dp = new DashboardPage(driver);
		dp.verifyDashboardPageTitle("User Dashboard | ECODERS");

		Thread.sleep(1000);

		// enter the url of wishlish, from the dashboard page.
		driver.navigate().to(URL_WISHLIST);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verify you are in wishlist page or not.
		WishlistPage wp = new WishlistPage(driver);
		wp.verifyWishlistPageTitle("Wishlist | ECODERS");
		Thread.sleep(2000);
	}

}
