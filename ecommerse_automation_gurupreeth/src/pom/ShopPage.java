package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.AllVerifications_Anusha;
import generic.TakingScreenshot;
import generic.BaseClass_Anusha.Excel_Anusha;

public class ShopPage extends AllVerifications
{
	public WebDriver driver =null; 
	SoftAssert sa = new SoftAssert();
	
	// finding your weblements 
	@FindBy(css = "div.grid>div.relative:nth-of-type(2)>div.p-4>div.pt-3>button")
	private WebElement addToCartButton;
	
	@FindBy(css = "h1.text-3xl")
	private WebElement headingInSearchField;
	//
	
	@FindBy(css = "div.space-y-6>div:nth-of-type(2)>div.flex")
	private WebElement CategoriesHeadingBelowClearFilterButton;
	
	@FindBy(css = "nav.containerWidth>div.flex:first-child>a.linkText")
	private WebElement shopAllLinkText;
	
	@FindBy(css = "div.hidden>div.relative:nth-of-type(1)>button>svg")
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
	
	@FindBy(css="nav.containerWidth>div:nth-of-type(3)>a.relative")
	private WebElement wishlistIconFromShopPage;
	
	@FindBy(css="div.bg-gradient-to-r")
	private WebElement avatarTabFromShopPage;
	
	@FindBy(css="a.flex:last-child>span")
	private WebElement SignInLinkText;
	
	@FindBy(css="svg.text-cyan-500")
	private WebElement logoFromShopPage;
		
	@FindBy(css="div.space-y-6>div.flex>button")
	private WebElement clearFilterButton;
	
	
	@FindBy(css="div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div")
	private List<WebElement> mainCategoryName;
	
	@FindBy(css="div.grid-cols-1.gap-6>div.relative")
	private List<WebElement> allProductContainer;


	
//	@FindBy(css="div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child(1)>div>span:first-child")
//	private WebElement mainCategories;
	
	// there are 12 main category drop down 
	@FindBy(css="div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child(1)>div>span:last-child")
	private WebElement DropDownOfMainCategories;
	
	//there is 4 sub category in first main category 
	@FindBy(css="div.pl-4>div.text-sm")
	private List<WebElement> subCategoriesOfFirstMainCategoryContainer;
	
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
	private WebElement brandsHeadingBelowCategoriesHeading;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div>span")
	private WebElement allBrandsLinkBelowBrandsHeading;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div>svg")
	private WebElement dropDownOfAllBrandsBelowToBrandsHeading;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+"i"+")>span")
	private WebElement brandsNameInAllBrands;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex>input")
	private List<WebElement> checkBoxesOfBrands_Container;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:first-child")
	private WebElement priceRangeHeadingBelowAllBrands;
	
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>span")
	private WebElement priceRangeScaleBelowAllBrands;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>span>span:nth-of-type(2)")
	private WebElement leftButtonOfPriceRangeScale;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>span>span:nth-of-type(3)")
	private WebElement rightButtonOfPriceRangeScale;
//	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>div>span:first-child")
	private WebElement MinimumPricePresentBelowToPriceRangeScale;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(4)>div:last-child>div>span:last-child")
	private WebElement MaximumPricePresentBelowToPriceRangeScale;
	
	@FindBy(css="div.space-y-6>div:nth-of-type(2)>div.flex")
	private WebElement categoriesHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:first-child")
	private WebElement sortByHeadingBelowPriceRange;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(1)")
	private WebElement defaultButtonBelongsToSortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(2)")
	private WebElement priceIncreaseBelongsToSortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(3)")
	private WebElement priceDecreaseBelongsToSortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(4)")
	private WebElement newestButtonBelongsToSortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(5)")
	private WebElement oldestButtonBelongsToSortByHeading;

	@FindBy(css="div.space-y-6>div:nth-of-type(5)>div:last-child>button:nth-of-type(6)")
	private WebElement popularButtonBelongsToSortByHeading;
	
	@FindBy(css="div.mb-6>h1")
	private WebElement ourProductsHeadingOnShopPage;
	
	@FindBy(css="div.grid:last-child>div.relative")
	private List<WebElement> eachProductCardsContainer;
	//div.grid:last-child>div.relative:nth-of-type(1)>button
	
	
