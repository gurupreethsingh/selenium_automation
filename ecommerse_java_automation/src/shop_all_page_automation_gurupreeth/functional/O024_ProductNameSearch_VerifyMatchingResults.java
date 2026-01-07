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

public class O024_ProductNameSearch_VerifyMatchingResults {

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

            String searchTerm = "phone"; // Change this to an existing product keyword
            WebElement searchInput = driver.findElement(By.cssSelector("input[type='search'], input[placeholder*='Search']"));
            All_Verifications.verifyAndTypeInputField(driver, searchInput, searchTerm, "Search Input", sa);

            Thread.sleep(2000); // Wait for filtering

            List<WebElement> productNames = driver.findElements(By.cssSelector("div.relative h3"));

            sa.assertTrue(productNames.size() > 0, "Search results are shown");

            for (WebElement product : productNames) {
                String name = product.getText().toLowerCase();
                sa.assertTrue(name.contains(searchTerm), "Product name contains search term: " + name);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
