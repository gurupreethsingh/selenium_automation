package homepage_normal_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O14_ClickShopnowFromHeroSectionOpenShoppage {

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
            WebElement shopNowButton  = driver.findElement(By.xpath("//div[contains(@class,'carousel-item') and contains(@class,'active')]//a[@href='/shop']"));
            // use the verfication method to click on the shop now button
            All_Verifications.clickIfVisibleAndEnabled(shopNowButton, driver, sa, "Shop now");

            // now verifiy the title and url of the shop page.
            String expectedShopTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
            String expectedShopUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            All_Verifications.verifyTitleMatch(expectedShopTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedShopUrl, driver, sa);

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
