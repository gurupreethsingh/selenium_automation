package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class QaAutomationPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public QaAutomationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyQaAutomationPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyQaAutomationPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
