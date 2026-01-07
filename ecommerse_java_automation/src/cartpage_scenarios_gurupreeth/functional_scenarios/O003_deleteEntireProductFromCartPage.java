package cartpage_scenarios_gurupreeth.functional_scenarios;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O003_deleteEntireProductFromCartPage {

	public static void main(String[] args)
	{
       WebDriver driver = null ;
       SoftAssert sa  = new SoftAssert();

       try
       {
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


           // shop page.
           String shoppageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
           String expectedShoppageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
           driver.get(shoppageUrl);
           System.out.println("Navigated to: " + expectedShoppageTitle);
           All_Verifications.verifyTitleMatch(expectedShoppageTitle, driver, sa);
           // add to cart.

           WebElement carPhone = driver.findElement(By.cssSelector("div.relative:nth-of-type(2)>div:last-child>div:last-child>button"));

           WebElement carPhonePrice = driver.findElement(By.cssSelector("div.relative:nth-of-type(2)>div:last-child>div>span:first-child"));

           String price = carPhonePrice.getText();

           int productPrice = Integer.parseInt(price);

           System.out.println(productPrice);

           Scanner sc = new Scanner(System.in);
           System.out.println("Enter the time you want to add the first product");
           int firstProductQuantity = sc.nextInt();

           // get the price and get the quantity of the product added using loop.

           for ( int i=1; i<= firstProductQuantity ; i++)
           {
        	   All_Verifications.clickIfVisibleAndEnabled(carPhone, driver, sa, "car Phone");
           }


           int subTotalProductOne = productPrice * firstProductQuantity;

           System.out.println("Product sub total is  : " + subTotalProductOne);


           int grandTotal = subTotalProductOne;
           System.out.println("Grand total is  : " +  grandTotal);

//           // === Read Data from Excel ===
           String cartpageUrl = O3_ReadFromExcel.getData("Cartpage", 1, 2);
           String expectedCartpageTitle = O3_ReadFromExcel.getData("Cartpage", 1, 1);
//
//           // === Open Homepage ===
           driver.get(cartpageUrl);
           System.out.println("Navigated to: " + cartpageUrl);
//
           All_Verifications.verifyTitleMatch(expectedCartpageTitle, driver, sa);
//
//           // click on cart icon and open minicart.
//           WebElement cartIcon = driver.findElement(By.cssSelector("button.relative"));
//           All_Verifications.clickIfVisibleAndEnabled(cartIcon, driver, sa, "Cart Icon");
//



           // click on delete button.
           WebElement deleteIcon = driver.findElement(By.cssSelector("main>div>div>div:first-child>div:last-child>button"));
         All_Verifications.clickIfVisibleAndEnabled(deleteIcon, driver, sa, "Delete Icon");


       WebElement cartEmptyMessage = driver.findElement(By.cssSelector("main>div>div>h2"));
       String cartEmptyMessageText = cartEmptyMessage.getText();
       System.out.println("Actual text : " + cartEmptyMessageText);
       All_Verifications.verifyTextPresent("Your cart is empty!" , driver, sa);

       }
       catch(Exception ex)
       {
    	   ex.printStackTrace();
       }
       finally
       {
    	   driver.quit();
       }
	}
}