//	div.grid:last-child>div.relative>button
	@FindBy(css="div.grid:last-child>div.relative>button")
	private List<WebElement> wishlistIconOnEachProductCardsContainer;
	
	@FindBy(css="div.grid>div.relative:nth-of-type(1)>div.p-4>div.flex>span:first-child")
	private WebElement priceOnProductCardsInShopPage;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(1)")
	private WebElement CardView;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(2)")
	private WebElement GridView;
	
	@FindBy(css="div.mb-6>div>div>button:nth-of-type(3)")
	private WebElement ListView;
	
	@FindBy(css="div.mb-6>div>span")
	private WebElement productCount;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(1)")
	private WebElement firstPaginationButton;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(2)")
	private WebElement secondPaginationButton;
	
	@FindBy(css="div.mt-10>div>nav>button:nth-of-type(3)")
	private WebElement thirdPaginationButton;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(1)>a")
	private WebElement aboutUs;
	
	@FindBy(css="div.mb-12>div:nth-of-type(1)>ul>li:nth-of-type(2)>a")
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
		
	@FindBy(css="form.space-y-6>div:first-child>input.w-full")
	private WebElement emailInputFieldOnLoginPage;
		
	@FindBy(css="form.space-y-6>div:nth-of-type(2)>input")
	private WebElement passwordInputFieldOnLoginPage;
	
	@FindBy(css="form.space-y-6>div:nth-of-type(2)>span")
	private WebElement EyeButtonOnPasswordInputField;
	
	@FindBy(css="form.space-y-6>button")
	private WebElement LoginButtonInLoginInPage;
	
	@FindBy(css="nav.containerWidth>div.flex:first-child>a:last-child")
	private WebElement shopAllLinkTextFromUserDashBoardPage;
	
	@FindBy(css="div.grid:last-child>div.relative>div:nth-of-type(3)>div:nth-of-type(2)>button")
	private List<WebElement> addToCartButtonOverProductCardContainer;
	
	
	
	
	
	
	
	
	
	
	
	// initializing all the elements in this page. using the constructor of this class. 
	public ShopPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// utilization (create fucntions to perform operations on elements ) 
	//
	public void clickOnlogoFromShopPage() throws InterruptedException
	{
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(logoFromShopPage, driver, sa);
		Thread.sleep(2000);
	}
	public void clickOnShopAllLinkTextFromShopPage() throws InterruptedException
	{
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(shopAllLinkText, driver, sa);
		Thread.sleep(2000);
	}
	
	
	
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


	public void clickOnwishlistFromShopPage() throws InterruptedException {
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(wishlistIconFromShopPage, driver, sa);
		Thread.sleep(2000);
		
	}


	public void clickOnCartFromShopPage() throws InterruptedException 
	{
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(cartIcon, driver, sa);
		Thread.sleep(2000);		
		
	}


	public void clickOnAvatarFromShopPage() throws InterruptedException 
	{
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(avatarTabFromShopPage, driver, sa);
		Thread.sleep(2000);		
		
	}


	public void clickOnSignInFromShopPage() throws InterruptedException {
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled(SignInLinkText, driver, sa);
		Thread.sleep(2000);		
		
	}


	public void EnterValueInSearchField(String keys) {
		AllVerifications.clickIfVisibleAndEnabled(searchField, driver, sa);
		searchField.clear();
		searchField.sendKeys(keys);
	}
	
	public void clickOnSearchButton()
	{
		AllVerifications.clickIfVisibleAndEnabled(searchIcon, driver, sa);
	}
	public void verifyProductNameInSearchProductPage(String expectedText)
	{
		
		AllVerifications.textIsPresentOrNot(expectedText, driver,headingInSearchField, sa);
	}


	public void clickOnCardViewFromShopPage() throws InterruptedException 
	{
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled( GridView, driver, sa);
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled( CardView, driver, sa);
		Thread.sleep(2000);	
		
	}


	public void clickOnGridViewFromShopPage() throws InterruptedException {
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled( GridView, driver, sa);
		Thread.sleep(2000);	
		
	}
	public void clickOnListViewFromShopPage() throws InterruptedException {
		Thread.sleep(2000);
		AllVerifications.clickIfVisibleAndEnabled( ListView, driver, sa);
		Thread.sleep(2000);	
		
	}
	public void verifyCategoriesHeadingBelowClearFilterButton(String expectedText) throws InterruptedException
	{
		
	Thread.sleep(1000);
	AllVerifications.textIsPresentOrNot(expectedText, driver,CategoriesHeadingBelowClearFilterButton, sa);
	Thread.sleep(1000);
	}
	
	public int verifyNumberOfMainCategories() throws InterruptedException
{
		Thread.sleep(2000);
		int allMainCategoryCount  = mainCategoryName.size();
		return  allMainCategoryCount;
		
		
	}
	
	
	
	
//	
//	public void clickOnMainCategoryFromShopPage() throws InterruptedException {
//		Thread.sleep(2000);
//		AllVerifications.clickIfVisibleAndEnabled(  mainCategories, driver, sa);
//		Thread.sleep(2000);	
//		
//	}
//
//	public void clickOnMainCategoryDropDownFromShopPage() throws InterruptedException {
//		Thread.sleep(2000);
//		AllVerifications.clickIfVisibleAndEnabled(  mainCategoriesDropDown, driver, sa);
//		Thread.sleep(2000);	
//		
//	}

	public void clickONClearFilterButton() throws InterruptedException 
	{
		Thread.sleep(1000);
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		Actions actions=new Actions(driver);
		actions.scrollToElement( clearFilterButton).build().perform();
		AllVerifications.clickIfVisibleAndEnabled(clearFilterButton, driver, sa);
		js.executeScript("window.scrollTo(0, 500);");
		Thread.sleep(1000);
		
	}

public void clickONClearFilterButtonAfterApplyingPriceRangeFilter() throws InterruptedException 
	{
		
	AllVerifications.clickIfVisibleAndEnabled(clearFilterButton, driver, sa);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(500, 0);");
	AllVerifications.clickIfVisibleAndEnabled(clearFilterButton, driver, sa);
	
		
	}
	
	
	
	


