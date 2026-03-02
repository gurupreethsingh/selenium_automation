package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class PrivacyPolicyPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public PrivacyPolicyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyPrivacyPolicyPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyPrivacyPolicyPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
