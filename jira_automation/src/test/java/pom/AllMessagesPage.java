package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllMessagesPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllMessagesPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllMessagesPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
