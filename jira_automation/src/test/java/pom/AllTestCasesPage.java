package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllTestCasesPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllTestCasesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllTestCasesPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllTestCasesPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