//	public String verifyMainCategoryName() {
//		String actualMainCategoryText  =  mainCategories.getText();
//		return  actualMainCategoryText;
//		
//	}
	public int findTotalCategoryCount()
    {
    	int mainCategoryCount=mainCategoryName.size();
    	System.out.println("Total main categories are  "+ mainCategoryCount);
    	
    	return mainCategoryCount;
    }

    public void clickOnMainCategory(int k)
    {
//    	int mainCategoryCount=mainCategoryName.size();
//    	System.out.println("Total main categories are  "+ mainCategoryCount);
    	
    	//now find the electronics category 
    	
    WebElement	mainCategoryName=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:first-child"));
    String MainCategoryName =mainCategoryName.getText();
    System.out.println("Clicking on main category "+ MainCategoryName);
    
    mainCategoryName.click();
    
    }
    //
    public void fetchAllProducts()
    {
    	int allProductsCount=allProductContainer.size();
    	System.out.println("Total products belonging to this main category are :"+ allProductsCount);
    	
    	//now find all the products name, sp,dp
    	for(int i=1;i<=allProductsCount;i++)
    	{
    		
    		// fetching products names
    		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
    		
    		System.out.println("Products names "+eachProductName.getText());
    	    
    	    //fetching products selling price
    	    WebElement	eachProductSellingPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:first-child"));
    	    System.out.println("Selling Price "+eachProductSellingPrice.getText());
    	    
    	    //fetching products display price
    	    WebElement	eachProductDisplayPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:last-child"));
    	    System.out.println("Display Price "+eachProductDisplayPrice.getText());
    	    
    	    
    	}    
    	}
    public void fetchAllProductsBelongsToSubCategory()
    {
    	int allProductsCount=allProductContainer.size();
    	System.out.println("Total products belonging to this sub-category are :"+ allProductsCount);
    	
    	//now find all the products name, sp,dp
    	for(int i=1;i<=allProductsCount;i++)
    	{
    		
    		// fetching products names
    		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
    		System.out.println("Products names "+eachProductName.getText());
    	    
    	    //fetching products selling price
    	    WebElement	eachProductSellingPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:first-child"));
    	    System.out.println("Selling Price "+eachProductSellingPrice.getText());
    	    
    	    //fetching products display price
    	    WebElement	eachProductDisplayPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:last-child"));
    	    System.out.println("Display Price "+eachProductDisplayPrice.getText());
    	    
    	}   
    	}    
    	
    	public void clickOnEachProduct()
        {
        	int allProductsCount=allProductContainer.size();
        	System.out.println("Total products are : "+ allProductsCount);
        	
        	//now find all the products name, sp,dp
        	for(int i=1;i<=allProductsCount;i++)
        	{
        		// fetching products names
        		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
        	    System.out.println("Clicking on Products names "+eachProductName.getText());
        	    eachProductName.click();    
        	}
        }
        	
   public void clickOnDropDownOfMainCategoryOPEN(int k) throws InterruptedException {
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
		
	WebElement	mainCategoryName=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:first-child"));
	actions.scrollToElement(mainCategoryName).build().perform();
	String MainCategoryName =mainCategoryName.getText();
	
	Thread.sleep(500);	
    WebElement	eachDropDownOfMainCategory=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:last-child"));
    actions.scrollToElement(eachDropDownOfMainCategory).build().perform();
    System.out.println("Clicking on "+ MainCategoryName+" drop down ");
    
    eachDropDownOfMainCategory.click();
    Thread.sleep(500);
    
    
    
    
//    int subCategoryCount=subCategoriesOfFirstMainCategoryContainer.size();
//	System.out.println("Number of sub categories of "+ MainCategoryName + "are :"+subCategoryCount);
	
//    eachDropDownOfMainCategory.click();  
//    return subCategoryCount;
  }
   
   public void clickOnDropDownOfMainCategoryCLOSE(int k) throws InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		Actions actions=new Actions(driver);
			
		WebElement	mainCategoryName=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:first-child"));
		actions.scrollToElement(mainCategoryName).build().perform();
		String MainCategoryName =mainCategoryName.getText();
		
		Thread.sleep(500);	
	    WebElement	eachDropDownOfMainCategory=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:last-child"));
	    actions.scrollToElement(eachDropDownOfMainCategory).build().perform();
	    System.out.println("Closing sub-cateories of : "+ MainCategoryName);
	    
	    eachDropDownOfMainCategory.click();
	    Thread.sleep(500);
//	    int subCategoryCount=subCategoriesOfFirstMainCategoryContainer.size();
//		System.out.println("Number of sub categories of "+ MainCategoryName + "are :"+subCategoryCount);
		
//	    eachDropDownOfMainCategory.click();  
//	    return subCategoryCount;
	  }

   public void clickOnDropDownOfMainCategoryOpenAndClose(int k) throws InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		Actions actions=new Actions(driver);
			
		WebElement	mainCategoryName=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:first-child"));
		actions.scrollToElement(mainCategoryName).build().perform();
		String MainCategoryName =mainCategoryName.getText();
		
		Thread.sleep(500);	
	    WebElement	eachDropDownOfMainCategory=driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+k+")>div>span:last-child"));
	    actions.scrollToElement(eachDropDownOfMainCategory).build().perform();
	    System.out.println("Clicking on "+ MainCategoryName+" drop down ");
	    
	    eachDropDownOfMainCategory.click();
	    Thread.sleep(500);
//	    int subCategoryCount=subCategoriesOfFirstMainCategoryContainer.size();
//		System.out.println("Number of sub categories of "+ MainCategoryName + "are :"+subCategoryCount);
		
	    eachDropDownOfMainCategory.click();  
//	    return subCategoryCount;
	  }
public int countNumberOfSubCategoriesOfThatMainCategory() {
	int subCategoryCount=subCategoriesOfFirstMainCategoryContainer.size();
	System.out.println("Number of sub categories of   are :"+subCategoryCount);

	return subCategoryCount;
}


public void fetchTheNameOfSubCatAndClick(int o) throws InterruptedException {
	WebElement	subCategoryBelongsToMainCategory=driver.findElement(By.cssSelector("div.pl-4>div.text-sm:nth-of-type("+o+")"));
  
    System.out.println("Clicking on the sub category : "+ subCategoryBelongsToMainCategory.getText());
    
    subCategoryBelongsToMainCategory.click();
    Thread.sleep(1000);
    
	

}
//
public void verifyBrandsHeadingBelowCategoriesHeading(String expectedText) throws InterruptedException
{
	Thread.sleep(1000);
	AllVerifications.textIsPresentOrNot(expectedText, driver,brandsHeadingBelowCategoriesHeading, sa);
	Thread.sleep(1000);
}


