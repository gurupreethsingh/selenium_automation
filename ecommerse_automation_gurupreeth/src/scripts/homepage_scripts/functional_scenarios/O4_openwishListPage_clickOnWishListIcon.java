package scripts.homepage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class O4_openwishListPage_clickOnWishListIcon extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
	
	@Test(enabled = true, invocationCount = 1)
	public void clickOnWishListIcon() throws InterruptedException
	{
		String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		 
		Homepage hp = new Homepage(driver);
		hp.clickOnwishListIcon();
		
		String expectedWishListPageTitle = (String)Excel.getData("wishlistpage", 0, 0); 
		AllVerifications.verifyTitle(expectedWishListPageTitle, driver, sa);
		sa.assertAll();
	}
		
	
}
