package scripts.single_product_page.functional_scenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.CartPage1;
import pom.ShopPage;
import pom.ShopPage2;
import pom.SingleProductPage;

public class AS_SPP_07_addSingleProductToCart extends OpenClose {

	@Test
	public void testAddMultipeProductsFromSingleProductPageWithMultipQuntitiesToCart() throws InterruptedException {
		// navigate to shop page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		double expectedGrandTotal = 0.0;

		SingleProductPage spp = new SingleProductPage(driver);

		ShopPage2 sp2 = new ShopPage2(driver);
		sp2.getProductName(1);
		int expectedPrice1 = sp2.getProductSellingPriceAsInteger(1);
		int expecteSubtotal1 = expectedPrice1;
		int exptecteGrandTotal1 = expecteSubtotal1;
		sp2.clickOnAnyOneProductBasedOnIndex(1);

		spp.clickOnAddToCartButton();
		Thread.sleep(1000);

		driver.navigate().back();
		Thread.sleep(1000);

		sp2.getProductName(2);
		int expectedPrice2 = sp2.getProductSellingPriceAsInteger(2);
		int expecteSubtotal2 = expectedPrice2;
		int exptecteGrandTotal2 = expecteSubtotal2;
		sp2.clickOnAnyOneProductBasedOnIndex(2);

		spp.clickOnAddToCartButton();

		driver.navigate().to("http://localhost:5173/cart");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		CartPage1 cp1 = new CartPage1(driver);

		for (int i = 1; i <= 2; i++) {
			System.out.println(cp1.getProductName(i));
			Thread.sleep(300);
		}
	}
}
