package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutomationConstants;

public class FindElementsUsingLocatorsFromByClass  implements AutomationConstants{

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
		// find the element (single element) logo 
		WebElement logo = driver.findElement(By.xpath("//div[@class='relative h-10 w-10 sm:h-11 sm:w-11 rounded-2xl bg-gradient-to-br from-orange-500 to-amber-400 flex items-center justify-center shadow-md shadow-orange-500/25']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the logo 
		logo.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		// close the browser
		Thread.sleep(4000);
		driver.quit();
	}
}
