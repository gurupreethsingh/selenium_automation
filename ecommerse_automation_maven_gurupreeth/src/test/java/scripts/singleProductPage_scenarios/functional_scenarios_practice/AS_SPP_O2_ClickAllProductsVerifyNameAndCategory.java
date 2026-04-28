package scripts.singleProductPage_scenarios.functional_scenarios_practice;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;
import pom.SingleProductPage;

public class AS_SPP_O2_ClickAllProductsVerifyNameAndCategory extends OpenClose {

	@Test
	public void testClickAllProductsFromShopAndVerifyNameAndCategoryInSingleProductPage() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		Assert.assertTrue(sp.verifyShopPageTitle("Shop | ECODERS"), "Shop page title is not matching");

		int totalProductCount = sp.getTotalProductCards();
		System.out.println("Total products found : " + totalProductCount);

		for (int productNumber = 1; productNumber <= totalProductCount; productNumber++) {

			System.out.println("====================================================");
			System.out.println("VERIFYING PRODUCT NUMBER : " + productNumber);
			System.out.println("====================================================");

			sp = new ShopPage(driver);

			String expectedProductName = sp.getProductNameByProductNumber(productNumber);
			String expectedCategoryName = sp.getProductCategoryNameByProductNumber(productNumber);

			System.out.println("Expected Product Name  : " + expectedProductName);
			System.out.println("Expected Category Name : " + expectedCategoryName);

			boolean clickStatus = sp.clickProductByProductNumber(productNumber);

			Assert.assertTrue(clickStatus, "Unable to click product number : " + productNumber);

			SingleProductPage spp = new SingleProductPage(driver);

			Assert.assertTrue(spp.verifySingleProductPageTitle("Single-Product | ECODERS"),
					"Single product page title is not matching for product number : " + productNumber);

			boolean productNameStatus = spp.verifyProductNameText(expectedProductName);
			boolean categoryNameStatus = spp.verifyProductCategoryNameText(expectedCategoryName);

			Assert.assertTrue(productNameStatus, "Product name mismatch for product number : " + productNumber
					+ " | Expected : " + expectedProductName);

			Assert.assertTrue(categoryNameStatus, "Category name mismatch for product number : " + productNumber
					+ " | Expected : " + expectedCategoryName);

			System.out.println("Product Name Verified  : " + expectedProductName);
			System.out.println("Category Name Verified : " + expectedCategoryName);

			driver.navigate().back();

			sp = new ShopPage(driver);

			Assert.assertTrue(sp.verifyShopPageTitle("Shop | ECODERS"),
					"Shop page title is not matching after navigating back from product number : " + productNumber);

			Thread.sleep(1000);
		}

		System.out.println("====================================================");
		System.out.println("ALL PRODUCTS VERIFIED SUCCESSFULLY");
		System.out.println("====================================================");
	}
}