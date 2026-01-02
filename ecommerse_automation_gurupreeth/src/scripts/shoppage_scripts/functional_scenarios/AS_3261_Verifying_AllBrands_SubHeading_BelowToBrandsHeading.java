package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;


public class AS_3261_Verifying_AllBrands_SubHeading_BelowToBrandsHeading extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void testVerifyingAllBrandsSubHeadingBelowToBrandsHeading() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		  
		String expectedText = "ALL BRANDS";
		ShopPage sp = new ShopPage(driver);
		
		
		sp.verifyAllBrandsSubHeadingBelowBrandsHeading(expectedText);
		TakingScreenshot.captureScreenshot(driver);
//		sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
//		Thread.sleep(1000);
//		sp.clickOnAllBrandsSubHeadingBelowBrandsHeading();
//		sp.clickOnDropDownOfAllBrandsSubHeadingBelowBrandsHeading();
		Thread.sleep(1000);
		
		
   }
	
}
