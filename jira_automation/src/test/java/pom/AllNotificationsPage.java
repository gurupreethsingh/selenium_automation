package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllNotificationsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllNotificationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllNotificationsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllNotificationsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
