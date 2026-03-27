package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleProductPage extends AllVerifications {

	public SingleProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAndPrintTheTextOfProductsSectionMainHeading(String expectedMainHeadingText) {
		return verifyText(productsSectionMainHeading, expectedMainHeadingText, "Products section main heading",
				"equals", // or "contains"
				true // ignore case
		);
	}

	// PAGE VERIFICATION
	public boolean verifySingleProductPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySingleProductPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
