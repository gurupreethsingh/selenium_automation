package cartpage_scenarios_gurupreeth.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O001_openCartPageUsingUrl {

	public static void main(String[] args)
	{
       WebDriver driver = null ;
       SoftAssert sa  = new SoftAssert();

       try
       {
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           // === Read Data from Excel ===
           String cartpageUrl = O3_ReadFromExcel.getData("Cartpage", 1, 2);
           String expectedCartpageTitle = O3_ReadFromExcel.getData("Cartpage", 1, 1);

           // === Open Homepage ===
           driver.get(cartpageUrl);
           System.out.println("Navigated to: " + cartpageUrl);

           // === Verify Homepage Title ===
           String expectedCartpageUrl = "http://localhost:5173/cart";
           All_Verifications.verifyTitleMatch(expectedCartpageTitle, driver, sa);
           All_Verifications.verifyUrleMatch(expectedCartpageUrl, driver, sa);

           WebElement cartHeading = driver.findElement(By.cssSelector("div>h1.text-3xl"));
           String actualCartHeadingText = cartHeading.getText();

           All_Verifications.verifyTextPresent("Your Cart" , driver, sa);
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
