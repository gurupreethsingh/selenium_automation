package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O020_VerifyWishlistIconStateToggle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Step 1: Open Shop page (ensure user is logged in before this test)
            String shopPageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            driver.get(shopPageUrl);

            All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
            All_Verifications.verifyUrleMatch(shopPageUrl, driver, sa);

            // Step 2: Locate the wishlist icon on the first product
            WebElement wishlistBtn = driver.findElement(By.cssSelector(
                    "div[style='opacity: 1; transform: none;'] > div.grid > div.relative:nth-of-type(1) button"));

            // Step 3: Get initial icon state (class or svg fill or tooltip)
            String beforeState = wishlistBtn.getAttribute("class");
            System.out.println("Before toggle class: " + beforeState);

            // Step 4: Click wishlist icon
            All_Verifications.clickIfVisibleAndEnabled(wishlistBtn, driver, sa, "Wishlist Toggle Button");
            Thread.sleep(2000);

            // Step 5: Get updated icon state
            String afterState = wishlistBtn.getAttribute("class");
            System.out.println("After toggle class: " + afterState);

            // Step 6: Verify state has changed
            sa.assertNotEquals(afterState, beforeState, "Wishlist icon should change state on toggle");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
