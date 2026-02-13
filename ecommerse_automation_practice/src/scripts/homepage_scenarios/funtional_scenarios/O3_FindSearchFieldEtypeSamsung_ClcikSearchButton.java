package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutomationConstants;

public class O3_FindSearchFieldEtypeSamsung_ClcikSearchButton  implements AutomationConstants{

	public static void main(String[] args) throws InterruptedException 
	{
		// open the browswer. 
		WebDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();		
		// sufficient waiting time. to load the browser. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to the web page.
		driver.get(urlOfApplication);
		// sufficient waiting time to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// find the element shop all link
		WebElement searchField = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the element
		searchField.sendKeys("Samsung");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// find the search button
		WebElement searchButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchButton.click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		// close the browser
		Thread.sleep(4000);
		driver.quit();
	}
}
