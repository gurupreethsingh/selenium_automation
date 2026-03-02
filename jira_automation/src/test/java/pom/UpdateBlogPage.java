package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateBlogPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UpdateBlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyUpdateBlogPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUpdateBlogPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
