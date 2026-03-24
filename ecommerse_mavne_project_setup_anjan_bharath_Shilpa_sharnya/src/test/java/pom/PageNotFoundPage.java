package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class PageNotFoundPage extends AllVerifications {

	public PageNotFoundPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyPageNotFoundPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyPageNotFoundPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
