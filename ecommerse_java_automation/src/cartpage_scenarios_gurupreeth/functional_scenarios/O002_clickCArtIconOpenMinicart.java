package cartpage_scenarios_gurupreeth.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O002_clickCArtIconOpenMinicart {

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

           All_Verifications.verifyTitleMatch(expectedCartpageTitle, driver, sa);

           // click on cart icon and open minicart.
           WebElement cartIcon = driver.findElement(By.cssSelector("button.relative"));
           All_Verifications.clickIfVisibleAndEnabled(cartIcon, driver, sa, "Cart Icon");

           WebElement cartSummary = driver.findElement(By.cssSelector("div.absolute>h2"));
           String actualCartSummeryText = cartSummary.getText();
           System.out.println("Actual text : " + actualCartSummeryText);

           All_Verifications.verifyTextPresent("Cart Summary" , driver, sa);

           WebElement cartEmptyMessage = driver.findElement(By.cssSelector("div.absolute>div>p"));
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
