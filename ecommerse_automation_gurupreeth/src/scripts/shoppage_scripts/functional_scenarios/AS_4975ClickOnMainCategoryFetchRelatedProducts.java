package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.BaseClass_Anusha.Excel_Anusha;
import pom.ShopPage;

public class AS_4975ClickOnMainCategoryFetchRelatedProducts extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
	public void testClickMainCategoryFetchRelatedProducts()
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
	    ShopPage sp = new ShopPage(driver);
	    int totalCategories=sp.findTotalCategoryCount();  //finding the main category count 
	    for(int i=1;i<=totalCategories;i++) 
	
	    {
		sp.clickOnMainCategory(i);
		sp.fetchAllProducts();
		System.out.println("\n****************************************************\n");
	    }
		
		
	}

}
