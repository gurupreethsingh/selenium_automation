package homepage_normal_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O5_OpenShoppageClickShopAllLink {

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

            // === Locate shop Link ===
//            WebElement shopLink = driver.findElement(By.xpath("//a[text()='SHOP ALL' and @href='/shop']"));
            WebElement shopLink = driver.findElement(By.cssSelector("a[href='/shop']"));

            // === Click on ECOMMERSE Link if ready ===
            All_Verifications.clickIfVisibleAndEnabled(shopLink, driver, sa, "SHOP ALL");

            // === Post-click: Verify URL or Title again ===
            String expectedShopTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
            String expectedShopUrl   = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            All_Verifications.verifyTitleMatch(expectedShopTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedShopUrl, driver, sa);

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
