package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ShopPage extends AllVerifications {
	
	@FindBy(css="div.items-center.gap-4>a[aria-label='Wishlist']")
	private WebElement wishlistIcon;
	
	@FindBy(css="div.group.bg-white:nth-of-type(1)>div>button[aria-label='Toggle wishlist']")
	private WebElement FirstProductWishlistIconButton;
	
	
	@FindBy(css="a[aria-label='Sign in']")
	private WebElement SignInLink;
	
	@FindBy(css = "div.hidden.gap-4 span.badgeDot")
	private WebElement  wishlistBadge;
	
	@FindBy(css = "p.leading-snug.truncate")
	private WebElement  productName;
	
	
	
	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyShopPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyShopPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}
	public boolean clickOnWishlistIcon() {
		return clickOnElement(wishlistIcon, "wishlist icon");
	}
	
	public boolean clickOnFirstProductWishlist() {
		return clickOnElement(FirstProductWishlistIconButton, "first product wishlist icon");
	}

	public boolean clickOnSignInLinkIcon() {
		return clickOnElement(SignInLink, "SignInLink icon");
	}
	public boolean verifywishlistBadgeText(String expectedText) {
		return verifyText(wishlistBadge, expectedText, "wishlistBadge Count Text", "equals", true);
	}
	 public String getProductHeadingText() {
		    return getTextFromElement(productName, "Product Heading");
		}

}
