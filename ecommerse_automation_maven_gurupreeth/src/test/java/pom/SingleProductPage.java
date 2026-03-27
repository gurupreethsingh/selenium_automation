package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleProductPage extends AllVerifications {
	@FindBy(css = "div.space-y-5>h1")
	private WebElement mainProductName;

	public SingleProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// action functions, fetch and print the text of main product name.
	public String fetchAndPrintMainProductName() {
		return getTextFromElement(mainProductName, "Main Product Name");
	}

	// PAGE VERIFICATION
	public boolean verifySingleProductPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySingleProductPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
