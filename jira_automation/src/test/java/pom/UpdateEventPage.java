package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateEventPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UpdateEventPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUpdateEventPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUpdateEventPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
