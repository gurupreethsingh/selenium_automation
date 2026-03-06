//package pom;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import generic.AllVerifications;
//
//public class HomePage extends AllVerifications {
//
//	// ============================================================
//	// ✅ ROOT / PAGE WRAPPER
//	// ============================================================
//
//	@FindBy(css = "div.bg-white.text-slate-900")
//	private WebElement pageRoot; // parent element which contains the entire page/homepage.
//
//	// ============================================================
//	// ✅ HERO SECTION (top)
//	// ============================================================
//
//	@FindBy(css = "section.relative.overflow-hidden")
//	private WebElement heroSection;
//
//	// Badge container + badges
//	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4")
//	private WebElement badgeContainer;
//
//	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span")
//	private List<WebElement> allBadges; // SOFTWARE, AI SYSTEMS, BLOCKCHAIN, CLOUD
//
//	// Main Hero Grid
//	@FindBy(css = "section.relative.overflow-hidden div.grid.grid-cols-1.lg\\:grid-cols-2.gap-10.items-center")
//	private WebElement heroGrid;
//
//	// LEFT TEXT BLOCK
//	@FindBy(css = "section.relative.overflow-hidden h1.text-3xl.sm\\:text-4xl.lg\\:text-5xl.font-semibold")
//	private WebElement heroMainHeading;
//
//	@FindBy(css = "section.relative.overflow-hidden h1.text-3xl.sm\\:text-4xl.lg\\:text-5xl.font-semibold > span")
//	private WebElement heroGradientSubHeading;
//
//	@FindBy(css = "section.relative.overflow-hidden p.mt-4.text-sm.sm\\:text-base.lg\\:text-lg")
//	private WebElement heroMainParagraph;
//
//	// CTA buttons area
//	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4")
//	private WebElement ctaButtonContainer;
//
//	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4 > button:nth-of-type(1)")
//	private WebElement exploreSolutionsButton;
//
//	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4 > button:nth-of-type(2)")
//	private WebElement viewProjectsButton;
//
//	// RIGHT — feature preview box
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl")
//	private WebElement rightPreviewBox;
//
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium")
//	private WebElement rightPreviewTopLine;
//
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium span.text-slate-900")
//	private WebElement rightPreviewTopLineLeftText;
//
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium span.bg-gradient-to-r")
//	private WebElement rightPreviewTopLineGradientText;
//
//	// Quick links grid (4 links)
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4")
//	private WebElement quickLinksGrid;
//
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a")
//	private List<WebElement> allQuickLinks; // 4 cards/links
//
//	// Each quick link label span
//	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a span.text-sm.font-medium.text-slate-800")
//	private List<WebElement> allQuickLinkLabels;
//
//	// ============================================================
//	// ✅ FEATURE GRID SECTION (What We Build)
//	// ============================================================
//
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white")
//	private WebElement featureSection;
//
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white h2.text-xl.sm\\:text-2xl.lg\\:text-3xl.font-semibold")
//	private WebElement featureSectionHeading; // "What We Build"
//
//	// Feature cards container
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3")
//	private WebElement featureCardsGrid;
//
//	// All feature cards (6)
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group")
//	private List<WebElement> allFeatureCards;
//
//	// Each card: title h3
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group h3.text-base.font-semibold.text-slate-900")
//	private List<WebElement> allFeatureCardTitles;
//
//	// Each card: description paragraph
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group p.mt-4.text-sm.text-slate-600")
//	private List<WebElement> allFeatureCardDescriptions;
//
//	// Each card: Learn more link
//	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group a.inline-flex")
//	private List<WebElement> allFeatureCardLearnMoreLinks;
//
//	// ============================================================
//	// ✅ By locators (React-friendly dynamic access when needed)
//	// ============================================================
//
//	private final By badgesBy = By.cssSelector("section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span");
//
//	private final By quickLinksBy = By.cssSelector(
//			"section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a");
//
//	private final By featureCardsBy = By.cssSelector(
//			"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group");
//
//	// nth-of-type helpers (1-based)
//	private By badgeNth(int n) {
//		return By.cssSelector(
//				"section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span:nth-of-type(" + n + ")");
//	}
//
//	private By quickLinkNth(int n) {
//		return By.cssSelector(
//				"section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a:nth-of-type("
//						+ n + ")");
//	}
//
//	private By featureCardNth(int n) {
//		return By.cssSelector(
//				"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group:nth-of-type("
//						+ n + ")");
//	}
//
//	private By featureCardLearnMoreNth(int n) {
//		return By.cssSelector(
//				"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group:nth-of-type("
//						+ n + ") a.inline-flex");
//	}
//
//	// ============================================================
//	// ✅ INITIALIZE ALL ELEMENTS
//	// ============================================================
//
//	public HomePage(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);
//	}
//
//	// ============================================================
//	// ✅ PAGE BASIC VERIFICATION
//	// ============================================================
//
//	public boolean isHomePageRootDisplayed() {
//		return isElementDisplayed(pageRoot, "HomePage Root");
//	}
//
//	public void verifyHomePageTitle(String expectedTitle) {
//		verifyTitleOfWebpage(expectedTitle);
//	}
//
//	public void verifyHomePageUrl(String expectedUrl) {
//		verifyUrlOfWebpage(expectedUrl);
//	}
//
//	// ============================================================
//	// ✅ BADGES (4)
//	// ============================================================
//
//	public int getBadgesCount() {
//		return driver.findElements(badgesBy).size();
//	}
//
//	public String getBadgeText(int badgeIndex1Based) {
//		WebElement badge = waitUntilElementVisible(badgeNth(badgeIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Badge " + badgeIndex1Based);
//		return badge == null ? "" : getTextFromElement(badge, "Badge " + badgeIndex1Based);
//	}
//
//	public void verifyTextOfFirstBadge() {
//		getTextFromElement(allBadges.get(0), "Badge 1 (SOFTWARE)");
//	}
//
//	public void verifyTextOfSecondBadge() {
//		getTextFromElement(allBadges.get(1), "Badge 2 (AI SYSTEMS)");
//	}
//
//	public void verifyTextOfThirdBadge() {
//		getTextFromElement(allBadges.get(2), "Badge 3 (BLOCKCHAIN)");
//	}
//
//	public void verifyTextOfFourthBadge() {
//		getTextFromElement(allBadges.get(3), "Badge 4 (CLOUD)");
//	}
//
//	// ============================================================
//	// ✅ HERO TEXTS
//	// ============================================================
//
//	public String getHeroMainHeadingText() {
//		return getTextFromElement(heroMainHeading, "Hero Main Heading");
//	}
//
//	public String getHeroSubHeadingText() {
//		return getTextFromElement(heroGradientSubHeading, "Hero Sub Heading");
//	}
//
//	public String getHeroMainParagraphText() {
//		return getTextFromElement(heroMainParagraph, "Hero Main Paragraph");
//	}
//
//	// ============================================================
//	// ✅ HERO CTA BUTTONS
//	// ============================================================
//
//	public void clickOnExploreSolutionsButton() {
//		clickOnElement(exploreSolutionsButton, "Explore Solutions Button");
//	}
//
//	public void clickOnViewProjectsButton() {
//		clickOnElement(viewProjectsButton, "View Projects Button");
//	}
//
//	// ============================================================
//	// ✅ RIGHT PREVIEW BOX
//	// ============================================================
//
//	public boolean isRightPreviewBoxDisplayed() {
//		return isElementDisplayed(rightPreviewBox, "Right Preview Box");
//	}
//
//	public String getRightPreviewTopLineText() {
//		return getTextFromElement(rightPreviewTopLine, "Right Preview Top Line");
//	}
//
//	public String getRightPreviewLeftText() {
//		return getTextFromElement(rightPreviewTopLineLeftText, "Right Preview Left Text");
//	}
//
//	public String getRightPreviewGradientText() {
//		return getTextFromElement(rightPreviewTopLineGradientText, "Right Preview Gradient Text");
//	}
//
//	// ============================================================
//	// ✅ QUICK LINKS (4)
//	// ============================================================
//
//	public int getQuickLinksCount() {
//		return driver.findElements(quickLinksBy).size();
//	}
//
//	public String getQuickLinkLabelText(int linkIndex1Based) {
//		WebElement link = waitUntilElementVisible(quickLinkNth(linkIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Quick Link " + linkIndex1Based);
//		if (link == null)
//			return "";
//		// inside the <a>, label span exists
//		WebElement label = link.findElement(By.cssSelector("span.text-sm.font-medium.text-slate-800"));
//		return getTextFromElement(label, "Quick Link Label " + linkIndex1Based);
//	}
//
//	public String getQuickLinkHref(int linkIndex1Based) {
//		WebElement link = waitUntilElementVisible(quickLinkNth(linkIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Quick Link " + linkIndex1Based);
//		return link == null ? "" : (link.getAttribute("href") == null ? "" : link.getAttribute("href"));
//	}
//
//	public void clickQuickLink(int linkIndex1Based) {
//		clickOnElement(quickLinkNth(linkIndex1Based), "Quick Link " + linkIndex1Based);
//	}
//
//	// Overload for click using By (your AllVerifications supports it)
//	public void clickElementOfHomepage(By locator, String name) {
//		super.clickOnElement(locator, name);
//	}
//
//	// ============================================================
//	// ✅ FEATURE SECTION (What We Build)
//	// ============================================================
//
//	public boolean isFeatureSectionDisplayed() {
//		return isElementDisplayed(featureSection, "Feature Section");
//	}
//
//	public String getFeatureSectionHeadingText() {
//		return getTextFromElement(featureSectionHeading, "Feature Section Heading");
//	}
//
//	// ============================================================
//	// ✅ FEATURE CARDS (6)
//	// ============================================================
//
//	public int getFeatureCardsCount() {
//		return driver.findElements(featureCardsBy).size();
//	}
//
//	public String getFeatureCardTitle(int cardIndex1Based) {
//		WebElement card = waitUntilElementVisible(featureCardNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Feature Card " + cardIndex1Based);
//		if (card == null)
//			return "";
//		WebElement title = card.findElement(By.cssSelector("h3.text-base.font-semibold.text-slate-900"));
//		return getTextFromElement(title, "Feature Card Title " + cardIndex1Based);
//	}
//
//	public String getFeatureCardDescription(int cardIndex1Based) {
//		WebElement card = waitUntilElementVisible(featureCardNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Feature Card " + cardIndex1Based);
//		if (card == null)
//			return "";
//		WebElement desc = card.findElement(By.cssSelector("p.mt-4.text-sm.text-slate-600"));
//		return getTextFromElement(desc, "Feature Card Description " + cardIndex1Based);
//	}
//
//	public String getFeatureCardLearnMoreHref(int cardIndex1Based) {
//		WebElement link = waitUntilElementVisible(featureCardLearnMoreNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
//				"Feature Card Learn More " + cardIndex1Based);
//		return link == null ? "" : (link.getAttribute("href") == null ? "" : link.getAttribute("href"));
//	}
//
//	public void clickFeatureCardLearnMore(int cardIndex1Based) {
//		clickOnElement(featureCardLearnMoreNth(cardIndex1Based), "Feature Card Learn More " + cardIndex1Based);
//	}
//}

