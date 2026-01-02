package scripts.shoppage_scripts.integration_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.BaseClass_Anusha.Excel_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;

public class AS_5246_Add_product_to_cart_fromShop_page extends BaseClass_Anusha
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openShoppageUsingUrl() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",1,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		
//		find add to cart button on any product and click on it
		
		ShopPage sp = new ShopPage(driver);
		
		String productClickedText = sp.verifyProductName();
		
		sp.clickOnAddToCartButton();
		
		Thread.sleep(6000);
		
		TakingScreenshot.captureScreenshot(driver);
		
// find the cart icon from header and  go click on cart icon
		
	sp.clickOnCartIcon();
	Thread.sleep(2000);
		
	TakingScreenshot.captureScreenshot(driver);	
	
	// verifyingthe productname in minicart
	
	sp.verifyProductNameInMinicart(productClickedText);
	
	
	sp.clickOnViewCartButtonOFMiniCart();
	
	//cart page  hardcoded here. 
	String cartPageExpectedTitle ="Cart | ECODERS";
	
	AllVerifications.verifyTitle(cartPageExpectedTitle, driver, sa);
	
	Thread.sleep(2000);
	
	WebElement  ProductTextInCartPage = driver.findElement(By.cssSelector("h2.text-lg"));
	String actualProductTextxInCartPage = ProductTextInCartPage.getText();
	
	System.out.println(actualProductTextxInCartPage);
	
	
	AllVerifications.textIsPresentOrNot("TechPro Tablet X15", driver, ProductTextInCartPage, sa);
		
		sa.assertAll(); 
   }

}
