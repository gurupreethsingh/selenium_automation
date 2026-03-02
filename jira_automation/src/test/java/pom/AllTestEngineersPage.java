package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllTestEngineersPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllTestEngineersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllTestEngineersPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllTestEngineersPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
