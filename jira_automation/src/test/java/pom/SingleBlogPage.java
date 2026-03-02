package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleBlogPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public SingleBlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifySingleBlogPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifySingleBlogPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
