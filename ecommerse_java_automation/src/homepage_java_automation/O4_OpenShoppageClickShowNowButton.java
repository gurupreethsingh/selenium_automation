package homepage_java_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O4_OpenShoppageClickShowNowButton {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://localhost:5173/");

            // Wait for Home title
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Home"));

            // Wait for active slide
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'carousel-item') and contains(@class,'active')]")));

            // Wait until "Shop Now" button inside active slide is clickable
            By shopNowXPath = By.xpath("//div[contains(@class,'carousel-item') and contains(@class,'active')]/div/a");
            WebElement shopNowButton = wait.until(ExpectedConditions.elementToBeClickable(shopNowXPath));


            // Now click
            shopNowButton.click();
            System.out.println("Clicked on Shop Now button of active carousel slide.");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to click Shop Now.");
        } finally {
            if (driver != null) {
                Thread.sleep(2000); // optional delay
                driver.quit();
            }
        }
    }
}
