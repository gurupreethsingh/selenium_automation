package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class DeveloperLeadDashboardPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public DeveloperLeadDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyDeveloperLeadDashboardPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyDeveloperLeadDashboardPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