public void verifyAllBrandsSubHeadingBelowBrandsHeading(String expectedText) 
{
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(allBrandsLinkBelowBrandsHeading).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,allBrandsLinkBelowBrandsHeading, sa);
	
}


public void clickOnAllBrandsSubHeadingBelowBrandsHeading() throws InterruptedException
{
	 Thread.sleep(2000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(0, 500);");
      AllVerifications.clickIfVisibleAndEnabled(allBrandsLinkBelowBrandsHeading, driver, sa);
      Thread.sleep(2000);
	
}


public void clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(0, 500);");
	AllVerifications.clickIfVisibleAndEnabled(dropDownOfAllBrandsBelowToBrandsHeading, driver, sa);
	Thread.sleep(2000);
	
}


public void clickOnCheckBoxOfAnyBrands() throws InterruptedException 
{
	Thread.sleep(2000);
	int allCheckBoxesCount=checkBoxesOfBrands_Container.size();
	for(int i=1;i<=allCheckBoxesCount;i++) 
	{
		WebElement	CheckBoxOfBrands=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>input"));
		WebElement  brandNamesBelongToThatCheckBox = driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>span"));
	    System.out.println("Clicking on the checkboxes of brand "+  brandNamesBelongToThatCheckBox.getText());
	    
		CheckBoxOfBrands.click();
		
		
	}
	Thread.sleep(1000);
}

public void clickOnBrandNamesOfAllBrandsSection() throws InterruptedException 
{

	Thread.sleep(1000);
	int allBrandsCount=checkBoxesOfBrands_Container.size();
	for(int i=1;i<=allBrandsCount;i++) 
	{
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		
		WebElement	brandNamesOfAllBrandsSection=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>span"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(brandNamesOfAllBrandsSection).build().perform();
		
	    System.out.println("Clicking on the  brand name "+ brandNamesOfAllBrandsSection.getText());
	    brandNamesOfAllBrandsSection.click();
	
	}
	
	Thread.sleep(1000);
}


public void clickOnBrandNamesOfAllBrandsSectionAndFetchAllTheProductsBelongsToThatBrand() throws InterruptedException 
{
	Thread.sleep(1000);
	int allBrandsCount=checkBoxesOfBrands_Container.size();
	for(int i=1;i<=allBrandsCount;i++) 
	{
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		
		WebElement	brandNamesOfAllBrandsSection=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>span"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(brandNamesOfAllBrandsSection).build().perform();
		
	    System.out.println("Clicking on the  brand "+ brandNamesOfAllBrandsSection.getText());
	    
	    brandNamesOfAllBrandsSection.click();
		
	    int allProductsCount=allProductContainer.size();
	    System.out.println("Total products are  "+ allProductsCount);
	    
	    	//now find all the products name, sp,dp
	    	for(int j=1;j<=allProductsCount;j++)
	    	{
	    		// fetching products names
	    		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>h3"));
	    	    System.out.println("Products belonging to "+brandNamesOfAllBrandsSection.getText()+" brands are :"+eachProductName.getText());
	    	    
	    	    //fetching products selling price
	    	    WebElement	eachProductSellingPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(1)>span:first-child"));
	    	    System.out.println("Selling Price "+eachProductSellingPrice.getText());
	    	    
	    	    //fetching products display price
	    	    WebElement	eachProductDisplayPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(1)>span:last-child"));
	    	    System.out.println("Display Price "+eachProductDisplayPrice.getText());
	    	    Thread.sleep(1000);
	    	    
	    	} 
//	    	JavascriptExecutor js1 =(JavascriptExecutor)driver; 
//	    	Actions action=new Actions(driver);
	    	actions.scrollToElement(clearFilterButton).build().perform();
	    	clearFilterButton.click();	
	    	Thread.sleep(1000);
	}
	//
	Thread.sleep(1000);
}

public void clickOnCheckBoxOfAnyBrandBelongsToAllBrandsSectionAndFetchAllTheProductsBelongsToThatBrand() throws InterruptedException 
{
	int allCheckBoxesCount=checkBoxesOfBrands_Container.size();
	for(int i=1;i<=allCheckBoxesCount;i++) 
	{
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		WebElement	CheckBoxOfBrands=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>input"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(CheckBoxOfBrands).build().perform();
		
		WebElement  brandNamesBelongToThatCheckBox = driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(3)>div:last-child>div:last-child>div.flex:nth-of-type("+i+")>span"));
	    System.out.println("Clicking on the checkboxes of brand "+  brandNamesBelongToThatCheckBox.getText());
	    CheckBoxOfBrands.click();
	    int allProductsCount=allProductContainer.size();
	    System.out.println("Total products are  "+ allProductsCount);
	    
	    	//now find all the products name, sp,dp
	    	for(int j=1;j<=allProductsCount;j++)
	    	{
	    		// fetching products names
	    		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>h3"));
	    	    System.out.println("Products belonging to "+ brandNamesBelongToThatCheckBox.getText()+" brands are :"+eachProductName.getText());
	    	    
	    	    //fetching products selling price
	    	    WebElement	eachProductSellingPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(1)>span:first-child"));
	    	    System.out.println("Selling Price "+eachProductSellingPrice.getText());
	    	    
	    	    //fetching products display price
	    	    WebElement	eachProductDisplayPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(1)>span:last-child"));
	    	    System.out.println("Display Price "+eachProductDisplayPrice.getText());
	    	    Thread.sleep(1000);
	    	    
	    	} 
//	    	JavascriptExecutor js1 =(JavascriptExecutor)driver; 
//	    	Actions action=new Actions(driver);
	    	actions.scrollToElement(clearFilterButton).build().perform();
	    	clearFilterButton.click();	
	    	Thread.sleep(1000);
	}
	//
	Thread.sleep(1000);
}
	
	



