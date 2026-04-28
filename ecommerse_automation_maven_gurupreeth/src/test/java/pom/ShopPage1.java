package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ShopPage1 extends AllVerifications {

	public ShopPage1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyShopPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyShopPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	@FindBy(css = "div.group.relative.rounded-2xl.bg-white")
	private List<WebElement> allProductCard;

	public int getTotalProductCards() {
		return allProductCard.size();
	}

	// find any one product on which we want to click.
	@FindBy(css = "div.group.relative.rounded-2xl.bg-white:nth-of-type(6)")
	private WebElement singleProduct;

	public String fetchSingleProductName(int productNumber) {
		WebElement product = clickProductByProductName(productNumber);
		WebElement productName = driver.findElement(By.cssSelector(
				"div.group.relative.rounded-2xl.bg-white:nth-of-type(" + productNumber + ")>div.mt-3>p:first-child"));
		String productNameText = productName.getText();
		return productNameText;
	}

	public String fetchSingleProductBrandName(int productNumber) {
		WebElement product = clickProductByProductName(productNumber);
		WebElement productBrand = driver.findElement(By.cssSelector(
				"div.group.relative.rounded-2xl.bg-white:nth-of-type(" + productNumber + ")>div.mt-3>p.mt-1"));
		String productBrandText = productBrand.getText();
		String lowercaseProductBrandText = productBrandText.toLowerCase();
		return lowercaseProductBrandText;
	}

	public int fetchSingleProductSellingPrice(int productNumber) {
		WebElement product = clickProductByProductName(productNumber);
		WebElement productSellingPrice = driver
				.findElement(By.cssSelector("div.group.relative.rounded-2xl.bg-white:nth-of-type(" + productNumber
						+ ")>div.mt-3>div.gap-2>span:first-child"));
		String productSellingPriceText = productSellingPrice.getText();
		String cleanPrice = productSellingPriceText.replaceAll("[^0-9]", "");
		int productSellingPriceNumber = Integer.parseInt(cleanPrice);
		return productSellingPriceNumber;
	}

	public int fetchSingleProductDisplayPrice(int productNumber) {
		WebElement product = clickProductByProductName(productNumber);
		WebElement productDisplayPrice = driver
				.findElement(By.cssSelector("div.group.relative.rounded-2xl.bg-white:nth-of-type(" + productNumber
						+ ")>div.mt-3>div.gap-2>span:last-child"));
		String productDisplayPriceText = productDisplayPrice.getText();
		String cleanPrice = productDisplayPriceText.replaceAll("[^0-9]", "");
		int productDisplayPriceNumber = Integer.parseInt(cleanPrice);
		return productDisplayPriceNumber;
	}

	public boolean clickOnSixthSingleProduct() {
		return clickOnElement(singleProduct, "NoiseCancel Pro Headphones");
	}

	// function to click on any product based on index value , productNumber
	public WebElement clickProductByProductName(int productNumber) {
		int index = productNumber;
		return driver.findElement(By.cssSelector("div.group.relative.rounded-2xl.bg-white:nth-of-type(" + index + ")"));
	}

	public boolean clickProductByProductNumber(int productNumber) {
		WebElement product = clickProductByProductName(productNumber);
		return clickOnElement(product, "Single Product : " + productNumber);
	}

}
