package scripts.shoppage_scenarios_functional_scenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_O1_ClickCategoryFetchAllProducts extends OpenClose {
	@Test
	public void testClickOnAnyOneCategoryFromShopPageFetchAllProductNames() throws InterruptedException {
		// navigate to shop page.

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		// you have to search the category name and click on the category name.

		int totalCategoryCount = sp.gettotalNumberOfCateogories();

		System.out.println("total cateogories found in shop page are : " + totalCategoryCount);

		// loop thought the category count and print all the cateogory names.
		for (int i = 1; i <= totalCategoryCount; i++) {
			// you find the name of the category to get the text and print on the screen.
			String singleCategoryName = sp.getSingleCategoryName(i);
			System.out.println(singleCategoryName);
			Thread.sleep(200);
		}

		// click on office supplies category name.
		boolean clicked = sp.clickOnASingleCategoryName(8);
		System.out.println("Clicked on category : " + clicked);

		// fetch all the products showing ( get the total size of the products showing)
		System.out.println("total products showing are : " + sp.getTotalProductCount());

		// loop through the size and print all the products names.
		for (int i = 1; i <= sp.getTotalProductCount(); i++) {
			// print the product names. one by one .
			System.out.println(sp.getSingleProductName(i));
			Thread.sleep(200);
		}

		// close the browser.

		Thread.sleep(4000);

	}

}
