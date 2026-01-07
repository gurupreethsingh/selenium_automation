package homepage_normal_automation_gurupreeth;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O24_ClickEachProduct {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
            String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

            driver.get(websiteUrl);
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);

            // Get all product blocks
            List<WebElement> allProducts = driver.findElements(By.xpath("//section[@class='mt-16 mb-16 relative']/div[2]/div/div"));
            System.out.println("Total products found: " + allProducts.size());

            for (int i = 0; i < allProducts.size(); i++) {
                List<WebElement> productList = driver.findElements(By.xpath("//section[@class='mt-16 mb-16 relative']/div[2]/div/div"));

                WebElement product = productList.get(i);
                String productText = product.getText().split("\n")[0].trim();
                System.out.println("\n Clicking product: " + productText);

                // Scroll into view and force click via JS
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
                Thread.sleep(500);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
                Thread.sleep(2000);

                // Verify we're on single product page
                All_Verifications.verifyTitleMatch("Single-Product | ECODERS", driver, sa);

                String productPageUrl = driver.getCurrentUrl();
                System.out.println(" Product URL: " + productPageUrl);

                Pattern pattern = Pattern.compile("/single-product/([a-zA-Z0-9]+)");
                Matcher matcher = pattern.matcher(productPageUrl);
                if (matcher.find()) {
                    System.out.println(" Product ID in URL: " + matcher.group(1));
                    sa.assertTrue(true);
                } else {
                    System.out.println(" Product ID not found in URL.");
                    sa.fail("Product URL did not contain expected ID pattern.");
                }

                driver.navigate().back();
                Thread.sleep(2000);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            sa.fail("Test failed due to exception: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
            } catch (AssertionError ae) {
                ae.printStackTrace();
            } finally {
                if (driver != null) {
                    driver.quit();
                    System.out.println("\n Browser closed.");
                }
            }
        }
    }
}
