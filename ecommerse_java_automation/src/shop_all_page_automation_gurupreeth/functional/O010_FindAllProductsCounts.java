package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O010_FindAllProductsCounts {

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

    	   // find the parent division which holds all the products.
    	  List<WebElement> productDiv =  driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));
    	  int actualCount = productDiv.size();
    	  System.out.println("Total products found : "+ actualCount);

    	  WebElement displyCountText = driver.findElement(By.cssSelector("div.w-full>div.flex.items-center>div.flex.items-center.gap-2>span"));

    	  System.out.println(displyCountText.getText());
    	  String expectedCountText = "("+actualCount+" items)";

    	  All_Verifications.verifyTextPresent(expectedCountText, driver, sa);

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
