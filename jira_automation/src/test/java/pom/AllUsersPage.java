package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllUsersPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllUsersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllUsersPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllUsersPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
