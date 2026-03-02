package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SubscriptionsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SubscriptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySubscriptionsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySubscriptionsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
