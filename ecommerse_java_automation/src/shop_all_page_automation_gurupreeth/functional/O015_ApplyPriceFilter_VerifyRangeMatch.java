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

public class O015_ApplyPriceFilter_VerifyRangeMatch {

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

            // ✅ Apply price filter (assumes input sliders or range buttons)
            WebElement priceRangeBtn = driver.findElement(By.cssSelector("button[data-range='1000-5000']")); // Adjust selector
            All_Verifications.clickIfVisibleAndEnabled(priceRangeBtn, driver, sa, "Price Range Button");

            Thread.sleep(3000); // Wait for product list to refresh

            List<WebElement> products = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;'] > div.grid > div.relative"));

            int totalFiltered = products.size();
            System.out.println("Filtered products count: " + totalFiltered);
            sa.assertTrue(totalFiltered > 0, "Price filtered products are shown");

            for (int i = 1; i <= totalFiltered; i++) {
                WebElement priceEl = driver.findElement(By.cssSelector(
                        "div[style='opacity: 1; transform: none;'] > div.grid > div.relative:nth-of-type(" + i + ") div span.text-xl"));

                String priceText = priceEl.getText().replaceAll("[^0-9]", "").trim();
                if (!priceText.isEmpty()) {
                    int price = Integer.parseInt(priceText);
                    sa.assertTrue(price >= 1000 && price <= 5000,
                            "Price " + price + " is within range 1000–5000 for product #" + i);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
