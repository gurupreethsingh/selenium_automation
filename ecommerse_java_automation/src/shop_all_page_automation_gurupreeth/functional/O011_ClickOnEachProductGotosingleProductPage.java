//package shop_all_page_automation_gurupreeth.functional;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.asserts.SoftAssert;
//
//import excel_automation.O3_ReadFromExcel;
//import verification_methods.All_Verifications;
//
//public class O011_ClickOnEachProductGotosingleProductPage {
//
//	public static void main(String[] args) throws InterruptedException
//	{
//       WebDriver driver = null;     // selenium qa
//       SoftAssert sa = new SoftAssert();   // test ng
//
//       try
//       {
//    	 // open browser. (chrome)
//    	   driver= new ChromeDriver();
//    	   driver.manage().window().maximize();
//    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//    	 // enter the shop page url.
//    	   String websiteUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
//    	   driver.get(websiteUrl);
//    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//    	 // verify the title and url of the shopall page.
//    	   String actualTitle = driver.getTitle();
//    	   System.out.println("Actual title found  : " + actualTitle);
//    	   String actualUrl = driver.getCurrentUrl();
//    	   System.out.println("Actual Url found  : " + actualUrl);
//    	   All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
//    	   All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);
//
//    	   // find the parent division which holds all the products.
//
//          int productCount = driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative")).size();
//          System.out.println("Total products found : " + productCount);
//
//    	  JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    	  for (int i = 1; i <= productCount; i++)
//    	  {
//
//    		  WebElement productNameElement = driver.findElement(By.cssSelector(
//                      "div[style='opacity: 1; transform: none;']>div.grid>div.relative:nth-of-type(" + i + ")>div>h3"));
//    		  System.out.println("\n****************************************************************\n");
//                  System.out.println(i+". Clicking on product : " + productNameElement.getText());
//
//                  js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productNameElement);
//
//                  // Click the product
//                  WebElement productClickElement = driver.findElement(By.cssSelector(
//                      "div[style='opacity: 1; transform: none;']>div.grid>div.relative:nth-of-type(" + i + ")"));
//                  productClickElement.click();
//
//
//
//                  Thread.sleep(1000); // short wait for page transition
//
//       	   String actualSingleproductTitle = driver.getTitle();
//       	   System.out.println("Actual title found  : " + actualSingleproductTitle);
//       	   String actualSingleproductUrl = driver.getCurrentUrl();
//       	   System.out.println("Actual Url found  : " + actualSingleproductUrl);
//       	   String expectedSingleproductTitle = O3_ReadFromExcel.getData("SingleProductPage", 1, 1);
//       	   All_Verifications.verifyTitleMatch(expectedSingleproductTitle, driver, sa);
//
//           driver.navigate().back();
//           Thread.sleep(1000); // wait for shop page to reload
//
//    	  }
//
//             }
//       catch(Exception ex)
//       {
//    	   ex.printStackTrace();
//       }
//
//       finally {
//    	   Thread.sleep(2000);
//    	   driver.quit();
//       }
//
//	}
//}










package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O011_ClickOnEachProductGotosingleProductPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            String websiteUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            driver.get(websiteUrl);

            All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
            All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);

            int productCount = driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative")).size();
            System.out.println("Total products found : " + productCount);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            for (int i = 1; i <= productCount; i++) {
                System.out.println("\n****************************************************************");

                // Re-fetch product name
                WebElement productNameElement = driver.findElement(By.cssSelector(
                        "div[style='opacity: 1; transform: none;']>div.grid>div.relative:nth-of-type(" + i + ")>div>h3"));
                String productName = productNameElement.getText();
                System.out.println(i + ". Clicking on product : " + productName);

                String expectedProductName = productName;


                // Scroll product into center view
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productNameElement);
                Thread.sleep(500);

                // Re-fetch clickable element and use reusable click method
                WebElement productClickElement = driver.findElement(By.cssSelector(
                        "div[style='opacity: 1; transform: none;']>div.grid>div.relative:nth-of-type(" + i + ")"));

                All_Verifications.clickIfVisibleAndEnabled(productClickElement, driver, sa, productName);

                Thread.sleep(1000); // wait for single product page to load

                String actualTitle = driver.getTitle();
                String actualUrl = driver.getCurrentUrl();
                System.out.println("Actual title found  : " + actualTitle);
                System.out.println("Actual Url found    : " + actualUrl);

                String expectedTitle = O3_ReadFromExcel.getData("SingleProductPage", 1, 1);
                All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

                System.out.println("✅ Successfully clicked and verified product: " + productName);

                WebElement singleProductname = driver.findElement(By.cssSelector("div.w-full>h1.text-4xl"));
                String actualProductName = singleProductname.getText();
                 System.out.println("Actual product found in page : "+ actualProductName);
                 All_Verifications.verifyTextPresent(expectedProductName, driver, sa);

                // Go back to shop page and wait
                driver.navigate().back();
                Thread.sleep(1000);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            if (driver != null) {
				driver.quit();
			}
        }
    }
}

