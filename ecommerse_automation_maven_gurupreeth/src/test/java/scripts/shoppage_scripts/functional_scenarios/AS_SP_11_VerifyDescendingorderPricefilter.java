package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_11_VerifyDescendingorderPricefilter extends OpenClose {

	@Test
	public void testVerifyAssendingorderPricefilter() throws InterruptedException {
		// home page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);
		// find the total product count.
		int totalProductCount = 0;

		List<WebElement> allProducts = driver
				.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
		totalProductCount = allProducts.size();
		System.out.println("Total product count : " + totalProductCount);

		List<WebElement> allProductsSellingPrice = driver.findElements(By.cssSelector(
				"main.w-full.flex-1 div.group div.mt-3 div.mt-2.flex.items-baseline.gap-2>span:first-child"));

		Thread.sleep(2000);

		System.out.println("Before Applying/ clicking the accending order price button");
		System.out.println("********************************************************");
		for (int i = 0; i < totalProductCount; i++) {
			String eachProductName = allProducts.get(i).getText();
			String eachProductPrice = allProductsSellingPrice.get(i).getText();
//			System.out.println((i + 1) + " - " + eachProductName + " " + eachProductPrice);
			System.out.println(eachProductPrice);
		}
		System.out.println("********************************************************");

		Thread.sleep(1000);

		// click on the descending order price button
		WebElement descendingOrderPriceButton = driver
				.findElement(By.cssSelector("div.flex.flex-wrap.gap-2 button:nth-of-type(3)"));
		Thread.sleep(500);
		descendingOrderPriceButton.click();
		Thread.sleep(2000);

		List<WebElement> newallProducts = driver
				.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
		totalProductCount = newallProducts.size();

		List<WebElement> newallProductsSellingPrice = driver.findElements(By.cssSelector(
				"main.w-full.flex-1 div.group div.mt-3 div.mt-2.flex.items-baseline.gap-2>span:first-child"));
		System.out.println("Total product count : " + totalProductCount);

		System.out.println("After clicking on the accending order price button");
		System.out.println("********************************************************");
		// print the product names and prices.
		for (int i = 0; i < totalProductCount; i++) {
			String eachProductName = newallProducts.get(i).getText();
			String eachProductPrice = newallProductsSellingPrice.get(i).getText();
//			System.out.println((i + 1) + " - " + eachProductName + " " + eachProductPrice);
			System.out.println(eachProductPrice);
		}
		System.out.println("********************************************************");

		Thread.sleep(2000);
	}

}
