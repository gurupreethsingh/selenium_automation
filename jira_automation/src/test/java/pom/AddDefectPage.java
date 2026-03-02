package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AddDefectPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AddDefectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAddDefectPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAddDefectPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
