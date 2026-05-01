package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CartPage extends AllVerifications {

	public CartPage(WebDriver driver) {
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

	// elements and its functions.

	@FindBy(css = "div.flex.items-end>div>button")
	private WebElement topBackButton;

	public boolean clickOnTopBackButton() {
		return clickOnElement(topBackButton, "Top Back Button");
	}

	@FindBy(css = "div.flex.items-end>div>button>svg")
	private WebElement topBackButtonIcon;

	public boolean clickOnTopBackButtonIcon() {
		return clickOnElement(topBackButtonIcon, "Top Back Button Icon");
	}

	@FindBy(css = "div.flex.items-end>div>h1")
	private WebElement mainCartPageHeadingText;

	public boolean verifyMainCartHeadingText() {
		return verifyText(mainCartPageHeadingText);
	}

	@FindBy(css = "h2.font-extrabold.truncate")
	private WebElement cartProductName;

	public String getActualProductNameInCartPage() {
		String actualProductName = cartProductName.getText();
		System.out.println("Actual product name in cart page is : " + actualProductName);
		return actualProductName;
	}

	@FindBy(css = "h2.font-extrabold.truncate")
	private List<WebElement> cartAllProductNames;

	public List<String> getallActualProductNamesInCartPage() {
		int totalNumberOfProductsAddedToCart = cartAllProductNames.size();
		ArrayList allproductNames = new ArrayList();

		for (int i = 1; i <= totalNumberOfProductsAddedToCart; i++) {
			String text = cartAllProductNames.get(i).getText();
			allproductNames.add(text);
		}

		return allproductNames;
	}

	@FindBy(css = "span.font-extrabold.text-slate-800")
	private WebElement cartSellingPrice;

	// getting cart value as string
	public String getActualSellingPriceTextInCartPage() {
		String actualSellingPriceText = cartSellingPrice.getText();
		System.out.println("Actual selling price text in cart page is : " + actualSellingPriceText);
		return actualSellingPriceText;
	}

	@FindBy(css = "span.font-extrabold.text-slate-800")
	private List<WebElement> cartAllSellingPrices;

	public List<Integer> getallActualSellingPricesInCartPage() {
		int totalNumberOfSellingPrices = cartAllSellingPrices.size();
		ArrayList allSellingPrices = new ArrayList();

		for (int i = 1; i <= totalNumberOfSellingPrices; i++) {
			String SellingPriceText = cartAllProductNames.get(i).getText();
			// convert them into numbers.
			String cleanedPriceText = SellingPriceText.replaceAll("[^0-9]", "");
			int sellingPriceNumber = Integer.parseInt(cleanedPriceText);
			allSellingPrices.add(sellingPriceNumber);
		}

		return allSellingPrices;
	}

	// getting cart selling price as number (integer)
	public int getActualSellingPriceNumberInCartPage() {
		String actualSellingPriceText = cartSellingPrice.getText();

		String actualSellingPriceTextClean = actualSellingPriceText.replaceAll("[^0-9]", "");
		System.out.println("cleaned text of selling price " + actualSellingPriceTextClean);

		int actualSellingPrice = Integer.parseInt(actualSellingPriceTextClean);

		System.out.println("Actual product selling price in cart page is : " + actualSellingPrice);

		return actualSellingPrice;
	}

	@FindBy(css = "span.text-center.text-slate-900")
	private WebElement cartQuantity;

	public String getActualQuantityTextInCartPage() {
		String actualQuantityText = cartQuantity.getText();
		System.out.println("Actual quantity text in cart page is : " + actualQuantityText);
		return actualQuantityText;
	}

	public int getActualQuantityNumberInCartPage() {
		String actualQuantityText = cartQuantity.getText();

		String actualQuantityTextClean = actualQuantityText.replaceAll("[^0-9]", "");

		int actualQuantity = Integer.parseInt(actualQuantityTextClean);

		System.out.println("Actual Quantity in cart page is : " + actualQuantity);

		return actualQuantity;
	}

	public int getActualSubTotalInCartPage() {
		int actualSellingPrice = getActualSellingPriceNumberInCartPage();
		int actualQuantity = getActualQuantityNumberInCartPage();

		int actualSubTotal = actualSellingPrice * actualQuantity;

		System.out.println("The actual sub total is : " + actualSubTotal);

		return actualSubTotal;
	}

	public int getActualGrandTotalInCartPage() {
		int actualGrandTotal = getActualSubTotalInCartPage();

		System.out.println("The actual Grand total is : " + actualGrandTotal);

		System.out.println("******************************************");

		return actualGrandTotal;
	}

	public boolean verifyCartProductNameText(String expectedProductName) {
		return verifyText(cartProductName, expectedProductName, "Cart Product Name", "contains", true);
	}

	public boolean verifyCartSellingPriceText(String expectedSellingPrice) {
		return verifyText(cartSellingPrice, expectedSellingPrice, "Cart Selling Price", "contains", true);
	}

	public boolean verifyCartQuantityText(String expectedQuantity) {
		return verifyText(cartQuantity, expectedQuantity, "Cart Quantity", "equals", true);
	}

}
