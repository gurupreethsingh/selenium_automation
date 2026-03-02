package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ProfilePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyProfilePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyProfilePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
