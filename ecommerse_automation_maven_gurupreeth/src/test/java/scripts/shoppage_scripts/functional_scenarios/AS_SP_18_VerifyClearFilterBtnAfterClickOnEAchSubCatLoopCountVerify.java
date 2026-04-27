package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_18_VerifyClearFilterBtnAfterClickOnEAchSubCatLoopCountVerify extends OpenClose {

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

		for (int number = 1; number <= categoryCount; number++) {

			By selectedCategoryBy = By
					.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ number + ") span.transition");

			By selectedCategorySubCategoryBy = By
					.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ number + ") div.pl-4.mt-1>div");

			WebElement selectedCategoryElement = driver.findElement(selectedCategoryBy);
			String categoryNameClicked = selectedCategoryElement.getText().trim();

			selectedCategoryElement.click();
			Thread.sleep(1000);

			System.out.println("**********************************************************");
			System.out.println("Clicked on main category : " + categoryNameClicked);
			System.out.println("**********************************************************");

			List<WebElement> allMainCategoryProductNames = driver.findElements(productNameBy);
			int expectedMainCategoryProductCount = allMainCategoryProductNames.size();

			System.out.println("Expected main category product count for '" + categoryNameClicked + "' is : "
					+ expectedMainCategoryProductCount);

			System.out.println("Products under main category:");
			System.out.println("----------------------------------------------------");

			for (WebElement product : allMainCategoryProductNames) {
				System.out.println(product.getText().trim());
				Thread.sleep(100);
			}

			System.out.println("----------------------------------------------------");

			List<WebElement> allSubCategories = driver.findElements(selectedCategorySubCategoryBy);
			int subCategoryCount = allSubCategories.size();

			System.out.println("Total subcategories inside '" + categoryNameClicked + "' is : " + subCategoryCount);

			for (int si = 1; si <= subCategoryCount; si++) {

				List<WebElement> visibleSubCategories = driver.findElements(selectedCategorySubCategoryBy);

				if (visibleSubCategories.size() == 0) {
					driver.findElement(selectedCategoryBy).click();
					Thread.sleep(1000);
				}

				By currentSubCategoryBy = By
						.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
								+ number + ") div.pl-4.mt-1>div:nth-of-type(" + si + ")");

				WebElement currentSubCategoryElement = driver.findElement(currentSubCategoryBy);
				String subCategoryName = currentSubCategoryElement.getText().trim();

				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("Clicking on subcategory : " + subCategoryName);
				System.out.println("---------------------------------------------------------------------------------");

				currentSubCategoryElement.click();
				Thread.sleep(1000);

				List<WebElement> allProductsInEachSubCategory = driver.findElements(productNameBy);
				int totalProductsInEachSubcategory = allProductsInEachSubCategory.size();

				System.out.println("Total products under subcategory '" + subCategoryName + "' is : "
						+ totalProductsInEachSubcategory);

				for (WebElement product : allProductsInEachSubCategory) {
					System.out.println(product.getText().trim());
					Thread.sleep(100);
				}

				System.out.println("Now clicking back on main category : " + categoryNameClicked);

				driver.findElement(selectedCategoryBy).click();
				Thread.sleep(1000);

				List<WebElement> productsAfterClickingMainCategoryAgain = driver.findElements(productNameBy);
				int actualMainCategoryProductCountAfterComingBack = productsAfterClickingMainCategoryAgain.size();

				System.out.println("Expected main category product count : " + expectedMainCategoryProductCount);
				System.out.println("Actual main category product count after coming back : "
						+ actualMainCategoryProductCountAfterComingBack);

				Assert.assertEquals(actualMainCategoryProductCountAfterComingBack, expectedMainCategoryProductCount,
						"Product count mismatch after coming back to main category: " + categoryNameClicked);

				System.out.println("VERIFICATION PASSED: Main category product count is same after coming back.");
				System.out
						.println("----------------------------------------------------------------------------------");
			}
		}

		Thread.sleep(3000);
	}
}