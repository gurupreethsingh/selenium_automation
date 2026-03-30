package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Header extends AllVerifications {

	// HEADER - LEFT elements

	@FindBy(css = "header>div.max-w-screen-3xl>div>a>img")
	private WebElement headerLogo;

	@FindBy(css = "header>div.max-w-screen-3xl>div>a>div")
	private WebElement headerApplicationName;

	// HEADER - NAV LINKS

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/']")
	private WebElement headerHomeLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/all-blogs']")
	private WebElement headerBlogsLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/contact']")
	private WebElement headerContactLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/about-us']")
	private WebElement headerAboutUsLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/careers']")
	private WebElement headerCareersLink;

	@FindBy(css = "div.flex.items-center.gap-4>div.relative>button>svg")
	private WebElement headerUserAvatarLoginLink;

	@FindBy(css = "div.flex.items-center.gap-4>div.relative>button>span")
	private WebElement headerLoginTextLink;

	@FindBy(css = "header button[aria-haspopup='menu'] span")
	private WebElement headerDropdownUserNameText;

	@FindBy(css = "header div.absolute.right-0>div")
	private List<WebElement> headerDropdownAllOptions;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(1)>a")
	private List<WebElement> headerDropdownProfileLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(2)>a")
	private List<WebElement> headerDropdownViewAllToDoTasksLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(3)>a")
	private List<WebElement> headerDropdownCreateToDoTaskListLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(4)>a")
	private List<WebElement> headerDropdownViewMessagesLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(5)>a")
	private List<WebElement> headerDropdownDashboardLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(6)>a")
	private List<WebElement> headerDropdownAllRepliesLink;

	@FindBy(css = "header div.absolute.right-0>div:nth-of-type(7)>button")
	private List<WebElement> headerDropdownLogoutLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/all-users']")
	private WebElement headerAllUsersLink;

	@FindBy(css = "div.flex.items-center.gap-5 a[href='/super-admin-dashboard']")
	private WebElement headerSuperAdminDashboardLink;

	@FindBy(css = "div.flex.items-center.gap-4>button[aria-label='Events']")
	private WebElement headerEvenetsIconLink;

	@FindBy(css = "div.flex.items-center.gap-4>button[aria-label='Notifications']")
	private WebElement headerNotificationsIconLink;

	@FindBy(css = "header div.hidden>div.flex.gap-5>a")
	private List<WebElement> headerAllLinksBeforeLogin;

	@FindBy(css = "header div.hidden>div.flex.gap-5>a")
	private List<WebElement> headerAllLinksAfterLogin;

	// initialize the elements of this page.
	public Header(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// HEADER LOGO / APPLICATION NAME
	// ============================================================

	public boolean clickOnLogo() {
		return clickOnElement(headerLogo, "Header Logo Image");
	}

	public boolean getApplicationNameText(String expectedText) {
		return verifyText(headerApplicationName, expectedText, "Header Application Name Text", "equals", true);
	}

	public boolean clickOnApplicationName() {
		return clickOnElement(headerApplicationName, "Header Application Name");
	}

	public boolean getHeaderLogoImageSource(String expectedSource) {
		return verifyElementAttribute(headerLogo, "src", expectedSource, "Header Logo Image Source");
	}

	public boolean getHeaderLogoRedirectHref(String expectedHref) {
		return verifyAncestorAnchorHref(headerLogo, expectedHref, "Header Logo Redirect Href");
	}

	public boolean getHeaderApplicationNameRedirectHref(String expectedHref) {
		return verifyAncestorAnchorHref(headerApplicationName, expectedHref, "Header Application Name Redirect Href");
	}

	// ============================================================
	// NAV LINKS
	// ============================================================

	public boolean clickOnHomeLink() {
		return clickOnElement(headerHomeLink, "Header Home Link");
	}

	public boolean getHomeLinkText(String expectedText) {
		return verifyText(headerHomeLink, expectedText, "Header Home Link Text", "equals", true);
	}

	public boolean getHomeLinkHref(String expectedHref) {
		return verifyElementAttribute(headerHomeLink, "href", expectedHref, "Header Home Link Href");
	}

	public boolean clickOnBlogsLink() {
		return clickOnElement(headerBlogsLink, "Header Blogs Link");
	}

	public boolean getBlogsLinkText(String expectedText) {
		return verifyText(headerBlogsLink, expectedText, "Header Blogs Link Text", "equals", true);
	}

	public boolean getBlogsLinkHref(String expectedHref) {
		return verifyElementAttribute(headerBlogsLink, "href", expectedHref, "Header Blogs Link Href");
	}

	public boolean clickOnContactLink() {
		return clickOnElement(headerContactLink, "Header Contact Link");
	}

	public boolean getContactLinkText(String expectedText) {
		return verifyText(headerContactLink, expectedText, "Header Contact Link Text", "equals", true);
	}

	public boolean getContactLinkHref(String expectedHref) {
		return verifyElementAttribute(headerContactLink, "href", expectedHref, "Header Contact Link Href");
	}

	public boolean clickOnAboutUsLink() {
		return clickOnElement(headerAboutUsLink, "Header About Us Link");
	}

	public boolean getAboutUsLinkText(String expectedText) {
		return verifyText(headerAboutUsLink, expectedText, "Header About Us Link Text", "equals", true);
	}

	public boolean getAboutUsLinkHref(String expectedHref) {
		return verifyElementAttribute(headerAboutUsLink, "href", expectedHref, "Header About Us Link Href");
	}

	public boolean clickOnCareersLink() {
		return clickOnElement(headerCareersLink, "Header Careers Link");
	}

	public boolean getCareersLinkText(String expectedText) {
		return verifyText(headerCareersLink, expectedText, "Header Careers Link Text", "equals", true);
	}

	public boolean getCareersLinkHref(String expectedHref) {
		return verifyElementAttribute(headerCareersLink, "href", expectedHref, "Header Careers Link Href");
	}

	public boolean clickOnAllUsersLink() {
		return clickOnElement(headerAllUsersLink, "Header All Users Link");
	}

	public boolean getAllUsersLinkText(String expectedText) {
		return verifyText(headerAllUsersLink, expectedText, "Header All Users Link Text", "equals", true);
	}

	public boolean getAllUsersLinkHref(String expectedHref) {
		return verifyElementAttribute(headerAllUsersLink, "href", expectedHref, "Header All Users Link Href");
	}

	public boolean clickOnSuperAdminDashboardLink() {
		return clickOnElement(headerSuperAdminDashboardLink, "Header Super Admin Dashboard Link");
	}

	public boolean getSuperAdminDashboardLinkText(String expectedText) {
		return verifyText(headerSuperAdminDashboardLink, expectedText, "Header Super Admin Dashboard Link Text",
				"equals", true);
	}

	public boolean getSuperAdminDashboardLinkHref(String expectedHref) {
		return verifyElementAttribute(headerSuperAdminDashboardLink, "href", expectedHref,
				"Header Super Admin Dashboard Link Href");
	}

	// ============================================================
	// USER / LOGIN
	// ============================================================

	public boolean clickOnUserAvatarLoginIcon() {
		return clickOnElement(headerUserAvatarLoginLink, "Header User Avatar Login Icon");
	}

	public boolean clickOnLoginTextLink() {
		return clickOnElement(headerLoginTextLink, "Header Login Text Link");
	}

	public boolean getLoginText(String expectedText) {
		return verifyText(headerLoginTextLink, expectedText, "Header Login Text", "equals", true);
	}

	public boolean getDropdownUserNameText(String expectedText) {
		return verifyText(headerDropdownUserNameText, expectedText, "Header Dropdown User Name Text", "equals", true);
	}

	public boolean openUserDropdown() {
		return clickAncestorElement(headerDropdownUserNameText, "./ancestor::button[1]", "Header User Dropdown Button");
	}

	// ============================================================
	// DROPDOWN LINKS / OPTIONS
	// ============================================================

	public boolean getAllDropdownOptions() {
		return verifyListHasElements(headerDropdownAllOptions, "Header Dropdown All Options");
	}

	public boolean clickOnProfileLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownProfileLink, "Header Dropdown Profile Link");
	}

	public boolean getProfileLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownProfileLink, expectedText,
				"Header Dropdown Profile Link Text", "equals", true);
	}

	public boolean getProfileLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownProfileLink, "href", expectedHref,
				"Header Dropdown Profile Link Href");
	}

	public boolean clickOnViewAllToDoTasksLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownViewAllToDoTasksLink,
				"Header Dropdown View All To Do Tasks Link");
	}

	public boolean getViewAllToDoTasksLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownViewAllToDoTasksLink, expectedText,
				"Header Dropdown View All To Do Tasks Link Text", "equals", true);
	}

	public boolean getViewAllToDoTasksLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownViewAllToDoTasksLink, "href", expectedHref,
				"Header Dropdown View All To Do Tasks Link Href");
	}

	public boolean clickOnCreateToDoTaskListLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownCreateToDoTaskListLink,
				"Header Dropdown Create To Do Task List Link");
	}

	public boolean getCreateToDoTaskListLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownCreateToDoTaskListLink, expectedText,
				"Header Dropdown Create To Do Task List Link Text", "equals", true);
	}

	public boolean getCreateToDoTaskListLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownCreateToDoTaskListLink, "href", expectedHref,
				"Header Dropdown Create To Do Task List Link Href");
	}

	public boolean clickOnViewMessagesLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownViewMessagesLink, "Header Dropdown View Messages Link");
	}

	public boolean getViewMessagesLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownViewMessagesLink, expectedText,
				"Header Dropdown View Messages Link Text", "equals", true);
	}

	public boolean getViewMessagesLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownViewMessagesLink, "href", expectedHref,
				"Header Dropdown View Messages Link Href");
	}

	public boolean clickOnDashboardLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownDashboardLink, "Header Dropdown Dashboard Link");
	}

	public boolean getDashboardLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownDashboardLink, expectedText,
				"Header Dropdown Dashboard Link Text", "equals", true);
	}

	public boolean getDashboardLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownDashboardLink, "href", expectedHref,
				"Header Dropdown Dashboard Link Href");
	}

	public boolean clickOnAllRepliesLinkFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownAllRepliesLink, "Header Dropdown All Replies Link");
	}

	public boolean getAllRepliesLinkTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownAllRepliesLink, expectedText,
				"Header Dropdown All Replies Link Text", "equals", true);
	}

	public boolean getAllRepliesLinkHrefFromDropdown(String expectedHref) {
		return verifyAttributeOfFirstElementFromList(headerDropdownAllRepliesLink, "href", expectedHref,
				"Header Dropdown All Replies Link Href");
	}

	public boolean clickOnLogoutButtonFromDropdown() {
		return clickOnFirstElementFromList(headerDropdownLogoutLink, "Header Dropdown Logout Button");
	}

	public boolean getLogoutButtonTextFromDropdown(String expectedText) {
		return verifyTextOfFirstElementFromList(headerDropdownLogoutLink, expectedText,
				"Header Dropdown Logout Button Text", "equals", true);
	}

	// ============================================================
	// ICON BUTTONS
	// ============================================================

	public boolean clickOnEventsIconLink() {
		return clickOnElement(headerEvenetsIconLink, "Header Events Icon Link");
	}

	public boolean getEventsIconAriaLabel(String expectedAriaLabel) {
		return verifyElementAttribute(headerEvenetsIconLink, "aria-label", expectedAriaLabel,
				"Header Events Icon Aria Label");
	}

	public boolean clickOnNotificationsIconLink() {
		return clickOnElement(headerNotificationsIconLink, "Header Notifications Icon Link");
	}

	public boolean getNotificationsIconAriaLabel(String expectedAriaLabel) {
		return verifyElementAttribute(headerNotificationsIconLink, "aria-label", expectedAriaLabel,
				"Header Notifications Icon Aria Label");
	}

	// ============================================================
	// BULK LIST GETTERS
	// ============================================================

	public boolean getAllHeaderLinksBeforeLogin() {
		return verifyListHasElements(headerAllLinksBeforeLogin, "Header All Links Before Login");
	}

	public boolean getAllHeaderLinksAfterLogin() {
		return verifyListHasElements(headerAllLinksAfterLogin, "Header All Links After Login");
	}

	public boolean getAllDropdownProfileLinks() {
		return verifyListHasElements(headerDropdownProfileLink, "Header Dropdown Profile Links");
	}

	public boolean getAllDropdownViewAllToDoTasksLinks() {
		return verifyListHasElements(headerDropdownViewAllToDoTasksLink, "Header Dropdown View All To Do Tasks Links");
	}

	public boolean getAllDropdownCreateToDoTaskListLinks() {
		return verifyListHasElements(headerDropdownCreateToDoTaskListLink,
				"Header Dropdown Create To Do Task List Links");
	}

	public boolean getAllDropdownViewMessagesLinks() {
		return verifyListHasElements(headerDropdownViewMessagesLink, "Header Dropdown View Messages Links");
	}

	public boolean getAllDropdownDashboardLinks() {
		return verifyListHasElements(headerDropdownDashboardLink, "Header Dropdown Dashboard Links");
	}

	public boolean getAllDropdownAllRepliesLinks() {
		return verifyListHasElements(headerDropdownAllRepliesLink, "Header Dropdown All Replies Links");
	}

	public boolean getAllDropdownLogoutButtons() {
		return verifyListHasElements(headerDropdownLogoutLink, "Header Dropdown Logout Buttons");
	}
}