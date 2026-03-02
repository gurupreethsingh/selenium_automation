package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateRequirementPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UpdateRequirementPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUpdateRequirementPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUpdateRequirementPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
