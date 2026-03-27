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

	public boolean verifyHomePageRootContainerIsDisplayedAndEnabled() {
		return verifyElementPresentAndVisible(pageRootContainer, "HomePage Parent Container");
	}

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
	private WebElement electronicsCategoryName; // electronics

	@FindBy(css = "div.flex.gap-3.overflow-x-auto.scroll-smooth.px-1.py-2.hide-scrollbar>div.duration-300>div.relative>div.absolute.bottom-3>div>span:first-child")
	private WebElement singleCategoryName; // any category name

	@FindBy(css = "div.flex.gap-3.overflow-x-auto.scroll-smooth.px-1.py-2.hide-scrollbar>div.duration-300>div.relative>div.absolute.bottom-3>div>span:last-child")
	private WebElement singleCategorAnyShopButtonName; // any category shop button

	@FindBy(css = "div.flex.gap-3.overflow-x-auto.scroll-smooth.px-1.py-2.hide-scrollbar>div.duration-300>div.relative>div.absolute.bottom-3>div>span:last-child")
	private List<WebElement> allShopButtons; // any category shop button

	// locator for ALL individual category items
	private By totalCategoryItems = By.cssSelector("section.m-8 > div.relative > div.flex.gap-3 > div");

	@FindBy(css = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:last-child")
	private List<WebElement> allCategoryShopButtons;

	@FindBy(css = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:first-child")
	private List<WebElement> allCategoryNames;

	String allCategoryNamesUsingJavascript = "section.m-8 > div.relative > div.flex.gap-3 > div > div.relative > div.absolute > div.flex.items-center > span:first-child";

	@FindBy(css = "section.m-8 > div.relative > div.flex.gap-3 > div > div.p-3>p")
	private List<WebElement> allCategorySubHeadingNames;

	String allCategorySubHeadingNamesUsingJavascript = "section.m-8 > div.relative > div.flex.gap-3 > div > div.p-3>p";

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

	public List<WebElement> printAllCategorySubHeadingNames() {
		return printTextOfAllElements(allCategorySubHeadingNames, "All Category Sub heading");
	}

	public List<String> printAllCategorySubHeadingNamesUsingJavascript() {
		return printTextOfAllElementsUsingJavascript(allCategorySubHeadingNamesUsingJavascript, "All Category Names");
	}

	public boolean clickOnCategory() {
		return clickOnElement(singleCategoryName, "Electronic category");
	}

	public boolean clickOnAnyCategory() {
		return clickOnElement(singleCategoryName, "Category Name");
	}

	// singleCategorAnyShopButtonyName
	public boolean clickOnAnyShopButtonOfCategory() {
		return clickOnElement(singleCategorAnyShopButtonName, "Category Shop Button");
	}

	public boolean clickOnAllShopButtonOfCategories() {
		try {
			if (allShopButtons == null || allShopButtons.isEmpty()) {
				captureFailure("ALL SHOP BUTTONS LIST EMPTY");
				return false;
			}

			return clickOnElement(allShopButtons.get(0), "First Category Shop Button");

		} catch (Exception ex) {
			captureFailure("CLICK ON FIRST CATEGORY SHOP BUTTON FAILED", ex);
			return false;
		}
	}

	public boolean clickShopButtonByCategoryName(String categoryName) {
		try {
			if (categoryName == null || categoryName.trim().isEmpty()) {
				throw new IllegalArgumentException("Category name is null or empty");
			}

			String expectedCategory = categoryName.trim();

			if (categoryCardsByTitle == null || categoryCardsByTitle.isEmpty()) {
				captureFailure("CATEGORY CARD LIST EMPTY");
				return false;
			}

			for (int attempt = 1; attempt <= 10; attempt++) {

				System.out.println("[SHOP BUTTON SEARCH ATTEMPT " + attempt + "] Category: " + expectedCategory);

				PageFactory.initElements(driver, this);

				for (int i = 0; i < categoryCardsByTitle.size(); i++) {
					try {
						WebElement categoryCard = categoryCardsByTitle.get(i);
						String actualTitle = categoryCard.getAttribute("title");

						if (actualTitle != null && actualTitle.trim().equalsIgnoreCase(expectedCategory)) {

							if (allShopButtons == null || allShopButtons.size() <= i) {
								System.out.println(
										"[SHOP BUTTON NOT FOUND] Category matched but shop button missing for: "
												+ expectedCategory);
								captureFailure("SHOP BUTTON NOT FOUND FOR CATEGORY -> " + expectedCategory);
								return false;
							}

							System.out
									.println("[CLICKING SHOP BUTTON] Category: " + expectedCategory + " | Index: " + i);

							return clickOnElement(allShopButtons.get(i),
									"Shop Button Of Category: " + expectedCategory);
						}

					} catch (Exception innerEx) {
						System.out.println("[CATEGORY / SHOP BUTTON MATCH FAILED] " + expectedCategory);
					}
				}

				clickOnElement(categoryScrollRightButton, "Category Scroll Right");
			}

			System.out.println(
					"[SHOP BUTTON CLICK FAILED] Category not found after slider attempts: " + expectedCategory);
			captureFailure("SHOP BUTTON CLICK FAILED -> Category not found: " + expectedCategory);
			return false;

		} catch (Exception ex) {
			System.out.println("[SHOP BUTTON CLICK FAILED] " + categoryName + " | " + ex.getMessage());
			captureFailure("SHOP BUTTON CLICK FAILED -> " + categoryName, ex);
			return false;
		}
	}

	public String fetchSingleCategoryNameText() {
		try {
			String categoryText = singleCategoryName.getText() == null ? "" : singleCategoryName.getText().trim();

			System.out.println("[SINGLE CATEGORY TEXT] " + categoryText);

			if (categoryText.isEmpty()) {
				captureFailure("SINGLE CATEGORY TEXT EMPTY");
			}

			return categoryText;

		} catch (Exception ex) {
			captureFailure("FETCH SINGLE CATEGORY TEXT FAILED", ex);
			return "";
		}
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
			System.out.println("[CATEGORY CLICK FAILED] " + categoryName + " | " + ex.getMessage());
			captureFailure("CATEGORY CLICK FAILED -> " + categoryName, ex);
			return false;
		}
	}

	public boolean clickCategoryShopButtonByName(String categoryName, WebElement categoryAllShopButtons) {
		try {
			if (categoryName == null || categoryName.trim().isEmpty()) {
				throw new IllegalArgumentException("Category name is null or empty");
			}

			String expectedCategory = categoryName.trim();

			for (WebElement category : categoryCardsByTitle) {
				String actualTitle = category.getAttribute("title");

				if (actualTitle != null && actualTitle.trim().equalsIgnoreCase(expectedCategory)) {
					return clickOnElement(categoryAllShopButtons, "Category Card: " + expectedCategory);
				}
			}

			System.out.println("[CATEGORY CLICK FAILED] Category not found: " + expectedCategory);
			captureFailure("CATEGORY CLICK FAILED -> Category not found: " + expectedCategory);
			return false;

		} catch (Exception ex) {
			System.out.println("[CATEGORY CLICK FAILED] " + categoryName + " | " + ex.getMessage());
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

// initialize all the webelements using the pom class constructor. 
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// products section elements.
	@FindBy(css = "div.flex.flex-col.gap-3.mb-4>div:first-child>h2")
	public WebElement productsSectionMainHeading;

	@FindBy(css = "div.flex.flex-col.gap-3.mb-4>div:first-child>p")
	public WebElement productsSectionSubHeading;

	@FindBy(css = "div.flex.flex-col.gap-3.mb-4>div:last-child>span")
	public WebElement productsSectionCountText;

	@FindBy(css = "div.grid.grid-cols-2.gap-3")
	public WebElement productsCardMainParentContiner;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div:first-child")
	public WebElement productsSingleCard;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl.border.border-orange-100")
	public List<WebElement> productsAllCards;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl:first-child>div:last-child>h4")
	public WebElement SingleProductName;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl>div:last-child>h4")
	public List<WebElement> AllproductNames;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl:first-child>div:last-child>div.flex.items-center.justify-between.gap-2")
	public WebElement SingleProductPrice;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl>div:last-child>div.flex.items-center.justify-between.gap-2")
	public List<WebElement> allProductPrices;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl:first-child>div:last-child>div.flex.items-center.justify-between.gap-2>span")
	public WebElement singleProductViewLink;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl>div:last-child>div.flex.items-center.justify-between.gap-2>span")
	public List<WebElement> allProductsViewLinks;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl:first-child>div:last-child>div.mt-2")
	public WebElement singleSubParagraphText;

	@FindBy(css = "div.grid.grid-cols-2.gap-3>div.rounded-2xl>div:last-child>div.mt-2")
	public List<WebElement> allSubParagraphText;

	// ============================================================
	// PRODUCTS SECTION - PRESENCE / VISIBILITY
	// ============================================================

	public boolean verifyProductsCardMainParentContinerPresent() {
		return verifyElementPresentAndVisible(productsCardMainParentContiner, "Products Card Main Parent Container");
	}

	public boolean verifyFirstProductCardPresent() {
		return verifyElementPresentAndVisible(productsSingleCard, "First Product Card");
	}

	public boolean verifyAllProductCardsPresent() {
		return verifyElementPresentAndVisible(productsCardMainParentContiner, "Products Card Main Parent Container")
				&& verifyTotalElementsCount(productsAllCards.size(), productsAllCards);
	}

	// ============================================================
	// PRODUCTS SECTION - TEXT VERIFICATION
	// ============================================================

	public boolean verifyProductsSectionMainHeading(String expectedText) {
		return verifyText(productsSectionMainHeading, expectedText, "Products Section Main Heading", "equals", true);
	}

	public boolean verifyProductsSectionSubHeading(String expectedText) {
		return verifyText(productsSectionSubHeading, expectedText, "Products Section Sub Heading", "equals", true);
	}

	public boolean verifyProductsSectionCountText(String expectedText) {
		return verifyText(productsSectionCountText, expectedText, "Products Section Count Text", "equals", true);
	}

	public boolean verifyTotalProductsCount(int expectedCount) {
		return verifyTotalElementsCount(expectedCount, productsAllCards);
	}

	// ============================================================
	// PRODUCTS SECTION - PRINT ALL TEXT
	// ============================================================

	public List<WebElement> printAllProductNames() {
		return printTextOfAllElements(AllproductNames, "All Product Names");
	}

	public List<WebElement> printAllProductPrices() {
		return printTextOfAllElements(allProductPrices, "All Product Prices");
	}

	public List<WebElement> printAllProductViewLinks() {
		return printTextOfAllElements(allProductsViewLinks, "All Product View Links");
	}

	public List<WebElement> printAllSubParagraphTexts() {
		return printTextOfAllElements(allSubParagraphText, "All Sub Paragraph Texts");
	}

	public boolean verifyEachProductCardDetails() {
		try {
			printAllProductNames();
			printAllProductPrices();
			printAllProductViewLinks();
			printAllSubParagraphTexts();
			return true;
		} catch (Exception e) {
			System.out.println("[VERIFY PRODUCT CARD DETAILS FAILED]");
			return false;
		}
	}

	// ============================================================
	// PRODUCTS SECTION - GET TEXT
	// ============================================================

	public String getFirstProductName() {
		return getTextFromElement(SingleProductName, "Single Product Name");
	}

	public String getFirstProductPriceText() {
		return getTextFromElement(SingleProductPrice, "Single Product Price");
	}

	public String getFirstProductViewLinkText() {
		return getTextFromElement(singleProductViewLink, "First Product View Link");
	}

	public String getFirstProductSubParagraphText() {
		return getTextFromElement(singleSubParagraphText, "First Product Sub Paragraph Text");
	}

	// ============================================================
	// PRODUCTS SECTION - CLICK ACTIONS
	// ============================================================

	public boolean clickOnFirstProductCard() {
		return clickOnElement(productsSingleCard, "First Product Card");
	}

	public boolean clickOnProductCardByIndex(int index) {
		if (index < 0 || index >= productsAllCards.size()) {
			throw new IllegalArgumentException("Invalid index: " + index);
		}
		return clickOnElement(productsAllCards.get(index), "Product Card Index: " + index);
	}

	public boolean clickOnFirstProductName() {
		return clickOnElement(SingleProductName, "Single Product Name");
	}

	public boolean clickOnFirstProductPrice() {
		return clickOnElement(SingleProductPrice, "Single Product Price");
	}

	public boolean clickOnViewProductLink() {
		return clickOnElement(singleProductViewLink, "Single Product View Link");
	}

	public boolean clickOnSubParagraphText() {
		return clickOnElement(singleSubParagraphText, "Product Sub Paragraph Text");
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