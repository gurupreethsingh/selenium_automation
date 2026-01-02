package scripts.homepage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class O3_OpenShopPageByClickinShopAllLinkHompage extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, invocationCount = 1)
	public void clickOnShopAllLinkFromHomepage()
	{
		
		String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		
		Homepage hp = new Homepage(driver);
		hp.clickOnshopAllLink();
		
		String expectedShoppageTitle = (String)Excel.getData("ShopAllPage", 0, 0); 
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
	}
}
