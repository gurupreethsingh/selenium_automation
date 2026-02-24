package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class OpenClose implements AutomationConstants {
	public static WebDriver driver = null;

	// funtion to open the application
	public static void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the url and open the web page / homepage.
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// function to close the application

	public static void closeApplication() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
