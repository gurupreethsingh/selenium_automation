package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O008_VerifyOurProductsTextInShopAllPage {

	public static void main(String[] args) throws InterruptedException
	{
       WebDriver driver = null;     // selenium qa
       SoftAssert sa = new SoftAssert();   // test ng

       try
       {
    	 // open browser. (chrome)
    	   driver= new ChromeDriver();
    	   driver.manage().window().maximize();
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    	 // enter the shop page url.
    	   String websiteUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
    	   driver.get(websiteUrl);
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    	 // verify the title and url of the shopall page.
    	   String actualTitle = driver.getTitle();
    	   System.out.println("Actual title found  : " + actualTitle);
    	   String actualUrl = driver.getCurrentUrl();
    	   System.out.println("Actual Url found  : " + actualUrl);
    	   All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
    	   All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);

    	   String expectedText = "Our Products";

    	   WebElement actualHeadingText = driver.findElement(By.cssSelector("h1[class='text-3xl font-extrabold text-gray-800']"));
    	    //  .flex-grow.container.py-6>div>div:last-child>div>h1
    	   String actualText = actualHeadingText.getText();
    	   System.out.println("Actual text found : " + actualText);

    	   All_Verifications.verifyTextPresent(expectedText, driver, sa);

             }
       catch(Exception ex)
       {
    	   ex.printStackTrace();
       }

       finally {
    	   Thread.sleep(2000);
    	   driver.quit();
       }

	}
}
