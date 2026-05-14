package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ShopPage extends AllVerifications {

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// find the private web elements
	// create functions to perform actions on those elements.

	@FindBy(css = "div.space-y-1>div")
	private List<WebElement> allCategories;

	public int gettotalNumberOfCateogories() {
		return allCategories.size();
	}

	public String getSingleCategoryName(int categoryIndex) {
		WebElement singleCategoryName = driver.findElement(
				By.cssSelector("div.space-y-1>div:nth-of-type(" + categoryIndex + ")>div>span.transition"));
		return singleCategoryName.getText();
	}

	public boolean clickOnASingleCategoryName(int categoryIndex) {
		boolean clickSuccessful = false;
		WebElement singleCategoryName = driver.findElement(
				By.cssSelector("div.space-y-1>div:nth-of-type(" + categoryIndex + ")>div>span.transition"));
		System.out.println("Clicking on : " + singleCategoryName.getText() + " Name.");
		try {
			singleCategoryName.click();
			clickSuccessful = true;
			System.out.println("Successfully Clicked on : " + singleCategoryName.getText() + " Name.");
		} catch (Exception ex) {
			System.out.println("Click operation failed.");
		}

		return clickSuccessful;
	}

	@FindBy(css = "div.productCardPerf")
	private List<WebElement> allProducts;

	public int getTotalProductCount() {
		return allProducts.size();
	}

	public String getSingleProductName(int productIndex) {
		WebElement productElement = driver.findElement(By.cssSelector(
				"div.productCardPerf:nth-of-type(" + productIndex + ")>div.shopGridDetails>p:first-child"));
		return productElement.getText();
	}

	public int getSingleProductSellingPriceInInteger(int productIndex) {
		WebElement productElement = driver.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + productIndex
				+ ")>div.shopGridDetails>div.shopProductPriceRow>span:first-child"));
		String sellingPriceText = productElement.getText();
		String cleanedSellingPrice = sellingPriceText.replaceAll("[^0-9]", "");
		int sellingPrice = Integer.parseInt(cleanedSellingPrice);
		return sellingPrice;
	}

	public double getSingleProductSellingPriceInDecimal(int productIndex) {
		WebElement productElement = driver.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + productIndex
				+ ")>div.shopGridDetails>div.shopProductPriceRow>span:first-child"));
		String sellingPriceText = productElement.getText();
		String cleanedSellingPrice = sellingPriceText.replaceAll("[^0-9.]", "");
		double sellingPrice = Double.parseDouble(cleanedSellingPrice);
		return sellingPrice;
	}

	public int getSingleProductDisplayPrice(int productIndex) {
		WebElement productElement = driver.findElement(By.cssSelector("div.productCardPerf:nth-of-type(" + productIndex
				+ ")>div.shopGridDetails>div.shopProductPriceRow>span:last-child"));
		String displayPriceText = productElement.getText();
		String cleanedDisplayPrice = displayPriceText.replaceAll("[^0-9]", "");
		int displayPrice = Integer.parseInt(cleanedDisplayPrice);
		return displayPrice;
	}

	public boolean clickOnAddToCartButton(int productIndex) {
		boolean clickSuccessful = false;
		WebElement singleAddToCartButton = driver.findElement(
				By.cssSelector("div.productCardPerf:nth-of-type(" + productIndex + ")>div.shopGridDetails>button"));
		System.out.println("Clicking on : " + singleAddToCartButton.getText());
		try {
			singleAddToCartButton.click();
			clickSuccessful = true;
			System.out.println("Successfully Clicked on Add To Cart Button");
		} catch (Exception ex) {
			System.out.println("Click operation failed.");
		}

		return clickSuccessful;
	}

}
