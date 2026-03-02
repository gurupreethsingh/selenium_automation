package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AddTestCasePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AddTestCasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAddTestCasePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAddTestCasePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
