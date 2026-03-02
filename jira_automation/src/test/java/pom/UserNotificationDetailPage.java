package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UserNotificationDetailPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UserNotificationDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUserNotificationDetailPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUserNotificationDetailPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
