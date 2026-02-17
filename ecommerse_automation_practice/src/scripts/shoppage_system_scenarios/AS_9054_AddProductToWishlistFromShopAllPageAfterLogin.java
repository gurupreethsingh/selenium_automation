package scripts.shoppage_system_scenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class AS_9054_AddProductToWishlistFromShopAllPageAfterLogin implements AutomationConstants
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enter the shop page url
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verify shop page is open or not.
		System.out.println(driver.getTitle());
		
		// step 2 : click sign in button and navigate to login page . 
		WebElement signinButton = driver.findElement(By.xpath("//span[@class='text-[12px] font-extrabold text-white']"));
		Thread.sleep(500);
		// click on the logo
		signinButton.click();
		Thread.sleep(500);
		System.out.println(driver.getTitle());
		
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		Thread.sleep(500);
		emailField.sendKeys("ecoders@gmail.com");
		Thread.sleep(500);
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		Thread.sleep(500);
		passwordField.sendKeys("abc123ABC!@#");
		Thread.sleep(500);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='w-full py-2 px-4 bg-gradient-to-r from-orange-500 to-amber-400 text-white font-bold rounded-full shadow hover:from-orange-500 hover:to-orange-300 transition']"));
		Thread.sleep(500);
		loginButton.click();
		Thread.sleep(500);
		
		// handle the alert by switching to alert window and click on ok button on the alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); // dissmiss()
		Thread.sleep(500);
		System.out.println(driver.getTitle());
		
		// navigate to shop page by clicking on shop all link from the header of dashboard page. 
		WebElement shopAllLink = driver.findElement(By.xpath("//a[@class='linkText text-sm transition-colors text-gray-700 hover:text-orange-600']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shopAllLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		// click on the wishlist icon of any one product 
		WebElement wishlistIconOnProduct = driver.findElement(By.xpath("(//button[@class='absolute top-2 right-2 h-9 w-9 rounded-full bg-white/90 backdrop-blur flex items-center justify-center transition hover:bg-white'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wishlistIconOnProduct.click();
		Thread.sleep(500);
		
		// find the wishlisticon from header and click on it and navigate to wishlist page. 
		
		WebElement wishlistIconHeader = driver.findElement(By.xpath("(//a[@href='/wishlist'])[1]"));
		Thread.sleep(500);
		wishlistIconHeader.click();
		Thread.sleep(500);
		System.out.println(driver.getTitle());
		
		// verify the product is added to wishlist or not 
		String expectedProductText = "Yoga Resistance Bands Set";
		
		
		WebElement productNameWishlistpage = driver.findElement(By.xpath("//h2[@class='text-[13px] font-extrabold text-slate-900 truncate']"));
		Thread.sleep(500);
		String actualProductText = productNameWishlistpage.getText();
		Thread.sleep(500);
		
		if(expectedProductText.equals((actualProductText)))
		{
			System.out.println("Product successfully added to wishlist");
		}
		else
		{
			System.out.println("Product not added to wishlist");
		}
		
		// click on name drop down from header  
		
			WebElement nameDropDown = driver.findElement(By.xpath("//button[@class='inline-flex items-center gap-2 rounded-full border border-orange-200 bg-orange-50 px-4 py-2 text-[12px] font-extrabold text-orange-700 hover:bg-orange-500 hover:text-white hover:border-orange-500 transition uppercase']"));
			Thread.sleep(500);
			 nameDropDown.click();
			Thread.sleep(500);
			
			
			WebElement logoutButton = driver.findElement(By.xpath("//button[@class='block w-full text-left px-4 py-2.5 text-[13px] font-extrabold text-red-500 hover:bg-red-50']"));
			Thread.sleep(500);
			 logoutButton.click();
			Thread.sleep(500);
			System.out.println(driver.getTitle());
			
		Thread.sleep(3000);
		driver.quit();
	}

}
