package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_14_ClickEVeryPagNumFetchProdsInEachPgCardView extends OpenClose {

	@Test
	public void testVerifyAssendingorderPricefilter() throws InterruptedException {
		// home page.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(1000);

		List totalProducts = new ArrayList();

		// click on the list view icon
		WebElement listViewButton = driver
				.findElement(By.cssSelector("div.inline-flex.items-center.gap-2.w-full>div>button:nth-of-type(2)"));
		listViewButton.click();
		Thread.sleep(500);

		// find the total pagination buttons.
		int totalPaginationButtons = 0;

		List<WebElement> allButtons = driver.findElements(By.cssSelector("div.mt-8.paginationWrap button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", allButtons.get(0));

		totalPaginationButtons = allButtons.size();
		System.out.println("Total product count : " + totalPaginationButtons);

		Thread.sleep(2000);

		for (int i = 1; i < totalPaginationButtons - 1; i++) {
			String text = allButtons.get(i).getText();
			System.out.println("Clicking on " + (i + 1) + " " + text + " Button");

			// click on button (12345)
			WebElement individualButton = driver
					.findElement(By.cssSelector("div.mt-8.paginationWrap button:nth-of-type(" + i + ")"));
			individualButton.click();
			System.out.println("--------------------------------------------");
			System.out.println("Clicked on then number : " + i);
			System.out.println("--------------------------------------------");
			// find all products
			int totalProductCount = 0;

			List<WebElement> allProducts = driver
					.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
			totalProductCount = allProducts.size();
			System.out.println("Total product count : " + totalProductCount);

			Thread.sleep(2000);

			for (int a = 0; a < totalProductCount; a++) {
				String eachProductName = allProducts.get(a).getText();
				totalProducts.add(eachProductName);
			}
			System.out.println("********************************************************");

			Thread.sleep(1000);

			System.out.println("Total product count from each pages : " + totalProducts.size());

		}
		// print the total produts in the application,
		System.out.println(totalProducts);
		System.out.println("Total product count from all pages : " + totalProducts.size());

	}

}
