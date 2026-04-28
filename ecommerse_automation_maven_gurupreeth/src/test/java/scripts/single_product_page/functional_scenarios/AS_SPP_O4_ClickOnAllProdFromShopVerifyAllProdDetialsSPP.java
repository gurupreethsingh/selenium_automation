package scripts.single_product_page.functional_scenarios;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage1;
import pom.SingleProductPage;

public class AS_SPP_O4_ClickOnAllProdFromShopVerifyAllProdDetialsSPP extends OpenClose {

	@Test
	public void testClickOnSingleProductFromShopAndNavigateToSingleProductPage() throws InterruptedException {
		// homepage.
		// navigate to shop page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ShopPage1 sp1 = new ShopPage1(driver);
		sp1.verifyTitleOfWebpage("Shop | ECODERS");

		Thread.sleep(2000);

		int totalProducts = sp1.getTotalProductCards();
		System.out.println("------------------------------------------------------------");
		System.out.println("Total products found in the shop page are : " + totalProducts);
		System.out.println("------------------------------------------------------------");

		for (int productNumber = 1; productNumber <= totalProducts; productNumber++) {
//    		4. fetch all the details of the product you are clicking on. and store it as expected values.
			String expectedProductName = sp1.fetchSingleProductName(productNumber);
			String expectedBrandName = sp1.fetchSingleProductBrandName(productNumber);
			System.out.println(expectedBrandName);
			int expectedSellingPrice = sp1.fetchSingleProductSellingPrice(productNumber);
			int expectedDisplayPrice = sp1.fetchSingleProductDisplayPrice(productNumber);

			System.out.println("------------------------------------------------------------");
			System.out.println("Clicked on product name from shop page is : " + expectedProductName);
			System.out.println("------------------------------------------------------------");

//    		5. click on that product. 
			sp1.clickProductByProductNumber(productNumber);

			// navigated to single product page. 6. navigate to spp
			SingleProductPage spp = new SingleProductPage(driver);

//    		7. title verification of spp. 
			spp.verifySingleProductPageTitle("Single-Product | ECODERS");

			// 8. find the actual product name and verify with the expectedproduct name.
			Assert.assertTrue(spp.verifyProductNameText(expectedProductName),
					"Product name didnot match test case failed");
//    		Assert.assertTrue(spp.verifyProductBrandNameText(expectedBrandName),
//    				"Product name didnot match test case failed");
			int sellingPriceResult = spp.verifySellingPriceNumber(expectedSellingPrice);
			Assert.assertEquals(sellingPriceResult, expectedSellingPrice);

			int displayPriceResult = spp.verifyDisplayPriceNumber(expectedDisplayPrice);
			Assert.assertEquals(displayPriceResult, expectedDisplayPrice);
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(2000);
		}

	}

}
