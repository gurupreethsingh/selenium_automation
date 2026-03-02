package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleEventPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleEventPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleEventPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleEventPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
