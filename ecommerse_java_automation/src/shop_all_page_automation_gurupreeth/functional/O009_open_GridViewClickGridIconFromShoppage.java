package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import screenshots.TakeScreenshot;
import verification_methods.All_Verifications;

public class O009_open_GridViewClickGridIconFromShoppage {

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

    	   // click on grid icon.
    	   WebElement gridIcon = driver.findElement(By.cssSelector("div.flex.items-center.gap-2>div.flex.gap-2.ml-3>button:first-child"));
    	   All_Verifications.clickIfVisibleAndEnabled(gridIcon, driver, sa,  "gridIcon");
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	   TakeScreenshot.getScreenshot(driver);
    	   Thread.sleep(1000);

    	   // click on grid icon.
    	   WebElement cardIcon = driver.findElement(By.cssSelector("div.flex.items-center.gap-2>div.flex.gap-2.ml-3>button:nth-of-type(2)"));
    	   All_Verifications.clickIfVisibleAndEnabled(cardIcon, driver, sa,  "cardIcon");
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	   TakeScreenshot.getScreenshot(driver);
    	   Thread.sleep(1000);

    	   // click on grid icon.
    	   WebElement listIcon = driver.findElement(By.cssSelector("div.flex.items-center.gap-2>div.flex.gap-2.ml-3>button:last-child"));
    	   All_Verifications.clickIfVisibleAndEnabled(listIcon , driver, sa,  "listIcon");
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	   TakeScreenshot.getScreenshot(driver);
    	   Thread.sleep(1000);
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
