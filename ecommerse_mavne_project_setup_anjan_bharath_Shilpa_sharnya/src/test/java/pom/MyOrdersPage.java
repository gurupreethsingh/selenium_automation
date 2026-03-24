package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class MyOrdersPage extends AllVerifications {

	public MyOrdersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyMyOrdersPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyMyOrdersPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}
