package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AssignDefectPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AssignDefectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAssignDefectPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAssignDefectPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
