package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HelpCenterPage extends AllVerifications {

	public HelpCenterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyHelpCenterPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyHelpCenterPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
