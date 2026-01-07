package hms_automation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMultipleUsers_Register {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
                String name = role;
                String email = role + "@gmail.com";
                String password = "abc123ABC!@#";

                // === Step 1: Register the user ===
                driver.get("http://localhost:5173/register"); // Update URL

                driver.findElement(By.id("name")).sendKeys(name);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.id("email")).sendKeys(email);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.id("password")).sendKeys(password);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.findElement(By.xpath("//button[@type='submit']")).click();

                // === Step 2: Handle alert ===
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                System.out.println("🔔 Alert Text: " + alert.getText());
                alert.accept(); // Clicks "OK"

                // === Step 3: Wait until login page loads ===
                wait.until(ExpectedConditions.urlContains("/login"));

                String expectedTitle = "Login | ECODERS";
                System.out.println("The Actual title of the page is : ");
                String actualTitle = driver.getTitle();
                System.out.println(actualTitle);

                try
                {
                	wait.until(ExpectedConditions.titleIs(expectedTitle));
                	System.out.println("Title is matching test case passed. ");
                }
                catch(Exception ex)
                {
                	ex.printStackTrace();
                	System.out.println("Title is not matching. Test case failed");
                }

                // Optional logout logic here if needed

            } catch (Exception e) {
                System.out.println("❌ Error for role: " + role);
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}
