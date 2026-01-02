package scripts.shoppage_scripts.functional_scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Anusha;
import pom.ShopPage;


public class ClickOnEachCategryOneByOne extends BaseClass_Anusha 
{
SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openShoppageUsingUrl() throws InterruptedException
   {
		String expectedShoppageTitle = (String)Excel_Anusha.getData("ShopPage",0,0);
		AllVerifications.verifyTitle(expectedShoppageTitle, driver, sa);
		
		//verifying CATEGORIES haeding below clear filter button 
        String expectedText = "CATEGORIES";
	    ShopPage sp = new ShopPage(driver);
	    sp.verifyCategoriesHeadingBelowClearFilterButton(expectedText);
		
//		sp.verifyNumberOfMainCategories();
		// not getting number of categories in pom class ------------> doubt
		// verifying number of main categories
		 List<WebElement> allCategoriesCount=driver.findElements(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div"));  //findElements-->multiple elements
		 int allMainCategoryCount =allCategoriesCount.size();
		 System.out.println("Total number of main categories  found:"+allMainCategoryCount);
//		// fetching each main categories name and clciking on each category 
		for(int i=1;i<=allMainCategoryCount;i++) 
		{
		WebElement mainCategories = driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+i+")>div>span:first-child")); 
		String mainCategoriesText=mainCategories.getText();
		System.out.println("Name of main category is :"+ mainCategoriesText);
		WebElement clickingOnMainCategories = driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+i+")>div>span:first-child"));
		AllVerifications.clickIfVisibleAndEnabled(clickingOnMainCategories, driver, sa);
		Thread.sleep(1000);
		
		WebElement clickingOnMainCategoriesDropDownOpen = driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+i+")>div>span:last-child"));
		AllVerifications.clickIfVisibleAndEnabled(clickingOnMainCategoriesDropDownOpen, driver, sa);
		Thread.sleep(1000);
		
	    List<WebElement>subCategoriescount=driver.findElements(By.cssSelector("div.pl-4>div.text-sm"));
	    int subCategoryCount=subCategoriescount.size();
	    System.out.println("Number of SubCategories in "+ mainCategoriesText+ " is:"+ subCategoryCount);
	    for(int j=1;j<=subCategoryCount;j++)
	    {
	    List<WebElement> subCategoriesText=driver.findElements(By.cssSelector("div.pl-4>div.text-sm:nth-of-type("+j+")")); 
		System.out.println("Sub categories of " + mainCategoriesText+ " is "+ subCategoriesText);
		
		 WebElement subCategories= driver.findElement(By.cssSelector("div.pl-4>div.text-sm:nth-of-type("+j+")"));
		AllVerifications.clickIfVisibleAndEnabled(subCategories, driver, sa);
		Thread.sleep(1000);
	    }
		
		WebElement clickingOnMainCategoriesDropDownClose = driver.findElement(By.cssSelector("div.py-10>div>div.rounded-xl>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-child("+i+")>div>span:last-child"));
		AllVerifications.clickIfVisibleAndEnabled(clickingOnMainCategoriesDropDownClose, driver, sa);
		Thread.sleep(1000);
		
		}
		
	//	sp.clickOnMainCategoryDropDownFromShopPage(); 
//		sp.verifyMainCategoryName();
//		sp.clickOnMainCategoryFromShopPage();
//		sp.clickOnMainCategoryDropDownFromShopPage();
		sp.clickONClearFilterButton();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		sa.assertAll();
		
		
		
		
		
		
		
   }

}
