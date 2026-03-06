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

public class Homepage extends AllVerifications {

	// ============================================================
	// ✅ HEADER - LEFT (Logo + Shop All)
	// ============================================================

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

	// Popup container (only exists when open)
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
	// ✅ HOMEPAGE - HERO CAROUSEL
	// ============================================================

	@FindBy(css = "div#root")
	private WebElement pageRootContainer; // parent element which contains the entire page/homepage.

	@FindBy(css = "div#carouselExampleDark")
	private WebElement heroCarousel;

	@FindBy(css = "div#carouselExampleDark .carousel-indicators button")
	private List<WebElement> heroCarouselIndicators;

	// ============================================================
	// ✅ HOMEPAGE - CATEGORY CAROUSEL
	// ============================================================

	@FindBy(css = "section button[aria-label='Scroll categories left']")
	private WebElement categoryScrollLeftButton;

	@FindBy(css = "section button[aria-label='Scroll categories right']")
	private WebElement categoryScrollRightButton;

	@FindBy(css = "section div.flex.gap-3.overflow-x-auto > div[title]")
	private List<WebElement> categoryCardsByTitle;

	// ============================================================
	// ✅ HOMEPAGE - BRANDS MARQUEE
	// ============================================================

	@FindBy(css = "section button[aria-label='Next brands (left)']")
	private WebElement brandsScrollLeftButton;

	@FindBy(css = "section button[aria-label='Next brands (right)']")
	private WebElement brandsScrollRightButton;

	@FindBy(css = "section button[title]")
	private List<WebElement> brandButtonsWithTitle;

	// ============================================================
	// ✅ HOMEPAGE - BRAND PRODUCTS GRID
	// ============================================================

	@FindBy(css = "section button[type='button'].underline")
	private List<WebElement> brandGridShowMoreLessLinks;

	@FindBy(css = "section div.grid div.rounded-2xl.border[title]")
	private List<WebElement> brandProductCardsByTitle;

	// ============================================================
	// ✅ FOOTER + SubscriptionForm.jsx
	// ============================================================

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

	@FindBy(css = "footer form.flex.flex-col.space-y-3 input[type='email']")
	private WebElement footerSubscribeEmailInput;

	@FindBy(css = "footer form.flex.flex-col.space-y-3 button[type='submit']")
	private WebElement footerSubscribeButton;

	private final By footerSubscribeErrorBy = By.cssSelector("footer form.flex.flex-col.space-y-3 p.text-red-500");
	private final By footerSubscribeOkMsgBy = By.cssSelector("footer form.flex.flex-col.space-y-3 p.text-green-600");

	// ============================================================
	// ✅ INIT
	// ============================================================

