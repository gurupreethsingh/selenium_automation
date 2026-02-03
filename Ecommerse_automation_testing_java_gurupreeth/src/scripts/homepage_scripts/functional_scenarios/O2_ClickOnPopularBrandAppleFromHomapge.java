package scripts.homepage_scripts.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class O2_ClickOnPopularBrandAppleFromHomapge implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
      // open the browser 
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// open the homepage of ecommerse
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("The title of the page is : " + driver.getTitle());
		
		// is to scroll down to the popular brand section. 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");    // 500 means scroll down , -500 scroll up 
		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0, -500)");   // scroll up -500 pixels
		
		// find the apple brand 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement appleBrand = driver.findElement(By.xpath("(//button[@title='APPLE'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the apple brand
		appleBrand.click();
		
		Thread.sleep(1000);
		// it will navigate to search product page. 
		System.out.println("title of the current page is : " + driver.getTitle());
		
		Thread.sleep(5000);
		driver.quit();
	}
}
