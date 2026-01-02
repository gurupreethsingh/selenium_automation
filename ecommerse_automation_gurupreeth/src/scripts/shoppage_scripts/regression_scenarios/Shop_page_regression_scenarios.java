package scripts.shoppage_scripts.regression_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import generic.BaseClass_Anusha.Excel_Anusha;
import pom.ShopPage;

public class Shop_page_regression_scenarios extends BaseClass_Anusha
{
	SoftAssert sa = new SoftAssert();
	@Test(enabled = true, priority = 1)
	   public void openShoppageUsingUrl()
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
	   }
		
	@Test(enabled = true, priority = 2)
	   public void clickOnLogoFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnlogoFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",1,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	
	@Test(enabled = true, priority = 3)
	   public void clickOnShopAllLinkTextFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnShopAllLinkTextFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 4)
	   public void clickOnWishlistFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnwishlistFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",3,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 5)
	   public void clickOnCartIconFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnCartFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 6)
	   public void clickOnAvatarFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnAvatarFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",4,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	
	@Test(enabled = true, priority = 7)
	   public void clickOnSignInFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnSignInFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",4,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 8)
	   public void enterValueIntoSearchFieldFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			   sp.EnterValueInSearchField("pen");
			   sp.clickOnSearchButton();		
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",2,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }

	@Test(enabled = true, priority =  9)
   public void testShoppageShouldReloadClickOnShopAllLinkTextFromShopPage() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnShopAllLinkTextFromShopPage();
		
		
		String expectedShopPageTitleAfterClick = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShopPageTitleAfterClick, driver, sa);
		sa.assertAll();
   }

	@Test(enabled = true, priority = 10)
   public void testVerifyPresenceOfAllThreeViews() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		
		ShopPage sp = new ShopPage(driver);
		sp.verifyPresenceOfAllViews();
		TakingScreenshot.captureScreenshot(driver);
		sa.assertAll();
		
   }
	@Test(enabled = true, priority = 11)
	   public void clickOnCardViewFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnCardViewFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
		
	@Test(enabled = true, priority = 12)
	   public void clickOnGridViewFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnGridViewFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 13)
	   public void clickOnListViewFromShopPage() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnListViewFromShopPage();
			
			
			String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			sa.assertAll();
	   }
	@Test(enabled = true, priority = 14)
	   public void testPresenceUIPropertiesEnabledStateOfClearFilterButton() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			ShopPage sp = new ShopPage(driver);
		
			sp.verifySortByHeadingBelowPriceRange("SORT BY");
			TakingScreenshot.captureScreenshot(driver);
			
	   }
	@Test(enabled = true, priority = 15)
	   public void testVerifyingPresenceUI_PropertiesoOfCategoriesHeadingBelowClearFilterButton() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			  
			String expectedText = "CATEGORIES";
			ShopPage sp = new ShopPage(driver);
			
			
			sp.verifyCategoriesHeadingBelowClearFilterButton(expectedText);
			TakingScreenshot.captureScreenshot(driver);
			
	   }
	
	@Test(enabled = true, priority = 16)
	public void testClickOnMainCategoryDropDownAndDisplayItsSubCategories() throws InterruptedException
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		int totalCategories=sp.findTotalCategoryCount(); 
		for(int k=1;k<=totalCategories;k++) 
		{
			sp.clickOnDropDownOfMainCategoryOPEN(k);
			
		}
	}
	@Test(enabled = true, priority = 17)
	public void testClickMainCategoryFetchRelatedProducts()
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
	    ShopPage sp = new ShopPage(driver);
	    int totalCategories=sp.findTotalCategoryCount();  //finding the main category count 
	    for(int i=1;i<=totalCategories;i++) 
	
	    {
		sp.clickOnMainCategory(i);
		sp.fetchAllProducts();
		System.out.println("\n****************************************************\n");
	    }
	}
	
	@Test(enabled = true, priority = 18)
	public void testCountNumberOfSubCategoriesOfThatMainCategory() throws InterruptedException
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		int totalCategories=sp.findTotalCategoryCount(); 
		
		for(int k=1;k<=totalCategories;k++) 
		{
			sp.clickOnDropDownOfMainCategoryOPEN(k);
		 sp.countNumberOfSubCategoriesOfThatMainCategory();
			
	
		}
	}
	@Test(enabled = true, priority = 19)
	public void testClickOnTheSubCategory_FetchTheProductsBelongingToSubCategories() throws InterruptedException
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		int totalCategories=sp.findTotalCategoryCount(); //------->
		
		for(int k=1;k<=totalCategories;k++) 
		{
			sp.clickOnDropDownOfMainCategoryOPEN(k);
			System.out.println("\n");
			 sp.countNumberOfSubCategoriesOfThatMainCategory();
			 System.out.println("\n");
			 int totalSubCategories=sp.countNumberOfSubCategoriesOfThatMainCategory();
			for(int p=1;p<=totalSubCategories;p++) 
			{
				sp.fetchTheNameOfSubCatAndClick(p);
				TakingScreenshot.captureScreenshot(driver);
				sp.fetchAllProductsBelongsToSubCategory();
				System.out.println("*******************************");
				
			}
			sp.clickOnDropDownOfMainCategoryCLOSE(k);
			System.out.println("*******************************");
			System.out.println("\n");
		}	
}
	@Test(enabled = true, priority = 20)
	   public void testVerifyingBRANDSHeadingBelowcategoriesheading() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			String expectedText = "BRANDS";
			ShopPage sp = new ShopPage(driver);
			sp.verifyBrandsHeadingBelowCategoriesHeading(expectedText);
			TakingScreenshot.captureScreenshot(driver);
	   }
	@Test(enabled = true, priority = 21)
	   public void testVerifyingAllBrandsSubHeadingBelowToBrandsHeading() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			  
			String expectedText = "ALL BRANDS";
			ShopPage sp = new ShopPage(driver);
			
			
			sp.verifyAllBrandsSubHeadingBelowBrandsHeading(expectedText);
			TakingScreenshot.captureScreenshot(driver);
