package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_26_CheckNweestOrderPriceFilter extends OpenClose {

	String containerButtonParent = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)";
	String newestOrderButton = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(4)";

	String productPriceCss = "main.w-full.flex-1 div.group div.mt-3>div.mt-2.flex.items-baseline.gap-2>span:first-child";
	String productNameCss = "main.w-full.flex-1 div.group div.mt-3>p:first-child";

	@Test
	public void testVerifyNewestOrderAndPrintProducts() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		Thread.sleep(1000);

		// scroll to sort container
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sortByContainer = driver.findElement(By.cssSelector(containerButtonParent));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", sortByContainer);
		Thread.sleep(500);

		// ✅ Click NEWEST button
		driver.findElement(By.cssSelector(newestOrderButton)).click();
		Thread.sleep(1000); // wait for UI update

		// ✅ Fetch product names and prices
		List<WebElement> productNames = driver.findElements(By.cssSelector(productNameCss));
		List<WebElement> productPrices = driver.findElements(By.cssSelector(productPriceCss));

		System.out.println("====================================");
		System.out.println("Products in NEWEST Order:");
		System.out.println("====================================");

		for (int i = 0; i < productNames.size(); i++) {

			String name = productNames.get(i).getText();

			String priceText = productPrices.get(i).getText();
			String cleanPrice = priceText.replaceAll("[^0-9]", "");

			System.out.println((i + 1) + ". " + name + " --> ₹" + cleanPrice);
		}

		System.out.println("====================================");
	}
}