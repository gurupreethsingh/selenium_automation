package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TestEngineerDashboardPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public TestEngineerDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyTestEngineerDashboardPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyTestEngineerDashboardPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
