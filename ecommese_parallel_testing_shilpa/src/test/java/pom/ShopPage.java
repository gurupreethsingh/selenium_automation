package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class ShopPage extends AllVerifications
{
	public WebDriver driver =null; 
	SoftAssert sa = new SoftAssert();
	
	// finding your weblements 
	@FindBy(css = "div.grid>div.relative:nth-of-type(2)>div.p-4>div.pt-3>button")
	private WebElement addToCartButton;
	
	@FindBy(css = "div.hidden.items-center.gap-6>div.relative>button")
	private WebElement cartIcon;
	
	@FindBy(css = "div.grid>div.relative:nth-of-type(2)>div.p-4>h3")
	private WebElement productNameInProductCard;
	
	@FindBy(css = "div.overflow-y-auto>div:nth-of-type(1)>div.flex-grow>h3")
	private WebElement productNameInMiniCart;
	
	@FindBy(css = "div.mt-4.border-t>a")
	private WebElement viewCartButtonInMiniCart;
	
	@FindBy(css = "div.mt-4.border-t>button.w-full")
	private WebElement checkoutButtonInMiniCart;
	
	@FindBy(css = "div.mt-4.border-t>div.flex")
	private WebElement totalPriceInMinicart;
	
	@FindBy(css="input.flex-grow")
	private WebElement searchField;
	
	@FindBy(css="div.hidden.justify-center>form>button")
	private WebElement searchIcon;
	
	@FindBy(css="h1.text-3xl")
	private WebElement headingOfProductInSearchProductPage;
	
	@FindBy(css="div.hidden>div.relative:nth-of-type(1)>button>svg")
	private WebElement wishlistIconFromShopPage;
	
	@FindBy(css="div.bg-gradient-to-r")
	private WebElement avatarTabFromShopPage;
	
	@FindBy(css="a.flex:last-child>span")
	private WebElement SignInLinkText;
	
	@FindBy(css="svg.text-cyan-500")
	private WebElement logoFromShopPage;
		
	@FindBy(css="div.space-y-6>div.flex>button")
	private WebElement clearFilterButton;
	
	
	// there are 12 main category
	@FindBy(css="div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+"i"+")>div>span:first-child")
	private WebElement mainCategories;
	
	// there are 12 main category drop down 
	@FindBy(css="div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+"i"+")>div>span:last-child")
	private WebElement mainCategoriesDropDown;
	
	//there is 4 sub category in first main category 
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfFirstMainCategory;
	
	//there is 3 sub category in second main category 
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfsecondMainCategory;
	
	//there is 2 sub category in second main category 
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfThirdMainCategory;
	
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfFourthMainCategory;
	
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfFivthMainCategory;
	
//	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
//	private WebElement SubCategoriesOfSixthMainCategory;

	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfSeventhMainCategory;
	
//	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
//	private WebElement SubCategoriesOfEightMainCategory;
//	
//	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
//	private WebElement SubCategoriesOfNingthMainCategory;
	
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfTenthMainCategory;
	
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfEleventhMainCategory;
	
	@FindBy(css="div.pl-4>div.text-sm:nth-of-type(1)")
	private WebElement SubCategoriesOfTwelthMainCategory;
	//div.space-y-6>div:nth-of-type(3)>div:last-child>div>span
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div.flex")
	private WebElement brandsHeading;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div>span")
	private WebElement allBrandsLink;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div>svg")
	private WebElement allBrandsDropDown;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+"i"+")>span")
	private WebElement brandsNameInAllBrands;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+"i"+")>input")
	private WebElement checkBoxesOfbrandsName;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:first-child")
	private WebElement priceRangeHeading;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>span>span:nth-of-type(2)")
	private WebElement leftPriceRangeButton;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>span>span:nth-of-type(3)")
	private WebElement rightPriceRangeButton;
	
	@FindBy(css="div.px-2>div.text-sm")
	private WebElement realPriceBelowPriceRange;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(2)>div.flex")
	private WebElement categoriesHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:first-child")
	private WebElement sortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(1)")
	private WebElement defaultButton;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(2)")
	private WebElement priceIncrease;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(3)")
	private WebElement priceDecrease;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(4)")
	private WebElement newestButton;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(5)")
	private WebElement oldestButton;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(6)")
	private WebElement popularButton;
	
	@FindBy(css="div.mb-6>h1")
	private WebElement ourProductsHeadingOnShopPage;
	
	@FindBy(css="div.grid:last-child>div.relative:nth-of-type("+"i"+")")
	private WebElement eachProductCards;
	//div.grid:last-child>div.relative:nth-of-type(1)>button
	
	@FindBy(css="div.grid:last-child>div.relative:nth-of-type("+"i"+")>button")
	private WebElement wishlistIconOnEachProductCards;
	
	@FindBy(css="div.grid>div.relative:nth-of-type(1)>div.p-4>div.flex>span:first-child")
	private WebElement priceOnProductCardsInShopPage;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(1)")
	private WebElement firstCardView;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(2)")
	private WebElement secondCardView;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(3)")
	private WebElement thirdCardView;
	
	@FindBy(css="div.mb-6>div>span")
	private WebElement productCount;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(1)")
	private WebElement firstPagination;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(2)")
	private WebElement secondPagination;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(3)")
	private WebElement thirdPagination;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(1)>a")
	private WebElement aboutUs;
	
	@FindBy(css="hdiv.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(2)>a")
	private WebElement contactUs;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(3)>a")
	private WebElement careers;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(4)>a")
	private WebElement blogs;
	
	@FindBy(css="div.mb-12>div:nth-of-type(2)>ul>li:nth-of-type(1)>a")
	private WebElement helpCenter;
	
	@FindBy(css="div.mb-12>div:nth-of-type(2)>ul>li:nth-of-type(2)>a")
	private WebElement privacyPolicy;
	
	@FindBy(css="div.mb-12>div:nth-of-type(2)>ul>li:nth-of-type(3)>a")
	private WebElement termsOfService;
	
	@FindBy(css="div.mb-12>div:nth-of-type(3)>div>a:nth-of-type(1)>svg")
	private WebElement faceBook;
	
	@FindBy(css="div.mb-12>div:nth-of-type(3)>div>a:nth-of-type(2)>svg")
	private WebElement twitter;
	
	@FindBy(css="div.mb-12>div:nth-of-type(3)>div>a:nth-of-type(4)>svg")
	private WebElement linkedIn;
	
	@FindBy(css="div.mb-12>div:nth-of-type(3)>div>a:nth-of-type(3)>svg")
	private WebElement gitHub;
	
	@FindBy(css="div.mb-12>div:nth-of-type(4)>form>input")
	private WebElement enterEmailField;
	
	@FindBy(css="div.mb-12>div:nth-of-type(4)>form>button")
	private WebElement subscribeButton;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>h3")
	private WebElement companyHeading;
	
	@FindBy(css="div.mb-12>div:nth-of-type(2)>h3")
	private WebElement supportHeading;
	
	@FindBy(css="div.mb-12>div:nth-of-type(3)>h3")
	private WebElement followUs;
	
	@FindBy(css="div.mb-12>div:nth-of-type(4)>h3")
	private WebElement subscribeHeading;
	
	@FindBy(css="button.fixed")
	private WebElement topUpArrowButtonInFooter;
	
	@FindBy(css="div.border-t>p.text-sm:first-child")
	private WebElement copyWriteTextLeftSide;
	
	@FindBy(css="div.border-t>p.text-sm:last-child")
	private WebElement copyWriteTextRightSide;
	
	@FindBy(css="div>h1")
	private WebElement productHeadingInSingleProductPage;
	
	@FindBy(css="header>nav>div:nth-child(3)>a>div>span")
	private WebElement wishlistBadge;
	
	@FindBy(css="header>nav>div:nth-child(3)>div:nth-of-type(1)>button>span")
	private WebElement miniCartBadge;
	
	@FindBy(css="div.mt-4>button ")
	private WebElement checkOutButtonOnMinicart;
	
	@FindBy(css="h1.text-3xl")
	private WebElement removeButtonFromWishlistPage;
	
	@FindBy(css="div.transition:nth-of-type(1)>div.mt-4:nth-of-type(1)>h2")
	private WebElement productNameInWishlistPage;
	
	@FindBy(css="div.transition:nth-of-type(1)>div.mt-4:nth-of-type(1)>p:nth-of-type(1)")
	private WebElement productPriceInWishlistPage;
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// initializing all the elements in this page. using the constructor of this class. 
	public ShopPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// utilization (create fucntions to perform operations on elements ) 
	public void clickOnAddToCartButton()
	{
		AllVerifications.clickIfVisibleAndEnabled(addToCartButton, driver, sa);
	}
	
	public void clickOnCartIcon()
	{
		AllVerifications.clickIfVisibleAndEnabled(cartIcon, driver, sa);
	}
	
	public void verifyProductNameInMinicart(String expectedText)
	{
		AllVerifications.textIsPresentOrNot(expectedText, driver,  productNameInMiniCart, sa);
	}
	
	
	public String  verifyProductName()
	{
		String actualProductText  =  productNameInProductCard.getText();
		return  actualProductText;
	}
	
	
	public void clickOnViewCartButtonOFMiniCart()
	{
		AllVerifications.clickIfVisibleAndEnabled(viewCartButtonInMiniCart, driver, sa);
	}
	
	public void enterValueInSearchField1(String keys)
	{
		AllVerifications.clickIfVisibleAndEnabled(searchField, driver, sa);
		searchField.clear();
		searchField.sendKeys(keys);
	}
	
	
	public void clickOnSearchButton1()
	{
		AllVerifications.clickIfVisibleAndEnabled(searchIcon, driver, sa);
	}
	
//	public void verifyProductNameInSearchProductPage(String expectedText)
//	{
//		AllVerifications.textIsPresentOrNot(expectedText, driver,headingInSearchField, sa);
//	}
	
	
	
	
	 
	
}
