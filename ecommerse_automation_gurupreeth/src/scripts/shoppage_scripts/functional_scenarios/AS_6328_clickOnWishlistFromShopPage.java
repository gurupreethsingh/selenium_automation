package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.Homepage;
import pom.ShopPage;


public class AS_6328_clickOnWishlistFromShopPage extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
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
	
}
