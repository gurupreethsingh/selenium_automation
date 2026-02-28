package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenClose implements AutomationConstants {

	public WebDriver driver;

	// funtion to open the application
	@BeforeMethod
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the url and open the web page / homepage.
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// function to close the application

	@AfterMethod
	public void closeApplication() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}

}
