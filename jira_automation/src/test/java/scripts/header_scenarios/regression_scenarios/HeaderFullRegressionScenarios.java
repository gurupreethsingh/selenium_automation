package scripts.header_scenarios.regression_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Header;
import pom.HomePage;

public class HeaderFullRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testClickAppNameLogoFromHeaderOfHomepageVerifyReloadingOfHomepage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage homepage = new HomePage(driver);
		Header header = new Header(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = "/home";

		boolean homeTitleVerifiedBeforeClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedBeforeClick,
				"Homepage title verification failed before clicking application name.");

		boolean appNameClickedAndReloadVerified = header.verifyPageReloadAfterAction(
				() -> header.clickOnApplicationName(), expectedHomePageTitle, expectedHomePageUrl,
				"Homepage Reload After Clicking Header Application Name");

		softAssert.assertTrue(appNameClickedAndReloadVerified,
				"Homepage reload verification failed after clicking application name.");

		boolean homeTitleVerifiedAfterClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedAfterClick,
				"Homepage title verification failed after clicking application name.");
		softAssert.assertTrue(homepage.verifyHomePageUrl(expectedHomePageUrl),
				"Homepage url verification failed after clicking application name.");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testClickLogoFromHeaderOfHomepageVerifyReloadingOfHomepage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		HomePage homepage = new HomePage(driver);
		Header header = new Header(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = "/home";

		boolean homeTitleVerifiedBeforeClick = homepage.verifyHomePageTitle(expectedHomePageTitle);
		softAssert.assertTrue(homeTitleVerifiedBeforeClick, "Homepage title verification failed before clicking logo.");

		boolean logoClickedAndReloadVerified = header.verifyPageReloadAfterAction(() -> header.clickOnLogo(),
				expectedHomePageTitle, expectedHomePageUrl, "Homepage Reload After Clicking Logo");

		softAssert.assertTrue(logoClickedAndReloadVerified, "Homepage reload verification failed after clicking logo.");

		softAssert.assertTrue(homepage.verifyHomePageTitle(expectedHomePageTitle),
				"Homepage title verification failed after clicking logo.");
		softAssert.assertTrue(homepage.verifyHomePageUrl(expectedHomePageUrl),
				"Homepage url verification failed after clicking logo.");

		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testClickAllTodoTaskListFromDropdownNavigateToViewAllTodoListPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks dropdown text verification failed.");

		softAssert.assertTrue(header.clickOnViewAllToDoTasksLinkFromDropdown(),
				"Failed to click View All ToDo Tasks link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*todo.*", "View All Todo List Page"),
				"View All Todo List page did not load properly.");

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testClickProfileFromDropdownNavigateToProfilePage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"),
				"Profile dropdown text verification failed.");

		softAssert.assertTrue(header.clickOnProfileLinkFromDropdown(), "Failed to click Profile link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*profile.*", "Profile Page"),
				"Profile page did not load properly.");

		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testVerifyTotalOptionsInUserNameDropdownIsFiveAndNamesAreCorrect() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By totalVisibleDropdownOptionsLocator = By.cssSelector("header div.absolute.right-0 > div:nth-of-type(-n+5)");

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.verifyTotalElementsCount(5, totalVisibleDropdownOptionsLocator),
				"Total dropdown options count is not 5.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"),
				"Profile dropdown option text verification failed.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks dropdown option text verification failed.");

		softAssert.assertTrue(header.getCreateToDoTaskListLinkTextFromDropdown("Create To Do Task List"),
				"Create To Do Task List dropdown option text verification failed.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard dropdown option text verification failed.");

		softAssert.assertTrue(header.getLogoutButtonTextFromDropdown("Logout"),
				"Logout dropdown option text verification failed.");

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testVerifyAllDropdownOptionsAreDisplayedWhenUserNameDropdownIsClicked() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getAllDropdownOptions(), "All dropdown options are not displayed.");

		softAssert.assertTrue(header.getProfileLinkTextFromDropdown("Profile"), "Profile option is not displayed.");

		softAssert.assertTrue(header.getViewAllToDoTasksLinkTextFromDropdown("View All ToDo Tasks"),
				"View All ToDo Tasks option is not displayed.");

		softAssert.assertTrue(header.getCreateToDoTaskListLinkTextFromDropdown("Create To Do Task List"),
				"Create To Do Task List option is not displayed.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard option is not displayed.");

		softAssert.assertTrue(header.getLogoutButtonTextFromDropdown("Logout"), "Logout option is not displayed.");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testVerifyUserNameAppearsRightNextToUserAvatarOnceUserIsLoggedIn() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);
		By userNameLocator = By.cssSelector("header button[aria-haspopup='menu'] span");

		softAssert.assertTrue(header.verifyElementPresentAndVisible(userNameLocator, "Header Dropdown User Name Text"),
				"User name is not visible next to the user avatar after login.");

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClickNotificationIconFromHeaderAfterLoginNavigateToAllNotificationsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnNotificationsIconLink(), "Failed to click Notifications icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*notification.*", "All Notifications Page"),
				"All Notifications page did not load properly.");

		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testClickEventsIconFromHeaderAfterLoginNavigateToAllEventsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnEventsIconLink(), "Failed to click Events icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*event.*", "All Events Page"),
				"All Events page did not load properly.");

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testVerifyEventsAndNotificationIconsAppearOnRightSideOfHeaderAfterLogin() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By eventsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Events']");
		By notificationsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Notifications']");

		softAssert.assertTrue(header.verifyElementPresentAndVisible(eventsIconLocator, "Header Events Icon Link"),
				"Events icon is not visible on the right side of header after login.");

		softAssert.assertTrue(
				header.verifyElementPresentAndVisible(notificationsIconLocator, "Header Notifications Icon Link"),
				"Notifications icon is not visible on the right side of header after login.");

		softAssert.assertAll();
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testVerifyEventsAndNotificationIconsAreNotDisplayedBeforeLogin() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		By eventsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Events']");
		By notificationsIconLocator = By.cssSelector("div.flex.items-center.gap-4>button[aria-label='Notifications']");

		softAssert.assertFalse(header.isElementPresentInDOM(eventsIconLocator),
				"Events icon should not be displayed before login.");

		softAssert.assertFalse(header.isElementPresentInDOM(notificationsIconLocator),
				"Notifications icon should not be displayed before login.");

		softAssert.assertAll();
	}

	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testClickDashboardLinkFromHeaderNavigateToRespectiveDashboardPagesBasedOnUserRoles()
			throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.getDashboardLinkTextFromDropdown("Dashboard"),
				"Dashboard dropdown option text verification failed.");

		softAssert.assertTrue(header.clickOnDashboardLinkFromDropdown(),
				"Failed to click Dashboard link from dropdown.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*dashboard.*", "Dashboard Page"),
				"Respective dashboard page did not load properly.");

		softAssert.assertAll();
	}

	@Test(priority = 13, enabled = true, invocationCount = 1)
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

	@Test(priority = 14, enabled = true, invocationCount = 1)
	public void testVerifyAllUsersLinkDisappearsInHeaderNavigationWhenSuperAdminLogsOut() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);
		By allUsersLinkLocator = By.cssSelector("div.flex.items-center.gap-5 a[href='/all-users']");

		softAssert.assertTrue(header.getAllUsersLinkText("All Users"), "All Users link is not visible before logout.");

		softAssert.assertTrue(header.openUserDropdown(), "Failed to open user dropdown.");

		softAssert.assertTrue(header.clickOnLogoutButtonFromDropdown(), "Failed to click Logout button from dropdown.");

		softAssert.assertFalse(header.isElementPresentInDOM(allUsersLinkLocator),
				"All Users link is still visible after superadmin logout.");

		softAssert.assertAll();
	}

	@Test(priority = 15, enabled = true, invocationCount = 1)
	public void testVerifyAllUsersLinkOnlyAppearsWhenSuperAdminOfTheApplicationLogsIn() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getAllUsersLinkText("All Users"),
				"All Users link text verification failed for superadmin login.");

		softAssert.assertTrue(header.getAllUsersLinkHref("/all-users"),
				"All Users link href verification failed for superadmin login.");

		softAssert.assertAll();
	}

	@Test(priority = 16, enabled = true, invocationCount = 1)
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

	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void testVerifyTotalHeaderNavigationLinksBeforeUserLoginIsFive() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);
		By headerNavLinksLocator = By.cssSelector("header div.hidden>div.flex.gap-5>a");

		softAssert.assertTrue(header.verifyTotalElementsCount(5, headerNavLinksLocator),
				"Total number of header navigation links before user login is not 5.");

		softAssert.assertTrue(header.getHomeLinkText("Home"), "Home link text verification failed.");

		softAssert.assertTrue(header.getBlogsLinkText("Blogs"), "Blogs link text verification failed.");

		softAssert.assertTrue(header.getContactLinkText("Contact"), "Contact link text verification failed.");

		softAssert.assertTrue(header.getAboutUsLinkText("About Us"), "About Us link text verification failed.");

		softAssert.assertTrue(header.getCareersLinkText("Careers"), "Careers link text verification failed.");

		softAssert.assertAll();
	}

	@Test(priority = 18, enabled = true, invocationCount = 1)
	public void testClickLoginLinkFromHeaderOfHomepageUserShouldNavigateToLoginSignInPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getLoginText("Login"), "Login text verification failed before click.");

		softAssert.assertTrue(header.clickOnLoginTextLink(), "Failed to click Login text link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*(login|sign-in).*", "Login / Sign In Page"),
				"Login / Sign In page did not load properly after clicking Login link.");

		softAssert.assertAll();
	}

	@Test(priority = 19, enabled = true, invocationCount = 1)
	public void testClickUserAvatarLoginIconFromHeaderOfHomepageUserShouldNavigateToLoginSignInPage()
			throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.clickOnUserAvatarLoginIcon(),
				"Failed to click User Avatar Login icon from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", ".*(login|sign-in).*", "Login / Sign In Page"),
				"Login / Sign In page did not load properly after clicking User Avatar Login icon.");

		softAssert.assertAll();
	}

	@Test(priority = 20, enabled = true, invocationCount = 1)
	public void testClickCareersLinkFromHeaderOfHomepageUserShouldNavigateToCareersPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getCareersLinkText("Careers"),
				"Careers link text verification failed before click.");

		softAssert.assertTrue(header.getCareersLinkHref("/careers"),
				"Careers link href verification failed before click.");

		softAssert.assertTrue(header.clickOnCareersLink(), "Failed to click Careers link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/careers", "Careers Page"),
				"Careers page did not load properly after clicking Careers link.");

		softAssert.assertAll();
	}

	@Test(priority = 21, enabled = true, invocationCount = 1)
	public void testClickAboutUsLinkFromHeaderOfHomepageUserShouldNavigateToAboutUsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getAboutUsLinkText("About Us"),
				"About Us link text verification failed before click.");

		softAssert.assertTrue(header.getAboutUsLinkHref("/about-us"),
				"About Us link href verification failed before click.");

		softAssert.assertTrue(header.clickOnAboutUsLink(), "Failed to click About Us link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/about-us", "About Us Page"),
				"About Us page did not load properly after clicking About Us link.");

		softAssert.assertAll();
	}

	@Test(priority = 22, enabled = true, invocationCount = 1)
	public void testClickContactLinkFromHeaderOfHomepageUserShouldNavigateToContactUsPage() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		Header header = new Header(driver);

		softAssert.assertTrue(header.getContactLinkText("Contact"),
				"Contact link text verification failed before click.");

		softAssert.assertTrue(header.getContactLinkHref("/contact"),
				"Contact link href verification failed before click.");

		softAssert.assertTrue(header.clickOnContactLink(), "Failed to click Contact link from header.");

		softAssert.assertTrue(header.waitForPageToLoad("", "/contact", "Contact Us Page"),
				"Contact Us page did not load properly after clicking Contact link.");

		softAssert.assertAll();
	}
}