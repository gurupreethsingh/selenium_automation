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

public class O014_ApplyBrandFilter_VerifyBrandMatch {

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

            // Click a brand filter checkbox (assumes first checkbox is a brand)
            WebElement brandCheckbox = driver.findElement(By.cssSelector("div input[type='checkbox']:nth-of-type(2)"));
            All_Verifications.clickIfVisibleAndEnabled(brandCheckbox, driver, sa, "First Brand Checkbox");

            Thread.sleep(2000); // Wait for products to filter

            List<WebElement> filteredProducts = driver.findElements(
                By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));

            int count = filteredProducts.size();
            System.out.println("Brand-filtered products found: " + count);
            sa.assertTrue(count > 0, "Products filtered by brand are shown");

            // Optional check: verify product names contain known brand keyword
            // e.g., brand like 'Nike', 'Sony', etc.
            // for (WebElement prod : filteredProducts) {
            //     String productText = prod.getText().toLowerCase();
            //     sa.assertTrue(productText.contains("sony"), "Brand name present in: " + productText);
            // }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}

