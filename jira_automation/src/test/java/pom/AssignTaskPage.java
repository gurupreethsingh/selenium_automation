package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AssignTaskPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AssignTaskPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAssignTaskPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAssignTaskPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
