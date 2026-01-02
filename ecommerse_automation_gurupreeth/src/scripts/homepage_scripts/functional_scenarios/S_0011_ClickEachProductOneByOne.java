//package scripts.homepage_scripts.functional_scenarios;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import generic.AllVerifications;
//import generic.OpenClose;
//
//public class S_0011_ClickEachProductOneByOne extends OpenClose
//{
//    SoftAssert sa = new SoftAssert();	
//
//   @Test
//   public void clickOneEachProductOneByOne() throws InterruptedException
//   {
//	   JavascriptExecutor js =(JavascriptExecutor)driver;     //typecasting-->downcasting
//	// scrolling to particular element
//		WebElement heading = driver.findElement(By.cssSelector("section.mt-16>div:first-child>h2"));  //findElement-->only one element
//		Actions actions=new Actions(driver);
//		actions.scrollToElement(heading).build().perform();
//		Thread.sleep(4000);
//		 String Heading= heading.getText();
//		 System.out.println("Heading of the product section is :"+Heading);
//		 Thread.sleep(4000);
//		   
//	//finding all the product count 
//		 List<WebElement> allProduct=driver.findElements(By.cssSelector("div#brandProductsCarousel>div"));  //findElements-->multiple elements
//		 int allProductCount =allProduct.size();
//		 System.out.println("Total number of products found:"+allProductCount);
//		 Thread.sleep(2000);
//	//Scroll to each product
//		 for(int i=1;i<=allProductCount;i++)
//	{
//		 WebElement eachProduct= driver.findElement(By.cssSelector(" div#brandProductsCarousel>div:nth-of-type("+i+")"));   //findElement-->only one element
//		 actions.scrollToElement(eachProduct).build().perform();
//		 String expectedProductNameHomePage=eachProduct.getText().trim();
//		 
//		 System.out.println("Clicking on :"+expectedProductNameHomePage);
//	//clicking on each product
//		 AllVerifications.clickIfVisibleAndEnabled(eachProduct, driver , sa);  //navigating to single-product page 
//		 Thread.sleep(3000);
//		 System.out.println(driver.getTitle());    //verify title
//		 System.out.println(driver.getCurrentUrl());  //verify currentUrl
//		 Thread.sleep(3000);
//	//verify the heading of the product in single product page 
//		WebElement expectedProductNameInSingleProductPage= driver.findElement(By.cssSelector("h1.text-4xl"));
//	    String expectedProductNameTextSingleProductPage=expectedProductNameInSingleProductPage.getText();
//	    AllVerifications.textIsPresentOrNot(expectedProductNameTextSingleProductPage, driver, expectedProductNameInSingleProductPage, sa);
//	    
//	    driver.navigate().back();
//	    Thread.sleep(3000);  
//	    
//	    sa.assertAll();
//      }
//   }
//}


package scripts.homepage_scripts.functional_scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.OpenClose;
import pom.Homepage;
import pom.SingleProductPage;

public class S_0011_ClickEachProductOneByOne extends OpenClose
{
    SoftAssert sa = new SoftAssert();	

   @Test
   public void clickOneEachProductOneByOne() throws InterruptedException
   {
	   JavascriptExecutor js =(JavascriptExecutor)driver;     //typecasting-->downcasting
		WebElement heading = driver.findElement(By.cssSelector("section.mt-16>div:first-child>h2"));  //findElement-->only one element

		Homepage hp = new Homepage(driver);
		hp.verifyexploreProductHeadingText();
		   
	   int allProductCount = 	hp.countAllProductText();
	   System.out.println(allProductCount);
	   SingleProductPage sp = new SingleProductPage(driver);
	   sp.findAllProductsAndClickOneByOne();
       
   }
}

