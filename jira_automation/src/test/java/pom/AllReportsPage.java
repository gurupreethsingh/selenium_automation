package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllReportsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllReportsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllReportsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllReportsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
