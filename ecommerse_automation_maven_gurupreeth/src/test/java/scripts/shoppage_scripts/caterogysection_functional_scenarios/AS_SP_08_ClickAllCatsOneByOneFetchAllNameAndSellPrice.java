package scripts.shoppage_scripts.caterogysection_functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_08_ClickAllCatsOneByOneFetchAllNameAndSellPrice extends OpenClose {

	// add a test function to do the automation.

	@Test
	public void testFindTotalCategoryCount() throws InterruptedException {
		// you will be in home page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		// find the total category count.
		int count = 0;

		List<WebElement> allCategories = driver
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div"));
		count = allCategories.size();
		System.out.println("Total categories found : " + count);

		Thread.sleep(2000);
		int a = 1;
		WebElement firstCategoryName = null;
		for (WebElement eachCategory : allCategories) {
			String categoryName = eachCategory.getText();
			System.out.println(a + " - " + categoryName);
			Thread.sleep(200);

			firstCategoryName = driver.findElement(
					By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ a + ") span.transition"));

			System.out.println("Clicked on : " + categoryName + "  catogry Name.");
			firstCategoryName.click();
			Thread.sleep(500);
			// go find the total count of all the products in each category clicked.
			List<WebElement> allProducts = driver
					.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
			int eachCategoryTotalProductsCount = allProducts.size();

			List<WebElement> allProductsSellingPrice = driver.findElements(By.cssSelector(
					"main.w-full.flex-1 div.group div.mt-3 div.mt-2.flex.items-baseline.gap-2>span:first-child"));
			int allProductsSellingPriceCount = allProductsSellingPrice.size();

			System.out.println(
					"The total products in " + categoryName + " category is " + eachCategoryTotalProductsCount);

			System.out.println("The total selling prices of all products in " + categoryName + " category is "
					+ allProductsSellingPriceCount);

			System.out.println("*************************************************************");
			System.out.println("Products under " + categoryName + " are\n");
			// loog though the count to print the names of all the products.
			for (int i = 0; i < eachCategoryTotalProductsCount; i++) {
				String eachProductName = allProducts.get(i).getText();
				String eachProductSellingPrice = allProductsSellingPrice.get(i).getText();
				System.out.println(i + 1 + " - " + eachProductName + " selling price " + eachProductSellingPrice);
				Thread.sleep(200);
				System.out.println("____________________________________________________");
			}

			Thread.sleep(2000);

			a++;
		}
		Thread.sleep(3000);
	}
}
