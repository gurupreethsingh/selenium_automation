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
	private WebElement headerSearchInputFieldDesktop;

	@FindBy(css = "header nav form[role='search'] button[type='submit']")
	private WebElement headerSearchButtonDesktop;

	@FindBy(css = "header div.lg\\:hidden form[role='search'] input[type='text']")
	private WebElement headerSearchInputMobileRow;

	@FindBy(css = "header div.lg\\:hidden form[role='search'] button[type='submit']")
	private WebElement headerSearchButtonMobileRow;

	// ============================================================
	// ✅ HEADER - RIGHT (Desktop Wishlist + MiniCart + Login/User)
	// ============================================================

	@FindBy(css = "div.hidden.items-center.gap-4>a[aria-label='Wishlist']>div")
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
	// ✅ HEADER ACTIONS
	// ============================================================

	public boolean clickHeaderLogoHome() {
		return clickOnElement(headerHomeLogoLink, "Header Home Logo");
	}

	public String clickHeaderLogoAppNameAndPrintText() {
		clickOnElement(headerHomeLogoAppNameText, "Header App Name Text");
		return getTextFromElement(headerHomeLogoAppNameText, "Header App Name Text");
	}

	public boolean clickHeaderShopAllDesktop() {
		return clickOnElement(headerShopAllLinkDesktop, "Header SHOP ALL (Desktop)");
	}

	// ---------- Search (Desktop / Mobile Row) ----------

	public WebElement getSearchInputField() {
		return headerSearchInputFieldDesktop;
	}

	public void enterValueIntoSearchInputField(String valueToEnter) {
		typeInInputField(headerSearchInputFieldDesktop, valueToEnter, "Header Search (Desktop)");
	}

	public void enterValueIntoSearchField(int valueToEnter) {
		enterValueIntoSearchInputField(String.valueOf(valueToEnter));
	}

	public void enterValueIntoSearchField(long valueToEnter) {
		enterValueIntoSearchInputField(String.valueOf(valueToEnter));
	}

	public void enterValueIntoSearchField(double valueToEnter) {
		enterValueIntoSearchInputField(String.valueOf(valueToEnter));
	}

	public boolean clickSearchButtonDesktop() {
		return clickOnElement(headerSearchButtonDesktop, "Header Search Button (Desktop)");
	}

	public void searchDesktop(String query) {
		enterValueIntoSearchInputField(query);
		clickSearchButtonDesktop();
	}

	public void enterValueInotSearchInputFieldDesktopAndPressEnter(String query) {
		typeInInputField(headerSearchInputFieldDesktop, query, "Header Search (Desktop)");
		pressKeyInElement(headerSearchInputFieldDesktop, Keys.ENTER, "Header Search Desktop ENTER");
	}

	public void enterValueInotSearchInputFieldMobileRow(String query) {
		typeInInputField(headerSearchInputMobileRow, query, "Header Search (Mobile Row)");
		clickOnElement(headerSearchButtonMobileRow, "Header Search Button (Mobile Row)");
	}

	// ---------- Wishlist / Cart (Mobile / Desktop) ----------

	public boolean clickWishlistIconDesktop() {
		return clickOnElement(headerWishlistLinkDesktop, "Wishlist (Desktop)");
	}

	public void clickWishlistIconMobile() {
		clickOnElement(headerWishlistLinkMobile, "Wishlist (Mobile)");
	}

	public boolean hoverOnWishlistIconDesktop() {
		return performActionsUsingActionsClass("Hover On Wishlist Icon Desktop", "HOVER", headerWishlistLinkDesktop);
	}

	public WebElement fetchWishlistIcon() {
		return headerWishlistLinkDesktop;
	}

	public void clickCartIconMobile() {
		clickOnElement(headerCartLinkMobile, "Cart (Mobile)");
	}

	public boolean clickSignInAvatarDesktop() {
		return clickOnElement(headerSignInLinkAvatarDesktop, "Sign In Avatar (Desktop)");
	}

	public boolean clickSignInTextDesktop() {
		return clickOnElement(headerSignInLinkDesktop, "Sign In (Desktop)");
	}

	// ---------- User dropdown ----------

	public void openUserDropdown() {
		clickOnElement(headerUserDropdownButton, "User Dropdown");
	}

	public void clickUserDropdownOption(String optionText) {
		openUserDropdown();

		WebElement btn = fetchMatchingElementByExactText(headerUserDropdownButtons, optionText,
				"Header User Dropdown Buttons");

		if (btn == null) {
			System.out.println("[HEADER] Dropdown option not found: " + optionText);
			captureFailure("HEADER DROPDOWN OPTION NOT FOUND -> " + optionText);
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

		WebElement cartBtn = fetchMatchingElementByExactText(buttons, "Cart", "Mobile Menu Buttons");

		if (cartBtn != null) {
			clickOnElement(cartBtn, "Mobile Menu Cart");
		} else {
			System.out.println("[HEADER] Mobile Menu Cart button not found.");
			captureFailure("MOBILE MENU CART BUTTON NOT FOUND");
		}
	}

	public void clickMobileMenuWishlistButton() {
		openMobileMenu();

		List<WebElement> buttons = driver
				.findElements(By.cssSelector("header div[role='dialog'][aria-modal='true'] button"));

		WebElement wlBtn = fetchMatchingElementByExactText(buttons, "Wishlist", "Mobile Menu Buttons");

		if (wlBtn != null) {
			clickOnElement(wlBtn, "Mobile Menu Wishlist");
		} else {
			System.out.println("[HEADER] Mobile Menu Wishlist button not found.");
			captureFailure("MOBILE MENU WISHLIST BUTTON NOT FOUND");
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

		for (int i = 0; i < titles.size(); i++) {
			String txt = getTextFromElement(titles.get(i), "MiniCart Item Title " + (i + 1));
			if (!txt.isEmpty()) {
				names.add(txt);
			}
		}

		return names;
	}

	public void removeMiniCartItemByIndex(int indexZeroBased) {
		openMiniCart();
		waitUntilElementPresent(miniCartItemsContainerBy, 10, "MiniCart Items Container");

		List<WebElement> removeButtons = driver.findElements(miniCartRemoveButtonsBy);

		if (removeButtons.isEmpty()) {
			System.out.println("[HEADER] No remove buttons found (cart empty?).");
			return;
		}

		if (indexZeroBased < 0 || indexZeroBased >= removeButtons.size()) {
			System.out.println("[HEADER] Invalid remove index: " + indexZeroBased);
			captureFailure("MINICART REMOVE INDEX INVALID -> " + indexZeroBased);
			return;
		}

		clickOnElement(removeButtons.get(indexZeroBased), "MiniCart Remove Item #" + indexZeroBased);
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

		List<WebElement> totalValues = driver.findElements(miniCartTotalValueBy);

		if (totalValues == null || totalValues.isEmpty()) {
			System.out.println("[HEADER] MiniCart total value element not found.");
			captureFailure("MINICART TOTAL VALUE NOT FOUND");
			return "";
		}

		return getTextFromElement(totalValues.get(totalValues.size() - 1), "MiniCart Total Value");
	}
}