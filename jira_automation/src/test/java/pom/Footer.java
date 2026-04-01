//package pom;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import generic.AllVerifications;
//
//public class Footer extends AllVerifications {
//	// find the elements of footer @FindBy() from testNG and declare them as private
//	// elements.
//
//	@FindBy(css = "footer div.grid.grid-cols-1.gap-8>div:nth-of-type(2)>ul>li:nth-of-type(1)>a")
//	private WebElement footerAboutUsLink;
//
//	// we have initialize the elements. which we have found using @FindBy, using the
//	// constructor of the Footer class. and PageFactory.initElements()
//
//	public Footer(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);
//	}
//
//	// we have to create fucntions to perform actions on those elements.
//	public boolean clickOnFooterAboutUsLink() {
//		return clickOnElement(footerAboutUsLink, "Footers About Us link");
//	}
//
//}

//

package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Footer extends AllVerifications {

	// ============================================================
	// FOOTER ROOT
	// ============================================================

	@FindBy(css = "footer.mt-8")
	private WebElement footerRoot;

	// ============================================================
	// BRAND SECTION
	// ============================================================

	@FindBy(css = "footer img[alt='Ecoders Logo']")
	private WebElement footerLogo;

	@FindBy(css = "footer img[alt='Ecoders Logo'] + p")
	private WebElement footerDescriptionText;

	// ============================================================
	// COMPANY LINKS
	// ============================================================

	@FindBy(css = "footer a[href='/about-us']")
	private WebElement footerAboutUsLink;

	@FindBy(css = "footer a[href='/projects']")
	private WebElement footerProjectsLink;

	@FindBy(css = "footer a[href='/all-blogs']")
	private WebElement footerBlogsLink;

	@FindBy(css = "footer a[href='/careers']")
	private WebElement footerCareersLink;

	// ============================================================
	// SERVICES LINKS
	// ============================================================

	@FindBy(css = "footer a[href='/explore-solutions']")
	private WebElement footerExploreSolutionsLink;

	@FindBy(css = "footer a[href='/web-apps']")
	private WebElement footerWebAppsLink;

	@FindBy(css = "footer a[href='/qa-automation']")
	private WebElement footerQaAutomationLink;

	@FindBy(css = "footer a[href='/ai-systems']")
	private WebElement footerAiSystemsLink;

	@FindBy(css = "footer a[href='/blockchain']")
	private WebElement footerBlockchainLink;

	// ============================================================
	// SUPPORT LINKS
	// ============================================================

	@FindBy(css = "footer a[href='/contact']")
	private WebElement footerContactLink;

	@FindBy(css = "footer a[href='/privacy-policy']")
	private WebElement footerPrivacyPolicyLink;

	@FindBy(css = "footer a[href='/login']")
	private WebElement footerLoginLink;

	@FindBy(css = "footer a[href='/register']")
	private WebElement footerRegisterLink;

	// ============================================================
	// ADDRESS SECTION
	// ============================================================

	@FindBy(css = "footer div.text-gray-400.text-sm>h3")
	private WebElement footerAddressHeadingText;

	@FindBy(css = "footer div.text-gray-400.text-sm>p")
	private List<WebElement> footerAddressAllParagraphs;

	@FindBy(css = "footer div.text-gray-400.text-sm>p:nth-of-type(1)")
	private WebElement footerAddressText;

	@FindBy(css = "footer div.text-gray-400.text-sm>p:nth-of-type(2)")
	private WebElement footerPhoneText;

	@FindBy(css = "footer div.text-gray-400.text-sm>p:nth-of-type(3)")
	private WebElement footerEmailText;

	@FindBy(css = "footer div.text-gray-400.text-sm>p:nth-of-type(4)")
	private WebElement footerWebsiteText;

	// ============================================================
	// COPYRIGHT
	// ============================================================

	@FindBy(css = "footer div.border-t p")
	private WebElement footerCopyrightText;

	// ============================================================
	// BULK LINKS
	// ============================================================

	@FindBy(css = "footer a")
	private List<WebElement> footerAllLinks;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public Footer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// FOOTER ROOT
	// ============================================================

	public boolean verifyFooterIsVisible() {
		return verifyElementPresentAndVisible(footerRoot, "Footer Root");
	}

	// ============================================================
	// BRAND SECTION
	// ============================================================

	public boolean getFooterLogoDisplayed() {
		return verifyElementPresentAndVisible(footerLogo, "Footer Logo");
	}

	public boolean getFooterLogoSource(String expectedSrc) {
		return verifyElementAttribute(footerLogo, "src", expectedSrc, "Footer Logo Source");
	}

	public boolean getFooterDescriptionText(String expectedText) {
		return verifyText(footerDescriptionText, expectedText, "Footer Description Text", "contains", true);
	}

	// ============================================================
	// COMPANY LINKS
	// ============================================================

	public boolean clickOnFooterAboutUsLink() {
		return clickOnElement(footerAboutUsLink, "Footer About Us Link");
	}

	public boolean getAboutUsLinkText(String expectedText) {
		return verifyText(footerAboutUsLink, expectedText, "Footer About Us Link Text", "equals", true);
	}

	public boolean getAboutUsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerAboutUsLink, "href", expectedHref, "Footer About Us Link Href");
	}

	public boolean clickOnFooterProjectsLink() {
		return clickOnElement(footerProjectsLink, "Footer Projects Link");
	}

	public boolean getProjectsLinkText(String expectedText) {
		return verifyText(footerProjectsLink, expectedText, "Footer Projects Link Text", "equals", true);
	}

	public boolean getProjectsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerProjectsLink, "href", expectedHref, "Footer Projects Link Href");
	}

	public boolean clickOnFooterBlogsLink() {
		return clickOnElement(footerBlogsLink, "Footer Blogs Link");
	}

	public boolean getBlogsLinkText(String expectedText) {
		return verifyText(footerBlogsLink, expectedText, "Footer Blogs Link Text", "equals", true);
	}

	public boolean getBlogsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerBlogsLink, "href", expectedHref, "Footer Blogs Link Href");
	}

	public boolean clickOnFooterCareersLink() {
		return clickOnElement(footerCareersLink, "Footer Careers Link");
	}

	public boolean getCareersLinkText(String expectedText) {
		return verifyText(footerCareersLink, expectedText, "Footer Careers Link Text", "equals", true);
	}

	public boolean getCareersLinkHref(String expectedHref) {
		return verifyElementAttribute(footerCareersLink, "href", expectedHref, "Footer Careers Link Href");
	}

	// ============================================================
	// SERVICES LINKS
	// ============================================================

	public boolean clickOnFooterExploreSolutionsLink() {
		return clickOnElement(footerExploreSolutionsLink, "Footer Explore Solutions Link");
	}

	public boolean getExploreSolutionsLinkText(String expectedText) {
		return verifyText(footerExploreSolutionsLink, expectedText, "Footer Explore Solutions Link Text", "equals",
				true);
	}

	public boolean getExploreSolutionsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerExploreSolutionsLink, "href", expectedHref,
				"Footer Explore Solutions Link Href");
	}

	public boolean clickOnFooterWebAppsLink() {
		return clickOnElement(footerWebAppsLink, "Footer Web Apps Link");
	}

	public boolean getWebAppsLinkText(String expectedText) {
		return verifyText(footerWebAppsLink, expectedText, "Footer Web Apps Link Text", "equals", true);
	}

	public boolean getWebAppsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerWebAppsLink, "href", expectedHref, "Footer Web Apps Link Href");
	}

	public boolean clickOnFooterQaAutomationLink() {
		return clickOnElement(footerQaAutomationLink, "Footer QA Automation Link");
	}

	public boolean getQaAutomationLinkText(String expectedText) {
		return verifyText(footerQaAutomationLink, expectedText, "Footer QA Automation Link Text", "equals", true);
	}

	public boolean getQaAutomationLinkHref(String expectedHref) {
		return verifyElementAttribute(footerQaAutomationLink, "href", expectedHref, "Footer QA Automation Link Href");
	}

	public boolean clickOnFooterAiSystemsLink() {
		return clickOnElement(footerAiSystemsLink, "Footer AI Systems Link");
	}

	public boolean getAiSystemsLinkText(String expectedText) {
		return verifyText(footerAiSystemsLink, expectedText, "Footer AI Systems Link Text", "equals", true);
	}

	public boolean getAiSystemsLinkHref(String expectedHref) {
		return verifyElementAttribute(footerAiSystemsLink, "href", expectedHref, "Footer AI Systems Link Href");
	}

	public boolean clickOnFooterBlockchainLink() {
		return clickOnElement(footerBlockchainLink, "Footer Blockchain Link");
	}

	public boolean getBlockchainLinkText(String expectedText) {
		return verifyText(footerBlockchainLink, expectedText, "Footer Blockchain Link Text", "equals", true);
	}

	public boolean getBlockchainLinkHref(String expectedHref) {
		return verifyElementAttribute(footerBlockchainLink, "href", expectedHref, "Footer Blockchain Link Href");
	}

	// ============================================================
	// SUPPORT LINKS
	// ============================================================

	public boolean clickOnFooterContactLink() {
		return clickOnElement(footerContactLink, "Footer Contact Link");
	}

	public boolean getContactLinkText(String expectedText) {
		return verifyText(footerContactLink, expectedText, "Footer Contact Link Text", "equals", true);
	}

	public boolean getContactLinkHref(String expectedHref) {
		return verifyElementAttribute(footerContactLink, "href", expectedHref, "Footer Contact Link Href");
	}

	public boolean clickOnFooterPrivacyPolicyLink() {
		return clickOnElement(footerPrivacyPolicyLink, "Footer Privacy Policy Link");
	}

	public boolean getPrivacyPolicyLinkText(String expectedText) {
		return verifyText(footerPrivacyPolicyLink, expectedText, "Footer Privacy Policy Link Text", "equals", true);
	}

	public boolean getPrivacyPolicyLinkHref(String expectedHref) {
		return verifyElementAttribute(footerPrivacyPolicyLink, "href", expectedHref, "Footer Privacy Policy Link Href");
	}

	public boolean clickOnFooterLoginLink() {
		return clickOnElement(footerLoginLink, "Footer Login Link");
	}

	public boolean getLoginLinkText(String expectedText) {
		return verifyText(footerLoginLink, expectedText, "Footer Login Link Text", "equals", true);
	}

	public boolean getLoginLinkHref(String expectedHref) {
		return verifyElementAttribute(footerLoginLink, "href", expectedHref, "Footer Login Link Href");
	}

	public boolean clickOnFooterRegisterLink() {
		return clickOnElement(footerRegisterLink, "Footer Register Link");
	}

	public boolean getRegisterLinkText(String expectedText) {
		return verifyText(footerRegisterLink, expectedText, "Footer Register Link Text", "equals", true);
	}

	public boolean getRegisterLinkHref(String expectedHref) {
		return verifyElementAttribute(footerRegisterLink, "href", expectedHref, "Footer Register Link Href");
	}

	// ============================================================
	// ADDRESS / DETAILS
	// ============================================================

	public boolean getAllAddressSectionsDetails() {
		printTextOfAllElements(footerAddressAllParagraphs, "Footer Address Section all links");
		return verifyListHasElements(footerAddressAllParagraphs, "Footer Address  All Paragraphs Details");
	}

	public boolean verifyFooterAddressHeaderText(String expectedText) {
		return verifyText(footerAddressHeadingText, expectedText, "Footer Address header Text", "equals", true);
	}

	public boolean verifyFooterAddressText(String expectedText) {
		return verifyText(footerAddressText, expectedText, "Footer Address Text", "equals", true);
	}

	public boolean verifyFooterPhoneText(String expectedText) {
		return verifyText(footerPhoneText, expectedText, "Footer Phone Text", "equals", true);
	}

	public boolean verifyFooterEmailText(String expectedText) {
		return verifyText(footerEmailText, expectedText, "Footer Email Text", "equals", true);
	}

	public boolean verifyFooterWebsiteText(String expectedText) {
		return verifyText(footerWebsiteText, expectedText, "Footer Website Text", "equals", true);
	}

	// ============================================================
	// COPYRIGHT
	// ============================================================

	public boolean getFooterCopyrightText(String expectedText) {
		return verifyText(footerCopyrightText, expectedText, "Footer Copyright Text", "contains", true);
	}

	// ============================================================
	// BULK
	// ============================================================

	public boolean getAllFooterLinks() {
		printTextOfAllElements(footerAllLinks, "All Footer links");
		return verifyListHasElements(footerAllLinks, "Footer All Links");
	}
}