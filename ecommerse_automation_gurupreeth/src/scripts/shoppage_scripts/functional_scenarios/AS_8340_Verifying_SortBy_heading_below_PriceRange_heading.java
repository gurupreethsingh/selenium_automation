package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;


public class AS_8340_Verifying_SortBy_heading_below_PriceRange_heading extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
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
	
}
