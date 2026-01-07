package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O022_AnimatedToast_ShownOnWishlistToggle {

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

            WebElement wishlistIcon = driver.findElement(By.cssSelector(
                "div[style='opacity: 1; transform: none;'] > div.grid > div.relative:nth-of-type(1) button"));

            All_Verifications.clickIfVisibleAndEnabled(wishlistIcon, driver, sa, "Wishlist Icon Toggle");

            Thread.sleep(2000); // Wait for toast to appear

            WebElement animatedToast = driver.findElement(By.cssSelector("div[class*='bg-gradient-to-r']"));
            String toastText = animatedToast.getText().toLowerCase();
            System.out.println("Animated toast text: " + toastText);

            sa.assertTrue(toastText.contains("added") || toastText.contains("removed"),
                "Toast should confirm wishlist action");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
