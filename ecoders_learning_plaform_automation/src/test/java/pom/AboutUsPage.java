package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AboutUsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AboutUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAboutUsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAboutUsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
