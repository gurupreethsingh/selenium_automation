package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ProjectManagerDashboardPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ProjectManagerDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyProjectManagerDashboardPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyProjectManagerDashboardPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
