package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class PageNotFoundPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public PageNotFoundPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyPageNotFoundPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyPageNotFoundPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
