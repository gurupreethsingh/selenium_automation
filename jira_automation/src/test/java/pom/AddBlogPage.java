package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AddBlogPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public AddBlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyAddBlogPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyAddBlogPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
