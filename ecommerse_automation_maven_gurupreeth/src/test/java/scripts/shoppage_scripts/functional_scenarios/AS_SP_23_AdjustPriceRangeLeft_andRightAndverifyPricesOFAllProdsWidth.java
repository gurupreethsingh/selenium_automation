package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_23_AdjustPriceRangeLeft_andRightAndverifyPricesOFAllProdsWidth extends OpenClose {

	String priceFilterCss = "div.w-full.rounded-xl.space-y-6>div:nth-of-type(4) span.relative.select-none";
	String leftSliderCss = priceFilterCss + ">span:nth-of-type(2)";
	String leftValueCss = leftSliderCss + ">span";
	String rightSliderCss = priceFilterCss + ">span:nth-of-type(3)";
	String rightValueCss = rightSliderCss + ">span";

	String productPriceCss = "main.w-full.flex-1 div.group div.mt-3>div.mt-2.flex.items-baseline.gap-2>span:first-child";

	@Test
	public void testAdjustPriceRangeLeftAndRightVerifyAllProductPrices() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");

		Thread.sleep(2000);

		Actions action = new Actions(driver);

		WebElement priceSliderBar = driver.findElement(By.cssSelector(priceFilterCss));
		int sliderWidth = priceSliderBar.getSize().width;

		int leftMoveOffset = (int) (sliderWidth * 0.02); // move left slider 10% right
		int rightMoveOffset = (int) (sliderWidth * 0.85); // move right slider 65% left

		String lowPriceBefore = getSliderValue(leftValueCss);
		String highPriceBefore = getSliderValue(rightValueCss);

		System.out.println("Low price before moving  : " + lowPriceBefore);
		System.out.println("High price before moving : " + highPriceBefore);

		moveSlider(leftSliderCss, leftMoveOffset, action);
		Thread.sleep(1000);

		moveSlider(rightSliderCss, -rightMoveOffset, action);
		Thread.sleep(1000);

		String lowPriceAfter = getSliderValue(leftValueCss);
		String highPriceAfter = getSliderValue(rightValueCss);

		System.out.println("Low price after moving   : " + lowPriceAfter);
		System.out.println("High price after moving  : " + highPriceAfter);

		Assert.assertNotEquals(lowPriceBefore, lowPriceAfter, "Left price indicator did not move.");
		Assert.assertNotEquals(highPriceBefore, highPriceAfter, "Right price indicator did not move.");

		int low = Integer.parseInt(lowPriceAfter);
		int high = Integer.parseInt(highPriceAfter);

		System.out.println("------------------------------------------------------------------------");
		System.out.println("The new price range is from " + low + " to " + high);
		System.out.println("------------------------------------------------------------------------");

		List<WebElement> allProductsPrices = driver.findElements(By.cssSelector(productPriceCss));

		System.out.println("Total products under this price range are : " + allProductsPrices.size());

		for (WebElement eachPriceValue : allProductsPrices) {

			String priceText = eachPriceValue.getText(); // Example: ₹4,999
			int productPrice = cleanPriceAndConvertToInt(priceText);

			System.out.println("Product price : " + productPrice);

			Assert.assertTrue(productPrice >= low && productPrice <= high,
					"Product price is out of range. Price: " + productPrice + ", Range: " + low + " - " + high);

			System.out.println("Price " + productPrice + " is within range " + low + " and " + high);
		}

		System.out.println("All product prices are verified successfully.");
		Thread.sleep(3000);
	}

	public void moveSlider(String sliderCss, int xOffset, Actions action) {
		WebElement slider = driver.findElement(By.cssSelector(sliderCss));

		action.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
	}

	public String getSliderValue(String valueCss) {
		return driver.findElement(By.cssSelector(valueCss)).getAttribute("aria-valuenow");
	}

	public int cleanPriceAndConvertToInt(String priceText) {
		String cleanPrice = priceText.replaceAll("[^0-9]", "");
		return Integer.parseInt(cleanPrice);
	}
}