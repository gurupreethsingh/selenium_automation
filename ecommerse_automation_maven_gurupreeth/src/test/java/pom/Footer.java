package pom;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(css = "footer")
	private WebElement footerRoot;

	@FindBy(css = "footer a[href='/about-us']")
	private WebElement footerAboutUsLink;

	@FindBy(css = "footer a[href='/contact-us']")
	private WebElement footerContactUsLink;

	@FindBy(css = "footer a[href='/careers']")
	private WebElement footerCareersLink;

	@FindBy(css = "footer a[href='/all-blogs']")
	private WebElement footerBlogsLink;

	@FindBy(css = "footer a[href='/help-center']")
	private WebElement footerHelpCenterLink;

	@FindBy(css = "footer a[href='/privacy-policy']")
	private WebElement footerPrivacyPolicyLink;

	@FindBy(css = "footer a[href='/terms-of-service']")
	private WebElement footerTermsOfServiceLink;

	@FindBy(css = "footer a[target='_blank'][rel='noreferrer']")
	private List<WebElement> footerSocialLinks;

	@FindBy(css = "footer input[type='email']")
	private WebElement footerSubscribeEmailInput;

	@FindBy(css = "footer button[type='submit']")
	private WebElement footerSubscribeButton;

	private final By footerSubscribeErrorBy = By.cssSelector("footer p.text-red-500");
	private final By footerSubscribeOkMsgBy = By.cssSelector("footer p.text-green-600");

	// ============================================================
	// ✅ FOOTER + SUBSCRIPTIONFORM ACTIONS
	// ============================================================

	public boolean isFooterVisible() {
		return isElementDisplayed(footerRoot, "Footer Root");
	}

	public void clickFooterAboutUs() {
		clickOnElement(footerAboutUsLink, "Footer About Us");
	}

	public void clickFooterContactUs() {
		clickOnElement(footerContactUsLink, "Footer Contact Us");
	}

	public void clickFooterCareers() {
		clickOnElement(footerCareersLink, "Footer Careers");
	}

	public void clickFooterBlogs() {
		clickOnElement(footerBlogsLink, "Footer Blogs");
	}

	public void clickFooterHelpCenter() {
		clickOnElement(footerHelpCenterLink, "Footer Help Center");
	}

	public void clickFooterPrivacyPolicy() {
		clickOnElement(footerPrivacyPolicyLink, "Footer Privacy Policy");
	}

	public void clickFooterTermsOfService() {
		clickOnElement(footerTermsOfServiceLink, "Footer Terms of Service");
	}

	public int getFooterSocialLinkCount() {
		return footerSocialLinks == null ? 0 : footerSocialLinks.size();
	}

	public void clickFooterSocialLinkByIndex(int indexZeroBased) {
		if (footerSocialLinks == null || footerSocialLinks.isEmpty()) {
			System.out.println("[FOOTER] No footer social links found.");
			return;
		}
		if (indexZeroBased < 0 || indexZeroBased >= footerSocialLinks.size()) {
			System.out.println("[FOOTER] Invalid footer social index: " + indexZeroBased);
			return;
		}
		clickOnElement(footerSocialLinks.get(indexZeroBased), "Footer Social Link #" + indexZeroBased);
	}

	public void enterEmailInFooterSubscription(String email) {
		typeInInputField(footerSubscribeEmailInput, email, "Footer Subscribe Email");
	}

	public void clickFooterSubscribeButton() {
		clickOnElement(footerSubscribeButton, "Footer Subscribe Button");
	}

	public void subscribeFromFooter(String email) {
		enterEmailInFooterSubscription(email);
		clickFooterSubscribeButton();
	}

	public String getFooterSubscriptionError() {
		if (!isElementPresentInDOM(footerSubscribeErrorBy)) {
			return "";
		}
		List<WebElement> els = driver.findElements(footerSubscribeErrorBy);
		if (els.isEmpty()) {
			return "";
		}
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	public String getFooterSubscriptionSuccessMessage() {
		if (!isElementPresentInDOM(footerSubscribeOkMsgBy)) {
			return "";
		}
		List<WebElement> els = driver.findElements(footerSubscribeOkMsgBy);
		if (els.isEmpty()) {
			return "";
		}
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}
}