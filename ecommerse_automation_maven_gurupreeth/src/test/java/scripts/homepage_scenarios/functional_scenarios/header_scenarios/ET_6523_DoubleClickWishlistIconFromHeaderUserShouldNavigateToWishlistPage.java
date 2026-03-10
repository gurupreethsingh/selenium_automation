package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.WishlistPage;

public class ET_6523_DoubleClickWishlistIconFromHeaderUserShouldNavigateToWishlistPage extends OpenClose {

	@Test
	public void testDoubleClickWishlistIconFromHeaderUserShouldNavigateToWishlistPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		WebElement wishlistIcon = driver
				.findElement(By.cssSelector("header a[href='/wishlist'][aria-label='Wishlist']"));
		Actions act = new Actions(driver);
		act.doubleClick(wishlistIcon).perform();
		Thread.sleep(1000);

		WishlistPage wp = new WishlistPage(driver);
		String expectedWishlistPageTitle = (String) Excel.getData("WishlistPage", 1, 0);
		wp.verifyWishlistPageTitle(expectedWishlistPageTitle);
	}
}