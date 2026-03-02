package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllDefectsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllDefectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllDefectsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllDefectsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