//			sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
//			Thread.sleep(1000);
//			sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
//			sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
			Thread.sleep(1000);	
	   }

	@Test(enabled = true, priority = 22)
   public void testClickOnAllBrandsSubHeadingBelowToBrandsHeading() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		  
		
		ShopPage sp = new ShopPage(driver);
	
		sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
		Thread.sleep(1000);
		TakingScreenshot.captureScreenshot(driver);
		sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
		Thread.sleep(1000);	
   }
	@Test(enabled = true, priority = 23)
	 public void testClickOnAllBrandsDropDownBelowToBrandsHeading() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			  
			
			ShopPage sp = new ShopPage(driver);
			sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
			Thread.sleep(1000);
			TakingScreenshot.captureScreenshot(driver);
			sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
			Thread.sleep(1000);
	   }
	
@Test(enabled = true, priority = 24)
public void testClickOnCheckBoxesOfAllBrandsSection() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			ShopPage sp = new ShopPage(driver);
			sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
			sp.clickOnCheckBoxOfAnyBrands();
			TakingScreenshot.captureScreenshot(driver);
	
	   }
@Test(enabled = true, priority = 25)
 public void testVerifyingPriceRangeHeadingBelowAllBrandsHeading() throws InterruptedException
	   {
			String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
			AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
			sa.assertAll();
			
			String expectedText = "PRICE RANGE";
			ShopPage sp = new ShopPage(driver);
			sp.verifyPriceRangeHeadingBelowAllBrandsHeading(expectedText);
			TakingScreenshot.captureScreenshot(driver);
			
	   }
@Test(enabled = true, priority = 26)
public void testAdjustTheLeftHandleOfPriceRangeSlider() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		  
		
		ShopPage sp = new ShopPage(driver);
	
		sp.adjustThePriceRangeSliderFromMinimumValue();
		Thread.sleep(2000);
		sp.fetchAllProductsComesUnderSelectedPriceRange();
//		TakingScreenshot.captureScreenshot(driver);
	
}

@Test(enabled = true, priority = 27)
public void testAdjustTheRightHandleOfPriceRangeSlider() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		  
		
		ShopPage sp = new ShopPage(driver);
	
		sp.adjustThePriceRangeSliderFromMaximumValue();
		Thread.sleep(2000);
		sp.fetchAllProductsComesUnderSelectedPriceRange();
//		TakingScreenshot.captureScreenshot(driver);
	
}
@Test(enabled = true, priority = 28)
public void testAdjustThePriceRangeSlidersFromBothSides () throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		ShopPage sp = new ShopPage(driver);
		sp.adjustThePriceRangeSliderFromMinimumAndMaximumValues();
		Thread.sleep(2000);
		sp.fetchAllProductsComesUnderSelectedPriceRange();
		
}
@Test(enabled = true, priority = 29)
public void testAdjustThePriceRangeSlidersFromBothSidesAndClickOnClearFilterButton () throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		ShopPage sp = new ShopPage(driver);
		sp.adjustThePriceRangeSliderFromMinimumAndMaximumValues();
		Thread.sleep(500);
		sp.fetchAllProductsComesUnderSelectedPriceRange();
		Thread.sleep(1000);
	sp.clickONClearFilterButtonAfterApplyingPriceRangeFilter();
	Thread.sleep(1000);
