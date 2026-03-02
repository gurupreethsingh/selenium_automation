package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllRequirementsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllRequirementsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllRequirementsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllRequirementsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
