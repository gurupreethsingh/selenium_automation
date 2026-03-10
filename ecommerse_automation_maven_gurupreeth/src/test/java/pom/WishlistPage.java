package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class WishlistPage extends AllVerifications {

	// ============================================================
	// ✅ PAGE ROOT / WRAPPER
	// ============================================================

	@FindBy(css = "div.wl-scope")
	private WebElement wishlistPageRoot;

	@FindBy(css = "div.wl-scope div.w-full")
	private WebElement wishlistOuterWrapper;

	@FindBy(css = "div.wl-scope div.w-full.max-w-\\[1700px\\].mx-auto")
	private WebElement wishlistContentWrapper;

	// ============================================================
	// ✅ HEADER - LEFT
	// ============================================================

	@FindBy(css = "div.wl-scope button.inline-flex.items-center.gap-2.text-\\[12px\\].font-extrabold.text-slate-600.hover\\:text-slate-900.transition")
	private WebElement backButton;

	@FindBy(css = "div.wl-scope h1.text-\\[20px\\].sm\\:text-\\[24px\\].\\32 xl\\:text-\\[26px\\].font-extrabold.tracking-tight.text-slate-900")
	private WebElement wishlistHeadingText;

	@FindBy(css = "div.wl-scope span.hidden.sm\\:inline.text-\\[12px\\].font-semibold.text-slate-500")
	private WebElement wishlistHeaderItemCountText;

	@FindBy(css = "div.wl-scope div.mt-1.text-\\[11px\\].sm\\:text-\\[12px\\].text-slate-500.font-medium")
	private WebElement wishlistShowingSummaryText;

	@FindBy(css = "div.wl-scope p.mt-1.text-\\[12px\\].font-semibold.text-slate-500")
	private WebElement wishlistSubDescriptionText;

	// ============================================================
	// ✅ HEADER - RIGHT (Desktop / View Toggle)
	// ============================================================

	@FindBy(css = "div.wl-scope button.hidden.sm\\:inline-flex.btnGhost.w-full.sm\\:w-auto.justify-center")
	private WebElement continueShoppingButtonDesktop;

	@FindBy(css = "div.wl-scope span.hidden.sm\\:inline-flex.items-center.gap-2.text-\\[12px\\].font-semibold.text-slate-600")
	private WebElement viewLabelText;

	@FindBy(css = "div.wl-scope div.inline-flex.w-full.lg\\:w-auto.items-center.gap-1.rounded-2xl.bg-slate-50.px-1\\.5.py-1\\.5.border.border-slate-200")
	private WebElement viewToggleContainer;

	@FindBy(css = "div.wl-scope button[title='Grid']")
	private WebElement gridViewButton;

	@FindBy(css = "div.wl-scope button[title='Cards']")
	private WebElement cardViewButton;

	@FindBy(css = "div.wl-scope button[title='List']")
	private WebElement listViewButton;

	@FindBy(css = "div.wl-scope button[title='Grid'] svg")
	private WebElement gridViewButtonIcon;

	@FindBy(css = "div.wl-scope button[title='Cards'] svg")
	private WebElement cardViewButtonIcon;

	@FindBy(css = "div.wl-scope button[title='List'] svg")
	private WebElement listViewButtonIcon;

	// ============================================================
	// ✅ EMPTY STATE
	// ============================================================

	@FindBy(css = "div.wl-scope div.text-center.text-slate-500.mt-12.sm\\:mt-16")
	private WebElement emptyStateContainer;

	@FindBy(css = "div.wl-scope div.text-center.text-slate-500.mt-12.sm\\:mt-16 div.inline-flex.items-center.gap-2.text-\\[12px\\].font-semibold")
	private WebElement emptyStateText;

	@FindBy(css = "div.wl-scope div.text-center.text-slate-500.mt-12.sm\\:mt-16 button.btnOrange")
	private WebElement emptyStateBrowseProductsButton;

	@FindBy(css = "div.wl-scope div.text-center.text-slate-500.mt-12.sm\\:mt-16 button.btnGhost.sm\\:hidden")
	private WebElement emptyStateContinueShoppingMobileButton;

	// ============================================================
	// ✅ PRODUCTS AREA - GRID VIEW
	// ============================================================

	@FindBy(css = "div.wl-scope div.grid.grid-cols-2.sm\\:grid-cols-3.md\\:grid-cols-4.lg\\:grid-cols-5.xl\\:grid-cols-6")
	private WebElement gridViewContainer;

	@FindBy(css = "div.wl-scope div.grid.grid-cols-2.sm\\:grid-cols-3.md\\:grid-cols-4.lg\\:grid-cols-5.xl\\:grid-cols-6 > div.group.relative.rounded-2xl.bg-white")
	private List<WebElement> gridViewProductCards;

	// ============================================================
	// ✅ PRODUCTS AREA - CARD VIEW
	// ============================================================

	@FindBy(css = "div.wl-scope div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3.xl\\:grid-cols-4")
	private WebElement cardViewContainer;

	@FindBy(css = "div.wl-scope div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3.xl\\:grid-cols-4 > div.relative.group.rounded-2xl.bg-white.overflow-hidden")
	private List<WebElement> cardViewProductCards;

	// ============================================================
	// ✅ PRODUCTS AREA - LIST VIEW
	// ============================================================

	@FindBy(css = "div.wl-scope div.space-y-10.sm\\:space-y-12")
	private WebElement listViewContainer;

	@FindBy(css = "div.wl-scope div.space-y-10.sm\\:space-y-12 > div.flex.flex-col.md\\:flex-row.items-stretch.md\\:items-center.bg-white.rounded-2xl.transition.group.relative")
	private List<WebElement> listViewProductCards;

	// ============================================================
	// ✅ PAGINATION
	// ============================================================

	@FindBy(css = "div.wl-scope div.paginationWrap")
	private WebElement paginationWrapper;

	@FindBy(css = "div.wl-scope nav.inline-flex.items-center.gap-2.justify-center")
	private WebElement paginationNav;

	@FindBy(css = "div.wl-scope button[aria-label='Previous page']")
	private WebElement paginationPreviousButton;

	@FindBy(css = "div.wl-scope button[aria-label='Next page']")
	private WebElement paginationNextButton;

	@FindBy(css = "div.wl-scope nav.inline-flex.items-center.gap-2.justify-center button[aria-label^='Page ']")
	private List<WebElement> paginationPageNumberButtons;

	@FindBy(css = "div.wl-scope button[title='Go to first page']")
	private WebElement paginationFirstPageJumpButton;

	@FindBy(css = "div.wl-scope button[title='Go to last page']")
	private WebElement paginationLastPageJumpButton;

	// ============================================================
	// ✅ MOBILE CONTINUE SHOPPING (NON-EMPTY STATE)
	// ============================================================

	@FindBy(css = "div.wl-scope div.mt-10.sm\\:hidden.flex.justify-center button.btnGhost")
	private WebElement continueShoppingButtonMobileBottom;

	// ============================================================
	// ✅ INTERNAL BY LOCATORS - COMMON / DYNAMIC
	// ============================================================

	private final By activeViewButtonBy = By.cssSelector("button.bg-white.text-slate-900");
	private final By allButtonsInsideCardBy = By.cssSelector("button");
	private final By allImagesInsideCardBy = By.cssSelector("img");
	private final By allHeadingsInsideCardBy = By.cssSelector("h2, h3");
	private final By allParagraphsInsideCardBy = By.cssSelector("p");
	private final By allSpansInsideCardBy = By.cssSelector("span");

	private final By productOpenAreaGridBy = By.cssSelector("div.p-3.cursor-pointer[title='Open product']");
	private final By productOpenAreaCardBy = By.cssSelector(
			"div.w-full.h-52.sm\\:h-56.bg-slate-50.flex.items-center.justify-center.overflow-hidden.cursor-pointer[title='Open product'], div.cursor-pointer");
	private final By productOpenAreaListBy = By.cssSelector(
			"div.w-full.md\\:w-44.h-52.md\\:h-44.bg-slate-50.rounded-2xl.overflow-hidden.flex.justify-center.items-center.cursor-pointer[title='Open product'], div.flex.flex-col.justify-center.md\\:ml-6.mt-4.md\\:mt-0.w-full.cursor-pointer.px-3.md\\:px-0.pb-3.md\\:pb-0[title='Open product']");

	private final By productNameBy = By.cssSelector("h2, h3");
	private final By productDescriptionBy = By.cssSelector("p.text-slate-500");
	private final By productPriceSellingBy = By.cssSelector("span.priceSelling");
	private final By productPriceMrpBy = By.cssSelector("span.priceMrp");
	private final By productRatingBy = By.cssSelector(
			"span.inline-flex.items-center.gap-1.text-\\[12px\\].font-extrabold.text-slate-600, span.inline-flex.items-center.gap-1");
	private final By productSavedForLaterBadgeBy = By.cssSelector("div.bg-amber-50");
	private final By productMoveToCartButtonBy = By.cssSelector("button.btnOrange");
	private final By productBuyNowButtonBy = By.cssSelector("button.btnGhost");
	private final By productSaveButtonBy = By.cssSelector("button.btnGhost");
	private final By productRemoveButtonBy = By.cssSelector("button.bg-rose-50");
	private final By productImageBy = By.cssSelector("img");

	// ============================================================
	// ✅ INIT
	// ============================================================

	public WishlistPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ INTERNAL SIMPLE HELPERS (NO WAITS)
	// ============================================================

	private WebElement findButtonByExactText(List<WebElement> buttons, String exactText) {
		String exp = exactText == null ? "" : exactText.trim();
		for (WebElement b : buttons) {
			String t = (b.getText() == null) ? "" : b.getText().trim();
			if (t.equals(exp))
				return b;
		}
		return null;
	}

	private WebElement getVisibleProductCardByIndex(int indexZeroBased) {
		List<WebElement> cards = getVisibleProductCards();

		if (cards == null || cards.isEmpty()) {
			System.out.println("[WISHLIST] No visible product cards found.");
			return null;
		}

		if (indexZeroBased < 0 || indexZeroBased >= cards.size()) {
			System.out.println("[WISHLIST] Invalid product index: " + indexZeroBased);
			return null;
		}

		return cards.get(indexZeroBased);
	}

	private List<WebElement> getVisibleProductCards() {
		List<WebElement> visibleCards = new ArrayList<>();

		if (isElementPresentInDOM(By.cssSelector(
				"div.wl-scope div.grid.grid-cols-2.sm\\:grid-cols-3.md\\:grid-cols-4.lg\\:grid-cols-5.xl\\:grid-cols-6 > div.group.relative.rounded-2xl.bg-white"))) {
			List<WebElement> cards = driver.findElements(By.cssSelector(
					"div.wl-scope div.grid.grid-cols-2.sm\\:grid-cols-3.md\\:grid-cols-4.lg\\:grid-cols-5.xl\\:grid-cols-6 > div.group.relative.rounded-2xl.bg-white"));
			for (WebElement el : cards) {
				if (el.isDisplayed())
					visibleCards.add(el);
			}
			if (!visibleCards.isEmpty())
				return visibleCards;
		}

		if (isElementPresentInDOM(By.cssSelector(
				"div.wl-scope div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3.xl\\:grid-cols-4 > div.relative.group.rounded-2xl.bg-white.overflow-hidden"))) {
			List<WebElement> cards = driver.findElements(By.cssSelector(
					"div.wl-scope div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3.xl\\:grid-cols-4 > div.relative.group.rounded-2xl.bg-white.overflow-hidden"));
			for (WebElement el : cards) {
				if (el.isDisplayed())
					visibleCards.add(el);
			}
			if (!visibleCards.isEmpty())
				return visibleCards;
		}

		if (isElementPresentInDOM(By.cssSelector(
				"div.wl-scope div.space-y-10.sm\\:space-y-12 > div.flex.flex-col.md\\:flex-row.items-stretch.md\\:items-center.bg-white.rounded-2xl.transition.group.relative"))) {
			List<WebElement> cards = driver.findElements(By.cssSelector(
					"div.wl-scope div.space-y-10.sm\\:space-y-12 > div.flex.flex-col.md\\:flex-row.items-stretch.md\\:items-center.bg-white.rounded-2xl.transition.group.relative"));
			for (WebElement el : cards) {
				if (el.isDisplayed())
					visibleCards.add(el);
			}
		}

		return visibleCards;
	}

	private WebElement findChildButtonByExactText(WebElement parent, String exactText) {
		List<WebElement> buttons = parent.findElements(allButtonsInsideCardBy);
		return findButtonByExactText(buttons, exactText);
	}

	// ============================================================
	// ✅ PAGE / HEADER ACTIONS
	// ============================================================

	public boolean isWishlistPageRootDisplayed() {
		return isElementDisplayed(wishlistPageRoot, "Wishlist Page Root");
	}

	public boolean isWishlistContentWrapperDisplayed() {
		return isElementDisplayed(wishlistContentWrapper, "Wishlist Content Wrapper");
	}

	public void clickBackButton() {
		clickOnElement(backButton, "Back Button");
	}

	public String getWishlistHeadingText() {
		return getTextFromElement(wishlistHeadingText, "Wishlist Heading Text");
	}

	public String getWishlistHeaderItemCountText() {
		return getTextFromElement(wishlistHeaderItemCountText, "Wishlist Header Item Count Text");
	}

	public String getWishlistShowingSummaryText() {
		return getTextFromElement(wishlistShowingSummaryText, "Wishlist Showing Summary Text");
	}

	public String getWishlistSubDescriptionText() {
		return getTextFromElement(wishlistSubDescriptionText, "Wishlist Sub Description Text");
	}

	public void clickContinueShoppingDesktop() {
		clickOnElement(continueShoppingButtonDesktop, "Continue Shopping Button Desktop");
	}

	// ============================================================
	// ✅ VIEW TOGGLE ACTIONS
	// ============================================================

	public void clickGridViewButton() {
		clickOnElement(gridViewButton, "Grid View Button");
	}

	public void clickCardViewButton() {
		clickOnElement(cardViewButton, "Card View Button");
	}

	public void clickListViewButton() {
		clickOnElement(listViewButton, "List View Button");
	}

	public String getActiveViewButtonText() {
		List<WebElement> activeButtons = driver.findElements(activeViewButtonBy);
		if (activeButtons.isEmpty())
			return "";
		String t = activeButtons.get(0).getText();
		return t == null ? "" : t.trim();
	}

	// ============================================================
	// ✅ EMPTY STATE ACTIONS
	// ============================================================

	public boolean isEmptyStateVisible() {
		return isElementPresentInDOM(By.cssSelector("div.wl-scope div.text-center.text-slate-500.mt-12.sm\\:mt-16"));
	}

	public String getEmptyStateText() {
		if (!isEmptyStateVisible())
			return "";
		return getTextFromElement(emptyStateText, "Empty State Text");
	}

	public void clickEmptyStateBrowseProductsButton() {
		clickOnElement(emptyStateBrowseProductsButton, "Empty State Browse Products Button");
	}

	public void clickEmptyStateContinueShoppingMobileButton() {
		clickOnElement(emptyStateContinueShoppingMobileButton, "Empty State Continue Shopping Mobile Button");
	}

	// ============================================================
	// ✅ PRODUCT COUNT / LISTS
	// ============================================================

	public int getVisibleWishlistProductCount() {
		return getVisibleProductCards().size();
	}

	public List<String> getVisibleWishlistProductNames() {
		List<String> names = new ArrayList<>();
		List<WebElement> cards = getVisibleProductCards();

		for (WebElement card : cards) {
			List<WebElement> namesEls = card.findElements(productNameBy);
			for (WebElement el : namesEls) {
				String txt = el.getText();
				if (txt != null && !txt.trim().isEmpty()) {
					names.add(txt.trim());
					break;
				}
			}
		}
		return names;
	}

	public List<String> getVisibleWishlistProductSellingPrices() {
		List<String> prices = new ArrayList<>();
		List<WebElement> cards = getVisibleProductCards();

		for (WebElement card : cards) {
			List<WebElement> els = card.findElements(productPriceSellingBy);
			if (els.isEmpty()) {
				prices.add("");
			} else {
				String txt = els.get(0).getText();
				prices.add(txt == null ? "" : txt.trim());
			}
		}
		return prices;
	}

	public List<String> getVisibleWishlistProductMrpPrices() {
		List<String> prices = new ArrayList<>();
		List<WebElement> cards = getVisibleProductCards();

		for (WebElement card : cards) {
			List<WebElement> els = card.findElements(productPriceMrpBy);
			if (els.isEmpty()) {
				prices.add("");
			} else {
				String txt = els.get(0).getText();
				prices.add(txt == null ? "" : txt.trim());
			}
		}
		return prices;
	}

	// ============================================================
	// ✅ PRODUCT CARD ACTIONS - COMMON
	// ============================================================

	public void clickProductByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return;

		List<WebElement> openAreas = card.findElements(productOpenAreaGridBy);
		if (openAreas.isEmpty())
			openAreas = card.findElements(productOpenAreaCardBy);
		if (openAreas.isEmpty())
			openAreas = card.findElements(productOpenAreaListBy);

		if (openAreas.isEmpty()) {
			System.out.println("[WISHLIST] Product open area not found for index: " + indexZeroBased);
			return;
		}

		clickOnElement(openAreas.get(0), "Wishlist Product Open Area #" + indexZeroBased);
	}

	public String getProductNameByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return "";

		List<WebElement> names = card.findElements(productNameBy);
		if (names.isEmpty())
			return "";

		String txt = names.get(0).getText();
		return txt == null ? "" : txt.trim();
	}

	public String getProductDescriptionByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return "";

		List<WebElement> descs = card.findElements(productDescriptionBy);
		if (descs.isEmpty())
			return "";

		String txt = descs.get(0).getText();
		return txt == null ? "" : txt.trim();
	}

	public String getProductSellingPriceByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return "";

		List<WebElement> els = card.findElements(productPriceSellingBy);
		if (els.isEmpty())
			return "";

		String txt = els.get(0).getText();
		return txt == null ? "" : txt.trim();
	}

	public String getProductMrpPriceByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return "";

		List<WebElement> els = card.findElements(productPriceMrpBy);
		if (els.isEmpty())
			return "";

		String txt = els.get(0).getText();
		return txt == null ? "" : txt.trim();
	}

	public String getProductRatingTextByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return "";

		List<WebElement> els = card.findElements(productRatingBy);
		if (els.isEmpty())
			return "";

		String txt = els.get(0).getText();
		return txt == null ? "" : txt.trim();
	}

	public boolean isProductImageDisplayedByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return false;

		List<WebElement> imgs = card.findElements(productImageBy);
		if (imgs.isEmpty())
			return false;

		return imgs.get(0).isDisplayed();
	}

	public boolean isSavedForLaterBadgeVisibleByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return false;

		List<WebElement> els = card.findElements(productSavedForLaterBadgeBy);
		return !els.isEmpty() && els.get(0).isDisplayed();
	}

	public void clickMoveToCartByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return;

		WebElement btn = findChildButtonByExactText(card, "Move to Cart");
		if (btn == null) {
			System.out.println("[WISHLIST] Move to Cart button not found for index: " + indexZeroBased);
			return;
		}
		clickOnElement(btn, "Move To Cart Button #" + indexZeroBased);
	}

	public void clickBuyNowByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return;

		WebElement btn = findChildButtonByExactText(card, "Buy Now");
		if (btn == null) {
			System.out.println("[WISHLIST] Buy Now button not found for index: " + indexZeroBased);
			return;
		}
		clickOnElement(btn, "Buy Now Button #" + indexZeroBased);
	}

	public void clickSaveOrUnsaveByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return;

		WebElement btn = findChildButtonByExactText(card, "Save");
		if (btn == null)
			btn = findChildButtonByExactText(card, "Unsave");

		if (btn == null) {
			System.out.println("[WISHLIST] Save/Unsave button not found for index: " + indexZeroBased);
			return;
		}
		clickOnElement(btn, "Save/Unsave Button #" + indexZeroBased);
	}

	public void clickRemoveByIndex(int indexZeroBased) {
		WebElement card = getVisibleProductCardByIndex(indexZeroBased);
		if (card == null)
			return;

		WebElement btn = findChildButtonByExactText(card, "Remove");
		if (btn == null) {
			System.out.println("[WISHLIST] Remove button not found for index: " + indexZeroBased);
			return;
		}
		clickOnElement(btn, "Remove Button #" + indexZeroBased);
	}

	// ============================================================
	// ✅ GRID / CARD / LIST VIEW PRESENCE
	// ============================================================

	public boolean isGridViewContainerVisible() {
		return isElementPresentInDOM(By.cssSelector(
				"div.wl-scope div.grid.grid-cols-2.sm\\:grid-cols-3.md\\:grid-cols-4.lg\\:grid-cols-5.xl\\:grid-cols-6"));
	}

	public boolean isCardViewContainerVisible() {
		return isElementPresentInDOM(
				By.cssSelector("div.wl-scope div.grid.grid-cols-1.sm\\:grid-cols-2.lg\\:grid-cols-3.xl\\:grid-cols-4"));
	}

	public boolean isListViewContainerVisible() {
		return isElementPresentInDOM(By.cssSelector("div.wl-scope div.space-y-10.sm\\:space-y-12"));
	}

	public int getGridViewProductCount() {
		return gridViewProductCards == null ? 0 : gridViewProductCards.size();
	}

	public int getCardViewProductCount() {
		return cardViewProductCards == null ? 0 : cardViewProductCards.size();
	}

	public int getListViewProductCount() {
		return listViewProductCards == null ? 0 : listViewProductCards.size();
	}

	// ============================================================
	// ✅ PAGINATION ACTIONS
	// ============================================================

	public boolean isPaginationVisible() {
		return isElementPresentInDOM(By.cssSelector("div.wl-scope nav.inline-flex.items-center.gap-2.justify-center"));
	}

	public void clickPaginationPrevious() {
		clickOnElement(paginationPreviousButton, "Pagination Previous Button");
	}

	public void clickPaginationNext() {
		clickOnElement(paginationNextButton, "Pagination Next Button");
	}

	public int getPaginationPageButtonCount() {
		return paginationPageNumberButtons == null ? 0 : paginationPageNumberButtons.size();
	}

	public void clickPaginationPageNumber(int pageNumber) {
		List<WebElement> pages = driver.findElements(
				By.cssSelector("div.wl-scope nav.inline-flex.items-center.gap-2.justify-center button[aria-label='Page "
						+ pageNumber + "']"));

		if (pages.isEmpty()) {
			System.out.println("[WISHLIST] Pagination page button not found: " + pageNumber);
			return;
		}

		clickOnElement(pages.get(0), "Pagination Page " + pageNumber);
	}

	public void clickPaginationFirstPageJumpButton() {
		if (!isElementPresentInDOM(By.cssSelector("div.wl-scope button[title='Go to first page']"))) {
			System.out.println("[WISHLIST] First page jump button not visible.");
			return;
		}
		clickOnElement(paginationFirstPageJumpButton, "Pagination First Page Jump Button");
	}

	public void clickPaginationLastPageJumpButton() {
		if (!isElementPresentInDOM(By.cssSelector("div.wl-scope button[title='Go to last page']"))) {
			System.out.println("[WISHLIST] Last page jump button not visible.");
			return;
		}
		clickOnElement(paginationLastPageJumpButton, "Pagination Last Page Jump Button");
	}

	// ============================================================
	// ✅ MOBILE CONTINUE SHOPPING ACTION
	// ============================================================

	public void clickContinueShoppingMobileBottom() {
		clickOnElement(continueShoppingButtonMobileBottom, "Continue Shopping Mobile Bottom Button");
	}

	// ============================================================
	// ✅ EXTRA TEXT / ELEMENT GETTERS
	// ============================================================

	public boolean isBackButtonVisible() {
		return isElementDisplayed(backButton, "Back Button");
	}

	public boolean isWishlistHeadingVisible() {
		return isElementDisplayed(wishlistHeadingText, "Wishlist Heading");
	}

	public boolean isContinueShoppingDesktopVisible() {
		return isElementPresentInDOM(By
				.cssSelector("div.wl-scope button.hidden.sm\\:inline-flex.btnGhost.w-full.sm\\:w-auto.justify-center"));
	}

	public boolean isViewToggleContainerVisible() {
		return isElementDisplayed(viewToggleContainer, "View Toggle Container");
	}

	public boolean isGridViewButtonVisible() {
		return isElementDisplayed(gridViewButton, "Grid View Button");
	}

	public boolean isCardViewButtonVisible() {
		return isElementDisplayed(cardViewButton, "Card View Button");
	}

	public boolean isListViewButtonVisible() {
		return isElementDisplayed(listViewButton, "List View Button");
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyWishlistPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyWishlistPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}