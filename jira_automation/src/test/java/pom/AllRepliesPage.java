package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllRepliesPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllRepliesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllRepliesPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllRepliesPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
