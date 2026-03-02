package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleTestCasePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleTestCasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleTestCasePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleTestCasePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