package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HomePage extends AllVerifications {

	// ============================================================
	// ✅ ROOT / PAGE WRAPPER
	// ============================================================

	@FindBy(css = "div.bg-white.text-slate-900")
	private WebElement pageRoot; // parent element which contains the entire page/homepage.

	// ============================================================
	// ✅ HERO SECTION (top)
	// ============================================================

	@FindBy(css = "section.relative.overflow-hidden")
	private WebElement heroSection;

	// Badge container + badges
	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4")
	private WebElement badgeContainer;

	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span")
	private List<WebElement> allBadges; // SOFTWARE, AI SYSTEMS, BLOCKCHAIN, CLOUD

	// Main Hero Grid
	@FindBy(css = "section.relative.overflow-hidden div.grid.grid-cols-1.lg\\:grid-cols-2.gap-10.items-center")
	private WebElement heroGrid;

	// LEFT TEXT BLOCK
	@FindBy(css = "section.relative.overflow-hidden h1.text-3xl.sm\\:text-4xl.lg\\:text-5xl.font-semibold")
	private WebElement heroMainHeading;

	@FindBy(css = "section.relative.overflow-hidden h1.text-3xl.sm\\:text-4xl.lg\\:text-5xl.font-semibold > span")
	private WebElement heroGradientSubHeading;

	@FindBy(css = "section.relative.overflow-hidden p.mt-4.text-sm.sm\\:text-base.lg\\:text-lg")
	private WebElement heroMainParagraph;

	// CTA buttons area
	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4")
	private WebElement ctaButtonContainer;

	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4 > button:nth-of-type(1)")
	private WebElement exploreSolutionsButton;

	@FindBy(css = "section.relative.overflow-hidden div.mt-7.flex.flex-wrap.gap-4 > button:nth-of-type(2)")
	private WebElement viewProjectsButton;

	// RIGHT — feature preview box
	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl")
	private WebElement rightPreviewBox;

	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium")
	private WebElement rightPreviewTopLine;

	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium span.text-slate-900")
	private WebElement rightPreviewTopLineLeftText;

	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl > div.text-sm.sm\\:text-base.font-medium span.bg-gradient-to-r")
	private WebElement rightPreviewTopLineGradientText;

	// Quick links grid (4 links)
	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4")
	private WebElement quickLinksGrid;

	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a")
	private List<WebElement> allQuickLinks; // 4 cards/links

	// Each quick link label span
	@FindBy(css = "section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a span.text-sm.font-medium.text-slate-800")
	private List<WebElement> allQuickLinkLabels;

	// ============================================================
	// ✅ FEATURE GRID SECTION (What We Build)
	// ============================================================

	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white")
	private WebElement featureSection;

	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white h2.text-xl.sm\\:text-2xl.lg\\:text-3xl.font-semibold")
	private WebElement featureSectionHeading; // "What We Build"

	// Feature cards container
	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3")
	private WebElement featureCardsGrid;

	// All feature cards (6)
	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group")
	private List<WebElement> allFeatureCards;

	// Each card: title h3
	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group h3.text-base.font-semibold.text-slate-900")
	private List<WebElement> allFeatureCardTitles;

	// Each card: description paragraph
	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group p.mt-4.text-sm.text-slate-600")
	private List<WebElement> allFeatureCardDescriptions;

	// Each card: Learn more link
	@FindBy(css = "section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group a.inline-flex")
	private List<WebElement> allFeatureCardLearnMoreLinks;

	// ============================================================
	// ✅ By locators (React-friendly dynamic access when needed)
	// ============================================================

	private final By badgesBy = By.cssSelector("section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span");

	private final By quickLinksBy = By.cssSelector(
			"section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a");

	private final By featureCardsBy = By.cssSelector(
			"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group");

	// nth-of-type helpers (1-based)
	private By badgeNth(int n) {
		return By.cssSelector(
				"section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span:nth-of-type(" + n + ")");
	}

	private By quickLinkNth(int n) {
		return By.cssSelector(
				"section.relative.overflow-hidden div.rounded-3xl.bg-white\\/90.backdrop-blur-xl div.grid.grid-cols-2.gap-4 > a:nth-of-type("
						+ n + ")");
	}

	private By featureCardNth(int n) {
		return By.cssSelector(
				"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group:nth-of-type("
						+ n + ")");
	}

	private By featureCardLearnMoreNth(int n) {
		return By.cssSelector(
				"section.py-12.sm\\:py-16.lg\\:py-20.bg-white div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3 > div.group:nth-of-type("
						+ n + ") a.inline-flex");
	}

	// ============================================================
	// ✅ INITIALIZE ALL ELEMENTS
	// ============================================================

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ GETTERS (needed for responsive layout checks)
	// ============================================================

	public WebElement getBadgeContainer() {
		return badgeContainer;
	}

	public List<WebElement> getAllBadges() {
		return allBadges;
	}

	// ============================================================
	// ✅ PAGE BASIC VERIFICATION
	// ============================================================

	public boolean isHomePageRootDisplayed() {
		return isElementDisplayed(pageRoot, "HomePage Root");
	}

	public boolean verifyHomePageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyHomePageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ BADGES (4)
	// ============================================================

	public int getBadgesCount() {
		return driver.findElements(badgesBy).size();
	}

	public String getBadgeText(int badgeIndex1Based) {
		WebElement badge = waitUntilElementVisible(badgeNth(badgeIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Badge " + badgeIndex1Based);
		return badge == null ? "" : getTextFromElement(badge, "Badge " + badgeIndex1Based);
	}

	public void verifyTextOfFirstBadge() {
		getTextFromElement(allBadges.get(0), "Badge 1 (SOFTWARE)");
	}

	public void verifyTextOfSecondBadge() {
		getTextFromElement(allBadges.get(1), "Badge 2 (AI SYSTEMS)");
	}

	public void verifyTextOfThirdBadge() {
		getTextFromElement(allBadges.get(2), "Badge 3 (BLOCKCHAIN)");
	}

	public void verifyTextOfFourthBadge() {
		getTextFromElement(allBadges.get(3), "Badge 4 (CLOUD)");
	}

	// ============================================================
	// ✅ HERO TEXTS
	// ============================================================

	public String getHeroMainHeadingText() {
		return getTextFromElement(heroMainHeading, "Hero Main Heading");
	}

	public String getHeroSubHeadingText() {
		return getTextFromElement(heroGradientSubHeading, "Hero Sub Heading");
	}

	public String getHeroMainParagraphText() {
		return getTextFromElement(heroMainParagraph, "Hero Main Paragraph");
	}

	// ============================================================
	// ✅ HERO CTA BUTTONS
	// ============================================================

	public void clickOnExploreSolutionsButton() {
		clickOnElement(exploreSolutionsButton, "Explore Solutions Button");
	}

	public void clickOnViewProjectsButton() {
		clickOnElement(viewProjectsButton, "View Projects Button");
	}

	// ============================================================
	// ✅ RIGHT PREVIEW BOX
	// ============================================================

	public boolean isRightPreviewBoxDisplayed() {
		return isElementDisplayed(rightPreviewBox, "Right Preview Box");
	}

	public String getRightPreviewTopLineText() {
		return getTextFromElement(rightPreviewTopLine, "Right Preview Top Line");
	}

	public String getRightPreviewLeftText() {
		return getTextFromElement(rightPreviewTopLineLeftText, "Right Preview Left Text");
	}

	public String getRightPreviewGradientText() {
		return getTextFromElement(rightPreviewTopLineGradientText, "Right Preview Gradient Text");
	}

	// ============================================================
	// ✅ QUICK LINKS (4)
	// ============================================================

	public int getQuickLinksCount() {
		return driver.findElements(quickLinksBy).size();
	}

	public String getQuickLinkLabelText(int linkIndex1Based) {
		WebElement link = waitUntilElementVisible(quickLinkNth(linkIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Quick Link " + linkIndex1Based);
		if (link == null)
			return "";

		WebElement label = link.findElement(By.cssSelector("span.text-sm.font-medium.text-slate-800"));
		return getTextFromElement(label, "Quick Link Label " + linkIndex1Based);
	}

	public String getQuickLinkHref(int linkIndex1Based) {
		WebElement link = waitUntilElementVisible(quickLinkNth(linkIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Quick Link " + linkIndex1Based);
		return link == null ? "" : (link.getAttribute("href") == null ? "" : link.getAttribute("href"));
	}

	public void clickQuickLink(int linkIndex1Based) {
		clickOnElement(quickLinkNth(linkIndex1Based), "Quick Link " + linkIndex1Based);
	}

	public void clickElementOfHomepage(By locator, String name) {
		super.clickOnElement(locator, name);
	}

	// ============================================================
	// ✅ FEATURE SECTION (What We Build)
	// ============================================================

	public boolean isFeatureSectionDisplayed() {
		return isElementDisplayed(featureSection, "Feature Section");
	}

	public String getFeatureSectionHeadingText() {
		return getTextFromElement(featureSectionHeading, "Feature Section Heading");
	}

	// ============================================================
	// ✅ FEATURE CARDS (6)
	// ============================================================

	public int getFeatureCardsCount() {
		return driver.findElements(featureCardsBy).size();
	}

	public String getFeatureCardTitle(int cardIndex1Based) {
		WebElement card = waitUntilElementVisible(featureCardNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Feature Card " + cardIndex1Based);
		if (card == null)
			return "";

		WebElement title = card.findElement(By.cssSelector("h3.text-base.font-semibold.text-slate-900"));
		return getTextFromElement(title, "Feature Card Title " + cardIndex1Based);
	}

	public String getFeatureCardDescription(int cardIndex1Based) {
		WebElement card = waitUntilElementVisible(featureCardNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Feature Card " + cardIndex1Based);
		if (card == null)
			return "";

		WebElement desc = card.findElement(By.cssSelector("p.mt-4.text-sm.text-slate-600"));
		return getTextFromElement(desc, "Feature Card Description " + cardIndex1Based);
	}

	public String getFeatureCardLearnMoreHref(int cardIndex1Based) {
		WebElement link = waitUntilElementVisible(featureCardLearnMoreNth(cardIndex1Based), DEFAULT_WAITING_TIME_IN_SEC,
				"Feature Card Learn More " + cardIndex1Based);
		return link == null ? "" : (link.getAttribute("href") == null ? "" : link.getAttribute("href"));
	}

	public void clickFeatureCardLearnMore(int cardIndex1Based) {
		clickOnElement(featureCardLearnMoreNth(cardIndex1Based), "Feature Card Learn More " + cardIndex1Based);
	}
}