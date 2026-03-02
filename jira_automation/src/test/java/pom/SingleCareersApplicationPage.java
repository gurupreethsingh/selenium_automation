package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleCareersApplicationPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleCareersApplicationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleCareersApplicationPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleCareersApplicationPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
