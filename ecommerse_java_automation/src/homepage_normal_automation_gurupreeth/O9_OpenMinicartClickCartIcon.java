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

public class O9_OpenMinicartClickCartIcon {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            // === Setup ===
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // === Read Data from Excel ===
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);

            // === Open Homepage ===
            driver.get(websiteUrl);
            System.out.println("Navigated to: " + websiteUrl);

            // === Verify Homepage Title ===
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

            // === Locate cart icon Link ===
//            WebElement cartIcon = driver.findElement(By.xpath("//div[@class='relative'][1]/button"));
            WebElement cartIcon = driver.findElement(By.cssSelector("div.relative:nth-of-type(1) > button"));
            // === Click on ECOMMERSE Link if ready ===
            All_Verifications.clickIfVisibleAndEnabled(cartIcon, driver, sa, "cartIcon");

// take screenshot to see if the minicart is open or not.
            TakeScreenshot.getScreenshot(driver);

        } catch (Exception ex) {
            ex.printStackTrace();
            sa.fail("Test execution failed due to an exception: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
            } catch (AssertionError ae) {
                ae.printStackTrace();
            } finally {
                try {
                    if (driver != null) {
                        driver.quit();
                        System.out.println("Browser closed successfully.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to close browser.");
                }
            }
        }

    }
}
