package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_16_FetchAllProudctsByClickOnAllSubCatInEachMainCat extends OpenClose {

	@Test
	public void testFetchProductsUnderASubcategory() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		By categoryBy = By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div");

		By productNameBy = By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug");

		List<WebElement> allCategories = driver.findElements(categoryBy);
		int totalCategoryCount = allCategories.size();

		System.out.println("Total categories found : " + totalCategoryCount);

		for (int ci = 1; ci <= totalCategoryCount; ci++) {

			WebElement categoryElement = driver.findElement(By.cssSelector(
					"div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type(" + ci + ")"));

			String categoryName = categoryElement.getText().trim();

			System.out.println("\n----------------------------------------------------");
			System.out.println(ci + " - Main Category : " + categoryName);
			System.out.println("----------------------------------------------------");

			WebElement categoryClickableElement = driver.findElement(
					By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ ci + ") span.transition"));

			categoryClickableElement.click();
			Thread.sleep(700);

			By subCategoryBy = By
					.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
							+ ci + ") div.pl-4.mt-1>div");

			List<WebElement> allSubCategories = driver.findElements(subCategoryBy);
			int subCategoryCount = allSubCategories.size();

			System.out.println("Total subcategories inside main category '" + categoryName + "' : " + subCategoryCount);

			if (subCategoryCount == 0) {
				System.out.println("No subcategories found under : " + categoryName);
				continue;
			}

			System.out.println("**************************************************");
			System.out.println("Subcategories under " + categoryName + " are:");
			System.out.println("--------------------------------------------------");

			for (int subCategoryIndex = 1; subCategoryIndex <= subCategoryCount; subCategoryIndex++) {

				WebElement subCategoryElement = driver.findElement(By
						.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(2)>div.space-y-1>div:nth-of-type("
								+ ci + ") div.pl-4.mt-1>div:nth-of-type(" + subCategoryIndex + ")"));

				String subCategoryName = subCategoryElement.getText().trim();

				System.out.println("\n" + subCategoryIndex + " - Subcategory : " + subCategoryName);
				System.out.println("=====================================================================");
				System.out.println("Clicking on '" + subCategoryName + "' and fetching products");
				System.out.println("=====================================================================");

				subCategoryElement.click();
				Thread.sleep(1000);

				List<WebElement> allProducts = driver.findElements(productNameBy);
				int productCount = allProducts.size();

				System.out.println("Total products in '" + subCategoryName + "' subcategory : " + productCount);

				if (productCount == 0) {
					System.out.println("No products found under subcategory : " + subCategoryName);
					continue;
				}

				System.out.println("*************************************************************");
				System.out.println("Products under '" + subCategoryName + "' are:");
				System.out.println("-------------------------------------------------------------");

				for (int pi = 0; pi < productCount; pi++) {
					String productName = allProducts.get(pi).getText().trim();
					System.out.println((pi + 1) + " - " + productName);
				}

				System.out.println("_____________________________________________________________");
			}

			Thread.sleep(1000);
		}

		Thread.sleep(3000);
	}
}