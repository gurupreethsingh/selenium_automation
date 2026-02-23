package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerifications;
import generic.AutomationConstants;

public class AS_O2_FindAllHeading_h1tag implements AutomationConstants {

	public static void main(String[] args) throws InterruptedException {
		// open browswer and go to the homepage of the application.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verifty you are in homepage.
		String expectedTitle = "Home | ECODERS";
		AllVerifications.verifyTitleOfWebpage(driver, expectedTitle);
		// find all the links/ achors tags
		List<WebElement> allHeading_h1 = driver.findElements(By.tagName("h1"));
		List<WebElement> allHeading_h2 = driver.findElements(By.tagName("h2"));
		List<WebElement> allHeading_h3 = driver.findElements(By.tagName("h3"));
		List<WebElement> allHeading_h4 = driver.findElements(By.tagName("h4"));
		List<WebElement> allHeading_h5 = driver.findElements(By.tagName("h5"));
		List<WebElement> allHeading_h6 = driver.findElements(By.tagName("h6"));

		int headingCounth1 = allHeading_h1.size();
		int headingCounth2 = allHeading_h2.size();
		int headingCounth3 = allHeading_h3.size();
		int headingCounth4 = allHeading_h4.size();
		int headingCounth5 = allHeading_h5.size();
		int headingCounth6 = allHeading_h6.size();

		System.out.println("Total links found : " + headingCounth1);
		System.out.println("Total links found : " + headingCounth2);
		System.out.println("Total links found : " + headingCounth3);
		System.out.println("Total links found : " + headingCounth4);
		System.out.println("Total links found : " + headingCounth5);
		System.out.println("Total links found : " + headingCounth6);

		// get the total count of all the links.
		// print the href , attribute of all the links.
		// print the text of all the links.
		// close the browser.
		Thread.sleep(3000);
		driver.quit();
	}
}
