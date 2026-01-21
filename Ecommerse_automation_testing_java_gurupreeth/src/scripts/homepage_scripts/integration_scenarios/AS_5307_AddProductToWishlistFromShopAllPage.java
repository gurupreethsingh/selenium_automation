package scripts.homepage_scripts.integration_scenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class AS_5307_AddProductToWishlistFromShopAllPage implements AutomationConstants
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		// sign in . 
		// click on sign in button from the header , 
		WebElement signinButton = driver.findElement(By.xpath("//span[@class = 'text-[12px] font-extrabold text-white']"));
		Thread.sleep(500);
		signinButton.click();
		Thread.sleep(500);
		// enter email , password, and click on login button. 
		WebElement emailField = driver.findElement(By.xpath("//input[@id = 'email']"));
		Thread.sleep(500);
		emailField.sendKeys("ecoders@gmail.com");
		Thread.sleep(500);
		WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'password']"));
		Thread.sleep(500);
		passwordField.sendKeys("abc123ABC!@#");
		Thread.sleep(500);
		WebElement loginButton = driver.findElement(By.xpath("//button[@class = 'w-full py-2 px-4 bg-gradient-to-r from-orange-500 to-amber-400 text-white font-bold rounded-full shadow hover:from-orange-500 hover:to-orange-300 transition']"));
		Thread.sleep(500);
		loginButton.click();
		Thread.sleep(500);
		Alert a1 = driver.switchTo().alert();
		Thread.sleep(500);
		a1.accept();
		Thread.sleep(500);
		// verify we are in dashboard page or not
		System.out.println(driver.getTitle());
		
		Thread.sleep(500);
		WebElement shopAllButton = driver.findElement(By.xpath("//a[@href = '/shop']"));
		Thread.sleep(500);
		shopAllButton .click();
		
		Thread.sleep(500);
		WebElement appleProductWishlistIcon = driver.findElement(By.xpath("(//button[@class = 'absolute top-2 right-2 h-9 w-9 rounded-full bg-white/90 backdrop-blur flex items-center justify-center transition hover:bg-white'])[1]"));
		Thread.sleep(500);
		appleProductWishlistIcon.click();
		
		
				
				Thread.sleep(500);
				WebElement appleProductText = driver.findElement(By.xpath("(//p[@class='text-[12px] sm:text-[13px] font-extrabold text-slate-900 leading-snug truncate'])[1]"));
				Thread.sleep(500);
				String expectedProductName = appleProductText.getText();
				System.out.println("Clicked on the product : " + expectedProductName);
				Thread.sleep(500);
		
		WebElement wishlistIconHeader = driver.findElement(By.xpath("//div[@class='relative rounded-2xl bg-white px-3 py-2 hover:shadow-md transition']"));
		Thread.sleep(500);
		wishlistIconHeader.click();
		Thread.sleep(500);
		// verify we are in wishlist page or not
		System.out.println(driver.getTitle());
		
		WebElement actualProductNameInWishlistPage = driver.findElement(By.xpath("(//h2[@class='text-[13px] font-extrabold text-slate-900 truncate'])[2]"));
		System.out.println("Actual product name : "+ actualProductNameInWishlistPage.getText());
		
		
		if(expectedProductName.equals(actualProductNameInWishlistPage.getText()))
		{
			System.out.println("TEst case passed, product present in wishlist page.");
		}
		else
		{
			System.out.println("TEst case failed, product not present/matching in wishlist page.");
		}
		
          Thread.sleep(4000);
          driver.quit();
	}

}
