package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CreateProjectPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CreateProjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCreateProjectPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCreateProjectPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
