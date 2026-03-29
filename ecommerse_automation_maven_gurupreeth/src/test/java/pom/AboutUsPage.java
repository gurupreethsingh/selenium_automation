package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AboutUsPage extends AllVerifications {

	public AboutUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyAboutUsPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyAboutUsPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
