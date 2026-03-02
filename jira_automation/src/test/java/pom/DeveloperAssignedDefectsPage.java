package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class DeveloperAssignedDefectsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public DeveloperAssignedDefectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyDeveloperAssignedDefectsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyDeveloperAssignedDefectsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
