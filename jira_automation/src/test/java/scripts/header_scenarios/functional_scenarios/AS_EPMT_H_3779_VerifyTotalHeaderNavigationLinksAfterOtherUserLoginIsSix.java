package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_3779_VerifyTotalHeaderNavigationLinksAfterOtherUserLoginIsSix extends OpenClose {

	@Test
	public void testVerifyTotalHeaderNavigationLinksAfterAnyOtherUserLoginIsSix() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By headerNavLinksLocator = By.cssSelector("header div.hidden>div.flex.gap-5>a");
		By dashboardNavLinkLocator = By.cssSelector("header div.hidden>div.flex.gap-5>a[href*='dashboard']");

		softAssert.assertTrue(header.verifyTotalElementsCount(6, headerNavLinksLocator),
				"Total number of header navigation links after other user login is not 6.");

		softAssert.assertTrue(header.getHomeLinkText("Home"), "Home link text verification failed.");

		softAssert.assertTrue(header.verifyElementPresentAndVisible(dashboardNavLinkLocator, "Header Dashboard Link"),
				"Dashboard link is not visible after other user login.");

		softAssert.assertTrue(header.getBlogsLinkText("Blogs"), "Blogs link text verification failed.");

		softAssert.assertTrue(header.getContactLinkText("Contact"), "Contact link text verification failed.");

		softAssert.assertTrue(header.getAboutUsLinkText("About Us"), "About Us link text verification failed.");

		softAssert.assertTrue(header.getCareersLinkText("Careers"), "Careers link text verification failed.");

		softAssert.assertAll();
	}
}