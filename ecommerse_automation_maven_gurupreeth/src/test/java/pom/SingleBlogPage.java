package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleBlogPage extends AllVerifications {

	public SingleBlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifySingleBlogPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySingleBlogPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
