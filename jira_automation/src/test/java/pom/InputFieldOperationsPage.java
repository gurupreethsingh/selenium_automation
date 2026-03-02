package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class InputFieldOperationsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public InputFieldOperationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyInputFieldOperationsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyInputFieldOperationsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
