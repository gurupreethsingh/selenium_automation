package homepage_normal_automation_gurupreeth;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O21_ClickEachBrand {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // === Read Homepage Data ===
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
            String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

            driver.get(websiteUrl);
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);

            // === Get all brand blocks ===
            List<WebElement> allBrands = driver.findElements(
                By.cssSelector("section.py-10.px-4.bg-gray-50 > div > div")
            );

            System.out.println("Total brands: " + allBrands.size());

            // === Click each brand one-by-one ===
            for (int i = 0; i < allBrands.size(); i++) {
                List<WebElement> brands = driver.findElements(
                    By.cssSelector("section.py-10.px-4.bg-gray-50 > div > div")
                );
                WebElement currentBrand = brands.get(i);
                String brandName = currentBrand.getText().trim();
                System.out.println("\n🔹 Clicking brand: " + brandName);

                // Scroll & click
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentBrand);
                Thread.sleep(500);
                currentBrand.click();
                Thread.sleep(2000);

                // === Title Check ===
                All_Verifications.verifyTitleMatch("Search-Products | ECODERS", driver, sa);

                // === URL Check ===
                String encodedBrand = URLEncoder.encode(brandName.trim(), StandardCharsets.UTF_8).replace("+", "%20");
                String actualUrl = driver.getCurrentUrl().trim();
                System.out.println("🌐 URL     : " + actualUrl);
                sa.assertTrue(actualUrl.toLowerCase().contains(("query=" + encodedBrand).toLowerCase()),
                    "❌ URL mismatch. Expected to contain: query=" + encodedBrand + ", Found: " + actualUrl);

                // === Heading Check ===
                String expectedHeading = "Results for \"" + brandName + "\"";
                try {
                    WebElement heading = driver.findElement(By.xpath("//div[@class='flex items-center justify-between mb-6']/h1"));
                    String actualHeading = heading.getText().trim();
                    System.out.println("📄 Heading : " + actualHeading);
                    System.out.println("🎯 Expect  : " + expectedHeading);
                    All_Verifications.verifyTextPresent(expectedHeading, driver, sa);
                } catch (Exception e) {
                    System.out.println("⚠️ Heading not found for: " + brandName);
                    sa.fail("Heading not found or mismatch for brand: " + brandName);
                }

                // Go back
                driver.navigate().back();
                Thread.sleep(2000);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            sa.fail("Test execution failed: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
            } catch (AssertionError ae) {
                ae.printStackTrace();
            } finally {
                if (driver != null) {
                    driver.quit();
                    System.out.println("\n✅ Browser closed.");
                }
            }
        }
    }
}
