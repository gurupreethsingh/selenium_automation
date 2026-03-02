//package generic;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class OpenClose implements AutomationConstants {
//
//	public WebDriver driver;
//
//	// funtion to open the application
//	@BeforeMethod
//	public void openApplication() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		// enter the url and open the web page / homepage.
//		driver.get(urlOfApplication);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//
//	// function to close the application
//
//	@AfterMethod
//	public void closeApplication() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
//	}
//
//}

package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenClose implements AutomationConstants {

	public WebDriver driver;

	@BeforeMethod
	public void openApplication() {

		ChromeOptions options = new ChromeOptions();

		// ✅ optional (keeps browser stable in CI / avoids random issues)
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");

		// ✅ if you want headless later (uncomment)
		// options.addArguments("--headless=new");
		// options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);

		// ✅ If you use maximize, do it once (start-maximized already does it, but ok)
		driver.manage().window().maximize();

		// ✅ IMPORTANT:
		// Do NOT mix implicit waits with explicit waits (AllVerifications).
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		// ✅ prevent hanging
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		// ✅ open app
		driver.get(urlOfApplication);
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("[TEARDOWN] Error while quitting driver: " + e.getMessage());
		}
	}
}