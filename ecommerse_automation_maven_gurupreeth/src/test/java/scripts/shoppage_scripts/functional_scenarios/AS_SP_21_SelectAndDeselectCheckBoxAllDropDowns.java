package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_21_SelectAndDeselectCheckBoxAllDropDowns extends OpenClose {

	@Test
	public void testClearFilterButtonWorksAfterClickingOnAnySubCategoryName() throws InterruptedException {

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
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3) div.pl-4>div>input"));
		int dropDownOptionsCount = allDropDownOptions.size();
		System.out.println("Total dropdown options are : " + dropDownOptionsCount);

		int count = 0;
		for (WebElement eachDropDownOptionName : allDropDownOptions) {
			System.out.println(count + 1 + ". " + eachDropDownOptionName.getText());

			WebElement singleDropDownOption = allDropDownOptions.get(count);
			// before click check the color of the drop down.
			System.out.println("Text color before drop down selection");
			// scroll down to the drop down option.
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", singleDropDownOption);

			singleDropDownOption.click();
			Thread.sleep(50);
			// after click check the color of the drop down.
			boolean isSelected = singleDropDownOption.isSelected();
			if (isSelected == true) {
				System.out.println("Drop down is selected.");
			} else {
				System.out.println("Drop Down is not selected.");
			}

			// de-select the drop down.
			System.out.println("AFter Deselection.");
			singleDropDownOption.click();

			boolean isDeSelected = singleDropDownOption.isSelected();
			if (isDeSelected == false) {
				System.out.println("Drop down is successfully De-selected.");
			} else {
				System.out.println("Drop Down is still selected.");
			}

			count++;
			Thread.sleep(50);
			System.out.println("-------------------------------------------------");
		}

	}
}