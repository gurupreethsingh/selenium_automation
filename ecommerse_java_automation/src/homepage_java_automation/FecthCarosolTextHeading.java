package homepage_java_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class FecthCarosolTextHeading {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://localhost:5173/");

            String expectedTitle = "Home | ECODERS";

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            System.out.println("title matched.");


            for (int i = 1; i <= 3; i++) {
                // Re-locate all buttons every time to avoid stale element
            	WebElement button = driver.findElement(By.xpath("//div[@class='carousel-indicators']/button[" + i + "]"));

                button.click();

                WebElement heading = driver.findElement(By.xpath("(//div[@class='carousel-caption d-none d-md-block animate__animated animate__fadeInUp']/h5)["+i+"]"));
                String text = heading.getText();
                Thread.sleep(1000);

                if (!text.isEmpty()) {
                    System.out.println("Slide " + (i + 1) + " Heading: " + text);
                } else {
                    System.out.println("Slide " + (i + 1) + " Heading is empty or not visible.");
                }

                Thread.sleep(1000); // short wait between transitions
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred.");
            TakeScreenshot.getScreenshot(driver);
        } finally {
            if (driver != null) {
                Thread.sleep(2000); // optional delay before quit
                driver.quit();
            }
        }
    }
}
