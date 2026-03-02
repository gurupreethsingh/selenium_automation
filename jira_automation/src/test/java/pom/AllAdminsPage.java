package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllAdminsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllAdminsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllAdminsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllAdminsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
