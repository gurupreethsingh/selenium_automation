package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleUserPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleUserPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleUserPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleUserPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
