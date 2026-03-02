package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllScrollOptionsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllScrollOptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllScrollOptionsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllScrollOptionsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
