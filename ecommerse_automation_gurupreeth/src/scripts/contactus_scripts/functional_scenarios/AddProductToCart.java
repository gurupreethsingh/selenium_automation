package scripts.contactus_scripts.functional_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.BaseClass_Shilpa;
import generic.TakingScreenshot;
import generic.BaseClass_Anusha.Excel_Anusha;

public class AddProductToCart extends BaseClass_Anusha {
	
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openShoppageUsingUrl() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		

		WebElement addToCartBtn = driver.findElement(By.cssSelector("div.relative:nth-of-type(1)>div.p-4>div.pt-3>button"));
		AllVerifications.clickIfVisibleAndEnabled(addToCartBtn, driver, sa);
		Thread.sleep(500);
		
		TakingScreenshot.captureScreenshot(driver);
		
		WebElement cartIcon = driver.findElement(By.cssSelector("div.relative:nth-of-type(1)>div.p-4>div.pt-3>button"));
		
	
		
		
		
   }

}
