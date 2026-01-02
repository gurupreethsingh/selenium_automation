package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.ShopPage;


public class AS_9194_clickOnAboutUsFromShopPage extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openShoppageUsingUrl() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnAboutUsFromShopPage();
		
		String expectedAboutUspageTitle = (String)Excel_Anusha.getData("ShopPage",7,0);
		AllVerifications.verifyTitle(expectedAboutUspageTitle, driver, sa);
		sa.assertAll();
		
//		sp.clickOnShopAllLinkTextFromUserDashBoradpage();
		
		
		
		
		
		
		
		
   }
	
}
