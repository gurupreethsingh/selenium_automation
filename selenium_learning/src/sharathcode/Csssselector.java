package sharathcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Csssselector {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("file:///C:/Users/shara/Desktop/cssselector.html");
		driver.manage().window().maximize();
//		  WebElement usernameDiv = driver.findElement(By.cssSelector("#username"));
//	        System.out.println("Text in the username div, is " + usernameDiv.getText());
//	        // this will fetch you the text of h2 field, as well as the p tag ( as many elements are there that many elements)
//	        Thread.sleep(1000);
//	        
//	        System.out.println(" 2. find the login button and click on it. (css selector using classname)"); 
//	        WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
//	        System.out.println(loginButton.getTagName());
//	        System.out.println(loginButton.getText());
//	        loginButton.click();
//	        Thread.sleep(1000);
//	        
//	        System.out.println("\n3. writing css selector, using the tag name and attributes, tagName[An='av'] syntax.\n");
//	       
////	        
//	        System.out.println("\n4.css selector using,  TagName, Class, and Attribute Selector - Find input with class 'form-control-lg' and name 'password' ");
//	        WebElement passwordInput = driver.findElement(By.cssSelector("input.form-control-lg[name='password']"));
//	        passwordInput.sendKeys("password123");
//	        Thread.sleep(1000);
////	        
//		 
//        System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
//        WebElement firstListItem = driver.findElement(By.cssSelector("li:first-child"));
//        System.out.println("First list item text: " + firstListItem.getText());
//        Thread.sleep(1000);
//		
        
        System.out.println("\n5. Tag and Pseudo-class Selector - Find last list item in the unordered list");
        WebElement lastListItem = driver.findElement(By.cssSelector("li:last-child"));
        System.out.println("last list item text: " + lastListItem.getText());
        Thread.sleep(1000);
		
		
	}

}
