package hms_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateUserRoles {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // === Step 1: Login as Admin ===
        driver.get("http://your-app-url.com/login"); // Replace with actual login page URL
        driver.findElement(By.id("email")).sendKeys("admin@gmail.com"); // or superadmin
        driver.findElement(By.id("password")).sendKeys("abc123ABC!@#");
        driver.findElement(By.id("loginButton")).click(); // Update ID as needed

        // Wait until dashboard/homepage loads
        wait.until(ExpectedConditions.urlContains("/dashboard")); // Update URL accordingly

        // === Step 2: Navigate to user management page ===
        driver.get("http://your-app-url.com/admin/user-management"); // Update to actual URL

        // === Step 3: Loop through names and update roles ===
        String[] roles = {
                "admin", "superadmin", "doctor", "surgeon", "nurse", "pharmacist",
                "lab_technician", "radiologist", "receptionist", "ward_boy", "cleaning_staff",
                "accountant", "hr_manager", "it_support", "ambulance_driver", "maintenance_staff",
                "intern", "medical_superintendent", "hospital_manager", "insurance_coordinator",
                "inventory_manager", "security_guard", "patient", "caregiver", "vendor",
                "medical_representative", "health_inspector", "delivery_person", "emergency_responder",
                "blood_donor", "volunteer", "user"
        };

        for (String role : roles) {
            try {
                // === Search user by name ===
                WebElement searchBox = driver.findElement(By.id("searchInput")); // Adjust to your actual field
                searchBox.clear();
                searchBox.sendKeys(role);
                searchBox.sendKeys(Keys.ENTER);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]"))); // Wait for table row

                // === Click Edit Button ===
                WebElement editButton = driver.findElement(By.xpath("//tr[1]//button[contains(text(), 'Edit')]"));
                editButton.click();

                // === Update Role ===
                WebElement roleField = wait.until(ExpectedConditions.elementToBeClickable(By.id("role"))); // Replace with actual field ID
                roleField.clear();
                roleField.sendKeys(role);

                // === Save/Update Button ===
                WebElement updateButton = driver.findElement(By.id("updateButton")); // Replace with actual ID
                updateButton.click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-message"))); // Confirmation

                System.out.println("✅ Updated role for: " + role);

                Thread.sleep(1000); // Optional pause between users

            } catch (Exception e) {
                System.out.println("❌ Failed to update role for: " + role);
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}

