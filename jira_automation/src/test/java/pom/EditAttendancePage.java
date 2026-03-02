package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class EditAttendancePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public EditAttendancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyEditAttendancePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyEditAttendancePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
