package homepage_java_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class O5_VerifyCategoryHeading {

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
                By.xpath("//div[@class='flex justify-between items-center mb-6']/h2")));

            // Wait until "Shop Now" button inside active slide is clickable
            WebElement categoryHading = driver.findElement(By.xpath("//div[@class='flex justify-between items-center mb-6']/h2"));

            String exptectedText = "Explore Our Categories";
            System.out.println("Acutal heading" + categoryHading.getText());

            try
            {
            	 wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='flex justify-between items-center mb-6']/h2"), exptectedText));
            	 System.out.println("Text is matching.");
            }
            catch(Exception ex)
            {
            	ex.printStackTrace();
            	System.out.println("Text is not matching.");
            	// screen shot code.
            	TakeScreenshot.getScreenshot(driver);
            }



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
