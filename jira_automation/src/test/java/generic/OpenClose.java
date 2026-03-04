package generic;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenClose implements AutomationConstants {

	public WebDriver driver;

	// for desktop automation use this code
//	@BeforeMethod
//	public void openApplication() {
//
//		ChromeOptions options = new ChromeOptions();
//
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--disable-infobars");
//		options.addArguments("--start-maximized");
//
//		driver = new ChromeDriver(options);
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//
//		driver.get(URL_HOME);
//	}
//	

	// for mobile screen automation use this.
	@BeforeMethod
	public void openApplicationInMobileViews() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		// ✅ Mobile screen size (example: iPhone 12/13/14)
		options.addArguments("--window-size=390,844");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		driver.get(URL_HOME);
	}

	/** ✅ use this in tests to simulate mobile/tablet screens */
	public void setViewport(int width, int height) {
		try {
			driver.manage().window().setSize(new Dimension(width, height));
			System.out.println("[VIEWPORT] set to " + width + "x" + height);
		} catch (Exception e) {
			System.out.println("[VIEWPORT] failed to set size: " + e.getMessage());
		}
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