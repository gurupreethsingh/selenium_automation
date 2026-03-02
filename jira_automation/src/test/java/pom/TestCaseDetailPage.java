package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TestCaseDetailPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public TestCaseDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyTestCaseDetailPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyTestCaseDetailPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
