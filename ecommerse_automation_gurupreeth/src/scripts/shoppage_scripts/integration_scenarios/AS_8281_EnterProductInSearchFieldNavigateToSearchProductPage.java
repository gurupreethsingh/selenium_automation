package scripts.shoppage_scripts.integration_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import generic.Excel;
import pom.Homepage;
import pom.ShopPage;

public class AS_8281_EnterProductInSearchFieldNavigateToSearchProductPage extends BaseClass_Anusha
{
	// open shop page using url and verify title
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openShoppageUsingUrl()
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		
		// enter product name in  search field and click on  search icon
		
		   ShopPage sp = new ShopPage(driver);
		   sp.enterValueInSearchField1("jungle book");
		   sp.clickOnSearchButton1();
		   
		// navigating to search product  page  and verify title
		   String expectedSearchProductTitle = (String)Excel_Anusha.getData("ShopPage", 2, 0); 
		   AllVerifications.verifyTitle(expectedSearchProductTitle, driver, sa);
		   
	
		// veriffy text 
		   String enteredText = "jungle book";
		   String expectedText = "Results for \"" + enteredText + "\"";
		sp.verifyProductNameInSearchProductPage(expectedText);
		
		
		
		
		
		
		
		
		
		
		
		
		
		sa.assertAll();
   }
	 

}
