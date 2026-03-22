package generic;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class OpenClose implements AutomationConstants {

	public WebDriver driver;

	// ✅ Available to all test classes that extend OpenClose
	protected SoftAssert softAssert;

	// ✅ Opens browser + creates SoftAssert object before every @Test
	@BeforeMethod(alwaysRun = true)
	public void openApplicationInDesktop() {

		// ✅ SoftAssert init for every test
		softAssert = new SoftAssert();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		driver.get(BASE_URL);
	}

//	// for mobile screen automation use this.
//	@BeforeMethod
//	public void openApplicationInMobileViews() {
// 	softAssert = new SoftAssert();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--disable-infobars");
//		// ✅ Mobile screen size (example: iPhone 12/13/14)
//		options.addArguments("--window-size=390,844");
//		driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

//		driver.get(URL_HOME);
//	}

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

		// ✅ Assert all at the end so test doesn't stop in middle
		try {
			if (softAssert != null) {
				softAssert.assertAll();
			}
		} catch (AssertionError ae) {
			// ✅ Print message, but re-throw so TestNG marks the test as FAILED
			System.out.println("[SOFT ASSERT FAILURES] " + ae.getMessage());
			throw ae;
		} finally {
			// ✅ Always quit browser even if assertAll fails
			try {
				if (driver != null) {
					driver.quit();
				}
			} catch (Exception e) {
				System.out.println("[TEARDOWN] Error while quitting driver: " + e.getMessage());
			}
		}
	}
}
