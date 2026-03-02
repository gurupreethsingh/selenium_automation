package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleModuleRequirementsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleModuleRequirementsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleModuleRequirementsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleModuleRequirementsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
