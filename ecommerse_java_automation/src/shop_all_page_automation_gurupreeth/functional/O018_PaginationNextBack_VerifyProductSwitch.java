package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O018_PaginationNextBack_VerifyProductSwitch {

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

            // Step 1: Capture product titles from page 1
            List<WebElement> productsPage1 = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative h3"));

            List<String> productNamesPage1 = new ArrayList<>();
            for (WebElement product : productsPage1) {
                productNamesPage1.add(product.getText().trim());
            }

            System.out.println("Captured products on page 1: " + productNamesPage1);

            // Step 2: Click pagination link to page 2
            WebElement nextPageBtn = driver.findElement(By.cssSelector("ul.pagination li:last-child button"));
            All_Verifications.clickIfVisibleAndEnabled(nextPageBtn, driver, sa, "Pagination Next Button");

            Thread.sleep(3000); // Wait for page switch

            // Step 3: Capture product titles from page 2
            List<WebElement> productsPage2 = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative h3"));

            List<String> productNamesPage2 = new ArrayList<>();
            for (WebElement product : productsPage2) {
                productNamesPage2.add(product.getText().trim());
            }

            System.out.println("Captured products on page 2: " + productNamesPage2);

            // Step 4: Compare lists
            boolean isDifferent = !productNamesPage1.equals(productNamesPage2);
            sa.assertTrue(isDifferent, "Products should differ between page 1 and page 2");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
