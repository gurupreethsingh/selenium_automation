package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllClickOperationsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllClickOperationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllClickOperationsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllClickOperationsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
