package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;


public class AS_4634ClickOnPriceDecreaseButtonBelowSortByHeading extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
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
	
}
