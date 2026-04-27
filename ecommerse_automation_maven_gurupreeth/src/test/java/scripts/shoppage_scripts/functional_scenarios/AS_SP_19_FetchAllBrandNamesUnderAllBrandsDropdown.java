package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_19_FetchAllBrandNamesUnderAllBrandsDropdown extends OpenClose {

	@Test
	public void testFetchAndPrintAllBrandNamesUnderAllBrandsDropdown() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);

		// find and click on the AllBrands drop down (name and icon) and click on it.

//		WebElement AllBrandsDropDownName = driver.findElement(
//				By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3)>div.justify-between>span"));
//		System.out.println("Name of the drop down is : " + AllBrandsDropDownName.getText());
//		AllBrandsDropDownName.click();

		WebElement AllBrandsDropDownIcon = driver.findElement(
				By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3)>div.justify-between>svg"));
		AllBrandsDropDownIcon.click();

		// find the total count. of all the options.
		List<WebElement> allDropDownOptions = driver
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3) div.pl-4>div>span"));
		int dropDownOptionsCount = allDropDownOptions.size();
		System.out.println("Total dropdown options are : " + dropDownOptionsCount);

		int count = 1;
		for (WebElement eachDropDownOptionName : allDropDownOptions) {
			System.out.println(count + ". " + eachDropDownOptionName.getText());
			count++;
			Thread.sleep(50);
		}
		Thread.sleep(3000);
	}
}