public void verifyPriceRangeHeadingBelowAllBrandsHeading(String expectedText) {
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(priceRangeHeadingBelowAllBrands).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver, priceRangeHeadingBelowAllBrands, sa);
	
}


public void verifySortByHeadingBelowPriceRange(String expectedText) {
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(sortByHeadingBelowPriceRange).build().perform();
	
	AllVerifications.textIsPresentOrNot(expectedText, driver, sortByHeadingBelowPriceRange, sa);
	
}
public void verifyAllOptionsWhichBelongsToSortBySection() throws InterruptedException 
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(0, 600);");
	Thread.sleep(1000);
	
	
}



public void clickOnDefaultButtonBelowSortByHeading() {
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(defaultButtonBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(defaultButtonBelongsToSortByHeading, driver, sa);
	
}


public void clickOnPriceIncreaseButtonBelowSortByHeading() throws InterruptedException 
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(priceIncreaseBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(priceIncreaseBelongsToSortByHeading, driver, sa);
	Thread.sleep(1000);
	
}


public void clickOnPriceDecreaseButtonBelowSortByHeading() throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(priceDecreaseBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(priceDecreaseBelongsToSortByHeading, driver, sa);
	Thread.sleep(1000);
	
	
}


public void clickOnOldestButtonBelowSortByHeading() throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( oldestButtonBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled( oldestButtonBelongsToSortByHeading, driver, sa);
	Thread.sleep(1000);
	
}


public void clickOnNewestButtonBelowSortByHeading() throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( newestButtonBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled( newestButtonBelongsToSortByHeading, driver, sa);
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(800, 0);");
	Thread.sleep(1000);
	TakingScreenshot.captureScreenshot(driver);
	
	
	
}
public void clickOnPopulartButtonBelowSortByHeading() throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( popularButtonBelongsToSortByHeading).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(popularButtonBelongsToSortByHeading, driver, sa);
	Thread.sleep(1000);
	
}


public void clickOnFirstPaginationButton() throws InterruptedException 
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver;
	Actions actions=new Actions(driver);
	actions.scrollToElement( firstPaginationButton).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(firstPaginationButton, driver, sa);
	Thread.sleep(1000);
    
}


public void clickOnSecondPaginationButton() throws InterruptedException 
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( secondPaginationButton).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(secondPaginationButton, driver, sa);
	Thread.sleep(1000);
}
//

public void clickOnThirdPaginationButton() throws InterruptedException 
{
	Thread.sleep(2000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( thirdPaginationButton).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(thirdPaginationButton, driver, sa);
	Thread.sleep(2000);
	
}


public void clickOnEachProductCardsOnFirstPage() throws InterruptedException
{
	Thread.sleep(2000);
	int AllProductCardsCount=eachProductCardsContainer.size();
	System.out.println("The Number of product cards in First page are :"+AllProductCardsCount);
	for(int i=1;i<=AllProductCardsCount;i++) 
	{
	    JavascriptExecutor js =(JavascriptExecutor)driver; 
		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
	    Actions actions=new Actions(driver);
		actions.scrollToElement(productCards).build().perform();
	    System.out.println("Clicking On the Product Card :"+  productCards.getText());
	    productCards.click();
	    Thread.sleep(1000);
	    
	    String expectedSingleProductpageTitle = (String)Excel_Anusha.getData("ShopPage",5,0);
		AllVerifications.verifyTitle(expectedSingleProductpageTitle, driver, sa);
		sa.assertAll();
		shopAllLinkText.click(); 
	}
}

//public void clickOnEachProductCardsOnSecondPage() throws InterruptedException
//{
//	Thread.sleep(1000);
//	JavascriptExecutor js =(JavascriptExecutor)driver; 
//	Actions actions=new Actions(driver);
//	actions.scrollToElement(secondPaginationButton).build().perform();
//	secondPaginationButton.click();
//	int AllProductCardsCount=eachProductCardsContainer.size();
//	System.out.println("The Number of product cards in Second page are :"+AllProductCardsCount);
//	for(int i=1;i<=AllProductCardsCount;i++) 
//	
//	{
//	  
//		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
//	    Actions actions1=new Actions(driver);
//   	    actions1.scrollToElement(productCards).build().perform();
//	 	
//	    System.out.println("Clicking On the Product Card :"+  productCards.getText());
//	    productCards.click();
//	    Thread.sleep(1000);
//	    
//	    String expectedSingleProductpageTitle = (String)Excel_Anusha.getData("ShopPage",5,0);
//		AllVerifications.verifyTitle(expectedSingleProductpageTitle, driver, sa);
//		sa.assertAll();
//		
//	    actions1.scrollToElement( shopAllLinkText).build().perform();
//	    shopAllLinkText.click(); 
//	    Thread.sleep(500);
////	    WebElement productNameInSingleProductPage=driver.findElement(By.cssSelector("h1.text-4xl"));
////	    AllVerifications.textIsPresentOrNot( productCards.getText(), driver, productNameInSingleProductPage, sa);
//	    actions1.scrollToElement(secondPaginationButton).build().perform();
//	    secondPaginationButton.click();
//	    Thread.sleep(1000);
//	    
//	}
//}
public void clickOnEachProductCardsOnSecondPage() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Go to 2nd pagination
    wait.until(ExpectedConditions.elementToBeClickable(secondPaginationButton));
    js.executeScript("arguments[0].scrollIntoView({block:'center'});", secondPaginationButton);
    secondPaginationButton.click();

    Thread.sleep(1500);

    // Get total product count on page
    int productCount = eachProductCardsContainer.size();
    System.out.println("The Number of product cards in Second page are : " + productCount);

    for (int i = 1; i <= productCount; i++) {

        // Re-locate element every time to avoid stale element exception
        By productLocator = By.cssSelector(
                "div.grid:last-child > div.relative:nth-of-type(" + i + ") > div:nth-of-type(3) > h3"
        );

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        // Scroll product to center (prevents header overlap)
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", productCard);
        Thread.sleep(500);

        System.out.println("Clicking On Product: " + productCard.getText());

        try {
            productCard.click();
        } catch (Exception e) {
            // Fallback JS click
            js.executeScript("arguments[0].click();", productCard);
        }

        // Verify product page
        String expectedSingleProductpageTitle = (String)Excel_Anusha.getData("ShopPage",5,0);
        AllVerifications.verifyTitle(expectedSingleProductpageTitle, driver, sa);

        // Navigate back to shop page
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", shopAllLinkText);
        shopAllLinkText.click();

        // Wait for page to reload
        wait.until(ExpectedConditions.elementToBeClickable(secondPaginationButton));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", secondPaginationButton);
        secondPaginationButton.click();

        Thread.sleep(1500);
    }
}

