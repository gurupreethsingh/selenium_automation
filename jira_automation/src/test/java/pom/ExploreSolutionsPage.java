package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ExploreSolutionsPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public ExploreSolutionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyExploreSolutionsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyExploreSolutionsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
