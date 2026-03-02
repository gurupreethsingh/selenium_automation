package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ViewAssignedTasksPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ViewAssignedTasksPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyViewAssignedTasksPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyViewAssignedTasksPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
