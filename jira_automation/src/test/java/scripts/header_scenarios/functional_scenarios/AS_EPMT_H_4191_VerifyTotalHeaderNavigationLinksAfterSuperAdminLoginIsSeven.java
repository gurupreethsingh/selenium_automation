package scripts.header_scenarios.functional_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.OpenClose;
import pom.Header;

public class AS_EPMT_H_4191_VerifyTotalHeaderNavigationLinksAfterSuperAdminLoginIsSeven extends OpenClose {

	@Test
	public void testVerifyTotalHeaderNavigationLinksAfterSuperAdminLoginIsSeven() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By headerNavLinksLocator = By.cssSelector("header div.hidden>div.flex.gap-5>a");

		softAssert.assertTrue(header.verifyTotalElementsCount(7, headerNavLinksLocator),
				"Total number of header navigation links after superadmin login is not 7.");

		softAssert.assertTrue(header.getHomeLinkText("Home"), "Home link text verification failed.");

		softAssert.assertTrue(header.getAllUsersLinkText("All Users"), "All Users link text verification failed.");

		softAssert.assertTrue(header.getSuperAdminDashboardLinkText("Dashboard"),
				"Dashboard link text verification failed.");

		softAssert.assertTrue(header.getBlogsLinkText("Blogs"), "Blogs link text verification failed.");

		softAssert.assertTrue(header.getContactLinkText("Contact"), "Contact link text verification failed.");

		softAssert.assertTrue(header.getAboutUsLinkText("About Us"), "About Us link text verification failed.");

		softAssert.assertTrue(header.getCareersLinkText("Careers"), "Careers link text verification failed.");

		softAssert.assertAll();
	}
}