package homepage_normal_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import screenshots.TakeScreenshot;
import verification_methods.All_Verifications;

public class O15_ClickAllThreeIndicatorButtons {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Read URL and Expected Title from Excel
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
            String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

            // Open Website
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Verify Title
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

            All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);

            // find the shop now button which is active then click on it.
            for(int i =1 ; i <= 3; i++)
            {
                WebElement indicatorButtons  = driver.findElement(By.xpath("//div[@class='carousel-indicators']/button["+i+"]"));
                // use the verfication method to click on the shop now button
                All_Verifications.clickIfVisibleAndEnabled( indicatorButtons, driver, sa, " indicatorButtons");
                // now verifiy the title and url of the shop page.
                TakeScreenshot.getScreenshot(driver);
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Final assert to report any soft assertion failures
            sa.assertAll();

            if (driver != null) {
                driver.quit();
            }
        }
    }
}
