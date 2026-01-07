package homepage_java_automation;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import screenshots.TakeScreenshot;

public class OpenHomepageUsingUrl_usingFluentWait {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://localhost:5173/");

            String expectedTitle = "Home | ECODERS";
            String expectedUrl = "http://localhost:5173/";
            String actualUrl = driver.getCurrentUrl();

            // FluentWait
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(Exception.class);  // You can also add specific ignored exceptions

            try {
                wait.until(new Function<WebDriver, Boolean>()
                {
                    @Override
					public Boolean apply(WebDriver driver)
                    {
                        return driver.getTitle().equals(expectedTitle);
                    }
                });

                System.out.println("title matched.");
            }
            catch (Exception ex)
            {
                System.out.println("Title did not match.");
                TakeScreenshot.getScreenshot(driver);
            }

        } catch (Exception e) {
            System.out.println("Unhandled exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
