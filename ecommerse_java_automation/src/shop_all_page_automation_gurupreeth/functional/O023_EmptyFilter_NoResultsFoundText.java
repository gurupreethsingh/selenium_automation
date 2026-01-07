package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O023_EmptyFilter_NoResultsFoundText {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            String shopPageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            driver.get(shopPageUrl);

            All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
            All_Verifications.verifyUrleMatch(shopPageUrl, driver, sa);

            // Apply an unlikely filter combo (manually choose checkboxes known to return 0)
            WebElement firstCat = driver.findElement(By.cssSelector("div input[type='checkbox']:first-of-type"));
            WebElement lastBrand = driver.findElement(By.cssSelector("div input[type='checkbox']:nth-of-type(10)")); // example
            All_Verifications.clickIfVisibleAndEnabled(firstCat, driver, sa, "Category Filter");
            All_Verifications.clickIfVisibleAndEnabled(lastBrand, driver, sa, "Brand Filter");

            Thread.sleep(2000);

            // Verify message shown
            WebElement emptyMessage = driver.findElement(By.xpath("//*[contains(text(),'no products found')]"));
            All_Verifications.verifyIfElementVisibleAndEnabled(emptyMessage, driver, sa, "No products found message");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
