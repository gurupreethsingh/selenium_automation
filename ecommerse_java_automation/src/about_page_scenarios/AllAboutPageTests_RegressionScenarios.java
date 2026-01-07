	package about_page_scenarios;

	import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import screenshots.TakeScreenshot;


public class AllAboutPageTests_RegressionScenarios {

	    WebDriver driver;
	    WebDriverWait wait;
	    SoftAssert softAssert;

	    @BeforeMethod
	    public void setup() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        softAssert = new SoftAssert();

	        driver.get("http://localhost:5173/login");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("igurupreeth@gmail.com");
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123ABC!@#");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        // Handle alert if it appears
	        try {
	            Thread.sleep(1000);
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	        } catch (Exception ignored) {}
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	        softAssert.assertAll();
	    }

	    @Test
	    public void openAboutPageUsingUrl() {
	        try {
	            wait.until(ExpectedConditions.titleIs("Login | ECODERS"));
	            driver.navigate().to("http://localhost:5173/about-us");
	            wait.until(ExpectedConditions.titleIs("About Us | ECODERS"));
	            System.out.println("About page loaded successfully via URL.");
	        } catch (Exception ex) {
	            TakeScreenshot.getScreenshot(driver);
	            softAssert.fail("About page via URL failed to load.");

	        }
	        softAssert.assertAll();
	    }

	    @Test
	    public void openAboutPageUsingHeaderLink() {
	        try {
	            wait.until(ExpectedConditions.titleIs("SuperAdmin Dashboard | ECODERS"));
	            driver.findElement(By.xpath("//a[@href='/about-us']")).click();
	            wait.until(ExpectedConditions.titleIs("About Us | ECODERS"));
	            System.out.println("About page loaded successfully via header link.");
	        } catch (Exception ex) {
	            TakeScreenshot.getScreenshot(driver);
	            softAssert.fail("About page via header link failed to load.");

	        }
	        softAssert.assertAll();
	    }

	    @Test
	    public void openContactPageUsingHeaderLink() {
	        try {
	            wait.until(ExpectedConditions.titleIs("SuperAdmin Dashboard | ECODERS"));
	            driver.navigate().to("http://localhost:5173/about-us");
	            driver.findElement(By.xpath("//a[@href='/contact-us']")).click();
	            wait.until(ExpectedConditions.titleIs("Contact Us | ECODERS"));
	            System.out.println("Contact page loaded successfully via header link.");
	        } catch (Exception ex) {
	            TakeScreenshot.getScreenshot(driver);
	            softAssert.fail("Contact page via header link failed to load.");
	        }
	        softAssert.assertAll();
	    }

	    @Test
	    public void openDashboardPageFromAboutPageHeader() {
	        try {
	            wait.until(ExpectedConditions.titleIs("SuperAdmin Dashboard | ECODERS"));
	            driver.navigate().to("http://localhost:5173/about-us");
	            driver.findElement(By.xpath("//a[@href='/superadmin-dashboard']")).click();
	            wait.until(ExpectedConditions.titleIs("SuperAdmin Dashboard | ECODERS"));
	            System.out.println("Dashboard page loaded successfully from About page.");
	        } catch (Exception ex) {
	            TakeScreenshot.getScreenshot(driver);
	            softAssert.fail("Dashboard page from About page failed to load.");
	        }
	        softAssert.assertAll();
	    }

	    @Test
	    public void openHomePageFromFooterLink() {
	        try {
	            wait.until(ExpectedConditions.titleIs("SuperAdmin Dashboard | ECODERS"));
	            driver.navigate().to("http://localhost:5173/about-us");
	            driver.findElement(By.xpath("//a[@href='/home']")).click();
	            wait.until(ExpectedConditions.titleIs("Home | ECODERS"));
	            System.out.println("Home page loaded successfully from footer link.");
	        } catch (Exception ex) {
	            TakeScreenshot.getScreenshot(driver);
	            softAssert.fail("Home page from footer link failed to load.");
	        }
	        softAssert.assertAll();
	    }
	}

