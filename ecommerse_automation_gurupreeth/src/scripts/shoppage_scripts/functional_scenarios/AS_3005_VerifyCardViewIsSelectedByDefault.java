package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;


public class AS_3005_VerifyCardViewIsSelectedByDefault extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void testVerifyCardIsSelectedByDefault() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		
		ShopPage sp = new ShopPage(driver);
		TakingScreenshot.captureScreenshot(driver);
		
		sp.VerifyCardViewIsSelectedByDefault();
		sa.assertAll();
   }
	
}
