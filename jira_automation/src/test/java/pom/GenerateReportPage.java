package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class GenerateReportPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public GenerateReportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyGenerateReportPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyGenerateReportPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
