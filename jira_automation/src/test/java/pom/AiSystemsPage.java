package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AiSystemsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AiSystemsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAiSystemsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAiSystemsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
