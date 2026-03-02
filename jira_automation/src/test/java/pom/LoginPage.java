package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class LoginPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyLoginPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyLoginPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
