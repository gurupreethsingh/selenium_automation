package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class OpenClose implements AutomationConstants {

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void openApplication(@Optional("chrome") String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("❌ Invalid browser name: " + browser);
        }

        // Store driver in ThreadLocal
        DriverManager.setDriver(driver);

        // Use ONLY ThreadLocal driver from here
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.getDriver().get(URL_HOME);
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverManager.unload();
    }

    // Optional helper for child test classes
    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
