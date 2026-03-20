package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Header extends AllVerifications {

	// ============================================================
	// ✅ HEADER - LEFT (Logo + Shop All)
	// ============================================================

	public Header(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "header nav a[aria-label='Go to home']")
	private WebElement headerHomeLogoLink;

	@FindBy(css = "header nav a[aria-label='Go to home'] span.text-\\[13px\\].font-extrabold")
	private WebElement headerHomeLogoAppNameText;

	@FindBy(css = "header nav a[href='/shop']")
	private WebElement headerShopAllLinkDesktop;

	// ============================================================
	// ✅ HEADER - SEARCH
	// ============================================================

	@FindBy(css = "header nav form[role='search'] input[type='text']")
	private WebElement headerSearchInputDesktop;

	@FindBy(css = "header nav form[role='search'] button[type='submit']")
	private WebElement headerSearchButtonDesktop;

	@FindBy(css = "header div.lg\\:hidden form[role='search'] input[type='text']")
	private WebElement headerSearchInputMobileRow;

	@FindBy(css = "header div.lg\\:hidden form[role='search'] button[type='submit']")
	private WebElement headerSearchButtonMobileRow;

	// ============================================================
	// ✅ HEADER - RIGHT (Desktop Wishlist + MiniCart + Login/User)
	// ============================================================

	@FindBy(css = "header a[href='/wishlist'][aria-label='Wishlist']")
	private WebElement headerWishlistLinkDesktop;

	@FindBy(css = "header a[href='/login']>div")
	private WebElement headerSignInLinkAvatarDesktop;

	@FindBy(css = "header a[href='/login'][aria-label='Sign in']")
	private WebElement headerSignInLinkDesktop;

	@FindBy(css = "header button[aria-haspopup='menu']")
	private WebElement headerUserDropdownButton;

	@FindBy(css = "header div.absolute.right-0 button")
	private List<WebElement> headerUserDropdownButtons;

	// ============================================================
	// ✅ HEADER - MOBILE RIGHT ICONS
	// ============================================================

	@FindBy(css = "header a[href='/wishlist'][aria-label='Wishlist']")
	private WebElement headerWishlistLinkMobile;

	@FindBy(css = "header a[href='/cart'][aria-label='Cart']")
	private WebElement headerCartLinkMobile;

	@FindBy(css = "header button[aria-label='Open menu']")
	private WebElement headerOpenMobileMenuButton;

	// ============================================================
	// ✅ MOBILE MENU (DialogPanel role=dialog)
	// ============================================================

	@FindBy(css = "header div[role='dialog'][aria-modal='true']")
	private WebElement mobileMenuDialogPanel;

	@FindBy(css = "header div[role='dialog'][aria-modal='true'] button[aria-label='Close menu']")
	private WebElement mobileMenuCloseButton;

	@FindBy(css = "header div[role='dialog'][aria-modal='true'] form input[type='text']")
	private WebElement mobileMenuSearchInput;

	@FindBy(css = "header div[role='dialog'][aria-modal='true'] form button[type='submit']")
	private WebElement mobileMenuSearchButton;

	@FindBy(css = "header div[role='dialog'][aria-modal='true'] a[href='/shop']")
	private WebElement mobileMenuShopAllLink;

	@FindBy(css = "header div[role='dialog'][aria-modal='true'] a[href='/login']")
	private WebElement mobileMenuLoginLink;

	// ============================================================
	// ✅ MINI CART (MiniCart.jsx) - scoped by .mc-scope
	// ============================================================

	@FindBy(css = ".mc-scope button[aria-label='Open cart']")
	private WebElement miniCartOpenButton;

	@FindBy(css = ".mc-scope button[aria-label='Open cart'] span")
	private WebElement miniCartCountBadge;

	private final By miniCartPopupBy = By.cssSelector(".mc-scope .mcCard");
	private final By miniCartCloseButtonBy = By.cssSelector(".mc-scope .mcCard button[aria-label='Close']");
	private final By miniCartBrowseProductsLinkBy = By.cssSelector(".mc-scope .mcCard a[href='/shop']");
	private final By miniCartItemsContainerBy = By.cssSelector(".mc-scope .mcCard .mcScroll");
	private final By miniCartItemRowsBy = By.cssSelector(".mc-scope .mcCard .mcScroll > div");
	private final By miniCartRemoveButtonsBy = By.cssSelector(".mc-scope .mcCard button[aria-label='Remove']");
	private final By miniCartTotalValueBy = By.cssSelector(".mc-scope .mcCard .mt-4 .text-slate-900");
	private final By miniCartViewCartLinkBy = By.cssSelector(".mc-scope .mcCard a[href='/cart']");
	private final By miniCartCheckoutButtonBy = By.cssSelector(".mc-scope .mcCard button.btnGhost");

	// ============================================================
	// ✅ INTERNAL SIMPLE HELPERS (NO WAITS)
	// ============================================================

	private WebElement findButtonByExactText(List<WebElement> buttons, String exactText) {
		String exp = exactText == null ? "" : exactText.trim();
		for (WebElement b : buttons) {
			String t = (b.getText() == null) ? "" : b.getText().trim();
			if (t.equals(exp)) {
				return b;
			}
		}
		return null;
	}

	// ============================================================
	// ✅ HEADER ACTIONS
	// ============================================================

	public void clickHeaderLogoHome() {
		clickOnElement(headerHomeLogoLink, "Header Home Logo");
	}

	public String clickHeaderLogoAppNameAndPrintText() {
		headerHomeLogoAppNameText.click();
		return getTextFromElement(headerHomeLogoAppNameText, "Header App Name Text");
	}

	public void clickHeaderShopAllDesktop() {
		clickOnElement(headerShopAllLinkDesktop, "Header SHOP ALL (Desktop)");
	}

	// ---------- Search (Desktop / Mobile Row) ----------

	public void enterValueIntoSearchField(String keys) {
		typeInInputField(headerSearchInputDesktop, keys, "Header Search (Desktop)");
	}

	public void enterValueIntoSearchField(int keys) {
		enterValueIntoSearchField(String.valueOf(keys));
	}

	public void enterValueIntoSearchField(long keys) {
		enterValueIntoSearchField(String.valueOf(keys));
	}

	public void enterValueIntoSearchField(double keys) {
		enterValueIntoSearchField(String.valueOf(keys));
	}

	public void clickSearchButtonDesktop() {
		clickOnElement(headerSearchButtonDesktop, "Header Search Button (Desktop)");
	}

	public void searchDesktop(String query) {
		enterValueIntoSearchField(query);
		clickSearchButtonDesktop();
	}

	public void searchDesktopAndPressEnter(String query) {
		typeInInputField(headerSearchInputDesktop, query, "Header Search (Desktop)");
		pressKeyInElement(headerSearchInputDesktop, Keys.ENTER, "Header Search Desktop ENTER");
	}

	public void searchMobileRow(String query) {
		typeInInputField(headerSearchInputMobileRow, query, "Header Search (Mobile Row)");
		clickOnElement(headerSearchButtonMobileRow, "Header Search Button (Mobile Row)");
	}

	// ---------- Wishlist / Cart (Mobile) ----------

	public void clickWishlistDesktop() {
		clickOnElement(headerWishlistLinkDesktop, "Wishlist (Desktop)");
	}

	public void clickWishlistMobile() {
		clickOnElement(headerWishlistLinkMobile, "Wishlist (Mobile)");
	}

	public void clickCartMobile() {
		clickOnElement(headerCartLinkMobile, "Cart (Mobile)");
	}

	public void clickSignInAvatarDesktop() {
		clickOnElement(headerSignInLinkAvatarDesktop, "Sign In (Desktop)");
	}

	public void clickSignInDesktop() {
		clickOnElement(headerSignInLinkDesktop, "Sign In (Desktop)");
	}

	// ---------- User dropdown ----------

	public void openUserDropdown() {
		clickOnElement(headerUserDropdownButton, "User Dropdown");
	}

	public void clickUserDropdownOption(String optionText) {
		openUserDropdown();
		WebElement btn = findButtonByExactText(headerUserDropdownButtons, optionText);
		if (btn == null) {
			System.out.println("[HEADER] Dropdown option not found: " + optionText);
			return;
		}
		clickOnElement(btn, "User Dropdown Option: " + optionText);
	}

	// ============================================================
	// ✅ MOBILE MENU ACTIONS
	// ============================================================

	public void openMobileMenu() {
		clickOnElement(headerOpenMobileMenuButton, "Open Mobile Menu");
		waitUntilElementVisible(mobileMenuDialogPanel, 10, "Mobile Menu Dialog Panel");
	}

	public void closeMobileMenu() {
		clickOnElement(mobileMenuCloseButton, "Close Mobile Menu");
	}

	public void searchInMobileMenu(String query) {
		openMobileMenu();
		typeInInputField(mobileMenuSearchInput, query, "Mobile Menu Search");
		clickOnElement(mobileMenuSearchButton, "Mobile Menu Search Button");
	}

	public void clickMobileMenuShopAll() {
		openMobileMenu();
		clickOnElement(mobileMenuShopAllLink, "Mobile Menu SHOP ALL");
	}

	public void clickMobileMenuLogin() {
		openMobileMenu();
		clickOnElement(mobileMenuLoginLink, "Mobile Menu Login");
	}

	public void clickMobileMenuCartButton() {
		openMobileMenu();
		List<WebElement> buttons = driver
				.findElements(By.cssSelector("header div[role='dialog'][aria-modal='true'] button"));
		WebElement cartBtn = findButtonByExactText(buttons, "Cart");
		if (cartBtn != null) {
			clickOnElement(cartBtn, "Mobile Menu Cart");
		} else {
			System.out.println("[HEADER] Mobile Menu Cart button not found.");
		}
	}

	public void clickMobileMenuWishlistButton() {
		openMobileMenu();
		List<WebElement> buttons = driver
				.findElements(By.cssSelector("header div[role='dialog'][aria-modal='true'] button"));
		WebElement wlBtn = findButtonByExactText(buttons, "Wishlist");
		if (wlBtn != null) {
			clickOnElement(wlBtn, "Mobile Menu Wishlist");
		} else {
			System.out.println("[HEADER] Mobile Menu Wishlist button not found.");
		}
	}

	// ============================================================
	// ✅ MINI CART ACTIONS (MiniCart.jsx)
	// ============================================================

	public void openMiniCart() {
		clickOnElement(miniCartOpenButton, "MiniCart Open Button");
		waitUntilElementPresent(miniCartPopupBy, 10, "MiniCart Popup");
	}

	public void closeMiniCart() {
		if (!isElementPresentInDOM(miniCartPopupBy)) {
			System.out.println("[HEADER] MiniCart popup is not open. Nothing to close.");
			return;
		}
		clickOnElement(miniCartCloseButtonBy, "MiniCart Close Button");
		waitUntilElementInvisible(miniCartPopupBy, 10, "MiniCart Popup");
	}

	public boolean isMiniCartOpen() {
		return isElementPresentInDOM(miniCartPopupBy);
	}

	public int getMiniCartBadgeCount() {
		return getIntegerFromElementText(miniCartCountBadge, "MiniCart Badge Count");
	}

	public void clickMiniCartBrowseProductsWhenEmpty() {
		openMiniCart();
		if (!isElementPresentInDOM(miniCartBrowseProductsLinkBy)) {
			System.out.println("[HEADER] Browse products link not visible (cart might not be empty).");
			return;
		}
		clickOnElement(miniCartBrowseProductsLinkBy, "MiniCart Browse Products Link");
	}

	public int getMiniCartItemRowCount() {
		openMiniCart();
		return driver.findElements(miniCartItemRowsBy).size();
	}

	public List<String> getMiniCartItemNames() {
		openMiniCart();
		List<String> names = new ArrayList<>();
		List<WebElement> titles = driver.findElements(By.cssSelector(".mc-scope .mcCard .mcScroll h3"));
		for (WebElement t : titles) {
			String txt = t.getText();
			if (txt != null && !txt.trim().isEmpty()) {
				names.add(txt.trim());
			}
		}
		return names;
	}

	public void removeMiniCartItemByIndex(int indexZeroBased) {
		openMiniCart();

		waitUntilElementPresent(miniCartItemsContainerBy, 10, "MiniCart Items Container");

		List<WebElement> removeBtns = driver.findElements(miniCartRemoveButtonsBy);
		if (removeBtns.isEmpty()) {
			System.out.println("[HEADER] No remove buttons found (cart empty?).");
			return;
		}

		if (indexZeroBased < 0 || indexZeroBased >= removeBtns.size()) {
			System.out.println("[HEADER] Invalid remove index: " + indexZeroBased);
			return;
		}

		clickOnElement(removeBtns.get(indexZeroBased), "MiniCart Remove Item #" + indexZeroBased);
	}

	public void clickMiniCartViewCart() {
		openMiniCart();
		clickOnElement(miniCartViewCartLinkBy, "MiniCart View Cart Link");
	}

	public void clickMiniCartCheckout() {
		openMiniCart();
		clickOnElement(miniCartCheckoutButtonBy, "MiniCart Checkout Button");
	}

	public String getMiniCartTotalText() {
		openMiniCart();
		List<WebElement> totals = driver.findElements(miniCartTotalValueBy);
		if (totals.isEmpty()) {
			return "";
		}
		String txt = totals.get(totals.size() - 1).getText();
		return txt == null ? "" : txt.trim();
	}
}