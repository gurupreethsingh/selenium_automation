package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.ShopPage;


public class AS_9194_loginFromShoppage extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void testSignInFromShopPage() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnSignInFromShopPage();
		sp.enterEmailInputField("xyz@gmail.com");
		sp.enterPasswordInputField("abc123ABC!@#");
		sp.clickOnEyeSymbolOnPassWordInputField();
		sp.clickOnEyeSymbolOnPassWordInputField();
		sp.clickOnLoginButtonInLoginInPage();
		sp.clickOnLoginButtonInLoginInPage();
		
		String expectedUserDashBoradpageTitle = (String)Excel_Anusha.getData("ShopPage",6,0);
		AllVerifications.verifyTitle(expectedUserDashBoradpageTitle, driver, sa);
		sa.assertAll();
		
		sp.clickOnShopAllLinkTextFromUserDashBoradpage();
		
		
		
		
		
		
		
		
   }
	
}
