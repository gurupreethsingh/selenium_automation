package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O002_open_shopallpage_clickShopall_link_inHeader {

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


    	   // click on shop all link.

    	   WebElement shopAllLink = driver.findElement(By.cssSelector("a[href='/shop']"));

    	   All_Verifications.clickIfVisibleAndEnabled(shopAllLink, driver, sa,  "Shop All Link");
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    	   String expectedShoppageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
    	   String expectedShoppageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
    	   All_Verifications.verifyTitleMatch(expectedShoppageTitle, driver, sa);

    	   All_Verifications.verifyUrleMatch(expectedShoppageUrl, driver, sa);
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
