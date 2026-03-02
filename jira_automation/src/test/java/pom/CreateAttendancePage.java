package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CreateAttendancePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CreateAttendancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCreateAttendancePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCreateAttendancePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
