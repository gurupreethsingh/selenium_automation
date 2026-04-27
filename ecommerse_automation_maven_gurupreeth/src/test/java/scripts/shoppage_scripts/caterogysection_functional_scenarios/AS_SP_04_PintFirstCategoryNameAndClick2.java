package scripts.shoppage_scripts.caterogysection_functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_04_PintFirstCategoryNameAndClick2 extends OpenClose {

	// add a test function to do the automation.

	@Test
	public void testFindTotalCategoryCount() throws InterruptedException {
		// you will be in homepage.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		WebElement firstCategoryName = driver.findElement(By.cssSelector(
				"div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type(1) span.transition"));

		Thread.sleep(2000);

		String automotiveCategoryName = firstCategoryName.getText();

		System.out.println(automotiveCategoryName);

	}
}
