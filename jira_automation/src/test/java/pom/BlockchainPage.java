package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class BlockchainPage extends AllVerifications {

	// ============================================================
	// ✅ INIT
	// ============================================================

	public BlockchainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyBlockchainPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyBlockchainPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}