public void clickOnEachProductCardsOnThirdPage() throws InterruptedException
{
	Thread.sleep(2000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(thirdPaginationButton).build().perform();
	thirdPaginationButton.click();
	int AllProductCardsCount=eachProductCardsContainer.size();
	System.out.println("The Number of product cards in Third page are :"+AllProductCardsCount);
	for(int i=1;i<=AllProductCardsCount;i++) 
	{
	  
		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
	    Actions actions1=new Actions(driver);
		actions1.scrollToElement(productCards).build().perform();
		
	    System.out.println("Clicking On the Product Card :"+  productCards.getText());
	    
	    productCards.click();
	    Thread.sleep(1000);
	    
	    String expectedSingleProductpageTitle = (String)Excel_Anusha.getData("ShopPage",5,0);
		AllVerifications.verifyTitle(expectedSingleProductpageTitle, driver, sa);
		sa.assertAll();
		
	    actions1.scrollToElement( shopAllLinkText).build().perform();
	    shopAllLinkText.click(); 
	    Thread.sleep(1000);
//	    WebElement productNameInSingleProductPage=driver.findElement(By.cssSelector("h1.text-4xl"));
//	    AllVerifications.textIsPresentOrNot( productCards.getText(), driver, productNameInSingleProductPage, sa);
	    actions1.scrollToElement(thirdPaginationButton).build().perform();
	    thirdPaginationButton.click();
	    Thread.sleep(2000);
	}
 }


public void clickOnWishListIconPresentOnEachProductCard() throws InterruptedException 
{
	Thread.sleep(1000);
	int wishlistIconOnEachProductCardsCount=wishlistIconOnEachProductCardsContainer.size();
	System.out.println("The Number of wishlist icons  in First page are :"+wishlistIconOnEachProductCardsCount);
	for(int i=1;i<=wishlistIconOnEachProductCardsCount;i++) 
	{
	    JavascriptExecutor js =(JavascriptExecutor)driver; 
		WebElement eachWishlistIconPresentOnProductCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>button"));
	    Actions actions=new Actions(driver);
		actions.scrollToElement(eachWishlistIconPresentOnProductCards).build().perform();
		//AllVerifications.clickIfVisibleAndEnabled(eachProductCardsContainer, driver, sa);
	    System.out.println("Clicking On wishListIcon of :"+  eachWishlistIconPresentOnProductCards.getText());
	    
	    eachWishlistIconPresentOnProductCards.click();
	    TakingScreenshot.captureScreenshot(driver);
//	    WebElement productNameInSingleProductPage=driver.findElement(By.cssSelector("h1.text-4xl"));
//	    AllVerifications.textIsPresentOrNot( productCards.getText(), driver, productNameInSingleProductPage, sa);
	    Thread.sleep(1000);
	   
	}
}


public void enterEmailInputField(String emailkeys) throws InterruptedException
{
	Thread.sleep(1000);	
	AllVerifications.clickIfVisibleAndEnabled(emailInputFieldOnLoginPage, driver, sa);
	
	emailInputFieldOnLoginPage.clear();
	emailInputFieldOnLoginPage.sendKeys(emailkeys);
	Thread.sleep(1000);	
	
}
	
public void enterPasswordInputField(String passwordkeys) throws InterruptedException
{
	Thread.sleep(1000);	
	AllVerifications.clickIfVisibleAndEnabled(passwordInputFieldOnLoginPage, driver, sa);
	passwordInputFieldOnLoginPage.sendKeys(passwordkeys);
	Thread.sleep(1000);	
}


public void clickOnEyeSymbolOnPassWordInputField() throws InterruptedException 
{
	Thread.sleep(1000);	
	AllVerifications.clickIfVisibleAndEnabled(EyeButtonOnPasswordInputField, driver, sa);
	Thread.sleep(1000);	
	
}

//i used the chat gpt code here 
public void clickOnLoginButtonInLoginInPage() throws InterruptedException {
	Thread.sleep(1000);	
	AllVerifications.clickIfVisibleAndEnabled(LoginButtonInLoginInPage, driver, sa);
	// 🔹 Handle alert 
	try {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    System.out.println("Login alert handled successfully!");
	} catch (Exception e) {
	    System.out.println("No alert found after login click");
	}

	// 🔹 WAIT for redirect page (instead of re-clicking login)
	new WebDriverWait(driver, Duration.ofSeconds(15))
	        .until(ExpectedConditions.titleContains("Dashboard"));

	  
	}
public void clickOnShopAllLinkTextFromUserDashBoradpage() throws InterruptedException 
{
	Thread.sleep(1000);	
	AllVerifications.clickIfVisibleAndEnabled(shopAllLinkTextFromUserDashBoardPage, driver, sa);
	
	Thread.sleep(1000);	
}
	
public void clickOnAddToCartButtonOverProductCardsOnFirstPage() throws InterruptedException
{
		
	int AddToCartButtonCount=addToCartButtonOverProductCardContainer.size();	
	for(int j=1;j<=AddToCartButtonCount;j++) 
	{
		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>h3"));
		WebElement AddToCartButtonOverProductCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(2)>button"));
	    Actions actions1=new Actions(driver);
	    actions1.scrollToElement(productCards).build().perform();
		actions1.scrollToElement(AddToCartButtonOverProductCards).build().perform();
		
	    System.out.println("Clicking On the add to cart button of :"+ productCards.getText());
	    AddToCartButtonOverProductCards.click();
	    Thread.sleep(1000);  
	     
	}
	 
}


public void clickOnAddToCartButtonOverProductCardsOnSecondPage() throws InterruptedException 
{
	secondPaginationButton.click();
	int AddToCartButtonCount=addToCartButtonOverProductCardContainer.size();	
	for(int j=1;j<=AddToCartButtonCount;j++) 
	{
		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>h3"));
		WebElement AddToCartButtonOverProductCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(2)>button"));
	    Actions actions1=new Actions(driver);
	    actions1.scrollToElement(productCards).build().perform();
		actions1.scrollToElement(AddToCartButtonOverProductCards).build().perform();
		
	    System.out.println("Clicking On the add to cart button of :"+ productCards.getText());
	    AddToCartButtonOverProductCards.click();
	    Thread.sleep(1000);  
	     
	}
	
}

public void clickOnAddToCartButtonOverProductCardsOnThirdPage() throws InterruptedException 
{
	 thirdPaginationButton.click();
	int AddToCartButtonCount=addToCartButtonOverProductCardContainer.size();	
	for(int j=1;j<=AddToCartButtonCount;j++) 
	{
		WebElement productCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>h3"));
		WebElement AddToCartButtonOverProductCards = driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+j+")>div:nth-of-type(3)>div:nth-of-type(2)>button"));
	    Actions actions1=new Actions(driver);
	    actions1.scrollToElement(productCards).build().perform();
		actions1.scrollToElement(AddToCartButtonOverProductCards).build().perform();
		
	    System.out.println("Clicking On the add to cart button of :"+ productCards.getText());
	    AddToCartButtonOverProductCards.click();
	    Thread.sleep(1000);  
	     
	}
	
}

