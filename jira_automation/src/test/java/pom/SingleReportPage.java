package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleReportPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleReportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleReportPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleReportPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
