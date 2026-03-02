package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TraceabilityMatrixPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public TraceabilityMatrixPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyTraceabilityMatrixPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyTraceabilityMatrixPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
