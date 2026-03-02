package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UserEventsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UserEventsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUserEventsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUserEventsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
