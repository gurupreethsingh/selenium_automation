package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_20_SelectAndDeselectAllBrandNamesUnderAllBrandsDdown extends OpenClose {

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
				.findElements(By.cssSelector("div.w-full.rounded-xl.space-y-6>div:nth-of-type(3) div.pl-4>div"));
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
			String previousColor = singleDropDownOption.getAttribute("class");
			System.out.println(previousColor);
			singleDropDownOption.click();
			Thread.sleep(50);
			// after click check the color of the drop down.
			String afterColor = singleDropDownOption.getAttribute("class");
			System.out.println("Text color after drop down is selected .");
			if (afterColor.contains("text-orange-700")) {
				System.out.println("Drop down color is orange, test passed after selection.");
			} else {
				System.out.println("Color test failed after selection of drop down option.");
			}
			System.out.println(afterColor);

			// de-select the drop down.
			singleDropDownOption.click();
			Thread.sleep(50);
			String colorAfterDeselection = singleDropDownOption.getAttribute("class");
			System.out.println("Text color after drop down is Deselected.");

			System.out.println(colorAfterDeselection);
			if (colorAfterDeselection.contains("text-slate-700")) {
				System.out.println("Color of the text is back to black color after deselection.");
			}

			count++;
			Thread.sleep(50);
		}

	}
}