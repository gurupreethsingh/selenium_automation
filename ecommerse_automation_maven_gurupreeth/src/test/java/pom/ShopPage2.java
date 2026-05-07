package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ShopPage2 extends AllVerifications {

	public ShopPage2(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// PAGE VERIFICATION
	public boolean verifySingleProductPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySingleProductPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	@FindBy(css = "div.productCardPerf")
	private List<WebElement> allProducts;

	public int getTotalProducts() {
		int totalProducts = allProducts.size();
		return totalProducts;
	}

	public void clickOnAllProductsOneByOne() {
		int totalProducts = getTotalProducts();
		for (int i = 1; i <= totalProducts; i++) {
			clickOnElement(allProducts.get(i), "Product from Shop page.");
		}
	}

	public boolean clickOnAnyOneProductBasedOnIndex(int i) {
		WebElement singleProduct = driver.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + i + ")"));
		return clickOnElement(singleProduct, "Single Product from Shop page.");
	}

	public String getProductName(int i) {
		WebElement expectedProductName = driver
				.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + i + ")>div:last-child>p:first-child"));
		return getTextFromElement(expectedProductName, expectedProductName.getText());
	}

	public int getProductSellingPriceAsInteger(int i) {

		WebElement expectedProductSellingPrice = driver.findElement(By.cssSelector(
				"div.productCardPerf:nth-of-type(" + i + ")>div:last-child>div.shopProductPriceRow>span.priceSelling"));
		return getIntegerFromElementText(expectedProductSellingPrice, "Selling Price");

	}

	public double getProductSellingPriceAsDouble(int i) {
		WebElement expectedProductSellingPrice = driver.findElement(By.cssSelector(
				"div.productCardPerf:nth-of-type(" + i + ")>div:last-child>div.shopProductPriceRow>span.priceSelling"));
		return getDoubleFromElementText(expectedProductSellingPrice, "Selling price");

	}

}
