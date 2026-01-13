package scripts.super_admin_panel.all_added_products;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O001_FetchAllProductNames {

	public static void main(String[] args)
	{
		// open browser 
		WebDriver driver = new ChromeDriver();
		// maximize the window
		driver.manage().window().maximize();
		// to to the login page
		driver.get("http://localhost:5174/login");
		
		
		WebElement emailField = driver.findElement(By.cssSelector("input.formInput:nth-child(2)"));
		emailField.sendKeys("ecoders@gmail.com");
		
		WebElement passwordField = driver.findElement(By.cssSelector("input.formInput:nth-child(1)"));
	    passwordField.sendKeys("abc123ABC!@#");
		
		WebElement loginButton = driver.findElement(By.cssSelector("button.primaryBtn"));
	    loginButton.click();
	    
	    Alert a = driver.switchTo().alert();
	    a.accept();
	    
	    driver.navigate().to("http://localhost:5174/all-added-products");
		
		//fetch all teh product names
		List<WebElement> allProducts = driver.findElements(By.cssSelector("div.mt-6>div>a>div.p-3>h3"));
		// print the size of total products 
		System.out.println("Total products found  : " + allProducts.size());
        // loop through each products and print the names of each product. 
		for(int i = 0; i< allProducts.size();  i++)
		{
			
			System.out.println();
		}
	}

}
