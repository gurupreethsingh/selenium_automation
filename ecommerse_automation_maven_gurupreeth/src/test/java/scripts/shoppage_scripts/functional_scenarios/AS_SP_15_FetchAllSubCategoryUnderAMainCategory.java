package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_15_FetchAllSubCategoryUnderAMainCategory extends OpenClose {

	@Test
	public void testFetchProductsUnderASubcategory() throws InterruptedException {
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
		WebElement firstCategoryName = null;
		for (WebElement eachCategory : allCategories) {
			String categoryName = eachCategory.getText();
			System.out.println("----------------------------------------------------");
			System.out.println(a + " - " + categoryName);
			System.out.println("----------------------------------------------------");
			Thread.sleep(200);

			firstCategoryName = driver.findElement(
					By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ a + ") span.transition"));

			System.out.println("Clicked on : " + categoryName + "  catogry Name.");
			firstCategoryName.click();
			Thread.sleep(500);

			// total count of sub categories on the clicked category name.
			List<WebElement> allSubCategories = driver.findElements(By.cssSelector(
					"div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div div.pl-4.mt-1>div"));
			int subcategorycount = allSubCategories.size();

			System.out.println(
					"total subcategories inside the main category " + categoryName + " is " + subcategorycount);
			// loop through total subcatgory count and print the text of each sub category

			System.out.println("**************************************************");
			System.out.println("Subcategories under " + categoryName + " are :");
			System.out.println("------------------------------------------------");
			int c1 = 1;
			for (int i = 0; i < subcategorycount; i++) {
				System.out.println(c1 + " - " + allSubCategories.get(i).getText());
				Thread.sleep(200);
				c1++;
			}

			Thread.sleep(2000);

			a++;
		}
		Thread.sleep(3000);
	}
}