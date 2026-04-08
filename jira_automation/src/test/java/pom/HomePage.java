package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HomePage extends AllVerifications {

	// ✅ ROOT / PAGE WRAPPER

	@FindBy(css = "div.bg-white.text-slate-900")
	private WebElement pageRoot;

	// ✅ HERO SECTION (top)

	@FindBy(css = "section.relative.overflow-hidden")
	private WebElement heroSection;

	// ✅ HERO BADGES

	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4")
	private WebElement badgeContainer;

	@FindBy(css = "section.relative.overflow-hidden div.flex.flex-wrap.gap-2.mb-4 > span")
	private List<WebElement> allBadges;

	// ✅ HERO LEFT TEXT BLOCK

	@FindBy(css = "div.w-full>h1.text-2xl")
	private WebElement heroMainHeading;

	@FindBy(css = "div.w-full>h1.text-2xl > span")
	private WebElement heroGradientSubHeading;

	@FindBy(css = "div.w-full>p")
	private WebElement heroMainParagraph;

	// ✅ HERO CTA BUTTONS

	@FindBy(css = "div.grid.grid-cols-1.gap-6.items-stretch div.mt-6")
	private WebElement heroSectionButtonContainer;

	@FindBy(css = "div.grid.grid-cols-1.gap-6.items-stretch div.mt-6>button:nth-of-type(1)")
	private WebElement exploreSolutionsButton;

	@FindBy(css = "div.grid.grid-cols-1.gap-6.items-stretch div.mt-6>button:nth-of-type(2)")
	private WebElement viewProjectsButton;

	// ✅ HERO RIGHT PREVIEW BOX

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex")
	private WebElement rightPreviewContainer;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.text-sm>span:nth-of-type(1)")
	private WebElement rightPreviewTopLineLeftText;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.text-sm>span:nth-of-type(2)")
	private WebElement rightPreviewTopLineGradientText;

	// ✅ HERO RHS LINKS GRID

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1")
	private WebElement herosectionRHSLinksGridContainer;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1 > a")
	private List<WebElement> allHerosectionRHSQuickLinks;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1>a:nth-of-type(1)")
	private WebElement herosectionAiDrvenSystemsLink;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1>a:nth-of-type(2)")
	private WebElement herosectionBlockchainLink;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1>a:nth-of-type(3)")
	private WebElement herosectionWEbMobielAppLink;

	@FindBy(css = "div.bg-white.text-slate-900 div.relative.flex div.grid.grid-cols-1>a:nth-of-type(4)")
	private WebElement herosectionQaAutomationLink;

	// ✅ INITIALIZE ALL ELEMENTS

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// page title and url verifications
	public boolean verifyHomePageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyHomePageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// hero section VERIFICATION

	public boolean isHomePageRootDisplayed() {
		return isElementDisplayed(pageRoot, "HomePage Root");
	}

	public boolean isHeroSectionDisplayed() {
		return isElementDisplayed(heroSection, "HomePage Hero Section");
	}

	// HERO SECTION BADGES

	public boolean verifyBadgeContainerIsDisplayed() {
		return isElementDisplayed(badgeContainer, "Hero Badge Container");
	}

	public boolean verifyTotalBadgesCountInHeroSection(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, allBadges);
	}

	public List<WebElement> printAllBadges() {
		return printTextOfAllElements(allBadges, "All Hero Badges");
	}

	// ✅ HERO MAIN TEXTS

	public boolean verifyHeroMainHeadingText(String expectedText) {
		return verifyText(heroMainHeading, expectedText, "Hero Main Heading", "contains", true);
	}

	public boolean verifyHeroSubHeadingText(String expectedText) {
		return verifyText(heroGradientSubHeading, expectedText, "Hero Gradient Sub Heading", "contains", true);
	}

	public boolean verifyHeroMainParagraphText(String expectedText) {
		return verifyText(heroMainParagraph, expectedText, "Hero Main Paragraph", "contains", true);
	}

	// ✅ HERO CTA BUTTON CONTAINER

	public boolean verifyHeroSectionButtonContainerIsDisplayed() {
		return isElementDisplayed(heroSectionButtonContainer, "Hero Section Button Container");
	}

	// ✅ EXPLORE SOLUTIONS BUTTON

	public boolean clickOnExploreSolutionsButton() {
		return clickOnElement(exploreSolutionsButton, "Explore Solutions Button");
	}

	// ✅ VIEW PROJECTS BUTTON

	public boolean clickOnViewProjectsButton() {
		return clickOnElement(viewProjectsButton, "View Projects Button");
	}

	// ✅ RIGHT PREVIEW CONTAINER

	public boolean verifyRightPreviewContainerIsDisplayed() {
		return isElementDisplayed(rightPreviewContainer, "Right Preview Container");
	}

	public boolean verifyRightPreviewTopLineLeftText(String expectedText) {
		return verifyText(rightPreviewTopLineLeftText, expectedText, "Right Preview Top Line Left Text", "contains",
				true);
	}

	public boolean verifyRightPreviewTopLineGradientText(String expectedText) {
		return verifyText(rightPreviewTopLineGradientText, expectedText, "Right Preview Top Line Gradient Text",
				"contains", true);
	}

	public List<WebElement> printAllHerosectionRHSQuickLinks() {
		return printTextOfAllElements(allHerosectionRHSQuickLinks, "All Hero Section RHS Quick Links");
	}

	public boolean clickOnAiDrivenSystemsLink() {
		return clickOnElement(herosectionAiDrvenSystemsLink, "Hero Section AI Driven Systems Link");
	}

	public boolean clickOnBlockchainLink() {
		return clickOnElement(herosectionBlockchainLink, "Hero Section Blockchain Link");
	}

	public boolean clickOnWebMobileAppsLink() {
		return clickOnElement(herosectionWEbMobielAppLink, "Hero Section Web Mobile Apps Link");
	}

	public boolean clickOnQaAutomationLink() {
		return clickOnElement(herosectionQaAutomationLink, "Hero Section QA Automation Link");
	}
}