package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ProjectsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ProjectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyProjectsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyProjectsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
