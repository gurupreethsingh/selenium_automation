package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleUserEventPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleUserEventPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleUserEventPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleUserEventPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
