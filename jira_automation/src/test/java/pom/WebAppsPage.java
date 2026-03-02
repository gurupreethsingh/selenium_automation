package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class WebAppsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public WebAppsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyWebAppsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyWebAppsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
