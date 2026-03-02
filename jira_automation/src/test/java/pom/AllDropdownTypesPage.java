package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllDropdownTypesPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllDropdownTypesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllDropdownTypesPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllDropdownTypesPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
