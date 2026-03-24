package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ResetPasswordPage extends AllVerifications {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyResetPasswordPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyResetPasswordPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
