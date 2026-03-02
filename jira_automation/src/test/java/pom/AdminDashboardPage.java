package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AdminDashboardPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AdminDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAdminDashboardPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAdminDashboardPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
