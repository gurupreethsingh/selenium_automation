package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class PrivacyPolicyPage extends AllVerifications {

	public PrivacyPolicyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyPrivacyPolicyPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyPrivacyPolicyPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
