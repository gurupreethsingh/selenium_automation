package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HomePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyHomePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyHomePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
