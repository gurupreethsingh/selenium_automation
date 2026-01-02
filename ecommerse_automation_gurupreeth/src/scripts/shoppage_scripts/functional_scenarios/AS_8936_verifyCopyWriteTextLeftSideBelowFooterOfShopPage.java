package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;

import pom.ShopPage;


public class AS_8936_verifyCopyWriteTextLeftSideBelowFooterOfShopPage extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void testVerifyCopyWriteTextLeftSideBelowFooterOfShopPage() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.verifyCopyWriteTextLeftSideBelowFooterOfShopPage("© 2025 Ecoders, Inc. All rights reserved.");
		TakingScreenshot.captureScreenshot(driver);
		
//		String expectedFacebookpageTitle = (String)Excel_Anusha.getData("ShopPage",14,0);
//		AllVerifications.verifyTitle(expectedFacebookpageTitle, driver, sa);
//		sa.assertAll();
		
   }
	
}
