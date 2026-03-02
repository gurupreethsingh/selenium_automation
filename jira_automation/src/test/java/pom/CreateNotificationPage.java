package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CreateNotificationPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CreateNotificationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCreateNotificationPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCreateNotificationPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
