package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Footer extends AllVerifications {

	// ============================================================
	// ✅ FOOTER ROOT
	// ============================================================

	@FindBy(css = "footer")
	private WebElement footerRoot;

	// ============================================================
	// ✅ BRAND (logo + description)
	// ============================================================

	@FindBy(css = "footer img[alt='Ecoders Logo']")
	private WebElement footerBrandLogo;

	@FindBy(css = "footer img[alt='Ecoders Logo'] + p")
	private WebElement footerBrandDescription;

	// ============================================================
	// ✅ SECTION HEADINGS
	// ============================================================

	@FindBy(xpath = "//footer//h3[normalize-space()='Company']")
	private WebElement footerCompanyHeading;

	@FindBy(xpath = "//footer//h3[normalize-space()='Services']")
	private WebElement footerServicesHeading;

	@FindBy(xpath = "//footer//h3[normalize-space()='Support']")
	private WebElement footerSupportHeading;

	@FindBy(xpath = "//footer//h3[normalize-space()='Address']")
	private WebElement footerAddressHeading;

	// ============================================================
	// ✅ COMPANY LINKS
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
	// ✅ SERVICES LINKS
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
	// ✅ SUPPORT LINKS
	// ============================================================

	@FindBy(css = "footer a[href='/contact']")
	private WebElement footerContactUsLink;

	@FindBy(css = "footer a[href='/privacy-policy']")
	private WebElement footerPrivacyPolicyLink;

	@FindBy(css = "footer a[href='/login']")
	private WebElement footerLoginLink;

	@FindBy(css = "footer a[href='/register']")
	private WebElement footerRegisterLink;

	// ============================================================
	// ✅ ADDRESS BLOCK (text only)
	// ============================================================

	// Address block container (the div which contains the Address heading)
	@FindBy(xpath = "//footer//h3[normalize-space()='Address']/parent::div")
	private WebElement footerAddressBlock;

	@FindBy(xpath = "//footer//h3[normalize-space()='Address']/following-sibling::p[1]")
	private WebElement footerAddressText;

	@FindBy(xpath = "//footer//h3[normalize-space()='Address']/following-sibling::p[2]")
	private WebElement footerPhoneText;

	@FindBy(xpath = "//footer//h3[normalize-space()='Address']/following-sibling::p[3]")
	private WebElement footerEmailText;

	@FindBy(xpath = "//footer//h3[normalize-space()='Address']/following-sibling::p[4]")
	private WebElement footerWebsiteText;

	// ============================================================
	// ✅ SOCIAL PLACEHOLDERS (href="#")
	// ============================================================

	@FindBy(xpath = "//footer//span[@class='sr-only' and normalize-space()='Facebook']/parent::a")
	private WebElement footerFacebookLink;

	@FindBy(xpath = "//footer//span[@class='sr-only' and normalize-space()='Twitter']/parent::a")
	private WebElement footerTwitterLink;

	@FindBy(xpath = "//footer//span[@class='sr-only' and normalize-space()='Instagram']/parent::a")
	private WebElement footerInstagramLink;

	@FindBy(css = "footer .mt-4.flex.justify-center.space-x-6 a")
	private List<WebElement> footerAllSocialLinks;

	// ============================================================
	// ✅ COPYRIGHT TEXT
	// ============================================================

	@FindBy(css = "footer div.mt-8.border-t.border-gray-700.pt-8.text-center.text-sm.text-gray-400 p")
	private WebElement footerCopyrightText;

	// ============================================================
	// ✅ NEWSLETTER SECTION (this is outside <footer> in App.jsx)
	// ============================================================

	// Root wrapper (helps in scrolling / visibility checks)
	@FindBy(css = "div.relative.isolate.overflow-hidden.bg-white")
	private WebElement newsletterRoot;

	// Left side heading + description
	@FindBy(xpath = "//h2[normalize-space()='Subscribe to Our Newsletter']")
	private WebElement newsletterHeading;

	@FindBy(xpath = "//h2[normalize-space()='Subscribe to Our Newsletter']/following-sibling::p[1]")
	private WebElement newsletterDescription;

	// Form elements
	@FindBy(css = "input#email-address")
	private WebElement newsletterEmailInput;

	@FindBy(css = "button[type='submit']")
	private WebElement newsletterSubscribeButton;

	// Success / error message (same element in your JSX: <p className="...">)
	private final By newsletterMessageBy = By.cssSelector("p.mt-4.text-sm");

	// RIGHT side “Monthly Updates” / “No Spam” blocks (text verifications)
	@FindBy(xpath = "//dt[normalize-space()='Monthly Updates']")
	private WebElement newsletterMonthlyUpdatesTitle;

	@FindBy(xpath = "//dt[normalize-space()='Monthly Updates']/following-sibling::dd[1]")
	private WebElement newsletterMonthlyUpdatesDesc;

	@FindBy(xpath = "//dt[normalize-space()='No Spam']")
	private WebElement newsletterNoSpamTitle;

	@FindBy(xpath = "//dt[normalize-space()='No Spam']/following-sibling::dd[1]")
	private WebElement newsletterNoSpamDesc;

	// ============================================================
	// ✅ INIT
	// ============================================================

	public Footer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ FOOTER VISIBILITY / BASIC TEXT GETTERS
	// ============================================================

	public boolean isFooterVisible() {
		return isElementDisplayed(footerRoot, "Footer Root");
	}

	public void scrollToFooter() {
		scrollToElement(footerRoot, "Footer Root");
	}

	public boolean isNewsletterVisible() {
		return isElementDisplayed(newsletterRoot, "Newsletter Root");
	}

	public void scrollToNewsletter() {
		scrollToElement(newsletterRoot, "Newsletter Root");
	}

	public String getFooterBrandDescriptionText() {
		return getTextFromElement(footerBrandDescription, "Footer Brand Description");
	}

	public String getFooterAddressText() {
		return getTextFromElement(footerAddressText, "Footer Address Text");
	}

	public String getFooterPhoneText() {
		return getTextFromElement(footerPhoneText, "Footer Phone Text");
	}

	public String getFooterEmailText() {
		return getTextFromElement(footerEmailText, "Footer Email Text");
	}

	public String getFooterWebsiteText() {
		return getTextFromElement(footerWebsiteText, "Footer Website Text");
	}

	public String getFooterCopyrightText() {
		return getTextFromElement(footerCopyrightText, "Footer Copyright Text");
	}

	// ============================================================
	// ✅ BRAND ACTIONS
	// ============================================================

	public void clickOnFooterLogo() {
		clickOnElement(footerBrandLogo, "Footer Brand Logo");
	}

	// ============================================================
	// ✅ COMPANY LINK ACTIONS
	// ============================================================

	public void clickOnFooterAboutUs() {
		clickOnElement(footerAboutUsLink, "Footer About Us Link");
	}

	public void clickOnFooterProjects() {
		clickOnElement(footerProjectsLink, "Footer Projects Link");
	}

	public void clickOnFooterBlogs() {
		clickOnElement(footerBlogsLink, "Footer Blogs Link");
	}

	public void clickOnFooterCareers() {
		clickOnElement(footerCareersLink, "Footer Careers Link");
	}

	// ============================================================
	// ✅ SERVICES LINK ACTIONS
	// ============================================================

	public void clickOnFooterExploreSolutions() {
		clickOnElement(footerExploreSolutionsLink, "Footer Explore Solutions Link");
	}

	public void clickOnFooterWebApps() {
		clickOnElement(footerWebAppsLink, "Footer Web & Mobile Apps Link");
	}

	public void clickOnFooterQaAutomation() {
		clickOnElement(footerQaAutomationLink, "Footer QA Automation Link");
	}

	public void clickOnFooterAiSystems() {
		clickOnElement(footerAiSystemsLink, "Footer AI Systems Link");
	}

	public void clickOnFooterBlockchain() {
		clickOnElement(footerBlockchainLink, "Footer Blockchain Link");
	}

	// ============================================================
	// ✅ SUPPORT LINK ACTIONS
	// ============================================================

	public void clickOnFooterContactUs() {
		clickOnElement(footerContactUsLink, "Footer Contact Us Link");
	}

	public void clickOnFooterPrivacyPolicy() {
		clickOnElement(footerPrivacyPolicyLink, "Footer Privacy Policy Link");
	}

	public void clickOnFooterLogin() {
		clickOnElement(footerLoginLink, "Footer Login Link");
	}

	public void clickOnFooterRegister() {
		clickOnElement(footerRegisterLink, "Footer Register Link");
	}

	// ============================================================
	// ✅ SOCIAL LINKS ACTIONS
	// ============================================================

	public void clickOnFooterFacebook() {
		clickOnElement(footerFacebookLink, "Footer Facebook Link");
	}

	public void clickOnFooterTwitter() {
		clickOnElement(footerTwitterLink, "Footer Twitter Link");
	}

	public void clickOnFooterInstagram() {
		clickOnElement(footerInstagramLink, "Footer Instagram Link");
	}

	public int getFooterSocialLinksCount() {
		return footerAllSocialLinks == null ? 0 : footerAllSocialLinks.size();
	}

	public void clickOnFooterSocialLinkByIndex(int indexZeroBased) {
		if (footerAllSocialLinks == null || footerAllSocialLinks.isEmpty()) {
			System.out.println("[FOOTER] No social links found.");
			return;
		}
		if (indexZeroBased < 0 || indexZeroBased >= footerAllSocialLinks.size()) {
			System.out.println("[FOOTER] Invalid social index: " + indexZeroBased);
			return;
		}
		clickOnElement(footerAllSocialLinks.get(indexZeroBased), "Footer Social Link #" + indexZeroBased);
	}

	// ============================================================
	// ✅ NEWSLETTER ACTIONS
	// ============================================================

	public String getNewsletterHeadingText() {
		return getTextFromElement(newsletterHeading, "Newsletter Heading");
	}

	public String getNewsletterDescriptionText() {
		return getTextFromElement(newsletterDescription, "Newsletter Description");
	}

	public void enterEmailInNewsletter(String email) {
		typeInInputField(newsletterEmailInput, email, "Newsletter Email Input");
	}

	public void clickOnNewsletterSubscribeButton() {
		clickOnElement(newsletterSubscribeButton, "Newsletter Subscribe Button");
	}

	public void subscribeToNewsletter(String email) {
		enterEmailInNewsletter(email);
		clickOnNewsletterSubscribeButton();
	}

	public String getNewsletterMessageText() {
		if (!isElementPresentInDOM(newsletterMessageBy))
			return "";
		List<WebElement> els = driver.findElements(newsletterMessageBy);
		if (els.isEmpty())
			return "";
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	// Right side info blocks (optional getters)
	public String getNewsletterMonthlyUpdatesTitleText() {
		return getTextFromElement(newsletterMonthlyUpdatesTitle, "Newsletter Monthly Updates Title");
	}

	public String getNewsletterMonthlyUpdatesDescText() {
		return getTextFromElement(newsletterMonthlyUpdatesDesc, "Newsletter Monthly Updates Desc");
	}

	public String getNewsletterNoSpamTitleText() {
		return getTextFromElement(newsletterNoSpamTitle, "Newsletter No Spam Title");
	}

	public String getNewsletterNoSpamDescText() {
		return getTextFromElement(newsletterNoSpamDesc, "Newsletter No Spam Desc");
	}

	// ============================================================
	// ✅ SIMPLE VERIFICATIONS (optional)
	// ============================================================

	public void verifyFooterVisible() {
		isFooterVisible();
	}

	public void verifyNewsletterVisible() {
		isNewsletterVisible();
	}
}