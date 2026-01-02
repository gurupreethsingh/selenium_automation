package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.Homepage;
import pom.ShopPage;


public class AS_8340_VerifyPresence_UI_PropertiesOfSortByHeadingPresentBelowToPriceRangeSection extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void testPresenceUIPropertiesEnabledStateOfClearFilterButton() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		TakingScreenshot.captureScreenshot(driver);
		sp.clickONClearFilterButton();
		
		
		
   }
	
}
