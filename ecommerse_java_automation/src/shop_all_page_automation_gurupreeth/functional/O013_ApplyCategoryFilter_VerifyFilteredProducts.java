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

public class O013_ApplyCategoryFilter_VerifyFilteredProducts {

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

            //Click on first available category check box
            WebElement categoryCheckbox = driver.findElement(By.cssSelector("div input[type='checkbox']:first-of-type"));
            All_Verifications.clickIfVisibleAndEnabled(categoryCheckbox, driver, sa, "First Category Checkbox");

            Thread.sleep(2000); // Wait for filter to apply

            // Get product count from visible grid
            List<WebElement> filteredProducts = driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));
            int filteredCount = filteredProducts.size();
            System.out.println("Filtered product count after applying category: " + filteredCount);

            sa.assertTrue(filteredCount > 0, "Products filtered by category are visible");

            WebElement countText = driver.findElement(By.cssSelector("div.flex.items-center.gap-2>span"));
            String expectedText = "(" + filteredCount + " items)";
            All_Verifications.verifyTextPresent(expectedText, driver, sa);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
