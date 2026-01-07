package homepage_java_automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class OpenHomepageUsingUrl {

	public static void main(String[] args) {
		WebDriver driver = null;

			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("http://localhost:5173/");

			String expectedTitle = "Home | ECODERS";
			String expectedUrl = "http://localhost:5173/";
			String actualUrl = driver.getCurrentUrl();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try
			{
				wait.until(ExpectedConditions.titleIs(expectedTitle));
			    System.out.println("title matched.");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println("ulr didnt match.");
				// screenshot code.
				TakeScreenshot.getScreenshot(driver);
			}
			driver.quit();
	}
}
