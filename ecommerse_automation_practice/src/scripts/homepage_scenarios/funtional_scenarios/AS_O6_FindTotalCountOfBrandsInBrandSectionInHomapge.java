package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerifications;
import generic.AutomationConstants;

public class AS_O6_FindTotalCountOfBrandsInBrandSectionInHomapge implements AutomationConstants {

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

		int totalExpectedCount = 117;

		// div.flex.gap-3.overflow-x-auto , this is the css selector. of the parent
		// holding all the categories.
		AllVerifications.verifyTotalElementsCount(driver, totalExpectedCount,
				By.cssSelector("div.flex.items-center.w-max:first-child>button"));

		// close the browser.
		Thread.sleep(3000);
		driver.quit();
	}
}

// div.flex.items-center.w-max:first-child>button   -  find total number of brands 
