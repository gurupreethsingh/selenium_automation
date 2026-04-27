package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_24_CheckAscendingOrderPriceFilter extends OpenClose {

	String containerButtonParent = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)";

	String defaultButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(1)";

	String ascendingOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(2)";
	String descendingOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(3)";
	String newestOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(4)";
	String oldestOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(5)";
	String popularOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(6)";

	String productPriceCss = "main.w-full.flex-1 div.group div.mt-3>div.mt-2.flex.items-baseline.gap-2>span:first-child";

	@Test
	public void testAdjustPriceRangeLeftAndRightVerifyAllProductPrices() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		Thread.sleep(1000);

		// scroll down to the sort by container
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sortByContainer = driver.findElement(By.cssSelector(containerButtonParent));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", sortByContainer);
		Thread.sleep(100);

		// find the ascending order button and click on it.
		driver.findElement(By.cssSelector(ascendingOrderButton)).click();
		Thread.sleep(100);
		// now fetch all the product prices and print them. ( verify they are displyed
		// in ascending order or not.
		List<WebElement> allProductsPrices = driver.findElements(By.cssSelector(productPriceCss));
		System.out.println("Total products are : " + allProductsPrices.size());
		System.out.println("--------------------------------------------------");

//		for (WebElement eachProductPrice : allProductsPrices) {
//			String eachPriceInString = eachProductPrice.getText();
//			String cleanPrices = eachPriceInString.replaceAll("[^0-9]", "");
//			int price = Integer.parseInt(cleanPrices);
//			System.out.println(price);
//			Thread.sleep(50);
//		}

		// verification.

		int previousPrice = -1;

		System.out.println("--------------------------------------------------");
		System.out.println("Verifying Ascending Order...");
		System.out.println("--------------------------------------------------");

		for (WebElement eachProductPrice : allProductsPrices) {

			String priceText = eachProductPrice.getText();
			String cleanPrice = priceText.replaceAll("[^0-9]", "");
			int currentPrice = Integer.parseInt(cleanPrice);

			System.out.println("Current Price: " + currentPrice);

			if (previousPrice != -1 && currentPrice < previousPrice) {
				System.out.println("❌ NOT in ascending order");
				System.out.println("Previous: " + previousPrice + " | Current: " + currentPrice);
				return; // stop test immediately
			}

			previousPrice = currentPrice;
		}

		System.out.println("====================================");
		System.out.println("All products are in ASCENDING order");
		System.out.println("====================================");

	}
}