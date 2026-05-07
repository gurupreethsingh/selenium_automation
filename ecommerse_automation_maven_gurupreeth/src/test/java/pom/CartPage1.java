package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CartPage1 extends AllVerifications {

	public CartPage1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCartPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCartPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}

	// find the elements and perform action on those elements.

	// 1. find the total products in the cart page.
	@FindBy(css = "div.flex.flex-col.gap-6>div")
	private List<WebElement> allProducts;

	@FindBy(css = "div.flex.flex-col.gap-6>div>div>div h2")
	private WebElement singleProductName;

	public String getSingleProductName() {
		return singleProductName.getText();
	}

	public int getTotalProductCount() {
		return allProducts.size();
	}

	public boolean verifyTotalProductCount(int expectedCount) {

		return verifyTotalElementsCount(expectedCount, allProducts);
	}

	// product name.
	// selling price.
	// quantity
	// sub total.
	// grandtotal

	public String getProductName(int b) {
		WebElement singleProductName = driver
				.findElement(By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div h2"));
		return getTextFromElement(singleProductName, singleProductName.getText());
	}

	public int getSellingPriceAsInteger(int b) {
		WebElement ProductSellingPrice = driver
				.findElement(By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div p>span"));
		return getIntegerFromElementText(ProductSellingPrice, "Selling Price In Integer.");
	}

	public double getSellingPriceAsDouble(int b) {
		WebElement ProductSellingPrice = driver
				.findElement(By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div p>span"));
		return getDoubleFromElementText(ProductSellingPrice, "Selling price In Double.");
	}

	public int getQuantity(int b) {
		WebElement TotalQuantityElement = driver.findElement(
				By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div:nth-of-type(2)>span"));
		return getIntegerFromElementText(TotalQuantityElement, "Quantity");
	}

	public int getSubTotal(int b) {
		WebElement SubTotalElement = driver.findElement(
				By.cssSelector("div.flex.flex-col.gap-6>div:nth-of-type(" + b + ")>div>div:nth-of-type(3)>span"));
		return getIntegerFromElementText(SubTotalElement, "Sub Total");
	}

	@FindBy(css = "div.mt-10.rounded-3xl.bg-white.p-6.text-center>p")
	private WebElement grandTotal;

	public double getGrandTotal() {
		return getDoubleFromElementText(grandTotal, "Grand Total");
	}

}
