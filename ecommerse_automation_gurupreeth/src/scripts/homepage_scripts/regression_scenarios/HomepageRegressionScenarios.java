package scripts.homepage_scripts.regression_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class HomepageRegressionScenarios extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openHomepageUsingUrl()
   {
		String expectedHomepageTitle = (String)Excel.getData("Homepage",0,0);
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		sa.assertAll();
   }
	
	
	
	@Test(enabled = true, priority = 4)
	   public void clickOneEachProductOneByOne() throws InterruptedException
	   {
		   JavascriptExecutor js =(JavascriptExecutor)driver;     //typecasting-->downcasting
		// scrolling to particular element
			WebElement heading = driver.findElement(By.cssSelector("section.mt-16>div:first-child>h2"));  //findElement-->only one element
			Actions actions=new Actions(driver);
			actions.scrollToElement(heading).build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 String Heading= heading.getText();
			 System.out.println("Heading of the product section is :"+Heading);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			   
		//finding all the product count 
			 List<WebElement> allProduct=driver.findElements(By.cssSelector("div#brandProductsCarousel>div"));  //findElements-->multiple elements
			 int allProductCount =allProduct.size();
			 System.out.println("Total number of products found:"+allProductCount);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Scroll to each product
			 for(int i=1;i<=allProductCount;i++)
		{
			 WebElement eachProduct= driver.findElement(By.cssSelector(" div#brandProductsCarousel>div:nth-of-type("+i+")"));   //findElement-->only one element
			 actions.scrollToElement(eachProduct).build().perform();
			 String expectedProductNameHomePage=eachProduct.getText().trim();
			 
			 System.out.println("Clicking on :"+expectedProductNameHomePage);
		//clicking on each product
			 AllVerifications.clickIfVisibleAndEnabled(eachProduct, driver , sa);  //navigating to single-product page 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 System.out.println(driver.getTitle());    //verify title
			 System.out.println(driver.getCurrentUrl());  //verify currentUrl
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//verify the heading of the product in single product page 
			WebElement expectedProductNameInSingleProductPage= driver.findElement(By.cssSelector("h1.text-4xl"));
		    String expectedProductNameTextSingleProductPage=expectedProductNameInSingleProductPage.getText();
		    AllVerifications.textIsPresentOrNot(expectedProductNameTextSingleProductPage, driver, expectedProductNameInSingleProductPage, sa);
		    
		    driver.navigate().back();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
		    
		    sa.assertAll();
	      }
	   }
	
	
	
	@Test(enabled = true, priority = 2)
    public void findAllButtonsInHomepage() throws InterruptedException
    {
    	   // Use a locator so we can pass it to the verifier
        By BUTTONS = By.tagName("button");

        // (Optional) grab current snapshot to log texts
        List<WebElement> allButtons = driver.findElements(BUTTONS);
        System.out.println("Total buttons in the page : " + allButtons.size());

        for(int i = 0; i < allButtons.size(); i++) 
        { 
        	String eachButtonText = allButtons.get(i).getText(); 
             System.out.println(eachButtonText); 
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

        // ✅ Call the new helper that waits until the count == expected
        AllVerifications.verifyTotalNumberOfElements(11, driver, BUTTONS, sa);
    }
	
	@Test(enabled = true, priority = 3)
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
	
	@Test(enabled = true, priority = 5)
	public void clickOnSignInLink() throws InterruptedException
	{
		String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		 
		Homepage hp = new Homepage(driver);
		hp.clickOnSignInLink();
		
		String expectedLoginInPageTitle = (String)Excel.getData("LoginPage", 0, 0); 
		AllVerifications.verifyTitle(expectedLoginInPageTitle, driver, sa);
		sa.assertAll();
	}	
	
	
	@Test(enabled = true, priority = 6)
	   public void enterTextIntoSearchField()
	   {
			String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
			AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
			 
		   Homepage hp = new Homepage(driver);
		   hp.enterValueInSearchField("pen");
		   hp.clickOnSearchButton();
		   
		   String expectedSearchProductTitle = (String)Excel.getData("searchproductpage", 0, 0); 
		   AllVerifications.verifyTitle(expectedSearchProductTitle, driver, sa);
		  
	   }
	
	
	
}
