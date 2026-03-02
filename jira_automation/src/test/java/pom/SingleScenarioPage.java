package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleScenarioPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleScenarioPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleScenarioPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleScenarioPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
