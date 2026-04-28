package scripts.single_product_page.functional_scenarios;

import java.time.Duration;
import java.util.Scanner;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage1;
import pom.SingleProductPage;

public class AS_SPP_O1_ClickOnAProdFromShopNavToSPP extends OpenClose {

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

		System.out.println(
				"Enter the value from 1 to " + totalProducts + " To click on that product based on product number.");
		Scanner sc = new Scanner(System.in);
		int productNumber = sc.nextInt();

		sp1.clickProductByProductNumber(productNumber);

		// navigated to single product page.
		SingleProductPage spp = new SingleProductPage(driver);
		spp.verifySingleProductPageTitle("Single-Product | ECODERS");

		Thread.sleep(3000);

	}

}
