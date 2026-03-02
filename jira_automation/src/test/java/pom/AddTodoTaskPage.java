package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AddTodoTaskPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AddTodoTaskPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAddTodoTaskPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAddTodoTaskPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
