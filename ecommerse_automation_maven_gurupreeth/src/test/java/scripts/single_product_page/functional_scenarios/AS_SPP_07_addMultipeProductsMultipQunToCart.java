package scripts.single_product_page.functional_scenarios;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;
import pom.SingleProductPage;

public class AS_SPP_07_addMultipeProductsMultipQunToCart extends OpenClose {

	@Test
	public void testAddMultipeProductsFromSingleProductPageWithMultipQuntitiesToCart() throws InterruptedException {
		// navigate to shop page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		// ask the user how many unique products he wants to add to cart.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("How many products you want to add to cart. (1, 36)");
//		int totalUniqueProudcts = sc.nextInt();
//		int expectedTotalProductsCount = totalUniqueProudcts;

		// you only generate a random number and code only decides whether to add , 1,
		// 2, 3, 4,5 products to cart.
		Random random = new Random();
		int expectedTotalProductsCount = random.nextInt(5) + 1;

		System.out.println("total products to be added to cart : " + expectedTotalProductsCount); // 1

		double expectedGrandTotal = 0.0;

		for (int x = 1; x <= expectedTotalProductsCount; x++) {
			// find the product which you want to click

			int i = random.nextInt(11) + 1;

			WebElement productToClick = driver
					.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + i + ")"));

			// find the product name. products selling price,
			WebElement expectedProductName = driver.findElement(
					By.cssSelector("div.productCardPerf:nth-of-type(" + i + ")>div:last-child>p:first-child"));

			String expecteProductNameText = expectedProductName.getText();

			System.out.println("****************************************************");
			System.out.println("Product name to be added to cart is : " + expecteProductNameText);

			// find the selling price of the product you are trying to add to cart.
			WebElement expectedProductSellingPrice = driver
					.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + i
							+ ")>div:last-child>div.shopProductPriceRow>span.priceSelling"));
			String expectedProductSellingPriceText = expectedProductSellingPrice.getText();
			String cleanedexpectedProductSellingPriceText = expectedProductSellingPriceText.replaceAll("[^0-9]", "");
			// int
			int expectedSellingPrice = Integer.parseInt(cleanedexpectedProductSellingPriceText);
			// double
			// double expectedSellingPrice =
			// Double.parseDouble(cleanedexpectedProductSellingPriceText);
			System.out.println("Product selling price to be added to cart is : " + expectedSellingPrice);
			System.out.println("****************************************************");

			productToClick.click();
			Thread.sleep(500);
			SingleProductPage spp = new SingleProductPage(driver);
			spp.verifySingleProductPageTitle("Single-Product | ECODERS");

			// the user will get navigated single product page.
			Thread.sleep(500);

			// find the add to cart button. and click on it , randomly generate a number to
			// click on add to cart button between 1 to 5
			int individualProudctQuantityToAddToCart = random.nextInt(5) + 1;

			for (int a = 1; a <= individualProudctQuantityToAddToCart; a++) {
				// add to cart button here and click on add to cart button,
				WebElement addToCartButton = driver.findElement(By.cssSelector(
						"div.sp-action-grid>button.btnOrange.inline-flex.items-center.justify-center.gap-2:first-child"));
				addToCartButton.click();
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

		// you are in cart page now.
		List<WebElement> actualTotalProductsAddedToCart = driver
				.findElements(By.cssSelector("div.flex.flex-col.gap-6>div"));
		int actualTotalProductsInCart = actualTotalProductsAddedToCart.size();

		if (expectedTotalProductsCount == actualTotalProductsInCart) {
			System.out.println(
					"The correct number of products are added to cart, which is : " + actualTotalProductsInCart);
		}

		for (int b = 1; b <= actualTotalProductsInCart; b++) {
			WebElement actualProductNameElement = driver
					.findElement(By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div h2"));
			String actualProductName = actualProductNameElement.getText();

			WebElement actualSellingPriceElement = driver
					.findElement(By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div p>span"));
			String actualSellingPriceText = actualSellingPriceElement.getText();
			String actualSellingPriceCleanedText = actualSellingPriceText.replaceAll("[^0-9]", "");
			int actualSellingPrice = Integer.parseInt(actualSellingPriceCleanedText);

			WebElement actualTotalQuantityElement = driver.findElement(
					By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div:nth-of-type(2)>span"));
			String actualTotalQuantityText = actualTotalQuantityElement.getText();
			int actualTotalQuantity = Integer.parseInt(actualTotalQuantityText);

			WebElement actualSubTotalElement = driver.findElement(
					By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div:nth-of-type(3)>span"));
			String actualSubTotalText = actualSubTotalElement.getText();
			String actualSubTotalTextCleaned = actualSubTotalText.replaceAll("[^0-9]", "");
			int actualSubTotal = Integer.parseInt(actualSubTotalTextCleaned);

			System.out.println("____________________________________________________________________________");
			System.out.println(b + " - " + actualProductName + " " + actualSellingPrice + " " + actualTotalQuantity
					+ " " + actualSubTotal);
			System.out.println("____________________________________________________________________________");
			Thread.sleep(300);
		}

		WebElement actualGrandTotalElement = driver
				.findElement(By.cssSelector("div.mt-10.rounded-3xl.bg-white.p-6.text-center>p"));
		String actualGrandTotalString = actualGrandTotalElement.getText();
		String cleanedGrandTotal = actualGrandTotalString.replaceAll("[^0-9.]", "");

		double actualGrandTotal = Double.parseDouble(cleanedGrandTotal);

		System.out.println("Grand Total found in cart page : " + actualGrandTotal);

		if (expectedGrandTotal == actualGrandTotal) {
			System.out.println("Grand total matching.");
		} else {
			System.out.println("Grand total not matching.");
		}
		Thread.sleep(5000);
	}
}
