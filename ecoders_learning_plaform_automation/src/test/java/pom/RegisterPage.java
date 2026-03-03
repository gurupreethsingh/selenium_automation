package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class RegisterPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyRegisterPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyRegisterPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
