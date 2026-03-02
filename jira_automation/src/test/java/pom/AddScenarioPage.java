package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AddScenarioPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AddScenarioPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAddScenarioPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAddScenarioPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
