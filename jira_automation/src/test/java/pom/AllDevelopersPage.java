package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllDevelopersPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllDevelopersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllDevelopersPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllDevelopersPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
