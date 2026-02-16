package scripts.singleproduct_page.integration_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerifications;

public class AS_O1_AddProductToCartfFromSingleProductPAge {

	public static void main(String[] args) throws InterruptedException 
	{
		// open the browswer 
		WebDriver driver = new ChromeDriver(); 
		// maximize the screen. 
		driver.manage().window().maximize();
		// waiting (pooling period to load the browswer)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// go the respective page
		driver.get("http://localhost:5173/single-product/681070ee7c1de11b82228fb9");
		// give time to load the page also correctly.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// get the product name on which we are adding to cart , that is the expected text in the cart page. 
		WebElement productName = driver.findElement(By.xpath("//h1[@class='text-[24px] sm:text-[28px] lg:text-[32px] font-extrabold tracking-tight text-slate-900']"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		String expectedProductText = productName.getText();
		System.out.println("Added Product : " + expectedProductText + " to cart.");
		
		// find the add to cart button 
		WebElement addToCartButton = driver.findElement(By.xpath("(//button[@class='btnOrange inline-flex items-center justify-center gap-2'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the add to cart button
		addToCartButton.click();
        Thread.sleep(1000);
		// navigate to cart page. 
        driver.navigate().to("http://localhost:5173/cart");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// verify the product added from single product page is present or not in cart page. 
        
        // the product name in  the cart page.
        WebElement productNameInCartPage = driver.findElement(By.xpath("//h2[@class='text-[14px] sm:text-[16px] font-extrabold text-slate-900 truncate']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualProductText = productNameInCartPage.getText();
		System.out.println("Actual Product added to cart is : " + actualProductText );
		
		boolean textMAtching = AllVerifications.verifyTextPresent(driver, expectedProductText, productNameInCartPage);
		
		if(textMAtching == true)
		{
			System.out.println("Test case passed product added successfully to cart.");
		}
		else
		{
			System.out.println("Test case failed product not added to cart.");
		}
		// close the broswer
		Thread.sleep(3000);
		driver.quit();
	}
}
