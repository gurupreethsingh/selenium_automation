package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ReplyMessagePage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ReplyMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyReplyMessagePageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyReplyMessagePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
