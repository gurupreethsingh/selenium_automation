package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllEventsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllEventsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllEventsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllEventsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
