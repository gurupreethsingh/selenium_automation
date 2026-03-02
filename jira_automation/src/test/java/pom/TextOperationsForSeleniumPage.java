package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TextOperationsForSeleniumPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public TextOperationsForSeleniumPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyTextOperationsForSeleniumPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyTextOperationsForSeleniumPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
