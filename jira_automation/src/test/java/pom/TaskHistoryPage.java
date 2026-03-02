package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class TaskHistoryPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public TaskHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyTaskHistoryPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyTaskHistoryPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
