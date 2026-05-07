package scripts.single_product_page.functional_scenarios;

import java.time.Duration;
import java.util.Random;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.CartPage1;
import pom.ShopPage;
import pom.ShopPage2;

public class AS_SPP_07_addMultipeProductsMultipQunToCart_POM extends OpenClose {

	@Test
	public void testAddMultipeProductsFromSingleProductPageWithMultipQuntitiesToCart() throws InterruptedException {
		// navigate to shop page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		Random random = new Random();
		int expectedTotalProductsCount = random.nextInt(5) + 1; // 2 products

		System.out.println("total products to be added to cart : " + expectedTotalProductsCount); // 1

		double expectedGrandTotal = 0.0;
		ShopPage2 spp1 = new ShopPage2(driver);
		for (int x = 1; x <= expectedTotalProductsCount; x++) {
			int i = random.nextInt(11) + 1; // 5th product, 2nd product
			String expecteProductNameText = spp1.getProductName(i);
			System.out.println("****************************************************");
			System.out.println("Product name to be added to cart is : " + expecteProductNameText);
			int expectedSellingPrice = spp1.getProductSellingPriceAsInteger(i);
			System.out.println("Product selling price to be added to cart is : " + expectedSellingPrice);
			System.out.println("****************************************************");

			spp1.clickOnAnyOneProductBasedOnIndex(i);

			Thread.sleep(500);

			spp1.verifySingleProductPageTitle("Single-Product | ECODERS");
			Thread.sleep(500);

			int individualProudctQuantityToAddToCart = random.nextInt(5) + 1;

			for (int a = 1; a <= individualProudctQuantityToAddToCart; a++) {
				spp1.clickOnAddToCartButton();
				Thread.sleep(500);
			}

			driver.navigate().back(); // go back to shop page.
			Thread.sleep(500);

			System.out.println("The product " + expecteProductNameText + " has been added "
					+ individualProudctQuantityToAddToCart + " times to cart.");

			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("The expected Sub total for the product " + expecteProductNameText + " is "
					+ expectedSellingPrice * individualProudctQuantityToAddToCart);
			System.out.println("-----------------------------------------------------------------------------------");

			expectedGrandTotal = expectedGrandTotal + (expectedSellingPrice * individualProudctQuantityToAddToCart);

		}

		System.out.println("**************************************************");
		System.out.println("The expected GrandTotal : " + expectedGrandTotal);
		System.out.println("**************************************************");

		// go to cart page and verify the following actualprodut name. selling price,
		// quantity added. subtotal , grandtotal
		driver.navigate().to("http://localhost:5173/cart");
		Thread.sleep(1000);

		CartPage1 cp1 = new CartPage1(driver);
		cp1.verifyTotalProductCount(expectedTotalProductsCount);
		int actualTotalProductsInCart = cp1.getTotalProductCount();

		for (int b = 1; b <= actualTotalProductsInCart; b++) {

			String actualProductName = cp1.getProductName(b);
			int actualSellingPrice = cp1.getSellingPriceAsInteger(b);
			int actualTotalQuantity = cp1.getQuantity(b);
			int actualSubTotal = cp1.getSubTotal(b);
			System.out.println("____________________________________________________________________________");
			System.out.println(b + " - " + actualProductName + " " + actualSellingPrice + " " + actualTotalQuantity
					+ " " + actualSubTotal);
			System.out.println("____________________________________________________________________________");
			Thread.sleep(300);
		}

		double actualGrandTotal = cp1.getGrandTotal();
		System.out.println("Grand Total found in cart page : " + actualGrandTotal);

		if (expectedGrandTotal == actualGrandTotal) {
			System.out.println("Grand total matching.");
		} else {
			System.out.println("Grand total not matching.");
		}
		Thread.sleep(10000);
	}
}
