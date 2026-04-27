package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_23_AdjustPriceRangeLeft_andRightAndverifyPricesOFAllProds extends OpenClose {

	@Test
	public void testAdjustPriceRangeLeftAndRight() throws InterruptedException {

		// Navigate to shop page
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		Thread.sleep(2000);

		Actions action = new Actions(driver);

		// ================================
		// LOCATORS
		// ================================

		String leftSliderButtonCss = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(4) span.relative.select-none>span:nth-of-type(2)";

		String leftSliderValueCss = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(4) span.relative.select-none>span:nth-of-type(2)>span";

		String rightSliderButtonCss = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(4) span.relative.select-none>span:nth-of-type(3)";

		String rightSliderValueCss = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(4) span.relative.select-none>span:nth-of-type(3)>span";

		// ================================
		// LEFT SLIDER
		// ================================

		WebElement leftSlider = driver.findElement(By.cssSelector(leftSliderButtonCss));
		WebElement leftValueBeforeElement = driver.findElement(By.cssSelector(leftSliderValueCss));

		String lowPriceBefore = leftValueBeforeElement.getAttribute("aria-valuenow");
		System.out.println("Low price before moving  : " + lowPriceBefore);

		// Move LEFT slider → RIGHT
		action.clickAndHold(leftSlider).moveByOffset(1, 0).release().perform();

		Thread.sleep(1000);

		WebElement leftValueAfterElement = driver.findElement(By.cssSelector(leftSliderValueCss));
		String lowPriceAfter = leftValueAfterElement.getAttribute("aria-valuenow");

		System.out.println("Low price after moving   : " + lowPriceAfter);

		// ================================
		// RIGHT SLIDER
		// ================================

		WebElement rightSlider = driver.findElement(By.cssSelector(rightSliderButtonCss));
		WebElement rightValueBeforeElement = driver.findElement(By.cssSelector(rightSliderValueCss));

		String highPriceBefore = rightValueBeforeElement.getAttribute("aria-valuenow");
		System.out.println("High price before moving : " + highPriceBefore);

		// Move RIGHT slider → LEFT
		action.clickAndHold(rightSlider).moveByOffset(-300, 0).release().perform();

		Thread.sleep(1000);

		WebElement rightValueAfterElement = driver.findElement(By.cssSelector(rightSliderValueCss));
		String highPriceAfter = rightValueAfterElement.getAttribute("aria-valuenow");

		System.out.println("High price after moving  : " + highPriceAfter);

		// ================================
		// VALIDATION
		// ================================

		if (!lowPriceBefore.equals(lowPriceAfter)) {
			System.out.println("✅ Left price indicator moved to RIGHT successfully");
		} else {
			System.out.println("❌ Left price indicator did NOT move");
		}

		if (!highPriceBefore.equals(highPriceAfter)) {
			System.out.println("✅ Right price indicator moved to LEFT successfully");
		} else {
			System.out.println("❌ Right price indicator did NOT move");
		}

		System.out.println("------------------------------------------------------------------------");
		System.out.println("The new price range is from " + lowPriceAfter + " to " + highPriceAfter);
		System.out.println("------------------------------------------------------------------------");

		// fetch the price of all the products and should check if the price of the
		List<WebElement> allProductsPrices = driver.findElements(By.cssSelector(
				"main.w-full.flex-1 div.group div.mt-3>div.mt-2.flex.items-baseline.gap-2>span:first-child"));
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Total products under this price range " + lowPriceAfter + " and " + highPriceAfter
				+ " are : " + allProductsPrices.size());
		System.out.println("--------------------------------------------------------------------------------");
		for (WebElement eachPriceValue : allProductsPrices) {
			System.out.println(eachPriceValue.getText());
		}

		System.out.println("_______________________________________________________________________________");

		// convert the low price value high price value into numbers (integers) for
		// validation.
		int low = Integer.parseInt(lowPriceAfter);
		int high = Integer.parseInt(highPriceAfter);

		// now remove the rupees symobol from all the product prices you have fetched.
		// and compare the final price not to be less than low and not to be more than
		// high.

		System.out.println("------------------------------------------------------------");
		System.out.println("Validating all product prices are within range...");
		System.out.println("------------------------------------------------------------");

		for (WebElement eachPriceValue : allProductsPrices) {

			String priceText = eachPriceValue.getText(); // ₹4,999. 4999

			// CLEAN THE FETCHED PRICE, replace the rupees symbol with null or empty
			// string(dont give space in doulbe quotes")
			String cleanPriceString = priceText.replaceAll("[^0-9]", "");

			int price = Integer.parseInt(cleanPriceString); // convert all the prices into integers for comparison.

			System.out.println("Product Price in Number/Integer value : " + price);

			// VALIDATION of price
			if (price < low) {
				System.out.println("❌ Price is LESS than minimum range: " + price);
			} else if (price > high) {
				System.out.println("❌ Price is GREATER than maximum range: " + price);
			} else {
				System.out.println("Price : " + price + " is within range " + low + " and " + high + ".");
			}
		}

		Thread.sleep(3000);
	}
}