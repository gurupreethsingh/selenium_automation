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

public class AS_SPP_O6_AddMultipleProductsToCart extends OpenClose {
	@Test
	public void testAddAddMultipleProductsToCart() throws InterruptedException {
		// navigate to shop page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		int grandTotal = 0;

		// randomly click on products to navigate to single product page..

		Random random = new Random();
		int totalUniqueProductsCount = random.nextInt(5) + 1; // so from 1 to 10 any random number it will give ,

		System.out.println("Adding " + totalUniqueProductsCount + " To cart.");

		for (int i = 1; i <= totalUniqueProductsCount; i++) {
			// find the product to click on.
			WebElement ProductToClick = driver
					.findElement(By.cssSelector("div.shopProductsGrid>div:nth-of-type(" + i + ")"));
			// store all the details of the product it will click on, one by one
			WebElement individualProduct = driver
					.findElement(By.cssSelector("div.shopProductsGrid>div:nth-of-type(" + i + ")>div>p:first-child"));
			// store all the details of the product it will click on, one by one
			String expectedProductName = individualProduct.getText();

			WebElement sellingPriceText = driver.findElement(By.cssSelector("div.shopProductsGrid>div:nth-of-type(" + i
					+ ")>div:last-child>div.shopProductPriceRow>span:first-child"));
			// store all the details of the product it will click on, one by one
			String productSellingPriceText = sellingPriceText.getText();
			String cleanedProductSellingPriceText = productSellingPriceText.replaceAll("[^0-9]", "");
			int expectedSellingPrice = Integer.parseInt(cleanedProductSellingPriceText);
			// click on that product, and navigate to single product page

			ProductToClick.click();

			SingleProductPage spp = new SingleProductPage(driver);
			spp.verifySingleProductPageTitle("Single-Product | ECODERS");
			Thread.sleep(500);

			// ask the user how many quantity of that product he want to add to cart.
			int expectedEachProductQuantity = 0;
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter the quantity for " + expectedProductName
//					+ " product you want to add to cart and its selling price per unit is : " + expectedSellingPrice);
//			expectedEachProductQuantity = sc.nextInt();
			expectedEachProductQuantity = random.nextInt(5) + 1;

			int expectedProductIndividualSubTotal = expectedSellingPrice * expectedEachProductQuantity;
			System.out.println("Expected sub total for the product " + expectedProductName + " is "
					+ expectedProductIndividualSubTotal);
			for (int j = 1; j <= expectedEachProductQuantity; j++) {
				// add to cart button clicked that many times.
				WebElement addToCartButton = driver.findElement(By.cssSelector(
						"div.sp-action-grid.sp-mobile-action-bar.grid.grid-cols-1.gap-4.pt-2>button:first-child"));
				addToCartButton.click();
				Thread.sleep(500);

			}
			System.out.println("Added " + expectedProductName + " product added to cart " + expectedEachProductQuantity
					+ " times.");
			grandTotal = grandTotal + expectedProductIndividualSubTotal;
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
		}

		System.out.println("Grand total of all the products  : " + grandTotal);

		driver.navigate().to(URL_CART);
		Thread.sleep(3000);

		// now in cart page. fetch all the product names, selling prices. each product
		// quantity , subtotal. and grand total.

		List<WebElement> actualTotalProductsFoundInCart = driver
				.findElements(By.cssSelector("div.flex.flex-col.gap-6>div.bg-white.rounded-3xl.p-4"));

		int actualProductsInCart = actualTotalProductsFoundInCart.size();

		for (int a = 1; a <= actualProductsInCart; a++) {
			WebElement actualProduct = driver.findElement(
					By.cssSelector("div.flex.flex-col.gap-6>div.bg-white.rounded-3xl.p-4:nth-of-type(" + a + ") h2"));

			String actualProductName = actualProduct.getText();

			WebElement actualSellingPriceText = driver.findElement(
					By.cssSelector("div.flex.flex-col.gap-6>div.bg-white.rounded-3xl.p-4:nth-of-type(" + a + ") p"));
			String text = actualSellingPriceText.getText();
			String cleanText = text.replaceAll("[^0-9]", "");
			int actualSellingPrice = Integer.parseInt(cleanText);

			WebElement actualQuantityText = driver
					.findElement(By.cssSelector("div.flex.flex-col.gap-6>div.bg-white.rounded-3xl.p-4:nth-of-type(" + a
							+ ") div.flex.items-center.gap-3>span"));
			String quantityText = actualQuantityText.getText();
			String cleanQuantityText = quantityText.replaceAll("[^0-9]", "");
			int actualQuantity = Integer.parseInt(cleanQuantityText);

			WebElement actualSubTotalText = driver
					.findElement(By.cssSelector("div.flex.flex-col.gap-6>div.bg-white.rounded-3xl.p-4:nth-of-type(" + a
							+ ") div.flex.items-center.justify-between.gap-4.w-full>span"));
			String subTotalText = actualSubTotalText.getText();
			String cleanSubtotalText = subTotalText.replaceAll("[^0-9]", "");
			int actualSubTotal = Integer.parseInt(cleanSubtotalText);

			System.out.println(a + " - " + actualProductName + " " + " at Rs " + actualSellingPrice + ", Quantity : "
					+ actualQuantity + ", SubTotal : " + actualSubTotal);
		}

		WebElement actualGrandTotalText = driver
				.findElement(By.cssSelector("div.mt-10.rounded-3xl.bg-white.p-6.text-center>p"));
		String GrandTotalText = actualGrandTotalText.getText();
		String cleanGrandTotalText = GrandTotalText.replaceAll("[^0-9.]", "");
		double actualGrandTotal = Double.parseDouble(cleanGrandTotalText);

		System.out.println("Grand Total : " + actualGrandTotal);
		Thread.sleep(5000);
	}

}
