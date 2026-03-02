package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleRequirementPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleRequirementPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleRequirementPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleRequirementPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
