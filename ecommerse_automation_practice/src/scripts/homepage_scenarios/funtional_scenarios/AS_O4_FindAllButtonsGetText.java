package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerifications;
import generic.AutomationConstants;

public class AS_O4_FindAllButtonsGetText implements AutomationConstants {

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
		List<WebElement> allButtons = driver.findElements(By.tagName("button"));
		// get the total count of all the elements.
		int buttonCount = allButtons.size();
		System.out.println("Total buttons found : " + buttonCount);

		// print the text of paragraphs.

		for (int i = 0; i < allButtons.size(); i++) {
			String eachButtonText = allButtons.get(i).getText();
			System.out.println("***************************");
			System.out.println(eachButtonText);
			System.out.println("***************************");
			Thread.sleep(500);
		}

		// close the browser.
		Thread.sleep(3000);
		driver.quit();
	}
}
