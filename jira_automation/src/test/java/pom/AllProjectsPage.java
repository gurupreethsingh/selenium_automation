package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllProjectsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllProjectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllProjectsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllProjectsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
