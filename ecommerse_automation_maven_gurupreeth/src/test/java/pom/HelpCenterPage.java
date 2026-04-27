package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HelpCenterPage extends AllVerifications {

	public HelpCenterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "main.min-h-screen")
	private WebElement helpCenterMainContainer;

	@FindBy(css = "main section:first-child h1")
	private WebElement helpCenterMainHeading;

	@FindBy(css = "main section:first-child p")
	private WebElement helpCenterSubHeading;

	@FindBy(css = "main section:first-child input[placeholder*='Search']")
	private WebElement searchInputField;

	@FindBy(css = "nav.flex.gap-2 a")
	private List<WebElement> navigationLinks;

	// Quick cards (grid)
	@FindBy(css = "section div.grid a")
	private List<WebElement> quickCard;

	// FAQ Section
	@FindBy(css = "section#faqs h2")
	private WebElement faqHeading;

	@FindBy(css = "section#faqs button")
	private WebElement faqQuestion;

	@FindBy(css = "section#faqs button p")
	private WebElement faqAnswer;

	// Contact section
	@FindBy(css = "section#contact h3")
	private WebElement contactHeading;

	@FindBy(css = "section#contact p")
	private WebElement contactSubText;

	@FindBy(css = "section#contact a[href^='tel']")
	private WebElement callSupportButton;

	@FindBy(css = "section#contact a[href^='mailto']")
	private WebElement emailSupportButton;

	@FindBy(css = "section#contact a[href='#faqs']")
	private WebElement browseFaqButton;

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyHelpCenterPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyHelpCenterPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ HEADER SECTION VERIFICATIONS
	// ============================================================

	public boolean verifyHelpCenterMainContainerVisible() {
		return verifyElementPresentAndVisible(helpCenterMainContainer, "Help Center Main Container");
	}

	public boolean verifyHelpCenterMainHeadingVisible() {
		return verifyElementPresentAndVisible(helpCenterMainHeading, "Help Center Main Heading");
	}

	public boolean verifyHelpCenterMainHeadingText(String expectedText) {
		return verifyText(helpCenterMainHeading, expectedText, "Help Center Main Heading", "contains", true);
	}

	public boolean verifyHelpCenterSubHeadingVisible() {
		return verifyElementPresentAndVisible(helpCenterSubHeading, "Help Center Sub Heading");
	}

	public boolean verifyHelpCenterSubHeadingText(String expectedText) {
		return verifyText(helpCenterSubHeading, expectedText, "Help Center Sub Heading", "contains", true);
	}

	// ============================================================
	// ✅ SEARCH FIELD
	// ============================================================

	public boolean verifySearchFieldVisible() {
		return verifyElementPresentAndVisible(searchInputField, "Search Input Field");
	}

	public boolean verifySearchFieldEnabled() {
		return verifyElementIsEnabled(searchInputField, "Search Input Field");
	}

	public boolean verifySearchFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(searchInputField, expectedPlaceholder, "Search Input Field");
	}

	public boolean enterSearchText(String text) {
		return clearAndEnterValueIntoInputField(searchInputField, text, "Search Input Field");
	}

	// ============================================================
	// ✅ NAVIGATION LINKS
	// ============================================================

	// ============================================================
	// ✅ FAQ SECTION
	// ============================================================

	public boolean verifyFaqHeadingVisible() {
		return verifyElementPresentAndVisible(faqHeading, "FAQ Heading");
	}

	public boolean verifyFaqHeadingText(String expectedText) {
		return verifyText(faqHeading, expectedText, "FAQ Heading", "contains", true);
	}

	public boolean verifyFaqQuestionVisible() {
		return verifyElementPresentAndVisible(faqQuestion, "FAQ Question");
	}

	public boolean clickFaqQuestion() {
		return clickOnElement(faqQuestion, "FAQ Question");
	}

	public boolean verifyFaqAnswerVisible() {
		return verifyElementPresentAndVisible(faqAnswer, "FAQ Answer");
	}

	public boolean verifyFaqAnswerText(String expectedText) {
		return verifyText(faqAnswer, expectedText, "FAQ Answer", "contains", true);
	}

	// ============================================================
	// ✅ CONTACT SECTION
	// ============================================================

	public boolean verifyContactHeadingVisible() {
		return verifyElementPresentAndVisible(contactHeading, "Contact Heading");
	}

	public boolean verifyContactHeadingText(String expectedText) {
		return verifyText(contactHeading, expectedText, "Contact Heading", "contains", true);
	}

	public boolean verifyContactSubTextVisible() {
		return verifyElementPresentAndVisible(contactSubText, "Contact Sub Text");
	}

	public boolean verifyContactSubText(String expectedText) {
		return verifyText(contactSubText, expectedText, "Contact Sub Text", "contains", true);
	}

	public boolean verifyCallSupportButtonVisible() {
		return verifyElementPresentAndVisible(callSupportButton, "Call Support Button");
	}

	public boolean clickCallSupportButton() {
		return clickOnElement(callSupportButton, "Call Support Button");
	}

	public boolean verifyEmailSupportButtonVisible() {
		return verifyElementPresentAndVisible(emailSupportButton, "Email Support Button");
	}

	public boolean clickEmailSupportButton() {
		return clickOnElement(emailSupportButton, "Email Support Button");
	}

	public boolean verifyBrowseFaqButtonVisible() {
		return verifyElementPresentAndVisible(browseFaqButton, "Browse FAQ Button");
	}

	public boolean clickBrowseFaqButton() {
		return clickOnElement(browseFaqButton, "Browse FAQ Button");
	}

	// ============================================================
	// ✅ FULL PAGE VALIDATION
	// ============================================================

	public boolean verifyAllHelpCenterElementsVisible() {
		return verifyHelpCenterMainContainerVisible() && verifyHelpCenterMainHeadingVisible()
				&& verifyHelpCenterSubHeadingVisible() && verifySearchFieldVisible() && verifyNavigationLinksVisible()
				&& verifyQuickCardVisible() && verifyFaqHeadingVisible() && verifyFaqQuestionVisible()
				&& verifyContactHeadingVisible() && verifyCallSupportButtonVisible()
				&& verifyEmailSupportButtonVisible() && verifyBrowseFaqButtonVisible();
	}
}