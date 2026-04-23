package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class WishlistPage extends AllVerifications {

	@FindBy(css = "button.btnOrange")
	private WebElement moveToCart;

	@FindBy(css = "button.btnOrange+button")
	private WebElement byNowButton;

	@FindBy(css = "button.btnGhost+button")
	private WebElement removeButton;

	@FindBy(css = "div.grid.mt-1>button.btnGhost")
	private WebElement saveButton;
	
	@FindBy(css = "div.group>div.p-3 h2")
	private WebElement productHeading;
	
	//div.flex>button.justify-center   continue shopping
	
	@FindBy(css = "div.flex>button.justify-center")
	private WebElement  continueShoppingButton;
	
	
	@FindBy(css = "button.btnOrange")
	private WebElement  browseProductsButton;
	
	
	
	@FindBy(css = "div.hidden.gap-4 span.badgeDot")
	private WebElement  wishliatBadge;
	
	@FindBy(css = "h2.truncate")
	private WebElement  productNameinWishlist;
	
	@FindBy(css = "div.inline-flex.items-center.gap-2.font-semibold")
	private WebElement  yourWishlistIsEmptyMessage;
	
	//
	@FindBy(css = "div.w-full.mx-auto div.min-w-0 button")
	private WebElement  backButton;
	
	public WishlistPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyWishlistPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyWishlistPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	public boolean clickOnmoveToCart() {
		return clickOnElement(moveToCart, "moveToCart Button");
	}

	public boolean clickOnbyNowButton() {
		return clickOnElement(byNowButton, "byNow Button");
	}
	public boolean clickContinueShoppingButton() {
		return clickOnElement(continueShoppingButton, "continue  Shopping  Button ");
	}

	public boolean clickOnremoveButton() {
		return clickOnElement(removeButton, "remove   Button ");
	}

	public boolean clickOnsaveButton() {
		return clickOnElement(saveButton, "saveButton ");
	}
	
	public boolean clickbrowseProductsButton() {
		return clickOnElement(browseProductsButton, "Browse Products Button ");
	}
	public boolean clickbackButton() {
		return clickOnElement(backButton, " Button ");
	}
	
	 public boolean verifybrowserProductsButtonText() {
	        return verifyText(
	        		browseProductsButton,
	            "Browse products",
	            "Browse products Button",
	            "equals",
	            true
	        );
	 }
	 public String getProductHeadingText() {
		    return getTextFromElement(productNameinWishlist, "Product Heading");
		}
	 public boolean verifyEmptyWishlistMessage() {
		    return verifyText(
		    		yourWishlistIsEmptyMessage,
		        "Your wishlist is empty.",
		        "Empty Wishlist Message",
		        "contains",
		        true
		    );
		}
}

