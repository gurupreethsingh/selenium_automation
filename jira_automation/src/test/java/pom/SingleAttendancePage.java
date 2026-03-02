package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleAttendancePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleAttendancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleAttendancePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleAttendancePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
