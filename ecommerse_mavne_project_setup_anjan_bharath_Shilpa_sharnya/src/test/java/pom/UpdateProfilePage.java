package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateProfilePage extends AllVerifications {

	public UpdateProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyUpdateProfilePageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyUpdateProfilePageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
