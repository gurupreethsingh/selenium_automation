package scripts.singleProductPage_scenarios.functional_scenarios_practice;

import java.time.Duration;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;
import pom.SingleProductPage;

public class AS_SPP_O1_clickProdtInShopPgVerifyCatNameInSPP extends OpenClose {
	@Test
	public void testClickOnAnyProductFromShopAndVerifyCategoryNameInSingleProductPage() throws InterruptedException {
		// open the shop page
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		// fetch all the information about the product clicked from the shop all page.
		int totalProductCount = sp.getTotalProductCards();
		System.out.println("Total products found : " + totalProductCount);

		System.out.println("Select any value from 1 to " + totalProductCount + " to print the product details.");

		// take the user input to print the details of the products.
		Scanner sc = new Scanner(System.in);
		int productNumber = sc.nextInt();

		sp.getProductCardByProductNumber(productNumber);

		String productNameClicked = sp.getProductNameByProductNumber(productNumber);
		String categoryNameClicked = sp.getProductCategoryNameByProductNumber(productNumber);

		System.out.println("Clicked Product Name: " + productNameClicked);
		System.out.println("Clicked Category Name: " + categoryNameClicked);

		sp.clickProductByProductNumber(productNumber);

		SingleProductPage spp = new SingleProductPage(driver);
		spp.verifySingleProductPageTitle("Single-Product | ECODERS");

		boolean isProductNameMatching = spp.verifyProductNameText(productNameClicked);
		boolean isCategoryMatching = spp.verifyProductCategoryNameText(categoryNameClicked);

		Assert.assertTrue(isProductNameMatching, "Product name is not matching");
		Assert.assertTrue(isCategoryMatching, "Category name is not matching");
		Thread.sleep(3000);
	}

}
