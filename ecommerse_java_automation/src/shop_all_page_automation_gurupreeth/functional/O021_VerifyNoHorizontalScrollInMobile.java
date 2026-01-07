package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O021_VerifyNoHorizontalScrollInMobile {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();

            // ✅ Resize to simulate mobile screen
            driver.manage().window().setSize(new Dimension(375, 812)); // iPhone X dimensions
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            String shopPageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            driver.get(shopPageUrl);

            All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
            All_Verifications.verifyUrleMatch(shopPageUrl, driver, sa);

            // ✅ Check for horizontal scroll
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Long scrollX = (Long) js.executeScript("return window.scrollX;");

            System.out.println("Horizontal scroll position: " + scrollX);
            sa.assertEquals(scrollX.longValue(), 0L, "Page should not scroll horizontally on mobile");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
