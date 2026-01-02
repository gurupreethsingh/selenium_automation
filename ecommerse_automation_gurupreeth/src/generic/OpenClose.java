package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenClose implements AutomationConstants
{
	public static WebDriver driver = null; 
	
	@BeforeMethod
	public static void openApplication()
	{
	    driver = new ChromeDriver(); 
	    driver.manage().window().maximize(); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(URL_HOME);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@AfterMethod
	public static void closeApplication()
	{
		driver.quit();
	}

}




//

// package generic;

// import java.lang.reflect.Method;
// import java.time.Duration;

// import org.openqa.selenium.Dimension;
// import org.openqa.selenium.Point;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;

// import org.testng.ITestResult;
// import org.testng.annotations.*;
// import org.testng.asserts.SoftAssert;

// public class OpenClose implements AutomationConstants {

//     private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();
//     private static final ThreadLocal<SoftAssert> TL_SOFT  = new ThreadLocal<>();

//     protected WebDriver getDriver() {
//         return TL_DRIVER.get();
//     }
//     protected SoftAssert getSoftAssert() {
//         return TL_SOFT.get();
//     }
//     private void setDriver(WebDriver d) {
//         TL_DRIVER.set(d);
//     }

//     @Parameters({
//         "baseUrl",
//         "headless",
//         "windowMode",
//         "customWidth",
//         "customHeight"
//     })
//     @BeforeMethod(alwaysRun = true)
//     public void setUp(
//             Method testMethod,
//             @Optional("") String baseUrl,
//             @Optional("false") String headless,
//             @Optional("maximize") String windowMode,
//             @Optional("1280") String customWidth,
//             @Optional("800") String customHeight
//     ) {
//         // 1) Browser options
//         ChromeOptions options = new ChromeOptions();
//         if ("true".equalsIgnoreCase(headless)) {
//             options.addArguments("--headless=new");
//         }

//         // 2) Start driver
//         WebDriver driver = new ChromeDriver(options);
//         setDriver(driver);

//         // 3) Timeouts
//         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//         // 4) Window mode
//         switch (windowMode.toLowerCase()) {
//             case "maximize":
//                 driver.manage().window().maximize();
//                 break;
//             case "minimize":
//                 driver.manage().window().minimize();
//                 break;
//             case "fullscreen":
//                 driver.manage().window().fullscreen();
//                 break;
//             case "custom":
//                 driver.manage().window().setPosition(new Point(50, 50));
//                 driver.manage().window().setSize(
//                         new Dimension(Integer.parseInt(customWidth), Integer.parseInt(customHeight)));
//                 break;
//             default:
//                 driver.manage().window().maximize();
//         }

//         // 5) Navigate
//         String targetUrl = (baseUrl == null || baseUrl.isBlank()) ? URL_HOME : baseUrl;
//         driver.get(targetUrl);

//         // 6) Create SoftAssert and register context for AllVerifications
//         SoftAssert sa = new SoftAssert();
//         TL_SOFT.set(sa);
//         AllVerifications.setContext(driver, sa);
//     }

//     @AfterMethod(alwaysRun = true)
//     public void tearDown(ITestResult result) {
//         WebDriver driver = getDriver();
//         SoftAssert sa = getSoftAssert();

//         // If a test failed, take a screenshot (you already had this)
//         if (result.getStatus() == ITestResult.FAILURE && driver != null) {
//             try { CaptureScreenshot.takeScreenshot(driver); } catch (Exception ignore) {}
//         }

//         // Ensure SoftAssert assertions are flushed
//         try {
//             if (sa != null) sa.assertAll();
//         } catch (AssertionError ae) {
//             // Re-throw after cleanup so TestNG marks failure correctly
//             throw ae;
//         } finally {
//             // Clear AllVerifications context
//             AllVerifications.clearContext();
//             TL_SOFT.remove();

//             // Quit driver
//             if (driver != null) {
//                 try { driver.quit(); } catch (Exception ignore) {}
//                 TL_DRIVER.remove();
//             }
//         }
//     }
// }
