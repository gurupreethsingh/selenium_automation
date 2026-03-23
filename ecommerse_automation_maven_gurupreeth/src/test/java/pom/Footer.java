package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Footer extends AllVerifications {

	public Footer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ FOOTER ROOT
	// ============================================================

	@FindBy(css = "footer.hp-font")
	private WebElement footerRoot;

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100")
	private WebElement footerMainWrapper;

	// ============================================================
	// ✅ TRUST BADGES SECTION
	// ============================================================

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid")
	private WebElement trustBadgesSection;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div")
	private List<WebElement> allTrustBadgeCards;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(1)")
	private WebElement fastDeliveryCard;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(2)")
	private WebElement easyReturnsCard;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(3)")
	private WebElement buyerProtectionCard;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(4)")
	private WebElement supportCard;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(1) p.font-extrabold")
	private WebElement fastDeliveryTitle;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(2) p.font-extrabold")
	private WebElement easyReturnsTitle;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(3) p.font-extrabold")
	private WebElement buyerProtectionTitle;

	@FindBy(css = "footer.hp-font div.hidden.sm\\:grid > div:nth-of-type(4) p.font-extrabold")
	private WebElement supportTitle;

	// ============================================================
	// ✅ MAIN FOOTER GRID SECTIONS
	// ============================================================

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4")
	private WebElement footerGridSection;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1)")
	private WebElement companyInfoSection;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2)")
	private WebElement companyLinksSection;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3)")
	private WebElement supportLinksSection;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(4)")
	private WebElement followAndSubscribeSection;

	// ============================================================
	// ✅ COMPANY INFO SECTION
	// ============================================================

	@FindBy(css = "footer.hp-font span.text-\\[12px\\].font-extrabold.text-orange-700.uppercase.tracking-wide")
	private WebElement ecodersBadgeText;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) > p.mt-4")
	private WebElement companyDescriptionText;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3")
	private WebElement contactInfoBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(1)")
	private WebElement supportEmailBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(1) span.text-gray-700.font-semibold")
	private WebElement supportEmailText;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(2)")
	private WebElement supportPhoneBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(2) span.text-gray-700.font-semibold")
	private WebElement supportPhoneText;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(3)")
	private WebElement workingHoursBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(3) span.text-gray-700.font-semibold")
	private WebElement workingHoursText;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(4)")
	private WebElement locationBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(1) div.mt-5.space-y-3 > div:nth-of-type(4) span.text-gray-700.font-semibold")
	private WebElement locationText;

	// ============================================================
	// ✅ COMPANY LINKS SECTION
	// ============================================================

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) > h3")
	private WebElement companySectionHeading;

	@FindBy(css = "footer.hp-font a[href='/about-us']")
	private WebElement footerAboutUsLink;

	@FindBy(css = "footer.hp-font a[href='/contact-us']")
	private WebElement footerContactUsLink;

	@FindBy(css = "footer.hp-font a[href='/careers']")
	private WebElement footerCareersLink;

	@FindBy(css = "footer.hp-font a[href='/all-blogs']")
	private WebElement footerBlogsLink;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) ul.space-y-3 > li > a")
	private List<WebElement> allCompanyLinks;

	// ============================================================
	// ✅ SECURE PAYMENTS CARD
	// ============================================================

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) div.mt-6.rounded-2xl")
	private WebElement securePaymentsCard;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) div.mt-6.rounded-2xl p.text-\\[12px\\].font-extrabold.text-gray-900")
	private WebElement securePaymentsHeading;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) div.mt-6.rounded-2xl div.mt-3")
	private WebElement paymentIconsBlock;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) div.mt-6.rounded-2xl p.mt-2")
	private WebElement paymentInfoText;

	// ============================================================
	// ✅ SUPPORT LINKS SECTION
	// ============================================================

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) > h3")
	private WebElement supportSectionHeading;

	@FindBy(css = "footer.hp-font a[href='/help-center']")
	private WebElement footerHelpCenterLink;

	@FindBy(css = "footer.hp-font a[href='/privacy-policy']")
	private WebElement footerPrivacyPolicyLink;

	@FindBy(css = "footer.hp-font a[href='/terms-of-service']")
	private WebElement footerTermsOfServiceLink;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) ul.space-y-3 > li > a")
	private List<WebElement> allSupportLinks;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) div.mt-6.rounded-2xl.bg-gradient-to-r")
	private WebElement subscribeTipCard;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) div.mt-6.rounded-2xl.bg-gradient-to-r p.text-\\[12px\\].font-extrabold.text-orange-800")
	private WebElement subscribeTipHeading;

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) div.mt-6.rounded-2xl.bg-gradient-to-r p.text-\\[12px\\].text-orange-700.mt-1")
	private WebElement subscribeTipSubText;

	// ============================================================
	// ✅ FOLLOW & SUBSCRIBE SECTION
	// ============================================================

	@FindBy(css = "footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(4) > h3")
	private WebElement followAndSubscribeHeading;

	@FindBy(css = "footer.hp-font div.flex.flex-wrap.gap-3")
	private WebElement socialIconsContainer;

	@FindBy(css = "footer.hp-font div.flex.flex-wrap.gap-3 > a")
	private List<WebElement> allSocialMediaLinks;

	@FindBy(css = "footer.hp-font a[href='https://www.facebook.com']")
	private WebElement footerFacebookLink;

	@FindBy(css = "footer.hp-font a[href='https://www.twitter.com']")
	private WebElement footerTwitterLink;

	@FindBy(css = "footer.hp-font a[href='https://www.github.com']")
	private WebElement footerGithubLink;

	@FindBy(css = "footer.hp-font a[href='https://www.linkedin.com']")
	private WebElement footerLinkedinLink;

	@FindBy(css = "footer.hp-font a[href='https://www.instagram.com']")
	private WebElement footerInstagramLink;

	@FindBy(css = "footer.hp-font a[href='https://www.youtube.com']")
	private WebElement footerYoutubeLink;

	// ============================================================
	// ✅ SUBSCRIPTION FORM
	// ============================================================

	@FindBy(css = "footer.hp-font div.mt-6")
	private WebElement subscribeContainer;

	@FindBy(css = "footer div.flex.items-center.gap-2.mb-3>h4")
	private WebElement subscribeFormHeading;

	@FindBy(css = "footer.hp-font div.rounded-2xl.bg-white.border.border-orange-100.shadow-sm.p-4:nth-of-type(2)")
	private WebElement subscribeFormCard;

	@FindBy(css = "footer.hp-font form")
	private WebElement subscriptionForm;

	@FindBy(css = "footer.hp-font form input[type='email']")
	private WebElement subscriptionEmailTextField;

	@FindBy(css = "footer.hp-font form button[type='submit']")
	private WebElement subscriptionButton;

	@FindBy(css = "footer.hp-font form>p.text-red-500.text-sm")
	private WebElement subscriptionErrorMessage;

	@FindBy(css = "footer.hp-font form p.text-green-600.text-sm")
	private WebElement subscriptionSuccessMessage;

	// ============================================================
	// ✅ BOTTOM FOOTER
	// ============================================================

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100.pt-6")
	private WebElement footerBottomSection;

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100.pt-6 > p:nth-of-type(1)")
	private WebElement copyrightText;

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100.pt-6 > div")
	private WebElement secureFastReliableBlock;

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100.pt-6 > div > span")
	private WebElement secureFastReliableText;

	@FindBy(css = "footer.hp-font div.border-t.border-orange-100.pt-6 > p:nth-of-type(2)")
	private WebElement footerTaglineText;

	// ============================================================
	// ✅ ROOT / SECTION VISIBILITY METHODS
	// ============================================================

	public boolean verifyFooterRootIsDisplayed() {
		return verifyElementPresentAndVisible(footerRoot, "Footer Root");
	}

	public boolean verifyFooterMainWrapperIsDisplayed() {
		return verifyElementPresentAndVisible(footerMainWrapper, "Footer Main Wrapper");
	}

	public boolean verifyTrustBadgesSectionIsDisplayed() {
		return verifyElementPresentAndVisible(trustBadgesSection, "Trust Badges Section");
	}

	public boolean verifyFooterGridSectionIsDisplayed() {
		return verifyElementPresentAndVisible(footerGridSection, "Footer Grid Section");
	}

	public boolean verifyFooterBottomSectionIsDisplayed() {
		return verifyElementPresentAndVisible(footerBottomSection, "Footer Bottom Section");
	}

	// ============================================================
	// ✅ TRUST BADGES METHODS
	// ============================================================

	public boolean verifyTotalTrustBadgeCardsCount(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, allTrustBadgeCards);
	}

	public List<WebElement> printAllTrustBadgeTitles() {
		return printTextOfAllElements(allTrustBadgeCards, "All Trust Badge Cards");
	}

	public boolean verifyFastDeliveryCardIsDisplayed() {
		return verifyElementPresentAndVisible(fastDeliveryCard, "Fast Delivery Card");
	}

	public boolean verifyEasyReturnsCardIsDisplayed() {
		return verifyElementPresentAndVisible(easyReturnsCard, "Easy Returns Card");
	}

	public boolean verifyBuyerProtectionCardIsDisplayed() {
		return verifyElementPresentAndVisible(buyerProtectionCard, "Buyer Protection Card");
	}

	public boolean verifySupportCardIsDisplayed() {
		return verifyElementPresentAndVisible(supportCard, "Support Card");
	}

	public boolean verifyFastDeliveryTitleText(String expectedText) {
		return verifyText(fastDeliveryTitle, expectedText, "Fast Delivery Title", "equals", true);
	}

	public boolean verifyEasyReturnsTitleText(String expectedText) {
		return verifyText(easyReturnsTitle, expectedText, "Easy Returns Title", "equals", true);
	}

	public boolean verifyBuyerProtectionTitleText(String expectedText) {
		return verifyText(buyerProtectionTitle, expectedText, "Buyer Protection Title", "equals", true);
	}

	public boolean verifySupportTitleText(String expectedText) {
		return verifyText(supportTitle, expectedText, "Support Title", "equals", true);
	}

	// ============================================================
	// ✅ COMPANY INFO METHODS
	// ============================================================

	public boolean verifyCompanyInfoSectionIsDisplayed() {
		return verifyElementPresentAndVisible(companyInfoSection, "Company Info Section");
	}

	public boolean verifyEcodersBadgeText(String expectedText) {
		return verifyText(ecodersBadgeText, expectedText, "Ecoders Badge Text", "equals", true);
	}

	public boolean verifyCompanyDescriptionText(String expectedText) {
		return verifyText(companyDescriptionText, expectedText, "Company Description Text", "contains", true);
	}

	public boolean verifyContactInfoBlockIsDisplayed() {
		return verifyElementPresentAndVisible(contactInfoBlock, "Contact Info Block");
	}

	public boolean verifySupportEmailBlockIsDisplayed() {
		return verifyElementPresentAndVisible(supportEmailBlock, "Support Email Block");
	}

	public boolean verifySupportEmailText(String expectedText) {
		return verifyText(supportEmailText, expectedText, "Support Email Text", "equals", true);
	}

	public boolean verifySupportPhoneBlockIsDisplayed() {
		return verifyElementPresentAndVisible(supportPhoneBlock, "Support Phone Block");
	}

	public boolean verifySupportPhoneText(String expectedText) {
		return verifyText(supportPhoneText, expectedText, "Support Phone Text", "equals", true);
	}

	public boolean verifyWorkingHoursBlockIsDisplayed() {
		return verifyElementPresentAndVisible(workingHoursBlock, "Working Hours Block");
	}

	public boolean verifyWorkingHoursText(String expectedText) {
		return verifyText(workingHoursText, expectedText, "Working Hours Text", "equals", true);
	}

	public boolean verifyLocationBlockIsDisplayed() {
		return verifyElementPresentAndVisible(locationBlock, "Location Block");
	}

	public boolean verifyLocationText(String expectedText) {
		return verifyText(locationText, expectedText, "Location Text", "equals", true);
	}

	// ============================================================
	// ✅ COMPANY LINKS METHODS
	// ============================================================

	public boolean verifyCompanyLinksSectionIsDisplayed() {
		return verifyElementPresentAndVisible(companyLinksSection, "Company Links Section");
	}

	public boolean verifyCompanySectionHeadingText(String expectedText) {
		return verifyText(companySectionHeading, expectedText, "Company Section Heading", "equals", true);
	}

	public boolean clickOnFooterAboutUsLink() {
		return clickOnElement(footerAboutUsLink, "Footer About Us Link");
	}

	public boolean clickOnFooterContactUsLink() {
		return clickOnElement(footerContactUsLink, "Footer Contact Us Link");
	}

	public boolean clickOnFooterCareersLink() {
		return clickOnElement(footerCareersLink, "Footer Careers Link");
	}

	public boolean clickOnFooterBlogsLink() {
		return clickOnElement(footerBlogsLink, "Footer Blogs Link");
	}

	public boolean verifyFooterAboutUsLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerAboutUsLink, "Footer About Us Link");
	}

	public boolean verifyFooterContactUsLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerContactUsLink, "Footer Contact Us Link");
	}

	public boolean verifyFooterCareersLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerCareersLink, "Footer Careers Link");
	}

	public boolean verifyFooterBlogsLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerBlogsLink, "Footer Blogs Link");
	}

	public boolean verifyTotalCompanyLinksCount(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, allCompanyLinks);
	}

	public List<WebElement> printAllCompanyLinksText() {
		return printTextOfAllElements(allCompanyLinks, "All Company Links");
	}

	// ============================================================
	// ✅ SECURE PAYMENTS METHODS
	// ============================================================

	public boolean verifySecurePaymentsCardIsDisplayed() {
		return verifyElementPresentAndVisible(securePaymentsCard, "Secure Payments Card");
	}

	public boolean verifySecurePaymentsHeadingText(String expectedText) {
		return verifyText(securePaymentsHeading, expectedText, "Secure Payments Heading", "equals", true);
	}

	public boolean verifyPaymentIconsBlockIsDisplayed() {
		return verifyElementPresentAndVisible(paymentIconsBlock, "Payment Icons Block");
	}

	public boolean verifyPaymentInfoText(String expectedText) {
		return verifyText(paymentInfoText, expectedText, "Payment Info Text", "contains", true);
	}

	// ============================================================
	// ✅ SUPPORT LINKS METHODS
	// ============================================================

	public boolean verifySupportLinksSectionIsDisplayed() {
		return verifyElementPresentAndVisible(supportLinksSection, "Support Links Section");
	}

	public boolean verifySupportSectionHeadingText(String expectedText) {
		return verifyText(supportSectionHeading, expectedText, "Support Section Heading", "equals", true);
	}

	public boolean clickOnFooterHelpCenterLink() {
		return clickOnElement(footerHelpCenterLink, "Footer Help Center Link");
	}

	public boolean clickOnFooterPrivacyPolicyLink() {
		return clickOnElement(footerPrivacyPolicyLink, "Footer Privacy Policy Link");
	}

	public boolean clickOnFooterTermsOfServiceLink() {
		return clickOnElement(footerTermsOfServiceLink, "Footer Terms Of Service Link");
	}

	public boolean verifyFooterHelpCenterLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerHelpCenterLink, "Footer Help Center Link");
	}

	public boolean verifyFooterPrivacyPolicyLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerPrivacyPolicyLink, "Footer Privacy Policy Link");
	}

	public boolean verifyFooterTermsOfServiceLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerTermsOfServiceLink, "Footer Terms Of Service Link");
	}

	public boolean verifyTotalSupportLinksCount(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, allSupportLinks);
	}

	public List<WebElement> printAllSupportLinksText() {
		return printTextOfAllElements(allSupportLinks, "All Support Links");
	}

	public boolean verifySubscribeTipCardIsDisplayed() {
		return verifyElementPresentAndVisible(subscribeTipCard, "Subscribe Tip Card");
	}

	public boolean verifySubscribeTipHeadingText(String expectedText) {
		return verifyText(subscribeTipHeading, expectedText, "Subscribe Tip Heading", "contains", true);
	}

	public boolean verifySubscribeTipSubText(String expectedText) {
		return verifyText(subscribeTipSubText, expectedText, "Subscribe Tip Sub Text", "contains", true);
	}

	// ============================================================
	// ✅ FOLLOW & SOCIAL METHODS
	// ============================================================

	public boolean verifyFollowAndSubscribeSectionIsDisplayed() {
		return verifyElementPresentAndVisible(followAndSubscribeSection, "Follow And Subscribe Section");
	}

	public boolean verifyFollowAndSubscribeHeadingText(String expectedText) {
		return verifyText(followAndSubscribeHeading, expectedText, "Follow And Subscribe Heading", "equals", true);
	}

	public boolean verifySocialIconsContainerIsDisplayed() {
		return verifyElementPresentAndVisible(socialIconsContainer, "Social Icons Container");
	}

	public boolean verifyTotalSocialLinksCount(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, allSocialMediaLinks);
	}

	public List<WebElement> printAllSocialMediaLinks() {
		return printTextOfAllElements(allSocialMediaLinks, "All Social Media Links");
	}

	public boolean clickOnFooterFacebookLink() {
		return clickOnElement(footerFacebookLink, "Footer Facebook Link");
	}

	public boolean clickOnFooterTwitterLink() {
		return clickOnElement(footerTwitterLink, "Footer Twitter Link");
	}

	public boolean clickOnFooterGithubLink() {
		return clickOnElement(footerGithubLink, "Footer Github Link");
	}

	public boolean clickOnFooterLinkedinLink() {
		return clickOnElement(footerLinkedinLink, "Footer Linkedin Link");
	}

	public boolean clickOnFooterInstagramLink() {
		return clickOnElement(footerInstagramLink, "Footer Instagram Link");
	}

	public boolean clickOnFooterYoutubeLink() {
		return clickOnElement(footerYoutubeLink, "Footer Youtube Link");
	}

	public boolean verifyFooterFacebookLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerFacebookLink, "Footer Facebook Link");
	}

	public boolean verifyFooterTwitterLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerTwitterLink, "Footer Twitter Link");
	}

	public boolean verifyFooterGithubLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerGithubLink, "Footer Github Link");
	}

	public boolean verifyFooterLinkedinLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerLinkedinLink, "Footer Linkedin Link");
	}

	public boolean verifyFooterInstagramLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerInstagramLink, "Footer Instagram Link");
	}

	public boolean verifyFooterYoutubeLinkIsDisplayed() {
		return verifyElementPresentAndVisible(footerYoutubeLink, "Footer Youtube Link");
	}

	// ============================================================
	// ✅ SUBSCRIPTION FORM METHODS
	// ============================================================

	public boolean verifySubscribeContainerIsDisplayed() {
		return verifyElementPresentAndVisible(subscribeContainer, "Subscribe Container");
	}

	public boolean verifySubscribeFormHeading(String expectedText) {
		return verifyText(subscribeFormHeading, expectedText, "Subscribe Form Heading", "equals", true);
	}

	public boolean verifySubscribeFormCardIsDisplayed() {
		return verifyElementPresentAndVisible(subscribeFormCard, "Subscribe Form Card");
	}

	public boolean verifySubscriptionFormIsDisplayed() {
		return verifyElementPresentAndVisible(subscriptionForm, "Subscription Form");
	}

	public boolean verifySubscriptionEmailTextFieldIsDisplayed() {
		return verifyElementPresentAndVisible(subscriptionEmailTextField, "Subscription Email Text Field");
	}

	public boolean verifySubscriptionButtonIsDisplayed() {
		return verifyElementPresentAndVisible(subscriptionButton, "Subscription Button");
	}

	public boolean clickOnSubscriptionButton() {
		return clickOnElement(subscriptionButton, "Subscription Button");
	}

	public boolean verifySubscriptionErrorMessageIsDisplayed() {
		return verifyElementPresentAndVisible(subscriptionErrorMessage, "Subscription Error Message");
	}

	public boolean verifySubscriptionSuccessMessageIsDisplayed() {
		return verifyElementPresentAndVisible(subscriptionSuccessMessage, "Subscription Success Message");
	}

	public boolean verifySubscriptionErrorMessageText(String expectedText) {
		return verifyText(subscriptionErrorMessage, expectedText, "Subscription Error Message", "equals", true);
	}

	public boolean verifySubscriptionSuccessMessageText(String expectedText) {
		return verifyText(subscriptionSuccessMessage, expectedText, "Subscription Success Message", "contains", true);
	}

	// ============================================================
	// ✅ BOTTOM FOOTER METHODS
	// ============================================================

	public boolean verifyCopyrightText(String expectedText) {
		return verifyText(copyrightText, expectedText, "Copyright Text", "contains", true);
	}

	public boolean verifySecureFastReliableBlockIsDisplayed() {
		return verifyElementPresentAndVisible(secureFastReliableBlock, "Secure Fast Reliable Block");
	}

	public boolean verifySecureFastReliableText(String expectedText) {
		return verifyText(secureFastReliableText, expectedText, "Secure Fast Reliable Text", "equals", true);
	}

	public boolean verifyFooterTaglineText(String expectedText) {
		return verifyText(footerTaglineText, expectedText, "Footer Tagline Text", "equals", true);
	}

	// ============================================================
	// ✅ JAVASCRIPT TEXT FETCH METHODS
	// ============================================================

	public List<String> printAllCompanyLinksUsingJavascript() {
		return printTextOfAllElementsUsingJavascript(
				"footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(2) ul.space-y-3 > li > a",
				"All Company Links Using Javascript");
	}

	public List<String> printAllSupportLinksUsingJavascript() {
		return printTextOfAllElementsUsingJavascript(
				"footer.hp-font div.grid.grid-cols-1.md\\:grid-cols-4 > div:nth-of-type(3) ul.space-y-3 > li > a",
				"All Support Links Using Javascript");
	}

	public List<String> printAllSocialLinksUsingJavascript() {
		return printTextOfAllElementsUsingJavascript("footer.hp-font div.flex.flex-wrap.gap-3 > a",
				"All Social Links Using Javascript");
	}

	// ============================================================
	// ✅ PAGE TITLE / URL VALIDATION METHODS
	// ============================================================

	public boolean verifyFooterNavigatedPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyFooterNavigatedPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
}