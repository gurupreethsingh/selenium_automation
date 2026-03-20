package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HomePage extends AllVerifications {

	// ============================================================
	// ✅ HOMEPAGE - HERO CAROUSEL
	// ============================================================

	@FindBy(css = "div#root")
	private WebElement pageRootContainer;

	private final By pageRootContainerBy = By.cssSelector("div#root");

	@FindBy(css = "div#carouselExampleDark")
	private WebElement heroCarousel;

	@FindBy(css = "div#carouselExampleDark .carousel-indicators button")
	private List<WebElement> heroCarouselIndicators;

	// ============================================================
	// ✅ HOMEPAGE ACTIONS
	// ============================================================

	public void clickHeroIndicator(int indexZeroBased) {
		if (indexZeroBased < 0 || heroCarouselIndicators == null || indexZeroBased >= heroCarouselIndicators.size()) {
			System.out.println("[HOMEPAGE] Invalid hero indicator index: " + indexZeroBased);
			return;
		}
		clickOnElement(heroCarouselIndicators.get(indexZeroBased), "Hero Indicator " + indexZeroBased);
	}

	// HOMEPAGE - CATEGORY CAROUSEL SECTION ELEMENTS
	@FindBy(css = "section.m-8")
	private WebElement categoryParentContainer;

	@FindBy(css = "section button[aria-label='Scroll categories left']")
	private WebElement categoryScrollLeftButton;

	@FindBy(css = "section button[aria-label='Scroll categories right']")
	private WebElement categoryScrollRightButton;

	@FindBy(css = "section div.flex.gap-3.overflow-x-auto > div[title]")
	private List<WebElement> categoryCardsByTitle;

	@FindBy(css = "section.m-8>div>div>h2")
	private WebElement categoryMainHeading;

	@FindBy(css = "section.m-8>div>div>p")
	private WebElement categorySubHeading;

	@FindBy(css = "section.m-8>div:first-child>div:last-child")
	private WebElement categoryCountText;

	@FindBy(css = "div.flex.gap-3.overflow-x-auto.scroll-smooth.px-1.py-2.hide-scrollbar>div.duration-300:first-child")
	private WebElement singleCategoryName; // electronics

	// locator for ALL individual category items
	private By totalCategoryItems = By.cssSelector("section.m-8 > div.relative > div.flex.gap-3 > div");

	@FindBy(css = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:last-child")
	private List<WebElement> allCategoryShopButtons;

	@FindBy(css = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:first-child")
	private List<WebElement> allCategoryNames;

	String allCategoryNamesUsingJavascript = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:first-child";

	// brand section elements
	@FindBy(css = "section.m-10>div:first-child>div>h2")
	private WebElement brandSectionMainHeading;

	@FindBy(css = "section.m-10>div:first-child>div>p")
	private WebElement brandSectionSubHeading;

	@FindBy(css = "section.m-10>div:first-child>div.hidden")
	private WebElement brandSectionCountText;

	@FindBy(css = "div.brandTrack>div.flex:first-child>button>div>div.flex.items-center.gap-2>span.uppercase")
	private List<WebElement> allBrandNames;

	@FindBy(css = "section button[aria-label='Next brands (left)']")
	private WebElement brandsScrollLeftButton;

	@FindBy(css = "section button[aria-label='Next brands (right)']")
	private WebElement brandsScrollRightButton;

	@FindBy(css = "div.brandTrack")
	private WebElement brandTrack;

	// HOMEPAGE - CATEGORY SECTION ACTION METHODS
	public boolean verifyCategoryParentContainerIsDisplayed() {
		return verifyElementPresentAndVisible(categoryParentContainer, "Category Parent Container");
	}

	public boolean verifyCategoryMainHeadingText(String expectedText) {
		return verifyText(categoryMainHeading, expectedText, "Category Main Heading", "equals", true);
	}

	public boolean verifyCategorySubHeadingText(String expectedText) {
		return verifyText(categorySubHeading, expectedText, "Category Sub Heading", "equals", true);
	}

	public boolean verifyCategoryCountText(String expectedText) {
		return verifyText(categoryCountText, expectedText, "Category Count Text", "contains", true);
	}

	public boolean verifyTotalCategoryCount(int expectedCategoryCount) {
		return verifyTotalElementsCount(expectedCategoryCount, totalCategoryItems);
	}

	public List<WebElement> printAllCategoryNames() {
		return printTextOfAllElements(allCategoryNames, "All Category Names");

	}

	public List<String> printAllCategoryNamesUsingJavascript() {
		return printTextOfAllElementsUsingJavascript(allCategoryNamesUsingJavascript, "All Category Names");
	}

	public boolean clickOnCategory() {
		return clickOnElement(singleCategoryName, "Electronic Category");
	}

	public void scrollCategoriesLeft() {
		clickOnElement(categoryScrollLeftButton, "Category Scroll Left");
	}

	public void scrollCategoriesRight() {
		clickOnElement(categoryScrollRightButton, "Category Scroll Right");
	}

	public int getCategoryCardCount() {
		return categoryCardsByTitle == null ? 0 : categoryCardsByTitle.size();
	}

	public boolean clickCategoryByName(String categoryName) {
		try {
			if (categoryName == null || categoryName.trim().isEmpty()) {
				throw new IllegalArgumentException("Category name is null or empty");
			}

			String expectedCategory = categoryName.trim();

			for (WebElement category : categoryCardsByTitle) {
				String actualTitle = category.getAttribute("title");

				if (actualTitle != null && actualTitle.trim().equalsIgnoreCase(expectedCategory)) {
					return clickOnElement(category, "Category Card: " + expectedCategory);
				}
			}

			System.out.println("[CATEGORY CLICK FAILED] Category not found: " + expectedCategory);
			captureFailure("CATEGORY CLICK FAILED -> Category not found: " + expectedCategory);
			return false;

		} catch (Exception ex) {
			System.out.println("[CATEGORY CLICK FAILED] " + categoryName);
			captureFailure("CATEGORY CLICK FAILED -> " + categoryName, ex);
			return false;
		}
	}

	public boolean clickAllCategoriesByName(String categoryName) {
		try {
			if (categoryName == null || categoryName.trim().isEmpty()) {
				throw new IllegalArgumentException("Category name is null or empty");
			}

			String targetCategory = categoryName.trim();

			// Try multiple times because categories are in a horizontal slider
			for (int attempt = 1; attempt <= 10; attempt++) {

				System.out.println("[CATEGORY SEARCH ATTEMPT " + attempt + "] " + targetCategory);

				// Refresh page object references each attempt
				PageFactory.initElements(driver, this);

				// Try to find currently visible category card by title
				for (WebElement category : categoryCardsByTitle) {
					try {
						String title = category.getAttribute("title");

						if (title != null && title.trim().equalsIgnoreCase(targetCategory)) {
							return clickOnElement(category, "Category: " + targetCategory);
						}
					} catch (Exception innerEx) {
						System.out.println("[CATEGORY ITEM CHECK FAILED] " + targetCategory);
					}
				}

				// If not found yet, move slider right and try again
				clickOnElement(categoryScrollRightButton, "Category Scroll Right");
			}

			System.out.println("[CATEGORY CLICK FAILED] Category not found after slider attempts: " + targetCategory);
			captureFailure("CATEGORY CLICK FAILED -> " + targetCategory);
			return false;

		} catch (Exception ex) {
			System.out.println("[CATEGORY CLICK FAILED] " + categoryName);
			captureFailure("CATEGORY CLICK FAILED -> " + categoryName, ex);
			return false;
		}
	}

	// HOMEPAGE - BRANDS SECTION ACTION METHODS

	public boolean verifyBrandSectionMainHeading() {
		return verifyText(brandSectionMainHeading, "Popular Brands", "Brand Section Main Heading", "equals", true);
	}

	public boolean verifyBrandSectionSubHeading() {
		return verifyText(brandSectionSubHeading, "Smooth infinite marquee • drag / swipe anytime • tap to search",
				"Brand Section Sub Heading", "equals", true);
	}

	public boolean verifyBrandSectionCountText() {
		return verifyText(brandSectionCountText, "117 brands", "Brand Section Count Text", "contains", true);
	}

	public void printAllBrandNames() {
		printTextOfAllElements(allBrandNames, "All Brand Names");
	}

	private String allBrandNamesUsingJavascript = "section.m-10 > div.rounded-2xl > div.relative > div.brandViewport > div.brandTrack > div button span:first-child";

	public List<String> printAllBrandNamesUsingJavascript() {
		return printTextOfAllElementsUsingJavascript(allBrandNamesUsingJavascript, "All Brand Names");
	}

	public int getTotalBrandCount() {
		List<String> brandNames = printAllBrandNamesUsingJavascript();
		int actualBrandCount = brandNames.size();
		verifyTotalElementsCount(117, brandNames);
		return actualBrandCount;
	}

	// CLICK BRAND BY NAME USING JAVASCRIPT
	public void clickBrandByNameUsingJavascript(String brandName) {
		try {
			if (brandName == null || brandName.trim().isEmpty()) {
				throw new IllegalArgumentException("Brand name is null or empty");
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("var brandName = arguments[0].trim().toUpperCase();"
					+ "var elements = document.querySelectorAll(arguments[1]);"
					+ "for (var i = 0; i < elements.length; i++) {"
					+ "    var text = elements[i].textContent.trim().toUpperCase();" + "    if (text === brandName) {"
					+ "        elements[i].click();" + "        return;" + "    }" + "}", brandName,
					allBrandNamesUsingJavascript);

		} catch (Exception ex) {
			captureFailure("CLICK BRAND BY NAME USING JAVASCRIPT FAILED - " + brandName, ex);
		}
	}

	private String allBrandNamesTextUsingJavascript = "section.m-10 > div.rounded-2xl > div.relative > div.brandViewport > div.brandTrack > div button span:first-child";

	// clicking on all the brand names one by one.
	public boolean moveSliderAndClickBrandByNameUsingJavascript(String brandName) {
		try {
			if (brandName == null || brandName.trim().isEmpty()) {
				throw new IllegalArgumentException("Brand name is null or empty");
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String targetBrand = brandName.trim().replaceAll("\\s+", "").toUpperCase();

			for (int attempt = 1; attempt <= 40; attempt++) {

				System.out.println(
						"[SLIDER SEARCH ATTEMPT " + attempt + "] Clicking on the following element: " + brandName);

				Boolean clicked = (Boolean) js.executeScript("var targetBrand = arguments[0];"
						+ "var selector = arguments[1];" + "var elements = document.querySelectorAll(selector);" + ""
						+ "for (var i = 0; i < elements.length; i++) {" + "    var el = elements[i];"
						+ "    var text = (el.textContent || '').replace(/\\s+/g, '').trim().toUpperCase();"
						+ "    if (text === targetBrand) {"
						+ "        el.scrollIntoView({block:'center', inline:'center'});" + "        el.click();"
						+ "        return true;" + "    }" + "}" + ""
						+ "var viewport = document.querySelector('section.m-10 div.brandViewport');" + "if (viewport) {"
						+ "    viewport.scrollLeft = viewport.scrollLeft + 250;" + "}" + "return false;", targetBrand,
						allBrandNamesTextUsingJavascript);

				if (clicked != null && clicked) {
					return true;
				}

				Thread.sleep(500);
			}

			captureFailure("BRAND NOT FOUND / CLICKED IN MOVING SLIDER - " + brandName);
			return false;

		} catch (Exception ex) {
			captureFailure("MOVE SLIDER AND CLICK BRAND FAILED - " + brandName, ex);
			return false;
		}
	}

	// ============================================================
	// ✅ INIT
	// ============================================================

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyHomepageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyHomepageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}