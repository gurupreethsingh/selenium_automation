package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateProfilePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UpdateProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUpdateProfilePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUpdateProfilePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
