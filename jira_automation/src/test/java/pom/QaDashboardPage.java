package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class QaDashboardPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public QaDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyQaDashboardPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyQaDashboardPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
