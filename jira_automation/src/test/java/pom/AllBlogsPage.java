package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllBlogsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllBlogsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllBlogsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllBlogsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
