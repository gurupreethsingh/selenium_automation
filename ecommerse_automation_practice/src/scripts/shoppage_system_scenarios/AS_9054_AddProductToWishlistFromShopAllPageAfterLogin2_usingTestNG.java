package scripts.shoppage_system_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.AllVerifications;
import generic.OpenClose;

public class AS_9054_AddProductToWishlistFromShopAllPageAfterLogin2_usingTestNG extends OpenClose {

	@Test(priority = 1)
	public static void userLogin() throws InterruptedException {

		// step 2 : click sign in button and navigate to login page .
		WebElement signinButton = driver
				.findElement(By.xpath("//span[@class='text-[12px] font-extrabold text-white']"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, signinButton);

		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		Thread.sleep(500);
		emailField.sendKeys("ecoders@gmail.com");
		Thread.sleep(500);

		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		Thread.sleep(500);
		passwordField.sendKeys("abc123ABC!@#");
		Thread.sleep(500);

		WebElement loginButton = driver.findElement(By.xpath(
				"//button[@class='w-full py-2 px-4 bg-gradient-to-r from-orange-500 to-amber-400 text-white font-bold rounded-full shadow hover:from-orange-500 hover:to-orange-300 transition']"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, loginButton);

		// handle the alert by switching to alert window and click on ok button on the
		// alert
		AllVerifications.handleAlertIfAlertIsPresentAndAccept(driver);
	}

	@Test(priority = 2)
	public static void userNavigateToShopAllPage() throws InterruptedException {
		// navigate to shop page by clicking on shop all link from the header of
		// dashboard page.
		WebElement shopAllLink = driver.findElement(
				By.xpath("//a[@class='linkText text-sm transition-colors text-gray-700 hover:text-orange-600']"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, shopAllLink);
	}

	@Test(priority = 3, enabled = false)
	public static void addProductToWishlist() throws InterruptedException {
		// click on the wishlist icon of any one product
		WebElement wishlistIconOnProduct = driver.findElement(By.xpath(
				"(//button[@class='absolute top-2 right-2 h-9 w-9 rounded-full bg-white/90 backdrop-blur flex items-center justify-center transition hover:bg-white'])[1]"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, wishlistIconOnProduct);

		// find the wishlisticon from header and click on it and navigate to wishlist
		// page.

		WebElement wishlistIconHeader = driver.findElement(By.xpath("(//a[@href='/wishlist'])[1]"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, wishlistIconHeader);

		// verify the product is added to wishlist or not
		String expectedProductText = "Yoga Resistance Bands Set";

		WebElement productNameWishlistpage = driver
				.findElement(By.xpath("//h2[@class='text-[13px] font-extrabold text-slate-900 truncate']"));
		Thread.sleep(500);
		String actualProductText = productNameWishlistpage.getText();
		Thread.sleep(500);

		AllVerifications.verifyTextPresent(driver, expectedProductText, productNameWishlistpage);

	}

	@Test(priority = 4)
	public static void userLogout() throws InterruptedException {

		// click on name drop down from header
		WebElement nameDropDown = driver.findElement(By.xpath(
				"//button[@class='inline-flex items-center gap-2 rounded-full border border-orange-200 bg-orange-50 px-4 py-2 text-[12px] font-extrabold text-orange-700 hover:bg-orange-500 hover:text-white hover:border-orange-500 transition uppercase']"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, nameDropDown);

		WebElement logoutButton = driver.findElement(By.xpath(
				"//button[@class='block w-full text-left px-4 py-2.5 text-[13px] font-extrabold text-red-500 hover:bg-red-50']"));
		AllVerifications.clickOnElementIfVisibleAndEnabled(driver, logoutButton);

	}

}
