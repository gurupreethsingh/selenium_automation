package scripts.shoppge.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerifications;
import generic.AutomationConstants;

public class AS_6079_Clicklogofromshoppagenavigatetohomepage implements AutomationConstants
{
	public static void main(String[] args) throws InterruptedException 
	{
		// open chrome 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the shop page url
		driver.get(urlOfShopAllPage);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verify shop page is open or not.
		boolean shoptitleVerified = AllVerifications.verifyTitleOfWebpage(driver, "Shop | ECODERS");
		System.out.println(shoptitleVerified);
		// find the logo in header of shoppage.
		WebElement logo = driver.findElement(By.xpath("//span[@class='text-[13px] font-extrabold text-gray-900 tracking-tight']"));
		Thread.sleep(500);
		// click on the logo
		logo.click();
		Thread.sleep(500);
		// verify homepage is opened or not. 
		boolean hometitleVerified = AllVerifications.verifyTitleOfWebpage(driver, "Home | ECODERS");
		System.out.println(hometitleVerified);
		Thread.sleep(3000);
		// close the browser
		driver.quit();
	}
}
