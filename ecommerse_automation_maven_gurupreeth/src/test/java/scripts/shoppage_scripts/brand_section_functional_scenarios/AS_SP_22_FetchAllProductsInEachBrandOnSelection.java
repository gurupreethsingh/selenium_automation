package scripts.shoppage_scripts.brand_section_functional_scenarios;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_22_FetchAllProductsInEachBrandOnSelection extends OpenClose {

	@Test
	public void testFetchAllTheProductsUnderEachBrandAndPrintTheNames() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement allBrandsDropDownIcon = driver.findElement(
				By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3)>div.justify-between>svg"));
		allBrandsDropDownIcon.click();

		List<WebElement> allDropDownOptions = driver
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3) div.pl-4>div>input"));

		System.out.println("Total dropdown options are : " + allDropDownOptions.size());

		Set<String> totalProductsInAllBrands = new LinkedHashSet<>();

		for (int i = 0; i < allDropDownOptions.size(); i++) {

			allDropDownOptions = driver.findElements(
					By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3) div.pl-4>div>input"));

			WebElement singleBrandCheckbox = allDropDownOptions.get(i);

			js.executeScript("arguments[0].scrollIntoView({block:'center'});", singleBrandCheckbox);
			Thread.sleep(300);

			singleBrandCheckbox.click();
			Thread.sleep(1000);

			System.out.println("Brand " + (i + 1) + " selected.");

			List<WebElement> allProductsUnderEachBrand = driver
					.findElements(By.cssSelector("main.w-full.flex-1 div.group div.mt-3>p.leading-snug"));

			System.out.println("Products found for this brand on current page: " + allProductsUnderEachBrand.size());

			for (WebElement eachProduct : allProductsUnderEachBrand) {
				String productName = eachProduct.getText().trim();

				if (!productName.isEmpty()) {
					totalProductsInAllBrands.add(productName);
				}
			}

			singleBrandCheckbox.click();
			Thread.sleep(700);

			System.out.println("Total unique products collected till now: " + totalProductsInAllBrands.size());
			System.out.println("-------------------------------------------------");
		}

		System.out.println("Final total unique products in all brands are : " + totalProductsInAllBrands.size());

		int productNumber = 1;
		for (String productName : totalProductsInAllBrands) {
			System.out.println(productNumber + ". " + productName);
			productNumber++;
		}
	}
}