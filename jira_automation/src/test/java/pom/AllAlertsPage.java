package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllAlertsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllAlertsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllAlertsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllAlertsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
