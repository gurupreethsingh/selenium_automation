package scripts.homepage_scripts.functional_scenarios;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class O1_ClickLogoRefreshHomepage implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException
	{
		// open the browser and maximize the window
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to the webpage (homepage) 
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// find the logo
		WebElement logo = driver.findElement(By.xpath("//span[@class = 'text-[13px] font-extrabold text-gray-900 tracking-tight']"));
		// click on the logo
		logo.click(); 
		// verify the title of the page. 
		String expectedTitle = "Home | ECODERS";
		
		String actualTitle = driver.getTitle(); 
		System.out.println("The actual title of the page loaded is :" + actualTitle);
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Test case passed, title is matching.");
		}
		else
		{
			System.out.println("Test case failed, title is not matching.");
		}
		
		Thread.sleep(3000);
		// close the browser. 
		
		driver.quit();
	}
}
