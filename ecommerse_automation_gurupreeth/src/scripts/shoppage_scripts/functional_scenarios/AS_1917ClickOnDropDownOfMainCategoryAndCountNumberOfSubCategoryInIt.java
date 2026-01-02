package scripts.shoppage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.ShopPage;

public class AS_1917ClickOnDropDownOfMainCategoryAndCountNumberOfSubCategoryInIt extends BaseClass_Anusha
{
	SoftAssert sa = new SoftAssert();
		
	@Test(enabled = true, priority = 1)
	public void testCountNumberOfSubCategoriesOfThatMainCategory() throws InterruptedException
	{
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		sa.assertAll();
		
		ShopPage sp = new ShopPage(driver);
		int totalCategories=sp.findTotalCategoryCount(); 
		
		for(int k=1;k<=totalCategories;k++) 
		{
			sp.clickOnDropDownOfMainCategoryOPEN(k);
		 sp.countNumberOfSubCategoriesOfThatMainCategory();
			
	
		}
		
		
		
}
}
