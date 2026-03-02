package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleProjectPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleProjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleProjectPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleProjectPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
