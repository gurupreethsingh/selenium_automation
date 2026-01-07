//package homepage_normal_automation_gurupreeth;
//
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.asserts.SoftAssert;
//
//public class O7_OpenSearchpageWithAllInputs {
//
//    public static void main(String[] args) {
//        WebDriver driver = null;
//        SoftAssert sa = new SoftAssert();
//
//        String[] testInputs = {
//            "iPhone 14", "iPho", "IPHONE", "iPhone@2023", "   Laptop  ",
//            "Peenut laddu", "Galaxy S22", "2023", "Samsung", "Logitech",
//            "", "     ", "asdkjhfksdjf", "<script>alert('x')</script>",
//            "####", "'; DROP TABLE products;--", "fastentry",
//            "refresh test", "disabled input", "js-injection-test"
//        };
//
//        try {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//            for (String input : testInputs) {
//                System.out.println("\n=== 🔍 Testing input: '" + input + "' ===");
//
//                // Step 1: Open homepage
//                driver.get("http://localhost:5173");
//
//                // Step 2: Enter search text
//                WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));
//                searchField.clear();
//                searchField.sendKeys(input);
//
//                // Step 3: Click the search button
//                WebElement searchButton = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
//                searchButton.click();
//
//                // Step 4: Wait and validate
//                Thread.sleep(2000);
//                String actualUrl = driver.getCurrentUrl().trim();
//                String actualTitle = driver.getTitle().trim();
//                String expectedPart = URLEncoder.encode(input.trim(), StandardCharsets.UTF_8).replace("+", "%20");
//
//
//                // 📋 Print title + URL for every input
//                System.out.println("🌐 URL     : " + actualUrl);
//                System.out.println("📄 Title   : " + actualTitle);
//
//                // Step 5: Validation
//                if (input.trim().isEmpty()) {
//                    boolean noRedirect = !actualUrl.contains("/search-products?query=");
//                    sa.assertTrue(noRedirect,
//                        "Should NOT redirect for blank input: '" + input + "'. URL: " + actualUrl);
//                } else {
//                    boolean matches = actualUrl.contains("/search-products?query=" + expectedPart);
//                    sa.assertTrue(matches,
//                        "URL mismatch for input '" + input + "'. Expected to contain: " + expectedPart + ", Found: " + actualUrl);
//                }
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            sa.fail("Test execution failed: " + ex.getMessage());
//        } finally {
//            try {
//                sa.assertAll();
//            } catch (AssertionError ae) {
//                ae.printStackTrace();
//            } finally {
//                if (driver != null) {
//                    driver.quit();
//                    System.out.println("\nBrowser closed.");
//                }
//            }
//        }
//    }
//}


package homepage_normal_automation_gurupreeth;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import verification_methods.All_Verifications;

public class O7_OpenSearchpageWithAllInputs {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        String[] testInputs = {
            "iPhone 14", "iPho", "IPHONE", "iPhone@2023", "   Laptop  ",
            "Peenut laddu", "Galaxy S22", "2023", "Samsung", "Logitech",
            "", "     ", "asdkjhfksdjf", "<script>alert('x')</script>",
            "####", "'; DROP TABLE products;--", "fastentry",
            "refresh test", "disabled input", "js-injection-test"
        };

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            for (String input : testInputs) {
                System.out.println("\n=== 🔍 Testing input: '" + input + "' ===");

                // Step 1: Open homepage
                driver.get("http://localhost:5173");

                // Step 2: Enter search text
                WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));
                searchField.clear();
                searchField.sendKeys(input);

                // Step 3: Click the search button
                WebElement searchButton = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
                searchButton.click();

                // Step 4: Wait and validate
                Thread.sleep(2000);
                String actualUrl = driver.getCurrentUrl().trim();
                String actualTitle = driver.getTitle().trim();
                String expectedPart = URLEncoder.encode(input.trim(), StandardCharsets.UTF_8).replace("+", "%20");

                // 📋 Print title + URL
                System.out.println("🌐 URL     : " + actualUrl);
                System.out.println("📄 Title   : " + actualTitle);

                if (input.trim().isEmpty()) {
                    boolean noRedirect = !actualUrl.contains("/search-products?query=");
                    sa.assertTrue(noRedirect,
                        "❌ Should NOT redirect for blank input: '" + input + "'. URL: " + actualUrl);
                } else {
                    boolean matches = actualUrl.contains("/search-products?query=" + expectedPart);
                    sa.assertTrue(matches,
                        "❌ URL mismatch for input '" + input + "'. Expected to contain: " + expectedPart + ", Found: " + actualUrl);

                    // ✅ Verify dynamic heading
                    String expectedHeading = "Results for \"" + input.trim() + "\"";
                    try {
                        WebElement heading = driver.findElement(By.xpath("//div[@class='flex items-center justify-between mb-6']/h1"));
                        String actualHeading = heading.getText().trim();

                        // Print both expected and actual heading
                        System.out.println("Expected Heading: " + expectedHeading);
                        System.out.println("Actual Heading  : " + actualHeading);
                    } catch (Exception e) {
                        System.out.println("Could not locate <h1> element on the page.");
                    }

                    // Also verify using your reusable method
                    All_Verifications.verifyTextPresent(expectedHeading, driver, sa);
                }
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
