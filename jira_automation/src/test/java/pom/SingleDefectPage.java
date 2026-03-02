package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleDefectPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleDefectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleDefectPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleDefectPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
