package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O016_WishlistToggle_UnloggedUser_ShowsLoginToast {

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

            // Click wishlist icon on first product as unlogged user
            WebElement firstWishlistIcon = driver.findElement(By.cssSelector(
                "div[style='opacity: 1; transform: none;'] > div.grid > div.relative:nth-of-type(1) button svg"));

            All_Verifications.clickIfVisibleAndEnabled(firstWishlistIcon, driver, sa, "Wishlist Icon (Guest)");

            Thread.sleep(2000); // Wait for toast message to appear

            // Verify toast message text (adjust this if your toast is not inside the page DOM)
            WebElement toastMsg = driver.findElement(By.cssSelector("div[class*='Toastify']"));
            String toastText = toastMsg.getText().toLowerCase();

            System.out.println("Toast text: " + toastText);
            sa.assertTrue(toastText.contains("please log in") || toastText.contains("login"),
                    "Toast should indicate login is required");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
