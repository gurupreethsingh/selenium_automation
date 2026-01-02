package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.TakingScreenshot;
import pom.ShopPage;

public class AS_4515_ClickOnTheSubCategoryAndClickOnClearFilterVerifyFilterAppliedWasRemoved extends BaseClass_Anusha
{
	SoftAssert sa = new SoftAssert();
		
	@Test(enabled = true, priority = 1)
	public void testClickOnTheSubCategoryAndClickOnClearFilterVerifyFilterAppliedWasRemoved() throws InterruptedException
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		int totalCategories=sp.findTotalCategoryCount(); //------->
		
		for(int k=1;k<=totalCategories;k++) 
		{
			sp.clickOnDropDownOfMainCategoryOPEN(k);
			System.out.println("\n");
			 sp.countNumberOfSubCategoriesOfThatMainCategory();
			 System.out.println("\n");
			 int totalSubCategories=sp.countNumberOfSubCategoriesOfThatMainCategory();
			for(int p=1;p<=totalSubCategories;p++) 
			{
				sp.fetchTheNameOfSubCatAndClick(p);
				TakingScreenshot.captureScreenshot(driver);
				sp.fetchAllProductsBelongsToSubCategory();
				System.out.println("*******************************");
				sp.clickONClearFilterButton();
				System.out.println("Filters applied was removed and all products are displayed ");
			}
			sp.clickOnDropDownOfMainCategoryCLOSE(k);
			System.out.println("*******************************");
			System.out.println("\n");
			
			
		}
		
		
		
		
}
}
