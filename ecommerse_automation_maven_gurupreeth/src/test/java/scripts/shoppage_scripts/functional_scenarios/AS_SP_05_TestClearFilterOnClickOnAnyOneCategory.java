package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_05_TestClearFilterOnClickOnAnyOneCategory extends OpenClose {

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

		int a = 0;
		for (WebElement eachCategory : allCategories) {
			String categoryName = eachCategory.getText();
			System.out.println(a + " - " + categoryName);
			Thread.sleep(200);
			a++;
		}

		HashMap<String, String> allprod = new HashMap<String, String>();

		// go and print all the products, before clicking on any category.
		// find the total product count.
		int totalProductCount = 0;
		List<WebElement> allProducts = driver
				.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
		totalProductCount = allProducts.size();
		System.out.println("Total product count : " + totalProductCount);

		System.out.println("Before clicking on any category name");
		System.out.println("********************************************************");
		for (int i = 0; i < totalProductCount; i++) {
			String eachProductName = allProducts.get(i).getText();
			System.out.println(eachProductName);
			allprod.put(eachProductName, "");
		}
		System.out.println("********************************************************");

		System.out.println("Mu hashmap collection right now is \n");
		System.out.println(allprod);
		System.out.println("**************************************************");

		Thread.sleep(1000);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number between 1 and " + (count) + " To click on that particular category");
		int number = sc.nextInt();

		WebElement firstCategoryName = driver.findElement(
				By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
						+ number + ") span.transition"));

		Thread.sleep(2000);

		String individualCategoryName = firstCategoryName.getText();

		System.out.println("Clicked on : " + individualCategoryName + "  catogry Name.");

		firstCategoryName.click();

		Thread.sleep(1000);

		// after you have clicked on any category name.
		System.out.println("After clicking on the category name, selected by user ");
		System.out.println("Total products in that category came to be ");
		System.out.println("*********************************************************");
		int totalProductCountForThatCateogry = 0;
		List<WebElement> allProductsInClickedCategory = driver
				.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
		totalProductCountForThatCateogry = allProductsInClickedCategory.size();
		System.out.println("Total product count in clicked category : " + totalProductCountForThatCateogry);

		System.out.println("after clicking on any category name");
		System.out.println("********************************************************");
		for (int i = 0; i < totalProductCountForThatCateogry; i++) {
			String eachProductName = allProductsInClickedCategory.get(i).getText();
			System.out.println(eachProductName);
		}
		System.out.println("********************************************************");

		Thread.sleep(1000);

		// click on the clear filter button

		WebElement clearFilterButton = driver
				.findElement(By.cssSelector("div.w-full.rounded-xl.space-y-6>div.flex.justify-center button"));
		Thread.sleep(500);
		clearFilterButton.click();
		Thread.sleep(500);

		// fetch all the original products.

		// go and print all the products, before clicking on clear filter button.
		// find the total product count.
		int totalOriginalProductCount = 0;
		List<WebElement> allOriginalProducts = driver
				.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));
		totalOriginalProductCount = allOriginalProducts.size();
		System.out.println("Total product count : " + totalOriginalProductCount);

		System.out.println("After clicking on any Clear Filter button");
		System.out.println("********************************************************");
		for (int i = 0; i < totalOriginalProductCount; i++) {
			String eachOrignalProductName = allOriginalProducts.get(i).getText();
			System.out.println(eachOrignalProductName);
			// update values using key.

			if (allprod.containsKey(eachOrignalProductName)) {
				allprod.put(eachOrignalProductName, eachOrignalProductName);
			}
		}
		System.out.println("********************************************************");

		System.out.println("--------------------------------------------------------");
		System.out.println(allprod);
		System.out.println("__________________________________________________________");

		Thread.sleep(1000);

	}
}
