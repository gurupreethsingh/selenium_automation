package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CreateEventPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CreateEventPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCreateEventPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCreateEventPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
