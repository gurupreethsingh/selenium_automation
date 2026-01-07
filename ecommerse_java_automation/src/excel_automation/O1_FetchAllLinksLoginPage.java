package excel_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import automation_scripts.AutomationConstants;

public class O1_FetchAllLinksLoginPage implements AutomationConstants{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = null;
		try
		{
			System.out.println("Fetch all links from Login page");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			driver.get(urlOfLogin);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			System.out.println(driver.getTitle());

			System.out.println(driver.getCurrentUrl());

			List <WebElement> allLinks = driver.findElements(By.tagName("a"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			System.out.println("Total links in login page " + allLinks.size());

			for ( WebElement eachLink  :allLinks)
			{
				String text = eachLink.getText();

				 String linkAddress = eachLink.getAttribute("href");

				 System.out.println(text +" " + linkAddress);

			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			Thread.sleep(3000);
			driver.quit();
		}

	}
}
