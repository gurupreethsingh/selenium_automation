package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllFramesPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllFramesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllFramesPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllFramesPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
