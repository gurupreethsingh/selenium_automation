package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_17_VerifyClearFilterButtonAfterClickingOnEAchSubCategory extends OpenClose {

	@Test
	public void testClearFilterButtonWorksAfterClickingOnAnySubCategoryName() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		By categoryListBy = By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div");

		By productNameBy = By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug");

		List<WebElement> allCategories = driver.findElements(categoryListBy);
		int categoryCount = allCategories.size();

		System.out.println("-----------------------------------");
		System.out.println("Total categories found : " + categoryCount);
		System.out.println("------------------------------------");

		for (int i = 1; i <= categoryCount; i++) {
			WebElement categoryNameElement = driver.findElement(
					By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ i + ") span.transition"));

			System.out.println(i + " - " + categoryNameElement.getText().trim());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Enter a number between 1 and " + categoryCount + " to click on that category");
		System.out.println("-----------------------------------------------------------------------------------");

		int number = sc.nextInt();

		System.out.println("The user selection is " + number);

		By selectedCategoryBy = By
				.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
						+ number + ") span.transition");

		WebElement selectedCategoryElement = driver.findElement(selectedCategoryBy);
		String categoryNameClicked = selectedCategoryElement.getText().trim();

		selectedCategoryElement.click();
		Thread.sleep(1000);

		System.out.println("**********************************************************");
		System.out.println("Clicked on : " + categoryNameClicked + " category name.");
		System.out.println("**********************************************************");

		System.out.println("Fetching all products under main category: " + categoryNameClicked);

		List<WebElement> allMainCategoryProductNames = driver.findElements(productNameBy);
		int totalMainCategoryProducts = allMainCategoryProductNames.size();

		System.out.println(
				"Total products under main category '" + categoryNameClicked + "' is " + totalMainCategoryProducts);

		System.out.println("----------------------------------------------------");
		for (WebElement eachMainCategoryProductName : allMainCategoryProductNames) {
			System.out.println(eachMainCategoryProductName.getText().trim());
			Thread.sleep(100);
		}
		System.out.println("----------------------------------------------------");

		By selectedCategorySubCategoryBy = By
				.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
						+ number + ") div.pl-4.mt-1>div");

		List<WebElement> allSubCategories = driver.findElements(selectedCategorySubCategoryBy);
		int subCategoryCount = allSubCategories.size();

		System.out.println(
				"Total subcategories inside main category '" + categoryNameClicked + "' is " + subCategoryCount);

		for (int si = 1; si <= subCategoryCount; si++) {

			// Re-open category if needed.
			WebElement categoryElementBeforeSubClick = driver.findElement(selectedCategoryBy);
			categoryElementBeforeSubClick.click();
			Thread.sleep(500);
			categoryElementBeforeSubClick = driver.findElement(selectedCategoryBy);
			categoryElementBeforeSubClick.click();
			Thread.sleep(700);

			By currentSubCategoryBy = By
					.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ number + ") div.pl-4.mt-1>div:nth-of-type(" + si + ")");

			WebElement currentSubCategoryElement = driver.findElement(currentSubCategoryBy);
			String subCategoryName = currentSubCategoryElement.getText().trim();

			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Clicking on " + subCategoryName + " and fetching products under this subcategory");
			System.out.println("---------------------------------------------------------------------------------");

			currentSubCategoryElement.click();
			Thread.sleep(1000);

			List<WebElement> allProductsInEachSubCategory = driver.findElements(productNameBy);
			int totalProductsInEachSubcategory = allProductsInEachSubCategory.size();

			System.out.println(
					"Total products under subcategory '" + subCategoryName + "' is " + totalProductsInEachSubcategory);

			System.out.println("----------------------------------------------------");
			for (WebElement eachSubCategoryProductName : allProductsInEachSubCategory) {
				System.out.println(eachSubCategoryProductName.getText().trim());
				Thread.sleep(100);
			}
			System.out.println("----------------------------------------------------------------------------------");
		}

		sc.close();
		Thread.sleep(3000);
	}
}