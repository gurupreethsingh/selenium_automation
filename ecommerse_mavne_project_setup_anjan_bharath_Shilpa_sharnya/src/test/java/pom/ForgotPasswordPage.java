package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ForgotPasswordPage extends AllVerifications {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyForgotPasswordPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyForgotPasswordPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
