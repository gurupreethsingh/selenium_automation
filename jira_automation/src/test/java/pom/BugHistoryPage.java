package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class BugHistoryPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public BugHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyBugHistoryPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyBugHistoryPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
