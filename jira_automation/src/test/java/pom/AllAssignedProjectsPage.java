package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllAssignedProjectsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllAssignedProjectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllAssignedProjectsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllAssignedProjectsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
