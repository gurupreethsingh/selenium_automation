package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class GetAllAttendancePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public GetAllAttendancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyGetAllAttendancePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyGetAllAttendancePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