//		
}
@Test(enabled = true, priority = 30)
public void testVerifyingSortByHeadingBelowAllBrands()
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		String expectedText = "SORT BY";
		ShopPage sp = new ShopPage(driver);
		sp.verifySortByHeadingBelowPriceRange(expectedText);
		TakingScreenshot.captureScreenshot(driver);
		
}
@Test(enabled = true, priority = 31)
public void testVerifyPresenceEnabledStateOfAllOptionsPresentsBelowToSortByHeading() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
	
		sp.verifyAllOptionsWhichBelongsToSortBySection();
		TakingScreenshot.captureScreenshot(driver);	
}

@Test(enabled = true, priority = 32)
public void testVerifyDefaultButtonIsSelectedByDeafultAndHighlighted() throws InterruptedException
{
	String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
	AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
	sa.assertAll();
	
	ShopPage sp = new ShopPage(driver);

	sp.verifyAllOptionsWhichBelongsToSortBySection();
	System.out.println("All products are sorted in a default manner ");
	TakingScreenshot.captureScreenshot(driver);
	
	
	
}

@Test(enabled = true, priority = 33)
public void testClickOnPriceIncreaseButtonBelowSortByHeading() throws InterruptedException
{
	String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
	AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
	sa.assertAll();
	
	ShopPage sp = new ShopPage(driver);
	sp.clickONClearFilterButton();
	sp.clickOnPriceIncreaseButtonBelowSortByHeading();
	Thread.sleep(1000);
	TakingScreenshot.captureScreenshot(driver);
	sp.fetchAllProductsComesUnderSelectedPriceRange();
	sp.clickOnSecondPaginationButton();
	sp.fetchAllProductsComesUnderSelectedPriceRange();
	sp.clickOnThirdPaginationButton();
	sp.fetchAllProductsComesUnderSelectedPriceRange();
	System.out.println("\n All products are sorted according to ascending order in their price\n ");
}
@Test(enabled = true, priority = 34)
public void testClickOnPriceDecreaseButtonBelowSortByHeading() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
	
		ShopPage sp = new ShopPage(driver);
		sp.clickONClearFilterButton();
		sp.clickOnPriceDecreaseButtonBelowSortByHeading();
		Thread.sleep(1000);
		TakingScreenshot.captureScreenshot(driver);
		sp.fetchAllProductsComesUnderSelectedPriceRange();
		sp.clickOnSecondPaginationButton();
		sp.fetchAllProductsComesUnderSelectedPriceRange();
		sp.clickOnThirdPaginationButton();
		sp.fetchAllProductsComesUnderSelectedPriceRange();
		System.out.println("\n All products are sorted according to descending order in their price\n ");
}
@Test(enabled = true, priority = 35)
public void testClickOnPriceNewestButtonBelowSortByHeading() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickONClearFilterButton();
		sp.clickOnNewestButtonBelowSortByHeading();
		TakingScreenshot.captureScreenshot(driver);
}
@Test(enabled = true, priority = 36)
public void testClickOnPriceOldestButtonBelowSortByHeading() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickONClearFilterButton();
		sp.clickOnOldestButtonBelowSortByHeading();
		TakingScreenshot.captureScreenshot(driver);
}
@Test(enabled = true, priority = 37)
public void testClickOnCheckBoxOfAnyBrandsAndClickOnClearFilter() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		  
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
		sp.clickOnCheckBoxOfAnyBrands();
		TakingScreenshot.captureScreenshot(driver);
		sp.clickONClearFilterButton();
	
		TakingScreenshot.captureScreenshot(driver);
		
		
}
@Test(enabled = true, priority = 38)
public void testClickOnCardViewFromShopPage() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		
		sp.clickOnCardViewFromShopPage();
		
		
		String expectedHomepageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		sa.assertAll();
}
@Test(enabled = true, priority =39)
public void testClickOnEachProductCardAndVerifyTitleAndProdcutName() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnEachProductCardsOnFirstPage();
     sp.clickOnEachProductCardsOnSecondPage();  //-->Im getting element click intercepted exception so i used  chat gpt ocde 
		sp.clickOnEachProductCardsOnThirdPage();
}
@Test(enabled = true, priority = 40)
public void ClickOnFirstPagination() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnFirstPaginationButton();
}
@Test(enabled = true, priority = 41)
public void testClickOnSecondPagination() throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		ShopPage sp = new ShopPage(driver);
		sp.clickOnSecondPaginationButton();
}
@Test(enabled = true, priority = 42)
public void testClickOnThirdPagination () throws InterruptedException
{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnThirdPaginationButton();
}
	
}
		
	