public void clickOnAboutUsFromShopPage() throws InterruptedException
{

	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( aboutUs).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(aboutUs, driver, sa);
	Thread.sleep(1000);
}
public void clickOnContactUsFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( contactUs).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(contactUs, driver, sa);
	Thread.sleep(1000);
	
}
public void clickOnCareersFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(careers).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(careers, driver, sa);
	Thread.sleep(1000);
	
	
}
public void clickOnBlogsFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(blogs).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(blogs, driver, sa);
	Thread.sleep(1000);	
}
public void clickOnHelpCenterFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(helpCenter).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(helpCenter, driver, sa);
	Thread.sleep(1000);
}
public void clickOnPrivacyPolicyFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(privacyPolicy).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(privacyPolicy, driver, sa);
	Thread.sleep(1000);
}
public void clickOnTermsOfServiceFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(termsOfService).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(termsOfService, driver, sa);
	Thread.sleep(1000);
}
public void clickOnFacebookFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(faceBook).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(faceBook, driver, sa);
	Thread.sleep(1000);
}
public void clickOnLinkedInFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(linkedIn).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(linkedIn, driver, sa);
	Thread.sleep(1000);
}
public void clickOnTwitterFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(twitter).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(twitter, driver, sa);
	Thread.sleep(1000);
}
public void clickOnGithubFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(gitHub).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(gitHub, driver, sa);
	Thread.sleep(1000);
}
public void enterValueIntoEmailInputFieldFromShopPage(String keys) throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(enterEmailField).build().perform();
	
	AllVerifications.clickIfVisibleAndEnabled(enterEmailField, driver, sa);
	enterEmailField.clear();
	enterEmailField.sendKeys(keys);
	Thread.sleep(1000);
}
public void clickOnSubscribeButtonFromShopPage() throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(subscribeButton).build().perform();
	AllVerifications.clickIfVisibleAndEnabled(subscribeButton, driver, sa);
	Thread.sleep(1000);
}


public void verifyCompanyHeadingInFooterSectionOfShopPage(String expectedText) throws InterruptedException
{
	
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(companyHeading).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,companyHeading, sa);
	Thread.sleep(1000);
}

