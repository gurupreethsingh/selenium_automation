package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AllScenariosPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AllScenariosPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAllScenariosPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAllScenariosPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
