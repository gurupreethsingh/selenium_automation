package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class CreateRequirementPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public CreateRequirementPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyCreateRequirementPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyCreateRequirementPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
