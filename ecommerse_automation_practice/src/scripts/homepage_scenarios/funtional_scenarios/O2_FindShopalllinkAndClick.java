package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutomationConstants;

public class O2_FindShopalllinkAndClick  implements AutomationConstants{

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
		WebElement shopAllLink = driver.findElement(By.xpath("//a[@class='linkText text-sm transition-colors text-gray-700 hover:text-orange-600']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the element
		System.out.println(shopAllLink.getText());
		System.out.println(shopAllLink.getTagName());
		System.out.println(shopAllLink.getAttribute("href"));
		System.out.println(shopAllLink.getAttribute("target"));
		System.out.println(shopAllLink.getAttribute("class"));
		shopAllLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		// close the browser
		Thread.sleep(4000);
		driver.quit();
	}
}
