package scripts.contactus_scripts.system_scenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClass_Shilpa;

public class As_1111_LoginAddTowishistConfirmLogoutLoginAgainConfirmWishlist extends BaseClass_Shilpa
{
	
	// nshilpamurthy@gmail.com
	// abc123ABC!@# 
    
	@Test
	public void loginAddProductToWishlist() throws InterruptedException
	{
		// check if the contact page is open or not. 
		// click on login  , check login page opened or not.
		
		System.out.println("Contact page title  " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement signInButton = driver.findElement(By.cssSelector("span.text-sm"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		signInButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("login page title  " + driver.getTitle());
		
		
		// enter the email and passsword and click on sign in button.  and handle the alert by accepting. (ok) 
		WebElement emailField = driver.findElement(By.cssSelector("form.space-y-6>div:nth-child(1)>input"));
		emailField.clear(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		emailField.sendKeys("nshilpamurthy@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement passwordField = driver.findElement(By.cssSelector("form.space-y-6>div:nth-child(2)>input"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		passwordField.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		passwordField.sendKeys("abc123ABC!@#");
		WebElement loginButton = driver.findElement(By.cssSelector("form.space-y-6>button"));
		
		loginButton.click();
		Thread.sleep(2000);
	
		// login and go to user dashboard.
		
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a.getText());
		Thread.sleep(2000);
		a.accept();
		Thread.sleep(2000);
		
		System.out.println("dashboard page title  " + driver.getTitle());
		
		// from user dashboard click on shop all link , shop page will open. 
		
		WebElement shopAllLink = driver.findElement(By.cssSelector("a.linkText"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shopAllLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// click on the second product wishlist icons .
		
		
		WebElement wishlistIconOnProduct = driver.findElement(By.cssSelector("div.grid>div.relative:nth-of-type(2)>button"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wishlistIconOnProduct.click();
		
		// click on wishlist icon form th header and navigate to wishlist. 
		
		
		
		WebElement wishlistIconInHeader = driver.findElement(By.cssSelector("div.hidden.items-center.gap-6>a.relative"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wishlistIconInHeader.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("wishlist page title  " + driver.getTitle());
		
		// verify product is presnt or not. in wishlist page. 
		System.out.println("wishlist page title  " + driver.getTitle());
		
		WebElement productNameInWishlistpage = driver.findElement(By.cssSelector("h2.text-lg"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(productNameInWishlistpage.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		// logout. (first clickon drop donw. then click on logout button. 
		
		
		WebElement nameDropDown = driver.findElement(By.cssSelector("div.hidden.items-center.gap-6>div.relative:last-child>button"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		nameDropDown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement logoutButton = driver.findElement(By.cssSelector("div.absolute>button:last-child"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logoutButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// login again. 
		
		WebElement signInButton1 = driver.findElement(By.cssSelector("span.text-sm"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		signInButton1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("login page title  " + driver.getTitle());
		
		
		// enter the email and passsword and click on sign in button.  and handle the alert by accepting. (ok) 
		WebElement emailField1 = driver.findElement(By.cssSelector("form.space-y-6>div:nth-child(1)>input"));
		emailField1.clear(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		emailField1.sendKeys("nshilpamurthy@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement passwordField1 = driver.findElement(By.cssSelector("form.space-y-6>div:nth-child(2)>input"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		passwordField1.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		passwordField1.sendKeys("abc123ABC!@#");
		WebElement loginButton1 = driver.findElement(By.cssSelector("form.space-y-6>button"));
		
		loginButton1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		// login and go to user dashboard.
		Thread.sleep(2000);
		Alert a1 = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a1.getText());
		Thread.sleep(2000);
		a1.accept();
		Thread.sleep(2000);
		
		
		// you will be in the user dashboard. 
		System.out.println("dashboard page title  " + driver.getTitle());
		
		// click on wishlist icon from the header of dashboard page. 
		WebElement wishlistIconInHeader1 = driver.findElement(By.cssSelector("div.hidden.items-center.gap-6>a.relative"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wishlistIconInHeader1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("wishlist page title  " + driver.getTitle());
		
		// wishlist will open and verify product persist in wishlist. 
		WebElement productNameInWishlistpageAffterLogin = driver.findElement(By.cssSelector("h2.text-lg"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(productNameInWishlistpageAffterLogin.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	}

}
