package scripts.single_product_page.functional_scenarios;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.CartPage;
import pom.ShopPage;
import pom.SingleProductPage;

public class AS_SPP_O5_addPrductToCartVerifyDetailsInCartPage extends OpenClose {

	@Test
	public void testAddPrductToCartVerifyDetailsOfProductInCartPage() throws InterruptedException {
		// navigate to shoppage.

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		// find one product and click on that product,

		WebElement product = driver.findElement(By.cssSelector("div.productCardPerf:nth-of-type(7)"));
		// store all the product details as expected values. which you are trying to
		// click.
		String expectedSellingPriceString = product.getAttribute("data-product-selling-price");
		String expectedProductName = product.getAttribute("data-product-name");

		int expectedSellingPrice = Integer.parseInt(expectedSellingPriceString);
		System.out.println("******************\n Expected product details \n ");
		System.out.println(expectedProductName);
		System.out.println(expectedSellingPrice);

		System.out.println("**************************************************");

		product.click();

		// single product page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SingleProductPage spp = new SingleProductPage(driver);
		spp.verifySingleProductPageTitle("Single-Product | ECODERS");

		Thread.sleep(1000);

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of times. you want to click on add to cart button.");
		int clickCount = sc.nextInt();

		int totalExpectedQuantity = 0;
		for (int i = 1; i <= clickCount; i++) {
			// find the add to cart button and click 5 times on it.
			spp.clickOnAddToCartButton();
			totalExpectedQuantity++;
			Thread.sleep(500);
		}

		System.out.println("Total expected quantity is : " + totalExpectedQuantity);

		// navigate to cart page.
		driver.navigate().to("http://localhost:5173/cart");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// find all the actual values. from the cart page.

		System.out.println("******************************************");

		CartPage cartPage = new CartPage(driver);

		String actualProductName = cartPage.getActualProductNameInCartPage();
		cartPage.verifyCartProductNameText(expectedProductName);

		int actualSellingPrice = cartPage.getActualSellingPriceNumberInCartPage();

		int actualQuantity = cartPage.getActualQuantityNumberInCartPage();

		int actualSubTotal = cartPage.getActualSubTotalInCartPage();

		int actualGrandTotal = cartPage.getActualGrandTotalInCartPage();

		System.out.println("The actual Grand total is : " + actualGrandTotal);

		System.out.println("******************************************");

		Thread.sleep(3000);
	}

}
