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

public class O18_ClickEachCatogory {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Read Homepage Data
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
            String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

            // Open Website
            driver.get(websiteUrl);
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);

            // Fetch category count info
            List<WebElement> allCategoryNames = driver.findElements(
                By.cssSelector("section.py-10.px-4.bg-white > div:nth-of-type(2) > div > div")
            );
            System.out.println("Total categories: " + allCategoryNames.size());

            WebElement categoryCountText = driver.findElement(By.xpath("//div[@class='flex justify-between items-center mb-6']/span"));
            String expectedCategoryCount = "Showing 6 of " + allCategoryNames.size() + " categories";
            All_Verifications.verifyTextPresent(expectedCategoryCount, driver, sa);

            // === Click each category one-by-one ===
            for (int i = 0; i < allCategoryNames.size(); i++) {
                // Re-fetch categories each time
                List<WebElement> categories = driver.findElements(
                    By.cssSelector("section.py-10.px-4.bg-white > div:nth-of-type(2) > div > div")
                );
                WebElement currentCategory = categories.get(i);
                String categoryName = currentCategory.getText().trim();
                System.out.println("\nClicking category: " + categoryName);

                // Scroll into view & click
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentCategory);
                Thread.sleep(500);
                currentCategory.click();
                Thread.sleep(2000);

                // Verify search page title
                All_Verifications.verifyTitleMatch("Search-Products | ECODERS", driver, sa);

                // === URL Validation (case-sensitive fix) ===
                String encodedQuery = URLEncoder.encode(categoryName.trim(), StandardCharsets.UTF_8).replace("+", "%20");
                String actualUrl = driver.getCurrentUrl().trim();
                System.out.println("URL     : " + actualUrl);
                sa.assertTrue(actualUrl.toLowerCase().contains(("query=" + encodedQuery).toLowerCase()),
                    "URL mismatch. Expected to contain: query=" + encodedQuery + ", Found: " + actualUrl);

                // === Heading Validation ===
                String expectedHeading = "Results for \"" + categoryName + "\"";
                try {
                    WebElement heading = driver.findElement(By.xpath("//div[@class='flex items-center justify-between mb-6']/h1"));
                    String actualHeading = heading.getText().trim();
                    System.out.println("Heading : " + actualHeading);
                    System.out.println("Expect  : " + expectedHeading);
                    All_Verifications.verifyTextPresent(expectedHeading, driver, sa);
                } catch (Exception e) {
                    System.out.println("⚠️ Heading not found for: " + categoryName);
                    sa.fail("Heading not found or mismatch for category: " + categoryName);
                }

                // Go back to homepage
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
                    System.out.println("\n Browser closed.");
                }
            }
        }
    }
}
