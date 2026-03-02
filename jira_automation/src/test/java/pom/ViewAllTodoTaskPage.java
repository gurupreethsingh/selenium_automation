package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ViewAllTodoTaskPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ViewAllTodoTaskPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyViewAllTodoTaskPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyViewAllTodoTaskPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