	public Homepage(WebDriver driver) {
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

	private WebElement findElementByTitle(List<WebElement> elements, String title) {
		String exp = title == null ? "" : title.trim();
		if (exp.isEmpty())
			return null;

		for (WebElement el : elements) {
			String t = el.getAttribute("title");
			if (t != null && t.trim().equalsIgnoreCase(exp))
				return el;
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
			System.out.println("[HOMEPAGE] Dropdown option not found: " + optionText);
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
		if (cartBtn != null)
			clickOnElement(cartBtn, "Mobile Menu Cart");
		else
			System.out.println("[HOMEPAGE] Mobile Menu Cart button not found.");
	}

	public void clickMobileMenuWishlistButton() {
		openMobileMenu();
		List<WebElement> buttons = driver
				.findElements(By.cssSelector("header div[role='dialog'][aria-modal='true'] button"));
		WebElement wlBtn = findButtonByExactText(buttons, "Wishlist");
		if (wlBtn != null)
			clickOnElement(wlBtn, "Mobile Menu Wishlist");
		else
			System.out.println("[HOMEPAGE] Mobile Menu Wishlist button not found.");
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
			System.out.println("[HOMEPAGE] MiniCart popup is not open. Nothing to close.");
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
			System.out.println("[HOMEPAGE] Browse products link not visible (cart might not be empty).");
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
			if (txt != null && !txt.trim().isEmpty())
				names.add(txt.trim());
		}
		return names;
	}

	public void removeMiniCartItemByIndex(int indexZeroBased) {
		openMiniCart();

		waitUntilElementPresent(miniCartItemsContainerBy, 10, "MiniCart Items Container");

		List<WebElement> removeBtns = driver.findElements(miniCartRemoveButtonsBy);
		if (removeBtns.isEmpty()) {
			System.out.println("[HOMEPAGE] No remove buttons found (cart empty?).");
			return;
		}

		if (indexZeroBased < 0 || indexZeroBased >= removeBtns.size()) {
			System.out.println("[HOMEPAGE] Invalid remove index: " + indexZeroBased);
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
		if (totals.isEmpty())
			return "";
		String txt = totals.get(totals.size() - 1).getText();
		return txt == null ? "" : txt.trim();
	}

	// ============================================================
	// ✅ HOMEPAGE ACTIONS
	// ============================================================

	public boolean isHomePageRootDisplayed() {
		return isElementDisplayed(pageRootContainer, "HomePage Root / Parent section.");
	}

	public boolean isHeroCarouselVisible() {
		return isElementDisplayed(heroCarousel, "Hero Carousel");
	}

	public void clickHeroIndicator(int indexZeroBased) {
		if (indexZeroBased < 0 || heroCarouselIndicators == null || indexZeroBased >= heroCarouselIndicators.size()) {
			System.out.println("[HOMEPAGE] Invalid hero indicator index: " + indexZeroBased);
			return;
		}
		clickOnElement(heroCarouselIndicators.get(indexZeroBased), "Hero Indicator " + indexZeroBased);
	}

	// ---------- Categories ----------
	public void scrollCategoriesLeft() {
		clickOnElement(categoryScrollLeftButton, "Category Scroll Left");
	}

	public void scrollCategoriesRight() {
		clickOnElement(categoryScrollRightButton, "Category Scroll Right");
	}

	public int getCategoryCardCount() {
		return categoryCardsByTitle == null ? 0 : categoryCardsByTitle.size();
	}

	public void clickCategoryByName(String categoryName) {
		WebElement el = findElementByTitle(categoryCardsByTitle, categoryName);
		if (el == null) {
			System.out.println("[HOMEPAGE] Category not found by title: " + categoryName);
			return;
		}
		clickOnElement(el, "Category Card: " + categoryName);
	}

	// ---------- Brands ----------
	public void clickBrandsLeftArrow() {
		clickOnElement(brandsScrollLeftButton, "Brands Left Arrow");
	}

	public void clickBrandsRightArrow() {
		clickOnElement(brandsScrollRightButton, "Brands Right Arrow");
	}

	public int getBrandButtonCount() {
		return brandButtonsWithTitle == null ? 0 : brandButtonsWithTitle.size();
	}

	public void clickBrandByTitle(String brandTitle) {
		WebElement el = findElementByTitle(brandButtonsWithTitle, brandTitle);
		if (el == null) {
			System.out.println("[HOMEPAGE] Brand not found: " + brandTitle);
			return;
		}
		clickOnElement(el, "Brand: " + brandTitle);
	}

	// ---------- Brand products grid ----------
	public void clickShowMoreBrands() {
		WebElement btn = findButtonByExactText(brandGridShowMoreLessLinks, "Show more →");
		if (btn != null)
			clickOnElement(btn, "Show more brands");
		else
			System.out.println("[HOMEPAGE] 'Show more →' button not visible.");
	}

	public void clickShowLessBrands() {
		WebElement btn = findButtonByExactText(brandGridShowMoreLessLinks, "Show less ←");
		if (btn != null)
			clickOnElement(btn, "Show less brands");
		else
			System.out.println("[HOMEPAGE] 'Show less ←' button not visible.");
	}

	public int getBrandProductCardCountVisible() {
		return brandProductCardsByTitle == null ? 0 : brandProductCardsByTitle.size();
	}

	public void clickBrandProductByName(String productName) {
		WebElement el = findElementByTitle(brandProductCardsByTitle, productName);
		if (el == null) {
			System.out.println("[HOMEPAGE] Product card not found by title: " + productName);
			return;
		}
		clickOnElement(el, "Product Card: " + productName);
	}

	public List<String> getVisibleBrandProductNames() {
		List<String> names = new ArrayList<>();
		List<WebElement> titles = driver.findElements(By.cssSelector("section div.grid h4"));
		for (WebElement t : titles) {
			String txt = t.getText();
			if (txt != null && !txt.trim().isEmpty())
				names.add(txt.trim());
		}
		return names;
	}

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
			System.out.println("[HOMEPAGE] No footer social links found.");
			return;
		}
		if (indexZeroBased < 0 || indexZeroBased >= footerSocialLinks.size()) {
			System.out.println("[HOMEPAGE] Invalid footer social index: " + indexZeroBased);
			return;
		}
		clickOnElement(footerSocialLinks.get(indexZeroBased), "Footer Social Link #" + indexZeroBased);
	}

	// ✅ SubscriptionForm - enter email + submit
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
		if (!isElementPresentInDOM(footerSubscribeErrorBy))
			return "";
		List<WebElement> els = driver.findElements(footerSubscribeErrorBy);
		if (els.isEmpty())
			return "";
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	public String getFooterSubscriptionSuccessMessage() {
		if (!isElementPresentInDOM(footerSubscribeOkMsgBy))
			return "";
		List<WebElement> els = driver.findElements(footerSubscribeOkMsgBy);
		if (els.isEmpty())
			return "";
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyHomepageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyHomepageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}