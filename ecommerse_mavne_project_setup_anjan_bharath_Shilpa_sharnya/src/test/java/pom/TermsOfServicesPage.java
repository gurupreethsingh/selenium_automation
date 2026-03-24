package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TermsOfServicesPage extends AllVerifications {

	public TermsOfServicesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyTermsOfServicesPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyTermsOfServicesPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
