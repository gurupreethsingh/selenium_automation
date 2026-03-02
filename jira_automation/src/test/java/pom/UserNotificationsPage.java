package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UserNotificationsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UserNotificationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUserNotificationsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUserNotificationsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