public void verifySupportHeadingInFooterSectionOfShopPage(String expectedText) throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(supportHeading).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,supportHeading, sa);
	Thread.sleep(1000);
	
}
public void verifyFollowUsHeadingInFooterSectionOfShopPage(String expectedText) throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(followUs).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,followUs, sa);
	Thread.sleep(1000);
	
}
public void verifySubscribeHeadingInFooterSectionOfShopPage(String expectedText) throws InterruptedException
{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(subscribeHeading).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,subscribeHeading, sa);
	Thread.sleep(1000);
	
}


public void verifyCopyWriteTextLeftSideBelowFooterOfShopPage(String expectedText) throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(copyWriteTextLeftSide).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,copyWriteTextLeftSide, sa);
	Thread.sleep(1000);
	
}
public void verifyCopyWriteTextRightSideBelowFooterOfShopPage(String expectedText) throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(copyWriteTextRightSide).build().perform();
	AllVerifications.textIsPresentOrNot(expectedText, driver,copyWriteTextRightSide, sa);
	Thread.sleep(1000);
	
}
public void verifyOurProductsHeading(String expectedText) throws InterruptedException
{
	Thread.sleep(1000);
JavascriptExecutor js =(JavascriptExecutor)driver; 
Actions actions=new Actions(driver);
actions.scrollToElement(ourProductsHeadingOnShopPage).build().perform();
AllVerifications.textIsPresentOrNot(expectedText, driver,ourProductsHeadingOnShopPage, sa);
Thread.sleep(1000);
}

public void verifyPresenceOfAllViews() throws InterruptedException
{
	Thread.sleep(1000);
JavascriptExecutor js =(JavascriptExecutor)driver; 
Actions actions=new Actions(driver);
actions.scrollToElement(CardView).build().perform();

Thread.sleep(1000);
}


public void VerifyCardViewIsSelectedByDefault() throws InterruptedException
{
	Thread.sleep(2000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(0, 1000);");
	Thread.sleep(1000);
	
	
}
public void adjustThePriceRangeSliderFromMinimumValue() throws InterruptedException

{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(leftButtonOfPriceRangeScale).build().perform();
	Thread.sleep(1000);
	AllVerifications_Anusha.dragSliderIfVisibleAndEnabled(leftButtonOfPriceRangeScale, 40, 0, driver, sa);
	Thread.sleep(1000);
	
}
public void fetchAllProductsComesUnderSelectedPriceRange()
{
	int allProductsCount=allProductContainer.size();
	System.out.println("Total products belonging to this price range are :"+ allProductsCount);
	
	//now find all the products name, sp,dp
	for(int i=1;i<=allProductsCount;i++)
	{
		
		// fetching products names
		WebElement	eachProductName=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>h3"));
		System.out.println("Products names "+eachProductName.getText());
	    
	    //fetching products selling price
	    WebElement	eachProductSellingPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:first-child"));
	    System.out.println("Selling Price "+eachProductSellingPrice.getText());
	    
	    //fetching products display price
	    WebElement	eachProductDisplayPrice=driver.findElement(By.cssSelector("div.grid:last-child>div.relative:nth-of-type("+i+")>div:nth-of-type(3)>div:nth-of-type(1)>span:last-child"));
	    System.out.println("Display Price "+eachProductDisplayPrice.getText());
	    
	}  	
}
public void adjustThePriceRangeSliderFromMaximumValue() throws InterruptedException

{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(rightButtonOfPriceRangeScale).build().perform();
	Thread.sleep(1000);
	AllVerifications_Anusha.dragSliderIfVisibleAndEnabled(rightButtonOfPriceRangeScale, -60, 0, driver, sa);
	Thread.sleep(1000);
	
}

public void adjustThePriceRangeSliderFromMinimumAndMaximumValues() throws InterruptedException

{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement(leftButtonOfPriceRangeScale).build().perform();
	Thread.sleep(1000);
	AllVerifications_Anusha.dragSliderIfVisibleAndEnabled(leftButtonOfPriceRangeScale, 40, 0, driver, sa);
	Thread.sleep(1000);

	actions.scrollToElement(rightButtonOfPriceRangeScale).build().perform();
	Thread.sleep(1000);
	AllVerifications_Anusha.dragSliderIfVisibleAndEnabled(rightButtonOfPriceRangeScale, -60, 0, driver, sa);
	Thread.sleep(1000);
	
}
public void verifyDeafultPriceValuesPresentBelowToPriceRangeScale() throws InterruptedException
{
	 Thread.sleep(1000);
     JavascriptExecutor js =(JavascriptExecutor)driver; 
     Actions actions=new Actions(driver);
     actions.scrollToElement(MinimumPricePresentBelowToPriceRangeScale).build().perform();
     WebElement	MinimumPriceMentionedBelowToPriceRangeScale=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(4)>div:last-child>div>span:first-child"));
     System.out.println("Default minimum price  is :"+MinimumPriceMentionedBelowToPriceRangeScale.getText());
     Thread.sleep(1000);
     
     WebElement	MaximumPriceMentionedBelowToPriceRangeScale=driver.findElement(By.cssSelector("div.space-y-6>div:nth-of-type(4)>div:last-child>div>span:last-child"));
     System.out.println("Default maximum price is "+MaximumPriceMentionedBelowToPriceRangeScale.getText());
     Thread.sleep(1000);
}

public void verifyPresenceAndEnabledStateOfpriceRangeScale() throws InterruptedException

{
	Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	Actions actions=new Actions(driver);
	actions.scrollToElement( priceRangeScaleBelowAllBrands).build().perform();
	Thread.sleep(1000);
	
	
}
public void verifyTheFooterSectionOfShoppage() throws InterruptedException
{
	JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	Thread.sleep(1000);
	
	
}
	
}









    
   


	

	
	//
	 
	

