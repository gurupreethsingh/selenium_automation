package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CareersPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CareersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCareersPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCareersPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
