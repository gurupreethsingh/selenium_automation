package homepage_scenarios;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class O1_OpenLoginPageWhenLoggedOutUsingHomelink_Parallel_testing implements AutomationConstants {

    WebDriver driver;
    String browser;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("firefox") String browser) {
        // Enable Selenium Manager debug log (optional, helps trace if browser not launching)
        System.setProperty("selenium.manager.log", "TRACE");

        this.browser = browser.toLowerCase();

        switch (this.browser) {
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
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openLoginPageTest() {
        try {
            driver.get(urlOfHomepage);
            System.out.println("Browser: " + browser);
            System.out.println("Expected title : Login | ECODERS");
            System.out.println("Actual title : " + driver.getTitle());
            System.out.println("Actual URL : " + driver.getCurrentUrl());

            String expectedTitle = "Login | ECODERS"; // fix the typo if needed

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.titleIs(expectedTitle));
            } catch (Exception ex) {
                System.out.println("Test failed: Expected title did not match. Screenshot captured.");
                TakeScreenshot.getScreenshot(driver);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
