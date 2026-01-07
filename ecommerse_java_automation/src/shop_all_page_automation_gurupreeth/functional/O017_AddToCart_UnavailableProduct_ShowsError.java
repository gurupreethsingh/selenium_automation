package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O017_AddToCart_UnavailableProduct_ShowsError {

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

            // ✅ Find product card with 'Out of Stock' text
            List<WebElement> allProducts = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));

            boolean foundOutOfStock = false;

            for (int i = 1; i <= allProducts.size(); i++) {
                WebElement productCard = driver.findElement(By.cssSelector(
                        "div[style='opacity: 1; transform: none;']>div.grid>div.relative:nth-of-type(" + i + ")"));

                if (productCard.getText().toLowerCase().contains("out of stock")) {
                    foundOutOfStock = true;
                    System.out.println("Found out-of-stock product at position: " + i);

                    WebElement addToCartBtn = productCard.findElement(By.xpath(".//button[contains(text(),'Add to Cart')]"));
                    All_Verifications.clickIfVisibleAndEnabled(addToCartBtn, driver, sa, "Add to Cart (Out of Stock)");

                    Thread.sleep(2000); // Wait for toast to appear
                    WebElement toast = driver.findElement(By.cssSelector("div[class*='Toastify']"));
                    String toastMsg = toast.getText().toLowerCase();

                    sa.assertTrue(toastMsg.contains("out of stock"), "Out of stock toast is shown");
                    break;
                }
            }

            sa.assertTrue(foundOutOfStock, "At least one out-of-stock product should exist on the shop page.");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
