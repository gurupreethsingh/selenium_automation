package scripts.shoppage_scripts.caterogysection_functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_03_PintAllCateogoryNames extends OpenClose {

	// add a test function to do the automation.

	@Test
	public void testFindTotalCategoryCount() throws InterruptedException {
		// you will be in homepage.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		// find the total cateogry count.
		int count = 0;

		List<WebElement> allCategories = driver
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div"));

		count = allCategories.size();

		System.out.println("Total categories found : " + count);

		Thread.sleep(2000);

		int a = 1;
		for (WebElement eachCategory : allCategories) {
			String categoryName = eachCategory.getText();
			System.out.println(a + ". " + categoryName);
			Thread.sleep(100);
			a++;
		}

	}
}
