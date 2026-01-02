package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.Homepage;
import pom.ShopPage;


public class AS_7322_clickOnAvatarFromShopPage extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
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
	
}
