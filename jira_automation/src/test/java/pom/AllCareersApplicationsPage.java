package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllCareersApplicationsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllCareersApplicationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllCareersApplicationsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllCareersApplicationsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
