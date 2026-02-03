package scripts.homepage_scripts.functional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class O3_ClickOnAllPopularBrandsOneByOneFromHomepage2 implements AutomationConstants {

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
			
//			WebElement element = driver.findElement(By.xpath("YOUR_XPATH_HERE"));

//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", element);      // scrolls to the element most commonly used
//			Thread.sleep(2000);
//			js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});",  element);     // better ui code
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");   // scrolls to teh bottom of the page 			
//			js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", eachBrand);
		
			List<WebElement> allBrandsSection = driver.findElements(By.cssSelector("div.flex.items-center.w-max:nth-child(1)>button"));
			System.out.println("Total popular brands are : ");
			System.out.println(allBrandsSection.size());
			
			for(int i = 1; i<= allBrandsSection.size(); i++)
			{
				WebElement eachBrand = driver.findElement(By.cssSelector("div.flex.items-center.w-max:nth-child(1)>button:nth-of-type("+i+")"));
				Thread.sleep(500);
				eachBrand.click();
				Thread.sleep(1000);
				System.out.println("Title of current page is : " + driver.getTitle());
				System.out.println("Clicked on "+i+" popular Brands.");
				// come back to homepage 
				driver.navigate().back();
				System.out.println("Title of homepage should be : "+ driver.getTitle());
			}
			
			// close the browser. 
			Thread.sleep(5000);
			driver.quit();
	}
}
